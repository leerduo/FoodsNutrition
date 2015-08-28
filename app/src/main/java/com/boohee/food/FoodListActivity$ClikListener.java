package com.boohee.food;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.boohee.food.util.PrefUtils;

class FoodListActivity$ClikListener
  implements View.OnClickListener
{
  private FoodListActivity$ClikListener(FoodListActivity paramFoodListActivity) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131427572: 
      this.a.finish();
      return;
    case 2131427447: 
      FoodListActivity.a(this.a).setVisibility(8);
      PrefUtils.a(true);
      return;
    }
    LightIntroduceActivity.a(this.a.a);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.FoodListActivity.ClikListener
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */