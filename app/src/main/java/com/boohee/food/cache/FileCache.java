package com.boohee.food.cache;

import android.content.Context;
import android.os.Process;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class FileCache
{
  private static Map<String, FileCache> a = new HashMap();
  private FileCache.ACacheManager b;
  
  private FileCache(File paramFile, long paramLong, int paramInt)
  {
    if ((!paramFile.exists()) && (!paramFile.mkdirs())) {
      throw new RuntimeException("can't make dirs in " + paramFile.getAbsolutePath());
    }
    this.b = new FileCache.ACacheManager(this, paramFile, paramLong, paramInt, null);
  }
  
  public static FileCache a(Context paramContext)
  {
    return a(paramContext, "ACache");
  }
  
  public static FileCache a(Context paramContext, String paramString)
  {
    return a(new File(paramContext.getCacheDir(), paramString), 50000000L, 2147483647);
  }
  
  public static FileCache a(File paramFile, long paramLong, int paramInt)
  {
    FileCache localFileCache = (FileCache)a.get(paramFile.getAbsoluteFile() + a());
    if (localFileCache == null)
    {
      localFileCache = new FileCache(paramFile, paramLong, paramInt);
      a.put(paramFile.getAbsolutePath() + a(), localFileCache);
    }
    return localFileCache;
  }
  
  private static String a()
  {
    return "_" + Process.myPid();
  }
  
  /* Error */
  public String a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 57	com/boohee/food/cache/FileCache:b	Lcom/boohee/food/cache/FileCache$ACacheManager;
    //   4: aload_1
    //   5: invokestatic 115	com/boohee/food/cache/FileCache$ACacheManager:b	(Lcom/boohee/food/cache/FileCache$ACacheManager;Ljava/lang/String;)Ljava/io/File;
    //   8: astore_2
    //   9: aload_2
    //   10: invokevirtual 26	java/io/File:exists	()Z
    //   13: istore_3
    //   14: aconst_null
    //   15: astore 4
    //   17: iload_3
    //   18: ifne +6 -> 24
    //   21: aload 4
    //   23: areturn
    //   24: new 117	java/io/BufferedReader
    //   27: dup
    //   28: new 119	java/io/FileReader
    //   31: dup
    //   32: aload_2
    //   33: invokespecial 122	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   36: invokespecial 125	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   39: astore 5
    //   41: ldc 127
    //   43: astore 6
    //   45: aload 5
    //   47: invokevirtual 130	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   50: astore 11
    //   52: aload 11
    //   54: ifnull +28 -> 82
    //   57: new 33	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   64: aload 6
    //   66: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: aload 11
    //   71: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: astore 6
    //   79: goto -34 -> 45
    //   82: aload 6
    //   84: invokestatic 135	com/boohee/food/cache/FileCache$Utils:a	(Ljava/lang/String;)Z
    //   87: ifne +37 -> 124
    //   90: aload 6
    //   92: invokestatic 137	com/boohee/food/cache/FileCache$Utils:b	(Ljava/lang/String;)Ljava/lang/String;
    //   95: astore 14
    //   97: aload 14
    //   99: astore 4
    //   101: aload 5
    //   103: ifnull -82 -> 21
    //   106: aload 5
    //   108: invokevirtual 140	java/io/BufferedReader:close	()V
    //   111: aload 4
    //   113: areturn
    //   114: astore 15
    //   116: aload 15
    //   118: invokevirtual 143	java/io/IOException:printStackTrace	()V
    //   121: aload 4
    //   123: areturn
    //   124: aload 5
    //   126: ifnull +8 -> 134
    //   129: aload 5
    //   131: invokevirtual 140	java/io/BufferedReader:close	()V
    //   134: aload_0
    //   135: aload_1
    //   136: invokevirtual 146	com/boohee/food/cache/FileCache:c	(Ljava/lang/String;)Z
    //   139: pop
    //   140: aconst_null
    //   141: areturn
    //   142: astore 13
    //   144: aload 13
    //   146: invokevirtual 143	java/io/IOException:printStackTrace	()V
    //   149: goto -15 -> 134
    //   152: astore 7
    //   154: aconst_null
    //   155: astore 5
    //   157: aload 7
    //   159: invokevirtual 143	java/io/IOException:printStackTrace	()V
    //   162: aconst_null
    //   163: astore 4
    //   165: aload 5
    //   167: ifnull -146 -> 21
    //   170: aload 5
    //   172: invokevirtual 140	java/io/BufferedReader:close	()V
    //   175: aconst_null
    //   176: areturn
    //   177: astore 10
    //   179: aload 10
    //   181: invokevirtual 143	java/io/IOException:printStackTrace	()V
    //   184: aconst_null
    //   185: areturn
    //   186: astore 16
    //   188: aconst_null
    //   189: astore 5
    //   191: aload 16
    //   193: astore 8
    //   195: aload 5
    //   197: ifnull +8 -> 205
    //   200: aload 5
    //   202: invokevirtual 140	java/io/BufferedReader:close	()V
    //   205: aload 8
    //   207: athrow
    //   208: astore 9
    //   210: aload 9
    //   212: invokevirtual 143	java/io/IOException:printStackTrace	()V
    //   215: goto -10 -> 205
    //   218: astore 8
    //   220: goto -25 -> 195
    //   223: astore 7
    //   225: goto -68 -> 157
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	228	0	this	FileCache
    //   0	228	1	paramString	String
    //   8	25	2	localFile	File
    //   13	5	3	bool	boolean
    //   15	149	4	localObject1	Object
    //   39	162	5	localBufferedReader	java.io.BufferedReader
    //   43	48	6	str1	String
    //   152	6	7	localIOException1	java.io.IOException
    //   223	1	7	localIOException2	java.io.IOException
    //   193	13	8	localObject2	Object
    //   218	1	8	localObject3	Object
    //   208	3	9	localIOException3	java.io.IOException
    //   177	3	10	localIOException4	java.io.IOException
    //   50	20	11	str2	String
    //   142	3	13	localIOException5	java.io.IOException
    //   95	3	14	str3	String
    //   114	3	15	localIOException6	java.io.IOException
    //   186	6	16	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   106	111	114	java/io/IOException
    //   129	134	142	java/io/IOException
    //   24	41	152	java/io/IOException
    //   170	175	177	java/io/IOException
    //   24	41	186	finally
    //   200	205	208	java/io/IOException
    //   45	52	218	finally
    //   57	79	218	finally
    //   82	97	218	finally
    //   157	162	218	finally
    //   45	52	223	java/io/IOException
    //   57	79	223	java/io/IOException
    //   82	97	223	java/io/IOException
  }
  
  /* Error */
  public void a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 57	com/boohee/food/cache/FileCache:b	Lcom/boohee/food/cache/FileCache$ACacheManager;
    //   4: aload_1
    //   5: invokestatic 149	com/boohee/food/cache/FileCache$ACacheManager:a	(Lcom/boohee/food/cache/FileCache$ACacheManager;Ljava/lang/String;)Ljava/io/File;
    //   8: astore_3
    //   9: aconst_null
    //   10: astore 4
    //   12: new 151	java/io/BufferedWriter
    //   15: dup
    //   16: new 153	java/io/FileWriter
    //   19: dup
    //   20: aload_3
    //   21: invokespecial 154	java/io/FileWriter:<init>	(Ljava/io/File;)V
    //   24: sipush 1024
    //   27: invokespecial 157	java/io/BufferedWriter:<init>	(Ljava/io/Writer;I)V
    //   30: astore 5
    //   32: aload 5
    //   34: aload_2
    //   35: invokevirtual 160	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   38: aload 5
    //   40: ifnull +13 -> 53
    //   43: aload 5
    //   45: invokevirtual 163	java/io/BufferedWriter:flush	()V
    //   48: aload 5
    //   50: invokevirtual 164	java/io/BufferedWriter:close	()V
    //   53: aload_0
    //   54: getfield 57	com/boohee/food/cache/FileCache:b	Lcom/boohee/food/cache/FileCache$ACacheManager;
    //   57: aload_3
    //   58: invokestatic 167	com/boohee/food/cache/FileCache$ACacheManager:a	(Lcom/boohee/food/cache/FileCache$ACacheManager;Ljava/io/File;)V
    //   61: return
    //   62: astore 10
    //   64: aload 10
    //   66: invokevirtual 143	java/io/IOException:printStackTrace	()V
    //   69: goto -16 -> 53
    //   72: astore 6
    //   74: aconst_null
    //   75: astore 5
    //   77: aload 6
    //   79: invokevirtual 143	java/io/IOException:printStackTrace	()V
    //   82: aload 5
    //   84: ifnull +13 -> 97
    //   87: aload 5
    //   89: invokevirtual 163	java/io/BufferedWriter:flush	()V
    //   92: aload 5
    //   94: invokevirtual 164	java/io/BufferedWriter:close	()V
    //   97: aload_0
    //   98: getfield 57	com/boohee/food/cache/FileCache:b	Lcom/boohee/food/cache/FileCache$ACacheManager;
    //   101: aload_3
    //   102: invokestatic 167	com/boohee/food/cache/FileCache$ACacheManager:a	(Lcom/boohee/food/cache/FileCache$ACacheManager;Ljava/io/File;)V
    //   105: return
    //   106: astore 9
    //   108: aload 9
    //   110: invokevirtual 143	java/io/IOException:printStackTrace	()V
    //   113: goto -16 -> 97
    //   116: astore 7
    //   118: aload 4
    //   120: ifnull +13 -> 133
    //   123: aload 4
    //   125: invokevirtual 163	java/io/BufferedWriter:flush	()V
    //   128: aload 4
    //   130: invokevirtual 164	java/io/BufferedWriter:close	()V
    //   133: aload_0
    //   134: getfield 57	com/boohee/food/cache/FileCache:b	Lcom/boohee/food/cache/FileCache$ACacheManager;
    //   137: aload_3
    //   138: invokestatic 167	com/boohee/food/cache/FileCache$ACacheManager:a	(Lcom/boohee/food/cache/FileCache$ACacheManager;Ljava/io/File;)V
    //   141: aload 7
    //   143: athrow
    //   144: astore 8
    //   146: aload 8
    //   148: invokevirtual 143	java/io/IOException:printStackTrace	()V
    //   151: goto -18 -> 133
    //   154: astore 7
    //   156: aload 5
    //   158: astore 4
    //   160: goto -42 -> 118
    //   163: astore 6
    //   165: goto -88 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	this	FileCache
    //   0	168	1	paramString1	String
    //   0	168	2	paramString2	String
    //   8	130	3	localFile	File
    //   10	149	4	localObject1	Object
    //   30	127	5	localBufferedWriter	java.io.BufferedWriter
    //   72	6	6	localIOException1	java.io.IOException
    //   163	1	6	localIOException2	java.io.IOException
    //   116	26	7	localObject2	Object
    //   154	1	7	localObject3	Object
    //   144	3	8	localIOException3	java.io.IOException
    //   106	3	9	localIOException4	java.io.IOException
    //   62	3	10	localIOException5	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   43	53	62	java/io/IOException
    //   12	32	72	java/io/IOException
    //   87	97	106	java/io/IOException
    //   12	32	116	finally
    //   123	133	144	java/io/IOException
    //   32	38	154	finally
    //   77	82	154	finally
    //   32	38	163	java/io/IOException
  }
  
  public void a(String paramString, JSONObject paramJSONObject)
  {
    a(paramString, paramJSONObject.toString());
  }
  
  public JSONObject b(String paramString)
  {
    String str = a(paramString);
    try
    {
      JSONObject localJSONObject = new JSONObject(str);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public boolean c(String paramString)
  {
    return FileCache.ACacheManager.c(this.b, paramString);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.cache.FileCache
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */