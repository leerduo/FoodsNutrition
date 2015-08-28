package com.google.zxing.client.androidlegacy.camera.open;

import com.google.zxing.client.androidlegacy.common.PlatformSupportManager;

public final class OpenCameraManager
  extends PlatformSupportManager<OpenCameraInterface>
{
  public OpenCameraManager()
  {
    super(OpenCameraInterface.class, new DefaultOpenCameraInterface());
    a(9, "com.google.zxing.client.android.camera.open.GingerbreadOpenCameraInterface");
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.androidlegacy.camera.open.OpenCameraManager
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */