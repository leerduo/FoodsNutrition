package cn.sharesdk.framework.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.view.View;
import cn.sharesdk.framework.network.i;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.Array;

public class BitmapHelper
{
  private static Bitmap a(Bitmap paramBitmap, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (Bitmap localBitmap = paramBitmap; paramInt < 1; localBitmap = paramBitmap.copy(paramBitmap.getConfig(), true)) {
      return null;
    }
    int i = localBitmap.getWidth();
    int j = localBitmap.getHeight();
    int[] arrayOfInt1 = new int[i * j];
    localBitmap.getPixels(arrayOfInt1, 0, i, 0, 0, i, j);
    int k = i - 1;
    int m = j - 1;
    int n = i * j;
    int i1 = 1 + (paramInt + paramInt);
    int[] arrayOfInt2 = new int[n];
    int[] arrayOfInt3 = new int[n];
    int[] arrayOfInt4 = new int[n];
    int[] arrayOfInt5 = new int[Math.max(i, j)];
    int i2 = i1 + 1 >> 1;
    int i3 = i2 * i2;
    int[] arrayOfInt6 = new int[i3 * 256];
    for (int i4 = 0; i4 < i3 * 256; i4++) {
      arrayOfInt6[i4] = (i4 / i3);
    }
    int[] arrayOfInt7 = { i1, 3 };
    int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, arrayOfInt7);
    int i5 = paramInt + 1;
    int i6 = 0;
    int i7 = 0;
    int i67;
    for (int i8 = 0; i8 < j; i8 = i67)
    {
      int i49 = 0;
      int i50 = -paramInt;
      int i51 = 0;
      int i52 = 0;
      int i53 = 0;
      int i54 = 0;
      int i55 = i50;
      int i56 = 0;
      int i57 = 0;
      int i58 = 0;
      int i59 = 0;
      if (i55 <= paramInt)
      {
        int i78 = arrayOfInt1[(i7 + Math.min(k, Math.max(i55, 0)))];
        int[] arrayOfInt13 = arrayOfInt[(i55 + paramInt)];
        arrayOfInt13[0] = ((0xFF0000 & i78) >> 16);
        arrayOfInt13[1] = ((0xFF00 & i78) >> 8);
        arrayOfInt13[2] = (i78 & 0xFF);
        int i79 = i5 - Math.abs(i55);
        i58 += i79 * arrayOfInt13[0];
        i57 += i79 * arrayOfInt13[1];
        i56 += i79 * arrayOfInt13[2];
        if (i55 > 0)
        {
          i51 += arrayOfInt13[0];
          i59 += arrayOfInt13[1];
          i49 += arrayOfInt13[2];
        }
        for (;;)
        {
          i55++;
          break;
          i54 += arrayOfInt13[0];
          i53 += arrayOfInt13[1];
          i52 += arrayOfInt13[2];
        }
      }
      int i60 = i58;
      int i61 = i57;
      int i62 = i56;
      int i63 = 0;
      int i64 = i7;
      int i65 = paramInt;
      while (i63 < i)
      {
        arrayOfInt2[i64] = arrayOfInt6[i60];
        arrayOfInt3[i64] = arrayOfInt6[i61];
        arrayOfInt4[i64] = arrayOfInt6[i62];
        int i68 = i60 - i54;
        int i69 = i61 - i53;
        int i70 = i62 - i52;
        int[] arrayOfInt11 = arrayOfInt[((i1 + (i65 - paramInt)) % i1)];
        int i71 = i54 - arrayOfInt11[0];
        int i72 = i53 - arrayOfInt11[1];
        int i73 = i52 - arrayOfInt11[2];
        if (i8 == 0) {
          arrayOfInt5[i63] = Math.min(1 + (i63 + paramInt), k);
        }
        int i74 = arrayOfInt1[(i6 + arrayOfInt5[i63])];
        arrayOfInt11[0] = ((0xFF0000 & i74) >> 16);
        arrayOfInt11[1] = ((0xFF00 & i74) >> 8);
        arrayOfInt11[2] = (i74 & 0xFF);
        int i75 = i51 + arrayOfInt11[0];
        int i76 = i59 + arrayOfInt11[1];
        int i77 = i49 + arrayOfInt11[2];
        i60 = i68 + i75;
        i61 = i69 + i76;
        i62 = i70 + i77;
        i65 = (i65 + 1) % i1;
        int[] arrayOfInt12 = arrayOfInt[(i65 % i1)];
        i54 = i71 + arrayOfInt12[0];
        i53 = i72 + arrayOfInt12[1];
        i52 = i73 + arrayOfInt12[2];
        i51 = i75 - arrayOfInt12[0];
        i59 = i76 - arrayOfInt12[1];
        i49 = i77 - arrayOfInt12[2];
        i64++;
        i63++;
      }
      int i66 = i6 + i;
      i67 = i8 + 1;
      i6 = i66;
      i7 = i64;
    }
    for (int i9 = 0; i9 < i; i9++)
    {
      int i10 = 0;
      int i11 = i * -paramInt;
      int i12 = -paramInt;
      int i13 = 0;
      int i14 = 0;
      int i15 = 0;
      int i16 = 0;
      int i17 = i12;
      int i18 = 0;
      int i19 = 0;
      int i20 = 0;
      int i21 = 0;
      if (i17 <= paramInt)
      {
        int i44 = i9 + Math.max(0, i11);
        int[] arrayOfInt10 = arrayOfInt[(i17 + paramInt)];
        arrayOfInt10[0] = arrayOfInt2[i44];
        arrayOfInt10[1] = arrayOfInt3[i44];
        arrayOfInt10[2] = arrayOfInt4[i44];
        int i45 = i5 - Math.abs(i17);
        int i46 = i20 + i45 * arrayOfInt2[i44];
        int i47 = i19 + i45 * arrayOfInt3[i44];
        int i48 = i18 + i45 * arrayOfInt4[i44];
        if (i17 > 0)
        {
          i13 += arrayOfInt10[0];
          i21 += arrayOfInt10[1];
          i10 += arrayOfInt10[2];
        }
        for (;;)
        {
          if (i17 < m) {
            i11 += i;
          }
          i17++;
          i18 = i48;
          i19 = i47;
          i20 = i46;
          break;
          i16 += arrayOfInt10[0];
          i15 += arrayOfInt10[1];
          i14 += arrayOfInt10[2];
        }
      }
      int i22 = i19;
      int i23 = i20;
      int i24 = 0;
      int i25 = i18;
      int i26 = i9;
      int i27 = i10;
      int i28 = i21;
      int i29 = i13;
      int i30 = i14;
      int i31 = i15;
      int i32 = i16;
      int i33 = paramInt;
      while (i24 < j)
      {
        arrayOfInt1[i26] = (0xFF000000 & arrayOfInt1[i26] | arrayOfInt6[i23] << 16 | arrayOfInt6[i22] << 8 | arrayOfInt6[i25]);
        int i34 = i23 - i32;
        int i35 = i22 - i31;
        int i36 = i25 - i30;
        int[] arrayOfInt8 = arrayOfInt[((i1 + (i33 - paramInt)) % i1)];
        int i37 = i32 - arrayOfInt8[0];
        int i38 = i31 - arrayOfInt8[1];
        int i39 = i30 - arrayOfInt8[2];
        if (i9 == 0) {
          arrayOfInt5[i24] = (i * Math.min(i24 + i5, m));
        }
        int i40 = i9 + arrayOfInt5[i24];
        arrayOfInt8[0] = arrayOfInt2[i40];
        arrayOfInt8[1] = arrayOfInt3[i40];
        arrayOfInt8[2] = arrayOfInt4[i40];
        int i41 = i29 + arrayOfInt8[0];
        int i42 = i28 + arrayOfInt8[1];
        int i43 = i27 + arrayOfInt8[2];
        i23 = i34 + i41;
        i22 = i35 + i42;
        i25 = i36 + i43;
        i33 = (i33 + 1) % i1;
        int[] arrayOfInt9 = arrayOfInt[i33];
        i32 = i37 + arrayOfInt9[0];
        i31 = i38 + arrayOfInt9[1];
        i30 = i39 + arrayOfInt9[2];
        i29 = i41 - arrayOfInt9[0];
        i28 = i42 - arrayOfInt9[1];
        i27 = i43 - arrayOfInt9[2];
        i26 += i;
        i24++;
      }
    }
    localBitmap.setPixels(arrayOfInt1, 0, i, 0, 0, i, j);
    return localBitmap;
  }
  
  private static String a(String paramString)
  {
    try
    {
      FileInputStream localFileInputStream = new FileInputStream(paramString);
      byte[] arrayOfByte = new byte[8];
      localFileInputStream.read(arrayOfByte);
      localFileInputStream.close();
      String str = a(arrayOfByte);
      return str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte1 = "BM".getBytes();
    byte[] arrayOfByte2 = "GIF".getBytes();
    byte[] arrayOfByte3 = { -119, 80, 78, 71 };
    byte[] arrayOfByte4 = { 73, 73, 42 };
    byte[] arrayOfByte5 = { 77, 77, 42 };
    byte[] arrayOfByte6 = { -1, -40, -1, -32 };
    byte[] arrayOfByte7 = { -1, -40, -1, -31 };
    if ((a(paramArrayOfByte, arrayOfByte6)) || (a(paramArrayOfByte, arrayOfByte7))) {
      return "jpg";
    }
    if (a(paramArrayOfByte, arrayOfByte3)) {
      return "png";
    }
    if (a(paramArrayOfByte, arrayOfByte2)) {
      return "gif";
    }
    if (a(paramArrayOfByte, arrayOfByte1)) {
      return "bmp";
    }
    if ((a(paramArrayOfByte, arrayOfByte4)) || (a(paramArrayOfByte, arrayOfByte5))) {
      return "tif";
    }
    return null;
  }
  
  private static boolean a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    boolean bool;
    if (paramArrayOfByte1 == paramArrayOfByte2) {
      bool = true;
    }
    do
    {
      do
      {
        return bool;
        bool = false;
      } while (paramArrayOfByte1 == null);
      bool = false;
    } while (paramArrayOfByte2 == null);
    for (int i = 0;; i++)
    {
      if (i >= paramArrayOfByte2.length) {
        break label54;
      }
      int j = paramArrayOfByte1[i];
      int k = paramArrayOfByte2[i];
      bool = false;
      if (j != k) {
        break;
      }
    }
    label54:
    return true;
  }
  
  public static Bitmap blur(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    int k = (int)(0.5F + paramInt1 / paramInt2);
    Bitmap localBitmap = Bitmap.createBitmap((int)(0.5F + i / paramInt2), (int)(0.5F + j / paramInt2), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.scale(1.0F / paramInt2, 1.0F / paramInt2);
    Paint localPaint = new Paint();
    localPaint.setFlags(2);
    localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, localPaint);
    a(localBitmap, k, true);
    return localBitmap;
  }
  
  public static Bitmap captureView(View paramView, int paramInt1, int paramInt2)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    paramView.draw(new Canvas(localBitmap));
    return localBitmap;
  }
  
  public static Bitmap cropBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = paramBitmap.getWidth() - paramInt1 - paramInt3;
    int j = paramBitmap.getHeight() - paramInt2 - paramInt4;
    if ((i == paramBitmap.getWidth()) && (j == paramBitmap.getHeight())) {
      return paramBitmap;
    }
    Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    localCanvas.drawBitmap(paramBitmap, -paramInt1, -paramInt2, localPaint);
    return localBitmap;
  }
  
  public static String downloadBitmap(Context paramContext, String paramString)
  {
    return new i().a(paramContext, paramString, "images", true);
  }
  
  public static int[] fixRect(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int[] arrayOfInt = new int[2];
    if (paramArrayOfInt1[0] / paramArrayOfInt1[1] > paramArrayOfInt2[0] / paramArrayOfInt2[1])
    {
      arrayOfInt[0] = paramArrayOfInt2[0];
      arrayOfInt[1] = ((int)(0.5F + paramArrayOfInt1[1] * paramArrayOfInt2[0] / paramArrayOfInt1[0]));
      return arrayOfInt;
    }
    arrayOfInt[1] = paramArrayOfInt2[1];
    arrayOfInt[0] = ((int)(0.5F + paramArrayOfInt1[0] * paramArrayOfInt2[1] / paramArrayOfInt1[1]));
    return arrayOfInt;
  }
  
  public static int[] fixRect_2(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int[] arrayOfInt = new int[2];
    if (paramArrayOfInt1[0] / paramArrayOfInt1[1] > paramArrayOfInt2[0] / paramArrayOfInt2[1])
    {
      arrayOfInt[1] = paramArrayOfInt2[1];
      arrayOfInt[0] = ((int)(0.5F + paramArrayOfInt1[0] * paramArrayOfInt2[1] / paramArrayOfInt1[1]));
      return arrayOfInt;
    }
    arrayOfInt[0] = paramArrayOfInt2[0];
    arrayOfInt[1] = ((int)(0.5F + paramArrayOfInt1[1] * paramArrayOfInt2[0] / paramArrayOfInt1[0]));
    return arrayOfInt;
  }
  
  public static Bitmap getBitmap(Context paramContext, String paramString)
  {
    return getBitmap(downloadBitmap(paramContext, paramString));
  }
  
  public static Bitmap getBitmap(File paramFile, int paramInt)
  {
    FileInputStream localFileInputStream = new FileInputStream(paramFile);
    Bitmap localBitmap = getBitmap(localFileInputStream, paramInt);
    localFileInputStream.close();
    return localBitmap;
  }
  
  public static Bitmap getBitmap(InputStream paramInputStream, int paramInt)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
    localOptions.inPurgeable = true;
    localOptions.inInputShareable = true;
    localOptions.inSampleSize = paramInt;
    return BitmapFactory.decodeStream(paramInputStream, null, localOptions);
  }
  
  public static Bitmap getBitmap(String paramString)
  {
    return getBitmap(paramString, 1);
  }
  
  public static Bitmap getBitmap(String paramString, int paramInt)
  {
    return getBitmap(new File(paramString), paramInt);
  }
  
  public static Bitmap.CompressFormat getBmpFormat(String paramString)
  {
    String str1 = paramString.toLowerCase();
    if ((str1.endsWith("png")) || (str1.endsWith("gif"))) {
      return Bitmap.CompressFormat.PNG;
    }
    if ((str1.endsWith("jpg")) || (str1.endsWith("jpeg")) || (str1.endsWith("bmp")) || (str1.endsWith("tif"))) {
      return Bitmap.CompressFormat.JPEG;
    }
    String str2 = a(paramString);
    if ((str2.endsWith("png")) || (str2.endsWith("gif"))) {
      return Bitmap.CompressFormat.PNG;
    }
    return Bitmap.CompressFormat.JPEG;
  }
  
  public static Bitmap.CompressFormat getBmpFormat(byte[] paramArrayOfByte)
  {
    String str = a(paramArrayOfByte);
    Bitmap.CompressFormat localCompressFormat = Bitmap.CompressFormat.JPEG;
    if ((str != null) && ((str.endsWith("png")) || (str.endsWith("gif")))) {
      localCompressFormat = Bitmap.CompressFormat.PNG;
    }
    return localCompressFormat;
  }
  
  public static Bitmap roundBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    Rect localRect1 = new Rect(0, 0, i, j);
    if ((i != paramInt1) || (j != paramInt2)) {}
    for (Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);; localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888))
    {
      Canvas localCanvas = new Canvas(localBitmap);
      Paint localPaint = new Paint();
      Rect localRect2 = new Rect(0, 0, paramInt1, paramInt2);
      localPaint.setAntiAlias(true);
      localCanvas.drawARGB(0, 0, 0, 0);
      localPaint.setColor(-12434878);
      float[] arrayOfFloat = { paramFloat1, paramFloat1, paramFloat2, paramFloat2, paramFloat3, paramFloat3, paramFloat4, paramFloat4 };
      ShapeDrawable localShapeDrawable = new ShapeDrawable(new RoundRectShape(arrayOfFloat, new RectF(0.0F, 0.0F, 0.0F, 0.0F), arrayOfFloat));
      localShapeDrawable.setBounds(localRect2);
      localShapeDrawable.draw(localCanvas);
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      localCanvas.drawBitmap(paramBitmap, localRect1, localRect2, localPaint);
      return localBitmap;
    }
  }
  
  public static String saveBitmap(Context paramContext, Bitmap paramBitmap)
  {
    return saveBitmap(paramContext, paramBitmap, Bitmap.CompressFormat.JPEG, 80);
  }
  
  public static String saveBitmap(Context paramContext, Bitmap paramBitmap, Bitmap.CompressFormat paramCompressFormat, int paramInt)
  {
    String str1 = R.getCachePath(paramContext, "images");
    String str2 = ".jpg";
    if (paramCompressFormat == Bitmap.CompressFormat.PNG) {
      str2 = ".png";
    }
    File localFile = new File(str1, String.valueOf(System.currentTimeMillis()) + str2);
    FileOutputStream localFileOutputStream = new FileOutputStream(localFile);
    paramBitmap.compress(paramCompressFormat, paramInt, localFileOutputStream);
    localFileOutputStream.flush();
    localFileOutputStream.close();
    return localFile.getAbsolutePath();
  }
  
  public static String saveViewToImage(View paramView)
  {
    return saveViewToImage(paramView, paramView.getWidth(), paramView.getHeight());
  }
  
  public static String saveViewToImage(View paramView, int paramInt1, int paramInt2)
  {
    Bitmap localBitmap = captureView(paramView, paramInt1, paramInt2);
    File localFile = new File(R.getCachePath(paramView.getContext(), "screenshot"), String.valueOf(System.currentTimeMillis()) + ".jpg");
    FileOutputStream localFileOutputStream = new FileOutputStream(localFile);
    localBitmap.compress(Bitmap.CompressFormat.JPEG, 100, localFileOutputStream);
    localFileOutputStream.flush();
    localFileOutputStream.close();
    return localFile.getAbsolutePath();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.framework.utils.BitmapHelper
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */