package android.support.v7.internal.widget;

import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v7.widget.Toolbar;
import android.view.View;

class ToolbarWidgetWrapper$3
  extends ViewPropertyAnimatorListenerAdapter
{
  ToolbarWidgetWrapper$3(ToolbarWidgetWrapper paramToolbarWidgetWrapper) {}
  
  public void onAnimationStart(View paramView)
  {
    ToolbarWidgetWrapper.a(this.a).setVisibility(0);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.ToolbarWidgetWrapper.3
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */