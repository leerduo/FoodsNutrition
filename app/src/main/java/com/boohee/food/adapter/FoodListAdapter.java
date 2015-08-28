package com.boohee.food.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.boohee.food.FoodApplication;
import com.boohee.food.model.Food;
import com.boohee.food.util.FoodUtils;
import com.boohee.food.util.ImageLoader;
import de.hdodenhof.circleimageview.CircleImageView;
import java.util.List;

public class FoodListAdapter
  extends SimpleBaseAdapter<Food>
{
  private int c;
  
  public FoodListAdapter(Context paramContext, List<Food> paramList)
  {
    super(paramContext, paramList);
  }
  
  public int a()
  {
    return 2130903106;
  }
  
  public View a(int paramInt, View paramView, SimpleBaseAdapter<Food>.ViewHolder paramSimpleBaseAdapter)
  {
    Food localFood = (Food)getItem(paramInt);
    if (localFood == null) {
      return paramView;
    }
    CircleImageView localCircleImageView = (CircleImageView)paramSimpleBaseAdapter.a(2131427585);
    TextView localTextView1 = (TextView)paramSimpleBaseAdapter.a(2131427581);
    TextView localTextView2 = (TextView)paramSimpleBaseAdapter.a(2131427429);
    TextView localTextView3 = (TextView)paramSimpleBaseAdapter.a(2131427587);
    ImageView localImageView = (ImageView)paramSimpleBaseAdapter.a(2131427435);
    ImageLoader.d(localCircleImageView, localFood.thumb_image_url);
    localTextView1.setText(localFood.name);
    String str1 = "";
    switch (this.c)
    {
    }
    String str2;
    String str3;
    for (;;)
    {
      localTextView2.setText(str1);
      str2 = FoodApplication.a().getString(2131558470);
      str3 = "";
      switch (this.c)
      {
      default: 
        localTextView3.setText(str3);
        FoodUtils.a(localFood.health_light, localImageView);
        return paramView;
        if (TextUtils.isEmpty(localFood.calory))
        {
          str1 = "0.0";
        }
        else
        {
          str1 = localFood.calory;
          continue;
          if (TextUtils.isEmpty(localFood.protein))
          {
            str1 = "0.0";
          }
          else
          {
            str1 = localFood.protein;
            continue;
            if (TextUtils.isEmpty(localFood.fat))
            {
              str1 = "0.0";
            }
            else
            {
              str1 = localFood.fat;
              continue;
              if (TextUtils.isEmpty(localFood.fiber_dietary)) {
                str1 = "0.0";
              } else {
                str1 = localFood.fiber_dietary;
              }
            }
          }
        }
        break;
      }
    }
    Object[] arrayOfObject2 = new Object[3];
    arrayOfObject2[0] = "大卡";
    arrayOfObject2[1] = localFood.weight;
    if (localFood.is_liquid) {}
    for (String str5 = "毫升";; str5 = "克")
    {
      arrayOfObject2[2] = str5;
      str3 = String.format(str2, arrayOfObject2);
      break;
    }
    Object[] arrayOfObject1 = new Object[3];
    arrayOfObject1[0] = "克";
    arrayOfObject1[1] = localFood.weight;
    if (localFood.is_liquid) {}
    for (String str4 = "毫升";; str4 = "克")
    {
      arrayOfObject1[2] = str4;
      str3 = String.format(str2, arrayOfObject1);
      break;
    }
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.adapter.FoodListAdapter
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */