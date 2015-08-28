package com.loopj.android.http;

import java.io.FilterOutputStream;
import java.io.OutputStream;

public class Base64OutputStream
  extends FilterOutputStream
{
  private static byte[] EMPTY = new byte[0];
  private int bpos = 0;
  private byte[] buffer = null;
  private final Base64.Coder coder;
  private final int flags;
  
  public Base64OutputStream(OutputStream paramOutputStream, int paramInt)
  {
    this(paramOutputStream, paramInt, true);
  }
  
  public Base64OutputStream(OutputStream paramOutputStream, int paramInt, boolean paramBoolean)
  {
    super(paramOutputStream);
    this.flags = paramInt;
    if (paramBoolean)
    {
      this.coder = new Base64.Encoder(paramInt, null);
      return;
    }
    this.coder = new Base64.Decoder(paramInt, null);
  }
  
  private byte[] embiggen(byte[] paramArrayOfByte, int paramInt)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < paramInt)) {
      paramArrayOfByte = new byte[paramInt];
    }
    return paramArrayOfByte;
  }
  
  private void flushBuffer()
  {
    if (this.bpos > 0)
    {
      internalWrite(this.buffer, 0, this.bpos, false);
      this.bpos = 0;
    }
  }
  
  private void internalWrite(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.coder.output = embiggen(this.coder.output, this.coder.maxOutputSize(paramInt2));
    if (!this.coder.process(paramArrayOfByte, paramInt1, paramInt2, paramBoolean)) {
      throw new Base64DataException("bad base-64");
    }
    this.out.write(this.coder.output, 0, this.coder.op);
  }
  
  /* Error */
  public void close()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: invokespecial 87	com/loopj/android/http/Base64OutputStream:flushBuffer	()V
    //   6: aload_0
    //   7: getstatic 16	com/loopj/android/http/Base64OutputStream:EMPTY	[B
    //   10: iconst_0
    //   11: iconst_0
    //   12: iconst_1
    //   13: invokespecial 47	com/loopj/android/http/Base64OutputStream:internalWrite	([BIIZ)V
    //   16: bipush 16
    //   18: aload_0
    //   19: getfield 30	com/loopj/android/http/Base64OutputStream:flags	I
    //   22: iand
    //   23: ifne +24 -> 47
    //   26: aload_0
    //   27: getfield 73	com/loopj/android/http/Base64OutputStream:out	Ljava/io/OutputStream;
    //   30: invokevirtual 89	java/io/OutputStream:close	()V
    //   33: aload_1
    //   34: astore_3
    //   35: aload_3
    //   36: ifnull +31 -> 67
    //   39: aload_3
    //   40: athrow
    //   41: astore_2
    //   42: aload_2
    //   43: astore_1
    //   44: goto -28 -> 16
    //   47: aload_0
    //   48: getfield 73	com/loopj/android/http/Base64OutputStream:out	Ljava/io/OutputStream;
    //   51: invokevirtual 92	java/io/OutputStream:flush	()V
    //   54: goto -21 -> 33
    //   57: astore_3
    //   58: aload_1
    //   59: ifnonnull -24 -> 35
    //   62: aload_1
    //   63: astore_3
    //   64: goto -29 -> 35
    //   67: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	Base64OutputStream
    //   1	62	1	localObject1	java.lang.Object
    //   41	2	2	localIOException1	java.io.IOException
    //   34	6	3	localObject2	java.lang.Object
    //   57	1	3	localIOException2	java.io.IOException
    //   63	1	3	localObject3	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   2	16	41	java/io/IOException
    //   16	33	57	java/io/IOException
    //   47	54	57	java/io/IOException
  }
  
  public void write(int paramInt)
  {
    if (this.buffer == null) {
      this.buffer = new byte[1024];
    }
    if (this.bpos >= this.buffer.length)
    {
      internalWrite(this.buffer, 0, this.bpos, false);
      this.bpos = 0;
    }
    byte[] arrayOfByte = this.buffer;
    int i = this.bpos;
    this.bpos = (i + 1);
    arrayOfByte[i] = ((byte)paramInt);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 <= 0) {
      return;
    }
    flushBuffer();
    internalWrite(paramArrayOfByte, paramInt1, paramInt2, false);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.loopj.android.http.Base64OutputStream
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */