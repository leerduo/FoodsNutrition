package cn.sharesdk.wechat.utils;

import android.os.Bundle;

public class f
  extends WechatResp
{
  public WXMediaMessage a;
  
  public f(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  public int a()
  {
    return 4;
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.a = WXMediaMessage.a.a(paramBundle);
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    paramBundle.putAll(WXMediaMessage.a.a(this.a));
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.wechat.utils.f
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */