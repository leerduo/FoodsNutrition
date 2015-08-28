package com.google.zxing.client.result;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class CalendarParsedResult
  extends ParsedResult
{
  private static final Pattern a = Pattern.compile("P(?:(\\d+)W)?(?:(\\d+)D)?(?:T(?:(\\d+)H)?(?:(\\d+)M)?(?:(\\d+)S)?)?");
  private static final long[] b = { 604800000L, 86400000L, 3600000L, 60000L, 1000L };
  private static final Pattern c = Pattern.compile("[0-9]{8}(T[0-9]{6}Z?)?");
  private final String d;
  private final Date e;
  private final boolean f;
  private final Date g;
  private final boolean h;
  private final String i;
  private final String j;
  private final String[] k;
  private final String l;
  private final double m;
  private final double n;
  
  public CalendarParsedResult(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String[] paramArrayOfString, String paramString7, double paramDouble1, double paramDouble2)
  {
    super(ParsedResultType.i);
    this.d = paramString1;
    for (;;)
    {
      long l1;
      try
      {
        this.e = a(paramString2);
        if (paramString3 != null) {
          break label161;
        }
        l1 = a(paramString4);
        if (l1 < 0L)
        {
          localDate = null;
          this.g = localDate;
          if (paramString2.length() != 8) {
            break label187;
          }
          bool1 = true;
          this.f = bool1;
          if ((paramString3 == null) || (paramString3.length() != 8)) {
            break label193;
          }
          bool2 = true;
          this.h = bool2;
          this.i = paramString5;
          this.j = paramString6;
          this.k = paramArrayOfString;
          this.l = paramString7;
          this.m = paramDouble1;
          this.n = paramDouble2;
          return;
        }
      }
      catch (ParseException localParseException1)
      {
        throw new IllegalArgumentException(localParseException1.toString());
      }
      Date localDate = new Date(l1 + this.e.getTime());
      continue;
      try
      {
        label161:
        this.g = a(paramString3);
      }
      catch (ParseException localParseException2)
      {
        throw new IllegalArgumentException(localParseException2.toString());
      }
      label187:
      boolean bool1 = false;
      continue;
      label193:
      boolean bool2 = false;
    }
  }
  
  private static long a(CharSequence paramCharSequence)
  {
    long l1 = -1L;
    if (paramCharSequence == null) {}
    for (;;)
    {
      return l1;
      Matcher localMatcher = a.matcher(paramCharSequence);
      if (localMatcher.matches())
      {
        l1 = 0L;
        for (int i1 = 0; i1 < b.length; i1++)
        {
          String str = localMatcher.group(i1 + 1);
          if (str != null) {
            l1 += b[i1] * Integer.parseInt(str);
          }
        }
      }
    }
  }
  
  private static String a(boolean paramBoolean, Date paramDate)
  {
    if (paramDate == null) {
      return null;
    }
    if (paramBoolean) {}
    for (DateFormat localDateFormat = DateFormat.getDateInstance(2);; localDateFormat = DateFormat.getDateTimeInstance(2, 2)) {
      return localDateFormat.format(paramDate);
    }
  }
  
  private static DateFormat a()
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH);
    localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
    return localSimpleDateFormat;
  }
  
  private static Date a(String paramString)
  {
    if (!c.matcher(paramString).matches()) {
      throw new ParseException(paramString, 0);
    }
    if (paramString.length() == 8) {
      return a().parse(paramString);
    }
    if ((paramString.length() == 16) && (paramString.charAt(15) == 'Z'))
    {
      Date localDate = b().parse(paramString.substring(0, 15));
      GregorianCalendar localGregorianCalendar = new GregorianCalendar();
      long l1 = localDate.getTime() + localGregorianCalendar.get(15);
      localGregorianCalendar.setTime(new Date(l1));
      return new Date(l1 + localGregorianCalendar.get(16));
    }
    return b().parse(paramString);
  }
  
  private static DateFormat b()
  {
    return new SimpleDateFormat("yyyyMMdd'T'HHmmss", Locale.ENGLISH);
  }
  
  public String g()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    a(this.d, localStringBuilder);
    a(a(this.f, this.e), localStringBuilder);
    a(a(this.h, this.g), localStringBuilder);
    a(this.i, localStringBuilder);
    a(this.j, localStringBuilder);
    a(this.k, localStringBuilder);
    a(this.l, localStringBuilder);
    return localStringBuilder.toString();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.result.CalendarParsedResult
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */