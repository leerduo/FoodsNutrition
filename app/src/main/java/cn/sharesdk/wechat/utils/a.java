package cn.sharesdk.wechat.utils;

import android.os.Bundle;
import cn.sharesdk.framework.utils.e;

public class a
  extends l
{
  public String a;
  public String b;
  
  public int a()
  {
    return 1;
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    paramBundle.putString("_wxapi_sendauth_req_scope", this.a);
    paramBundle.putString("_wxapi_sendauth_req_state", this.b);
  }
  
  public boolean b()
  {
    if ((this.a == null) || (this.a.length() == 0) || (this.a.length() > 1024))
    {
      e.c("MicroMsg.SDK.SendAuth.Req", new Object[] { "checkArgs fail, scope is invalid" });
      return false;
    }
    if ((this.b != null) && (this.b.length() > 1024))
    {
      e.c("MicroMsg.SDK.SendAuth.Req", new Object[] { "checkArgs fail, state is invalid" });
      return false;
    }
    return true;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.wechat.utils.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */