package com.xiaomi.network;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class Fallbacks
{
  private String a;
  private final ArrayList<Fallback> b = new ArrayList();
  
  public Fallbacks() {}
  
  public Fallbacks(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("the host is empty");
    }
    this.a = paramString;
  }
  
  public Fallback a()
  {
    for (;;)
    {
      try
      {
        int i = -1 + this.b.size();
        Fallback localFallback;
        if (i >= 0)
        {
          localFallback = (Fallback)this.b.get(i);
          if (!localFallback.b())
          {
            this.b.remove(i);
          }
          else if (localFallback.a())
          {
            HostManager.a().b(localFallback.d());
            return localFallback;
          }
        }
        else
        {
          localFallback = null;
          continue;
        }
        i--;
      }
      finally {}
    }
  }
  
  public Fallbacks a(JSONObject paramJSONObject)
  {
    try
    {
      this.a = paramJSONObject.getString("host");
      JSONArray localJSONArray = paramJSONObject.getJSONArray("fbs");
      for (int i = 0; i < localJSONArray.length(); i++) {
        this.b.add(new Fallback(this.a).a(localJSONArray.getJSONObject(i)));
      }
      return this;
    }
    finally {}
  }
  
  /* Error */
  public void a(Fallback paramFallback)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: istore_2
    //   4: iload_2
    //   5: aload_0
    //   6: getfield 18	com/xiaomi/network/Fallbacks:b	Ljava/util/ArrayList;
    //   9: invokevirtual 38	java/util/ArrayList:size	()I
    //   12: if_icmpge +31 -> 43
    //   15: aload_0
    //   16: getfield 18	com/xiaomi/network/Fallbacks:b	Ljava/util/ArrayList;
    //   19: iload_2
    //   20: invokevirtual 42	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   23: checkcast 44	com/xiaomi/network/Fallback
    //   26: aload_1
    //   27: invokevirtual 99	com/xiaomi/network/Fallback:a	(Lcom/xiaomi/network/Fallback;)Z
    //   30: ifeq +36 -> 66
    //   33: aload_0
    //   34: getfield 18	com/xiaomi/network/Fallbacks:b	Ljava/util/ArrayList;
    //   37: iload_2
    //   38: aload_1
    //   39: invokevirtual 103	java/util/ArrayList:set	(ILjava/lang/Object;)Ljava/lang/Object;
    //   42: pop
    //   43: iload_2
    //   44: aload_0
    //   45: getfield 18	com/xiaomi/network/Fallbacks:b	Ljava/util/ArrayList;
    //   48: invokevirtual 38	java/util/ArrayList:size	()I
    //   51: if_icmplt +12 -> 63
    //   54: aload_0
    //   55: getfield 18	com/xiaomi/network/Fallbacks:b	Ljava/util/ArrayList;
    //   58: aload_1
    //   59: invokevirtual 95	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   62: pop
    //   63: aload_0
    //   64: monitorexit
    //   65: return
    //   66: iinc 2 1
    //   69: goto -65 -> 4
    //   72: astore_3
    //   73: aload_0
    //   74: monitorexit
    //   75: aload_3
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	this	Fallbacks
    //   0	77	1	paramFallback	Fallback
    //   3	64	2	i	int
    //   72	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	43	72	finally
    //   43	63	72	finally
  }
  
  public ArrayList<Fallback> b()
  {
    return this.b;
  }
  
  public void c()
  {
    try
    {
      for (int i = -1 + this.b.size(); i >= 0; i--) {
        if (!((Fallback)this.b.get(i)).b()) {
          this.b.remove(i);
        }
      }
      return;
    }
    finally {}
  }
  
  public String d()
  {
    return this.a;
  }
  
  public JSONObject e()
  {
    JSONObject localJSONObject;
    try
    {
      localJSONObject = new JSONObject();
      localJSONObject.put("host", this.a);
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext()) {
        localJSONArray.put(((Fallback)localIterator.next()).g());
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
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append((Fallback)localIterator.next());
    }
    return localStringBuilder.toString();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.network.Fallbacks
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */