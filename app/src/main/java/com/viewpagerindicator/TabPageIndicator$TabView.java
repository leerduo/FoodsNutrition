package com.viewpagerindicator;

import android.content.Context;
import android.view.View.MeasureSpec;
import android.widget.TextView;

class TabPageIndicator$TabView
  extends TextView
{
  private int b;
  
  public TabPageIndicator$TabView(TabPageIndicator paramTabPageIndicator, Context paramContext)
  {
    super(paramContext, null, R.attr.vpiTabPageIndicatorStyle);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if ((TabPageIndicator.a(this.a) > 0) && (getMeasuredWidth() > TabPageIndicator.a(this.a))) {
      super.onMeasure(View.MeasureSpec.makeMeasureSpec(TabPageIndicator.a(this.a), 1073741824), paramInt2);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.viewpagerindicator.TabPageIndicator.TabView
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */