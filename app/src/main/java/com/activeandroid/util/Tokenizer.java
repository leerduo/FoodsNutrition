package com.activeandroid.util;

import java.io.InputStream;

public class Tokenizer
{
  private final InputStream a;
  private boolean b;
  private int c;
  
  public Tokenizer(InputStream paramInputStream)
  {
    this.a = paramInputStream;
  }
  
  public boolean a()
  {
    if (!this.b)
    {
      this.b = true;
      this.c = this.a.read();
    }
    return this.c != -1;
  }
  
  public boolean a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    while (paramString.charAt(0) != this.c) {
      return false;
    }
    int i = paramString.length();
    this.a.mark(i - 1);
    for (int j = 1; j < i; j++) {
      if (this.a.read() != paramString.charAt(j))
      {
        this.a.reset();
        return false;
      }
    }
    return true;
  }
  
  public int b()
  {
    if (!this.b) {
      this.c = this.a.read();
    }
    this.b = false;
    return this.c;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.activeandroid.util.Tokenizer
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */