package cn.sharesdk.framework;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import cn.sharesdk.framework.utils.R;
import cn.sharesdk.framework.utils.UIHandler;
import java.util.HashMap;

public class FakeActivity
{
  private static Class<? extends ShareSDKUIShell> shell;
  protected Activity activity;
  private View contentView;
  private HashMap<String, Object> result;
  private FakeActivity resultReceiver;
  
  public static void setShell(Class<? extends ShareSDKUIShell> paramClass)
  {
    shell = paramClass;
  }
  
  public View findViewById(int paramInt)
  {
    if (this.activity == null) {
      return null;
    }
    return this.activity.findViewById(paramInt);
  }
  
  public View findViewByResName(View paramView, String paramString)
  {
    if (this.activity == null) {}
    int i;
    do
    {
      return null;
      i = R.getIdRes(this.activity, paramString);
    } while (i <= 0);
    return paramView.findViewById(i);
  }
  
  public View findViewByResName(String paramString)
  {
    if (this.activity == null) {}
    int i;
    do
    {
      return null;
      i = R.getIdRes(this.activity, paramString);
    } while (i <= 0);
    return findViewById(i);
  }
  
  public final void finish()
  {
    if (this.activity != null) {
      this.activity.finish();
    }
  }
  
  public View getContentView()
  {
    return this.contentView;
  }
  
  public Context getContext()
  {
    if (this.activity == null) {
      return null;
    }
    return this.activity;
  }
  
  public int getOrientation()
  {
    return this.activity.getResources().getConfiguration().orientation;
  }
  
  public FakeActivity getParent()
  {
    return this.resultReceiver;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void onCreate() {}
  
  public void onDestroy() {}
  
  public boolean onFinish()
  {
    return false;
  }
  
  public boolean onKeyEvent(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  protected void onNewIntent(Intent paramIntent) {}
  
  public void onPause() {}
  
  public void onRestart() {}
  
  public void onResult(HashMap<String, Object> paramHashMap) {}
  
  public void onResume() {}
  
  public void onStart() {}
  
  public void onStop() {}
  
  public void requestFullScreen(boolean paramBoolean)
  {
    if (this.activity == null) {
      return;
    }
    if (paramBoolean)
    {
      this.activity.getWindow().addFlags(1024);
      this.activity.getWindow().clearFlags(2048);
    }
    for (;;)
    {
      this.activity.getWindow().getDecorView().requestLayout();
      return;
      this.activity.getWindow().addFlags(2048);
      this.activity.getWindow().clearFlags(1024);
    }
  }
  
  public void requestLandscapeOrientation()
  {
    setRequestedOrientation(0);
  }
  
  public void requestPortraitOrientation()
  {
    setRequestedOrientation(1);
  }
  
  public void runOnUIThread(Runnable paramRunnable)
  {
    UIHandler.sendEmptyMessage(0, new b(this, paramRunnable));
  }
  
  public void runOnUIThread(Runnable paramRunnable, long paramLong)
  {
    UIHandler.sendEmptyMessageDelayed(0, paramLong, new c(this, paramRunnable));
  }
  
  void sendResult()
  {
    if (this.resultReceiver != null) {
      this.resultReceiver.onResult(this.result);
    }
  }
  
  public void setActivity(Activity paramActivity)
  {
    this.activity = paramActivity;
  }
  
  final void setContentView(View paramView)
  {
    this.contentView = paramView;
  }
  
  public void setContentViewLayoutResName(String paramString)
  {
    if (this.activity == null) {}
    int i;
    do
    {
      return;
      i = R.getLayoutRes(this.activity, paramString);
    } while (i <= 0);
    this.activity.setContentView(i);
  }
  
  public void setRequestedOrientation(int paramInt)
  {
    if (this.activity == null) {
      return;
    }
    this.activity.setRequestedOrientation(paramInt);
  }
  
  public final void setResult(HashMap<String, Object> paramHashMap)
  {
    this.result = paramHashMap;
  }
  
  public void show(Context paramContext, Intent paramIntent)
  {
    showForResult(paramContext, paramIntent, null);
  }
  
  public void showForResult(Context paramContext, Intent paramIntent, FakeActivity paramFakeActivity)
  {
    this.resultReceiver = paramFakeActivity;
    Message localMessage = new Message();
    if (shell == null) {}
    for (Object localObject = ShareSDKUIShell.class;; localObject = shell)
    {
      Intent localIntent = new Intent(paramContext, (Class)localObject);
      localIntent.putExtra("launch_time", ShareSDKUIShell.a(this));
      if (paramIntent != null) {
        localIntent.putExtras(paramIntent);
      }
      localMessage.obj = new Object[] { paramContext, localIntent };
      UIHandler.sendMessage(localMessage, new a(this));
      return;
    }
  }
  
  public void startActivity(Intent paramIntent)
  {
    startActivityForResult(paramIntent, -1);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    if (this.activity == null) {
      return;
    }
    this.activity.startActivityForResult(paramIntent, paramInt);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.framework.FakeActivity
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */