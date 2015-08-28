package com.google.zxing.client.androidlegacy;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.client.androidlegacy.camera.CameraManager;
import java.io.IOException;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class CaptureActivity
  extends Activity
  implements SurfaceHolder.Callback
{
  private static final String a = CaptureActivity.class.getSimpleName();
  private static final String[] b = { "http://zxing.appspot.com/scan", "zxing://scan/" };
  private static final Set<ResultMetadataType> c = EnumSet.of(ResultMetadataType.e, ResultMetadataType.f, ResultMetadataType.d, ResultMetadataType.g);
  private CameraManager d;
  private CaptureActivityHandler e;
  private Result f;
  private ViewfinderView g;
  private TextView h;
  private View i;
  private Result j;
  private boolean k;
  private IntentSource l;
  private String m;
  private Collection<BarcodeFormat> n;
  private Map<DecodeHintType, ?> o;
  private String p;
  private InactivityTimer q;
  private BeepManager r;
  private AmbientLightManager s;
  private Button t;
  
  private void a(int paramInt, Object paramObject, long paramLong)
  {
    Message localMessage = Message.obtain(this.e, paramInt, paramObject);
    if (paramLong > 0L)
    {
      this.e.sendMessageDelayed(localMessage, paramLong);
      return;
    }
    this.e.sendMessage(localMessage);
  }
  
  private void a(Bitmap paramBitmap, float paramFloat, Result paramResult)
  {
    int i1 = 0;
    ResultPoint[] arrayOfResultPoint = paramResult.c();
    Canvas localCanvas;
    Paint localPaint;
    if ((arrayOfResultPoint != null) && (arrayOfResultPoint.length > 0))
    {
      localCanvas = new Canvas(paramBitmap);
      localPaint = new Paint();
      localPaint.setColor(getResources().getColor(R.color.zxinglegacy_result_points));
      if (arrayOfResultPoint.length != 2) {
        break label85;
      }
      localPaint.setStrokeWidth(4.0F);
      a(localCanvas, localPaint, arrayOfResultPoint[0], arrayOfResultPoint[1], paramFloat);
    }
    for (;;)
    {
      return;
      label85:
      if ((arrayOfResultPoint.length == 4) && ((paramResult.d() == BarcodeFormat.o) || (paramResult.d() == BarcodeFormat.h)))
      {
        a(localCanvas, localPaint, arrayOfResultPoint[0], arrayOfResultPoint[1], paramFloat);
        a(localCanvas, localPaint, arrayOfResultPoint[2], arrayOfResultPoint[3], paramFloat);
        return;
      }
      localPaint.setStrokeWidth(10.0F);
      int i2 = arrayOfResultPoint.length;
      while (i1 < i2)
      {
        ResultPoint localResultPoint = arrayOfResultPoint[i1];
        if (localResultPoint != null) {
          localCanvas.drawPoint(paramFloat * localResultPoint.a(), paramFloat * localResultPoint.b(), localPaint);
        }
        i1++;
      }
    }
  }
  
  private void a(Bitmap paramBitmap, Result paramResult)
  {
    if (this.e == null)
    {
      this.f = paramResult;
      return;
    }
    if (paramResult != null) {
      this.f = paramResult;
    }
    if (this.f != null)
    {
      Message localMessage = Message.obtain(this.e, R.id.zxinglegacy_decode_succeeded, this.f);
      this.e.sendMessage(localMessage);
    }
    this.f = null;
  }
  
  private static void a(Canvas paramCanvas, Paint paramPaint, ResultPoint paramResultPoint1, ResultPoint paramResultPoint2, float paramFloat)
  {
    if ((paramResultPoint1 != null) && (paramResultPoint2 != null)) {
      paramCanvas.drawLine(paramFloat * paramResultPoint1.a(), paramFloat * paramResultPoint1.b(), paramFloat * paramResultPoint2.a(), paramFloat * paramResultPoint2.b(), paramPaint);
    }
  }
  
  private void a(SurfaceHolder paramSurfaceHolder)
  {
    if (paramSurfaceHolder == null) {
      throw new IllegalStateException("No SurfaceHolder provided");
    }
    if (this.d.a())
    {
      Log.w(a, "initCamera() while already open -- late SurfaceView callback?");
      return;
    }
    try
    {
      this.d.a(paramSurfaceHolder);
      if (this.e == null) {
        this.e = new CaptureActivityHandler(this, this.n, this.o, this.p, this.d);
      }
      a(null, null);
      return;
    }
    catch (IOException localIOException)
    {
      Log.w(a, localIOException);
      f();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      Log.w(a, "Unexpected error initializing camera", localRuntimeException);
      f();
    }
  }
  
  private void a(Result paramResult, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      this.g.a(paramBitmap);
    }
    long l1;
    if (getIntent() == null) {
      l1 = 1500L;
    }
    while (this.l == IntentSource.a)
    {
      Intent localIntent = new Intent(getIntent().getAction());
      localIntent.addFlags(524288);
      localIntent.putExtra("SCAN_RESULT", paramResult.toString());
      localIntent.putExtra("SCAN_RESULT_FORMAT", paramResult.d().toString());
      byte[] arrayOfByte1 = paramResult.b();
      if ((arrayOfByte1 != null) && (arrayOfByte1.length > 0)) {
        localIntent.putExtra("SCAN_RESULT_BYTES", arrayOfByte1);
      }
      Map localMap = paramResult.e();
      if (localMap != null)
      {
        if (localMap.containsKey(ResultMetadataType.h)) {
          localIntent.putExtra("SCAN_RESULT_UPC_EAN_EXTENSION", localMap.get(ResultMetadataType.h).toString());
        }
        Integer localInteger = (Integer)localMap.get(ResultMetadataType.b);
        if (localInteger != null) {
          localIntent.putExtra("SCAN_RESULT_ORIENTATION", localInteger.intValue());
        }
        String str = (String)localMap.get(ResultMetadataType.d);
        if (str != null) {
          localIntent.putExtra("SCAN_RESULT_ERROR_CORRECTION_LEVEL", str);
        }
        Iterable localIterable = (Iterable)localMap.get(ResultMetadataType.c);
        if (localIterable != null)
        {
          int i1 = 0;
          Iterator localIterator = localIterable.iterator();
          for (;;)
          {
            if (localIterator.hasNext())
            {
              byte[] arrayOfByte2 = (byte[])localIterator.next();
              localIntent.putExtra("SCAN_RESULT_BYTE_SEGMENTS_" + i1, arrayOfByte2);
              i1++;
              continue;
              l1 = getIntent().getLongExtra("RESULT_DISPLAY_DURATION_MS", 1500L);
              break;
            }
          }
        }
      }
      a(R.id.zxinglegacy_return_scan_result, localIntent, l1);
    }
  }
  
  private static boolean a(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return false;
      String[] arrayOfString = b;
      int i1 = arrayOfString.length;
      for (int i2 = 0; i2 < i1; i2++) {
        if (paramString.startsWith(arrayOfString[i2])) {
          return true;
        }
      }
    }
  }
  
  private boolean e()
  {
    return false;
  }
  
  private void f()
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
    localBuilder.setTitle(getString(R.string.zxinglegacy_app_name));
    localBuilder.setMessage(getString(R.string.zxinglegacy_msg_camera_framework_bug));
    localBuilder.setPositiveButton(R.string.zxinglegacy_button_ok, new FinishListener(this));
    localBuilder.setOnCancelListener(new FinishListener(this));
    localBuilder.show();
  }
  
  private void g()
  {
    this.i.setVisibility(8);
    this.h.setText(R.string.zxinglegacy_msg_default_status);
    this.h.setVisibility(0);
    this.g.setVisibility(0);
    this.j = null;
  }
  
  ViewfinderView a()
  {
    return this.g;
  }
  
  public void a(long paramLong)
  {
    if (this.e != null) {
      this.e.sendEmptyMessageDelayed(R.id.zxinglegacy_restart_preview, paramLong);
    }
    g();
  }
  
  public void a(Result paramResult, Bitmap paramBitmap, float paramFloat)
  {
    this.q.a();
    this.j = paramResult;
    if (paramBitmap != null) {}
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 != 0)
      {
        this.r.b();
        a(paramBitmap, paramFloat, paramResult);
      }
      a(paramResult, paramBitmap);
      return;
    }
  }
  
  public Handler b()
  {
    return this.e;
  }
  
  CameraManager c()
  {
    return this.d;
  }
  
  public void d()
  {
    this.g.a();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().addFlags(128);
    Bundle localBundle = getIntent().getExtras();
    int i1 = R.layout.zxinglegacy_capture;
    if (localBundle != null) {
      i1 = localBundle.getInt("ZXINGLEGACY_CAPTURE_LAYOUT_ID_KEY", R.layout.zxinglegacy_capture);
    }
    setContentView(i1);
    this.k = false;
    this.q = new InactivityTimer(this);
    this.r = new BeepManager(this);
    this.s = new AmbientLightManager(this);
    PreferenceManager.setDefaultValues(this, R.xml.zxinglegacy_preferences, false);
    e();
    this.t = ((Button)findViewById(R.id.zxinglegacy_back_button));
    if (this.t != null) {
      this.t.setOnClickListener(new CaptureActivity.1(this));
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(R.menu.zxinglegacy_capture, paramMenu);
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  protected void onDestroy()
  {
    this.q.d();
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    switch (paramInt)
    {
    default: 
    case 27: 
    case 80: 
    case 4: 
      do
      {
        bool = super.onKeyDown(paramInt, paramKeyEvent);
        return bool;
        if (this.l == IntentSource.a)
        {
          setResult(0);
          finish();
          return bool;
        }
      } while (((this.l != IntentSource.d) && (this.l != IntentSource.c)) || (this.j == null));
      a(0L);
      return bool;
    case 25: 
      this.d.a(false);
      return bool;
    }
    this.d.a(bool);
    return bool;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.addFlags(524288);
    if (paramMenuItem.getItemId() == R.id.menu_help)
    {
      localIntent.setClassName(this, HelpActivity.class.getName());
      startActivity(localIntent);
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  protected void onPause()
  {
    if (this.e != null)
    {
      this.e.a();
      this.e = null;
    }
    this.q.b();
    this.s.a();
    this.d.b();
    if (!this.k) {
      ((SurfaceView)findViewById(R.id.zxinglegacy_preview_view)).getHolder().removeCallback(this);
    }
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    this.d = new CameraManager(getApplication());
    this.g = ((ViewfinderView)findViewById(R.id.zxinglegacy_viewfinder_view));
    this.g.setCameraManager(this.d);
    this.i = findViewById(R.id.zxinglegacy_result_view);
    this.h = ((TextView)findViewById(R.id.zxinglegacy_status_view));
    this.e = null;
    this.j = null;
    g();
    SurfaceHolder localSurfaceHolder = ((SurfaceView)findViewById(R.id.zxinglegacy_preview_view)).getHolder();
    Intent localIntent;
    String str2;
    if (this.k)
    {
      a(localSurfaceHolder);
      this.r.a();
      this.s.a(this.d);
      this.q.c();
      localIntent = getIntent();
      PreferenceManager.getDefaultSharedPreferences(this);
      this.l = IntentSource.d;
      this.n = null;
      this.p = null;
      if (localIntent != null)
      {
        String str1 = localIntent.getAction();
        str2 = localIntent.getDataString();
        if (!"com.google.zxing.client.android.SCAN".equals(str1)) {
          break label324;
        }
        this.l = IntentSource.a;
        this.n = DecodeFormatManager.a(localIntent);
        this.o = DecodeHintManager.a(localIntent);
        if ((localIntent.hasExtra("SCAN_WIDTH")) && (localIntent.hasExtra("SCAN_HEIGHT")))
        {
          int i1 = localIntent.getIntExtra("SCAN_WIDTH", 0);
          int i2 = localIntent.getIntExtra("SCAN_HEIGHT", 0);
          if ((i1 > 0) && (i2 > 0)) {
            this.d.a(i1, i2);
          }
        }
        String str3 = localIntent.getStringExtra("PROMPT_MESSAGE");
        if (str3 != null) {
          this.h.setText(str3);
        }
      }
    }
    for (;;)
    {
      this.p = localIntent.getStringExtra("CHARACTER_SET");
      return;
      localSurfaceHolder.addCallback(this);
      localSurfaceHolder.setType(3);
      break;
      label324:
      if ((str2 != null) && (str2.contains("http://www.google")) && (str2.contains("/m/products/scan")))
      {
        this.l = IntentSource.b;
        this.m = str2;
        this.n = DecodeFormatManager.a;
      }
      else if (a(str2))
      {
        this.l = IntentSource.c;
        this.m = str2;
        Uri localUri = Uri.parse(str2);
        this.n = DecodeFormatManager.a(localUri);
        this.o = DecodeHintManager.a(localUri);
      }
    }
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (paramSurfaceHolder == null) {
      Log.e(a, "*** WARNING *** surfaceCreated() gave us a null surface!");
    }
    if (!this.k)
    {
      this.k = true;
      a(paramSurfaceHolder);
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    this.k = false;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.androidlegacy.CaptureActivity
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */