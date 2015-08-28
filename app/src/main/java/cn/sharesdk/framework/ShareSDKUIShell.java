package cn.sharesdk.framework;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import cn.sharesdk.framework.utils.e;
import java.util.HashMap;

public class ShareSDKUIShell
  extends Activity
{
  private static HashMap<String, FakeActivity> a = new HashMap();
  private FakeActivity b;
  
  public static String a(FakeActivity paramFakeActivity)
  {
    return a(String.valueOf(System.currentTimeMillis()), paramFakeActivity);
  }
  
  public static String a(String paramString, FakeActivity paramFakeActivity)
  {
    a.put(paramString, paramFakeActivity);
    return paramString;
  }
  
  public void finish()
  {
    if ((this.b != null) && (this.b.onFinish())) {
      return;
    }
    super.finish();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.b != null) {
      this.b.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.b != null) {
      this.b.onConfigurationChanged(paramConfiguration);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    Intent localIntent = getIntent();
    String str1 = localIntent.getStringExtra("launch_time");
    this.b = ((FakeActivity)a.remove(str1));
    if (this.b == null)
    {
      String str2 = localIntent.getScheme();
      this.b = ((FakeActivity)a.remove(str2));
      if (this.b == null)
      {
        e.c(new RuntimeException("Executor lost! launchTime = " + str1));
        super.onCreate(paramBundle);
        finish();
        return;
      }
    }
    e.b("ShareSDKUIShell found executor: " + this.b.getClass(), new Object[0]);
    this.b.setActivity(this);
    super.onCreate(paramBundle);
    this.b.onCreate();
  }
  
  protected void onDestroy()
  {
    if (this.b != null)
    {
      this.b.sendResult();
      this.b.onDestroy();
    }
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    FakeActivity localFakeActivity = this.b;
    boolean bool = false;
    if (localFakeActivity != null) {
      bool = this.b.onKeyEvent(paramInt, paramKeyEvent);
    }
    if (bool) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    FakeActivity localFakeActivity = this.b;
    boolean bool = false;
    if (localFakeActivity != null) {
      bool = this.b.onKeyEvent(paramInt, paramKeyEvent);
    }
    if (bool) {
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    if (this.b == null)
    {
      super.onNewIntent(paramIntent);
      return;
    }
    this.b.onNewIntent(paramIntent);
  }
  
  protected void onPause()
  {
    if (this.b != null) {
      this.b.onPause();
    }
    super.onPause();
  }
  
  protected void onRestart()
  {
    if (this.b != null) {
      this.b.onRestart();
    }
    super.onRestart();
  }
  
  protected void onResume()
  {
    if (this.b != null) {
      this.b.onResume();
    }
    super.onResume();
  }
  
  protected void onStart()
  {
    if (this.b != null) {
      this.b.onStart();
    }
    super.onStart();
  }
  
  protected void onStop()
  {
    if (this.b != null) {
      this.b.onStop();
    }
    super.onStop();
  }
  
  public void setContentView(int paramInt)
  {
    setContentView(LayoutInflater.from(this).inflate(paramInt, null));
  }
  
  public void setContentView(View paramView)
  {
    super.setContentView(paramView);
    if (this.b != null) {
      this.b.setContentView(paramView);
    }
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.setContentView(paramView, paramLayoutParams);
    if (this.b != null) {
      this.b.setContentView(paramView);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.framework.ShareSDKUIShell
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */