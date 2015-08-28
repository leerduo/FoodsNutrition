package com.boohee.food.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import java.util.List;

public class HotListAdapter
  extends SimpleBaseAdapter<String>
{
  public HotListAdapter(Context paramContext, List<String> paramList)
  {
    super(paramContext, paramList);
  }
  
  public int a()
  {
    return 2130903111;
  }
  
  public View a(int paramInt, View paramView, SimpleBaseAdapter<String>.ViewHolder paramSimpleBaseAdapter)
  {
    TextView localTextView = (TextView)paramSimpleBaseAdapter.a(2131427572);
    if (!TextUtils.isEmpty((CharSequence)this.b.get(paramInt))) {
      localTextView.setText((CharSequence)this.b.get(paramInt));
    }
    return paramView;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.adapter.HotListAdapter
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */