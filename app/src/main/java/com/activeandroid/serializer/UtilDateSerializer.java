package com.activeandroid.serializer;

import java.util.Date;

public final class UtilDateSerializer
  extends TypeSerializer
{
  public Class<?> a()
  {
    return Date.class;
  }
  
  public Long a(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    return Long.valueOf(((Date)paramObject).getTime());
  }
  
  public Class<?> b()
  {
    return Long.TYPE;
  }
  
  public Date b(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    return new Date(((Long)paramObject).longValue());
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.activeandroid.serializer.UtilDateSerializer
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */