package cn.sharesdk.wechat.utils;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import cn.sharesdk.framework.utils.e;
import java.io.ByteArrayOutputStream;

public final class WXMediaMessage
{
  public static final String ACTION_WXAPPMESSAGE = "com.tencent.mm.sdk.openapi.Intent.ACTION_WXAPPMESSAGE";
  public String description;
  public WXMediaMessage.IMediaObject mediaObject;
  public int sdkVer;
  public byte[] thumbData;
  public String title;
  
  public WXMediaMessage()
  {
    this(null);
  }
  
  public WXMediaMessage(WXMediaMessage.IMediaObject paramIMediaObject)
  {
    this.mediaObject = paramIMediaObject;
  }
  
  public final int getType()
  {
    if (this.mediaObject == null) {
      return 0;
    }
    return this.mediaObject.type();
  }
  
  public final void setThumbImage(Bitmap paramBitmap)
  {
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, 85, localByteArrayOutputStream);
      this.thumbData = localByteArrayOutputStream.toByteArray();
      localByteArrayOutputStream.close();
      return;
    }
    catch (Exception localException)
    {
      e.c(localException);
      e.c("put thumb failed", new Object[0]);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.wechat.utils.WXMediaMessage
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */