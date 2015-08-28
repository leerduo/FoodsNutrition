package com.google.zxing.client.androidlegacy.encode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class MECARDContactEncoder$1
  implements Formatter
{
  public String a(String paramString)
  {
    return MECARDContactEncoder.b().matcher(MECARDContactEncoder.a().matcher(paramString).replaceAll("\\\\$1")).replaceAll("");
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.androidlegacy.encode.MECARDContactEncoder.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */