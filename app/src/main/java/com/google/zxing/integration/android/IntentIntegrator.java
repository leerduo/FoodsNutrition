package com.google.zxing.integration.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class IntentIntegrator
{
  public static final Collection<String> a;
  public static final Collection<String> b;
  public static final Collection<String> c;
  public static final Collection<String> d;
  public static final Collection<String> e;
  private static final String f;
  private static final boolean l;
  private static final boolean m;
  private final Activity g;
  private android.app.Fragment h;
  private android.support.v4.app.Fragment i;
  private final Map<String, Object> j = new HashMap(3);
  private Collection<String> k;
  
  /* Error */
  static
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_0
    //   2: ldc 2
    //   4: invokevirtual 36	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   7: putstatic 38	com/google/zxing/integration/android/IntentIntegrator:f	Ljava/lang/String;
    //   10: iconst_5
    //   11: anewarray 40	java/lang/String
    //   14: astore_1
    //   15: aload_1
    //   16: iconst_0
    //   17: ldc 42
    //   19: aastore
    //   20: aload_1
    //   21: iload_0
    //   22: ldc 44
    //   24: aastore
    //   25: aload_1
    //   26: iconst_2
    //   27: ldc 46
    //   29: aastore
    //   30: aload_1
    //   31: iconst_3
    //   32: ldc 48
    //   34: aastore
    //   35: aload_1
    //   36: iconst_4
    //   37: ldc 50
    //   39: aastore
    //   40: aload_1
    //   41: invokestatic 53	com/google/zxing/integration/android/IntentIntegrator:a	([Ljava/lang/String;)Ljava/util/List;
    //   44: putstatic 55	com/google/zxing/integration/android/IntentIntegrator:a	Ljava/util/Collection;
    //   47: bipush 10
    //   49: anewarray 40	java/lang/String
    //   52: astore_2
    //   53: aload_2
    //   54: iconst_0
    //   55: ldc 42
    //   57: aastore
    //   58: aload_2
    //   59: iload_0
    //   60: ldc 44
    //   62: aastore
    //   63: aload_2
    //   64: iconst_2
    //   65: ldc 46
    //   67: aastore
    //   68: aload_2
    //   69: iconst_3
    //   70: ldc 48
    //   72: aastore
    //   73: aload_2
    //   74: iconst_4
    //   75: ldc 57
    //   77: aastore
    //   78: aload_2
    //   79: iconst_5
    //   80: ldc 59
    //   82: aastore
    //   83: aload_2
    //   84: bipush 6
    //   86: ldc 61
    //   88: aastore
    //   89: aload_2
    //   90: bipush 7
    //   92: ldc 63
    //   94: aastore
    //   95: aload_2
    //   96: bipush 8
    //   98: ldc 50
    //   100: aastore
    //   101: aload_2
    //   102: bipush 9
    //   104: ldc 65
    //   106: aastore
    //   107: aload_2
    //   108: invokestatic 53	com/google/zxing/integration/android/IntentIntegrator:a	([Ljava/lang/String;)Ljava/util/List;
    //   111: putstatic 67	com/google/zxing/integration/android/IntentIntegrator:b	Ljava/util/Collection;
    //   114: ldc 69
    //   116: invokestatic 75	java/util/Collections:singleton	(Ljava/lang/Object;)Ljava/util/Set;
    //   119: putstatic 77	com/google/zxing/integration/android/IntentIntegrator:c	Ljava/util/Collection;
    //   122: ldc 79
    //   124: invokestatic 75	java/util/Collections:singleton	(Ljava/lang/Object;)Ljava/util/Set;
    //   127: putstatic 81	com/google/zxing/integration/android/IntentIntegrator:d	Ljava/util/Collection;
    //   130: aconst_null
    //   131: putstatic 83	com/google/zxing/integration/android/IntentIntegrator:e	Ljava/util/Collection;
    //   134: ldc 85
    //   136: invokestatic 89	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   139: pop
    //   140: iload_0
    //   141: istore 4
    //   143: iload 4
    //   145: putstatic 91	com/google/zxing/integration/android/IntentIntegrator:l	Z
    //   148: ldc 93
    //   150: invokestatic 89	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   153: pop
    //   154: iload_0
    //   155: putstatic 95	com/google/zxing/integration/android/IntentIntegrator:m	Z
    //   158: return
    //   159: astore_3
    //   160: iconst_0
    //   161: istore 4
    //   163: goto -20 -> 143
    //   166: astore 5
    //   168: iconst_0
    //   169: istore_0
    //   170: goto -16 -> 154
    // Local variable table:
    //   start	length	slot	name	signature
    //   1	169	0	bool1	boolean
    //   14	27	1	arrayOfString1	String[]
    //   52	56	2	arrayOfString2	String[]
    //   159	1	3	localClassNotFoundException1	ClassNotFoundException
    //   141	21	4	bool2	boolean
    //   166	1	5	localClassNotFoundException2	ClassNotFoundException
    // Exception table:
    //   from	to	target	type
    //   134	140	159	java/lang/ClassNotFoundException
    //   148	154	166	java/lang/ClassNotFoundException
  }
  
  public IntentIntegrator(Activity paramActivity)
  {
    this.g = paramActivity;
  }
  
  public static IntentResult a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 49374)
    {
      if (paramInt2 == -1)
      {
        String str1 = paramIntent.getStringExtra("SCAN_RESULT");
        String str2 = paramIntent.getStringExtra("SCAN_RESULT_FORMAT");
        byte[] arrayOfByte = paramIntent.getByteArrayExtra("SCAN_RESULT_BYTES");
        int n = paramIntent.getIntExtra("SCAN_RESULT_ORIENTATION", -2147483648);
        Integer localInteger = null;
        if (n == -2147483648) {}
        for (;;)
        {
          return new IntentResult(str1, str2, arrayOfByte, localInteger, paramIntent.getStringExtra("SCAN_RESULT_ERROR_CORRECTION_LEVEL"));
          localInteger = Integer.valueOf(n);
        }
      }
      return new IntentResult();
    }
    return null;
  }
  
  private static List<String> a(String... paramVarArgs)
  {
    return Collections.unmodifiableList(Arrays.asList(paramVarArgs));
  }
  
  private void a(Intent paramIntent)
  {
    Iterator localIterator = this.j.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str = (String)localEntry.getKey();
      Object localObject = localEntry.getValue();
      if ((localObject instanceof Integer)) {
        paramIntent.putExtra(str, (Integer)localObject);
      } else if ((localObject instanceof Long)) {
        paramIntent.putExtra(str, (Long)localObject);
      } else if ((localObject instanceof Boolean)) {
        paramIntent.putExtra(str, (Boolean)localObject);
      } else if ((localObject instanceof Double)) {
        paramIntent.putExtra(str, (Double)localObject);
      } else if ((localObject instanceof Float)) {
        paramIntent.putExtra(str, (Float)localObject);
      } else if ((localObject instanceof Bundle)) {
        paramIntent.putExtra(str, (Bundle)localObject);
      } else {
        paramIntent.putExtra(str, localObject.toString());
      }
    }
  }
  
  private static String d()
  {
    if ((l) && (Build.VERSION.SDK_INT >= 15)) {
      return "com.google.zxing.client.android";
    }
    if (m) {
      return "com.google.zxing.client.androidlegacy";
    }
    return "com.google.zxing.client.android";
  }
  
  public final IntentIntegrator a(int paramInt)
  {
    a("ZXING_CAPTURE_LAYOUT_ID_KEY", Integer.valueOf(paramInt));
    return this;
  }
  
  public final IntentIntegrator a(String paramString)
  {
    if (paramString != null) {
      a("PROMPT_MESSAGE", paramString);
    }
    return this;
  }
  
  public final IntentIntegrator a(String paramString, Object paramObject)
  {
    this.j.put(paramString, paramObject);
    return this;
  }
  
  public IntentIntegrator a(Collection<String> paramCollection)
  {
    this.k = paramCollection;
    return this;
  }
  
  protected Class<?> a()
  {
    try
    {
      Class localClass = Class.forName(d() + ".CaptureActivity");
      return localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new RuntimeException("Could not find CaptureActivity. Make sure one of the zxing-android libraries are loaded.", localClassNotFoundException);
    }
  }
  
  protected void a(Intent paramIntent, int paramInt)
  {
    if (this.h != null)
    {
      if (Build.VERSION.SDK_INT >= 11) {
        this.h.startActivityForResult(paramIntent, paramInt);
      }
      return;
    }
    if (this.i != null)
    {
      this.i.startActivityForResult(paramIntent, paramInt);
      return;
    }
    this.g.startActivityForResult(paramIntent, paramInt);
  }
  
  public final IntentIntegrator b(int paramInt)
  {
    a("ZXINGLEGACY_CAPTURE_LAYOUT_ID_KEY", Integer.valueOf(paramInt));
    return this;
  }
  
  public final void b()
  {
    a(c(), 49374);
  }
  
  public final void b(Collection<String> paramCollection)
  {
    a(paramCollection);
    b();
  }
  
  public Intent c()
  {
    Intent localIntent = new Intent(this.g, a());
    localIntent.setAction("com.google.zxing.client.android.SCAN");
    if (this.k != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = this.k.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (localStringBuilder.length() > 0) {
          localStringBuilder.append(',');
        }
        localStringBuilder.append(str);
      }
      localIntent.putExtra("SCAN_FORMATS", localStringBuilder.toString());
    }
    localIntent.addFlags(67108864);
    localIntent.addFlags(524288);
    a(localIntent);
    return localIntent;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.integration.android.IntentIntegrator
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */