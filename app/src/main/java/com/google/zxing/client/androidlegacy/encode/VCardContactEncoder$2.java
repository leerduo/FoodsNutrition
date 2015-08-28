package com.google.zxing.client.androidlegacy.encode;

import android.telephony.PhoneNumberUtils;

class VCardContactEncoder$2
  implements Formatter
{
  VCardContactEncoder$2(VCardContactEncoder paramVCardContactEncoder) {}
  
  public String a(String paramString)
  {
    return PhoneNumberUtils.formatNumber(paramString);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.androidlegacy.encode.VCardContactEncoder.2
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */