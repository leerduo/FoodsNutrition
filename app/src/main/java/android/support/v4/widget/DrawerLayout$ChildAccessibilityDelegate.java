package android.support.v4.widget;

import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;

final class DrawerLayout$ChildAccessibilityDelegate
  extends AccessibilityDelegateCompat
{
  DrawerLayout$ChildAccessibilityDelegate(DrawerLayout paramDrawerLayout) {}
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
    if (!DrawerLayout.access$400(paramView)) {
      paramAccessibilityNodeInfoCompat.setParent(null);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.widget.DrawerLayout.ChildAccessibilityDelegate
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */