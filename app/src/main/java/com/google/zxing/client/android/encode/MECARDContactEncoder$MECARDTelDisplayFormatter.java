package com.google.zxing.client.android.encode;

import android.telephony.PhoneNumberUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class MECARDContactEncoder$MECARDTelDisplayFormatter
  implements Formatter
{
  private static final Pattern a = Pattern.compile("[^0-9]+");
  
  public CharSequence a(CharSequence paramCharSequence, int paramInt)
  {
    return a.matcher(PhoneNumberUtils.formatNumber(paramCharSequence.toString())).replaceAll("");
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.android.encode.MECARDContactEncoder.MECARDTelDisplayFormatter
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */