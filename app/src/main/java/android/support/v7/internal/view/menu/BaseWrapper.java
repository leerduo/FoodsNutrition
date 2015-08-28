package android.support.v7.internal.view.menu;

class BaseWrapper<T>
{
  final T b;
  
  BaseWrapper(T paramT)
  {
    if (paramT == null) {
      throw new IllegalArgumentException("Wrapped Object can not be null.");
    }
    this.b = paramT;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.view.menu.BaseWrapper
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */