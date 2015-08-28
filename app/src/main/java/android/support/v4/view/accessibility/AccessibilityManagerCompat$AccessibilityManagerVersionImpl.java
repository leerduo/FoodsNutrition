package android.support.v4.view.accessibility;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.view.accessibility.AccessibilityManager;
import java.util.List;

abstract interface AccessibilityManagerCompat$AccessibilityManagerVersionImpl
{
  public abstract boolean addAccessibilityStateChangeListener(AccessibilityManager paramAccessibilityManager, AccessibilityManagerCompat.AccessibilityStateChangeListenerCompat paramAccessibilityStateChangeListenerCompat);
  
  public abstract List<AccessibilityServiceInfo> getEnabledAccessibilityServiceList(AccessibilityManager paramAccessibilityManager, int paramInt);
  
  public abstract List<AccessibilityServiceInfo> getInstalledAccessibilityServiceList(AccessibilityManager paramAccessibilityManager);
  
  public abstract boolean isTouchExplorationEnabled(AccessibilityManager paramAccessibilityManager);
  
  public abstract Object newAccessiblityStateChangeListener(AccessibilityManagerCompat.AccessibilityStateChangeListenerCompat paramAccessibilityStateChangeListenerCompat);
  
  public abstract boolean removeAccessibilityStateChangeListener(AccessibilityManager paramAccessibilityManager, AccessibilityManagerCompat.AccessibilityStateChangeListenerCompat paramAccessibilityStateChangeListenerCompat);
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.view.accessibility.AccessibilityManagerCompat.AccessibilityManagerVersionImpl
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */