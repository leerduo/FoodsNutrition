package com.umeng.analytics.social;

import android.text.TextUtils;

public class UMPlatformData
{
  private UMPlatformData.UMedia a;
  private String b = "";
  private String c = "";
  private String d;
  private UMPlatformData.GENDER e;
  
  public UMPlatformData(UMPlatformData.UMedia paramUMedia, String paramString)
  {
    if ((paramUMedia == null) || (TextUtils.isEmpty(paramString)))
    {
      b.b("MobclickAgent", "parameter is not valid");
      return;
    }
    this.a = paramUMedia;
    this.b = paramString;
  }
  
  public UMPlatformData.GENDER getGender()
  {
    return this.e;
  }
  
  public UMPlatformData.UMedia getMeida()
  {
    return this.a;
  }
  
  public String getName()
  {
    return this.d;
  }
  
  public String getUsid()
  {
    return this.b;
  }
  
  public String getWeiboId()
  {
    return this.c;
  }
  
  public boolean isValid()
  {
    return (this.a != null) && (!TextUtils.isEmpty(this.b));
  }
  
  public void setGender(UMPlatformData.GENDER paramGENDER)
  {
    this.e = paramGENDER;
  }
  
  public void setName(String paramString)
  {
    this.d = paramString;
  }
  
  public void setWeiboId(String paramString)
  {
    this.c = paramString;
  }
  
  public String toString()
  {
    return "UMPlatformData [meida=" + this.a + ", usid=" + this.b + ", weiboId=" + this.c + ", name=" + this.d + ", gender=" + this.e + "]";
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.umeng.analytics.social.UMPlatformData
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */