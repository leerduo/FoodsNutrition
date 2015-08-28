package u.aly;

import android.content.Context;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class f
{
  private static final byte[] a = "pbl0".getBytes();
  private at b = null;
  private Context c;
  
  public f(Context paramContext)
  {
    this.c = paramContext;
  }
  
  private at a(at paramat1, at paramat2)
  {
    if (paramat2 == null) {
      return paramat1;
    }
    Map localMap = paramat1.a();
    Iterator localIterator = paramat2.a().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((au)localEntry.getValue()).b()) {
        localMap.put(localEntry.getKey(), localEntry.getValue());
      } else {
        localMap.remove(localEntry.getKey());
      }
    }
    paramat1.a(paramat2.b());
    paramat1.a(a(paramat1));
    return paramat1;
  }
  
  private boolean c(at paramat)
  {
    if (!paramat.d().equals(a(paramat))) {
      return false;
    }
    Iterator localIterator = paramat.a().values().iterator();
    while (localIterator.hasNext())
    {
      au localau = (au)localIterator.next();
      byte[] arrayOfByte1 = c.b(localau.e());
      byte[] arrayOfByte2 = a(localau);
      for (int i = 0; i < 4; i++) {
        if (arrayOfByte1[i] != arrayOfByte2[i]) {
          return false;
        }
      }
    }
    return true;
  }
  
  public String a(at paramat)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = new TreeMap(paramat.a()).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localStringBuilder.append((String)localEntry.getKey());
      localStringBuilder.append(((au)localEntry.getValue()).a());
      localStringBuilder.append(((au)localEntry.getValue()).c());
      localStringBuilder.append(((au)localEntry.getValue()).e());
    }
    localStringBuilder.append(paramat.b);
    return bv.a(localStringBuilder.toString()).toLowerCase(Locale.US);
  }
  
  public at a()
  {
    try
    {
      at localat = this.b;
      return localat;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public byte[] a(au paramau)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(8);
    localByteBuffer.order(null);
    localByteBuffer.putLong(paramau.c());
    byte[] arrayOfByte1 = localByteBuffer.array();
    byte[] arrayOfByte2 = a;
    byte[] arrayOfByte3 = new byte[4];
    for (int i = 0; i < 4; i++) {
      arrayOfByte3[i] = ((byte)(arrayOfByte1[i] ^ arrayOfByte2[i]));
    }
    return arrayOfByte3;
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: new 183	java/io/File
    //   5: dup
    //   6: aload_0
    //   7: getfield 30	u/aly/f:c	Landroid/content/Context;
    //   10: invokevirtual 189	android/content/Context:getFilesDir	()Ljava/io/File;
    //   13: ldc 191
    //   15: invokespecial 194	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   18: invokevirtual 197	java/io/File:exists	()Z
    //   21: ifne +4 -> 25
    //   24: return
    //   25: aload_0
    //   26: getfield 30	u/aly/f:c	Landroid/content/Context;
    //   29: ldc 191
    //   31: invokevirtual 201	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   34: astore 8
    //   36: aload 8
    //   38: astore 4
    //   40: aload 4
    //   42: invokestatic 204	u/aly/bv:b	(Ljava/io/InputStream;)[B
    //   45: astore 9
    //   47: aload 9
    //   49: astore 5
    //   51: aload 4
    //   53: invokestatic 207	u/aly/bv:c	(Ljava/io/InputStream;)V
    //   56: aload 5
    //   58: ifnull -34 -> 24
    //   61: new 33	u/aly/at
    //   64: dup
    //   65: invokespecial 208	u/aly/at:<init>	()V
    //   68: astore 6
    //   70: new 210	u/aly/cc
    //   73: dup
    //   74: invokespecial 211	u/aly/cc:<init>	()V
    //   77: aload 6
    //   79: aload 5
    //   81: invokevirtual 214	u/aly/cc:a	(Lu/aly/bz;[B)V
    //   84: aload_0
    //   85: aload 6
    //   87: putfield 28	u/aly/f:b	Lu/aly/at;
    //   90: return
    //   91: astore 7
    //   93: aload 7
    //   95: invokevirtual 217	java/lang/Exception:printStackTrace	()V
    //   98: return
    //   99: astore_3
    //   100: aconst_null
    //   101: astore 4
    //   103: aload_3
    //   104: invokevirtual 217	java/lang/Exception:printStackTrace	()V
    //   107: aload 4
    //   109: invokestatic 207	u/aly/bv:c	(Ljava/io/InputStream;)V
    //   112: aconst_null
    //   113: astore 5
    //   115: goto -59 -> 56
    //   118: astore_2
    //   119: aload_1
    //   120: invokestatic 207	u/aly/bv:c	(Ljava/io/InputStream;)V
    //   123: aload_2
    //   124: athrow
    //   125: astore_2
    //   126: aload 4
    //   128: astore_1
    //   129: goto -10 -> 119
    //   132: astore_3
    //   133: goto -30 -> 103
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	this	f
    //   1	128	1	localObject1	Object
    //   118	6	2	localObject2	Object
    //   125	1	2	localObject3	Object
    //   99	5	3	localException1	Exception
    //   132	1	3	localException2	Exception
    //   38	89	4	localFileInputStream1	java.io.FileInputStream
    //   49	65	5	arrayOfByte1	byte[]
    //   68	18	6	localat	at
    //   91	3	7	localException3	Exception
    //   34	3	8	localFileInputStream2	java.io.FileInputStream
    //   45	3	9	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   61	90	91	java/lang/Exception
    //   25	36	99	java/lang/Exception
    //   25	36	118	finally
    //   40	47	125	finally
    //   103	107	125	finally
    //   40	47	132	java/lang/Exception
  }
  
  public void b(at paramat)
  {
    if (paramat == null) {}
    while (!c(paramat)) {
      return;
    }
    for (;;)
    {
      at localat1;
      try
      {
        localat1 = this.b;
        if (localat1 == null)
        {
          this.b = paramat;
          return;
        }
      }
      finally {}
      at localat2 = a(localat1, paramat);
      paramat = localat2;
    }
  }
  
  public void c()
  {
    if (this.b == null) {
      return;
    }
    try
    {
      byte[] arrayOfByte = new ci().a(this.b);
      bv.a(new File(this.c.getFilesDir(), ".imprint"), arrayOfByte);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.f
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */