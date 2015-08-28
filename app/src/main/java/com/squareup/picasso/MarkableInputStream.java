package com.squareup.picasso;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

final class MarkableInputStream
  extends InputStream
{
  private final InputStream a;
  private long b;
  private long c;
  private long d;
  private long e = -1L;
  
  public MarkableInputStream(InputStream paramInputStream)
  {
    this(paramInputStream, 4096);
  }
  
  public MarkableInputStream(InputStream paramInputStream, int paramInt)
  {
    if (!paramInputStream.markSupported()) {
      paramInputStream = new BufferedInputStream(paramInputStream, paramInt);
    }
    this.a = paramInputStream;
  }
  
  private void a(long paramLong1, long paramLong2)
  {
    for (;;)
    {
      if (paramLong1 < paramLong2)
      {
        l = this.a.skip(paramLong2 - paramLong1);
        if (l != 0L) {
          break label37;
        }
        if (read() != -1) {}
      }
      else
      {
        return;
      }
      long l = 1L;
      label37:
      paramLong1 += l;
    }
  }
  
  /* Error */
  private void b(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 46	com/squareup/picasso/MarkableInputStream:c	J
    //   4: aload_0
    //   5: getfield 48	com/squareup/picasso/MarkableInputStream:b	J
    //   8: lcmp
    //   9: ifge +54 -> 63
    //   12: aload_0
    //   13: getfield 48	com/squareup/picasso/MarkableInputStream:b	J
    //   16: aload_0
    //   17: getfield 50	com/squareup/picasso/MarkableInputStream:d	J
    //   20: lcmp
    //   21: ifgt +42 -> 63
    //   24: aload_0
    //   25: getfield 32	com/squareup/picasso/MarkableInputStream:a	Ljava/io/InputStream;
    //   28: invokevirtual 53	java/io/InputStream:reset	()V
    //   31: aload_0
    //   32: getfield 32	com/squareup/picasso/MarkableInputStream:a	Ljava/io/InputStream;
    //   35: lload_1
    //   36: aload_0
    //   37: getfield 46	com/squareup/picasso/MarkableInputStream:c	J
    //   40: lsub
    //   41: l2i
    //   42: invokevirtual 57	java/io/InputStream:mark	(I)V
    //   45: aload_0
    //   46: aload_0
    //   47: getfield 46	com/squareup/picasso/MarkableInputStream:c	J
    //   50: aload_0
    //   51: getfield 48	com/squareup/picasso/MarkableInputStream:b	J
    //   54: invokespecial 59	com/squareup/picasso/MarkableInputStream:a	(JJ)V
    //   57: aload_0
    //   58: lload_1
    //   59: putfield 50	com/squareup/picasso/MarkableInputStream:d	J
    //   62: return
    //   63: aload_0
    //   64: aload_0
    //   65: getfield 48	com/squareup/picasso/MarkableInputStream:b	J
    //   68: putfield 46	com/squareup/picasso/MarkableInputStream:c	J
    //   71: aload_0
    //   72: getfield 32	com/squareup/picasso/MarkableInputStream:a	Ljava/io/InputStream;
    //   75: lload_1
    //   76: aload_0
    //   77: getfield 48	com/squareup/picasso/MarkableInputStream:b	J
    //   80: lsub
    //   81: l2i
    //   82: invokevirtual 57	java/io/InputStream:mark	(I)V
    //   85: goto -28 -> 57
    //   88: astore_3
    //   89: new 61	java/lang/IllegalStateException
    //   92: dup
    //   93: new 63	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   100: ldc 66
    //   102: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload_3
    //   106: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokespecial 80	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   115: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	this	MarkableInputStream
    //   0	116	1	paramLong	long
    //   88	18	3	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   0	57	88	java/io/IOException
    //   57	62	88	java/io/IOException
    //   63	85	88	java/io/IOException
  }
  
  public long a(int paramInt)
  {
    long l = this.b + paramInt;
    if (this.d < l) {
      b(l);
    }
    return this.b;
  }
  
  public void a(long paramLong)
  {
    if ((this.b > this.d) || (paramLong < this.c)) {
      throw new IOException("Cannot reset");
    }
    this.a.reset();
    a(this.c, paramLong);
    this.b = paramLong;
  }
  
  public int available()
  {
    return this.a.available();
  }
  
  public void close()
  {
    this.a.close();
  }
  
  public void mark(int paramInt)
  {
    this.e = a(paramInt);
  }
  
  public boolean markSupported()
  {
    return this.a.markSupported();
  }
  
  public int read()
  {
    int i = this.a.read();
    if (i != -1) {
      this.b = (1L + this.b);
    }
    return i;
  }
  
  public int read(byte[] paramArrayOfByte)
  {
    int i = this.a.read(paramArrayOfByte);
    if (i != -1) {
      this.b += i;
    }
    return i;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = this.a.read(paramArrayOfByte, paramInt1, paramInt2);
    if (i != -1) {
      this.b += i;
    }
    return i;
  }
  
  public void reset()
  {
    a(this.e);
  }
  
  public long skip(long paramLong)
  {
    long l = this.a.skip(paramLong);
    this.b = (l + this.b);
    return l;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.squareup.picasso.MarkableInputStream
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */