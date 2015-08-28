package com.xiaomi.network;

import android.text.TextUtils;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class Fallback
{
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  protected String h;
  private long i;
  private ArrayList<WeightedHost> j = new ArrayList();
  private String k;
  private double l = 0.1D;
  private String m = "s.mi1.cc";
  private long n = 86400000L;
  
  public Fallback(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("the host is empty");
    }
    this.i = System.currentTimeMillis();
    this.j.add(new WeightedHost(paramString, -1));
    this.a = HostManager.a().b();
    this.b = paramString;
  }
  
  private void d(String paramString)
  {
    try
    {
      Iterator localIterator = this.j.iterator();
      while (localIterator.hasNext()) {
        if (TextUtils.equals(((WeightedHost)localIterator.next()).a, paramString)) {
          localIterator.remove();
        }
      }
    }
    finally {}
  }
  
  public Fallback a(JSONObject paramJSONObject)
  {
    try
    {
      this.a = paramJSONObject.optString("net");
      this.n = paramJSONObject.getLong("ttl");
      this.l = paramJSONObject.getDouble("pct");
      this.i = paramJSONObject.getLong("ts");
      this.d = paramJSONObject.optString("city");
      this.c = paramJSONObject.optString("prv");
      this.g = paramJSONObject.optString("cty");
      this.e = paramJSONObject.optString("isp");
      this.f = paramJSONObject.optString("ip");
      this.b = paramJSONObject.optString("host");
      this.h = paramJSONObject.optString("xf");
      JSONArray localJSONArray = paramJSONObject.getJSONArray("fbs");
      for (int i1 = 0; i1 < localJSONArray.length(); i1++) {
        a(new WeightedHost().a(localJSONArray.getJSONObject(i1)));
      }
      return this;
    }
    finally {}
  }
  
  public ArrayList<String> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("the url is empty.");
    }
    URL localURL = new URL(paramString);
    ArrayList localArrayList;
    if (TextUtils.equals(localURL.getHost(), this.b))
    {
      localArrayList = new ArrayList();
      Iterator localIterator = c().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localArrayList.add(new URL(localURL.getProtocol(), str, localURL.getPort(), localURL.getFile()).toString());
      }
    }
    throw new IllegalArgumentException("the url is not supported by the fallback");
    return localArrayList;
  }
  
  public void a(double paramDouble)
  {
    this.l = paramDouble;
  }
  
  public void a(long paramLong)
  {
    if (paramLong <= 0L) {
      throw new IllegalArgumentException("the duration is invalid " + paramLong);
    }
    this.n = paramLong;
  }
  
  public void a(WeightedHost paramWeightedHost)
  {
    try
    {
      d(paramWeightedHost.a);
      this.j.add(paramWeightedHost);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(String paramString, int paramInt, long paramLong1, long paramLong2, Exception paramException)
  {
    a(paramString, new AccessHistory(paramInt, paramLong1, paramLong2, paramException));
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    a(paramString, 0, paramLong1, paramLong2, null);
  }
  
  public void a(String paramString, long paramLong1, long paramLong2, Exception paramException)
  {
    a(paramString, -1, paramLong1, paramLong2, paramException);
  }
  
  public void a(String paramString, AccessHistory paramAccessHistory)
  {
    try
    {
      Iterator localIterator = this.j.iterator();
      while (localIterator.hasNext())
      {
        WeightedHost localWeightedHost = (WeightedHost)localIterator.next();
        if (TextUtils.equals(paramString, localWeightedHost.a)) {
          localWeightedHost.a(paramAccessHistory);
        }
      }
      return;
    }
    finally {}
  }
  
  public void a(String[] paramArrayOfString)
  {
    for (;;)
    {
      int i1;
      int i3;
      int i4;
      int i6;
      int i5;
      try
      {
        i1 = -1 + this.j.size();
        if (i1 >= 0)
        {
          int i2 = paramArrayOfString.length;
          i3 = 0;
          if (i3 >= i2) {
            break label175;
          }
          String str = paramArrayOfString[i3];
          if (!TextUtils.equals(((WeightedHost)this.j.get(i1)).a, str)) {
            break label181;
          }
          this.j.remove(i1);
          break label175;
        }
        Iterator localIterator = this.j.iterator();
        i4 = 0;
        if (!localIterator.hasNext()) {
          break label194;
        }
        WeightedHost localWeightedHost = (WeightedHost)localIterator.next();
        if (localWeightedHost.b <= i4) {
          break label168;
        }
        i6 = localWeightedHost.b;
      }
      finally {}
      if (i5 < paramArrayOfString.length)
      {
        a(new WeightedHost(paramArrayOfString[i5], i4 + paramArrayOfString.length - i5));
        i5++;
      }
      else
      {
        return;
        label168:
        i6 = i4;
        break label187;
        label175:
        i1--;
        continue;
        label181:
        i3++;
        continue;
        label187:
        i4 = i6;
        continue;
        label194:
        i5 = 0;
      }
    }
  }
  
  public boolean a()
  {
    return TextUtils.equals(this.a, HostManager.a().b());
  }
  
  public boolean a(Fallback paramFallback)
  {
    return TextUtils.equals(this.a, paramFallback.a);
  }
  
  public void b(String paramString)
  {
    try
    {
      a(new WeightedHost(paramString));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean b()
  {
    return System.currentTimeMillis() - this.i < this.n;
  }
  
  public ArrayList<String> c()
  {
    try
    {
      WeightedHost[] arrayOfWeightedHost = new WeightedHost[this.j.size()];
      this.j.toArray(arrayOfWeightedHost);
      Arrays.sort(arrayOfWeightedHost);
      ArrayList localArrayList = new ArrayList();
      int i1 = arrayOfWeightedHost.length;
      for (int i2 = 0; i2 < i1; i2++) {
        localArrayList.add(arrayOfWeightedHost[i2].a);
      }
      return localArrayList;
    }
    finally {}
  }
  
  public void c(String paramString)
  {
    this.m = paramString;
  }
  
  /* Error */
  public String d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 271	com/xiaomi/network/Fallback:k	Ljava/lang/String;
    //   6: invokestatic 51	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifne +12 -> 21
    //   12: aload_0
    //   13: getfield 271	com/xiaomi/network/Fallback:k	Ljava/lang/String;
    //   16: astore_2
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_2
    //   20: areturn
    //   21: aload_0
    //   22: getfield 147	com/xiaomi/network/Fallback:e	Ljava/lang/String;
    //   25: invokestatic 51	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   28: ifeq +10 -> 38
    //   31: ldc_w 273
    //   34: astore_2
    //   35: goto -18 -> 17
    //   38: iconst_5
    //   39: anewarray 194	java/lang/String
    //   42: astore_3
    //   43: aload_3
    //   44: iconst_0
    //   45: aload_0
    //   46: getfield 147	com/xiaomi/network/Fallback:e	Ljava/lang/String;
    //   49: aastore
    //   50: aload_3
    //   51: iconst_1
    //   52: aload_0
    //   53: getfield 139	com/xiaomi/network/Fallback:c	Ljava/lang/String;
    //   56: aastore
    //   57: aload_3
    //   58: iconst_2
    //   59: aload_0
    //   60: getfield 135	com/xiaomi/network/Fallback:d	Ljava/lang/String;
    //   63: aastore
    //   64: aload_3
    //   65: iconst_3
    //   66: aload_0
    //   67: getfield 143	com/xiaomi/network/Fallback:g	Ljava/lang/String;
    //   70: aastore
    //   71: aload_3
    //   72: iconst_4
    //   73: aload_0
    //   74: getfield 151	com/xiaomi/network/Fallback:f	Ljava/lang/String;
    //   77: aastore
    //   78: aload_0
    //   79: aload_3
    //   80: ldc_w 275
    //   83: invokestatic 278	com/xiaomi/network/HostManager:a	([Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   86: putfield 271	com/xiaomi/network/Fallback:k	Ljava/lang/String;
    //   89: aload_0
    //   90: getfield 271	com/xiaomi/network/Fallback:k	Ljava/lang/String;
    //   93: astore_2
    //   94: goto -77 -> 17
    //   97: astore_1
    //   98: aload_0
    //   99: monitorexit
    //   100: aload_1
    //   101: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	this	Fallback
    //   97	4	1	localObject	Object
    //   16	78	2	str	String
    //   42	38	3	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   2	17	97	finally
    //   21	31	97	finally
    //   38	94	97	finally
  }
  
  public ArrayList<WeightedHost> e()
  {
    return this.j;
  }
  
  public double f()
  {
    if (this.l < 1.E-005D) {
      return 0.1D;
    }
    return this.l;
  }
  
  public JSONObject g()
  {
    JSONObject localJSONObject;
    try
    {
      localJSONObject = new JSONObject();
      localJSONObject.put("net", this.a);
      localJSONObject.put("ttl", this.n);
      localJSONObject.put("pct", this.l);
      localJSONObject.put("ts", this.i);
      localJSONObject.put("city", this.d);
      localJSONObject.put("prv", this.c);
      localJSONObject.put("cty", this.g);
      localJSONObject.put("isp", this.e);
      localJSONObject.put("ip", this.f);
      localJSONObject.put("host", this.b);
      localJSONObject.put("xf", this.h);
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = this.j.iterator();
      while (localIterator.hasNext()) {
        localJSONArray.put(((WeightedHost)localIterator.next()).b());
      }
      localJSONObject.put("fbs", localJSONArray);
    }
    finally {}
    return localJSONObject;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append("\n");
    localStringBuilder.append(d());
    Iterator localIterator = this.j.iterator();
    while (localIterator.hasNext())
    {
      WeightedHost localWeightedHost = (WeightedHost)localIterator.next();
      localStringBuilder.append("\n");
      localStringBuilder.append(localWeightedHost.toString());
    }
    localStringBuilder.append("\n");
    return localStringBuilder.toString();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.network.Fallback
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */