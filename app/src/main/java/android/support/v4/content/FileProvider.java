package android.support.v4.content;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParserException;

public class FileProvider
  extends ContentProvider
{
  private static final String ATTR_NAME = "name";
  private static final String ATTR_PATH = "path";
  private static final String[] COLUMNS = { "_display_name", "_size" };
  private static final File DEVICE_ROOT = new File("/");
  private static final String META_DATA_FILE_PROVIDER_PATHS = "android.support.FILE_PROVIDER_PATHS";
  private static final String TAG_CACHE_PATH = "cache-path";
  private static final String TAG_EXTERNAL = "external-path";
  private static final String TAG_FILES_PATH = "files-path";
  private static final String TAG_ROOT_PATH = "root-path";
  private static HashMap<String, FileProvider.PathStrategy> sCache = new HashMap();
  private FileProvider.PathStrategy mStrategy;
  
  private static File buildPath(File paramFile, String... paramVarArgs)
  {
    int i = paramVarArgs.length;
    int j = 0;
    Object localObject1 = paramFile;
    String str;
    if (j < i)
    {
      str = paramVarArgs[j];
      if (str == null) {
        break label49;
      }
    }
    label49:
    for (Object localObject2 = new File((File)localObject1, str);; localObject2 = localObject1)
    {
      j++;
      localObject1 = localObject2;
      break;
      return localObject1;
    }
  }
  
  private static Object[] copyOf(Object[] paramArrayOfObject, int paramInt)
  {
    Object[] arrayOfObject = new Object[paramInt];
    System.arraycopy(paramArrayOfObject, 0, arrayOfObject, 0, paramInt);
    return arrayOfObject;
  }
  
  private static String[] copyOf(String[] paramArrayOfString, int paramInt)
  {
    String[] arrayOfString = new String[paramInt];
    System.arraycopy(paramArrayOfString, 0, arrayOfString, 0, paramInt);
    return arrayOfString;
  }
  
  private static FileProvider.PathStrategy getPathStrategy(Context paramContext, String paramString)
  {
    Object localObject2;
    synchronized (sCache)
    {
      localObject2 = (FileProvider.PathStrategy)sCache.get(paramString);
      if (localObject2 != null) {}
    }
    try
    {
      FileProvider.PathStrategy localPathStrategy = parsePathStrategy(paramContext, paramString);
      localObject2 = localPathStrategy;
      sCache.put(paramString, localObject2);
      return localObject2;
    }
    catch (IOException localIOException)
    {
      throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", localIOException);
      localObject1 = finally;
      throw localObject1;
    }
    catch (XmlPullParserException localXmlPullParserException)
    {
      throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", localXmlPullParserException);
    }
  }
  
  public static Uri getUriForFile(Context paramContext, String paramString, File paramFile)
  {
    return getPathStrategy(paramContext, paramString).getUriForFile(paramFile);
  }
  
  private static int modeToMode(String paramString)
  {
    if ("r".equals(paramString)) {
      return 268435456;
    }
    if (("w".equals(paramString)) || ("wt".equals(paramString))) {
      return 738197504;
    }
    if ("wa".equals(paramString)) {
      return 704643072;
    }
    if ("rw".equals(paramString)) {
      return 939524096;
    }
    if ("rwt".equals(paramString)) {
      return 1006632960;
    }
    throw new IllegalArgumentException("Invalid mode: " + paramString);
  }
  
  private static FileProvider.PathStrategy parsePathStrategy(Context paramContext, String paramString)
  {
    FileProvider.SimplePathStrategy localSimplePathStrategy = new FileProvider.SimplePathStrategy(paramString);
    XmlResourceParser localXmlResourceParser = paramContext.getPackageManager().resolveContentProvider(paramString, 128).loadXmlMetaData(paramContext.getPackageManager(), "android.support.FILE_PROVIDER_PATHS");
    if (localXmlResourceParser == null) {
      throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
    }
    label235:
    for (;;)
    {
      int i = localXmlResourceParser.next();
      String str1;
      String str2;
      String str3;
      File localFile;
      if (i != 1)
      {
        if (i == 2)
        {
          str1 = localXmlResourceParser.getName();
          str2 = localXmlResourceParser.getAttributeValue(null, "name");
          str3 = localXmlResourceParser.getAttributeValue(null, "path");
          if ("root-path".equals(str1)) {
            localFile = buildPath(DEVICE_ROOT, new String[] { str3 });
          }
        }
      }
      else {
        for (;;)
        {
          if (localFile == null) {
            break label235;
          }
          localSimplePathStrategy.addRoot(str2, localFile);
          break;
          if ("files-path".equals(str1))
          {
            localFile = buildPath(paramContext.getFilesDir(), new String[] { str3 });
          }
          else if ("cache-path".equals(str1))
          {
            localFile = buildPath(paramContext.getCacheDir(), new String[] { str3 });
          }
          else if ("external-path".equals(str1))
          {
            localFile = buildPath(Environment.getExternalStorageDirectory(), new String[] { str3 });
            continue;
            return localSimplePathStrategy;
          }
          else
          {
            localFile = null;
          }
        }
      }
    }
  }
  
  public void attachInfo(Context paramContext, ProviderInfo paramProviderInfo)
  {
    super.attachInfo(paramContext, paramProviderInfo);
    if (paramProviderInfo.exported) {
      throw new SecurityException("Provider must not be exported");
    }
    if (!paramProviderInfo.grantUriPermissions) {
      throw new SecurityException("Provider must grant uri permissions");
    }
    this.mStrategy = getPathStrategy(paramContext, paramProviderInfo.authority);
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    if (this.mStrategy.getFileForUri(paramUri).delete()) {
      return 1;
    }
    return 0;
  }
  
  public String getType(Uri paramUri)
  {
    File localFile = this.mStrategy.getFileForUri(paramUri);
    int i = localFile.getName().lastIndexOf('.');
    if (i >= 0)
    {
      String str1 = localFile.getName().substring(i + 1);
      String str2 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str1);
      if (str2 != null) {
        return str2;
      }
    }
    return "application/octet-stream";
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    throw new UnsupportedOperationException("No external inserts");
  }
  
  public boolean onCreate()
  {
    return true;
  }
  
  public ParcelFileDescriptor openFile(Uri paramUri, String paramString)
  {
    return ParcelFileDescriptor.open(this.mStrategy.getFileForUri(paramUri), modeToMode(paramString));
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    File localFile = this.mStrategy.getFileForUri(paramUri);
    if (paramArrayOfString1 == null) {
      paramArrayOfString1 = COLUMNS;
    }
    String[] arrayOfString1 = new String[paramArrayOfString1.length];
    Object[] arrayOfObject1 = new Object[paramArrayOfString1.length];
    int i = paramArrayOfString1.length;
    int j = 0;
    int k = 0;
    String str;
    int m;
    if (j < i)
    {
      str = paramArrayOfString1[j];
      if ("_display_name".equals(str))
      {
        arrayOfString1[k] = "_display_name";
        m = k + 1;
        arrayOfObject1[k] = localFile.getName();
      }
    }
    for (;;)
    {
      j++;
      k = m;
      break;
      if ("_size".equals(str))
      {
        arrayOfString1[k] = "_size";
        m = k + 1;
        arrayOfObject1[k] = Long.valueOf(localFile.length());
        continue;
        String[] arrayOfString2 = copyOf(arrayOfString1, k);
        Object[] arrayOfObject2 = copyOf(arrayOfObject1, k);
        MatrixCursor localMatrixCursor = new MatrixCursor(arrayOfString2, 1);
        localMatrixCursor.addRow(arrayOfObject2);
        return localMatrixCursor;
      }
      else
      {
        m = k;
      }
    }
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    throw new UnsupportedOperationException("No external updates");
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.content.FileProvider
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */