package com.google.zxing.client.androidlegacy;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.zxing.DecodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.PlanarYUVLuminanceSource;
import java.io.ByteArrayOutputStream;
import java.util.Map;

final class DecodeHandler
  extends Handler
{
  private static final String a = DecodeHandler.class.getSimpleName();
  private final CaptureActivity b;
  private final MultiFormatReader c = new MultiFormatReader();
  private boolean d = true;
  
  DecodeHandler(CaptureActivity paramCaptureActivity, Map<DecodeHintType, Object> paramMap)
  {
    this.c.a(paramMap);
    this.b = paramCaptureActivity;
  }
  
  private static void a(PlanarYUVLuminanceSource paramPlanarYUVLuminanceSource, Bundle paramBundle)
  {
    int[] arrayOfInt = paramPlanarYUVLuminanceSource.f();
    int i = paramPlanarYUVLuminanceSource.g();
    Bitmap localBitmap = Bitmap.createBitmap(arrayOfInt, 0, i, i, paramPlanarYUVLuminanceSource.h(), Bitmap.Config.ARGB_8888);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    localBitmap.compress(Bitmap.CompressFormat.JPEG, 50, localByteArrayOutputStream);
    paramBundle.putByteArray("barcode_bitmap", localByteArrayOutputStream.toByteArray());
    paramBundle.putFloat("barcode_scaled_factor", i / paramPlanarYUVLuminanceSource.b());
  }
  
  /* Error */
  private void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: invokestatic 106	java/lang/System:currentTimeMillis	()J
    //   3: lstore 4
    //   5: aload_0
    //   6: getfield 38	com/google/zxing/client/androidlegacy/DecodeHandler:b	Lcom/google/zxing/client/androidlegacy/CaptureActivity;
    //   9: invokevirtual 111	com/google/zxing/client/androidlegacy/CaptureActivity:c	()Lcom/google/zxing/client/androidlegacy/camera/CameraManager;
    //   12: aload_1
    //   13: iload_2
    //   14: iload_3
    //   15: invokevirtual 116	com/google/zxing/client/androidlegacy/camera/CameraManager:a	([BII)Lcom/google/zxing/PlanarYUVLuminanceSource;
    //   18: astore 6
    //   20: aconst_null
    //   21: astore 7
    //   23: aload 6
    //   25: ifnull +43 -> 68
    //   28: new 118	com/google/zxing/BinaryBitmap
    //   31: dup
    //   32: new 120	com/google/zxing/common/HybridBinarizer
    //   35: dup
    //   36: aload 6
    //   38: invokespecial 123	com/google/zxing/common/HybridBinarizer:<init>	(Lcom/google/zxing/LuminanceSource;)V
    //   41: invokespecial 126	com/google/zxing/BinaryBitmap:<init>	(Lcom/google/zxing/Binarizer;)V
    //   44: astore 8
    //   46: aload_0
    //   47: getfield 33	com/google/zxing/client/androidlegacy/DecodeHandler:c	Lcom/google/zxing/MultiFormatReader;
    //   50: aload 8
    //   52: invokevirtual 129	com/google/zxing/MultiFormatReader:a	(Lcom/google/zxing/BinaryBitmap;)Lcom/google/zxing/Result;
    //   55: astore 17
    //   57: aload 17
    //   59: astore 7
    //   61: aload_0
    //   62: getfield 33	com/google/zxing/client/androidlegacy/DecodeHandler:c	Lcom/google/zxing/MultiFormatReader;
    //   65: invokevirtual 131	com/google/zxing/MultiFormatReader:a	()V
    //   68: aload_0
    //   69: getfield 38	com/google/zxing/client/androidlegacy/DecodeHandler:b	Lcom/google/zxing/client/androidlegacy/CaptureActivity;
    //   72: invokevirtual 134	com/google/zxing/client/androidlegacy/CaptureActivity:b	()Landroid/os/Handler;
    //   75: astore 11
    //   77: aload 7
    //   79: ifnull +116 -> 195
    //   82: invokestatic 106	java/lang/System:currentTimeMillis	()J
    //   85: lstore 12
    //   87: getstatic 22	com/google/zxing/client/androidlegacy/DecodeHandler:a	Ljava/lang/String;
    //   90: new 136	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   97: ldc 139
    //   99: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: lload 12
    //   104: lload 4
    //   106: lsub
    //   107: invokevirtual 146	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   110: ldc 148
    //   112: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokestatic 156	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   121: pop
    //   122: aload 11
    //   124: ifnull +43 -> 167
    //   127: aload 11
    //   129: getstatic 162	com/google/zxing/client/androidlegacy/R$id:zxinglegacy_decode_succeeded	I
    //   132: aload 7
    //   134: invokestatic 168	android/os/Message:obtain	(Landroid/os/Handler;ILjava/lang/Object;)Landroid/os/Message;
    //   137: astore 15
    //   139: new 85	android/os/Bundle
    //   142: dup
    //   143: invokespecial 169	android/os/Bundle:<init>	()V
    //   146: astore 16
    //   148: aload 6
    //   150: aload 16
    //   152: invokestatic 171	com/google/zxing/client/androidlegacy/DecodeHandler:a	(Lcom/google/zxing/PlanarYUVLuminanceSource;Landroid/os/Bundle;)V
    //   155: aload 15
    //   157: aload 16
    //   159: invokevirtual 175	android/os/Message:setData	(Landroid/os/Bundle;)V
    //   162: aload 15
    //   164: invokevirtual 178	android/os/Message:sendToTarget	()V
    //   167: return
    //   168: astore 10
    //   170: aload_0
    //   171: getfield 33	com/google/zxing/client/androidlegacy/DecodeHandler:c	Lcom/google/zxing/MultiFormatReader;
    //   174: invokevirtual 131	com/google/zxing/MultiFormatReader:a	()V
    //   177: aconst_null
    //   178: astore 7
    //   180: goto -112 -> 68
    //   183: astore 9
    //   185: aload_0
    //   186: getfield 33	com/google/zxing/client/androidlegacy/DecodeHandler:c	Lcom/google/zxing/MultiFormatReader;
    //   189: invokevirtual 131	com/google/zxing/MultiFormatReader:a	()V
    //   192: aload 9
    //   194: athrow
    //   195: aload 11
    //   197: ifnull -30 -> 167
    //   200: aload 11
    //   202: getstatic 181	com/google/zxing/client/androidlegacy/R$id:zxinglegacy_decode_failed	I
    //   205: invokestatic 184	android/os/Message:obtain	(Landroid/os/Handler;I)Landroid/os/Message;
    //   208: invokevirtual 178	android/os/Message:sendToTarget	()V
    //   211: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	212	0	this	DecodeHandler
    //   0	212	1	paramArrayOfByte	byte[]
    //   0	212	2	paramInt1	int
    //   0	212	3	paramInt2	int
    //   3	102	4	l1	long
    //   18	131	6	localPlanarYUVLuminanceSource	PlanarYUVLuminanceSource
    //   21	158	7	localObject1	Object
    //   44	7	8	localBinaryBitmap	com.google.zxing.BinaryBitmap
    //   183	10	9	localObject2	Object
    //   168	1	10	localException	java.lang.Exception
    //   75	126	11	localHandler	Handler
    //   85	18	12	l2	long
    //   137	26	15	localMessage	Message
    //   146	12	16	localBundle	Bundle
    //   55	3	17	localResult	com.google.zxing.Result
    // Exception table:
    //   from	to	target	type
    //   46	57	168	java/lang/Exception
    //   46	57	183	finally
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (!this.d) {}
    do
    {
      return;
      if (paramMessage.what == R.id.zxinglegacy_decode)
      {
        a((byte[])paramMessage.obj, paramMessage.arg1, paramMessage.arg2);
        return;
      }
    } while (paramMessage.what != R.id.zxinglegacy_quit);
    this.d = false;
    Looper.myLooper().quit();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.androidlegacy.DecodeHandler
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */