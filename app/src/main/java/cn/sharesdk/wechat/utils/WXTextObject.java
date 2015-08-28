package cn.sharesdk.wechat.utils;

import android.os.Bundle;
import cn.sharesdk.framework.utils.e;

public class WXTextObject
  implements WXMediaMessage.IMediaObject
{
  public String text;
  
  public WXTextObject()
  {
    this(null);
  }
  
  public WXTextObject(String paramString)
  {
    this.text = paramString;
  }
  
  public boolean checkArgs()
  {
    if ((this.text == null) || (this.text.length() == 0) || (this.text.length() > 10240))
    {
      e.c("checkArgs fail, text is invalid", new Object[0]);
      return false;
    }
    return true;
  }
  
  public void serialize(Bundle paramBundle)
  {
    paramBundle.putString("_wxtextobject_text", this.text);
  }
  
  public int type()
  {
    return 1;
  }
  
  public void unserialize(Bundle paramBundle)
  {
    this.text = paramBundle.getString("_wxtextobject_text");
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.wechat.utils.WXTextObject
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */