package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.List;

public final class VEventResultParser
  extends ResultParser
{
  private static String a(CharSequence paramCharSequence, String paramString, boolean paramBoolean)
  {
    List localList = VCardResultParser.b(paramCharSequence, paramString, paramBoolean, false);
    if ((localList == null) || (localList.isEmpty())) {
      return null;
    }
    return (String)localList.get(0);
  }
  
  private static String a(String paramString)
  {
    if ((paramString != null) && ((paramString.startsWith("mailto:")) || (paramString.startsWith("MAILTO:")))) {
      paramString = paramString.substring(7);
    }
    return paramString;
  }
  
  private static String[] b(CharSequence paramCharSequence, String paramString, boolean paramBoolean)
  {
    List localList = VCardResultParser.a(paramCharSequence, paramString, paramBoolean, false);
    if ((localList == null) || (localList.isEmpty())) {
      return null;
    }
    int i = localList.size();
    String[] arrayOfString = new String[i];
    for (int j = 0; j < i; j++) {
      arrayOfString[j] = ((String)((List)localList.get(j)).get(0));
    }
    return arrayOfString;
  }
  
  public CalendarParsedResult a(Result paramResult)
  {
    String str1 = c(paramResult);
    if (str1.indexOf("BEGIN:VEVENT") < 0) {
      return null;
    }
    String str2 = a("SUMMARY", str1, true);
    String str3 = a("DTSTART", str1, true);
    if (str3 == null) {
      return null;
    }
    String str4 = a("DTEND", str1, true);
    String str5 = a("DURATION", str1, true);
    String str6 = a("LOCATION", str1, true);
    String str7 = a(a("ORGANIZER", str1, true));
    String[] arrayOfString = b("ATTENDEE", str1, true);
    if (arrayOfString != null) {
      for (int j = 0; j < arrayOfString.length; j++) {
        arrayOfString[j] = a(arrayOfString[j]);
      }
    }
    String str8 = a("DESCRIPTION", str1, true);
    String str9 = a("GEO", str1, true);
    double d1;
    double d3;
    if (str9 == null)
    {
      d1 = (0.0D / 0.0D);
      d3 = (0.0D / 0.0D);
    }
    for (;;)
    {
      try
      {
        CalendarParsedResult localCalendarParsedResult = new CalendarParsedResult(str2, str3, str4, str5, str6, str7, arrayOfString, str8, d1, d3);
        return localCalendarParsedResult;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        return null;
      }
      int i = str9.indexOf(';');
      if (i < 0) {
        return null;
      }
      try
      {
        d1 = Double.parseDouble(str9.substring(0, i));
        double d2 = Double.parseDouble(str9.substring(i + 1));
        d3 = d2;
      }
      catch (NumberFormatException localNumberFormatException) {}
    }
    return null;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.result.VEventResultParser
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */