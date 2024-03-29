package android.support.v4.widget;

import android.util.Log;
import android.view.View;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class SlidingPaneLayout$SlidingPanelLayoutImplJB
  extends SlidingPaneLayout.SlidingPanelLayoutImplBase
{
  private Method mGetDisplayList;
  private Field mRecreateDisplayList;
  
  SlidingPaneLayout$SlidingPanelLayoutImplJB()
  {
    try
    {
      this.mGetDisplayList = View.class.getDeclaredMethod("getDisplayList", (Class[])null);
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        try
        {
          this.mRecreateDisplayList = View.class.getDeclaredField("mRecreateDisplayList");
          this.mRecreateDisplayList.setAccessible(true);
          return;
        }
        catch (NoSuchFieldException localNoSuchFieldException)
        {
          Log.e("SlidingPaneLayout", "Couldn't fetch mRecreateDisplayList field; dimming will be slow.", localNoSuchFieldException);
        }
        localNoSuchMethodException = localNoSuchMethodException;
        Log.e("SlidingPaneLayout", "Couldn't fetch getDisplayList method; dimming won't work right.", localNoSuchMethodException);
      }
    }
  }
  
  public void invalidateChildRegion(SlidingPaneLayout paramSlidingPaneLayout, View paramView)
  {
    if ((this.mGetDisplayList != null) && (this.mRecreateDisplayList != null)) {
      try
      {
        this.mRecreateDisplayList.setBoolean(paramView, true);
        this.mGetDisplayList.invoke(paramView, (Object[])null);
        super.invalidateChildRegion(paramSlidingPaneLayout, paramView);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("SlidingPaneLayout", "Error refreshing display list state", localException);
        }
      }
    }
    paramView.invalidate();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.widget.SlidingPaneLayout.SlidingPanelLayoutImplJB
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */