package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class GeoResultParser
  extends ResultParser
{
  private static final Pattern a = Pattern.compile("geo:([\\-0-9.]+),([\\-0-9.]+)(?:,([\\-0-9.]+))?(?:\\?(.*))?", 2);
  
  public GeoParsedResult a(Result paramResult)
  {
    double d1 = 0.0D;
    String str1 = c(paramResult);
    Matcher localMatcher = a.matcher(str1);
    if (!localMatcher.matches()) {
      return null;
    }
    String str2 = localMatcher.group(4);
    for (;;)
    {
      double d4;
      try
      {
        double d2 = Double.parseDouble(localMatcher.group(1));
        if ((d2 > 90.0D) || (d2 < -90.0D)) {
          break;
        }
        double d3 = Double.parseDouble(localMatcher.group(2));
        if ((d3 > 180.0D) || (d3 < -180.0D)) {
          break label160;
        }
        String str3 = localMatcher.group(3);
        if (str3 == null) {
          return new GeoParsedResult(d2, d3, d1, str2);
        }
        d4 = Double.parseDouble(localMatcher.group(3));
        if (d4 < d1) {
          return null;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        return null;
      }
      d1 = d4;
    }
    return null;
    label160:
    return null;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.result.GeoResultParser
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */