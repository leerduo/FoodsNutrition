package com.xiaomi.stats;

import android.util.Base64;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.g;
import com.xiaomi.smack.r;
import com.xiaomi.xmpush.thrift.f;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class a
{
  private static final int a = ;
  private int b = a;
  private boolean c = true;
  private XMPushService d;
  private String e;
  private long f = System.currentTimeMillis();
  private LinkedList<a.b> g = new LinkedList();
  
  private a.b a(long paramLong)
  {
    a.b localb;
    for (Object localObject = null; !this.g.isEmpty(); localObject = localb)
    {
      localb = (a.b)this.g.getFirst();
      if (this.g.size() <= 100) {
        break;
      }
      this.g.removeFirst();
    }
    return localObject;
  }
  
  public static a a()
  {
    return a.a.a;
  }
  
  private String a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      String str = Base64.encodeToString(MessageDigest.getInstance("SHA1").digest(paramString.getBytes()), 8).substring(0, 16);
      return str;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      b.a(localNoSuchAlgorithmException);
    }
    return null;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, long paramLong)
  {
    a.b localb = a(paramLong);
    if (localb == null) {
      localb = new a.b();
    }
    localb.b.a = ((byte)paramInt1);
    localb.b.b = paramInt2;
    localb.b.c = paramInt3;
    localb.b.d = paramString2;
    localb.b.e = paramString1;
    localb.a = System.currentTimeMillis();
    this.g.addLast(localb);
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = Integer.valueOf(paramInt1);
    arrayOfObject[1] = Integer.valueOf(paramInt2);
    arrayOfObject[2] = Integer.valueOf(paramInt3);
    arrayOfObject[3] = paramString2;
    b.b(String.format(localLocale, "add stats: chid = %s, type =%d, value = %d, connpt = %s", arrayOfObject));
  }
  
  /* Error */
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 154	com/xiaomi/stats/a:e	Ljava/lang/String;
    //   6: ifnonnull +21 -> 27
    //   9: getstatic 137	java/util/Locale:US	Ljava/util/Locale;
    //   12: ldc 156
    //   14: iconst_0
    //   15: anewarray 4	java/lang/Object
    //   18: invokestatic 149	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   21: invokestatic 152	com/xiaomi/channel/commonutils/logger/b:b	(Ljava/lang/String;)V
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: aload_0
    //   28: getfield 158	com/xiaomi/stats/a:d	Lcom/xiaomi/push/service/XMPushService;
    //   31: invokestatic 163	com/xiaomi/channel/commonutils/network/a:f	(Landroid/content/Context;)Ljava/lang/String;
    //   34: astore 6
    //   36: aload 6
    //   38: invokestatic 168	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   41: ifne -17 -> 24
    //   44: aload_0
    //   45: iload_1
    //   46: iload_2
    //   47: iload_3
    //   48: aload 4
    //   50: aload 6
    //   52: invokestatic 40	java/lang/System:currentTimeMillis	()J
    //   55: invokespecial 170	com/xiaomi/stats/a:a	(IIILjava/lang/String;Ljava/lang/String;J)V
    //   58: goto -34 -> 24
    //   61: astore 5
    //   63: aload_0
    //   64: monitorexit
    //   65: aload 5
    //   67: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	a
    //   0	68	1	paramInt1	int
    //   0	68	2	paramInt2	int
    //   0	68	3	paramInt3	int
    //   0	68	4	paramString	String
    //   61	5	5	localObject	Object
    //   34	17	6	str	String
    // Exception table:
    //   from	to	target	type
    //   2	24	61	finally
    //   27	58	61	finally
  }
  
  public void a(XMPushService paramXMPushService)
  {
    try
    {
      this.d = paramXMPushService;
      this.e = a(g.c(paramXMPushService));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  boolean a(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("chid = ").append(paramInt1);
    localStringBuilder.append("key = ").append(paramInt2);
    localStringBuilder.append("host = ").append(paramString1);
    localStringBuilder.append("val = ").append(paramInt3);
    localStringBuilder.append("salt = ").append("XIAOMI_STATS");
    String str1 = paramString2.substring(-4 + paramString2.length());
    localStringBuilder.append(str1);
    try
    {
      String str2 = Base64.encodeToString(MessageDigest.getInstance("MD5").digest(localStringBuilder.toString().getBytes()), 8).substring(0, 12);
      String str3 = str2 + str1;
      return str3.equals(paramString2);
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {}
    return false;
  }
  
  boolean b()
  {
    return (this.c) && (!this.g.isEmpty()) && (System.currentTimeMillis() - this.f > this.b);
  }
  
  f c()
  {
    ArrayList localArrayList;
    try
    {
      boolean bool = b();
      localf = null;
      if (!bool) {
        break label120;
      }
      localArrayList = new ArrayList();
      Iterator localIterator = this.g.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((a.b)localIterator.next()).b);
      }
      this.g.clear();
    }
    finally {}
    this.f = System.currentTimeMillis();
    f localf = new f(this.e, localArrayList);
    if (!com.xiaomi.channel.commonutils.network.a.e(this.d)) {
      localf.a(g.d(this.d));
    }
    label120:
    return localf;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.stats.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */