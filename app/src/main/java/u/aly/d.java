package u.aly;

import android.content.Context;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class d
{
  private final String a = "umeng_it.cache";
  private File b;
  private as c = null;
  private long d;
  private long e;
  private Set<a> f = new HashSet();
  
  public d(Context paramContext)
  {
    this.b = new File(paramContext.getFilesDir(), "umeng_it.cache");
    this.e = 86400000L;
  }
  
  private void a(as paramas)
  {
    if (paramas != null) {}
    try
    {
      try
      {
        byte[] arrayOfByte = new ci().a(paramas);
        if (arrayOfByte != null) {
          bv.a(this.b, arrayOfByte);
        }
        return;
      }
      finally {}
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void f()
  {
    as localas = new as();
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.c())
      {
        if (locala.d() != null) {
          localHashMap.put(locala.b(), locala.d());
        }
        if ((locala.e() != null) && (!locala.e().isEmpty())) {
          localArrayList.addAll(locala.e());
        }
      }
    }
    localas.a(localArrayList);
    localas.a(localHashMap);
    try
    {
      this.c = localas;
      return;
    }
    finally {}
  }
  
  /* Error */
  private as g()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 45	u/aly/d:b	Ljava/io/File;
    //   4: invokevirtual 130	java/io/File:exists	()Z
    //   7: ifne +5 -> 12
    //   10: aconst_null
    //   11: areturn
    //   12: new 132	java/io/FileInputStream
    //   15: dup
    //   16: aload_0
    //   17: getfield 45	u/aly/d:b	Ljava/io/File;
    //   20: invokespecial 135	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   23: astore_1
    //   24: aload_1
    //   25: invokestatic 138	u/aly/bv:b	(Ljava/io/InputStream;)[B
    //   28: astore 4
    //   30: new 68	u/aly/as
    //   33: dup
    //   34: invokespecial 69	u/aly/as:<init>	()V
    //   37: astore 5
    //   39: new 140	u/aly/cc
    //   42: dup
    //   43: invokespecial 141	u/aly/cc:<init>	()V
    //   46: aload 5
    //   48: aload 4
    //   50: invokevirtual 144	u/aly/cc:a	(Lu/aly/bz;[B)V
    //   53: aload_1
    //   54: invokestatic 147	u/aly/bv:c	(Ljava/io/InputStream;)V
    //   57: aload 5
    //   59: areturn
    //   60: astore_2
    //   61: aconst_null
    //   62: astore_1
    //   63: aload_2
    //   64: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   67: aload_1
    //   68: invokestatic 147	u/aly/bv:c	(Ljava/io/InputStream;)V
    //   71: aconst_null
    //   72: areturn
    //   73: astore 6
    //   75: aconst_null
    //   76: astore_1
    //   77: aload 6
    //   79: astore_3
    //   80: aload_1
    //   81: invokestatic 147	u/aly/bv:c	(Ljava/io/InputStream;)V
    //   84: aload_3
    //   85: athrow
    //   86: astore_3
    //   87: goto -7 -> 80
    //   90: astore_2
    //   91: goto -28 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	d
    //   23	58	1	localFileInputStream	java.io.FileInputStream
    //   60	4	2	localException1	Exception
    //   90	1	2	localException2	Exception
    //   79	6	3	localObject1	Object
    //   86	1	3	localObject2	Object
    //   28	21	4	arrayOfByte	byte[]
    //   37	21	5	localas	as
    //   73	5	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   12	24	60	java/lang/Exception
    //   12	24	73	finally
    //   24	53	86	finally
    //   63	67	86	finally
    //   24	53	90	java/lang/Exception
  }
  
  public void a()
  {
    long l = System.currentTimeMillis();
    int i;
    if (l - this.d >= this.e)
    {
      Iterator localIterator = this.f.iterator();
      i = 0;
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (!locala.c()) {
          i = 1;
        } else {
          if (!locala.a()) {
            break label102;
          }
        }
      }
    }
    label102:
    for (int j = 1;; j = i)
    {
      i = j;
      break;
      if (i != 0)
      {
        f();
        e();
      }
      this.d = l;
      return;
    }
  }
  
  public void a(a parama)
  {
    this.f.add(parama);
  }
  
  public as b()
  {
    return this.c;
  }
  
  public void c()
  {
    Iterator localIterator = this.f.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.c())
      {
        if ((locala.e() == null) || (locala.e().isEmpty())) {
          break label88;
        }
        locala.a(null);
      }
    }
    label88:
    for (int j = 1;; j = i)
    {
      i = j;
      break;
      if (i != 0)
      {
        this.c.b(false);
        e();
      }
      return;
    }
  }
  
  public void d()
  {
    as localas = g();
    if (localas == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList(this.f.size());
    try
    {
      this.c = localas;
      Iterator localIterator1 = this.f.iterator();
      while (localIterator1.hasNext())
      {
        a locala2 = (a)localIterator1.next();
        locala2.a(this.c);
        if (!locala2.c()) {
          localArrayList.add(locala2);
        }
      }
      localIterator2 = localArrayList.iterator();
    }
    finally {}
    Iterator localIterator2;
    while (localIterator2.hasNext())
    {
      a locala1 = (a)localIterator2.next();
      this.f.remove(locala1);
    }
    f();
  }
  
  public void e()
  {
    if (this.c != null) {
      a(this.c);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.d
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */