package com.android.volley.toolbox;

import com.android.volley.Cache.Entry;
import com.android.volley.NetworkResponse;
import java.util.Date;
import java.util.Map;
import org.apache.http.impl.cookie.DateParseException;
import org.apache.http.impl.cookie.DateUtils;

public class HttpHeaderParser
{
  public static long a(String paramString)
  {
    try
    {
      long l = DateUtils.parseDate(paramString).getTime();
      return l;
    }
    catch (DateParseException localDateParseException) {}
    return 0L;
  }
  
  public static Cache.Entry a(NetworkResponse paramNetworkResponse)
  {
    long l1 = 0L;
    long l2 = System.currentTimeMillis();
    Map localMap = paramNetworkResponse.c;
    String str1 = (String)localMap.get("Date");
    if (str1 != null) {}
    for (long l3 = a(str1);; l3 = l1)
    {
      String str2 = (String)localMap.get("Cache-Control");
      long l4;
      if (str2 != null)
      {
        String[] arrayOfString = str2.split(",");
        int j = 0;
        long l6 = l1;
        if (j < arrayOfString.length)
        {
          String str5 = arrayOfString[j].trim();
          if ((str5.equals("no-cache")) || (str5.equals("no-store"))) {
            return null;
          }
          if (str5.startsWith("max-age=")) {}
          for (;;)
          {
            try
            {
              long l7 = Long.parseLong(str5.substring(8));
              l6 = l7;
              j++;
            }
            catch (Exception localException)
            {
              continue;
              l5 = l1;
              continue;
            }
            if ((str5.equals("must-revalidate")) || (str5.equals("proxy-revalidate"))) {
              l6 = l1;
            }
          }
        }
        l4 = l6;
      }
      for (int i = 1;; i = 0)
      {
        String str3 = (String)localMap.get("Expires");
        long l5;
        if (str3 != null)
        {
          l5 = a(str3);
          String str4 = (String)localMap.get("ETag");
          if (i != 0) {}
          for (l1 = l2 + 1000L * l4;; l1 = l2 + (l5 - l3)) {
            do
            {
              Cache.Entry localEntry = new Cache.Entry();
              localEntry.a = paramNetworkResponse.b;
              localEntry.b = str4;
              localEntry.e = l1;
              localEntry.d = localEntry.e;
              localEntry.c = l3;
              localEntry.f = localMap;
              return localEntry;
            } while ((l3 <= l1) || (l5 < l3));
          }
        }
        l4 = l1;
      }
    }
  }
  
  public static String a(Map<String, String> paramMap)
  {
    String str = (String)paramMap.get("Content-Type");
    if (str != null)
    {
      String[] arrayOfString1 = str.split(";");
      for (int i = 1; i < arrayOfString1.length; i++)
      {
        String[] arrayOfString2 = arrayOfString1[i].trim().split("=");
        if ((arrayOfString2.length == 2) && (arrayOfString2[0].equals("charset"))) {
          return arrayOfString2[1];
        }
      }
    }
    return "ISO-8859-1";
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.android.volley.toolbox.HttpHeaderParser
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */