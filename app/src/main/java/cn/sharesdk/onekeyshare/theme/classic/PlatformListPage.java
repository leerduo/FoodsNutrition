package cn.sharesdk.onekeyshare.theme.classic;

import android.app.Activity;
import android.content.res.Configuration;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import cn.sharesdk.R.drawable;
import cn.sharesdk.framework.utils.R;
import cn.sharesdk.onekeyshare.PlatformListFakeActivity;
import java.util.ArrayList;

public class PlatformListPage
  extends PlatformListFakeActivity
  implements View.OnClickListener
{
  private Animation animHide;
  private Animation animShow;
  private Button btnCancel;
  private boolean finishing;
  private FrameLayout flPage;
  private PlatformGridView grid;
  
  private void initAnim()
  {
    this.animShow = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    this.animShow.setDuration(300L);
    this.animHide = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.0F);
    this.animHide.setDuration(300L);
  }
  
  private void initPageView()
  {
    this.flPage = new FrameLayout(getContext());
    this.flPage.setOnClickListener(this);
    this.flPage.setBackgroundColor(0);
    PlatformListPage.1 local1 = new PlatformListPage.1(this, getContext());
    local1.setOrientation(1);
    if (R.getBitmapRes(getContext(), "share_vp_back") > 0) {
      local1.setBackgroundColor(-1);
    }
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
    localLayoutParams.gravity = 80;
    local1.setLayoutParams(localLayoutParams);
    this.flPage.addView(local1);
    this.grid = new PlatformGridView(getContext());
    this.grid.setEditPageBackground(getBackgroundView());
    LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-1, -2);
    this.grid.setLayoutParams(localLayoutParams1);
    local1.addView(this.grid);
    View localView = new View(getContext());
    localView.setBackgroundColor(-7829368);
    local1.addView(localView, new ViewGroup.LayoutParams(-1, 1));
    this.btnCancel = new Button(getContext());
    this.btnCancel.setTextColor(-65536);
    this.btnCancel.setTextSize(1, 20.0F);
    int i = R.getStringRes(getContext(), "cancel");
    if (i > 0) {
      this.btnCancel.setText(i);
    }
    this.btnCancel.setPadding(0, 0, 0, R.dipToPx(getContext(), 5));
    if (R.getBitmapRes(getContext(), "btn_cancel_back") > 0) {
      this.btnCancel.setBackgroundResource(R.drawable.bg_button_selector);
    }
    LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-1, R.dipToPx(getContext(), 45));
    this.btnCancel.setLayoutParams(localLayoutParams2);
    local1.addView(this.btnCancel);
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.equals(this.flPage)) || (paramView.equals(this.btnCancel)))
    {
      setCanceled(true);
      finish();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (this.grid != null) {
      this.grid.onConfigurationChanged();
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.finishing = false;
    initPageView();
    initAnim();
    this.activity.setContentView(this.flPage);
    this.grid.setData(this.shareParamsMap, this.silent);
    this.grid.setHiddenPlatforms(this.hiddenPlatforms);
    this.grid.setCustomerLogos(this.customerLogos);
    this.grid.setParent(this);
    this.btnCancel.setOnClickListener(this);
    this.flPage.clearAnimation();
    this.flPage.startAnimation(this.animShow);
  }
  
  public boolean onFinish()
  {
    if (this.finishing) {
      return super.onFinish();
    }
    if (this.animHide == null)
    {
      this.finishing = true;
      return false;
    }
    this.finishing = true;
    this.animHide.setAnimationListener(new PlatformListPage.2(this));
    this.flPage.clearAnimation();
    this.flPage.startAnimation(this.animHide);
    return true;
  }
  
  public void onPlatformIconClick(View paramView, ArrayList<Object> paramArrayList)
  {
    onShareButtonClick(paramView, paramArrayList);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.onekeyshare.theme.classic.PlatformListPage
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */