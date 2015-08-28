package com.qiniu.android.utils;

import java.util.zip.CRC32;

public final class Crc32
{
  public static long bytes(byte[] paramArrayOfByte)
  {
    return bytes(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static long bytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    CRC32 localCRC32 = new CRC32();
    localCRC32.update(paramArrayOfByte, paramInt1, paramInt2);
    return localCRC32.getValue();
  }
  
  /* Error */
  public static long file(java.io.File paramFile)
  {
    // Byte code:
    //   0: new 30	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 33	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: astore_1
    //   9: ldc 34
    //   11: newarray byte
    //   13: astore_2
    //   14: new 15	java/util/zip/CRC32
    //   17: dup
    //   18: invokespecial 16	java/util/zip/CRC32:<init>	()V
    //   21: astore_3
    //   22: aload_1
    //   23: aload_2
    //   24: invokevirtual 38	java/io/FileInputStream:read	([B)I
    //   27: istore 6
    //   29: iload 6
    //   31: iconst_m1
    //   32: if_icmpeq +30 -> 62
    //   35: aload_3
    //   36: aload_2
    //   37: iconst_0
    //   38: iload 6
    //   40: invokevirtual 20	java/util/zip/CRC32:update	([BII)V
    //   43: goto -21 -> 22
    //   46: astore 5
    //   48: aload 5
    //   50: invokevirtual 41	java/lang/Exception:printStackTrace	()V
    //   53: aload_1
    //   54: invokevirtual 44	java/io/FileInputStream:close	()V
    //   57: aload_3
    //   58: invokevirtual 24	java/util/zip/CRC32:getValue	()J
    //   61: lreturn
    //   62: aload_1
    //   63: invokevirtual 44	java/io/FileInputStream:close	()V
    //   66: goto -9 -> 57
    //   69: astore 4
    //   71: aload_1
    //   72: invokevirtual 44	java/io/FileInputStream:close	()V
    //   75: aload 4
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	paramFile	java.io.File
    //   8	64	1	localFileInputStream	java.io.FileInputStream
    //   13	24	2	arrayOfByte	byte[]
    //   21	37	3	localCRC32	CRC32
    //   69	7	4	localObject	Object
    //   46	3	5	localException	java.lang.Exception
    //   27	12	6	i	int
    // Exception table:
    //   from	to	target	type
    //   22	29	46	java/lang/Exception
    //   35	43	46	java/lang/Exception
    //   22	29	69	finally
    //   35	43	69	finally
    //   48	53	69	finally
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.qiniu.android.utils.Crc32
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */