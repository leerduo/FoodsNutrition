package com.boohee.food.adapter;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.boohee.food.fragment.IntroductionFragment;

public class IntroductionAdapter
  extends FragmentPagerAdapter
{
  private int[] a;
  
  public IntroductionAdapter(FragmentManager paramFragmentManager, int[] paramArrayOfInt)
  {
    super(paramFragmentManager);
    this.a = paramArrayOfInt;
  }
  
  public IntroductionFragment a(int paramInt)
  {
    int i = this.a[paramInt];
    if (paramInt + 1 == this.a.length) {}
    for (boolean bool = true;; bool = false) {
      return IntroductionFragment.a(i, bool);
    }
  }
  
  public int getCount()
  {
    return this.a.length;
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.adapter.IntroductionAdapter
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */