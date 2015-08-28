package m.framework.ui.widget.viewpager;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.Scroller;
import m.framework.utils.Utils;

public class ViewPagerClassic
  extends ViewGroup
{
  private int a;
  private Scroller b;
  private VelocityTracker c;
  private float d;
  private float e;
  private int f = 0;
  private int g;
  private int h;
  private ViewPagerAdapter i;
  
  public ViewPagerClassic(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ViewPagerClassic(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ViewPagerClassic(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    int j;
    int k;
    Scroller localScroller;
    int m;
    if (paramInt != this.a)
    {
      j = 1;
      View localView = getFocusedChild();
      if ((localView != null) && (j != 0) && (localView == getChildAt(this.a))) {
        localView.clearFocus();
      }
      k = paramInt * getWidth() - getScrollX();
      localScroller = this.b;
      m = getScrollX();
      if (!paramBoolean) {
        break label98;
      }
    }
    label98:
    for (int n = 0;; n = Math.abs(k) / 2)
    {
      localScroller.startScroll(m, 0, k, 0, n);
      invalidate();
      return;
      j = 0;
      break;
    }
  }
  
  private void a(Context paramContext)
  {
    this.b = new Scroller(getContext(), new ViewPagerClassic.1(this));
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(paramContext);
    this.g = localViewConfiguration.getScaledTouchSlop();
    this.h = localViewConfiguration.getScaledMaximumFlingVelocity();
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    int j = (int)Math.abs(f1 - this.d);
    int k = (int)Math.abs(f2 - this.e);
    if (j > this.g) {}
    for (int m = 1;; m = 0)
    {
      int n = this.g;
      int i1 = 0;
      if (k > n) {
        i1 = 1;
      }
      if (((m != 0) || (i1 != 0)) && (m != 0))
      {
        this.f = 1;
        this.d = f1;
      }
      return;
    }
  }
  
  private void b(MotionEvent paramMotionEvent)
  {
    if (this.i == null) {}
    int j;
    int k;
    do
    {
      do
      {
        do
        {
          return;
          float f1 = paramMotionEvent.getX();
          j = (int)(this.d - f1);
          this.d = f1;
          if (j >= 0) {
            break;
          }
        } while (getScrollX() <= 0);
        scrollBy(Math.max(-getScrollX(), j), 0);
        return;
      } while ((j <= 0) || (getChildCount() == 0));
      k = getChildAt(-1 + getChildCount()).getRight() - getScrollX() - getWidth();
    } while (k <= 0);
    scrollBy(Math.min(k, j), 0);
  }
  
  public void a(int paramInt)
  {
    a(paramInt, false);
  }
  
  public void computeScroll()
  {
    if (this.i == null) {}
    int j;
    do
    {
      return;
      if (this.b.computeScrollOffset())
      {
        scrollTo(this.b.getCurrX(), this.b.getCurrY());
        postInvalidate();
        return;
      }
      j = this.a;
      int k = this.b.getCurrX();
      int m = getWidth();
      int n = k / m;
      if (k % m > m / 2) {
        n++;
      }
      this.a = Math.max(0, Math.min(n, -1 + getChildCount()));
    } while ((j == this.a) || (this.i == null));
    this.i.onScreenChange(this.a, j);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if ((this.i == null) || (getChildCount() <= 0)) {}
    long l;
    do
    {
      return;
      l = getDrawingTime();
      if (this.a > 0) {
        drawChild(paramCanvas, getChildAt(-1 + this.a), l);
      }
      drawChild(paramCanvas, getChildAt(this.a), l);
    } while (this.a >= -1 + getChildCount());
    drawChild(paramCanvas, getChildAt(1 + this.a), l);
  }
  
  public boolean dispatchUnhandledMove(View paramView, int paramInt)
  {
    if (this.i == null) {
      return super.dispatchUnhandledMove(paramView, paramInt);
    }
    if (paramInt == 17)
    {
      if (this.a > 0)
      {
        a(-1 + this.a);
        return true;
      }
    }
    else if ((paramInt == 66) && (this.a < -1 + getChildCount()))
    {
      a(1 + this.a);
      return true;
    }
    return super.dispatchUnhandledMove(paramView, paramInt);
  }
  
  public int getCurrentScreen()
  {
    return this.a;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = paramMotionEvent.getAction();
    if ((j == 2) && (this.f != 0)) {}
    for (;;)
    {
      return true;
      if (this.c == null) {
        this.c = VelocityTracker.obtain();
      }
      this.c.addMovement(paramMotionEvent);
      switch (j)
      {
      }
      while (this.f == 0)
      {
        return false;
        a(paramMotionEvent);
        continue;
        float f1 = paramMotionEvent.getX();
        float f2 = paramMotionEvent.getY();
        this.d = f1;
        this.e = f2;
        if (this.b.isFinished()) {}
        for (int k = 0;; k = 1)
        {
          this.f = k;
          break;
        }
        if (this.c != null)
        {
          this.c.recycle();
          this.c = null;
        }
        this.f = 0;
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.i == null) {}
    for (;;)
    {
      return;
      int j = paramInt3 - paramInt1;
      int k = paramInt4 - paramInt2;
      int m = getChildCount();
      int n = 0;
      int i1 = 0;
      while (n < m)
      {
        View localView = getChildAt(n);
        if (localView.getVisibility() != 8)
        {
          localView.layout(i1, 0, i1 + j, k);
          i1 += j;
        }
        n++;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.i == null) {
      super.onMeasure(paramInt1, paramInt2);
    }
    int k;
    int m;
    int n;
    for (;;)
    {
      return;
      int j = getChildCount();
      k = View.MeasureSpec.makeMeasureSpec(Utils.a(getContext()), 1073741824);
      m = 0;
      n = 0;
      if (m < j) {
        break;
      }
      int i2 = View.MeasureSpec.makeMeasureSpec(n, 1073741824);
      super.onMeasure(k, i2);
      for (int i3 = 0; i3 < j; i3++) {
        getChildAt(i3).measure(k, i2);
      }
    }
    View localView = getChildAt(m);
    localView.measure(k, 0);
    int i1 = localView.getMeasuredHeight();
    if (i1 > n) {}
    for (;;)
    {
      m++;
      n = i1;
      break;
      i1 = n;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.i == null) {
      return false;
    }
    if (this.c == null) {
      this.c = VelocityTracker.obtain();
    }
    this.c.addMovement(paramMotionEvent);
    int j = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getX();
    switch (j)
    {
    }
    for (;;)
    {
      return true;
      if (this.f != 0)
      {
        if (!this.b.isFinished()) {
          this.b.abortAnimation();
        }
        this.d = f1;
        continue;
        if (this.f == 1)
        {
          b(paramMotionEvent);
        }
        else if ((onInterceptTouchEvent(paramMotionEvent)) && (this.f == 1))
        {
          b(paramMotionEvent);
          continue;
          int k;
          if (this.f == 1)
          {
            VelocityTracker localVelocityTracker = this.c;
            localVelocityTracker.computeCurrentVelocity(1000, this.h);
            k = (int)localVelocityTracker.getXVelocity();
            if ((k <= 500) || (this.a <= 0)) {
              break label233;
            }
            a(-1 + this.a);
          }
          for (;;)
          {
            if (this.c != null)
            {
              this.c.recycle();
              this.c = null;
            }
            this.f = 0;
            break;
            label233:
            if ((k < -500) && (this.a < -1 + getChildCount()))
            {
              a(1 + this.a);
            }
            else
            {
              int m = getWidth();
              a((getScrollX() + m / 2) / m);
            }
          }
          this.f = 0;
        }
      }
    }
  }
  
  public void setAdapter(ViewPagerAdapter paramViewPagerAdapter)
  {
    int j = 0;
    this.i = paramViewPagerAdapter;
    removeAllViews();
    this.a = 0;
    if (this.i == null) {}
    for (;;)
    {
      return;
      int k = paramViewPagerAdapter.getCount();
      while (j < k)
      {
        addView(paramViewPagerAdapter.getView(j, this));
        j++;
      }
    }
  }
  
  public void setCurrentScreen(int paramInt)
  {
    if (this.i == null) {
      return;
    }
    if (!this.b.isFinished()) {
      this.b.abortAnimation();
    }
    int j = this.a;
    this.a = Math.max(0, Math.min(paramInt, getChildCount()));
    this.i.onScreenChange(this.a, j);
    int k = Utils.a(getContext()) * this.a;
    this.b.startScroll(0, 0, k, 0);
    scrollTo(k, 0);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     m.framework.ui.widget.viewpager.ViewPagerClassic
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */