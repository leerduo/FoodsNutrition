package com.google.zxing.client.androidlegacy.camera;

import android.content.SharedPreferences;

public enum FrontLightMode
{
  static
  {
    FrontLightMode[] arrayOfFrontLightMode = new FrontLightMode[3];
    arrayOfFrontLightMode[0] = a;
    arrayOfFrontLightMode[1] = b;
    arrayOfFrontLightMode[2] = c;
  }
  
  private FrontLightMode() {}
  
  public static FrontLightMode a(SharedPreferences paramSharedPreferences)
  {
    return a(paramSharedPreferences.getString("preferences_front_light_mode", null));
  }
  
  private static FrontLightMode a(String paramString)
  {
    if (paramString == null) {
      return c;
    }
    return valueOf(paramString);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.androidlegacy.camera.FrontLightMode
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */