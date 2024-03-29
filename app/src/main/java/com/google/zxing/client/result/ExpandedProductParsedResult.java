package com.google.zxing.client.result;

import java.util.Map;

public final class ExpandedProductParsedResult
  extends ParsedResult
{
  private final String a;
  private final String b;
  private final String c;
  private final String d;
  private final String e;
  private final String f;
  private final String g;
  private final String h;
  private final String i;
  private final String j;
  private final String k;
  private final String l;
  private final String m;
  private final String n;
  private final Map<String, String> o;
  
  public ExpandedProductParsedResult(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, Map<String, String> paramMap)
  {
    super(ParsedResultType.c);
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
    this.e = paramString5;
    this.f = paramString6;
    this.g = paramString7;
    this.h = paramString8;
    this.i = paramString9;
    this.j = paramString10;
    this.k = paramString11;
    this.l = paramString12;
    this.m = paramString13;
    this.n = paramString14;
    this.o = paramMap;
  }
  
  private static int a(Object paramObject)
  {
    if (paramObject == null) {
      return 0;
    }
    return paramObject.hashCode();
  }
  
  private static boolean a(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null) {
      return paramObject2 == null;
    }
    return paramObject1.equals(paramObject2);
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ExpandedProductParsedResult)) {}
    ExpandedProductParsedResult localExpandedProductParsedResult;
    do
    {
      return false;
      localExpandedProductParsedResult = (ExpandedProductParsedResult)paramObject;
    } while ((!a(this.b, localExpandedProductParsedResult.b)) || (!a(this.c, localExpandedProductParsedResult.c)) || (!a(this.d, localExpandedProductParsedResult.d)) || (!a(this.e, localExpandedProductParsedResult.e)) || (!a(this.g, localExpandedProductParsedResult.g)) || (!a(this.h, localExpandedProductParsedResult.h)) || (!a(this.i, localExpandedProductParsedResult.i)) || (!a(this.j, localExpandedProductParsedResult.j)) || (!a(this.k, localExpandedProductParsedResult.k)) || (!a(this.l, localExpandedProductParsedResult.l)) || (!a(this.m, localExpandedProductParsedResult.m)) || (!a(this.n, localExpandedProductParsedResult.n)) || (!a(this.o, localExpandedProductParsedResult.o)));
    return true;
  }
  
  public String g()
  {
    return String.valueOf(this.a);
  }
  
  public int hashCode()
  {
    return 0x0 ^ a(this.b) ^ a(this.c) ^ a(this.d) ^ a(this.e) ^ a(this.g) ^ a(this.h) ^ a(this.i) ^ a(this.j) ^ a(this.k) ^ a(this.l) ^ a(this.m) ^ a(this.n) ^ a(this.o);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.result.ExpandedProductParsedResult
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */