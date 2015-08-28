package android.support.v7.internal.widget;

import android.support.v4.view.ActionProvider;
import android.support.v7.widget.ListPopupWindow;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class ActivityChooserView$2
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  ActivityChooserView$2(ActivityChooserView paramActivityChooserView) {}
  
  public void onGlobalLayout()
  {
    if (this.a.c())
    {
      if (this.a.isShown()) {
        break label31;
      }
      ActivityChooserView.b(this.a).a();
    }
    label31:
    do
    {
      return;
      ActivityChooserView.b(this.a).c();
    } while (this.a.a == null);
    this.a.a.subUiVisibilityChanged(true);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.ActivityChooserView.2
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */