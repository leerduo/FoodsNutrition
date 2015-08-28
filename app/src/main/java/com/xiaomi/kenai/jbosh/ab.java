package com.xiaomi.kenai.jbosh;

import java.util.EventObject;

public final class ab
  extends EventObject
{
  private final b a;
  
  private ab(Object paramObject, b paramb)
  {
    super(paramObject);
    if (paramb == null) {
      throw new IllegalArgumentException("message body may not be null");
    }
    this.a = paramb;
  }
  
  static ab a(s params, b paramb)
  {
    return new ab(params, paramb);
  }
  
  static ab b(s params, b paramb)
  {
    return new ab(params, paramb);
  }
  
  public b a()
  {
    return this.a;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.kenai.jbosh.ab
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */