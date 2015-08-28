package com.google.zxing.client.androidlegacy.encode;

import java.util.regex.Pattern;

final class VCardContactEncoder
  extends ContactEncoder
{
  private static final Pattern a = Pattern.compile("([\\\\,;])");
  private static final Pattern b = Pattern.compile("\\n");
  private static final Formatter c = new VCardContactEncoder.1();
  
  private static void a(StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2, String paramString, Iterable<String> paramIterable, int paramInt, Formatter paramFormatter)
  {
    a(paramStringBuilder1, paramStringBuilder2, paramString, paramIterable, paramInt, paramFormatter, c, '\n');
  }
  
  private static void a(StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2, String paramString1, String paramString2)
  {
    a(paramStringBuilder1, paramStringBuilder2, paramString1, paramString2, c, '\n');
  }
  
  public String[] a(Iterable<String> paramIterable1, String paramString1, Iterable<String> paramIterable2, Iterable<String> paramIterable3, Iterable<String> paramIterable4, Iterable<String> paramIterable5, String paramString2)
  {
    StringBuilder localStringBuilder1 = new StringBuilder(100);
    localStringBuilder1.append("BEGIN:VCARD").append('\n');
    localStringBuilder1.append("VERSION:3.0").append('\n');
    StringBuilder localStringBuilder2 = new StringBuilder(100);
    a(localStringBuilder1, localStringBuilder2, "N", paramIterable1, 1, null);
    a(localStringBuilder1, localStringBuilder2, "ORG", paramString1);
    a(localStringBuilder1, localStringBuilder2, "ADR", paramIterable2, 1, null);
    a(localStringBuilder1, localStringBuilder2, "TEL", paramIterable3, 2147483647, new VCardContactEncoder.2(this));
    a(localStringBuilder1, localStringBuilder2, "EMAIL", paramIterable4, 2147483647, null);
    a(localStringBuilder1, localStringBuilder2, "URL", paramIterable5, 2147483647, null);
    a(localStringBuilder1, localStringBuilder2, "NOTE", paramString2);
    localStringBuilder1.append("END:VCARD").append('\n');
    String[] arrayOfString = new String[2];
    arrayOfString[0] = localStringBuilder1.toString();
    arrayOfString[1] = localStringBuilder2.toString();
    return arrayOfString;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.androidlegacy.encode.VCardContactEncoder
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */