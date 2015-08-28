package android.support.v7.internal.widget;

import android.support.v7.internal.app.WindowCallback;
import android.support.v7.internal.view.menu.ActionMenuItem;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;

class ToolbarWidgetWrapper$1
  implements View.OnClickListener
{
  final ActionMenuItem a = new ActionMenuItem(ToolbarWidgetWrapper.a(this.b).getContext(), 0, 16908332, 0, 0, ToolbarWidgetWrapper.b(this.b));
  
  ToolbarWidgetWrapper$1(ToolbarWidgetWrapper paramToolbarWidgetWrapper) {}
  
  public void onClick(View paramView)
  {
    if ((ToolbarWidgetWrapper.c(this.b) != null) && (ToolbarWidgetWrapper.d(this.b))) {
      ToolbarWidgetWrapper.c(this.b).a(0, this.a);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.ToolbarWidgetWrapper.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */