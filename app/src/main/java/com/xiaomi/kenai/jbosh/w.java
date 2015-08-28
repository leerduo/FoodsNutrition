package com.xiaomi.kenai.jbosh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EventObject;
import java.util.List;

public final class w
  extends EventObject
{
  private final boolean a;
  private final List<ai> b;
  private final Throwable c;
  
  private w(s params, boolean paramBoolean, List<ai> paramList, Throwable paramThrowable)
  {
    super(params);
    this.a = paramBoolean;
    this.c = paramThrowable;
    if (this.a)
    {
      if (paramThrowable != null) {
        throw new IllegalStateException("Cannot be connected and have a cause");
      }
      if ((paramList != null) && (paramList.size() > 0)) {
        throw new IllegalStateException("Cannot be connected and have outstanding requests");
      }
    }
    if (paramList == null)
    {
      this.b = Collections.emptyList();
      return;
    }
    this.b = Collections.unmodifiableList(new ArrayList(paramList));
  }
  
  static w a(s params)
  {
    return new w(params, true, null, null);
  }
  
  static w a(s params, List<ai> paramList, Throwable paramThrowable)
  {
    return new w(params, false, paramList, paramThrowable);
  }
  
  static w b(s params)
  {
    return new w(params, false, null, null);
  }
  
  public boolean a()
  {
    return this.a;
  }
  
  public Throwable b()
  {
    return this.c;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.kenai.jbosh.w
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */