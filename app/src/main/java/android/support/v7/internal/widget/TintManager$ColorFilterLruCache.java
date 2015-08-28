package android.support.v7.internal.widget;

import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.support.v4.util.LruCache;

class TintManager$ColorFilterLruCache
  extends LruCache<Integer, PorterDuffColorFilter>
{
  public TintManager$ColorFilterLruCache(int paramInt)
  {
    super(paramInt);
  }
  
  private static int b(int paramInt, PorterDuff.Mode paramMode)
  {
    return 31 * (paramInt + 31) + paramMode.hashCode();
  }
  
  PorterDuffColorFilter a(int paramInt, PorterDuff.Mode paramMode)
  {
    return (PorterDuffColorFilter)get(Integer.valueOf(b(paramInt, paramMode)));
  }
  
  PorterDuffColorFilter a(int paramInt, PorterDuff.Mode paramMode, PorterDuffColorFilter paramPorterDuffColorFilter)
  {
    return (PorterDuffColorFilter)put(Integer.valueOf(b(paramInt, paramMode)), paramPorterDuffColorFilter);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.TintManager.ColorFilterLruCache
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */