package com.boohee.food.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtils
{
  public static String a(Date paramDate, String paramString)
  {
    return new SimpleDateFormat(paramString).format(paramDate);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.util.DateFormatUtils
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */