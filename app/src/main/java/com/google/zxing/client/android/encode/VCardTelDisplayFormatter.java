package com.google.zxing.client.android.encode;

import android.telephony.PhoneNumberUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class VCardTelDisplayFormatter
  implements Formatter
{
  private final List<Map<String, Set<String>>> a;
  
  VCardTelDisplayFormatter()
  {
    this(null);
  }
  
  VCardTelDisplayFormatter(List<Map<String, Set<String>>> paramList)
  {
    this.a = paramList;
  }
  
  private static CharSequence a(CharSequence paramCharSequence, Map<String, Set<String>> paramMap)
  {
    if ((paramMap == null) || (paramMap.isEmpty())) {
      return paramCharSequence;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator1 = paramMap.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Set localSet = (Set)((Map.Entry)localIterator1.next()).getValue();
      if ((localSet != null) && (!localSet.isEmpty()))
      {
        Iterator localIterator2 = localSet.iterator();
        localStringBuilder.append((String)localIterator2.next());
        while (localIterator2.hasNext()) {
          localStringBuilder.append(',').append((String)localIterator2.next());
        }
      }
    }
    if (localStringBuilder.length() > 0) {
      localStringBuilder.append(' ');
    }
    localStringBuilder.append(paramCharSequence);
    return localStringBuilder;
  }
  
  public CharSequence a(CharSequence paramCharSequence, int paramInt)
  {
    String str = PhoneNumberUtils.formatNumber(paramCharSequence.toString());
    if ((this.a == null) || (this.a.size() <= paramInt)) {}
    for (Map localMap = null;; localMap = (Map)this.a.get(paramInt)) {
      return a(str, localMap);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.android.encode.VCardTelDisplayFormatter
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */