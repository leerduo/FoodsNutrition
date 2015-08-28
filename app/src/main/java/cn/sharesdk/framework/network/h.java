package cn.sharesdk.framework.network;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class h
  extends InputStream
{
  private ArrayList<InputStream> a = new ArrayList();
  private int b;
  
  private boolean a()
  {
    return (this.a == null) || (this.a.size() <= 0);
  }
  
  public void a(InputStream paramInputStream)
  {
    this.a.add(paramInputStream);
  }
  
  public int available()
  {
    if (a()) {
      return 0;
    }
    return ((InputStream)this.a.get(this.b)).available();
  }
  
  public void close()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((InputStream)localIterator.next()).close();
    }
  }
  
  public int read()
  {
    int i;
    if (a()) {
      i = -1;
    }
    label76:
    for (;;)
    {
      return i;
      for (i = ((InputStream)this.a.get(this.b)).read();; i = ((InputStream)this.a.get(this.b)).read())
      {
        if (i >= 0) {
          break label76;
        }
        this.b = (1 + this.b);
        if (this.b >= this.a.size()) {
          break;
        }
      }
    }
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i;
    if (a()) {
      i = -1;
    }
    label87:
    for (;;)
    {
      return i;
      for (i = ((InputStream)this.a.get(this.b)).read(paramArrayOfByte, paramInt1, paramInt2);; i = ((InputStream)this.a.get(this.b)).read(paramArrayOfByte, paramInt1, paramInt2))
      {
        if (i >= 0) {
          break label87;
        }
        this.b = (1 + this.b);
        if (this.b >= this.a.size()) {
          break;
        }
      }
    }
  }
  
  public long skip(long paramLong)
  {
    throw new IOException();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.framework.network.h
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */