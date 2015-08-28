package com.google.zxing.client.androidlegacy.encode;

import android.telephony.PhoneNumberUtils;

class MECARDContactEncoder$3
  implements Formatter
{
  MECARDContactEncoder$3(MECARDContactEncoder paramMECARDContactEncoder) {}
  
  public String a(String paramString)
  {
    return MECARDContactEncoder.a(PhoneNumberUtils.formatNumber(paramString));
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.androidlegacy.encode.MECARDContactEncoder.3
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */