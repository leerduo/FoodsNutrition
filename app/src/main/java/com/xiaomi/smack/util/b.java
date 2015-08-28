package com.xiaomi.smack.util;

import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class b
  extends Writer
{
  Writer a = null;
  List b = new ArrayList();
  
  public b(Writer paramWriter)
  {
    this.a = paramWriter;
  }
  
  private void a(String paramString)
  {
    synchronized (this.b)
    {
      j[] arrayOfj = new j[this.b.size()];
      this.b.toArray(arrayOfj);
      int i = 0;
      if (i < arrayOfj.length)
      {
        arrayOfj[i].a(paramString);
        i++;
      }
    }
  }
  
  public void a(j paramj)
  {
    if (paramj == null) {
      return;
    }
    synchronized (this.b)
    {
      if (!this.b.contains(paramj)) {
        this.b.add(paramj);
      }
      return;
    }
  }
  
  public void b(j paramj)
  {
    synchronized (this.b)
    {
      this.b.remove(paramj);
      return;
    }
  }
  
  public void close()
  {
    this.a.close();
  }
  
  public void flush()
  {
    this.a.flush();
  }
  
  public void write(int paramInt)
  {
    this.a.write(paramInt);
  }
  
  public void write(String paramString)
  {
    this.a.write(paramString);
    a(paramString);
  }
  
  public void write(String paramString, int paramInt1, int paramInt2)
  {
    this.a.write(paramString, paramInt1, paramInt2);
    a(paramString.substring(paramInt1, paramInt1 + paramInt2));
  }
  
  public void write(char[] paramArrayOfChar)
  {
    this.a.write(paramArrayOfChar);
    a(new String(paramArrayOfChar));
  }
  
  public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    this.a.write(paramArrayOfChar, paramInt1, paramInt2);
    a(new String(paramArrayOfChar, paramInt1, paramInt2));
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.smack.util.b
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */