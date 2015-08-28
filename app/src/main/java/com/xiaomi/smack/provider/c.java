package com.xiaomi.smack.provider;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class c
{
  private static c a;
  private Map<String, Object> b = new ConcurrentHashMap();
  private Map<String, Object> c = new ConcurrentHashMap();
  
  private c()
  {
    b();
  }
  
  public static c a()
  {
    try
    {
      if (a == null) {
        a = new c();
      }
      c localc = a;
      return localc;
    }
    finally {}
  }
  
  private String b(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<").append(paramString1).append("/>");
    if (paramString1 != null) {
      localStringBuilder.append("<").append(paramString2).append("/>");
    }
    return localStringBuilder.toString();
  }
  
  private ClassLoader[] c()
  {
    int i = 0;
    ClassLoader[] arrayOfClassLoader = new ClassLoader[2];
    arrayOfClassLoader[0] = c.class.getClassLoader();
    arrayOfClassLoader[1] = Thread.currentThread().getContextClassLoader();
    ArrayList localArrayList = new ArrayList();
    int j = arrayOfClassLoader.length;
    while (i < j)
    {
      ClassLoader localClassLoader = arrayOfClassLoader[i];
      if (localClassLoader != null) {
        localArrayList.add(localClassLoader);
      }
      i++;
    }
    return (ClassLoader[])localArrayList.toArray(new ClassLoader[localArrayList.size()]);
  }
  
  public Object a(String paramString1, String paramString2)
  {
    String str = b(paramString1, paramString2);
    return this.b.get(str);
  }
  
  public void a(String paramString1, String paramString2, Object paramObject)
  {
    if ((!(paramObject instanceof b)) && (!(paramObject instanceof Class))) {
      throw new IllegalArgumentException("Provider must be a PacketExtensionProvider or a Class instance.");
    }
    String str = b(paramString1, paramString2);
    this.b.put(str, paramObject);
  }
  
  /* Error */
  protected void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 109	com/xiaomi/smack/provider/c:c	()[Ljava/lang/ClassLoader;
    //   4: astore_2
    //   5: aload_2
    //   6: arraylength
    //   7: istore_3
    //   8: iconst_0
    //   9: istore 4
    //   11: iload 4
    //   13: iload_3
    //   14: if_icmpge +326 -> 340
    //   17: aload_2
    //   18: iload 4
    //   20: aaload
    //   21: ldc 111
    //   23: invokevirtual 115	java/lang/ClassLoader:getResources	(Ljava/lang/String;)Ljava/util/Enumeration;
    //   26: astore 5
    //   28: aload 5
    //   30: invokeinterface 121 1 0
    //   35: ifeq +498 -> 533
    //   38: aload 5
    //   40: invokeinterface 125 1 0
    //   45: checkcast 127	java/net/URL
    //   48: astore 6
    //   50: aconst_null
    //   51: astore 7
    //   53: aload 6
    //   55: invokevirtual 131	java/net/URL:openStream	()Ljava/io/InputStream;
    //   58: astore 7
    //   60: invokestatic 137	org/xmlpull/v1/XmlPullParserFactory:newInstance	()Lorg/xmlpull/v1/XmlPullParserFactory;
    //   63: invokevirtual 141	org/xmlpull/v1/XmlPullParserFactory:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   66: astore 10
    //   68: aload 10
    //   70: ldc 143
    //   72: iconst_1
    //   73: invokeinterface 149 3 0
    //   78: aload 10
    //   80: aload 7
    //   82: ldc 151
    //   84: invokeinterface 155 3 0
    //   89: aload 10
    //   91: invokeinterface 158 1 0
    //   96: istore 11
    //   98: iload 11
    //   100: iconst_2
    //   101: if_icmpne +155 -> 256
    //   104: aload 10
    //   106: invokeinterface 161 1 0
    //   111: ldc 163
    //   113: invokevirtual 168	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   116: ifeq +225 -> 341
    //   119: aload 10
    //   121: invokeinterface 171 1 0
    //   126: pop
    //   127: aload 10
    //   129: invokeinterface 171 1 0
    //   134: pop
    //   135: aload 10
    //   137: invokeinterface 174 1 0
    //   142: astore 31
    //   144: aload 10
    //   146: invokeinterface 171 1 0
    //   151: pop
    //   152: aload 10
    //   154: invokeinterface 171 1 0
    //   159: pop
    //   160: aload 10
    //   162: invokeinterface 174 1 0
    //   167: astore 34
    //   169: aload 10
    //   171: invokeinterface 171 1 0
    //   176: pop
    //   177: aload 10
    //   179: invokeinterface 171 1 0
    //   184: pop
    //   185: aload 10
    //   187: invokeinterface 174 1 0
    //   192: astore 37
    //   194: aload_0
    //   195: aload 31
    //   197: aload 34
    //   199: invokespecial 83	com/xiaomi/smack/provider/c:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   202: astore 38
    //   204: aload_0
    //   205: getfield 21	com/xiaomi/smack/provider/c:c	Ljava/util/Map;
    //   208: aload 38
    //   210: invokeinterface 177 2 0
    //   215: istore 39
    //   217: iload 39
    //   219: ifne +37 -> 256
    //   222: aload 37
    //   224: invokestatic 181	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   227: astore 41
    //   229: ldc 183
    //   231: aload 41
    //   233: invokevirtual 187	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   236: ifeq +52 -> 288
    //   239: aload_0
    //   240: getfield 21	com/xiaomi/smack/provider/c:c	Ljava/util/Map;
    //   243: aload 38
    //   245: aload 41
    //   247: invokevirtual 189	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   250: invokeinterface 103 3 0
    //   255: pop
    //   256: aload 10
    //   258: invokeinterface 171 1 0
    //   263: istore 24
    //   265: iload 24
    //   267: istore 11
    //   269: iload 11
    //   271: iconst_1
    //   272: if_icmpne -174 -> 98
    //   275: aload 7
    //   277: invokevirtual 194	java/io/InputStream:close	()V
    //   280: goto -252 -> 28
    //   283: astore 25
    //   285: goto -257 -> 28
    //   288: ldc 196
    //   290: aload 41
    //   292: invokevirtual 187	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   295: ifeq -39 -> 256
    //   298: aload_0
    //   299: getfield 21	com/xiaomi/smack/provider/c:c	Ljava/util/Map;
    //   302: aload 38
    //   304: aload 41
    //   306: invokeinterface 103 3 0
    //   311: pop
    //   312: goto -56 -> 256
    //   315: astore 40
    //   317: aload 40
    //   319: invokevirtual 199	java/lang/ClassNotFoundException:printStackTrace	()V
    //   322: goto -66 -> 256
    //   325: astore 8
    //   327: aload 7
    //   329: invokevirtual 194	java/io/InputStream:close	()V
    //   332: aload 8
    //   334: athrow
    //   335: astore_1
    //   336: aload_1
    //   337: invokevirtual 200	java/lang/Exception:printStackTrace	()V
    //   340: return
    //   341: aload 10
    //   343: invokeinterface 161 1 0
    //   348: ldc 202
    //   350: invokevirtual 168	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   353: ifeq -97 -> 256
    //   356: aload 10
    //   358: invokeinterface 171 1 0
    //   363: pop
    //   364: aload 10
    //   366: invokeinterface 171 1 0
    //   371: pop
    //   372: aload 10
    //   374: invokeinterface 174 1 0
    //   379: astore 14
    //   381: aload 10
    //   383: invokeinterface 171 1 0
    //   388: pop
    //   389: aload 10
    //   391: invokeinterface 171 1 0
    //   396: pop
    //   397: aload 10
    //   399: invokeinterface 174 1 0
    //   404: astore 17
    //   406: aload 10
    //   408: invokeinterface 171 1 0
    //   413: pop
    //   414: aload 10
    //   416: invokeinterface 171 1 0
    //   421: pop
    //   422: aload 10
    //   424: invokeinterface 174 1 0
    //   429: astore 20
    //   431: aload_0
    //   432: aload 14
    //   434: aload 17
    //   436: invokespecial 83	com/xiaomi/smack/provider/c:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   439: astore 21
    //   441: aload_0
    //   442: getfield 19	com/xiaomi/smack/provider/c:b	Ljava/util/Map;
    //   445: aload 21
    //   447: invokeinterface 177 2 0
    //   452: istore 22
    //   454: iload 22
    //   456: ifne -200 -> 256
    //   459: aload 20
    //   461: invokestatic 181	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   464: astore 26
    //   466: ldc 92
    //   468: aload 26
    //   470: invokevirtual 187	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   473: ifeq +33 -> 506
    //   476: aload_0
    //   477: getfield 19	com/xiaomi/smack/provider/c:b	Ljava/util/Map;
    //   480: aload 21
    //   482: aload 26
    //   484: invokevirtual 189	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   487: invokeinterface 103 3 0
    //   492: pop
    //   493: goto -237 -> 256
    //   496: astore 23
    //   498: aload 23
    //   500: invokevirtual 199	java/lang/ClassNotFoundException:printStackTrace	()V
    //   503: goto -247 -> 256
    //   506: ldc 204
    //   508: aload 26
    //   510: invokevirtual 187	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   513: ifeq -257 -> 256
    //   516: aload_0
    //   517: getfield 19	com/xiaomi/smack/provider/c:b	Ljava/util/Map;
    //   520: aload 21
    //   522: aload 26
    //   524: invokeinterface 103 3 0
    //   529: pop
    //   530: goto -274 -> 256
    //   533: iinc 4 1
    //   536: goto -525 -> 11
    //   539: astore 9
    //   541: goto -209 -> 332
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	544	0	this	c
    //   335	2	1	localException1	java.lang.Exception
    //   4	14	2	arrayOfClassLoader	ClassLoader[]
    //   7	8	3	i	int
    //   9	525	4	j	int
    //   26	13	5	localEnumeration	java.util.Enumeration
    //   48	6	6	localURL	java.net.URL
    //   51	277	7	localInputStream	java.io.InputStream
    //   325	8	8	localObject	Object
    //   539	1	9	localException2	java.lang.Exception
    //   66	357	10	localXmlPullParser	org.xmlpull.v1.XmlPullParser
    //   96	177	11	k	int
    //   379	54	14	str1	String
    //   404	31	17	str2	String
    //   429	31	20	str3	String
    //   439	82	21	str4	String
    //   452	3	22	bool1	boolean
    //   496	3	23	localClassNotFoundException1	java.lang.ClassNotFoundException
    //   263	3	24	m	int
    //   283	1	25	localException3	java.lang.Exception
    //   464	59	26	localClass1	Class
    //   142	54	31	str5	String
    //   167	31	34	str6	String
    //   192	31	37	str7	String
    //   202	101	38	str8	String
    //   215	3	39	bool2	boolean
    //   315	3	40	localClassNotFoundException2	java.lang.ClassNotFoundException
    //   227	78	41	localClass2	Class
    // Exception table:
    //   from	to	target	type
    //   275	280	283	java/lang/Exception
    //   222	256	315	java/lang/ClassNotFoundException
    //   288	312	315	java/lang/ClassNotFoundException
    //   53	98	325	finally
    //   104	217	325	finally
    //   222	256	325	finally
    //   256	265	325	finally
    //   288	312	325	finally
    //   317	322	325	finally
    //   341	454	325	finally
    //   459	493	325	finally
    //   498	503	325	finally
    //   506	530	325	finally
    //   0	8	335	java/lang/Exception
    //   17	28	335	java/lang/Exception
    //   28	50	335	java/lang/Exception
    //   332	335	335	java/lang/Exception
    //   459	493	496	java/lang/ClassNotFoundException
    //   506	530	496	java/lang/ClassNotFoundException
    //   327	332	539	java/lang/Exception
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.smack.provider.c
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */