package com.google.zxing.client.android.camera;

import android.content.Context;
import android.graphics.Rect;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Handler;
import android.util.Log;
import android.view.SurfaceHolder;
import com.google.zxing.PlanarYUVLuminanceSource;
import com.google.zxing.client.android.camera.open.OpenCameraInterface;
import java.io.IOException;

public final class CameraManager
{
  private static final String a = CameraManager.class.getSimpleName();
  private final Context b;
  private final CameraConfigurationManager c;
  private Camera d;
  private AutoFocusManager e;
  private Rect f;
  private Rect g;
  private boolean h;
  private boolean i;
  private int j = -1;
  private int k;
  private int l;
  private final PreviewCallback m;
  
  public CameraManager(Context paramContext)
  {
    this.b = paramContext;
    this.c = new CameraConfigurationManager(paramContext);
    this.m = new PreviewCallback(this.c);
  }
  
  private static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    int n = paramInt1 * 5 / 8;
    if (n < paramInt2) {
      return paramInt2;
    }
    if (n > paramInt3) {
      return paramInt3;
    }
    return n;
  }
  
  public PlanarYUVLuminanceSource a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Rect localRect = f();
    if (localRect == null) {
      return null;
    }
    return new PlanarYUVLuminanceSource(paramArrayOfByte, paramInt1, paramInt2, localRect.left, localRect.top, localRect.width(), localRect.height(), false);
  }
  
  public void a(int paramInt)
  {
    try
    {
      if (this.h) {
        throw new IllegalStateException();
      }
    }
    finally {}
    this.j = paramInt;
  }
  
  /* Error */
  public void a(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 85	com/google/zxing/client/android/camera/CameraManager:h	Z
    //   6: ifeq +124 -> 130
    //   9: aload_0
    //   10: getfield 50	com/google/zxing/client/android/camera/CameraManager:c	Lcom/google/zxing/client/android/camera/CameraConfigurationManager;
    //   13: invokevirtual 92	com/google/zxing/client/android/camera/CameraConfigurationManager:b	()Landroid/graphics/Point;
    //   16: astore 4
    //   18: iload_1
    //   19: aload 4
    //   21: getfield 97	android/graphics/Point:x	I
    //   24: if_icmple +9 -> 33
    //   27: aload 4
    //   29: getfield 97	android/graphics/Point:x	I
    //   32: istore_1
    //   33: iload_2
    //   34: aload 4
    //   36: getfield 100	android/graphics/Point:y	I
    //   39: if_icmple +9 -> 48
    //   42: aload 4
    //   44: getfield 100	android/graphics/Point:y	I
    //   47: istore_2
    //   48: aload 4
    //   50: getfield 97	android/graphics/Point:x	I
    //   53: iload_1
    //   54: isub
    //   55: iconst_2
    //   56: idiv
    //   57: istore 5
    //   59: aload 4
    //   61: getfield 100	android/graphics/Point:y	I
    //   64: iload_2
    //   65: isub
    //   66: iconst_2
    //   67: idiv
    //   68: istore 6
    //   70: aload_0
    //   71: new 66	android/graphics/Rect
    //   74: dup
    //   75: iload 5
    //   77: iload 6
    //   79: iload 5
    //   81: iload_1
    //   82: iadd
    //   83: iload 6
    //   85: iload_2
    //   86: iadd
    //   87: invokespecial 103	android/graphics/Rect:<init>	(IIII)V
    //   90: putfield 105	com/google/zxing/client/android/camera/CameraManager:f	Landroid/graphics/Rect;
    //   93: getstatic 36	com/google/zxing/client/android/camera/CameraManager:a	Ljava/lang/String;
    //   96: new 107	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   103: ldc 110
    //   105: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: aload_0
    //   109: getfield 105	com/google/zxing/client/android/camera/CameraManager:f	Landroid/graphics/Rect;
    //   112: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokestatic 125	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   121: pop
    //   122: aload_0
    //   123: aconst_null
    //   124: putfield 127	com/google/zxing/client/android/camera/CameraManager:g	Landroid/graphics/Rect;
    //   127: aload_0
    //   128: monitorexit
    //   129: return
    //   130: aload_0
    //   131: iload_1
    //   132: putfield 129	com/google/zxing/client/android/camera/CameraManager:k	I
    //   135: aload_0
    //   136: iload_2
    //   137: putfield 131	com/google/zxing/client/android/camera/CameraManager:l	I
    //   140: goto -13 -> 127
    //   143: astore_3
    //   144: aload_0
    //   145: monitorexit
    //   146: aload_3
    //   147: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	this	CameraManager
    //   0	148	1	paramInt1	int
    //   0	148	2	paramInt2	int
    //   143	4	3	localObject	Object
    //   16	44	4	localPoint	android.graphics.Point
    //   57	26	5	n	int
    //   68	19	6	i1	int
    // Exception table:
    //   from	to	target	type
    //   2	33	143	finally
    //   33	48	143	finally
    //   48	127	143	finally
    //   130	140	143	finally
  }
  
  public void a(Handler paramHandler, int paramInt)
  {
    try
    {
      Camera localCamera = this.d;
      if ((localCamera != null) && (this.i))
      {
        this.m.a(paramHandler, paramInt);
        localCamera.setOneShotPreviewCallback(this.m);
      }
      return;
    }
    finally {}
  }
  
  public void a(SurfaceHolder paramSurfaceHolder)
  {
    Camera localCamera1;
    for (;;)
    {
      try
      {
        localCamera1 = this.d;
        if (localCamera1 != null) {
          break label55;
        }
        if (this.j >= 0)
        {
          localCamera1 = OpenCameraInterface.a(this.j);
          if (localCamera1 != null) {
            break;
          }
          throw new IOException();
        }
      }
      finally {}
      localCamera1 = OpenCameraInterface.a();
    }
    this.d = localCamera1;
    label55:
    localCamera2 = localCamera1;
    localCamera2.setPreviewDisplay(paramSurfaceHolder);
    if (!this.h)
    {
      this.h = true;
      this.c.a(localCamera2);
      if ((this.k > 0) && (this.l > 0))
      {
        a(this.k, this.l);
        this.k = 0;
        this.l = 0;
      }
    }
    Camera.Parameters localParameters1 = localCamera2.getParameters();
    if (localParameters1 == null) {}
    for (str = null;; str = localParameters1.flatten()) {
      try
      {
        this.c.a(localCamera2, false);
        return;
      }
      catch (RuntimeException localRuntimeException1)
      {
        for (;;)
        {
          Log.w(a, "Camera rejected parameters. Setting only minimal safe-mode parameters");
          Log.i(a, "Resetting to saved camera params: " + str);
          if (str != null)
          {
            Camera.Parameters localParameters2 = localCamera2.getParameters();
            localParameters2.unflatten(str);
            try
            {
              localCamera2.setParameters(localParameters2);
              this.c.a(localCamera2, true);
            }
            catch (RuntimeException localRuntimeException2)
            {
              Log.w(a, "Camera rejected even safe-mode parameters! No configuration");
            }
          }
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    try
    {
      if ((paramBoolean != this.c.b(this.d)) && (this.d != null))
      {
        if (this.e != null) {
          this.e.b();
        }
        this.c.b(this.d, paramBoolean);
        if (this.e != null) {
          this.e.a();
        }
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public boolean a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 134	com/google/zxing/client/android/camera/CameraManager:d	Landroid/hardware/Camera;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnull +9 -> 17
    //   11: iconst_1
    //   12: istore_3
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_3
    //   16: ireturn
    //   17: iconst_0
    //   18: istore_3
    //   19: goto -6 -> 13
    //   22: astore_1
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_1
    //   26: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	27	0	this	CameraManager
    //   22	4	1	localObject	Object
    //   6	2	2	localCamera	Camera
    //   12	7	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	22	finally
  }
  
  public void b()
  {
    try
    {
      if (this.d != null)
      {
        this.d.release();
        this.d = null;
        this.f = null;
        this.g = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void c()
  {
    try
    {
      Camera localCamera = this.d;
      if ((localCamera != null) && (!this.i))
      {
        localCamera.startPreview();
        this.i = true;
        this.e = new AutoFocusManager(this.b, this.d);
      }
      return;
    }
    finally {}
  }
  
  public void d()
  {
    try
    {
      if (this.e != null)
      {
        this.e.b();
        this.e = null;
      }
      if ((this.d != null) && (this.i))
      {
        this.d.stopPreview();
        this.m.a(null, 0);
        this.i = false;
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public Rect e()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 105	com/google/zxing/client/android/camera/CameraManager:f	Landroid/graphics/Rect;
    //   6: ifnonnull +144 -> 150
    //   9: aload_0
    //   10: getfield 134	com/google/zxing/client/android/camera/CameraManager:d	Landroid/hardware/Camera;
    //   13: astore_3
    //   14: aconst_null
    //   15: astore_2
    //   16: aload_3
    //   17: ifnonnull +7 -> 24
    //   20: aload_0
    //   21: monitorexit
    //   22: aload_2
    //   23: areturn
    //   24: aload_0
    //   25: getfield 50	com/google/zxing/client/android/camera/CameraManager:c	Lcom/google/zxing/client/android/camera/CameraConfigurationManager;
    //   28: invokevirtual 92	com/google/zxing/client/android/camera/CameraConfigurationManager:b	()Landroid/graphics/Point;
    //   31: astore 4
    //   33: aconst_null
    //   34: astore_2
    //   35: aload 4
    //   37: ifnull -17 -> 20
    //   40: aload 4
    //   42: getfield 97	android/graphics/Point:x	I
    //   45: sipush 240
    //   48: sipush 1200
    //   51: invokestatic 226	com/google/zxing/client/android/camera/CameraManager:a	(III)I
    //   54: istore 5
    //   56: aload 4
    //   58: getfield 100	android/graphics/Point:y	I
    //   61: sipush 240
    //   64: sipush 675
    //   67: invokestatic 226	com/google/zxing/client/android/camera/CameraManager:a	(III)I
    //   70: istore 6
    //   72: aload 4
    //   74: getfield 97	android/graphics/Point:x	I
    //   77: iload 5
    //   79: isub
    //   80: iconst_2
    //   81: idiv
    //   82: istore 7
    //   84: aload 4
    //   86: getfield 100	android/graphics/Point:y	I
    //   89: iload 6
    //   91: isub
    //   92: iconst_2
    //   93: idiv
    //   94: istore 8
    //   96: aload_0
    //   97: new 66	android/graphics/Rect
    //   100: dup
    //   101: iload 7
    //   103: iload 8
    //   105: iload 5
    //   107: iload 7
    //   109: iadd
    //   110: iload 6
    //   112: iload 8
    //   114: iadd
    //   115: invokespecial 103	android/graphics/Rect:<init>	(IIII)V
    //   118: putfield 105	com/google/zxing/client/android/camera/CameraManager:f	Landroid/graphics/Rect;
    //   121: getstatic 36	com/google/zxing/client/android/camera/CameraManager:a	Ljava/lang/String;
    //   124: new 107	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   131: ldc 228
    //   133: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: aload_0
    //   137: getfield 105	com/google/zxing/client/android/camera/CameraManager:f	Landroid/graphics/Rect;
    //   140: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   143: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokestatic 125	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   149: pop
    //   150: aload_0
    //   151: getfield 105	com/google/zxing/client/android/camera/CameraManager:f	Landroid/graphics/Rect;
    //   154: astore_2
    //   155: goto -135 -> 20
    //   158: astore_1
    //   159: aload_0
    //   160: monitorexit
    //   161: aload_1
    //   162: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	163	0	this	CameraManager
    //   158	4	1	localObject	Object
    //   15	140	2	localRect	Rect
    //   13	4	3	localCamera	Camera
    //   31	54	4	localPoint	android.graphics.Point
    //   54	56	5	n	int
    //   70	45	6	i1	int
    //   82	28	7	i2	int
    //   94	21	8	i3	int
    // Exception table:
    //   from	to	target	type
    //   2	14	158	finally
    //   24	33	158	finally
    //   40	150	158	finally
    //   150	155	158	finally
  }
  
  /* Error */
  public Rect f()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 127	com/google/zxing/client/android/camera/CameraManager:g	Landroid/graphics/Rect;
    //   6: ifnonnull +154 -> 160
    //   9: aload_0
    //   10: invokevirtual 230	com/google/zxing/client/android/camera/CameraManager:e	()Landroid/graphics/Rect;
    //   13: astore_3
    //   14: aconst_null
    //   15: astore_2
    //   16: aload_3
    //   17: ifnonnull +7 -> 24
    //   20: aload_0
    //   21: monitorexit
    //   22: aload_2
    //   23: areturn
    //   24: new 66	android/graphics/Rect
    //   27: dup
    //   28: aload_3
    //   29: invokespecial 233	android/graphics/Rect:<init>	(Landroid/graphics/Rect;)V
    //   32: astore 4
    //   34: aload_0
    //   35: getfield 50	com/google/zxing/client/android/camera/CameraManager:c	Lcom/google/zxing/client/android/camera/CameraConfigurationManager;
    //   38: invokevirtual 235	com/google/zxing/client/android/camera/CameraConfigurationManager:a	()Landroid/graphics/Point;
    //   41: astore 5
    //   43: aload_0
    //   44: getfield 50	com/google/zxing/client/android/camera/CameraManager:c	Lcom/google/zxing/client/android/camera/CameraConfigurationManager;
    //   47: invokevirtual 92	com/google/zxing/client/android/camera/CameraConfigurationManager:b	()Landroid/graphics/Point;
    //   50: astore 6
    //   52: aconst_null
    //   53: astore_2
    //   54: aload 5
    //   56: ifnull -36 -> 20
    //   59: aconst_null
    //   60: astore_2
    //   61: aload 6
    //   63: ifnull -43 -> 20
    //   66: aload 4
    //   68: aload 4
    //   70: getfield 69	android/graphics/Rect:left	I
    //   73: aload 5
    //   75: getfield 97	android/graphics/Point:x	I
    //   78: imul
    //   79: aload 6
    //   81: getfield 97	android/graphics/Point:x	I
    //   84: idiv
    //   85: putfield 69	android/graphics/Rect:left	I
    //   88: aload 4
    //   90: aload 4
    //   92: getfield 238	android/graphics/Rect:right	I
    //   95: aload 5
    //   97: getfield 97	android/graphics/Point:x	I
    //   100: imul
    //   101: aload 6
    //   103: getfield 97	android/graphics/Point:x	I
    //   106: idiv
    //   107: putfield 238	android/graphics/Rect:right	I
    //   110: aload 4
    //   112: aload 4
    //   114: getfield 72	android/graphics/Rect:top	I
    //   117: aload 5
    //   119: getfield 100	android/graphics/Point:y	I
    //   122: imul
    //   123: aload 6
    //   125: getfield 100	android/graphics/Point:y	I
    //   128: idiv
    //   129: putfield 72	android/graphics/Rect:top	I
    //   132: aload 4
    //   134: aload 4
    //   136: getfield 241	android/graphics/Rect:bottom	I
    //   139: aload 5
    //   141: getfield 100	android/graphics/Point:y	I
    //   144: imul
    //   145: aload 6
    //   147: getfield 100	android/graphics/Point:y	I
    //   150: idiv
    //   151: putfield 241	android/graphics/Rect:bottom	I
    //   154: aload_0
    //   155: aload 4
    //   157: putfield 127	com/google/zxing/client/android/camera/CameraManager:g	Landroid/graphics/Rect;
    //   160: aload_0
    //   161: getfield 127	com/google/zxing/client/android/camera/CameraManager:g	Landroid/graphics/Rect;
    //   164: astore_2
    //   165: goto -145 -> 20
    //   168: astore_1
    //   169: aload_0
    //   170: monitorexit
    //   171: aload_1
    //   172: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	this	CameraManager
    //   168	4	1	localObject	Object
    //   15	150	2	localRect1	Rect
    //   13	16	3	localRect2	Rect
    //   32	124	4	localRect3	Rect
    //   41	99	5	localPoint1	android.graphics.Point
    //   50	96	6	localPoint2	android.graphics.Point
    // Exception table:
    //   from	to	target	type
    //   2	14	168	finally
    //   24	52	168	finally
    //   66	160	168	finally
    //   160	165	168	finally
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.android.camera.CameraManager
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */