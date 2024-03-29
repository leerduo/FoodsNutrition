package android.support.v7.widget;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.appcompat.R.attr;
import android.support.v7.internal.widget.TintImageView;

class ActionMenuPresenter$OverflowMenuButton
  extends TintImageView
  implements ActionMenuView.ActionMenuChildView
{
  private final float[] b = new float[2];
  
  public ActionMenuPresenter$OverflowMenuButton(ActionMenuPresenter paramActionMenuPresenter, Context paramContext)
  {
    super(paramContext, null, R.attr.actionOverflowButtonStyle);
    setClickable(true);
    setFocusable(true);
    setVisibility(0);
    setEnabled(true);
    setOnTouchListener(new ActionMenuPresenter.OverflowMenuButton.1(this, this, paramActionMenuPresenter));
  }
  
  public boolean c()
  {
    return false;
  }
  
  public boolean d()
  {
    return false;
  }
  
  public boolean performClick()
  {
    if (super.performClick()) {
      return true;
    }
    playSoundEffect(0);
    this.a.c();
    return true;
  }
  
  protected boolean setFrame(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool = super.setFrame(paramInt1, paramInt2, paramInt3, paramInt4);
    Drawable localDrawable1 = getDrawable();
    Drawable localDrawable2 = getBackground();
    if ((localDrawable1 != null) && (localDrawable2 != null))
    {
      float[] arrayOfFloat = this.b;
      arrayOfFloat[0] = localDrawable1.getBounds().centerX();
      getImageMatrix().mapPoints(arrayOfFloat);
      int i = (int)arrayOfFloat[0] - getWidth() / 2;
      DrawableCompat.setHotspotBounds(localDrawable2, i, 0, i + getWidth(), getHeight());
    }
    return bool;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.widget.ActionMenuPresenter.OverflowMenuButton
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */