package com.boohee.food;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import com.boohee.food.model.Category;
import java.util.List;

class FoodListActivity$SpinnerItemSelectedListener
  implements AdapterView.OnItemSelectedListener
{
  private FoodListActivity$SpinnerItemSelectedListener(FoodListActivity paramFoodListActivity) {}
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    FoodListActivity.a(this.a, paramView);
    if (paramInt > 0) {
      FoodListActivity.a(this.a, ((Category)FoodListActivity.b(this.a).sub_categories.get(paramInt - 1)).id);
    }
    for (;;)
    {
      FoodListActivity.c(this.a);
      return;
      FoodListActivity.a(this.a, -1);
    }
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.FoodListActivity.SpinnerItemSelectedListener
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */