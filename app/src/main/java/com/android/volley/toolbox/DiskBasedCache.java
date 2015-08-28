package com.android.volley.toolbox;

import android.os.SystemClock;
import com.android.volley.Cache;
import com.android.volley.VolleyLog;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DiskBasedCache
  implements Cache
{
  private final Map<String, DiskBasedCache.CacheHeader> a = new LinkedHashMap(16, 0.75F, true);
  private long b = 0L;
  private final File c;
  private final int d;
  
  public DiskBasedCache(File paramFile)
  {
    this(paramFile, 5242880);
  }
  
  public DiskBasedCache(File paramFile, int paramInt)
  {
    this.c = paramFile;
    this.d = paramInt;
  }
  
  static int a(InputStream paramInputStream)
  {
    return 0x0 | e(paramInputStream) << 0 | e(paramInputStream) << 8 | e(paramInputStream) << 16 | e(paramInputStream) << 24;
  }
  
  private void a(int paramInt)
  {
    if (this.b + paramInt < this.d) {}
    label258:
    for (;;)
    {
      return;
      if (VolleyLog.b) {
        VolleyLog.a("Pruning old cache entries.", new Object[0]);
      }
      long l1 = this.b;
      long l2 = SystemClock.elapsedRealtime();
      Iterator localIterator = this.a.entrySet().iterator();
      int i = 0;
      DiskBasedCache.CacheHeader localCacheHeader;
      label120:
      int j;
      if (localIterator.hasNext())
      {
        localCacheHeader = (DiskBasedCache.CacheHeader)((Map.Entry)localIterator.next()).getValue();
        if (c(localCacheHeader.b).delete())
        {
          this.b -= localCacheHeader.a;
          localIterator.remove();
          j = i + 1;
          if ((float)(this.b + paramInt) >= 0.9F * this.d) {
            break label246;
          }
        }
      }
      for (;;)
      {
        if (!VolleyLog.b) {
          break label258;
        }
        Object[] arrayOfObject1 = new Object[3];
        arrayOfObject1[0] = Integer.valueOf(j);
        arrayOfObject1[1] = Long.valueOf(this.b - l1);
        arrayOfObject1[2] = Long.valueOf(SystemClock.elapsedRealtime() - l2);
        VolleyLog.a("pruned %d files, %d bytes, %d ms", arrayOfObject1);
        return;
        Object[] arrayOfObject2 = new Object[2];
        arrayOfObject2[0] = localCacheHeader.b;
        arrayOfObject2[1] = d(localCacheHeader.b);
        VolleyLog.b("Could not delete cache entry for key=%s, filename=%s", arrayOfObject2);
        break label120;
        label246:
        i = j;
        break;
        j = i;
      }
    }
  }
  
  static void a(OutputStream paramOutputStream, int paramInt)
  {
    paramOutputStream.write(0xFF & paramInt >> 0);
    paramOutputStream.write(0xFF & paramInt >> 8);
    paramOutputStream.write(0xFF & paramInt >> 16);
    paramOutputStream.write(0xFF & paramInt >> 24);
  }
  
  static void a(OutputStream paramOutputStream, long paramLong)
  {
    paramOutputStream.write((byte)(int)(paramLong >>> 0));
    paramOutputStream.write((byte)(int)(paramLong >>> 8));
    paramOutputStream.write((byte)(int)(paramLong >>> 16));
    paramOutputStream.write((byte)(int)(paramLong >>> 24));
    paramOutputStream.write((byte)(int)(paramLong >>> 32));
    paramOutputStream.write((byte)(int)(paramLong >>> 40));
    paramOutputStream.write((byte)(int)(paramLong >>> 48));
    paramOutputStream.write((byte)(int)(paramLong >>> 56));
  }
  
  static void a(OutputStream paramOutputStream, String paramString)
  {
    byte[] arrayOfByte = paramString.getBytes("UTF-8");
    a(paramOutputStream, arrayOfByte.length);
    paramOutputStream.write(arrayOfByte, 0, arrayOfByte.length);
  }
  
  private void a(String paramString, DiskBasedCache.CacheHeader paramCacheHeader)
  {
    if (!this.a.containsKey(paramString)) {}
    DiskBasedCache.CacheHeader localCacheHeader;
    for (this.b += paramCacheHeader.a;; this.b += paramCacheHeader.a - localCacheHeader.a)
    {
      this.a.put(paramString, paramCacheHeader);
      return;
      localCacheHeader = (DiskBasedCache.CacheHeader)this.a.get(paramString);
    }
  }
  
  static void a(Map<String, String> paramMap, OutputStream paramOutputStream)
  {
    if (paramMap != null)
    {
      a(paramOutputStream, paramMap.size());
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        a(paramOutputStream, (String)localEntry.getKey());
        a(paramOutputStream, (String)localEntry.getValue());
      }
    }
    a(paramOutputStream, 0);
  }
  
  private static byte[] a(InputStream paramInputStream, int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      int j = paramInputStream.read(arrayOfByte, i, paramInt - i);
      if (j == -1) {
        break;
      }
      i += j;
    }
    if (i != paramInt) {
      throw new IOException("Expected " + paramInt + " bytes, read " + i + " bytes");
    }
    return arrayOfByte;
  }
  
  static long b(InputStream paramInputStream)
  {
    return 0L | (0xFF & e(paramInputStream)) << 0 | (0xFF & e(paramInputStream)) << 8 | (0xFF & e(paramInputStream)) << 16 | (0xFF & e(paramInputStream)) << 24 | (0xFF & e(paramInputStream)) << 32 | (0xFF & e(paramInputStream)) << 40 | (0xFF & e(paramInputStream)) << 48 | (0xFF & e(paramInputStream)) << 56;
  }
  
  static String c(InputStream paramInputStream)
  {
    return new String(a(paramInputStream, (int)b(paramInputStream)), "UTF-8");
  }
  
  private String d(String paramString)
  {
    int i = paramString.length() / 2;
    String str = String.valueOf(paramString.substring(0, i).hashCode());
    return str + String.valueOf(paramString.substring(i).hashCode());
  }
  
  static Map<String, String> d(InputStream paramInputStream)
  {
    int i = a(paramInputStream);
    if (i == 0) {}
    for (Object localObject = Collections.emptyMap();; localObject = new HashMap(i)) {
      for (int j = 0; j < i; j++) {
        ((Map)localObject).put(c(paramInputStream).intern(), c(paramInputStream).intern());
      }
    }
    return localObject;
  }
  
  private static int e(InputStream paramInputStream)
  {
    int i = paramInputStream.read();
    if (i == -1) {
      throw new EOFException();
    }
    return i;
  }
  
  private void e(String paramString)
  {
    DiskBasedCache.CacheHeader localCacheHeader = (DiskBasedCache.CacheHeader)this.a.get(paramString);
    if (localCacheHeader != null)
    {
      this.b -= localCacheHeader.a;
      this.a.remove(paramString);
    }
  }
  
  /* Error */
  public com.android.volley.Cache.Entry a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 32	com/android/volley/toolbox/DiskBasedCache:a	Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface 159 2 0
    //   12: checkcast 88	com/android/volley/toolbox/DiskBasedCache$CacheHeader
    //   15: astore_3
    //   16: aload_3
    //   17: ifnonnull +11 -> 28
    //   20: aconst_null
    //   21: astore 9
    //   23: aload_0
    //   24: monitorexit
    //   25: aload 9
    //   27: areturn
    //   28: aload_0
    //   29: aload_1
    //   30: invokevirtual 94	com/android/volley/toolbox/DiskBasedCache:c	(Ljava/lang/String;)Ljava/io/File;
    //   33: astore 4
    //   35: new 257	com/android/volley/toolbox/DiskBasedCache$CountingInputStream
    //   38: dup
    //   39: new 259	java/io/FileInputStream
    //   42: dup
    //   43: aload 4
    //   45: invokespecial 261	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   48: aconst_null
    //   49: invokespecial 264	com/android/volley/toolbox/DiskBasedCache$CountingInputStream:<init>	(Ljava/io/InputStream;Lcom/android/volley/toolbox/DiskBasedCache$1;)V
    //   52: astore 5
    //   54: aload 5
    //   56: invokestatic 267	com/android/volley/toolbox/DiskBasedCache$CacheHeader:a	(Ljava/io/InputStream;)Lcom/android/volley/toolbox/DiskBasedCache$CacheHeader;
    //   59: pop
    //   60: aload_3
    //   61: aload 5
    //   63: aload 4
    //   65: invokevirtual 269	java/io/File:length	()J
    //   68: aload 5
    //   70: invokestatic 272	com/android/volley/toolbox/DiskBasedCache$CountingInputStream:a	(Lcom/android/volley/toolbox/DiskBasedCache$CountingInputStream;)I
    //   73: i2l
    //   74: lsub
    //   75: l2i
    //   76: invokestatic 211	com/android/volley/toolbox/DiskBasedCache:a	(Ljava/io/InputStream;I)[B
    //   79: invokevirtual 275	com/android/volley/toolbox/DiskBasedCache$CacheHeader:a	([B)Lcom/android/volley/Cache$Entry;
    //   82: astore 13
    //   84: aload 13
    //   86: astore 9
    //   88: aload 5
    //   90: ifnull -67 -> 23
    //   93: aload 5
    //   95: invokevirtual 278	com/android/volley/toolbox/DiskBasedCache$CountingInputStream:close	()V
    //   98: goto -75 -> 23
    //   101: astore 14
    //   103: aconst_null
    //   104: astore 9
    //   106: goto -83 -> 23
    //   109: astore 6
    //   111: aconst_null
    //   112: astore 5
    //   114: iconst_2
    //   115: anewarray 4	java/lang/Object
    //   118: astore 10
    //   120: aload 10
    //   122: iconst_0
    //   123: aload 4
    //   125: invokevirtual 281	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   128: aastore
    //   129: aload 10
    //   131: iconst_1
    //   132: aload 6
    //   134: invokevirtual 282	java/io/IOException:toString	()Ljava/lang/String;
    //   137: aastore
    //   138: ldc_w 284
    //   141: aload 10
    //   143: invokestatic 125	com/android/volley/VolleyLog:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   146: aload_0
    //   147: aload_1
    //   148: invokevirtual 286	com/android/volley/toolbox/DiskBasedCache:b	(Ljava/lang/String;)V
    //   151: aload 5
    //   153: ifnull +8 -> 161
    //   156: aload 5
    //   158: invokevirtual 278	com/android/volley/toolbox/DiskBasedCache$CountingInputStream:close	()V
    //   161: aconst_null
    //   162: astore 9
    //   164: goto -141 -> 23
    //   167: astore 11
    //   169: aconst_null
    //   170: astore 9
    //   172: goto -149 -> 23
    //   175: astore 7
    //   177: aconst_null
    //   178: astore 5
    //   180: aload 5
    //   182: ifnull +8 -> 190
    //   185: aload 5
    //   187: invokevirtual 278	com/android/volley/toolbox/DiskBasedCache$CountingInputStream:close	()V
    //   190: aload 7
    //   192: athrow
    //   193: astore_2
    //   194: aload_0
    //   195: monitorexit
    //   196: aload_2
    //   197: athrow
    //   198: astore 8
    //   200: aconst_null
    //   201: astore 9
    //   203: goto -180 -> 23
    //   206: astore 7
    //   208: goto -28 -> 180
    //   211: astore 6
    //   213: goto -99 -> 114
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	216	0	this	DiskBasedCache
    //   0	216	1	paramString	String
    //   193	4	2	localObject1	Object
    //   15	46	3	localCacheHeader	DiskBasedCache.CacheHeader
    //   33	91	4	localFile	File
    //   52	134	5	localCountingInputStream	DiskBasedCache.CountingInputStream
    //   109	24	6	localIOException1	IOException
    //   211	1	6	localIOException2	IOException
    //   175	16	7	localObject2	Object
    //   206	1	7	localObject3	Object
    //   198	1	8	localIOException3	IOException
    //   21	181	9	localObject4	Object
    //   118	24	10	arrayOfObject	Object[]
    //   167	1	11	localIOException4	IOException
    //   82	3	13	localEntry	com.android.volley.Cache.Entry
    //   101	1	14	localIOException5	IOException
    // Exception table:
    //   from	to	target	type
    //   93	98	101	java/io/IOException
    //   35	54	109	java/io/IOException
    //   156	161	167	java/io/IOException
    //   35	54	175	finally
    //   2	16	193	finally
    //   28	35	193	finally
    //   93	98	193	finally
    //   156	161	193	finally
    //   185	190	193	finally
    //   190	193	193	finally
    //   185	190	198	java/io/IOException
    //   54	84	206	finally
    //   114	151	206	finally
    //   54	84	211	java/io/IOException
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 36	com/android/volley/toolbox/DiskBasedCache:c	Ljava/io/File;
    //   6: invokevirtual 289	java/io/File:exists	()Z
    //   9: ifne +41 -> 50
    //   12: aload_0
    //   13: getfield 36	com/android/volley/toolbox/DiskBasedCache:c	Ljava/io/File;
    //   16: invokevirtual 292	java/io/File:mkdirs	()Z
    //   19: ifne +28 -> 47
    //   22: iconst_1
    //   23: anewarray 4	java/lang/Object
    //   26: astore 17
    //   28: aload 17
    //   30: iconst_0
    //   31: aload_0
    //   32: getfield 36	com/android/volley/toolbox/DiskBasedCache:c	Ljava/io/File;
    //   35: invokevirtual 281	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   38: aastore
    //   39: ldc_w 294
    //   42: aload 17
    //   44: invokestatic 296	com/android/volley/VolleyLog:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   47: aload_0
    //   48: monitorexit
    //   49: return
    //   50: aload_0
    //   51: getfield 36	com/android/volley/toolbox/DiskBasedCache:c	Ljava/io/File;
    //   54: invokevirtual 300	java/io/File:listFiles	()[Ljava/io/File;
    //   57: astore_2
    //   58: aload_2
    //   59: ifnull -12 -> 47
    //   62: aload_2
    //   63: arraylength
    //   64: istore_3
    //   65: iconst_0
    //   66: istore 4
    //   68: iload 4
    //   70: iload_3
    //   71: if_icmpge -24 -> 47
    //   74: aload_2
    //   75: iload 4
    //   77: aaload
    //   78: astore 5
    //   80: aconst_null
    //   81: astore 6
    //   83: new 302	java/io/BufferedInputStream
    //   86: dup
    //   87: new 259	java/io/FileInputStream
    //   90: dup
    //   91: aload 5
    //   93: invokespecial 261	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   96: invokespecial 305	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   99: astore 7
    //   101: aload 7
    //   103: invokestatic 267	com/android/volley/toolbox/DiskBasedCache$CacheHeader:a	(Ljava/io/InputStream;)Lcom/android/volley/toolbox/DiskBasedCache$CacheHeader;
    //   106: astore 14
    //   108: aload 14
    //   110: aload 5
    //   112: invokevirtual 269	java/io/File:length	()J
    //   115: putfield 101	com/android/volley/toolbox/DiskBasedCache$CacheHeader:a	J
    //   118: aload_0
    //   119: aload 14
    //   121: getfield 91	com/android/volley/toolbox/DiskBasedCache$CacheHeader:b	Ljava/lang/String;
    //   124: aload 14
    //   126: invokespecial 307	com/android/volley/toolbox/DiskBasedCache:a	(Ljava/lang/String;Lcom/android/volley/toolbox/DiskBasedCache$CacheHeader;)V
    //   129: aload 7
    //   131: ifnull +8 -> 139
    //   134: aload 7
    //   136: invokevirtual 308	java/io/BufferedInputStream:close	()V
    //   139: iinc 4 1
    //   142: goto -74 -> 68
    //   145: astore 16
    //   147: aconst_null
    //   148: astore 7
    //   150: aload 5
    //   152: ifnull +9 -> 161
    //   155: aload 5
    //   157: invokevirtual 99	java/io/File:delete	()Z
    //   160: pop
    //   161: aload 7
    //   163: ifnull -24 -> 139
    //   166: aload 7
    //   168: invokevirtual 308	java/io/BufferedInputStream:close	()V
    //   171: goto -32 -> 139
    //   174: astore 9
    //   176: goto -37 -> 139
    //   179: astore 11
    //   181: aload 6
    //   183: ifnull +8 -> 191
    //   186: aload 6
    //   188: invokevirtual 308	java/io/BufferedInputStream:close	()V
    //   191: aload 11
    //   193: athrow
    //   194: astore_1
    //   195: aload_0
    //   196: monitorexit
    //   197: aload_1
    //   198: athrow
    //   199: astore 15
    //   201: goto -62 -> 139
    //   204: astore 12
    //   206: goto -15 -> 191
    //   209: astore 10
    //   211: aload 7
    //   213: astore 6
    //   215: aload 10
    //   217: astore 11
    //   219: goto -38 -> 181
    //   222: astore 8
    //   224: goto -74 -> 150
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	227	0	this	DiskBasedCache
    //   194	4	1	localObject1	Object
    //   57	18	2	arrayOfFile	File[]
    //   64	8	3	i	int
    //   66	74	4	j	int
    //   78	78	5	localFile	File
    //   81	133	6	localObject2	Object
    //   99	113	7	localBufferedInputStream	java.io.BufferedInputStream
    //   222	1	8	localIOException1	IOException
    //   174	1	9	localIOException2	IOException
    //   209	7	10	localObject3	Object
    //   179	13	11	localObject4	Object
    //   217	1	11	localObject5	Object
    //   204	1	12	localIOException3	IOException
    //   106	19	14	localCacheHeader	DiskBasedCache.CacheHeader
    //   199	1	15	localIOException4	IOException
    //   145	1	16	localIOException5	IOException
    //   26	17	17	arrayOfObject	Object[]
    // Exception table:
    //   from	to	target	type
    //   83	101	145	java/io/IOException
    //   166	171	174	java/io/IOException
    //   83	101	179	finally
    //   2	47	194	finally
    //   50	58	194	finally
    //   62	65	194	finally
    //   74	80	194	finally
    //   134	139	194	finally
    //   166	171	194	finally
    //   186	191	194	finally
    //   191	194	194	finally
    //   134	139	199	java/io/IOException
    //   186	191	204	java/io/IOException
    //   101	129	209	finally
    //   155	161	209	finally
    //   101	129	222	java/io/IOException
  }
  
  /* Error */
  public void a(String paramString, com.android.volley.Cache.Entry paramEntry)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_2
    //   4: getfield 314	com/android/volley/Cache$Entry:a	[B
    //   7: arraylength
    //   8: invokespecial 316	com/android/volley/toolbox/DiskBasedCache:a	(I)V
    //   11: aload_0
    //   12: aload_1
    //   13: invokevirtual 94	com/android/volley/toolbox/DiskBasedCache:c	(Ljava/lang/String;)Ljava/io/File;
    //   16: astore 4
    //   18: new 318	java/io/FileOutputStream
    //   21: dup
    //   22: aload 4
    //   24: invokespecial 319	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   27: astore 5
    //   29: new 88	com/android/volley/toolbox/DiskBasedCache$CacheHeader
    //   32: dup
    //   33: aload_1
    //   34: aload_2
    //   35: invokespecial 321	com/android/volley/toolbox/DiskBasedCache$CacheHeader:<init>	(Ljava/lang/String;Lcom/android/volley/Cache$Entry;)V
    //   38: astore 6
    //   40: aload 6
    //   42: aload 5
    //   44: invokevirtual 324	com/android/volley/toolbox/DiskBasedCache$CacheHeader:a	(Ljava/io/OutputStream;)Z
    //   47: ifne +75 -> 122
    //   50: aload 5
    //   52: invokevirtual 325	java/io/FileOutputStream:close	()V
    //   55: iconst_1
    //   56: anewarray 4	java/lang/Object
    //   59: astore 9
    //   61: aload 9
    //   63: iconst_0
    //   64: aload 4
    //   66: invokevirtual 281	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   69: aastore
    //   70: ldc_w 327
    //   73: aload 9
    //   75: invokestatic 125	com/android/volley/VolleyLog:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   78: new 180	java/io/IOException
    //   81: dup
    //   82: invokespecial 328	java/io/IOException:<init>	()V
    //   85: athrow
    //   86: astore 7
    //   88: aload 4
    //   90: invokevirtual 99	java/io/File:delete	()Z
    //   93: ifne +26 -> 119
    //   96: iconst_1
    //   97: anewarray 4	java/lang/Object
    //   100: astore 8
    //   102: aload 8
    //   104: iconst_0
    //   105: aload 4
    //   107: invokevirtual 281	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   110: aastore
    //   111: ldc_w 330
    //   114: aload 8
    //   116: invokestatic 125	com/android/volley/VolleyLog:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   119: aload_0
    //   120: monitorexit
    //   121: return
    //   122: aload 5
    //   124: aload_2
    //   125: getfield 314	com/android/volley/Cache$Entry:a	[B
    //   128: invokevirtual 333	java/io/FileOutputStream:write	([B)V
    //   131: aload 5
    //   133: invokevirtual 325	java/io/FileOutputStream:close	()V
    //   136: aload_0
    //   137: aload_1
    //   138: aload 6
    //   140: invokespecial 307	com/android/volley/toolbox/DiskBasedCache:a	(Ljava/lang/String;Lcom/android/volley/toolbox/DiskBasedCache$CacheHeader;)V
    //   143: goto -24 -> 119
    //   146: astore_3
    //   147: aload_0
    //   148: monitorexit
    //   149: aload_3
    //   150: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	this	DiskBasedCache
    //   0	151	1	paramString	String
    //   0	151	2	paramEntry	com.android.volley.Cache.Entry
    //   146	4	3	localObject	Object
    //   16	90	4	localFile	File
    //   27	105	5	localFileOutputStream	java.io.FileOutputStream
    //   38	101	6	localCacheHeader	DiskBasedCache.CacheHeader
    //   86	1	7	localIOException	IOException
    //   100	15	8	arrayOfObject1	Object[]
    //   59	15	9	arrayOfObject2	Object[]
    // Exception table:
    //   from	to	target	type
    //   18	86	86	java/io/IOException
    //   122	143	86	java/io/IOException
    //   2	18	146	finally
    //   18	86	146	finally
    //   88	119	146	finally
    //   122	143	146	finally
  }
  
  public void b(String paramString)
  {
    try
    {
      boolean bool = c(paramString).delete();
      e(paramString);
      if (!bool)
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = paramString;
        arrayOfObject[1] = d(paramString);
        VolleyLog.b("Could not delete cache entry for key=%s, filename=%s", arrayOfObject);
      }
      return;
    }
    finally {}
  }
  
  public File c(String paramString)
  {
    return new File(this.c, d(paramString));
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.android.volley.toolbox.DiskBasedCache
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */