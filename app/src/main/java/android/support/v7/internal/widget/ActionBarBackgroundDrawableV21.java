package android.support.v7.internal.widget;

import android.graphics.Outline;
import android.graphics.drawable.Drawable;

class ActionBarBackgroundDrawableV21
  extends ActionBarBackgroundDrawable
{
  public ActionBarBackgroundDrawableV21(ActionBarContainer paramActionBarContainer)
  {
    super(paramActionBarContainer);
  }
  
  public void getOutline(Outline paramOutline)
  {
    if (this.a.d) {
      if (this.a.c != null) {
        this.a.c.getOutline(paramOutline);
      }
    }
    while (this.a.a == null) {
      return;
    }
    this.a.a.getOutline(paramOutline);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.ActionBarBackgroundDrawableV21
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */