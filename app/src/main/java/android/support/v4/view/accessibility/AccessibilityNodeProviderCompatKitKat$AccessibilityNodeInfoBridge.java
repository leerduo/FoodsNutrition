package android.support.v4.view.accessibility;

import android.os.Bundle;
import java.util.List;

abstract interface AccessibilityNodeProviderCompatKitKat$AccessibilityNodeInfoBridge
{
  public abstract Object createAccessibilityNodeInfo(int paramInt);
  
  public abstract List<Object> findAccessibilityNodeInfosByText(String paramString, int paramInt);
  
  public abstract Object findFocus(int paramInt);
  
  public abstract boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle);
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.view.accessibility.AccessibilityNodeProviderCompatKitKat.AccessibilityNodeInfoBridge
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */