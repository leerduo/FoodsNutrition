package com.boohee.food.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.boohee.food.model.Food;
import com.boohee.food.util.FoodUtils;
import java.util.List;

public class SearchListAdapter
  extends SimpleBaseAdapter<Food>
{
  public SearchListAdapter(Context paramContext, List<Food> paramList)
  {
    super(paramContext, paramList);
  }
  
  public int a()
  {
    return 2130903112;
  }
  
  public View a(int paramInt, View paramView, SimpleBaseAdapter<Food>.ViewHolder paramSimpleBaseAdapter)
  {
    Food localFood = (Food)getItem(paramInt);
    if (paramView == null) {
      return paramView;
    }
    TextView localTextView1 = (TextView)paramSimpleBaseAdapter.a(2131427581);
    TextView localTextView2 = (TextView)paramSimpleBaseAdapter.a(2131427429);
    TextView localTextView3 = (TextView)paramSimpleBaseAdapter.a(2131427587);
    ImageView localImageView = (ImageView)paramSimpleBaseAdapter.a(2131427435);
    localTextView1.setText(localFood.name);
    localTextView2.setText(FoodUtils.a(localFood.calory, false));
    localTextView3.setText(FoodUtils.a(localFood.weight, localFood.is_liquid, false));
    FoodUtils.a(localFood.health_light, localImageView);
    return paramView;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.adapter.SearchListAdapter
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */