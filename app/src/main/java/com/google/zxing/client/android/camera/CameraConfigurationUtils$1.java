package com.google.zxing.client.android.camera;

import android.hardware.Camera.Size;
import java.util.Comparator;

final class CameraConfigurationUtils$1
  implements Comparator<Camera.Size>
{
  public int a(Camera.Size paramSize1, Camera.Size paramSize2)
  {
    int i = paramSize1.height * paramSize1.width;
    int j = paramSize2.height * paramSize2.width;
    if (j < i) {
      return -1;
    }
    if (j > i) {
      return 1;
    }
    return 0;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.android.camera.CameraConfigurationUtils.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */