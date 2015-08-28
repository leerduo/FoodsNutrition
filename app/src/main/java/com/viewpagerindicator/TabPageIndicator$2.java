package com.viewpagerindicator;

import android.view.View;

class TabPageIndicator$2
  implements Runnable
{
  TabPageIndicator$2(TabPageIndicator paramTabPageIndicator, View paramView) {}
  
  public void run()
  {
    int i = this.a.getLeft() - (this.b.getWidth() - this.a.getWidth()) / 2;
    this.b.smoothScrollTo(i, 0);
    TabPageIndicator.a(this.b, null);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.viewpagerindicator.TabPageIndicator.2
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */