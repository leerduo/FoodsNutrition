package com.boohee.food;

import com.astuetz.PagerSlidingTabStrip.OnTabClickListener;
import com.boohee.food.fragment.FoodListFragment;
import java.util.List;

class FoodListActivity$2
  implements PagerSlidingTabStrip.OnTabClickListener
{
  FoodListActivity$2(FoodListActivity paramFoodListActivity) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    ((FoodListFragment)FoodListActivity.d(this.a).get(paramInt1)).a(paramInt2);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.FoodListActivity.2
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */