package com.google.zxing.client.android.encode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class MECARDContactEncoder$MECARDFieldFormatter
  implements Formatter
{
  private static final Pattern a = Pattern.compile("([\\\\:;])");
  private static final Pattern b = Pattern.compile("\\n");
  
  public CharSequence a(CharSequence paramCharSequence, int paramInt)
  {
    return ':' + b.matcher(a.matcher(paramCharSequence).replaceAll("\\\\$1")).replaceAll("");
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.android.encode.MECARDContactEncoder.MECARDFieldFormatter
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */