package com.activeandroid.content;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.SparseArray;
import com.activeandroid.ActiveAndroid;
import com.activeandroid.Cache;
import com.activeandroid.Configuration;
import com.activeandroid.Configuration.Builder;
import com.activeandroid.Model;
import com.activeandroid.TableInfo;
import java.util.ArrayList;
import java.util.List;

public class ContentProvider
  extends android.content.ContentProvider
{
  private static final UriMatcher a = new UriMatcher(-1);
  private static final SparseArray<Class<? extends Model>> b = new SparseArray();
  private static String c;
  private static SparseArray<String> d = new SparseArray();
  
  public static Uri a(Class<? extends Model> paramClass, Long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("content://");
    localStringBuilder.append(c);
    localStringBuilder.append("/");
    localStringBuilder.append(Cache.c(paramClass).toLowerCase());
    if (paramLong != null)
    {
      localStringBuilder.append("/");
      localStringBuilder.append(paramLong.toString());
    }
    return Uri.parse(localStringBuilder.toString());
  }
  
  private Class<? extends Model> a(Uri paramUri)
  {
    int i = a.match(paramUri);
    if (i != -1) {
      return (Class)b.get(i);
    }
    return null;
  }
  
  private void b(Uri paramUri)
  {
    getContext().getContentResolver().notifyChange(paramUri, null);
  }
  
  protected String a()
  {
    return getContext().getPackageName();
  }
  
  protected Configuration b()
  {
    return new Configuration.Builder(getContext()).a();
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    Class localClass = a(paramUri);
    int i = Cache.b().delete(Cache.c(localClass), paramString, paramArrayOfString);
    b(paramUri);
    return i;
  }
  
  public String getType(Uri paramUri)
  {
    int i = a.match(paramUri);
    String str1 = (String)d.get(i);
    if (str1 != null) {
      return str1;
    }
    Class localClass = a(paramUri);
    int j;
    StringBuilder localStringBuilder;
    if (i % 2 == 0)
    {
      j = 1;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("vnd");
      localStringBuilder.append(".");
      localStringBuilder.append(c);
      localStringBuilder.append(".");
      if (j == 0) {
        break label176;
      }
    }
    label176:
    for (String str2 = "item";; str2 = "dir")
    {
      localStringBuilder.append(str2);
      localStringBuilder.append("/");
      localStringBuilder.append("vnd");
      localStringBuilder.append(".");
      localStringBuilder.append(c);
      localStringBuilder.append(".");
      localStringBuilder.append(Cache.c(localClass));
      d.append(i, localStringBuilder.toString());
      return localStringBuilder.toString();
      j = 0;
      break;
    }
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    Class localClass = a(paramUri);
    Long localLong = Long.valueOf(Cache.b().insert(Cache.c(localClass), null, paramContentValues));
    Uri localUri = null;
    if (localLong != null)
    {
      boolean bool = localLong.longValue() < 0L;
      localUri = null;
      if (bool)
      {
        localUri = a(localClass, localLong);
        b(localUri);
      }
    }
    return localUri;
  }
  
  public boolean onCreate()
  {
    ActiveAndroid.a(b());
    c = a();
    ArrayList localArrayList = new ArrayList(Cache.e());
    int i = localArrayList.size();
    for (int j = 0; j < i; j++)
    {
      TableInfo localTableInfo = (TableInfo)localArrayList.get(j);
      int k = 1 + j * 2;
      int m = 2 + j * 2;
      a.addURI(c, localTableInfo.b().toLowerCase(), k);
      b.put(k, localTableInfo.a());
      a.addURI(c, localTableInfo.b().toLowerCase() + "/#", m);
      b.put(m, localTableInfo.a());
    }
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    Class localClass = a(paramUri);
    Cursor localCursor = Cache.b().query(Cache.c(localClass), paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2);
    localCursor.setNotificationUri(getContext().getContentResolver(), paramUri);
    return localCursor;
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    Class localClass = a(paramUri);
    int i = Cache.b().update(Cache.c(localClass), paramContentValues, paramString, paramArrayOfString);
    b(paramUri);
    return i;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.activeandroid.content.ContentProvider
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */