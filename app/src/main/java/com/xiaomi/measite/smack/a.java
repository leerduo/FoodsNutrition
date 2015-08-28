package com.xiaomi.measite.smack;

import com.xiaomi.smack.l;
import com.xiaomi.smack.n;
import com.xiaomi.smack.util.f;
import java.io.Reader;
import java.io.Writer;
import java.text.SimpleDateFormat;

public class a
  implements com.xiaomi.smack.debugger.a
{
  public static boolean a = false;
  private SimpleDateFormat b = new SimpleDateFormat("hh:mm:ss aaa");
  private com.xiaomi.smack.j c = null;
  private n d = null;
  private l e = null;
  private Writer f;
  private Reader g;
  private f h;
  private com.xiaomi.smack.util.j i;
  
  public a(com.xiaomi.smack.j paramj, Writer paramWriter, Reader paramReader)
  {
    this.c = paramj;
    this.f = paramWriter;
    this.g = paramReader;
    e();
  }
  
  private void e()
  {
    com.xiaomi.smack.util.a locala = new com.xiaomi.smack.util.a(this.g);
    this.h = new b(this);
    locala.a(this.h);
    com.xiaomi.smack.util.b localb = new com.xiaomi.smack.util.b(this.f);
    this.i = new c(this);
    localb.a(this.i);
    this.g = locala;
    this.f = localb;
    this.d = new d(this);
    this.e = new e(this);
  }
  
  public Reader a()
  {
    return this.g;
  }
  
  public Reader a(Reader paramReader)
  {
    ((com.xiaomi.smack.util.a)this.g).b(this.h);
    com.xiaomi.smack.util.a locala = new com.xiaomi.smack.util.a(paramReader);
    locala.a(this.h);
    this.g = locala;
    return this.g;
  }
  
  public Writer a(Writer paramWriter)
  {
    ((com.xiaomi.smack.util.b)this.f).b(this.i);
    com.xiaomi.smack.util.b localb = new com.xiaomi.smack.util.b(paramWriter);
    localb.a(this.i);
    this.f = localb;
    return this.f;
  }
  
  public Writer b()
  {
    return this.f;
  }
  
  public n c()
  {
    return this.d;
  }
  
  public n d()
  {
    return null;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.measite.smack.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */