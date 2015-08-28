package com.google.zxing.client.android.camera;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;

final class CameraConfigurationManager
{
  private final Context a;
  private Point b;
  private Point c;
  
  CameraConfigurationManager(Context paramContext)
  {
    this.a = paramContext;
  }
  
  private void a(Camera.Parameters paramParameters, SharedPreferences paramSharedPreferences, boolean paramBoolean)
  {
    if (FrontLightMode.a(paramSharedPreferences) == FrontLightMode.a) {}
    for (boolean bool = true;; bool = false)
    {
      a(paramParameters, bool, paramBoolean);
      return;
    }
  }
  
  private void a(Camera.Parameters paramParameters, boolean paramBoolean1, boolean paramBoolean2)
  {
    CameraConfigurationUtils.a(paramParameters, paramBoolean1);
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.a);
    if ((!paramBoolean2) && (!localSharedPreferences.getBoolean("zxing_preferences_disable_exposure", true))) {
      CameraConfigurationUtils.b(paramParameters, paramBoolean1);
    }
  }
  
  Point a()
  {
    return this.c;
  }
  
  void a(Camera paramCamera)
  {
    Camera.Parameters localParameters = paramCamera.getParameters();
    Display localDisplay = ((WindowManager)this.a.getSystemService("window")).getDefaultDisplay();
    Point localPoint = new Point();
    localDisplay.getSize(localPoint);
    this.b = localPoint;
    Log.i("CameraConfiguration", "Screen resolution: " + this.b);
    this.c = CameraConfigurationUtils.a(localParameters, this.b);
    Log.i("CameraConfiguration", "Camera resolution: " + this.c);
  }
  
  void a(Camera paramCamera, boolean paramBoolean)
  {
    Camera.Parameters localParameters = paramCamera.getParameters();
    if (localParameters == null) {
      Log.w("CameraConfiguration", "Device error: no camera parameters are available. Proceeding without configuration.");
    }
    Camera.Size localSize;
    do
    {
      return;
      Log.i("CameraConfiguration", "Initial camera parameters: " + localParameters.flatten());
      if (paramBoolean) {
        Log.w("CameraConfiguration", "In camera config safe mode -- most settings will not be honored");
      }
      SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.a);
      a(localParameters, localSharedPreferences, paramBoolean);
      CameraConfigurationUtils.a(localParameters, localSharedPreferences.getBoolean("zxing_preferences_auto_focus", true), localSharedPreferences.getBoolean("zxing_preferences_disable_continuous_focus", true), paramBoolean);
      if (!paramBoolean)
      {
        if (localSharedPreferences.getBoolean("zxing_preferences_invert_scan", false)) {
          CameraConfigurationUtils.e(localParameters);
        }
        if (!localSharedPreferences.getBoolean("zxing_preferences_disable_barcode_scene_mode", true)) {
          CameraConfigurationUtils.d(localParameters);
        }
        if (!localSharedPreferences.getBoolean("zxing_preferences_disable_metering", true))
        {
          CameraConfigurationUtils.c(localParameters);
          CameraConfigurationUtils.a(localParameters);
          CameraConfigurationUtils.b(localParameters);
        }
      }
      localParameters.setPreviewSize(this.c.x, this.c.y);
      paramCamera.setParameters(localParameters);
      localSize = paramCamera.getParameters().getPreviewSize();
    } while ((localSize == null) || ((this.c.x == localSize.width) && (this.c.y == localSize.height)));
    Log.w("CameraConfiguration", "Camera said it supported preview size " + this.c.x + 'x' + this.c.y + ", but after setting it, preview size is " + localSize.width + 'x' + localSize.height);
    this.c.x = localSize.width;
    this.c.y = localSize.height;
  }
  
  Point b()
  {
    return this.b;
  }
  
  void b(Camera paramCamera, boolean paramBoolean)
  {
    Camera.Parameters localParameters = paramCamera.getParameters();
    a(localParameters, paramBoolean, false);
    paramCamera.setParameters(localParameters);
  }
  
  boolean b(Camera paramCamera)
  {
    boolean bool1 = false;
    if (paramCamera != null)
    {
      Camera.Parameters localParameters = paramCamera.getParameters();
      bool1 = false;
      if (localParameters != null)
      {
        String str = paramCamera.getParameters().getFlashMode();
        bool1 = false;
        if (str != null) {
          if (!"on".equals(str))
          {
            boolean bool2 = "torch".equals(str);
            bool1 = false;
            if (!bool2) {}
          }
          else
          {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.android.camera.CameraConfigurationManager
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */