package cn.sharesdk.wechat.utils;

import android.os.Bundle;

public abstract class l
{
  public String c;
  
  public abstract int a();
  
  public void a(Bundle paramBundle)
  {
    paramBundle.putInt("_wxapi_command_type", a());
    paramBundle.putString("_wxapi_basereq_transaction", this.c);
  }
  
  public abstract boolean b();
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.wechat.utils.l
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */