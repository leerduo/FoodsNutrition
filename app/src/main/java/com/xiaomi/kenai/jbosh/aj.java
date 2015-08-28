package com.xiaomi.kenai.jbosh;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPInputStream;

final class aj
{
  /* Error */
  public static byte[] a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 10	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 14	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_1
    //   8: new 16	java/util/zip/GZIPOutputStream
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 19	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   16: astore_2
    //   17: aload_2
    //   18: aload_0
    //   19: invokevirtual 23	java/util/zip/GZIPOutputStream:write	([B)V
    //   22: aload_2
    //   23: invokevirtual 26	java/util/zip/GZIPOutputStream:close	()V
    //   26: aload_1
    //   27: invokevirtual 27	java/io/ByteArrayOutputStream:close	()V
    //   30: aload_1
    //   31: invokevirtual 31	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   34: astore 5
    //   36: aload_2
    //   37: invokevirtual 26	java/util/zip/GZIPOutputStream:close	()V
    //   40: aload_1
    //   41: invokevirtual 27	java/io/ByteArrayOutputStream:close	()V
    //   44: aload 5
    //   46: areturn
    //   47: astore_3
    //   48: aconst_null
    //   49: astore_2
    //   50: aload_2
    //   51: invokevirtual 26	java/util/zip/GZIPOutputStream:close	()V
    //   54: aload_1
    //   55: invokevirtual 27	java/io/ByteArrayOutputStream:close	()V
    //   58: aload_3
    //   59: athrow
    //   60: astore 4
    //   62: goto -4 -> 58
    //   65: astore_3
    //   66: goto -16 -> 50
    //   69: astore 6
    //   71: aload 5
    //   73: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	paramArrayOfByte	byte[]
    //   7	48	1	localByteArrayOutputStream	ByteArrayOutputStream
    //   16	35	2	localGZIPOutputStream	java.util.zip.GZIPOutputStream
    //   47	12	3	localObject1	Object
    //   65	1	3	localObject2	Object
    //   60	1	4	localIOException1	java.io.IOException
    //   34	38	5	arrayOfByte	byte[]
    //   69	1	6	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   8	17	47	finally
    //   50	58	60	java/io/IOException
    //   17	36	65	finally
    //   36	44	69	java/io/IOException
  }
  
  public static byte[] b(byte[] paramArrayOfByte)
  {
    ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(paramArrayOfByte);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      localGZIPInputStream = new GZIPInputStream(localByteArrayInputStream);
      byte[] arrayOfByte1;
      int i;
      byte[] arrayOfByte2;
      if (localGZIPInputStream == null) {
        break label93;
      }
    }
    finally
    {
      try
      {
        arrayOfByte1 = new byte[512];
        do
        {
          i = localGZIPInputStream.read(arrayOfByte1);
          if (i > 0) {
            localByteArrayOutputStream.write(arrayOfByte1, 0, i);
          }
        } while (i >= 0);
        arrayOfByte2 = localByteArrayOutputStream.toByteArray();
        if (localGZIPInputStream != null) {
          localGZIPInputStream.close();
        }
        localByteArrayOutputStream.close();
        return arrayOfByte2;
      }
      finally
      {
        GZIPInputStream localGZIPInputStream;
        break label85;
      }
      localObject1 = finally;
      localGZIPInputStream = null;
    }
    label85:
    localGZIPInputStream.close();
    label93:
    localByteArrayOutputStream.close();
    throw localObject1;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.kenai.jbosh.aj
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */