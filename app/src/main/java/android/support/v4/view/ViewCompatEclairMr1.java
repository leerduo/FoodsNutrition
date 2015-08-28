package android.support.v4.view;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ViewCompatEclairMr1
{
  public static final String TAG = "ViewCompat";
  private static Method sChildrenDrawingOrderMethod;
  
  public static boolean isOpaque(View paramView)
  {
    return paramView.isOpaque();
  }
  
  public static void setChildrenDrawingOrderEnabled(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (sChildrenDrawingOrderMethod == null) {}
    try
    {
      Class[] arrayOfClass = new Class[1];
      arrayOfClass[0] = Boolean.TYPE;
      sChildrenDrawingOrderMethod = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", arrayOfClass);
      sChildrenDrawingOrderMethod.setAccessible(true);
      Method localMethod;
      Object[] arrayOfObject;
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        try
        {
          localMethod = sChildrenDrawingOrderMethod;
          arrayOfObject = new Object[1];
          arrayOfObject[0] = Boolean.valueOf(paramBoolean);
          localMethod.invoke(paramViewGroup, arrayOfObject);
          return;
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", localIllegalAccessException);
          return;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", localIllegalArgumentException);
          return;
        }
        catch (InvocationTargetException localInvocationTargetException)
        {
          Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", localInvocationTargetException);
        }
        localNoSuchMethodException = localNoSuchMethodException;
        Log.e("ViewCompat", "Unable to find childrenDrawingOrderEnabled", localNoSuchMethodException);
      }
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.view.ViewCompatEclairMr1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */