package com.boohee.food.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.boohee.food.DetailInfoActivity;
import com.boohee.food.model.Banner;
import com.umeng.analytics.MobclickAgent;

class HomeFragment$1
  implements View.OnClickListener
{
  HomeFragment$1(HomeFragment paramHomeFragment) {}
  
  public void onClick(View paramView)
  {
    if (HomeFragment.a(this.a) != null) {
      DetailInfoActivity.a(this.a.getActivity(), HomeFragment.a(this.a).food_code);
    }
    for (;;)
    {
      MobclickAgent.onEvent(this.a.getActivity(), "click_home_cover");
      return;
      DetailInfoActivity.a(this.a.getActivity(), "yingtao");
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.fragment.HomeFragment.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */