package com.boohee.food.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import com.boohee.food.model.Banner;
import com.boohee.food.util.ImageLoader;
import java.util.List;

class HomeFragment$2
  implements SwipeRefreshLayout.OnRefreshListener
{
  HomeFragment$2(HomeFragment paramHomeFragment) {}
  
  public void onRefresh()
  {
    this.a.e.setRefreshing(false);
    if ((HomeFragment.b(this.a) != null) && (HomeFragment.b(this.a).size() > 0))
    {
      if (HomeFragment.c() >= HomeFragment.b(this.a).size()) {
        HomeFragment.a(0);
      }
      HomeFragment.a(this.a, (Banner)HomeFragment.b(this.a).get(HomeFragment.d()));
      ImageLoader.c(this.a.d, HomeFragment.a(this.a).image_url);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.fragment.HomeFragment.2
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */