package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class v
{
  private static v a;
  private ConcurrentHashMap<String, HashMap<String, v.b>> b = new ConcurrentHashMap();
  private List<v.a> c = new ArrayList();
  
  public static v a()
  {
    try
    {
      if (a == null) {
        a = new v();
      }
      v localv = a;
      return localv;
    }
    finally {}
  }
  
  private String d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = null;
    }
    int i;
    do
    {
      return paramString;
      i = paramString.indexOf("@");
    } while (i <= 0);
    return paramString.substring(0, i);
  }
  
  public void a(Context paramContext)
  {
    try
    {
      Iterator localIterator1 = this.b.values().iterator();
      while (localIterator1.hasNext())
      {
        Iterator localIterator2 = ((HashMap)localIterator1.next()).values().iterator();
        while (localIterator2.hasNext()) {
          ((v.b)localIterator2.next()).a(v.c.a, 1, 3, null, null);
        }
      }
    }
    finally {}
  }
  
  public void a(Context paramContext, int paramInt)
  {
    try
    {
      Iterator localIterator1 = this.b.values().iterator();
      while (localIterator1.hasNext())
      {
        Iterator localIterator2 = ((HashMap)localIterator1.next()).values().iterator();
        while (localIterator2.hasNext()) {
          ((v.b)localIterator2.next()).a(v.c.a, 2, paramInt, null, null);
        }
      }
    }
    finally {}
  }
  
  public void a(v.a parama)
  {
    try
    {
      this.c.add(parama);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(v.b paramb)
  {
    try
    {
      HashMap localHashMap = (HashMap)this.b.get(paramb.h);
      if (localHashMap == null)
      {
        localHashMap = new HashMap();
        this.b.put(paramb.h, localHashMap);
      }
      localHashMap.put(d(paramb.b), paramb);
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext()) {
        ((v.a)localIterator.next()).a();
      }
    }
    finally {}
  }
  
  public void a(String paramString)
  {
    try
    {
      HashMap localHashMap = (HashMap)this.b.get(paramString);
      if (localHashMap != null)
      {
        localHashMap.clear();
        this.b.remove(paramString);
      }
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext()) {
        ((v.a)localIterator.next()).a();
      }
    }
    finally {}
  }
  
  public void a(String paramString1, String paramString2)
  {
    try
    {
      HashMap localHashMap = (HashMap)this.b.get(paramString1);
      if (localHashMap != null)
      {
        localHashMap.remove(d(paramString2));
        if (localHashMap.isEmpty()) {
          this.b.remove(paramString1);
        }
      }
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext()) {
        ((v.a)localIterator.next()).a();
      }
    }
    finally {}
  }
  
  /* Error */
  public v.b b(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 21	com/xiaomi/push/service/v:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   6: aload_1
    //   7: invokevirtual 101	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast 73	java/util/HashMap
    //   13: astore 4
    //   15: aload 4
    //   17: ifnonnull +11 -> 28
    //   20: aconst_null
    //   21: astore 5
    //   23: aload_0
    //   24: monitorexit
    //   25: aload 5
    //   27: areturn
    //   28: aload 4
    //   30: aload_0
    //   31: aload_2
    //   32: invokespecial 110	com/xiaomi/push/service/v:d	(Ljava/lang/String;)Ljava/lang/String;
    //   35: invokevirtual 129	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   38: checkcast 76	com/xiaomi/push/service/v$b
    //   41: astore 5
    //   43: goto -20 -> 23
    //   46: astore_3
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_3
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	v
    //   0	51	1	paramString1	String
    //   0	51	2	paramString2	String
    //   46	4	3	localObject	Object
    //   13	16	4	localHashMap	HashMap
    //   21	21	5	localb	v.b
    // Exception table:
    //   from	to	target	type
    //   2	15	46	finally
    //   28	43	46	finally
  }
  
  public ArrayList<v.b> b()
  {
    ArrayList localArrayList;
    try
    {
      localArrayList = new ArrayList();
      Iterator localIterator = this.b.values().iterator();
      while (localIterator.hasNext()) {
        localArrayList.addAll(((HashMap)localIterator.next()).values());
      }
    }
    finally {}
    return localArrayList;
  }
  
  public List<String> b(String paramString)
  {
    ArrayList localArrayList;
    try
    {
      localArrayList = new ArrayList();
      Iterator localIterator1 = this.b.values().iterator();
      while (localIterator1.hasNext())
      {
        Iterator localIterator2 = ((HashMap)localIterator1.next()).values().iterator();
        while (localIterator2.hasNext())
        {
          v.b localb = (v.b)localIterator2.next();
          if (paramString.equals(localb.a)) {
            localArrayList.add(localb.h);
          }
        }
      }
    }
    finally {}
    return localArrayList;
  }
  
  public int c()
  {
    try
    {
      int i = this.b.size();
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public Collection<v.b> c(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 21	com/xiaomi/push/service/v:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   6: aload_1
    //   7: invokevirtual 148	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   10: ifne +15 -> 25
    //   13: new 23	java/util/ArrayList
    //   16: dup
    //   17: invokespecial 24	java/util/ArrayList:<init>	()V
    //   20: astore_3
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_3
    //   24: areturn
    //   25: aload_0
    //   26: getfield 21	com/xiaomi/push/service/v:b	Ljava/util/concurrent/ConcurrentHashMap;
    //   29: aload_1
    //   30: invokevirtual 101	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   33: checkcast 73	java/util/HashMap
    //   36: invokevirtual 151	java/util/HashMap:clone	()Ljava/lang/Object;
    //   39: checkcast 73	java/util/HashMap
    //   42: invokevirtual 74	java/util/HashMap:values	()Ljava/util/Collection;
    //   45: astore 4
    //   47: aload 4
    //   49: astore_3
    //   50: goto -29 -> 21
    //   53: astore_2
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_2
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	v
    //   0	58	1	paramString	String
    //   53	4	2	localObject1	Object
    //   20	30	3	localObject2	Object
    //   45	3	4	localCollection	Collection
    // Exception table:
    //   from	to	target	type
    //   2	21	53	finally
    //   25	47	53	finally
  }
  
  public void d()
  {
    try
    {
      this.b.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void e()
  {
    try
    {
      this.c.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.service.v
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */