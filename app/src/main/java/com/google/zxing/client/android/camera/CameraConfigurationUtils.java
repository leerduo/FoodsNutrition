package com.google.zxing.client.android.camera;

import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera.Area;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public final class CameraConfigurationUtils
{
  private static final Pattern a = Pattern.compile(";");
  
  public static Point a(Camera.Parameters paramParameters, Point paramPoint)
  {
    List localList = paramParameters.getSupportedPreviewSizes();
    if (localList == null)
    {
      Log.w("CameraConfiguration", "Device returned no supported preview sizes; using default");
      Camera.Size localSize5 = paramParameters.getPreviewSize();
      if (localSize5 == null) {
        throw new IllegalStateException("Parameters contained no preview size!");
      }
      return new Point(localSize5.width, localSize5.height);
    }
    ArrayList localArrayList = new ArrayList(localList);
    Collections.sort(localArrayList, new CameraConfigurationUtils.1());
    if (Log.isLoggable("CameraConfiguration", 4))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator1 = localArrayList.iterator();
      while (localIterator1.hasNext())
      {
        Camera.Size localSize4 = (Camera.Size)localIterator1.next();
        localStringBuilder.append(localSize4.width).append('x').append(localSize4.height).append(' ');
      }
      Log.i("CameraConfiguration", "Supported preview sizes: " + localStringBuilder);
    }
    double d = paramPoint.x / paramPoint.y;
    Iterator localIterator2 = localArrayList.iterator();
    while (localIterator2.hasNext())
    {
      Camera.Size localSize3 = (Camera.Size)localIterator2.next();
      int i = localSize3.width;
      int j = localSize3.height;
      if (i * j < 153600)
      {
        localIterator2.remove();
      }
      else
      {
        int k;
        label269:
        int m;
        if (i < j)
        {
          k = 1;
          if (k == 0) {
            break label323;
          }
          m = j;
          label278:
          if (k == 0) {
            break label330;
          }
        }
        label323:
        label330:
        for (int n = i;; n = j)
        {
          if (Math.abs(m / n - d) <= 0.15D) {
            break label337;
          }
          localIterator2.remove();
          break;
          k = 0;
          break label269;
          m = i;
          break label278;
        }
        label337:
        if ((m == paramPoint.x) && (n == paramPoint.y))
        {
          Point localPoint3 = new Point(i, j);
          Log.i("CameraConfiguration", "Found preview size exactly matching screen size: " + localPoint3);
          return localPoint3;
        }
      }
    }
    if (!localArrayList.isEmpty())
    {
      Camera.Size localSize2 = (Camera.Size)localArrayList.get(0);
      Point localPoint2 = new Point(localSize2.width, localSize2.height);
      Log.i("CameraConfiguration", "Using largest suitable preview size: " + localPoint2);
      return localPoint2;
    }
    Camera.Size localSize1 = paramParameters.getPreviewSize();
    if (localSize1 == null) {
      throw new IllegalStateException("Parameters contained no preview size!");
    }
    Point localPoint1 = new Point(localSize1.width, localSize1.height);
    Log.i("CameraConfiguration", "No suitable preview sizes, using default: " + localPoint1);
    return localPoint1;
  }
  
  private static String a(Iterable<Camera.Area> paramIterable)
  {
    if (paramIterable == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramIterable.iterator();
    while (localIterator.hasNext())
    {
      Camera.Area localArea = (Camera.Area)localIterator.next();
      localStringBuilder.append(localArea.rect).append(':').append(localArea.weight).append(' ');
    }
    return localStringBuilder.toString();
  }
  
  private static String a(String paramString, Collection<String> paramCollection, String... paramVarArgs)
  {
    Log.i("CameraConfiguration", "Requesting " + paramString + " value from among: " + Arrays.toString(paramVarArgs));
    Log.i("CameraConfiguration", "Supported " + paramString + " values: " + paramCollection);
    if (paramCollection != null)
    {
      int i = paramVarArgs.length;
      for (int j = 0; j < i; j++)
      {
        String str = paramVarArgs[j];
        if (paramCollection.contains(str))
        {
          Log.i("CameraConfiguration", "Can set " + paramString + " to: " + str);
          return str;
        }
      }
    }
    Log.i("CameraConfiguration", "No supported values match");
    return null;
  }
  
  private static List<Camera.Area> a(int paramInt)
  {
    return Collections.singletonList(new Camera.Area(new Rect(-paramInt, -paramInt, paramInt, paramInt), 1));
  }
  
  public static void a(Camera.Parameters paramParameters)
  {
    if (paramParameters.getMaxNumFocusAreas() > 0)
    {
      Log.i("CameraConfiguration", "Old focus areas: " + a(paramParameters.getFocusAreas()));
      List localList = a(400);
      Log.i("CameraConfiguration", "Setting focus area to : " + a(localList));
      paramParameters.setFocusAreas(localList);
      return;
    }
    Log.i("CameraConfiguration", "Device does not support focus areas");
  }
  
  public static void a(Camera.Parameters paramParameters, boolean paramBoolean)
  {
    List localList = paramParameters.getSupportedFlashModes();
    if (paramBoolean) {}
    for (String str = a("flash mode", localList, new String[] { "torch", "on" });; str = a("flash mode", localList, new String[] { "off" }))
    {
      if (str != null)
      {
        if (!str.equals(paramParameters.getFlashMode())) {
          break;
        }
        Log.i("CameraConfiguration", "Flash mode already set to " + str);
      }
      return;
    }
    Log.i("CameraConfiguration", "Setting flash mode to " + str);
    paramParameters.setFlashMode(str);
  }
  
  public static void a(Camera.Parameters paramParameters, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    List localList = paramParameters.getSupportedFocusModes();
    String str = null;
    if (paramBoolean1) {
      if ((!paramBoolean3) && (!paramBoolean2)) {
        break label121;
      }
    }
    label121:
    for (str = a("focus mode", localList, new String[] { "auto" });; str = a("focus mode", localList, new String[] { "continuous-picture", "continuous-video", "auto" }))
    {
      if ((!paramBoolean3) && (str == null)) {
        str = a("focus mode", localList, new String[] { "macro", "edof" });
      }
      if (str != null)
      {
        if (!str.equals(paramParameters.getFocusMode())) {
          break;
        }
        Log.i("CameraConfiguration", "Focus mode already set to " + str);
      }
      return;
    }
    paramParameters.setFocusMode(str);
  }
  
  public static void b(Camera.Parameters paramParameters)
  {
    if (paramParameters.getMaxNumMeteringAreas() > 0)
    {
      Log.i("CameraConfiguration", "Old metering areas: " + paramParameters.getMeteringAreas());
      List localList = a(400);
      Log.i("CameraConfiguration", "Setting metering area to : " + a(localList));
      paramParameters.setMeteringAreas(localList);
      return;
    }
    Log.i("CameraConfiguration", "Device does not support metering areas");
  }
  
  public static void b(Camera.Parameters paramParameters, boolean paramBoolean)
  {
    int i = paramParameters.getMinExposureCompensation();
    int j = paramParameters.getMaxExposureCompensation();
    float f1 = paramParameters.getExposureCompensationStep();
    if (((i != 0) || (j != 0)) && (f1 > 0.0F))
    {
      float f2 = 0.0F;
      if (paramBoolean) {}
      float f3;
      int m;
      for (;;)
      {
        int k = Math.round(f2 / f1);
        f3 = f1 * k;
        m = Math.max(Math.min(k, j), i);
        if (paramParameters.getExposureCompensation() != m) {
          break;
        }
        Log.i("CameraConfiguration", "Exposure compensation already set to " + m + " / " + f3);
        return;
        f2 = 1.5F;
      }
      Log.i("CameraConfiguration", "Setting exposure compensation to " + m + " / " + f3);
      paramParameters.setExposureCompensation(m);
      return;
    }
    Log.i("CameraConfiguration", "Camera does not support exposure compensation");
  }
  
  public static void c(Camera.Parameters paramParameters)
  {
    if (paramParameters.isVideoStabilizationSupported())
    {
      if (paramParameters.getVideoStabilization())
      {
        Log.i("CameraConfiguration", "Video stabilization already enabled");
        return;
      }
      Log.i("CameraConfiguration", "Enabling video stabilization...");
      paramParameters.setVideoStabilization(true);
      return;
    }
    Log.i("CameraConfiguration", "This device does not support video stabilization");
  }
  
  public static void d(Camera.Parameters paramParameters)
  {
    if ("barcode".equals(paramParameters.getSceneMode())) {
      Log.i("CameraConfiguration", "Barcode scene mode already set");
    }
    String str;
    do
    {
      return;
      str = a("scene mode", paramParameters.getSupportedSceneModes(), new String[] { "barcode" });
    } while (str == null);
    paramParameters.setSceneMode(str);
  }
  
  public static void e(Camera.Parameters paramParameters)
  {
    if ("negative".equals(paramParameters.getColorEffect())) {
      Log.i("CameraConfiguration", "Negative effect already set");
    }
    String str;
    do
    {
      return;
      str = a("color effect", paramParameters.getSupportedColorEffects(), new String[] { "negative" });
    } while (str == null);
    paramParameters.setColorEffect(str);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.android.camera.CameraConfigurationUtils
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */