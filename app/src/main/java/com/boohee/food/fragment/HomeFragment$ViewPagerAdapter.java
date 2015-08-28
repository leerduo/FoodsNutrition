package com.boohee.food.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.boohee.food.model.Topic;
import java.util.List;

class HomeFragment$ViewPagerAdapter
  extends FragmentPagerAdapter
{
  public HomeFragment$ViewPagerAdapter(HomeFragment paramHomeFragment, FragmentManager paramFragmentManager)
  {
    super(paramFragmentManager);
  }
  
  public int getCount()
  {
    if (HomeFragment.f(this.a) == null) {
      return 0;
    }
    return HomeFragment.f(this.a).size();
  }
  
  public Fragment getItem(int paramInt)
  {
    return HomeItemFragment.a((Topic)HomeFragment.f(this.a).get(paramInt));
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.fragment.HomeFragment.ViewPagerAdapter
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */