package com.boohee.food.util;

public class AssetUtils
{
  /* Error */
  public static java.lang.String a(android.content.Context paramContext, java.lang.String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: ifnonnull +5 -> 8
    //   6: aload_2
    //   7: areturn
    //   8: aload_0
    //   9: invokevirtual 14	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   12: aload_1
    //   13: invokevirtual 20	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   16: astore 9
    //   18: aload 9
    //   20: astore 4
    //   22: aload 4
    //   24: invokevirtual 26	java/io/InputStream:available	()I
    //   27: newarray byte
    //   29: astore 10
    //   31: aload 4
    //   33: aload 10
    //   35: invokevirtual 30	java/io/InputStream:read	([B)I
    //   38: pop
    //   39: aload 10
    //   41: ldc 32
    //   43: invokestatic 38	org/apache/http/util/EncodingUtils:getString	([BLjava/lang/String;)Ljava/lang/String;
    //   46: astore 12
    //   48: aload 12
    //   50: astore_2
    //   51: aload 4
    //   53: ifnull -47 -> 6
    //   56: aload 4
    //   58: invokevirtual 42	java/io/InputStream:close	()V
    //   61: aload_2
    //   62: areturn
    //   63: astore 13
    //   65: aload 13
    //   67: invokevirtual 45	java/io/IOException:printStackTrace	()V
    //   70: aload_2
    //   71: areturn
    //   72: astore 7
    //   74: aconst_null
    //   75: astore 4
    //   77: aload 7
    //   79: invokevirtual 45	java/io/IOException:printStackTrace	()V
    //   82: aconst_null
    //   83: astore_2
    //   84: aload 4
    //   86: ifnull -80 -> 6
    //   89: aload 4
    //   91: invokevirtual 42	java/io/InputStream:close	()V
    //   94: aconst_null
    //   95: areturn
    //   96: astore 8
    //   98: aload 8
    //   100: invokevirtual 45	java/io/IOException:printStackTrace	()V
    //   103: aconst_null
    //   104: areturn
    //   105: astore_3
    //   106: aconst_null
    //   107: astore 4
    //   109: aload_3
    //   110: astore 5
    //   112: aload 4
    //   114: ifnull +8 -> 122
    //   117: aload 4
    //   119: invokevirtual 42	java/io/InputStream:close	()V
    //   122: aload 5
    //   124: athrow
    //   125: astore 6
    //   127: aload 6
    //   129: invokevirtual 45	java/io/IOException:printStackTrace	()V
    //   132: goto -10 -> 122
    //   135: astore 5
    //   137: goto -25 -> 112
    //   140: astore 7
    //   142: goto -65 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	paramContext	android.content.Context
    //   0	145	1	paramString	java.lang.String
    //   1	83	2	localObject1	Object
    //   105	5	3	localObject2	Object
    //   20	98	4	localInputStream1	java.io.InputStream
    //   110	13	5	localObject3	Object
    //   135	1	5	localObject4	Object
    //   125	3	6	localIOException1	java.io.IOException
    //   72	6	7	localIOException2	java.io.IOException
    //   140	1	7	localIOException3	java.io.IOException
    //   96	3	8	localIOException4	java.io.IOException
    //   16	3	9	localInputStream2	java.io.InputStream
    //   29	11	10	arrayOfByte	byte[]
    //   46	3	12	str	java.lang.String
    //   63	3	13	localIOException5	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   56	61	63	java/io/IOException
    //   8	18	72	java/io/IOException
    //   89	94	96	java/io/IOException
    //   8	18	105	finally
    //   117	122	125	java/io/IOException
    //   22	48	135	finally
    //   77	82	135	finally
    //   22	48	140	java/io/IOException
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.util.AssetUtils
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */