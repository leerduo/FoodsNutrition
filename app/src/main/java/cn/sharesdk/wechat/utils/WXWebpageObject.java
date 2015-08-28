package cn.sharesdk.wechat.utils;

import android.os.Bundle;
import cn.sharesdk.framework.utils.e;

public class WXWebpageObject
  implements WXMediaMessage.IMediaObject
{
  public String webpageUrl;
  
  public WXWebpageObject() {}
  
  public WXWebpageObject(String paramString)
  {
    this.webpageUrl = paramString;
  }
  
  public boolean checkArgs()
  {
    if ((this.webpageUrl == null) || (this.webpageUrl.length() == 0) || (this.webpageUrl.length() > 10240))
    {
      e.c("checkArgs fail, webpageUrl is invalid", new Object[0]);
      return false;
    }
    return true;
  }
  
  public void serialize(Bundle paramBundle)
  {
    paramBundle.putString("_wxwebpageobject_webpageUrl", this.webpageUrl);
  }
  
  public int type()
  {
    return 5;
  }
  
  public void unserialize(Bundle paramBundle)
  {
    this.webpageUrl = paramBundle.getString("_wxwebpageobject_webpageUrl");
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.wechat.utils.WXWebpageObject
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */