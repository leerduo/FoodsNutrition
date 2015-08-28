package com.google.zxing.client.androidlegacy.common;

import android.os.Build.VERSION;
import android.util.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public abstract class PlatformSupportManager<T>
{
  private static final String a = PlatformSupportManager.class.getSimpleName();
  private final Class<T> b;
  private final T c;
  private final SortedMap<Integer, String> d;
  
  protected PlatformSupportManager(Class<T> paramClass, T paramT)
  {
    if (!paramClass.isInterface()) {
      throw new IllegalArgumentException();
    }
    if (!paramClass.isInstance(paramT)) {
      throw new IllegalArgumentException();
    }
    this.b = paramClass;
    this.c = paramT;
    this.d = new TreeMap(Collections.reverseOrder());
  }
  
  public final T a()
  {
    Iterator localIterator = this.d.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      if (Build.VERSION.SDK_INT >= localInteger.intValue())
      {
        String str = (String)this.d.get(localInteger);
        try
        {
          Class localClass = Class.forName(str).asSubclass(this.b);
          Log.i(a, "Using implementation " + localClass + " of " + this.b + " for SDK " + localInteger);
          Object localObject = localClass.getConstructor(new Class[0]).newInstance(new Object[0]);
          return localObject;
        }
        catch (ClassNotFoundException localClassNotFoundException)
        {
          Log.w(a, localClassNotFoundException);
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          Log.w(a, localIllegalAccessException);
        }
        catch (InstantiationException localInstantiationException)
        {
          Log.w(a, localInstantiationException);
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          Log.w(a, localNoSuchMethodException);
        }
        catch (InvocationTargetException localInvocationTargetException)
        {
          Log.w(a, localInvocationTargetException);
        }
      }
    }
    Log.i(a, "Using default implementation " + this.c.getClass() + " of " + this.b);
    return this.c;
  }
  
  protected final void a(int paramInt, String paramString)
  {
    this.d.put(Integer.valueOf(paramInt), paramString);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.androidlegacy.common.PlatformSupportManager
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */