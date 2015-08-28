package com.boohee.food.fragment;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class LoadingFragment
  extends DialogFragment
{
  public static LoadingFragment a()
  {
    LoadingFragment localLoadingFragment = new LoadingFragment();
    localLoadingFragment.setStyle(2, 0);
    return localLoadingFragment;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903100, paramViewGroup, false);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.fragment.LoadingFragment
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */