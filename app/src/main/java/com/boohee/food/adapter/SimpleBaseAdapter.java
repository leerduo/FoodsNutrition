package com.boohee.food.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.List;

public abstract class SimpleBaseAdapter<T>
  extends BaseAdapter
{
  protected final Context a;
  protected final List<T> b;
  
  public SimpleBaseAdapter(Context paramContext, List<T> paramList)
  {
    this.a = paramContext;
    if (paramList == null) {
      paramList = new ArrayList();
    }
    this.b = paramList;
  }
  
  public abstract int a();
  
  public abstract View a(int paramInt, View paramView, SimpleBaseAdapter<T>.ViewHolder paramSimpleBaseAdapter);
  
  public int getCount()
  {
    return this.b.size();
  }
  
  public T getItem(int paramInt)
  {
    if (paramInt >= this.b.size()) {
      return null;
    }
    return this.b.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    SimpleBaseAdapter.ViewHolder localViewHolder;
    if (paramView == null)
    {
      paramView = View.inflate(this.a, a(), null);
      localViewHolder = new SimpleBaseAdapter.ViewHolder(this, paramView);
      paramView.setTag(localViewHolder);
    }
    for (;;)
    {
      return a(paramInt, paramView, localViewHolder);
      localViewHolder = (SimpleBaseAdapter.ViewHolder)paramView.getTag();
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.adapter.SimpleBaseAdapter
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */