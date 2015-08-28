package com.qiniu.android.http;

import java.util.Locale;

public final class ResponseInfo
{
  public static final int Cancelled = -2;
  public static final int InvalidArgument = -4;
  public static final int InvalidFile = -3;
  public static final int NetworkError = -1;
  public final double duration;
  public final String error;
  public final String host;
  public final String ip;
  public final String reqId;
  public final int statusCode;
  public final String xlog;
  public final String xvia;
  
  public ResponseInfo(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, double paramDouble, String paramString6)
  {
    this.statusCode = paramInt;
    this.reqId = paramString1;
    this.xlog = paramString2;
    this.xvia = paramString3;
    this.host = paramString4;
    this.duration = paramDouble;
    this.error = paramString6;
    this.ip = paramString5;
  }
  
  public static ResponseInfo cancelled()
  {
    return new ResponseInfo(-2, "", "", "", "", "", 0.0D, "cancelled by user");
  }
  
  public static ResponseInfo fileError(Exception paramException)
  {
    return new ResponseInfo(-3, "", "", "", "", "", 0.0D, paramException.getMessage());
  }
  
  public static ResponseInfo invalidArgument(String paramString)
  {
    return new ResponseInfo(-4, "", "", "", "", "", 0.0D, paramString);
  }
  
  public boolean isCancelled()
  {
    return this.statusCode == -2;
  }
  
  public boolean isNetworkBroken()
  {
    return this.statusCode == -1;
  }
  
  public boolean isOK()
  {
    return (this.statusCode == 200) && (this.error == null) && (this.reqId != null);
  }
  
  public boolean isServerError()
  {
    return ((this.statusCode >= 500) && (this.statusCode < 600) && (this.statusCode != 579)) || (this.statusCode == 996);
  }
  
  public boolean needRetry()
  {
    return (isNetworkBroken()) || (isServerError()) || (this.statusCode == 406) || ((this.statusCode == 200) && (this.error != null));
  }
  
  public boolean needSwitchServer()
  {
    return (isNetworkBroken()) || ((this.statusCode >= 500) && (this.statusCode < 600) && (this.statusCode != 579));
  }
  
  public String toString()
  {
    Locale localLocale = Locale.ENGLISH;
    Object[] arrayOfObject = new Object[9];
    arrayOfObject[0] = super.toString();
    arrayOfObject[1] = Integer.valueOf(this.statusCode);
    arrayOfObject[2] = this.reqId;
    arrayOfObject[3] = this.xlog;
    arrayOfObject[4] = this.xvia;
    arrayOfObject[5] = this.host;
    arrayOfObject[6] = this.ip;
    arrayOfObject[7] = Double.valueOf(this.duration);
    arrayOfObject[8] = this.error;
    return String.format(localLocale, "{ResponseInfo:%s,status:%d, reqId:%s, xlog:%s, xvia:%s,  host:%s, ip:%s, duration:%f s, error:%s}", arrayOfObject);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.qiniu.android.http.ResponseInfo
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */