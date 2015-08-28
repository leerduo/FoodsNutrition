package android.support.v4.view;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import java.lang.reflect.Field;
import java.util.WeakHashMap;

class ViewCompat$ICSViewCompatImpl
  extends ViewCompat.HCViewCompatImpl
{
  static boolean accessibilityDelegateCheckFailed = false;
  static Field mAccessibilityDelegateField;
  
  public ViewPropertyAnimatorCompat animate(View paramView)
  {
    if (this.mViewPropertyAnimatorCompatMap == null) {
      this.mViewPropertyAnimatorCompatMap = new WeakHashMap();
    }
    ViewPropertyAnimatorCompat localViewPropertyAnimatorCompat = (ViewPropertyAnimatorCompat)this.mViewPropertyAnimatorCompatMap.get(paramView);
    if (localViewPropertyAnimatorCompat == null)
    {
      localViewPropertyAnimatorCompat = new ViewPropertyAnimatorCompat(paramView);
      this.mViewPropertyAnimatorCompatMap.put(paramView, localViewPropertyAnimatorCompat);
    }
    return localViewPropertyAnimatorCompat;
  }
  
  public boolean canScrollHorizontally(View paramView, int paramInt)
  {
    return ViewCompatICS.canScrollHorizontally(paramView, paramInt);
  }
  
  public boolean canScrollVertically(View paramView, int paramInt)
  {
    return ViewCompatICS.canScrollVertically(paramView, paramInt);
  }
  
  /* Error */
  public boolean hasAccessibilityDelegate(View paramView)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: getstatic 12	android/support/v4/view/ViewCompat$ICSViewCompatImpl:accessibilityDelegateCheckFailed	Z
    //   5: ifeq +5 -> 10
    //   8: iconst_0
    //   9: ireturn
    //   10: getstatic 52	android/support/v4/view/ViewCompat$ICSViewCompatImpl:mAccessibilityDelegateField	Ljava/lang/reflect/Field;
    //   13: ifnonnull +20 -> 33
    //   16: ldc 54
    //   18: ldc 56
    //   20: invokevirtual 62	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   23: putstatic 52	android/support/v4/view/ViewCompat$ICSViewCompatImpl:mAccessibilityDelegateField	Ljava/lang/reflect/Field;
    //   26: getstatic 52	android/support/v4/view/ViewCompat$ICSViewCompatImpl:mAccessibilityDelegateField	Ljava/lang/reflect/Field;
    //   29: iconst_1
    //   30: invokevirtual 68	java/lang/reflect/Field:setAccessible	(Z)V
    //   33: getstatic 52	android/support/v4/view/ViewCompat$ICSViewCompatImpl:mAccessibilityDelegateField	Ljava/lang/reflect/Field;
    //   36: aload_1
    //   37: invokevirtual 69	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   40: astore 4
    //   42: aload 4
    //   44: ifnull +13 -> 57
    //   47: iload_2
    //   48: ireturn
    //   49: astore 5
    //   51: iload_2
    //   52: putstatic 12	android/support/v4/view/ViewCompat$ICSViewCompatImpl:accessibilityDelegateCheckFailed	Z
    //   55: iconst_0
    //   56: ireturn
    //   57: iconst_0
    //   58: istore_2
    //   59: goto -12 -> 47
    //   62: astore_3
    //   63: iload_2
    //   64: putstatic 12	android/support/v4/view/ViewCompat$ICSViewCompatImpl:accessibilityDelegateCheckFailed	Z
    //   67: iconst_0
    //   68: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	this	ICSViewCompatImpl
    //   0	69	1	paramView	View
    //   1	63	2	bool	boolean
    //   62	1	3	localThrowable1	java.lang.Throwable
    //   40	3	4	localObject	java.lang.Object
    //   49	1	5	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   16	33	49	java/lang/Throwable
    //   33	42	62	java/lang/Throwable
  }
  
  public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    ViewCompatICS.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    ViewCompatICS.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat.getInfo());
  }
  
  public void onPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    ViewCompatICS.onPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  public void setAccessibilityDelegate(View paramView, AccessibilityDelegateCompat paramAccessibilityDelegateCompat)
  {
    ViewCompatICS.setAccessibilityDelegate(paramView, paramAccessibilityDelegateCompat.getBridge());
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.view.ViewCompat.ICSViewCompatImpl
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */