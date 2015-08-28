package com.google.zxing.client.android.encode;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class VCardFieldFormatter
  implements Formatter
{
  private static final Pattern a = Pattern.compile("([\\\\,;])");
  private static final Pattern b = Pattern.compile("\\n");
  private final List<Map<String, Set<String>>> c;
  
  VCardFieldFormatter()
  {
    this(null);
  }
  
  VCardFieldFormatter(List<Map<String, Set<String>>> paramList)
  {
    this.c = paramList;
  }
  
  private static CharSequence a(CharSequence paramCharSequence, Map<String, Set<String>> paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramMap != null)
    {
      Iterator localIterator1 = paramMap.entrySet().iterator();
      while (localIterator1.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator1.next();
        Set localSet = (Set)localEntry.getValue();
        if ((localSet != null) && (!localSet.isEmpty()))
        {
          localStringBuilder.append(';').append((String)localEntry.getKey()).append('=');
          if (localSet.size() > 1) {
            localStringBuilder.append('"');
          }
          Iterator localIterator2 = localSet.iterator();
          localStringBuilder.append((String)localIterator2.next());
          while (localIterator2.hasNext()) {
            localStringBuilder.append(',').append((String)localIterator2.next());
          }
          if (localSet.size() > 1) {
            localStringBuilder.append('"');
          }
        }
      }
    }
    localStringBuilder.append(':').append(paramCharSequence);
    return localStringBuilder;
  }
  
  public CharSequence a(CharSequence paramCharSequence, int paramInt)
  {
    String str1 = a.matcher(paramCharSequence).replaceAll("\\\\$1");
    String str2 = b.matcher(str1).replaceAll("");
    if ((this.c == null) || (this.c.size() <= paramInt)) {}
    for (Map localMap = null;; localMap = (Map)this.c.get(paramInt)) {
      return a(str2, localMap);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.android.encode.VCardFieldFormatter
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */