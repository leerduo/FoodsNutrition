package com.xiaomi.channel.commonutils.string;

import android.net.Uri;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.security.InvalidParameterException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class b
{
  public static String a(String paramString)
  {
    try
    {
      String str = String.valueOf(a.a(MessageDigest.getInstance("SHA1").digest(paramString.getBytes("UTF-8"))));
      return str;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      com.xiaomi.channel.commonutils.logger.b.a("CloudCoder.hash4SHA1 ", localNoSuchAlgorithmException);
      throw new IllegalStateException("failed to SHA1");
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        com.xiaomi.channel.commonutils.logger.b.a("CloudCoder.hash4SHA1 ", localUnsupportedEncodingException);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.xiaomi.channel.commonutils.logger.b.a("CloudCoder.hash4SHA1 ", localException);
      }
    }
  }
  
  public static String a(String paramString1, String paramString2, Map<String, String> paramMap, String paramString3)
  {
    int i = 1;
    if (TextUtils.isEmpty(paramString3)) {
      throw new InvalidParameterException("security is not nullable");
    }
    ArrayList localArrayList = new ArrayList();
    if (paramString1 != null) {
      localArrayList.add(paramString1.toUpperCase());
    }
    if (paramString2 != null) {
      localArrayList.add(Uri.parse(paramString2).getEncodedPath());
    }
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      Iterator localIterator2 = new TreeMap(paramMap).entrySet().iterator();
      while (localIterator2.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator2.next();
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = localEntry.getKey();
        arrayOfObject[i] = localEntry.getValue();
        localArrayList.add(String.format("%s=%s", arrayOfObject));
      }
    }
    localArrayList.add(paramString3);
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator1 = localArrayList.iterator();
    while (localIterator1.hasNext())
    {
      String str = (String)localIterator1.next();
      if (i == 0) {
        localStringBuilder.append('&');
      }
      localStringBuilder.append(str);
      i = 0;
    }
    return a(localStringBuilder.toString());
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.channel.commonutils.string.b
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */