package android.support.v4.view;

import android.view.View;

class ViewCompat$KitKatViewCompatImpl
  extends ViewCompat.JbMr1ViewCompatImpl
{
  public int getAccessibilityLiveRegion(View paramView)
  {
    return ViewCompatKitKat.getAccessibilityLiveRegion(paramView);
  }
  
  public void setAccessibilityLiveRegion(View paramView, int paramInt)
  {
    ViewCompatKitKat.setAccessibilityLiveRegion(paramView, paramInt);
  }
  
  public void setImportantForAccessibility(View paramView, int paramInt)
  {
    ViewCompatJB.setImportantForAccessibility(paramView, paramInt);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.view.ViewCompat.KitKatViewCompatImpl
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */