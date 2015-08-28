package android.support.v7.internal.widget;

import android.view.View;

class ScrollingTabContainerView$1
  implements Runnable
{
  ScrollingTabContainerView$1(ScrollingTabContainerView paramScrollingTabContainerView, View paramView) {}
  
  public void run()
  {
    int i = this.a.getLeft() - (this.b.getWidth() - this.a.getWidth()) / 2;
    this.b.smoothScrollTo(i, 0);
    this.b.a = null;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.ScrollingTabContainerView.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */