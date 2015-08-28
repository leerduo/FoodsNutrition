package android.support.v4.util;

public class Pools$SimplePool<T>
  implements Pools.Pool<T>
{
  private final Object[] mPool;
  private int mPoolSize;
  
  public Pools$SimplePool(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("The max pool size must be > 0");
    }
    this.mPool = new Object[paramInt];
  }
  
  private boolean isInPool(T paramT)
  {
    for (int i = 0;; i++)
    {
      int j = this.mPoolSize;
      boolean bool = false;
      if (i < j)
      {
        if (this.mPool[i] == paramT) {
          bool = true;
        }
      }
      else {
        return bool;
      }
    }
  }
  
  public T acquire()
  {
    if (this.mPoolSize > 0)
    {
      int i = -1 + this.mPoolSize;
      Object localObject = this.mPool[i];
      this.mPool[i] = null;
      this.mPoolSize = (-1 + this.mPoolSize);
      return localObject;
    }
    return null;
  }
  
  public boolean release(T paramT)
  {
    if (isInPool(paramT)) {
      throw new IllegalStateException("Already in the pool!");
    }
    if (this.mPoolSize < this.mPool.length)
    {
      this.mPool[this.mPoolSize] = paramT;
      this.mPoolSize = (1 + this.mPoolSize);
      return true;
    }
    return false;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.util.Pools.SimplePool
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */