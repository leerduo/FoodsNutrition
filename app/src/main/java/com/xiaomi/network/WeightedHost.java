package com.xiaomi.network;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public class WeightedHost
  implements Comparable<WeightedHost>
{
  public String a;
  protected int b;
  private final LinkedList<AccessHistory> c = new LinkedList();
  private long d = 0L;
  
  public WeightedHost()
  {
    this(null, 0);
  }
  
  public WeightedHost(String paramString)
  {
    this(paramString, 0);
  }
  
  public WeightedHost(String paramString, int paramInt)
  {
    this.a = paramString;
    this.b = paramInt;
  }
  
  public int a(WeightedHost paramWeightedHost)
  {
    if (paramWeightedHost == null) {
      return 1;
    }
    return paramWeightedHost.b - this.b;
  }
  
  public WeightedHost a(JSONObject paramJSONObject)
  {
    try
    {
      this.d = paramJSONObject.getLong("tt");
      this.b = paramJSONObject.getInt("wt");
      this.a = paramJSONObject.getString("host");
      JSONArray localJSONArray = paramJSONObject.getJSONArray("ah");
      for (int i = 0; i < localJSONArray.length(); i++)
      {
        JSONObject localJSONObject = localJSONArray.getJSONObject(i);
        this.c.add(new AccessHistory().a(localJSONObject));
      }
      return this;
    }
    finally {}
  }
  
  public ArrayList<AccessHistory> a()
  {
    ArrayList localArrayList;
    try
    {
      localArrayList = new ArrayList();
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        AccessHistory localAccessHistory = (AccessHistory)localIterator.next();
        if (localAccessHistory.c() > this.d) {
          localArrayList.add(localAccessHistory);
        }
      }
      this.d = System.currentTimeMillis();
    }
    finally {}
    return localArrayList;
  }
  
  /* Error */
  protected void a(AccessHistory paramAccessHistory)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +80 -> 83
    //   6: invokestatic 116	com/xiaomi/network/UploadHostStatHelper:a	()Lcom/xiaomi/network/UploadHostStatHelper;
    //   9: invokevirtual 118	com/xiaomi/network/UploadHostStatHelper:b	()V
    //   12: aload_0
    //   13: getfield 29	com/xiaomi/network/WeightedHost:c	Ljava/util/LinkedList;
    //   16: aload_1
    //   17: invokevirtual 83	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   20: pop
    //   21: aload_1
    //   22: invokevirtual 120	com/xiaomi/network/AccessHistory:a	()I
    //   25: istore 4
    //   27: iload 4
    //   29: ifle +57 -> 86
    //   32: aload_0
    //   33: aload_0
    //   34: getfield 35	com/xiaomi/network/WeightedHost:b	I
    //   37: aload_1
    //   38: invokevirtual 120	com/xiaomi/network/AccessHistory:a	()I
    //   41: iadd
    //   42: putfield 35	com/xiaomi/network/WeightedHost:b	I
    //   45: aload_0
    //   46: getfield 29	com/xiaomi/network/WeightedHost:c	Ljava/util/LinkedList;
    //   49: invokevirtual 123	java/util/LinkedList:size	()I
    //   52: bipush 30
    //   54: if_icmple +29 -> 83
    //   57: aload_0
    //   58: getfield 29	com/xiaomi/network/WeightedHost:c	Ljava/util/LinkedList;
    //   61: invokevirtual 126	java/util/LinkedList:remove	()Ljava/lang/Object;
    //   64: checkcast 75	com/xiaomi/network/AccessHistory
    //   67: astore 5
    //   69: aload_0
    //   70: aload_0
    //   71: getfield 35	com/xiaomi/network/WeightedHost:b	I
    //   74: aload 5
    //   76: invokevirtual 120	com/xiaomi/network/AccessHistory:a	()I
    //   79: isub
    //   80: putfield 35	com/xiaomi/network/WeightedHost:b	I
    //   83: aload_0
    //   84: monitorexit
    //   85: return
    //   86: iconst_m1
    //   87: aload_0
    //   88: getfield 29	com/xiaomi/network/WeightedHost:c	Ljava/util/LinkedList;
    //   91: invokevirtual 123	java/util/LinkedList:size	()I
    //   94: iadd
    //   95: istore 6
    //   97: iconst_0
    //   98: istore 7
    //   100: iload 6
    //   102: istore 8
    //   104: iload 8
    //   106: iflt +30 -> 136
    //   109: aload_0
    //   110: getfield 29	com/xiaomi/network/WeightedHost:c	Ljava/util/LinkedList;
    //   113: iload 8
    //   115: invokevirtual 130	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   118: checkcast 75	com/xiaomi/network/AccessHistory
    //   121: invokevirtual 120	com/xiaomi/network/AccessHistory:a	()I
    //   124: ifge +12 -> 136
    //   127: iinc 7 1
    //   130: iinc 8 255
    //   133: goto -29 -> 104
    //   136: aload_0
    //   137: aload_0
    //   138: getfield 35	com/xiaomi/network/WeightedHost:b	I
    //   141: iload 4
    //   143: iload 7
    //   145: imul
    //   146: iadd
    //   147: putfield 35	com/xiaomi/network/WeightedHost:b	I
    //   150: goto -105 -> 45
    //   153: astore_2
    //   154: aload_0
    //   155: monitorexit
    //   156: aload_2
    //   157: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	this	WeightedHost
    //   0	158	1	paramAccessHistory	AccessHistory
    //   153	4	2	localObject	Object
    //   25	121	4	i	int
    //   67	8	5	localAccessHistory	AccessHistory
    //   95	6	6	j	int
    //   98	48	7	k	int
    //   102	29	8	m	int
    // Exception table:
    //   from	to	target	type
    //   6	27	153	finally
    //   32	45	153	finally
    //   45	83	153	finally
    //   86	97	153	finally
    //   109	127	153	finally
    //   136	150	153	finally
  }
  
  public JSONObject b()
  {
    JSONObject localJSONObject;
    try
    {
      localJSONObject = new JSONObject();
      localJSONObject.put("tt", this.d);
      localJSONObject.put("wt", this.b);
      localJSONObject.put("host", this.a);
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext()) {
        localJSONArray.put(((AccessHistory)localIterator.next()).f());
      }
      localJSONObject.put("ah", localJSONArray);
    }
    finally {}
    return localJSONObject;
  }
  
  public String toString()
  {
    return this.a + ":" + this.b;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.network.WeightedHost
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */