package com.google.zxing.client.android.encode;

import java.util.List;

final class MECARDContactEncoder
  extends ContactEncoder
{
  public String[] a(List<String> paramList1, String paramString1, List<String> paramList2, List<String> paramList3, List<String> paramList4, List<String> paramList5, List<String> paramList6, String paramString2)
  {
    StringBuilder localStringBuilder1 = new StringBuilder(100);
    localStringBuilder1.append("MECARD:");
    StringBuilder localStringBuilder2 = new StringBuilder(100);
    MECARDContactEncoder.MECARDFieldFormatter localMECARDFieldFormatter = new MECARDContactEncoder.MECARDFieldFormatter(null);
    a(localStringBuilder1, localStringBuilder2, "N", paramList1, 1, new MECARDContactEncoder.MECARDNameDisplayFormatter(null), localMECARDFieldFormatter, ';');
    a(localStringBuilder1, localStringBuilder2, "ORG", paramString1, localMECARDFieldFormatter, ';');
    a(localStringBuilder1, localStringBuilder2, "ADR", paramList2, 1, null, localMECARDFieldFormatter, ';');
    a(localStringBuilder1, localStringBuilder2, "TEL", paramList3, 2147483647, new MECARDContactEncoder.MECARDTelDisplayFormatter(null), localMECARDFieldFormatter, ';');
    a(localStringBuilder1, localStringBuilder2, "EMAIL", paramList5, 2147483647, null, localMECARDFieldFormatter, ';');
    a(localStringBuilder1, localStringBuilder2, "URL", paramList6, 2147483647, null, localMECARDFieldFormatter, ';');
    a(localStringBuilder1, localStringBuilder2, "NOTE", paramString2, localMECARDFieldFormatter, ';');
    localStringBuilder1.append(';');
    String[] arrayOfString = new String[2];
    arrayOfString[0] = localStringBuilder1.toString();
    arrayOfString[1] = localStringBuilder2.toString();
    return arrayOfString;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.android.encode.MECARDContactEncoder
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */