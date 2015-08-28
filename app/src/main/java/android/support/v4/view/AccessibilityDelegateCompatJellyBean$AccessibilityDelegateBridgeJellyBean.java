package android.support.v4.view;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

public abstract interface AccessibilityDelegateCompatJellyBean$AccessibilityDelegateBridgeJellyBean
{
  public abstract boolean dispatchPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent);
  
  public abstract Object getAccessibilityNodeProvider(View paramView);
  
  public abstract void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent);
  
  public abstract void onInitializeAccessibilityNodeInfo(View paramView, Object paramObject);
  
  public abstract void onPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent);
  
  public abstract boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent);
  
  public abstract boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle);
  
  public abstract void sendAccessibilityEvent(View paramView, int paramInt);
  
  public abstract void sendAccessibilityEventUnchecked(View paramView, AccessibilityEvent paramAccessibilityEvent);
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.view.AccessibilityDelegateCompatJellyBean.AccessibilityDelegateBridgeJellyBean
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */