package com.boohee.food.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import com.boohee.food.BaseActivity;

public abstract class BaseFragment
  extends Fragment
{
  public void a()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity != null) && ((localFragmentActivity instanceof BaseActivity))) {
      ((BaseActivity)localFragmentActivity).c();
    }
  }
  
  public void b()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity != null) && ((localFragmentActivity instanceof BaseActivity))) {
      ((BaseActivity)localFragmentActivity).d();
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.fragment.BaseFragment
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */