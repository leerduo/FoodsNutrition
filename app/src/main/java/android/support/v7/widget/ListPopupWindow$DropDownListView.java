package android.support.v7.widget;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.widget.ListViewAutoScrollHelper;
import android.support.v7.appcompat.R.attr;
import android.support.v7.internal.widget.ListViewCompat;
import android.view.MotionEvent;
import android.view.View;

class ListPopupWindow$DropDownListView
  extends ListViewCompat
{
  private boolean f;
  private boolean g;
  private boolean h;
  private ViewPropertyAnimatorCompat i;
  private ListViewAutoScrollHelper j;
  
  public ListPopupWindow$DropDownListView(Context paramContext, boolean paramBoolean)
  {
    super(paramContext, null, R.attr.dropDownListViewStyle);
    this.g = paramBoolean;
    setCacheColorHint(0);
  }
  
  private void a(View paramView, int paramInt)
  {
    performItemClick(paramView, paramInt, getItemIdAtPosition(paramInt));
  }
  
  private void a(View paramView, int paramInt, float paramFloat1, float paramFloat2)
  {
    this.h = true;
    setPressed(true);
    layoutChildren();
    setSelection(paramInt);
    a(paramInt, paramView, paramFloat1, paramFloat2);
    setSelectorEnabled(false);
    refreshDrawableState();
  }
  
  private void d()
  {
    this.h = false;
    setPressed(false);
    drawableStateChanged();
    if (this.i != null)
    {
      this.i.cancel();
      this.i = null;
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent, int paramInt)
  {
    int k = MotionEventCompat.getActionMasked(paramMotionEvent);
    int n;
    boolean bool2;
    switch (k)
    {
    default: 
      n = 0;
    case 3: 
      for (bool2 = true;; bool2 = false)
      {
        label38:
        if ((!bool2) || (n != 0)) {
          d();
        }
        if (!bool2) {
          break;
        }
        if (this.j == null) {
          this.j = new ListViewAutoScrollHelper(this);
        }
        this.j.setEnabled(true);
        this.j.onTouch(this, paramMotionEvent);
        label95:
        return bool2;
        n = 0;
      }
    }
    for (boolean bool1 = false;; bool1 = true)
    {
      int m = paramMotionEvent.findPointerIndex(paramInt);
      if (m < 0)
      {
        n = 0;
        bool2 = false;
        break label38;
      }
      int i1 = (int)paramMotionEvent.getX(m);
      int i2 = (int)paramMotionEvent.getY(m);
      int i3 = pointToPosition(i1, i2);
      if (i3 == -1)
      {
        bool2 = bool1;
        n = 1;
        break label38;
      }
      View localView = getChildAt(i3 - getFirstVisiblePosition());
      a(localView, i3, i1, i2);
      if (k != 1) {
        break;
      }
      a(localView, i3);
      break;
      if (this.j == null) {
        break label95;
      }
      this.j.setEnabled(false);
      return bool2;
    }
  }
  
  protected boolean c()
  {
    return (this.h) || (super.c());
  }
  
  public boolean hasFocus()
  {
    return (this.g) || (super.hasFocus());
  }
  
  public boolean hasWindowFocus()
  {
    return (this.g) || (super.hasWindowFocus());
  }
  
  public boolean isFocused()
  {
    return (this.g) || (super.isFocused());
  }
  
  public boolean isInTouchMode()
  {
    return ((this.g) && (this.f)) || (super.isInTouchMode());
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.widget.ListPopupWindow.DropDownListView
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */