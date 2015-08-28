package com.google.zxing.client.androidlegacy.encode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class MECARDContactEncoder$2
  implements Formatter
{
  MECARDContactEncoder$2(MECARDContactEncoder paramMECARDContactEncoder) {}
  
  public String a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return MECARDContactEncoder.c().matcher(paramString).replaceAll("");
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.androidlegacy.encode.MECARDContactEncoder.2
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */