package android.support.v4.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

class ViewGroupCompat$ViewGroupCompatIcsImpl
  extends ViewGroupCompat.ViewGroupCompatHCImpl
{
  public boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    return ViewGroupCompatIcs.onRequestSendAccessibilityEvent(paramViewGroup, paramView, paramAccessibilityEvent);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.view.ViewGroupCompat.ViewGroupCompatIcsImpl
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */