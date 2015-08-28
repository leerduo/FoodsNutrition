package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class VCardResultParser
  extends ResultParser
{
  private static final Pattern a = Pattern.compile("BEGIN:VCARD", 2);
  private static final Pattern b = Pattern.compile("\\d{4}-?\\d{2}-?\\d{2}");
  private static final Pattern c = Pattern.compile("\r\n[ \t]");
  private static final Pattern d = Pattern.compile("\\\\[nN]");
  private static final Pattern e = Pattern.compile("\\\\([,;\\\\])");
  private static final Pattern f = Pattern.compile("=");
  private static final Pattern g = Pattern.compile(";");
  private static final Pattern h = Pattern.compile("(?<!\\\\);+");
  private static final Pattern i = Pattern.compile(",");
  private static final Pattern j = Pattern.compile("[;,]");
  
  private static String a(CharSequence paramCharSequence, String paramString)
  {
    int k = paramCharSequence.length();
    StringBuilder localStringBuilder = new StringBuilder(k);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    int m = 0;
    if (m < k)
    {
      char c1 = paramCharSequence.charAt(m);
      switch (c1)
      {
      default: 
        a(localByteArrayOutputStream, paramString, localStringBuilder);
        localStringBuilder.append(c1);
      }
      for (;;)
      {
        m++;
        break;
        if (m < k - 2)
        {
          char c2 = paramCharSequence.charAt(m + 1);
          if ((c2 != '\r') && (c2 != '\n'))
          {
            char c3 = paramCharSequence.charAt(m + 2);
            int n = a(c2);
            int i1 = a(c3);
            if ((n >= 0) && (i1 >= 0)) {
              localByteArrayOutputStream.write(i1 + (n << 4));
            }
            m += 2;
          }
        }
      }
    }
    a(localByteArrayOutputStream, paramString, localStringBuilder);
    return localStringBuilder.toString();
  }
  
  private static String a(List<String> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    return (String)paramList.get(0);
  }
  
  static List<List<String>> a(CharSequence paramCharSequence, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = null;
    int k = 0;
    int m = paramString.length();
    Matcher localMatcher;
    if (k < m)
    {
      localMatcher = Pattern.compile("(?:^|\n)" + paramCharSequence + "(?:;([^:]*))?:", 2).matcher(paramString);
      if (k > 0) {
        k--;
      }
      if (localMatcher.find(k)) {}
    }
    else
    {
      return localObject1;
    }
    int n = localMatcher.end(0);
    String str1 = localMatcher.group(1);
    ArrayList localArrayList1 = null;
    int i1 = 0;
    Object localObject2 = null;
    int i6;
    label214:
    Object localObject3;
    if (str1 != null)
    {
      String[] arrayOfString1 = g.split(str1);
      int i4 = arrayOfString1.length;
      int i5 = 0;
      if (i5 < i4)
      {
        String str6 = arrayOfString1[i5];
        if (localArrayList1 == null) {
          localArrayList1 = new ArrayList(1);
        }
        localArrayList1.add(str6);
        String[] arrayOfString2 = f.split(str6, 2);
        if (arrayOfString2.length > 1)
        {
          String str7 = arrayOfString2[0];
          String str8 = arrayOfString2[1];
          if (("ENCODING".equalsIgnoreCase(str7)) && ("QUOTED-PRINTABLE".equalsIgnoreCase(str8))) {}
          for (i6 = 1;; i6 = i1)
          {
            i5++;
            i1 = i6;
            break;
            if (!"CHARSET".equalsIgnoreCase(str7)) {
              break label640;
            }
            localObject2 = str8;
          }
        }
      }
      else
      {
        localObject3 = localObject2;
      }
    }
    for (ArrayList localArrayList2 = localArrayList1;; localArrayList2 = null)
    {
      int i2 = n;
      int i3;
      for (;;)
      {
        i3 = paramString.indexOf('\n', i2);
        if (i3 < 0) {
          break;
        }
        if ((i3 < -1 + paramString.length()) && ((paramString.charAt(i3 + 1) == ' ') || (paramString.charAt(i3 + 1) == '\t')))
        {
          i2 = i3 + 2;
        }
        else
        {
          if ((i1 == 0) || (((i3 < 1) || (paramString.charAt(i3 - 1) != '=')) && ((i3 < 2) || (paramString.charAt(i3 - 2) != '=')))) {
            break;
          }
          i2 = i3 + 1;
        }
      }
      if (i3 < 0)
      {
        k = m;
        break;
      }
      if (i3 > n) {
        if (localObject1 != null) {
          break label633;
        }
      }
      label483:
      label633:
      for (Object localObject4 = new ArrayList(1);; localObject4 = localObject1)
      {
        if ((i3 >= 1) && (paramString.charAt(i3 - 1) == '\r')) {
          i3--;
        }
        String str2 = paramString.substring(n, i3);
        if (paramBoolean1) {
          str2 = str2.trim();
        }
        String str5;
        if (i1 != 0)
        {
          str5 = a(str2, localObject3);
          if (paramBoolean2) {
            str5 = h.matcher(str5).replaceAll("\n").trim();
          }
          if (localArrayList2 != null) {
            break label601;
          }
          ArrayList localArrayList3 = new ArrayList(1);
          localArrayList3.add(str5);
          ((List)localObject4).add(localArrayList3);
        }
        for (;;)
        {
          k = i3 + 1;
          localObject1 = localObject4;
          break;
          if (paramBoolean2) {
            str2 = h.matcher(str2).replaceAll("\n").trim();
          }
          String str3 = c.matcher(str2).replaceAll("");
          String str4 = d.matcher(str3).replaceAll("\n");
          str5 = e.matcher(str4).replaceAll("$1");
          break label483;
          localArrayList2.add(0, str5);
          ((List)localObject4).add(localArrayList2);
        }
        k = i3 + 1;
        break;
      }
      label601:
      i6 = i1;
      label640:
      break label214;
      localObject3 = null;
      i1 = 0;
    }
  }
  
  private static void a(ByteArrayOutputStream paramByteArrayOutputStream, String paramString, StringBuilder paramStringBuilder)
  {
    byte[] arrayOfByte;
    String str;
    if (paramByteArrayOutputStream.size() > 0)
    {
      arrayOfByte = paramByteArrayOutputStream.toByteArray();
      if (paramString != null) {
        break label43;
      }
      str = new String(arrayOfByte, Charset.forName("UTF-8"));
    }
    for (;;)
    {
      paramByteArrayOutputStream.reset();
      paramStringBuilder.append(str);
      return;
      try
      {
        label43:
        str = new String(arrayOfByte, paramString);
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        str = new String(arrayOfByte, Charset.forName("UTF-8"));
      }
    }
  }
  
  private static void a(Iterable<List<String>> paramIterable)
  {
    if (paramIterable != null)
    {
      Iterator localIterator = paramIterable.iterator();
      while (localIterator.hasNext())
      {
        List localList = (List)localIterator.next();
        String str = (String)localList.get(0);
        String[] arrayOfString = new String[5];
        int k = 0;
        int n;
        for (int m = 0; k < -1 + arrayOfString.length; m = n + 1)
        {
          n = str.indexOf(';', m);
          if (n < 0) {
            break;
          }
          arrayOfString[k] = str.substring(m, n);
          k++;
        }
        arrayOfString[k] = str.substring(m);
        StringBuilder localStringBuilder = new StringBuilder(100);
        a(arrayOfString, 3, localStringBuilder);
        a(arrayOfString, 1, localStringBuilder);
        a(arrayOfString, 2, localStringBuilder);
        a(arrayOfString, 0, localStringBuilder);
        a(arrayOfString, 4, localStringBuilder);
        localList.set(0, localStringBuilder.toString().trim());
      }
    }
  }
  
  private static void a(String[] paramArrayOfString, int paramInt, StringBuilder paramStringBuilder)
  {
    if ((paramArrayOfString[paramInt] != null) && (!paramArrayOfString[paramInt].isEmpty()))
    {
      if (paramStringBuilder.length() > 0) {
        paramStringBuilder.append(' ');
      }
      paramStringBuilder.append(paramArrayOfString[paramInt]);
    }
  }
  
  private static boolean a(CharSequence paramCharSequence)
  {
    return (paramCharSequence == null) || (b.matcher(paramCharSequence).matches());
  }
  
  private static String[] a(Collection<List<String>> paramCollection)
  {
    if ((paramCollection == null) || (paramCollection.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramCollection.size());
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)((List)localIterator.next()).get(0);
      if ((str != null) && (!str.isEmpty())) {
        localArrayList.add(str);
      }
    }
    return (String[])localArrayList.toArray(new String[paramCollection.size()]);
  }
  
  static List<String> b(CharSequence paramCharSequence, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    List localList = a(paramCharSequence, paramString, paramBoolean1, paramBoolean2);
    if ((localList == null) || (localList.isEmpty())) {
      return null;
    }
    return (List)localList.get(0);
  }
  
  private static String[] b(Collection<List<String>> paramCollection)
  {
    if ((paramCollection == null) || (paramCollection.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramCollection.size());
    Iterator localIterator = paramCollection.iterator();
    int k;
    label58:
    String str;
    int m;
    if (localIterator.hasNext())
    {
      List localList = (List)localIterator.next();
      k = 1;
      if (k >= localList.size()) {
        break label164;
      }
      str = (String)localList.get(k);
      m = str.indexOf('=');
      if (m >= 0) {}
    }
    for (;;)
    {
      localArrayList.add(str);
      break;
      if ("TYPE".equalsIgnoreCase(str.substring(0, m)))
      {
        str = str.substring(m + 1);
      }
      else
      {
        k++;
        break label58;
        return (String[])localArrayList.toArray(new String[paramCollection.size()]);
        label164:
        str = null;
      }
    }
  }
  
  public AddressBookParsedResult a(Result paramResult)
  {
    String str = c(paramResult);
    Matcher localMatcher = a.matcher(str);
    if ((!localMatcher.find()) || (localMatcher.start() != 0)) {
      return null;
    }
    List localList1 = a("FN", str, true, false);
    if (localList1 == null)
    {
      localList1 = a("N", str, true, false);
      a(localList1);
    }
    List localList2 = localList1;
    List localList3 = b("NICKNAME", str, true, false);
    String[] arrayOfString1;
    List localList4;
    List localList5;
    List localList6;
    List localList7;
    List localList8;
    List localList9;
    if (localList3 == null)
    {
      arrayOfString1 = null;
      localList4 = a("TEL", str, true, false);
      localList5 = a("EMAIL", str, true, false);
      localList6 = b("NOTE", str, false, false);
      localList7 = a("ADR", str, true, true);
      localList8 = b("ORG", str, true, true);
      localList9 = b("BDAY", str, true, false);
      if ((localList9 == null) || (a((CharSequence)localList9.get(0)))) {
        break label364;
      }
    }
    label364:
    for (List localList10 = null;; localList10 = localList9)
    {
      List localList11 = b("TITLE", str, true, false);
      List localList12 = a("URL", str, true, false);
      List localList13 = b("IMPP", str, true, false);
      List localList14 = b("GEO", str, true, false);
      if (localList14 == null) {}
      for (String[] arrayOfString2 = null;; arrayOfString2 = j.split((CharSequence)localList14.get(0)))
      {
        if ((arrayOfString2 != null) && (arrayOfString2.length != 2)) {
          arrayOfString2 = null;
        }
        return new AddressBookParsedResult(a(localList2), arrayOfString1, null, a(localList4), b(localList4), a(localList5), b(localList5), a(localList13), a(localList6), a(localList7), b(localList7), a(localList8), a(localList10), a(localList11), a(localList12), arrayOfString2);
        arrayOfString1 = i.split((CharSequence)localList3.get(0));
        break;
      }
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.result.VCardResultParser
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */