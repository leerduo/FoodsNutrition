package com.google.zxing.client.android;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.preference.PreferenceManager;
import com.google.zxing.client.android.camera.CameraManager;
import com.google.zxing.client.android.camera.FrontLightMode;

final class AmbientLightManager
  implements SensorEventListener
{
  private final Context a;
  private CameraManager b;
  private Sensor c;
  
  AmbientLightManager(Context paramContext)
  {
    this.a = paramContext;
  }
  
  void a()
  {
    if (this.c != null)
    {
      ((SensorManager)this.a.getSystemService("sensor")).unregisterListener(this);
      this.b = null;
      this.c = null;
    }
  }
  
  void a(CameraManager paramCameraManager)
  {
    this.b = paramCameraManager;
    if (FrontLightMode.a(PreferenceManager.getDefaultSharedPreferences(this.a)) == FrontLightMode.b)
    {
      SensorManager localSensorManager = (SensorManager)this.a.getSystemService("sensor");
      this.c = localSensorManager.getDefaultSensor(5);
      if (this.c != null) {
        localSensorManager.registerListener(this, this.c, 3);
      }
    }
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    float f = paramSensorEvent.values[0];
    if (this.b != null)
    {
      if (f > 45.0F) {
        break label30;
      }
      this.b.a(true);
    }
    label30:
    while (f < 450.0F) {
      return;
    }
    this.b.a(false);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.android.AmbientLightManager
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */