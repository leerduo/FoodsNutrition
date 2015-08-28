package android.support.v7.widget;

import android.support.v7.internal.view.menu.MenuBuilder;
import android.view.View;

class ActionMenuPresenter$OpenOverflowRunnable
  implements Runnable
{
  private ActionMenuPresenter.OverflowPopup b;
  
  public ActionMenuPresenter$OpenOverflowRunnable(ActionMenuPresenter paramActionMenuPresenter, ActionMenuPresenter.OverflowPopup paramOverflowPopup)
  {
    this.b = paramOverflowPopup;
  }
  
  public void run()
  {
    ActionMenuPresenter.f(this.a).f();
    View localView = (View)ActionMenuPresenter.g(this.a);
    if ((localView != null) && (localView.getWindowToken() != null) && (this.b.d())) {
      ActionMenuPresenter.a(this.a, this.b);
    }
    ActionMenuPresenter.a(this.a, null);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.widget.ActionMenuPresenter.OpenOverflowRunnable
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */