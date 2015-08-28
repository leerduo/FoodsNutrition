package android.support.v7.internal.widget;

import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v7.widget.Toolbar;
import android.view.View;

class ToolbarWidgetWrapper$2
  extends ViewPropertyAnimatorListenerAdapter
{
  private boolean b = false;
  
  ToolbarWidgetWrapper$2(ToolbarWidgetWrapper paramToolbarWidgetWrapper) {}
  
  public void onAnimationCancel(View paramView)
  {
    this.b = true;
  }
  
  public void onAnimationEnd(View paramView)
  {
    if (!this.b) {
      ToolbarWidgetWrapper.a(this.a).setVisibility(8);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.ToolbarWidgetWrapper.2
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */