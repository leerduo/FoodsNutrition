package com.umeng.analytics.onlineconfig;

import android.content.Context;
import org.json.JSONObject;
import u.aly.bj;
import u.aly.bo;

public class a$b
  extends bo
  implements Runnable
{
  Context a;
  
  public a$b(a parama, Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
  }
  
  private void b()
  {
    JSONObject localJSONObject = a.a(this.b, this.a);
    a.a locala = new a.a(this.b, localJSONObject);
    String[] arrayOfString = com.umeng.analytics.a.g;
    int i = 0;
    b localb = null;
    for (;;)
    {
      if (i < arrayOfString.length)
      {
        locala.a(arrayOfString[i]);
        localb = (b)a(locala, b.class);
        if (localb == null) {}
      }
      else
      {
        if (localb != null) {
          break;
        }
        a.a(this.b, null);
        return;
      }
      i++;
    }
    if (localb.b)
    {
      if (a.a(this.b) != null) {
        a.a(this.b).a(localb.c, localb.d);
      }
      a.a(this.b, this.a, localb);
      a.b(this.b, this.a, localb);
      a.a(this.b, localb.a);
      return;
    }
    a.a(this.b, null);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void run()
  {
    try
    {
      b();
      return;
    }
    catch (Exception localException)
    {
      a.a(this.b, null);
      bj.c("MobclickAgent", "reques update error", localException);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.umeng.analytics.onlineconfig.a.b
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */