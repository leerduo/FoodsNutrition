package com.google.zxing.client.androidlegacy.camera.open;

import android.hardware.Camera;

final class DefaultOpenCameraInterface
  implements OpenCameraInterface
{
  public Camera a()
  {
    return Camera.open();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.androidlegacy.camera.open.DefaultOpenCameraInterface
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */