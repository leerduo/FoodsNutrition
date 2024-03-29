package android.support.v4.util;

public class Pools$SynchronizedPool<T>
  extends Pools.SimplePool<T>
{
  private final Object mLock = new Object();
  
  public Pools$SynchronizedPool(int paramInt)
  {
    super(paramInt);
  }
  
  public T acquire()
  {
    synchronized (this.mLock)
    {
      Object localObject3 = super.acquire();
      return localObject3;
    }
  }
  
  public boolean release(T paramT)
  {
    synchronized (this.mLock)
    {
      boolean bool = super.release(paramT);
      return bool;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.util.Pools.SynchronizedPool
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */