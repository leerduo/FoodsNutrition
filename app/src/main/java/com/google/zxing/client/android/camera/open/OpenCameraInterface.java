package com.google.zxing.client.android.camera.open;

import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.util.Log;

public final class OpenCameraInterface
{
  private static final String a = OpenCameraInterface.class.getName();
  
  public static Camera a()
  {
    return a(-1);
  }
  
  public static Camera a(int paramInt)
  {
    int i = Camera.getNumberOfCameras();
    if (i == 0)
    {
      Log.w(a, "No cameras!");
      return null;
    }
    int j;
    if (paramInt >= 0)
    {
      j = 1;
      if (j != 0) {}
    }
    for (paramInt = 0;; paramInt++) {
      if (paramInt < i)
      {
        Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(paramInt, localCameraInfo);
        if (localCameraInfo.facing != 0) {}
      }
      else
      {
        if (paramInt >= i) {
          break label106;
        }
        Log.i(a, "Opening camera #" + paramInt);
        return Camera.open(paramInt);
        j = 0;
        break;
      }
    }
    label106:
    if (j != 0)
    {
      Log.w(a, "Requested camera does not exist: " + paramInt);
      return null;
    }
    Log.i(a, "No camera facing back; returning camera #0");
    return Camera.open(0);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.android.camera.open.OpenCameraInterface
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */