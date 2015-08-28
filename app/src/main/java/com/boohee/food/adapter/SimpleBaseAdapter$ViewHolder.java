package com.boohee.food.adapter;

import android.util.SparseArray;
import android.view.View;

public class SimpleBaseAdapter$ViewHolder
{
  private SparseArray<View> b = new SparseArray();
  private View c;
  
  public SimpleBaseAdapter$ViewHolder(SimpleBaseAdapter paramSimpleBaseAdapter, View paramView)
  {
    this.c = paramView;
  }
  
  public <V extends View> V a(int paramInt)
  {
    View localView = (View)this.b.get(paramInt);
    if (localView == null)
    {
      localView = this.c.findViewById(paramInt);
      this.b.put(paramInt, localView);
    }
    return localView;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.adapter.SimpleBaseAdapter.ViewHolder
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */