package com.boohee.food;

import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import com.boohee.food.model.FoodInfo;
import com.boohee.food.util.FoodUtils;

class DetailInfoActivity$2
  implements RadioGroup.OnCheckedChangeListener
{
  DetailInfoActivity$2(DetailInfoActivity paramDetailInfoActivity) {}
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    FoodUtils.a();
    this.a.d.setText(FoodUtils.a(DetailInfoActivity.a(this.a).calory, true));
    this.a.e.setText(FoodUtils.a(DetailInfoActivity.a(this.a).weight, DetailInfoActivity.a(this.a).is_liquid, true));
    DetailInfoActivity.b(this.a);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.DetailInfoActivity.2
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */