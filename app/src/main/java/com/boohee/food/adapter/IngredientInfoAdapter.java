package com.boohee.food.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.boohee.food.model.IngredientInfo;
import java.util.List;

public class IngredientInfoAdapter
  extends SimpleBaseAdapter<IngredientInfo>
{
  public IngredientInfoAdapter(Context paramContext, List<IngredientInfo> paramList)
  {
    super(paramContext, paramList);
  }
  
  public int a()
  {
    return 2130903108;
  }
  
  public View a(int paramInt, View paramView, SimpleBaseAdapter<IngredientInfo>.ViewHolder paramSimpleBaseAdapter)
  {
    IngredientInfo localIngredientInfo = (IngredientInfo)getItem(paramInt);
    if (localIngredientInfo == null) {
      return paramView;
    }
    ((TextView)paramSimpleBaseAdapter.a(2131427581)).setText(localIngredientInfo.name);
    TextView localTextView = (TextView)paramSimpleBaseAdapter.a(2131427590);
    if ("--".equals(localIngredientInfo.value)) {
      localTextView.setText(localIngredientInfo.value);
    }
    for (;;)
    {
      ((TextView)paramSimpleBaseAdapter.a(2131427591)).setText(localIngredientInfo.memo);
      return paramView;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = localIngredientInfo.value;
      arrayOfObject[1] = localIngredientInfo.unit;
      localTextView.setText(String.format("%s %s", arrayOfObject));
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.adapter.IngredientInfoAdapter
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */