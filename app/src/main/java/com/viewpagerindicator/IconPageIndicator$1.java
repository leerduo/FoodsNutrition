package com.viewpagerindicator;

import android.view.View;

class IconPageIndicator$1
  implements Runnable
{
  IconPageIndicator$1(IconPageIndicator paramIconPageIndicator, View paramView) {}
  
  public void run()
  {
    int i = this.a.getLeft() - (this.b.getWidth() - this.a.getWidth()) / 2;
    this.b.smoothScrollTo(i, 0);
    IconPageIndicator.a(this.b, null);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.viewpagerindicator.IconPageIndicator.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */