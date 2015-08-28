package android.support.v4.view;

import android.view.View;
import android.view.ViewPropertyAnimator;

class ViewPropertyAnimatorCompatKK
{
  public static void setUpdateListener(View paramView, ViewPropertyAnimatorUpdateListener paramViewPropertyAnimatorUpdateListener)
  {
    paramView.animate().setUpdateListener(new ViewPropertyAnimatorCompatKK.1(paramViewPropertyAnimatorUpdateListener, paramView));
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.view.ViewPropertyAnimatorCompatKK
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */