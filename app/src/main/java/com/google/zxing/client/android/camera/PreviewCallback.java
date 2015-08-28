package com.google.zxing.client.android.camera;

import android.graphics.Point;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

final class PreviewCallback
  implements Camera.PreviewCallback
{
  private static final String a = PreviewCallback.class.getSimpleName();
  private final CameraConfigurationManager b;
  private Handler c;
  private int d;
  
  PreviewCallback(CameraConfigurationManager paramCameraConfigurationManager)
  {
    this.b = paramCameraConfigurationManager;
  }
  
  void a(Handler paramHandler, int paramInt)
  {
    this.c = paramHandler;
    this.d = paramInt;
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    Point localPoint = this.b.a();
    Handler localHandler = this.c;
    if ((localPoint != null) && (localHandler != null))
    {
      localHandler.obtainMessage(this.d, localPoint.x, localPoint.y, paramArrayOfByte).sendToTarget();
      this.c = null;
      return;
    }
    Log.d(a, "Got preview callback, but no handler or resolution available");
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.android.camera.PreviewCallback
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */