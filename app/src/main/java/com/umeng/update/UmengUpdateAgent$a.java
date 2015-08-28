package com.umeng.update;

import android.content.Context;

class UmengUpdateAgent$a
  implements Runnable
{
  Context a;
  
  public UmengUpdateAgent$a(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public void run()
  {
    try
    {
      localUpdateResponse = new b(this.a).b();
      if (localUpdateResponse == null)
      {
        UmengUpdateAgent.a(3, null);
        return;
      }
      if (!localUpdateResponse.hasUpdate)
      {
        UmengUpdateAgent.a(1, localUpdateResponse);
        return;
      }
    }
    catch (Exception localException)
    {
      UpdateResponse localUpdateResponse;
      UmengUpdateAgent.a(1, null);
      u.upd.b.a("update", "request update error", localException);
      return;
      UmengUpdateAgent.a(0, localUpdateResponse);
      return;
    }
    catch (Error localError)
    {
      u.upd.b.a("update", "request update error" + localError.getMessage());
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.umeng.update.UmengUpdateAgent.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */