package com.boohee.food.fragment;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.boohee.food.AuthActivity;
import com.boohee.food.CategoryActivity;
import com.boohee.food.LargeImageActivity;
import com.boohee.food.MoreActivity;
import com.boohee.food.MyActivity;
import com.boohee.food.util.AccountUtils;
import com.boohee.food.util.ImageLoader;
import com.umeng.analytics.MobclickAgent;
import de.hdodenhof.circleimageview.CircleImageView;

public class DrawerFragment
  extends BaseFragment
{
  CircleImageView a;
  TextView b;
  private ActionBarDrawerToggle c;
  private DrawerLayout d;
  private View e;
  
  private void d()
  {
    if (AccountUtils.d())
    {
      ImageLoader.a(this.a, AccountUtils.f());
      this.b.setText(AccountUtils.e());
      return;
    }
    ImageLoader.a(this.a, 2130837633, 2130837633);
    this.b.setText(getString(2131558502));
  }
  
  public void a(int paramInt, DrawerLayout paramDrawerLayout)
  {
    this.e = getActivity().findViewById(paramInt);
    this.d = paramDrawerLayout;
    this.d.setDrawerShadow(2130837575, 8388611);
    this.c = new DrawerFragment.1(this, getActivity(), this.d, 2130837603, 2131558543, 2131558542);
    this.d.post(new DrawerFragment.2(this));
    this.d.setScrimColor(0);
    this.d.setDrawerListener(this.c);
  }
  
  public void a(RelativeLayout paramRelativeLayout)
  {
    switch (paramRelativeLayout.getId())
    {
    default: 
      return;
    case 2131427550: 
      CategoryActivity.a(getActivity(), "group");
      return;
    case 2131427556: 
      CategoryActivity.a(getActivity(), "brand");
      return;
    case 2131427559: 
      CategoryActivity.a(getActivity(), "restaurant");
      return;
    case 2131427553: 
      CategoryActivity.a(getActivity(), "cooking");
      return;
    case 2131427562: 
      CategoryActivity.a(getActivity(), "season");
      return;
    }
    MoreActivity.a(getActivity());
  }
  
  public boolean c()
  {
    if (AccountUtils.d()) {
      LargeImageActivity.a(getActivity(), AccountUtils.e(), AccountUtils.f());
    }
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    MobclickAgent.onEvent(getActivity(), "click_login");
    if (AccountUtils.d())
    {
      MyActivity.a(getActivity());
      return;
    }
    AuthActivity.a(getActivity());
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.c.onConfigurationChanged(paramConfiguration);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903094, paramViewGroup, false);
    ButterKnife.a(this, localView);
    d();
    return localView;
  }
  
  public void onResume()
  {
    super.onResume();
    d();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.fragment.DrawerFragment
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */