package com.boohee.pictures;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BitmapUtils
{
  private static int calculateInSampleSize(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int i = paramOptions.outHeight;
    int j = paramOptions.outWidth;
    int k = 1;
    if ((i > paramInt2) || (j > paramInt1))
    {
      int m = i / 2;
      int n = j / 2;
      k = 2;
      while ((m / k > paramInt2) || (n / k > paramInt1)) {
        k *= 2;
      }
    }
    return k;
  }
  
  public static ByteArrayOutputStream compressBitmap(Context paramContext, Picture paramPicture, int paramInt)
  {
    if ((paramPicture == null) || (TextUtils.isEmpty(paramPicture.path))) {
      return null;
    }
    Uri localUri = Uri.fromFile(new File(paramPicture.path));
    BitmapFactory.Options localOptions = getBitmapOptions(paramContext, localUri);
    paramPicture.height = localOptions.outHeight;
    paramPicture.width = localOptions.outWidth;
    Bitmap localBitmap = getBitmapWithUri(paramContext, localUri);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    localBitmap.compress(Bitmap.CompressFormat.JPEG, paramInt, localByteArrayOutputStream);
    return localByteArrayOutputStream;
  }
  
  /* Error */
  public static BitmapFactory.Options getBitmapOptions(Context paramContext, Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 81	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   4: invokevirtual 87	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   7: astore_2
    //   8: aload_0
    //   9: invokevirtual 91	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   12: astore_3
    //   13: new 12	android/graphics/BitmapFactory$Options
    //   16: dup
    //   17: invokespecial 92	android/graphics/BitmapFactory$Options:<init>	()V
    //   20: astore 4
    //   22: aload 4
    //   24: iconst_1
    //   25: putfield 96	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   28: aload_3
    //   29: aload_1
    //   30: invokevirtual 102	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   33: aconst_null
    //   34: aload 4
    //   36: invokestatic 108	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   39: pop
    //   40: aload_0
    //   41: invokestatic 114	com/boohee/pictures/util/EnvHelper:getNetworkType	(Landroid/content/Context;)Lcom/boohee/pictures/util/EnvHelper$NetType;
    //   44: getstatic 120	com/boohee/pictures/util/EnvHelper$NetType:WIFI	Lcom/boohee/pictures/util/EnvHelper$NetType;
    //   47: invokevirtual 124	com/boohee/pictures/util/EnvHelper$NetType:equals	(Ljava/lang/Object;)Z
    //   50: istore 6
    //   52: iload 6
    //   54: ifeq +55 -> 109
    //   57: ldc2_w 125
    //   60: aload_2
    //   61: getfield 131	android/util/DisplayMetrics:widthPixels	I
    //   64: i2d
    //   65: dmul
    //   66: d2i
    //   67: istore 7
    //   69: iload 6
    //   71: ifeq +53 -> 124
    //   74: ldc2_w 125
    //   77: aload_2
    //   78: getfield 134	android/util/DisplayMetrics:heightPixels	I
    //   81: i2d
    //   82: dmul
    //   83: d2i
    //   84: istore 8
    //   86: aload 4
    //   88: aload 4
    //   90: iload 7
    //   92: iload 8
    //   94: invokestatic 136	com/boohee/pictures/BitmapUtils:calculateInSampleSize	(Landroid/graphics/BitmapFactory$Options;II)I
    //   97: putfield 139	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   100: aload 4
    //   102: iconst_0
    //   103: putfield 96	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   106: aload 4
    //   108: areturn
    //   109: ldc2_w 140
    //   112: aload_2
    //   113: getfield 131	android/util/DisplayMetrics:widthPixels	I
    //   116: i2d
    //   117: dmul
    //   118: d2i
    //   119: istore 7
    //   121: goto -52 -> 69
    //   124: ldc2_w 140
    //   127: aload_2
    //   128: getfield 134	android/util/DisplayMetrics:heightPixels	I
    //   131: i2d
    //   132: dmul
    //   133: d2i
    //   134: istore 8
    //   136: goto -50 -> 86
    //   139: astore 5
    //   141: goto -101 -> 40
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	paramContext	Context
    //   0	144	1	paramUri	Uri
    //   7	121	2	localDisplayMetrics	android.util.DisplayMetrics
    //   12	17	3	localContentResolver	ContentResolver
    //   20	87	4	localOptions	BitmapFactory.Options
    //   139	1	5	localFileNotFoundException	FileNotFoundException
    //   50	20	6	bool	boolean
    //   67	53	7	i	int
    //   84	51	8	j	int
    // Exception table:
    //   from	to	target	type
    //   28	40	139	java/io/FileNotFoundException
  }
  
  public static Bitmap getBitmapWithUri(Context paramContext, Uri paramUri)
  {
    return getBitmapWithUri(paramContext, paramUri, getBitmapOptions(paramContext, paramUri));
  }
  
  public static Bitmap getBitmapWithUri(Context paramContext, Uri paramUri, BitmapFactory.Options paramOptions)
  {
    Bitmap localBitmap1 = null;
    if ((paramUri == null) || (paramContext == null)) {
      return null;
    }
    ContentResolver localContentResolver = paramContext.getContentResolver();
    Matrix localMatrix = new Matrix();
    localMatrix.postRotate(readPictureDegree(paramContext, paramUri.getPath()));
    try
    {
      localBitmap1 = BitmapFactory.decodeStream(localContentResolver.openInputStream(paramUri), null, paramOptions);
      Bitmap localBitmap2 = Bitmap.createBitmap(localBitmap1, 0, 0, paramOptions.outWidth, paramOptions.outHeight, localMatrix, false);
      return localBitmap2;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      localFileNotFoundException.printStackTrace();
    }
    return localBitmap1;
  }
  
  public static int readPictureDegree(Context paramContext, String paramString)
  {
    try
    {
      ExifInterface localExifInterface = new ExifInterface(paramString);
      Log.d("EXIF value", localExifInterface.getAttribute("Orientation"));
      if (localExifInterface.getAttribute("Orientation").equalsIgnoreCase("6")) {
        return 90;
      }
      if (localExifInterface.getAttribute("Orientation").equalsIgnoreCase("8")) {
        return 270;
      }
      boolean bool = localExifInterface.getAttribute("Orientation").equalsIgnoreCase("3");
      if (bool) {
        return 180;
      }
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    return 0;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.pictures.BitmapUtils
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */