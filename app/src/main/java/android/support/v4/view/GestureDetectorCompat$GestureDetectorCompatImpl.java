package android.support.v4.view;

import android.view.GestureDetector.OnDoubleTapListener;
import android.view.MotionEvent;

abstract interface GestureDetectorCompat$GestureDetectorCompatImpl
{
  public abstract boolean isLongpressEnabled();
  
  public abstract boolean onTouchEvent(MotionEvent paramMotionEvent);
  
  public abstract void setIsLongpressEnabled(boolean paramBoolean);
  
  public abstract void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener paramOnDoubleTapListener);
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.view.GestureDetectorCompat.GestureDetectorCompatImpl
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */