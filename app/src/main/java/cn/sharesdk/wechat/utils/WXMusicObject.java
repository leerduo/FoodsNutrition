package cn.sharesdk.wechat.utils;

import android.os.Bundle;
import android.text.TextUtils;
import cn.sharesdk.framework.utils.e;

public class WXMusicObject
  implements WXMediaMessage.IMediaObject
{
  public String musicDataUrl;
  public String musicLowBandDataUrl;
  public String musicLowBandUrl;
  public String musicUrl;
  
  public boolean checkArgs()
  {
    if ((TextUtils.isEmpty(this.musicUrl)) && (TextUtils.isEmpty(this.musicLowBandUrl)))
    {
      e.c("both musicUrl and musicLowBandUrl are null", new Object[0]);
      return false;
    }
    if ((this.musicUrl != null) && (this.musicUrl.length() > 10240))
    {
      e.c("checkArgs fail, musicUrl is too long", new Object[0]);
      return false;
    }
    if ((this.musicLowBandUrl != null) && (this.musicLowBandUrl.length() > 10240))
    {
      e.c("checkArgs fail, musicLowBandUrl is too long", new Object[0]);
      return false;
    }
    return true;
  }
  
  public void serialize(Bundle paramBundle)
  {
    paramBundle.putString("_wxmusicobject_musicUrl", this.musicUrl);
    paramBundle.putString("_wxmusicobject_musicLowBandUrl", this.musicLowBandUrl);
    paramBundle.putString("_wxmusicobject_musicDataUrl", this.musicDataUrl);
    paramBundle.putString("_wxmusicobject_musicLowBandDataUrl", this.musicLowBandDataUrl);
  }
  
  public int type()
  {
    return 3;
  }
  
  public void unserialize(Bundle paramBundle)
  {
    this.musicUrl = paramBundle.getString("_wxmusicobject_musicUrl");
    this.musicLowBandUrl = paramBundle.getString("_wxmusicobject_musicLowBandUrl");
    this.musicDataUrl = paramBundle.getString("_wxmusicobject_musicDataUrl");
    this.musicLowBandDataUrl = paramBundle.getString("_wxmusicobject_musicLowBandDataUrl");
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.wechat.utils.WXMusicObject
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */