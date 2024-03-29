package android.support.v4.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.animation.Interpolator;

public class ScrollerCompat
{
  static final int CHASE_FRAME_TIME = 16;
  private static final String TAG = "ScrollerCompat";
  ScrollerCompat.ScrollerCompatImpl mImpl;
  Object mScroller;
  
  private ScrollerCompat(int paramInt, Context paramContext, Interpolator paramInterpolator)
  {
    if (paramInt >= 14) {
      this.mImpl = new ScrollerCompat.ScrollerCompatImplIcs();
    }
    for (;;)
    {
      this.mScroller = this.mImpl.createScroller(paramContext, paramInterpolator);
      return;
      if (paramInt >= 9) {
        this.mImpl = new ScrollerCompat.ScrollerCompatImplGingerbread();
      } else {
        this.mImpl = new ScrollerCompat.ScrollerCompatImplBase();
      }
    }
  }
  
  ScrollerCompat(Context paramContext, Interpolator paramInterpolator)
  {
    this(Build.VERSION.SDK_INT, paramContext, paramInterpolator);
  }
  
  public static ScrollerCompat create(Context paramContext)
  {
    return create(paramContext, null);
  }
  
  public static ScrollerCompat create(Context paramContext, Interpolator paramInterpolator)
  {
    return new ScrollerCompat(paramContext, paramInterpolator);
  }
  
  public void abortAnimation()
  {
    this.mImpl.abortAnimation(this.mScroller);
  }
  
  public boolean computeScrollOffset()
  {
    return this.mImpl.computeScrollOffset(this.mScroller);
  }
  
  public void fling(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    this.mImpl.fling(this.mScroller, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
  }
  
  public void fling(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10)
  {
    this.mImpl.fling(this.mScroller, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10);
  }
  
  public float getCurrVelocity()
  {
    return this.mImpl.getCurrVelocity(this.mScroller);
  }
  
  public int getCurrX()
  {
    return this.mImpl.getCurrX(this.mScroller);
  }
  
  public int getCurrY()
  {
    return this.mImpl.getCurrY(this.mScroller);
  }
  
  public int getFinalX()
  {
    return this.mImpl.getFinalX(this.mScroller);
  }
  
  public int getFinalY()
  {
    return this.mImpl.getFinalY(this.mScroller);
  }
  
  public boolean isFinished()
  {
    return this.mImpl.isFinished(this.mScroller);
  }
  
  public boolean isOverScrolled()
  {
    return this.mImpl.isOverScrolled(this.mScroller);
  }
  
  public void notifyHorizontalEdgeReached(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mImpl.notifyHorizontalEdgeReached(this.mScroller, paramInt1, paramInt2, paramInt3);
  }
  
  public void notifyVerticalEdgeReached(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mImpl.notifyVerticalEdgeReached(this.mScroller, paramInt1, paramInt2, paramInt3);
  }
  
  public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mImpl.startScroll(this.mScroller, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.mImpl.startScroll(this.mScroller, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.widget.ScrollerCompat
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */