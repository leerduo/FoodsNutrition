package android.support.v4.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

abstract interface ViewGroupCompat$ViewGroupCompatImpl
{
  public abstract int getLayoutMode(ViewGroup paramViewGroup);
  
  public abstract boolean isTransitionGroup(ViewGroup paramViewGroup);
  
  public abstract boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent);
  
  public abstract void setLayoutMode(ViewGroup paramViewGroup, int paramInt);
  
  public abstract void setMotionEventSplittingEnabled(ViewGroup paramViewGroup, boolean paramBoolean);
  
  public abstract void setTransitionGroup(ViewGroup paramViewGroup, boolean paramBoolean);
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.view.ViewGroupCompat.ViewGroupCompatImpl
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */