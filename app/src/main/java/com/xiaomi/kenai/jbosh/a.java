package com.xiaomi.kenai.jbosh;

abstract class a<T extends Comparable>
  implements Comparable
{
  private final T a;
  
  protected a(T paramT)
  {
    this.a = paramT;
  }
  
  public final T a()
  {
    return this.a;
  }
  
  public int compareTo(Object paramObject)
  {
    if (paramObject == null) {
      return 1;
    }
    return this.a.compareTo(paramObject);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    while (!(paramObject instanceof a)) {
      return false;
    }
    a locala = (a)paramObject;
    return this.a.equals(locala.a);
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
  
  public String toString()
  {
    return this.a.toString();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.kenai.jbosh.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */