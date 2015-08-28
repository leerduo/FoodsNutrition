package android.support.v4.view;

import android.os.Build.VERSION;

public class ScaleGestureDetectorCompat
{
  static final ScaleGestureDetectorCompat.ScaleGestureDetectorImpl IMPL = new ScaleGestureDetectorCompat.BaseScaleGestureDetectorImpl(null);
  
  static
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      IMPL = new ScaleGestureDetectorCompat.ScaleGestureDetectorCompatKitKatImpl(null);
      return;
    }
  }
  
  public static boolean isQuickScaleEnabled(Object paramObject)
  {
    return IMPL.isQuickScaleEnabled(paramObject);
  }
  
  public static void setQuickScaleEnabled(Object paramObject, boolean paramBoolean)
  {
    IMPL.setQuickScaleEnabled(paramObject, paramBoolean);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.view.ScaleGestureDetectorCompat
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */