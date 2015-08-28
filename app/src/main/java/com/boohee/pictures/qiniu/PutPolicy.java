package com.boohee.pictures.qiniu;

import org.json.JSONStringer;

public class PutPolicy
{
  public String asyncOps;
  public String callbackBody;
  public String callbackUrl;
  public String endUser;
  public long expires;
  public String returnBody;
  public String returnUrl;
  public String scope;
  
  public PutPolicy(String paramString)
  {
    this.scope = paramString;
  }
  
  private String marshal()
  {
    JSONStringer localJSONStringer = new JSONStringer();
    localJSONStringer.object();
    localJSONStringer.key("scope").value(this.scope);
    if ((this.callbackUrl != null) && (this.callbackUrl.length() > 0)) {
      localJSONStringer.key("callbackUrl").value(this.callbackUrl);
    }
    if ((this.returnUrl != null) && (this.returnUrl.length() > 0)) {
      localJSONStringer.key("returnUrl").value(this.returnUrl);
    }
    if ((this.asyncOps != null) && (this.asyncOps.length() > 0)) {
      localJSONStringer.key("asyncOps").value(this.asyncOps);
    }
    if ((this.returnBody != null) && (this.returnBody.length() > 0)) {
      localJSONStringer.key("returnBody").value(this.returnBody);
    }
    localJSONStringer.key("deadline").value(this.expires);
    localJSONStringer.endObject();
    return localJSONStringer.toString();
  }
  
  private static String signWithData(Mac paramMac, byte[] paramArrayOfByte)
  {
    if (paramMac == null) {
      paramMac = new Mac(QiniuConfig.ACCESS_KEY, QiniuConfig.SECRET_KEY);
    }
    return paramMac.signWithData(paramArrayOfByte);
  }
  
  public String token(Mac paramMac)
  {
    if (this.expires == 0L) {
      this.expires = 3600L;
    }
    this.expires = (System.currentTimeMillis() / 1000L + this.expires);
    return signWithData(paramMac, marshal().getBytes());
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.pictures.qiniu.PutPolicy
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */