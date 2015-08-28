package android.support.v7.widget;

import android.os.SystemClock;
import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewParent;

public abstract class ListPopupWindow$ForwardingListener
  implements View.OnTouchListener
{
  private final float a;
  private final int b;
  private final int c;
  private final View d;
  private Runnable e;
  private Runnable f;
  private boolean g;
  private boolean h;
  private int i;
  private final int[] j = new int[2];
  
  public ListPopupWindow$ForwardingListener(View paramView)
  {
    this.d = paramView;
    this.a = ViewConfiguration.get(paramView.getContext()).getScaledTouchSlop();
    this.b = ViewConfiguration.getTapTimeout();
    this.c = ((this.b + ViewConfiguration.getLongPressTimeout()) / 2);
  }
  
  private boolean a(MotionEvent paramMotionEvent)
  {
    View localView = this.d;
    if (!localView.isEnabled()) {}
    int k;
    do
    {
      return false;
      switch (MotionEventCompat.getActionMasked(paramMotionEvent))
      {
      default: 
        return false;
      case 0: 
        this.i = paramMotionEvent.getPointerId(0);
        this.h = false;
        if (this.e == null) {
          this.e = new ListPopupWindow.ForwardingListener.DisallowIntercept(this, null);
        }
        localView.postDelayed(this.e, this.b);
        if (this.f == null) {
          this.f = new ListPopupWindow.ForwardingListener.TriggerLongPress(this, null);
        }
        localView.postDelayed(this.f, this.c);
        return false;
      case 2: 
        k = paramMotionEvent.findPointerIndex(this.i);
      }
    } while ((k < 0) || (a(localView, paramMotionEvent.getX(k), paramMotionEvent.getY(k), this.a)));
    d();
    localView.getParent().requestDisallowInterceptTouchEvent(true);
    return true;
    d();
    return false;
  }
  
  private static boolean a(View paramView, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (paramFloat1 >= -paramFloat3) && (paramFloat2 >= -paramFloat3) && (paramFloat1 < paramFloat3 + (paramView.getRight() - paramView.getLeft())) && (paramFloat2 < paramFloat3 + (paramView.getBottom() - paramView.getTop()));
  }
  
  private boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    int[] arrayOfInt = this.j;
    paramView.getLocationOnScreen(arrayOfInt);
    paramMotionEvent.offsetLocation(-arrayOfInt[0], -arrayOfInt[1]);
    return true;
  }
  
  private boolean b(MotionEvent paramMotionEvent)
  {
    int k = 1;
    View localView = this.d;
    ListPopupWindow localListPopupWindow = a();
    if ((localListPopupWindow == null) || (!localListPopupWindow.b())) {}
    ListPopupWindow.DropDownListView localDropDownListView;
    do
    {
      return false;
      localDropDownListView = ListPopupWindow.a(localListPopupWindow);
    } while ((localDropDownListView == null) || (!localDropDownListView.isShown()));
    MotionEvent localMotionEvent = MotionEvent.obtainNoHistory(paramMotionEvent);
    b(localView, localMotionEvent);
    a(localDropDownListView, localMotionEvent);
    boolean bool = localDropDownListView.a(localMotionEvent, this.i);
    localMotionEvent.recycle();
    int m = MotionEventCompat.getActionMasked(paramMotionEvent);
    if ((m != k) && (m != 3))
    {
      int n = k;
      if ((!bool) || (n == 0)) {
        break label128;
      }
    }
    for (;;)
    {
      return k;
      int i1 = 0;
      break;
      label128:
      k = 0;
    }
  }
  
  private boolean b(View paramView, MotionEvent paramMotionEvent)
  {
    int[] arrayOfInt = this.j;
    paramView.getLocationOnScreen(arrayOfInt);
    paramMotionEvent.offsetLocation(arrayOfInt[0], arrayOfInt[1]);
    return true;
  }
  
  private void d()
  {
    if (this.f != null) {
      this.d.removeCallbacks(this.f);
    }
    if (this.e != null) {
      this.d.removeCallbacks(this.e);
    }
  }
  
  private void e()
  {
    d();
    if (!this.d.isEnabled()) {}
    while (!b()) {
      return;
    }
    this.d.getParent().requestDisallowInterceptTouchEvent(true);
    long l = SystemClock.uptimeMillis();
    MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
    this.d.onTouchEvent(localMotionEvent);
    localMotionEvent.recycle();
    this.g = true;
    this.h = true;
  }
  
  public abstract ListPopupWindow a();
  
  protected boolean b()
  {
    ListPopupWindow localListPopupWindow = a();
    if ((localListPopupWindow != null) && (!localListPopupWindow.b())) {
      localListPopupWindow.c();
    }
    return true;
  }
  
  protected boolean c()
  {
    ListPopupWindow localListPopupWindow = a();
    if ((localListPopupWindow != null) && (localListPopupWindow.b())) {
      localListPopupWindow.a();
    }
    return true;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool1 = this.g;
    boolean bool3;
    if (bool1)
    {
      if (this.h) {
        bool3 = b(paramMotionEvent);
      }
      for (;;)
      {
        this.g = bool3;
        boolean bool4;
        if (!bool3)
        {
          bool4 = false;
          if (!bool1) {}
        }
        else
        {
          bool4 = true;
        }
        return bool4;
        if ((b(paramMotionEvent)) || (!c())) {
          bool3 = true;
        } else {
          bool3 = false;
        }
      }
    }
    if ((a(paramMotionEvent)) && (b())) {}
    for (boolean bool2 = true;; bool2 = false)
    {
      if (bool2)
      {
        long l = SystemClock.uptimeMillis();
        MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
        this.d.onTouchEvent(localMotionEvent);
        localMotionEvent.recycle();
      }
      bool3 = bool2;
      break;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.widget.ListPopupWindow.ForwardingListener
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */