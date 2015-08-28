package com.boohee.food.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.boohee.food.util.LogUtils;

public class BooheeListView
  extends ListView
  implements AbsListView.OnScrollListener
{
  private boolean a;
  private BooheeListView.OnLoadMoreListener b;
  
  public BooheeListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOnScrollListener(this);
  }
  
  private void a()
  {
    if ((this.b != null) && (!this.a)) {
      this.b.a();
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = Integer.valueOf(paramInt1);
    arrayOfObject[1] = Integer.valueOf(paramInt2);
    arrayOfObject[2] = Integer.valueOf(paramInt3);
    LogUtils.a(String.format("onScroll: %d | %d | %d", arrayOfObject));
    if ((paramInt1 + paramInt2 == paramInt3) && (paramInt3 > 0))
    {
      a();
      this.a = true;
      return;
    }
    this.a = false;
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
  
  public void setOnLoadMoreListener(BooheeListView.OnLoadMoreListener paramOnLoadMoreListener)
  {
    this.b = paramOnLoadMoreListener;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.view.BooheeListView
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */