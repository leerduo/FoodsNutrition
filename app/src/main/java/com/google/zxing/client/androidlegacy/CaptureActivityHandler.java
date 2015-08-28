package com.google.zxing.client.androidlegacy;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.Result;
import com.google.zxing.client.androidlegacy.camera.CameraManager;
import java.util.Collection;
import java.util.Map;

public final class CaptureActivityHandler
  extends Handler
{
  private static final String a = CaptureActivityHandler.class.getSimpleName();
  private final CaptureActivity b;
  private final DecodeThread c;
  private CaptureActivityHandler.State d;
  private final CameraManager e;
  
  CaptureActivityHandler(CaptureActivity paramCaptureActivity, Collection<BarcodeFormat> paramCollection, Map<DecodeHintType, ?> paramMap, String paramString, CameraManager paramCameraManager)
  {
    this.b = paramCaptureActivity;
    this.c = new DecodeThread(paramCaptureActivity, paramCollection, paramMap, paramString, new ViewfinderResultPointCallback(paramCaptureActivity.a()));
    this.c.start();
    this.d = CaptureActivityHandler.State.b;
    this.e = paramCameraManager;
    paramCameraManager.c();
    b();
  }
  
  private void b()
  {
    if (this.d == CaptureActivityHandler.State.b)
    {
      this.d = CaptureActivityHandler.State.a;
      this.e.a(this.c.a(), R.id.zxinglegacy_decode);
      this.b.d();
    }
  }
  
  public void a()
  {
    this.d = CaptureActivityHandler.State.c;
    this.e.d();
    Message.obtain(this.c.a(), R.id.zxinglegacy_quit).sendToTarget();
    try
    {
      this.c.join(500L);
      label40:
      removeMessages(R.id.zxinglegacy_decode_succeeded);
      removeMessages(R.id.zxinglegacy_decode_failed);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label40;
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == R.id.zxinglegacy_restart_preview)
    {
      Log.d(a, "Got restart preview message");
      b();
      return;
    }
    Bitmap localBitmap2;
    label94:
    float f;
    if (paramMessage.what == R.id.zxinglegacy_decode_succeeded)
    {
      Log.d(a, "Got decode succeeded message");
      this.d = CaptureActivityHandler.State.b;
      Bundle localBundle = paramMessage.getData();
      if (localBundle == null) {
        break label422;
      }
      byte[] arrayOfByte = localBundle.getByteArray("barcode_bitmap");
      if (arrayOfByte == null) {
        break label416;
      }
      localBitmap2 = BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length, null).copy(Bitmap.Config.ARGB_8888, true);
      f = localBundle.getFloat("barcode_scaled_factor");
    }
    for (Bitmap localBitmap1 = localBitmap2;; localBitmap1 = null)
    {
      this.b.a((Result)paramMessage.obj, localBitmap1, f);
      return;
      if (paramMessage.what == R.id.zxinglegacy_decode_failed)
      {
        this.d = CaptureActivityHandler.State.a;
        this.e.a(this.c.a(), R.id.zxinglegacy_decode);
        return;
      }
      if (paramMessage.what == R.id.zxinglegacy_return_scan_result)
      {
        Log.d(a, "Got return scan result message");
        this.b.setResult(-1, (Intent)paramMessage.obj);
        this.b.finish();
        return;
      }
      if (paramMessage.what != R.id.zxinglegacy_launch_product_query) {
        break;
      }
      Log.d(a, "Got product query message");
      String str1 = (String)paramMessage.obj;
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.addFlags(524288);
      localIntent.setData(Uri.parse(str1));
      ResolveInfo localResolveInfo = this.b.getPackageManager().resolveActivity(localIntent, 65536);
      ActivityInfo localActivityInfo = localResolveInfo.activityInfo;
      String str2 = null;
      if (localActivityInfo != null)
      {
        str2 = localResolveInfo.activityInfo.packageName;
        Log.d(a, "Using browser in package " + str2);
      }
      if (("com.android.browser".equals(str2)) || ("com.android.chrome".equals(str2)))
      {
        localIntent.setPackage(str2);
        localIntent.addFlags(268435456);
        localIntent.putExtra("com.android.browser.application_id", str2);
      }
      try
      {
        this.b.startActivity(localIntent);
        return;
      }
      catch (ActivityNotFoundException localActivityNotFoundException)
      {
        Log.w(a, "Can't find anything to handle VIEW of URI " + str1);
        return;
      }
      label416:
      localBitmap2 = null;
      break label94;
      label422:
      f = 1.0F;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.androidlegacy.CaptureActivityHandler
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */