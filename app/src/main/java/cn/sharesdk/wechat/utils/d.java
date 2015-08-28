package cn.sharesdk.wechat.utils;

import android.os.Bundle;
import cn.sharesdk.framework.utils.e;

public class d
  extends l
{
  public WXMediaMessage a;
  public int b;
  
  public int a()
  {
    return 2;
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    paramBundle.putAll(WXMediaMessage.a.a(this.a));
    paramBundle.putInt("_wxapi_sendmessagetowx_req_scene", this.b);
  }
  
  public boolean b()
  {
    if ((this.a.getType() == 8) && ((this.a.thumbData == null) || (this.a.thumbData.length <= 0)))
    {
      e.c("checkArgs fail, thumbData should not be null when send emoji", new Object[0]);
      return false;
    }
    if ((this.a.thumbData != null) && (this.a.thumbData.length > 32768))
    {
      e.c("checkArgs fail, thumbData is invalid", new Object[0]);
      return false;
    }
    if ((this.a.title != null) && (this.a.title.length() > 512))
    {
      e.c("checkArgs fail, title is invalid", new Object[0]);
      return false;
    }
    if ((this.a.description != null) && (this.a.description.length() > 1024)) {
      this.a.description = (this.a.description.substring(0, 1021) + "...");
    }
    if (this.a.mediaObject == null)
    {
      e.c("checkArgs fail, mediaObject is null", new Object[0]);
      return false;
    }
    return this.a.mediaObject.checkArgs();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.wechat.utils.d
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */