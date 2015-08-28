package com.boohee.food.adapter;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.boohee.food.model.Food;
import com.boohee.food.util.FoodUtils;
import com.boohee.food.util.ImageLoader;
import de.hdodenhof.circleimageview.CircleImageView;
import java.util.List;

public class CollectionAdapter
  extends SimpleBaseAdapter<Food>
{
  private List<Boolean> c;
  private boolean d;
  
  public CollectionAdapter(Context paramContext, List<Food> paramList, List<Boolean> paramList1)
  {
    super(paramContext, paramList);
    this.c = paramList1;
  }
  
  public int a()
  {
    return 2130903104;
  }
  
  public View a(int paramInt, View paramView, SimpleBaseAdapter<Food>.ViewHolder paramSimpleBaseAdapter)
  {
    Food localFood = (Food)getItem(paramInt);
    if (localFood == null) {
      return paramView;
    }
    ImageLoader.d((CircleImageView)paramSimpleBaseAdapter.a(2131427585), localFood.thumb_image_url);
    ((TextView)paramSimpleBaseAdapter.a(2131427581)).setText(localFood.name);
    ((TextView)paramSimpleBaseAdapter.a(2131427429)).setText(FoodUtils.a(localFood.calory, false));
    ((TextView)paramSimpleBaseAdapter.a(2131427587)).setText(FoodUtils.a(localFood.weight, localFood.is_liquid, false));
    ImageView localImageView = (ImageView)paramSimpleBaseAdapter.a(2131427435);
    FoodUtils.a(localFood.health_light, localImageView);
    CheckBox localCheckBox = (CheckBox)paramSimpleBaseAdapter.a(2131427588);
    localCheckBox.setChecked(((Boolean)this.c.get(paramInt)).booleanValue());
    if (this.d)
    {
      localCheckBox.setVisibility(0);
      localImageView.setVisibility(8);
      localCheckBox.setOnCheckedChangeListener(new CollectionAdapter.1(this, paramInt));
      return paramView;
    }
    localCheckBox.setVisibility(8);
    localImageView.setVisibility(0);
    return paramView;
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
    notifyDataSetChanged();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.adapter.CollectionAdapter
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */