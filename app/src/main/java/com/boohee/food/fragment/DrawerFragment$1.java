package com.boohee.food.fragment;

import android.app.Activity;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.view.View;

class DrawerFragment$1
  extends ActionBarDrawerToggle
{
  DrawerFragment$1(DrawerFragment paramDrawerFragment, Activity paramActivity, DrawerLayout paramDrawerLayout, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramActivity, paramDrawerLayout, paramInt1, paramInt2, paramInt3);
  }
  
  public void onDrawerClosed(View paramView)
  {
    super.onDrawerClosed(paramView);
    if (!this.a.isAdded()) {
      return;
    }
    this.a.getActivity().invalidateOptionsMenu();
  }
  
  public void onDrawerOpened(View paramView)
  {
    super.onDrawerOpened(paramView);
    DrawerFragment.a(this.a);
    if (this.a.isAdded()) {
      this.a.getActivity().invalidateOptionsMenu();
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.fragment.DrawerFragment.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */