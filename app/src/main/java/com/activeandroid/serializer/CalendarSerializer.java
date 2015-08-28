package com.activeandroid.serializer;

import java.util.Calendar;

public final class CalendarSerializer
  extends TypeSerializer
{
  public Class<?> a()
  {
    return Calendar.class;
  }
  
  public Long a(Object paramObject)
  {
    return Long.valueOf(((Calendar)paramObject).getTimeInMillis());
  }
  
  public Class<?> b()
  {
    return Long.TYPE;
  }
  
  public Calendar b(Object paramObject)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(((Long)paramObject).longValue());
    return localCalendar;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.activeandroid.serializer.CalendarSerializer
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */