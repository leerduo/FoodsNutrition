package com.google.zxing.client.androidlegacy;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.ResultPointCallback;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

final class DecodeThread
  extends Thread
{
  private final CaptureActivity a;
  private final Map<DecodeHintType, Object> b;
  private Handler c;
  private final CountDownLatch d;
  
  DecodeThread(CaptureActivity paramCaptureActivity, Collection<BarcodeFormat> paramCollection, Map<DecodeHintType, ?> paramMap, String paramString, ResultPointCallback paramResultPointCallback)
  {
    this.a = paramCaptureActivity;
    this.d = new CountDownLatch(1);
    this.b = new EnumMap(DecodeHintType.class);
    if (paramMap != null) {
      this.b.putAll(paramMap);
    }
    this.b.put(DecodeHintType.c, paramCollection);
    if (paramString != null) {
      this.b.put(DecodeHintType.e, paramString);
    }
    this.b.put(DecodeHintType.j, paramResultPointCallback);
    Log.i("DecodeThread", "Hints: " + this.b);
  }
  
  Handler a()
  {
    try
    {
      this.d.await();
      label7:
      return this.c;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label7;
    }
  }
  
  public void run()
  {
    Looper.prepare();
    this.c = new DecodeHandler(this.a, this.b);
    this.d.countDown();
    Looper.loop();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.androidlegacy.DecodeThread
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */