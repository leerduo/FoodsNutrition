package com.google.zxing.client.androidlegacy.camera;

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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

final class CameraConfigurationManager
{
  private final Context a;
  private Point b;
  private Point c;
  
  CameraConfigurationManager(Context paramContext)
  {
    this.a = paramContext;
  }
  
  private Point a(Camera.Parameters paramParameters, Point paramPoint)
  {
    List localList = paramParameters.getSupportedPreviewSizes();
    if (localList == null)
    {
      Log.w("CameraConfiguration", "Device returned no supported preview sizes; using default");
      Camera.Size localSize4 = paramParameters.getPreviewSize();
      return new Point(localSize4.width, localSize4.height);
    }
    ArrayList localArrayList = new ArrayList(localList);
    Collections.sort(localArrayList, new CameraConfigurationManager.1(this));
    if (Log.isLoggable("CameraConfiguration", 4))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator1 = localArrayList.iterator();
      while (localIterator1.hasNext())
      {
        Camera.Size localSize3 = (Camera.Size)localIterator1.next();
        localStringBuilder.append(localSize3.width).append('x').append(localSize3.height).append(' ');
      }
      Log.i("CameraConfiguration", "Supported preview sizes: " + localStringBuilder);
    }
    Object localObject1 = null;
    float f1 = paramPoint.x / paramPoint.y;
    float f2 = (1.0F / 1.0F);
    Iterator localIterator2 = localArrayList.iterator();
    int i;
    int j;
    label276:
    label351:
    label358:
    label365:
    float f3;
    while (localIterator2.hasNext())
    {
      Camera.Size localSize2 = (Camera.Size)localIterator2.next();
      i = localSize2.width;
      j = localSize2.height;
      int k = i * j;
      if ((k >= 150400) && (k <= 1024000))
      {
        int m;
        int n;
        if (i < j)
        {
          m = 1;
          if (m == 0) {
            break label351;
          }
          n = j;
          if (m == 0) {
            break label358;
          }
        }
        for (int i1 = i;; i1 = j)
        {
          if ((n != paramPoint.x) || (i1 != paramPoint.y)) {
            break label365;
          }
          Point localPoint = new Point(i, j);
          Log.i("CameraConfiguration", "Found preview size exactly matching screen size: " + localPoint);
          return localPoint;
          m = 0;
          break;
          n = i;
          break label276;
        }
        f3 = Math.abs(n / i1 - f1);
        if (f3 >= f2) {
          break label497;
        }
      }
    }
    for (Object localObject2 = new Point(i, j);; localObject2 = localObject1)
    {
      localObject1 = localObject2;
      f2 = f3;
      break;
      if (localObject1 == null)
      {
        Camera.Size localSize1 = paramParameters.getPreviewSize();
        localObject1 = new Point(localSize1.width, localSize1.height);
        Log.i("CameraConfiguration", "No suitable preview sizes, using default: " + localObject1);
      }
      Log.i("CameraConfiguration", "Found best approximate preview size: " + localObject1);
      return localObject1;
      label497:
      f3 = f2;
    }
  }
  
  private static String a(Collection<String> paramCollection, String... paramVarArgs)
  {
    Log.i("CameraConfiguration", "Supported values: " + paramCollection);
    int j;
    String str;
    if (paramCollection != null)
    {
      int i = paramVarArgs.length;
      j = 0;
      if (j < i)
      {
        str = paramVarArgs[j];
        if (!paramCollection.contains(str)) {}
      }
    }
    for (;;)
    {
      Log.i("CameraConfiguration", "Settable value: " + str);
      return str;
      j++;
      break;
      str = null;
    }
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
    if (paramBoolean1) {}
    for (String str = a(paramParameters.getSupportedFlashModes(), new String[] { "torch", "on" });; str = a(paramParameters.getSupportedFlashModes(), new String[] { "off" }))
    {
      if (str != null) {
        paramParameters.setFlashMode(str);
      }
      return;
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
    int i = localDisplay.getWidth();
    int j = localDisplay.getHeight();
    if (i < j) {
      Log.i("CameraConfiguration", "Display reports portrait orientation; assuming this is incorrect");
    }
    for (;;)
    {
      this.b = new Point(j, i);
      Log.i("CameraConfiguration", "Screen resolution: " + this.b);
      this.c = a(localParameters, this.b);
      Log.i("CameraConfiguration", "Camera resolution: " + this.c);
      return;
      int k = j;
      j = i;
      i = k;
    }
  }
  
  void a(Camera paramCamera, boolean paramBoolean)
  {
    Camera.Parameters localParameters = paramCamera.getParameters();
    if (localParameters == null)
    {
      Log.w("CameraConfiguration", "Device error: no camera parameters are available. Proceeding without configuration.");
      return;
    }
    Log.i("CameraConfiguration", "Initial camera parameters: " + localParameters.flatten());
    if (paramBoolean) {
      Log.w("CameraConfiguration", "In camera config safe mode -- most settings will not be honored");
    }
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.a);
    a(localParameters, localSharedPreferences, paramBoolean);
    boolean bool = localSharedPreferences.getBoolean("preferences_auto_focus", true);
    String str1 = null;
    if (bool) {
      if ((!paramBoolean) && (!localSharedPreferences.getBoolean("preferences_disable_continuous_focus", false))) {
        break label241;
      }
    }
    label241:
    for (str1 = a(localParameters.getSupportedFocusModes(), new String[] { "auto" });; str1 = a(localParameters.getSupportedFocusModes(), new String[] { "continuous-picture", "continuous-video", "auto" }))
    {
      if ((!paramBoolean) && (str1 == null)) {
        str1 = a(localParameters.getSupportedFocusModes(), new String[] { "macro", "edof" });
      }
      if (str1 != null) {
        localParameters.setFocusMode(str1);
      }
      if (localSharedPreferences.getBoolean("preferences_invert_scan", false))
      {
        String str2 = a(localParameters.getSupportedColorEffects(), new String[] { "negative" });
        if (str2 != null) {
          localParameters.setColorEffect(str2);
        }
      }
      localParameters.setPreviewSize(this.c.x, this.c.y);
      paramCamera.setParameters(localParameters);
      return;
    }
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
 * Qualified Name:     com.google.zxing.client.androidlegacy.camera.CameraConfigurationManager
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */