package com.boohee.food.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.boohee.food.DetailInfoActivity;
import com.boohee.food.adapter.FoodListAdapter;
import com.boohee.food.model.Food;
import com.boohee.food.volley.FoodRequest;
import java.util.ArrayList;
import java.util.List;

public class FoodListFragment
  extends BaseFragment
  implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener
{
  private ListView a;
  private List<Food> b = new ArrayList();
  private FoodListAdapter c;
  private String d;
  private int e;
  private int f = -1;
  private int g = 1;
  private int h = 1;
  private int i = 1;
  private int j = 1;
  private int k = 0;
  private int l = 0;
  
  public static FoodListFragment a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    FoodListFragment localFoodListFragment = new FoodListFragment();
    localFoodListFragment.d = paramString;
    localFoodListFragment.e = paramInt1;
    localFoodListFragment.f = paramInt2;
    localFoodListFragment.g = paramInt3;
    localFoodListFragment.h = paramInt4;
    return localFoodListFragment;
  }
  
  private void a(List<Food> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      if (this.i == 1)
      {
        this.b.clear();
        this.b.addAll(paramList);
        this.c = new FoodListAdapter(getActivity(), this.b);
        this.c.a(this.g);
        this.a.setAdapter(this.c);
        this.i = (1 + this.i);
      }
    }
    else {
      return;
    }
    this.b.addAll(paramList);
    this.c.notifyDataSetChanged();
    this.i = (1 + this.i);
  }
  
  private void c()
  {
    a();
    FoodRequest.a(d(), new FoodListFragment.1(this, getActivity()), getActivity());
  }
  
  private String d()
  {
    if (this.f == -1)
    {
      Object[] arrayOfObject2 = new Object[5];
      arrayOfObject2[0] = this.d;
      arrayOfObject2[1] = Integer.valueOf(this.e);
      arrayOfObject2[2] = Integer.valueOf(this.g);
      arrayOfObject2[3] = Integer.valueOf(this.i);
      arrayOfObject2[4] = Integer.valueOf(this.h);
      return String.format("/fb/v1/foods?kind=%1$s&value=%2$d&order_by=%3$s&page=%4$d&order_asc=%5$d", arrayOfObject2);
    }
    Object[] arrayOfObject1 = new Object[6];
    arrayOfObject1[0] = this.d;
    arrayOfObject1[1] = Integer.valueOf(this.e);
    arrayOfObject1[2] = Integer.valueOf(this.f);
    arrayOfObject1[3] = Integer.valueOf(this.g);
    arrayOfObject1[4] = Integer.valueOf(this.i);
    arrayOfObject1[5] = Integer.valueOf(this.h);
    return String.format("/fb/v1/foods?kind=%1$s&value=%2$d&sub_value=%3$d&order_by=%4$s&page=%5$d&order_asc=%6$d", arrayOfObject1);
  }
  
  public void a(int paramInt)
  {
    this.h = paramInt;
    this.i = 1;
    this.j = 1;
    this.k = 0;
    this.l = 0;
    this.b.clear();
    c();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903095, paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.b != null) {
      this.b.clear();
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    DetailInfoActivity.a(getActivity(), ((Food)this.b.get(paramInt)).code);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.k = (paramInt1 + paramInt2);
    this.l = paramInt3;
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (this.l == this.k) && (this.i <= 10) && (this.i > this.j))
    {
      this.j = this.i;
      c();
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.a = ((ListView)getView().findViewById(2131427568));
    this.a.setOnScrollListener(this);
    this.a.setOnItemClickListener(this);
    c();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.fragment.FoodListFragment
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */