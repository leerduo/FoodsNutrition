package com.boohee.food;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.boohee.food.util.SystemUtils;
import com.boohee.food.util.ToastUtils;

public class MoreActivity
  extends BaseActivity
{
  TextView b;
  
  private void a()
  {
    try
    {
      Intent localIntent = new Intent();
      localIntent.setAction("android.intent.action.VIEW");
      localIntent.setData(Uri.parse("market://details?id=" + getPackageName()));
      startActivity(localIntent);
      return;
    }
    catch (Exception localException)
    {
      ToastUtils.b(getString(2131558530));
      localException.printStackTrace();
    }
  }
  
  public static void a(Context paramContext)
  {
    paramContext.startActivity(new Intent(paramContext, MoreActivity.class));
  }
  
  private void b()
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("\n\n\n\n\n");
      localStringBuilder.append("以下信息有助于我们更好的了解您的问题：");
      localStringBuilder.append("\nAPP版本：" + SystemUtils.a(this));
      localStringBuilder.append("\n手机品牌：" + Build.BRAND);
      localStringBuilder.append("\n手机型号：" + Build.MODEL);
      localStringBuilder.append("\n系统版本：" + Build.VERSION.RELEASE + "(" + Build.VERSION.SDK_INT + ")");
      Intent localIntent = new Intent("android.intent.action.SENDTO", Uri.parse("mailto:" + getString(2131558527)));
      localIntent.putExtra("android.intent.extra.SUBJECT", getString(2131558529));
      localIntent.putExtra("android.intent.extra.TEXT", localStringBuilder.toString());
      startActivity(localIntent);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      ToastUtils.b(getString(2131558528));
      localActivityNotFoundException.printStackTrace();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131427479: 
      b();
      return;
    case 2131427480: 
      a();
      return;
    }
    AboutActivity.a(this);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903081);
    ButterKnife.a(this);
    this.b.setText("V " + SystemUtils.a(this));
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.MoreActivity
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */