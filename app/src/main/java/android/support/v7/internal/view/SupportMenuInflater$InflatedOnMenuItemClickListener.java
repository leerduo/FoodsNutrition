package android.support.v7.internal.view;

import android.view.InflateException;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import java.lang.reflect.Method;

class SupportMenuInflater$InflatedOnMenuItemClickListener
  implements MenuItem.OnMenuItemClickListener
{
  private static final Class<?>[] a = { MenuItem.class };
  private Object b;
  private Method c;
  
  public SupportMenuInflater$InflatedOnMenuItemClickListener(Object paramObject, String paramString)
  {
    this.b = paramObject;
    Class localClass = paramObject.getClass();
    try
    {
      this.c = localClass.getMethod(paramString, a);
      return;
    }
    catch (Exception localException)
    {
      InflateException localInflateException = new InflateException("Couldn't resolve menu item onClick handler " + paramString + " in class " + localClass.getName());
      localInflateException.initCause(localException);
      throw localInflateException;
    }
  }
  
  public boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    try
    {
      if (this.c.getReturnType() == Boolean.TYPE) {
        return ((Boolean)this.c.invoke(this.b, new Object[] { paramMenuItem })).booleanValue();
      }
      this.c.invoke(this.b, new Object[] { paramMenuItem });
      return true;
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.view.SupportMenuInflater.InflatedOnMenuItemClickListener
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */