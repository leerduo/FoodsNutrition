package com.xiaomi.smack.util;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class a
  extends Reader
{
  Reader a = null;
  List b = new ArrayList();
  
  public a(Reader paramReader)
  {
    this.a = paramReader;
  }
  
  public void a(f paramf)
  {
    if (paramf == null) {
      return;
    }
    synchronized (this.b)
    {
      if (!this.b.contains(paramf)) {
        this.b.add(paramf);
      }
      return;
    }
  }
  
  public void b(f paramf)
  {
    synchronized (this.b)
    {
      this.b.remove(paramf);
      return;
    }
  }
  
  public void close()
  {
    this.a.close();
  }
  
  public void mark(int paramInt)
  {
    this.a.mark(paramInt);
  }
  
  public boolean markSupported()
  {
    return this.a.markSupported();
  }
  
  public int read()
  {
    return this.a.read();
  }
  
  public int read(char[] paramArrayOfChar)
  {
    return this.a.read(paramArrayOfChar);
  }
  
  public int read(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int i = this.a.read(paramArrayOfChar, paramInt1, paramInt2);
    if (i > 0)
    {
      String str = new String(paramArrayOfChar, paramInt1, i);
      synchronized (this.b)
      {
        f[] arrayOff = new f[this.b.size()];
        this.b.toArray(arrayOff);
        int j = 0;
        if (j < arrayOff.length)
        {
          arrayOff[j].a(str);
          j++;
        }
      }
    }
    return i;
  }
  
  public boolean ready()
  {
    return this.a.ready();
  }
  
  public void reset()
  {
    this.a.reset();
  }
  
  public long skip(long paramLong)
  {
    return this.a.skip(paramLong);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.smack.util.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */