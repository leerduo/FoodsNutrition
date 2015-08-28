package m.framework.ui.widget.pulltorefresh;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public class PullToRefreshView
  extends RelativeLayout
{
  private PullToRefreshAdatper a;
  private View b;
  private View c;
  private int d;
  private int e;
  private float f;
  private boolean g;
  private boolean h;
  private Runnable i;
  private long j;
  
  public PullToRefreshView(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  private MotionEvent a(MotionEvent paramMotionEvent)
  {
    return MotionEvent.obtain(paramMotionEvent.getDownTime(), paramMotionEvent.getEventTime(), 3, paramMotionEvent.getX(), paramMotionEvent.getY(), paramMotionEvent.getMetaState());
  }
  
  private void b()
  {
    this.i = new PullToRefreshView.1(this);
  }
  
  private void c()
  {
    this.j = System.currentTimeMillis();
    this.g = true;
    if (this.a != null) {
      this.a.onRequest();
    }
  }
  
  private void d()
  {
    this.g = false;
  }
  
  private void e()
  {
    this.e = 0;
    scrollTo(0, 0);
    if (this.a != null) {
      this.a.onReversed();
    }
  }
  
  private boolean f()
  {
    return (!this.h) && (this.a.isPullReady());
  }
  
  public void a()
  {
    long l = System.currentTimeMillis() - this.j;
    if (l < 1000L)
    {
      postDelayed(this.i, 1000L - l);
      return;
    }
    post(this.i);
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = this.d;
    scrollTo(0, -this.e);
    if (paramBoolean) {
      c();
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      this.f = paramMotionEvent.getY();
      continue;
      float f1 = paramMotionEvent.getY();
      if ((this.g) || (f()))
      {
        this.e = ((int)(this.e + (f1 - this.f) / 2.0F));
        if (this.e <= 0) {
          break label155;
        }
        scrollTo(0, -this.e);
        if ((!this.g) && (this.a != null)) {
          this.a.onPullDown(100 * this.e / this.d);
        }
        paramMotionEvent = a(paramMotionEvent);
      }
      for (;;)
      {
        this.f = f1;
        break;
        label155:
        this.e = 0;
        scrollTo(0, 0);
      }
      if (!this.g)
      {
        if (this.e > this.d)
        {
          this.e = this.d;
          scrollTo(0, -this.e);
          if (this.a != null) {
            this.a.onPullDown(100);
          }
          c();
          paramMotionEvent = a(paramMotionEvent);
        }
        else if (this.e != 0)
        {
          e();
          if (this.a != null) {
            this.a.onPullDown(0);
          }
        }
      }
      else
      {
        this.e = this.d;
        scrollTo(0, -this.e);
      }
    }
  }
  
  public void setAdapter(PullToRefreshAdatper paramPullToRefreshAdatper)
  {
    this.a = paramPullToRefreshAdatper;
    removeAllViews();
    this.c = ((View)paramPullToRefreshAdatper.getBodyView());
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams1.addRule(9, -1);
    localLayoutParams1.addRule(11, -1);
    localLayoutParams1.addRule(10, -1);
    addView(this.c, localLayoutParams1);
    this.b = paramPullToRefreshAdatper.getHeaderView();
    this.b.measure(0, 0);
    this.d = this.b.getMeasuredHeight();
    RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-2, this.d);
    localLayoutParams2.addRule(9, -1);
    localLayoutParams2.addRule(11, -1);
    localLayoutParams2.addRule(10, -1);
    localLayoutParams2.topMargin = (-this.d);
    addView(this.b, localLayoutParams2);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     m.framework.ui.widget.pulltorefresh.PullToRefreshView
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */