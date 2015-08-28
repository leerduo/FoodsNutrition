package com.boohee.food.fragment;

import android.support.v4.view.ViewPager.PageTransformer;
import android.view.View;

public class HomeFragment$RotatePageTransformer
  implements ViewPager.PageTransformer
{
  private static float a = 50.0F;
  private static int b = 15;
  
  public void transformPage(View paramView, float paramFloat)
  {
    float f1;
    float f2;
    if (paramFloat <= 1.0F)
    {
      f1 = paramFloat * b;
      f2 = paramFloat * a;
      if (paramFloat <= 0.0F) {
        break label38;
      }
      paramView.setTranslationY(f2);
    }
    for (;;)
    {
      paramView.setRotation(f1);
      return;
      label38:
      paramView.setTranslationY(-f2);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.fragment.HomeFragment.RotatePageTransformer
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */