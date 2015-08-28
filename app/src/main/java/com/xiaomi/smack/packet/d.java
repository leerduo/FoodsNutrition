package com.xiaomi.smack.packet;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.xiaomi.smack.util.g;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class d
{
  protected static final String a = Locale.getDefault().getLanguage().toLowerCase();
  public static final DateFormat b;
  private static String c = null;
  private static String d = g.a(5) + "-";
  private static long e = 0L;
  private String f = c;
  private String g = null;
  private String h = null;
  private String i = null;
  private String j = null;
  private String k = null;
  private List<a> l = new CopyOnWriteArrayList();
  private final Map<String, Object> m = new HashMap();
  private h n = null;
  
  static
  {
    b = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    b.setTimeZone(TimeZone.getTimeZone("UTC"));
  }
  
  public d() {}
  
  public d(Bundle paramBundle)
  {
    this.h = paramBundle.getString("ext_to");
    this.i = paramBundle.getString("ext_from");
    this.j = paramBundle.getString("ext_chid");
    this.g = paramBundle.getString("ext_pkt_id");
    Parcelable[] arrayOfParcelable = paramBundle.getParcelableArray("ext_exts");
    if (arrayOfParcelable != null)
    {
      this.l = new ArrayList(arrayOfParcelable.length);
      int i1 = arrayOfParcelable.length;
      for (int i2 = 0; i2 < i1; i2++)
      {
        a locala = a.a((Bundle)arrayOfParcelable[i2]);
        if (locala != null) {
          this.l.add(locala);
        }
      }
    }
    Bundle localBundle = paramBundle.getBundle("ext_ERROR");
    if (localBundle != null) {
      this.n = new h(localBundle);
    }
  }
  
  public static String j()
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder().append(d);
      long l1 = e;
      e = 1L + l1;
      String str = Long.toString(l1);
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String u()
  {
    return a;
  }
  
  public void a(a parama)
  {
    this.l.add(parama);
  }
  
  public void a(h paramh)
  {
    this.n = paramh;
  }
  
  public Bundle b()
  {
    Bundle localBundle1 = new Bundle();
    if (!TextUtils.isEmpty(this.f)) {
      localBundle1.putString("ext_ns", this.f);
    }
    if (!TextUtils.isEmpty(this.i)) {
      localBundle1.putString("ext_from", this.i);
    }
    if (!TextUtils.isEmpty(this.h)) {
      localBundle1.putString("ext_to", this.h);
    }
    if (!TextUtils.isEmpty(this.g)) {
      localBundle1.putString("ext_pkt_id", this.g);
    }
    if (!TextUtils.isEmpty(this.j)) {
      localBundle1.putString("ext_chid", this.j);
    }
    if (this.n != null) {
      localBundle1.putBundle("ext_ERROR", this.n.c());
    }
    Bundle[] arrayOfBundle;
    int i1;
    int i2;
    if (this.l != null)
    {
      arrayOfBundle = new Bundle[this.l.size()];
      Iterator localIterator = this.l.iterator();
      i1 = 0;
      if (localIterator.hasNext())
      {
        Bundle localBundle2 = ((a)localIterator.next()).e();
        if (localBundle2 == null) {
          break label217;
        }
        i2 = i1 + 1;
        arrayOfBundle[i1] = localBundle2;
      }
    }
    for (;;)
    {
      i1 = i2;
      break;
      localBundle1.putParcelableArray("ext_exts", arrayOfBundle);
      return localBundle1;
      label217:
      i2 = i1;
    }
  }
  
  public a b(String paramString1, String paramString2)
  {
    Iterator localIterator = this.l.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (((paramString2 == null) || (paramString2.equals(locala.b()))) && (paramString1.equals(locala.a()))) {
        return locala;
      }
    }
    return null;
  }
  
  public abstract String c();
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = true;
    boolean bool2;
    if (this == paramObject) {
      bool2 = bool1;
    }
    d locald;
    label100:
    boolean bool4;
    label149:
    label177:
    label205:
    do
    {
      boolean bool5;
      do
      {
        boolean bool6;
        do
        {
          boolean bool7;
          do
          {
            boolean bool3;
            do
            {
              boolean bool8;
              do
              {
                boolean bool9;
                do
                {
                  Class localClass1;
                  Class localClass2;
                  do
                  {
                    do
                    {
                      return bool2;
                      bool2 = false;
                    } while (paramObject == null);
                    localClass1 = getClass();
                    localClass2 = paramObject.getClass();
                    bool2 = false;
                  } while (localClass1 != localClass2);
                  locald = (d)paramObject;
                  if (this.n == null) {
                    break;
                  }
                  bool9 = this.n.equals(locald.n);
                  bool2 = false;
                } while (!bool9);
                if (this.i == null) {
                  break label269;
                }
                bool8 = this.i.equals(locald.i);
                bool2 = false;
              } while (!bool8);
              bool3 = this.l.equals(locald.l);
              bool2 = false;
            } while (!bool3);
            if (this.g == null) {
              break label279;
            }
            bool7 = this.g.equals(locald.g);
            bool2 = false;
          } while (!bool7);
          if (this.j == null) {
            break label289;
          }
          bool6 = this.j.equals(locald.j);
          bool2 = false;
        } while (!bool6);
        if (this.m == null) {
          break label299;
        }
        bool5 = this.m.equals(locald.m);
        bool2 = false;
      } while (!bool5);
      if (this.h == null) {
        break label309;
      }
      bool4 = this.h.equals(locald.h);
      bool2 = false;
    } while (!bool4);
    label233:
    if (this.f != null) {
      if (!this.f.equals(locald.f)) {
        label255:
        bool1 = false;
      }
    }
    for (;;)
    {
      return bool1;
      if (locald.n == null) {
        break;
      }
      return false;
      label269:
      if (locald.i == null) {
        break label100;
      }
      return false;
      label279:
      if (locald.g == null) {
        break label149;
      }
      return false;
      label289:
      if (locald.j == null) {
        break label177;
      }
      return false;
      label299:
      if (locald.m == null) {
        break label205;
      }
      return false;
      label309:
      if (locald.h == null) {
        break label233;
      }
      return false;
      if (locald.f != null) {
        break label255;
      }
    }
  }
  
  public int hashCode()
  {
    int i1;
    int i3;
    label35:
    int i5;
    label59:
    int i7;
    label85:
    int i8;
    if (this.f != null)
    {
      i1 = this.f.hashCode();
      int i2 = i1 * 31;
      if (this.g == null) {
        break label177;
      }
      i3 = this.g.hashCode();
      int i4 = 31 * (i3 + i2);
      if (this.h == null) {
        break label182;
      }
      i5 = this.h.hashCode();
      int i6 = 31 * (i5 + i4);
      if (this.i == null) {
        break label188;
      }
      i7 = this.i.hashCode();
      i8 = 31 * (i7 + i6);
      if (this.j == null) {
        break label194;
      }
    }
    label177:
    label182:
    label188:
    label194:
    for (int i9 = this.j.hashCode();; i9 = 0)
    {
      int i10 = 31 * (31 * (31 * (i9 + i8) + this.l.hashCode()) + this.m.hashCode());
      h localh = this.n;
      int i11 = 0;
      if (localh != null) {
        i11 = this.n.hashCode();
      }
      return i10 + i11;
      i1 = 0;
      break;
      i3 = 0;
      break label35;
      i5 = 0;
      break label59;
      i7 = 0;
      break label85;
    }
  }
  
  public String k()
  {
    if ("ID_NOT_AVAILABLE".equals(this.g)) {
      return null;
    }
    if (this.g == null) {
      this.g = j();
    }
    return this.g;
  }
  
  public void k(String paramString)
  {
    this.g = paramString;
  }
  
  public String l()
  {
    return this.j;
  }
  
  public void l(String paramString)
  {
    this.j = paramString;
  }
  
  public String m()
  {
    return this.h;
  }
  
  public void m(String paramString)
  {
    this.h = paramString;
  }
  
  public String n()
  {
    return this.i;
  }
  
  public void n(String paramString)
  {
    this.i = paramString;
  }
  
  public String o()
  {
    return this.k;
  }
  
  public void o(String paramString)
  {
    this.k = paramString;
  }
  
  public a p(String paramString)
  {
    return b(paramString, null);
  }
  
  public h p()
  {
    return this.n;
  }
  
  /* Error */
  public Object q(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 116	com/xiaomi/smack/packet/d:m	Ljava/util/Map;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnonnull +11 -> 19
    //   11: aconst_null
    //   12: astore 5
    //   14: aload_0
    //   15: monitorexit
    //   16: aload 5
    //   18: areturn
    //   19: aload_0
    //   20: getfield 116	com/xiaomi/smack/packet/d:m	Ljava/util/Map;
    //   23: aload_1
    //   24: invokeinterface 252 2 0
    //   29: astore 4
    //   31: aload 4
    //   33: astore 5
    //   35: goto -21 -> 14
    //   38: astore_2
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_2
    //   42: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	this	d
    //   0	43	1	paramString	String
    //   38	4	2	localObject1	Object
    //   6	2	3	localMap	Map
    //   29	3	4	localObject2	Object
    //   12	22	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	38	finally
    //   19	31	38	finally
  }
  
  /* Error */
  public java.util.Collection<a> q()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 111	com/xiaomi/smack/packet/d:l	Ljava/util/List;
    //   6: ifnonnull +15 -> 21
    //   9: invokestatic 259	java/util/Collections:emptyList	()Ljava/util/List;
    //   12: astore 4
    //   14: aload 4
    //   16: astore_3
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_3
    //   20: areturn
    //   21: new 141	java/util/ArrayList
    //   24: dup
    //   25: aload_0
    //   26: getfield 111	com/xiaomi/smack/packet/d:l	Ljava/util/List;
    //   29: invokespecial 262	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   32: invokestatic 266	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   35: astore_2
    //   36: aload_2
    //   37: astore_3
    //   38: goto -21 -> 17
    //   41: astore_1
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	this	d
    //   41	4	1	localObject1	Object
    //   35	2	2	localList1	List
    //   16	22	3	localObject2	Object
    //   12	3	4	localList2	List
    // Exception table:
    //   from	to	target	type
    //   2	14	41	finally
    //   21	36	41	finally
  }
  
  /* Error */
  public java.util.Collection<String> r()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 116	com/xiaomi/smack/packet/d:m	Ljava/util/Map;
    //   6: ifnonnull +15 -> 21
    //   9: invokestatic 271	java/util/Collections:emptySet	()Ljava/util/Set;
    //   12: astore 4
    //   14: aload 4
    //   16: astore_3
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_3
    //   20: areturn
    //   21: new 273	java/util/HashSet
    //   24: dup
    //   25: aload_0
    //   26: getfield 116	com/xiaomi/smack/packet/d:m	Ljava/util/Map;
    //   29: invokeinterface 276 1 0
    //   34: invokespecial 277	java/util/HashSet:<init>	(Ljava/util/Collection;)V
    //   37: invokestatic 281	java/util/Collections:unmodifiableSet	(Ljava/util/Set;)Ljava/util/Set;
    //   40: astore_2
    //   41: aload_2
    //   42: astore_3
    //   43: goto -26 -> 17
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	d
    //   46	4	1	localObject1	Object
    //   40	2	2	localSet1	java.util.Set
    //   16	27	3	localObject2	Object
    //   12	3	4	localSet2	java.util.Set
    // Exception table:
    //   from	to	target	type
    //   2	14	46	finally
    //   21	41	46	finally
  }
  
  /* Error */
  protected String s()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 73	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   9: astore_1
    //   10: aload_0
    //   11: invokevirtual 286	com/xiaomi/smack/packet/d:q	()Ljava/util/Collection;
    //   14: invokeinterface 289 1 0
    //   19: astore_3
    //   20: aload_3
    //   21: invokeinterface 207 1 0
    //   26: ifeq +30 -> 56
    //   29: aload_1
    //   30: aload_3
    //   31: invokeinterface 211 1 0
    //   36: checkcast 146	com/xiaomi/smack/packet/a
    //   39: invokeinterface 293 1 0
    //   44: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: goto -28 -> 20
    //   51: astore_2
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_2
    //   55: athrow
    //   56: aload_0
    //   57: getfield 116	com/xiaomi/smack/packet/d:m	Ljava/util/Map;
    //   60: ifnull +462 -> 522
    //   63: aload_0
    //   64: getfield 116	com/xiaomi/smack/packet/d:m	Ljava/util/Map;
    //   67: invokeinterface 295 1 0
    //   72: ifne +450 -> 522
    //   75: aload_1
    //   76: ldc_w 297
    //   79: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: aload_0
    //   84: invokevirtual 299	com/xiaomi/smack/packet/d:r	()Ljava/util/Collection;
    //   87: invokeinterface 289 1 0
    //   92: astore 6
    //   94: aload 6
    //   96: invokeinterface 207 1 0
    //   101: ifeq +413 -> 514
    //   104: aload 6
    //   106: invokeinterface 211 1 0
    //   111: checkcast 40	java/lang/String
    //   114: astore 8
    //   116: aload_0
    //   117: aload 8
    //   119: invokevirtual 301	com/xiaomi/smack/packet/d:q	(Ljava/lang/String;)Ljava/lang/Object;
    //   122: astore 9
    //   124: aload_1
    //   125: ldc_w 303
    //   128: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: pop
    //   132: aload_1
    //   133: ldc_w 305
    //   136: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: aload 8
    //   141: invokestatic 307	com/xiaomi/smack/util/g:a	(Ljava/lang/String;)Ljava/lang/String;
    //   144: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: ldc_w 309
    //   150: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: pop
    //   154: aload_1
    //   155: ldc_w 311
    //   158: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: aload 9
    //   164: instanceof 313
    //   167: ifeq +33 -> 200
    //   170: aload_1
    //   171: ldc_w 315
    //   174: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: aload 9
    //   179: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   182: ldc_w 320
    //   185: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: aload_1
    //   190: ldc_w 322
    //   193: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: goto -103 -> 94
    //   200: aload 9
    //   202: instanceof 167
    //   205: ifeq +25 -> 230
    //   208: aload_1
    //   209: ldc_w 324
    //   212: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: aload 9
    //   217: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   220: ldc_w 320
    //   223: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: pop
    //   227: goto -38 -> 189
    //   230: aload 9
    //   232: instanceof 326
    //   235: ifeq +25 -> 260
    //   238: aload_1
    //   239: ldc_w 328
    //   242: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: aload 9
    //   247: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   250: ldc_w 320
    //   253: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: pop
    //   257: goto -68 -> 189
    //   260: aload 9
    //   262: instanceof 330
    //   265: ifeq +25 -> 290
    //   268: aload_1
    //   269: ldc_w 332
    //   272: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: aload 9
    //   277: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   280: ldc_w 320
    //   283: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: pop
    //   287: goto -98 -> 189
    //   290: aload 9
    //   292: instanceof 334
    //   295: ifeq +25 -> 320
    //   298: aload_1
    //   299: ldc_w 336
    //   302: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: aload 9
    //   307: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   310: ldc_w 320
    //   313: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: pop
    //   317: goto -128 -> 189
    //   320: aload 9
    //   322: instanceof 40
    //   325: ifeq +35 -> 360
    //   328: aload_1
    //   329: ldc_w 338
    //   332: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: pop
    //   336: aload_1
    //   337: aload 9
    //   339: checkcast 40	java/lang/String
    //   342: invokestatic 307	com/xiaomi/smack/util/g:a	(Ljava/lang/String;)Ljava/lang/String;
    //   345: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: pop
    //   349: aload_1
    //   350: ldc_w 320
    //   353: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: pop
    //   357: goto -168 -> 189
    //   360: new 340	java/io/ByteArrayOutputStream
    //   363: dup
    //   364: invokespecial 341	java/io/ByteArrayOutputStream:<init>	()V
    //   367: astore 13
    //   369: new 343	java/io/ObjectOutputStream
    //   372: dup
    //   373: aload 13
    //   375: invokespecial 346	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   378: astore 14
    //   380: aload 14
    //   382: aload 9
    //   384: invokevirtual 350	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   387: aload_1
    //   388: ldc_w 352
    //   391: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: pop
    //   395: aload_1
    //   396: aload 13
    //   398: invokevirtual 356	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   401: invokestatic 359	com/xiaomi/smack/util/g:a	([B)Ljava/lang/String;
    //   404: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: ldc_w 320
    //   410: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: pop
    //   414: aload 14
    //   416: ifnull +8 -> 424
    //   419: aload 14
    //   421: invokevirtual 362	java/io/ObjectOutputStream:close	()V
    //   424: aload 13
    //   426: ifnull -237 -> 189
    //   429: aload 13
    //   431: invokevirtual 363	java/io/ByteArrayOutputStream:close	()V
    //   434: goto -245 -> 189
    //   437: astore 26
    //   439: goto -250 -> 189
    //   442: astore 15
    //   444: aconst_null
    //   445: astore 16
    //   447: aconst_null
    //   448: astore 17
    //   450: aload 15
    //   452: invokevirtual 366	java/lang/Exception:printStackTrace	()V
    //   455: aload 16
    //   457: ifnull +8 -> 465
    //   460: aload 16
    //   462: invokevirtual 362	java/io/ObjectOutputStream:close	()V
    //   465: aload 17
    //   467: ifnull -278 -> 189
    //   470: aload 17
    //   472: invokevirtual 363	java/io/ByteArrayOutputStream:close	()V
    //   475: goto -286 -> 189
    //   478: astore 21
    //   480: goto -291 -> 189
    //   483: astore 18
    //   485: aconst_null
    //   486: astore 14
    //   488: aconst_null
    //   489: astore 13
    //   491: aload 14
    //   493: ifnull +8 -> 501
    //   496: aload 14
    //   498: invokevirtual 362	java/io/ObjectOutputStream:close	()V
    //   501: aload 13
    //   503: ifnull +8 -> 511
    //   506: aload 13
    //   508: invokevirtual 363	java/io/ByteArrayOutputStream:close	()V
    //   511: aload 18
    //   513: athrow
    //   514: aload_1
    //   515: ldc_w 368
    //   518: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   521: pop
    //   522: aload_1
    //   523: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   526: astore 4
    //   528: aload_0
    //   529: monitorexit
    //   530: aload 4
    //   532: areturn
    //   533: astore 27
    //   535: goto -111 -> 424
    //   538: astore 23
    //   540: goto -75 -> 465
    //   543: astore 20
    //   545: goto -44 -> 501
    //   548: astore 19
    //   550: goto -39 -> 511
    //   553: astore 18
    //   555: aconst_null
    //   556: astore 14
    //   558: goto -67 -> 491
    //   561: astore 18
    //   563: goto -72 -> 491
    //   566: astore 18
    //   568: aload 17
    //   570: astore 13
    //   572: aload 16
    //   574: astore 14
    //   576: goto -85 -> 491
    //   579: astore 15
    //   581: aload 13
    //   583: astore 17
    //   585: aconst_null
    //   586: astore 16
    //   588: goto -138 -> 450
    //   591: astore 15
    //   593: aload 14
    //   595: astore 16
    //   597: aload 13
    //   599: astore 17
    //   601: goto -151 -> 450
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	604	0	this	d
    //   9	514	1	localStringBuilder	StringBuilder
    //   51	4	2	localObject1	Object
    //   19	12	3	localIterator1	Iterator
    //   526	5	4	str1	String
    //   92	13	6	localIterator2	Iterator
    //   114	26	8	str2	String
    //   122	261	9	localObject2	Object
    //   367	231	13	localObject3	Object
    //   378	216	14	localObject4	Object
    //   442	9	15	localException1	java.lang.Exception
    //   579	1	15	localException2	java.lang.Exception
    //   591	1	15	localException3	java.lang.Exception
    //   445	151	16	localObject5	Object
    //   448	152	17	localObject6	Object
    //   483	29	18	localObject7	Object
    //   553	1	18	localObject8	Object
    //   561	1	18	localObject9	Object
    //   566	1	18	localObject10	Object
    //   548	1	19	localException4	java.lang.Exception
    //   543	1	20	localException5	java.lang.Exception
    //   478	1	21	localException6	java.lang.Exception
    //   538	1	23	localException7	java.lang.Exception
    //   437	1	26	localException8	java.lang.Exception
    //   533	1	27	localException9	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   2	20	51	finally
    //   20	48	51	finally
    //   56	94	51	finally
    //   94	189	51	finally
    //   189	197	51	finally
    //   200	227	51	finally
    //   230	257	51	finally
    //   260	287	51	finally
    //   290	317	51	finally
    //   320	357	51	finally
    //   419	424	51	finally
    //   429	434	51	finally
    //   460	465	51	finally
    //   470	475	51	finally
    //   496	501	51	finally
    //   506	511	51	finally
    //   511	514	51	finally
    //   514	522	51	finally
    //   522	528	51	finally
    //   429	434	437	java/lang/Exception
    //   360	369	442	java/lang/Exception
    //   470	475	478	java/lang/Exception
    //   360	369	483	finally
    //   419	424	533	java/lang/Exception
    //   460	465	538	java/lang/Exception
    //   496	501	543	java/lang/Exception
    //   506	511	548	java/lang/Exception
    //   369	380	553	finally
    //   380	414	561	finally
    //   450	455	566	finally
    //   369	380	579	java/lang/Exception
    //   380	414	591	java/lang/Exception
  }
  
  public String t()
  {
    return this.f;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.smack.packet.d
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */