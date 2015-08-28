package com.xiaomi.smack;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.smack.packet.d;
import com.xiaomi.smack.util.c;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

class o
{
  private Thread a;
  private t b;
  private XmlPullParser c;
  private boolean d;
  
  protected o(t paramt)
  {
    this.b = paramt;
    a();
  }
  
  private void a(d paramd)
  {
    if (paramd == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.b.f.values().iterator();
      while (localIterator.hasNext()) {
        ((j.a)localIterator.next()).a(paramd);
      }
    }
  }
  
  private void e()
  {
    this.c = XmlPullParserFactory.newInstance().newPullParser();
    this.c.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
    this.c.setInput(this.b.i);
  }
  
  private void f()
  {
    int i;
    Object localObject;
    String str1;
    for (;;)
    {
      try
      {
        e();
        i = this.c.getEventType();
        localObject = "";
        this.b.p();
        if (i != 2) {
          break label486;
        }
        str1 = this.c.getName();
        if (!this.c.getName().equals("message")) {
          break label160;
        }
        a(c.a(this.c));
        localObject = str1;
        i = this.c.next();
        if ((!this.d) && (i != 1)) {
          continue;
        }
        if (i != 1) {
          break label159;
        }
        throw new Exception("SMACK: server close the connection or timeout happened, last element name=" + (String)localObject + " host=" + this.b.e());
      }
      catch (Exception localException)
      {
        b.a(localException);
        if (this.d) {
          break label518;
        }
      }
      a(9, localException);
      label159:
      return;
      label160:
      if (this.c.getName().equals("iq"))
      {
        a(c.a(this.c, this.b));
        localObject = str1;
      }
      else
      {
        if (!this.c.getName().equals("presence")) {
          break;
        }
        a(c.b(this.c));
        localObject = str1;
      }
    }
    String str2;
    if (this.c.getName().equals("stream")) {
      str2 = "";
    }
    for (int j = 0;; j++) {
      if (j < this.c.getAttributeCount())
      {
        if (this.c.getAttributeName(j).equals("from")) {
          this.b.m.a(this.c.getAttributeValue(j));
        } else if (this.c.getAttributeName(j).equals("challenge")) {
          str2 = this.c.getAttributeValue(j);
        }
      }
      else
      {
        this.b.a(str2);
        localObject = str1;
        break;
        if (this.c.getName().equals("error")) {
          throw new w(c.d(this.c));
        }
        if (this.c.getName().equals("warning"))
        {
          this.c.next();
          if (!this.c.getName().equals("multi-login")) {
            break label524;
          }
          a(6, null);
          localObject = str1;
          break;
        }
        if (this.c.getName().equals("bind"))
        {
          a(c.c(this.c));
          localObject = str1;
          break;
          label486:
          if ((i != 3) || (!this.c.getName().equals("stream"))) {
            break;
          }
          a(13, null);
          break;
          label518:
          b.b("reader is shutdown, ignore the exception.");
          return;
        }
        label524:
        localObject = str1;
        break;
      }
    }
  }
  
  protected void a()
  {
    this.d = false;
    this.a = new p(this, "Smack Packet Reader (" + this.b.l + ")");
  }
  
  void a(int paramInt, Exception paramException)
  {
    this.d = true;
    this.b.a(paramInt, paramException);
  }
  
  public void b()
  {
    this.a.start();
  }
  
  public void c()
  {
    this.d = true;
  }
  
  void d()
  {
    this.b.f.clear();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.smack.o
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */