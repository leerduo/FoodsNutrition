package cn.sharesdk.framework.authorize;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import cn.sharesdk.framework.TitleLayout;
import cn.sharesdk.framework.utils.R;
import cn.sharesdk.framework.utils.e;

public class RegisterView
  extends ResizeLayout
{
  private TitleLayout a;
  private RelativeLayout b;
  private WebView c;
  private TextView d;
  
  public RegisterView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public RegisterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    setBackgroundColor(-1);
    setOrientation(1);
    int i = b(paramContext);
    this.a = new TitleLayout(paramContext);
    try
    {
      int k = R.getBitmapRes(paramContext, "ssdk_auth_title_back");
      this.a.setBackgroundResource(k);
      this.a.getBtnRight().setVisibility(8);
      int j = R.getStringRes(getContext(), "weibo_oauth_regiseter");
      this.a.getTvTitle().setText(j);
      addView(this.a);
      ImageView localImageView = new ImageView(paramContext);
      localImageView.setImageResource(R.getBitmapRes(paramContext, "ssdk_logo"));
      localImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      localImageView.setPadding(0, 0, R.dipToPx(paramContext, 10), 0);
      localImageView.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
      localImageView.setOnClickListener(new c(this));
      this.a.addView(localImageView);
      this.b = new RelativeLayout(paramContext);
      LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-1, 0);
      localLayoutParams1.weight = 1.0F;
      this.b.setLayoutParams(localLayoutParams1);
      addView(this.b);
      LinearLayout localLinearLayout = new LinearLayout(paramContext);
      localLinearLayout.setOrientation(1);
      localLinearLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
      this.b.addView(localLinearLayout);
      this.d = new TextView(paramContext);
      this.d.setLayoutParams(new LinearLayout.LayoutParams(-1, 5));
      this.d.setBackgroundColor(-12929302);
      localLinearLayout.addView(this.d);
      this.d.setVisibility(8);
      this.c = new WebView(paramContext);
      LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-1, -1);
      localLayoutParams2.weight = 1.0F;
      this.c.setLayoutParams(localLayoutParams2);
      d locald = new d(this, i);
      this.c.setWebChromeClient(locald);
      localLinearLayout.addView(this.c);
      this.c.requestFocus();
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        e.c(localThrowable);
      }
    }
  }
  
  private int b(Context paramContext)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    if (!(paramContext instanceof Activity)) {}
    WindowManager localWindowManager;
    do
    {
      return 0;
      localWindowManager = ((Activity)paramContext).getWindowManager();
    } while (localWindowManager == null);
    localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
    return localDisplayMetrics.widthPixels;
  }
  
  public View a()
  {
    return this.a.getBtnBack();
  }
  
  public void a(boolean paramBoolean)
  {
    TitleLayout localTitleLayout = this.a;
    if (paramBoolean) {}
    for (int i = 8;; i = 0)
    {
      localTitleLayout.setVisibility(i);
      return;
    }
  }
  
  public WebView b()
  {
    return this.c;
  }
  
  public TitleLayout c()
  {
    return this.a;
  }
  
  public RelativeLayout d()
  {
    return this.b;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.framework.authorize.RegisterView
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */