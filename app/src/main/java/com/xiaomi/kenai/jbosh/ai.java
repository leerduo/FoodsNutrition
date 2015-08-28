package com.xiaomi.kenai.jbosh;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;

public final class ai
  extends b
{
  private static final Pattern a = Pattern.compile("<body(?:[\t\n\r ][^>]*?)?(/>|>)", 64);
  private final Map<ag, String> b;
  private final String c;
  private final AtomicReference<String> d = new AtomicReference();
  
  private ai(Map<ag, String> paramMap, String paramString)
  {
    this.b = paramMap;
    this.c = paramString;
  }
  
  public static ai.a a()
  {
    return new ai.a(null);
  }
  
  private String a(String paramString)
  {
    return paramString.replace("'", "&apos;");
  }
  
  private String g()
  {
    ag localag1 = f();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<");
    localStringBuilder.append(localag1.b());
    Iterator localIterator = this.b.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localStringBuilder.append(" ");
      ag localag2 = (ag)localEntry.getKey();
      String str = localag2.c();
      if ((str != null) && (str.length() > 0))
      {
        localStringBuilder.append(str);
        localStringBuilder.append(":");
      }
      localStringBuilder.append(localag2.b());
      localStringBuilder.append("='");
      localStringBuilder.append(a((String)localEntry.getValue()));
      localStringBuilder.append("'");
    }
    localStringBuilder.append(" ");
    localStringBuilder.append("xmlns");
    localStringBuilder.append("='");
    localStringBuilder.append(localag1.a());
    localStringBuilder.append("'>");
    if (this.c != null) {
      localStringBuilder.append(this.c);
    }
    localStringBuilder.append("</body>");
    return localStringBuilder.toString();
  }
  
  public ai.a b()
  {
    return ai.a.a(this);
  }
  
  public Map<ag, String> c()
  {
    return Collections.unmodifiableMap(this.b);
  }
  
  public String d()
  {
    String str = (String)this.d.get();
    if (str == null)
    {
      str = g();
      this.d.set(str);
    }
    return str;
  }
  
  public String e()
  {
    return this.c;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.kenai.jbosh.ai
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */