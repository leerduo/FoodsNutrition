package butterknife;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;

public final class ButterKnife
{
  static final Map<Class<?>, Method> a = new LinkedHashMap();
  static final Map<Class<?>, Method> b = new LinkedHashMap();
  static final Method c = null;
  private static boolean d = false;
  
  private static Method a(Class<?> paramClass)
  {
    Method localMethod1 = (Method)a.get(paramClass);
    if (localMethod1 != null)
    {
      if (d) {
        Log.d("ButterKnife", "HIT: Cached in injector map.");
      }
      return localMethod1;
    }
    String str = paramClass.getName();
    if ((str.startsWith("android.")) || (str.startsWith("java.")))
    {
      if (d) {
        Log.d("ButterKnife", "MISS: Reached framework class. Abandoning search.");
      }
      return c;
    }
    try
    {
      localMethod2 = Class.forName(str + "$$ViewInjector").getMethod("inject", new Class[] { ButterKnife.Finder.class, paramClass, Object.class });
      if (d) {
        Log.d("ButterKnife", "HIT: Class loaded injection class.");
      }
      a.put(paramClass, localMethod2);
      return localMethod2;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        if (d) {
          Log.d("ButterKnife", "Not found. Trying superclass " + paramClass.getSuperclass().getName());
        }
        Method localMethod2 = a(paramClass.getSuperclass());
      }
    }
  }
  
  public static void a(Activity paramActivity)
  {
    a(paramActivity, paramActivity, ButterKnife.Finder.b);
  }
  
  public static void a(Object paramObject, View paramView)
  {
    a(paramObject, paramView, ButterKnife.Finder.a);
  }
  
  static void a(Object paramObject1, Object paramObject2, ButterKnife.Finder paramFinder)
  {
    Class localClass = paramObject1.getClass();
    try
    {
      if (d) {
        Log.d("ButterKnife", "Looking up view injector for " + localClass.getName());
      }
      Method localMethod = a(localClass);
      if (localMethod != null) {
        localMethod.invoke(null, new Object[] { paramFinder, paramObject1, paramObject2 });
      }
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (Exception localException)
    {
      Throwable localThrowable;
      if ((localException instanceof InvocationTargetException)) {
        localThrowable = localException.getCause();
      }
      throw new RuntimeException("Unable to inject views for " + paramObject1, localThrowable);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     butterknife.ButterKnife
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */