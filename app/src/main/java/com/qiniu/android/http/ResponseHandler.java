package com.qiniu.android.http;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.qiniu.android.utils.Dns;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

public final class ResponseHandler
  extends AsyncHttpResponseHandler
{
  private CompletionHandler completionHandler;
  private String host;
  private String ip;
  private ProgressHandler progressHandler;
  private long reqStartTime;
  
  public ResponseHandler(String paramString, CompletionHandler paramCompletionHandler, ProgressHandler paramProgressHandler)
  {
    super(Looper.getMainLooper());
    try
    {
      this.host = new URI(paramString).getHost();
      this.completionHandler = paramCompletionHandler;
      this.progressHandler = paramProgressHandler;
      return;
    }
    catch (URISyntaxException localURISyntaxException)
    {
      for (;;)
      {
        this.host = "N/A";
        localURISyntaxException.printStackTrace();
      }
    }
  }
  
  private static JSONObject buildJsonResp(byte[] paramArrayOfByte)
  {
    return new JSONObject(new String(paramArrayOfByte, "utf-8"));
  }
  
  private static ResponseInfo buildResponseInfo(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfByte, String paramString, double paramDouble, Throwable paramThrowable)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    Object localObject3 = null;
    if (paramArrayOfHeader != null)
    {
      int j = paramArrayOfHeader.length;
      String str4 = null;
      String str5 = null;
      int k = 0;
      String str6 = null;
      if (k < j)
      {
        Header localHeader = paramArrayOfHeader[k];
        if ("X-Reqid".equals(localHeader.getName())) {
          str5 = localHeader.getValue();
        }
        for (;;)
        {
          k++;
          break;
          if ("X-Log".equals(localHeader.getName())) {
            str4 = localHeader.getValue();
          } else if ("X-Via".equals(localHeader.getName())) {
            str6 = localHeader.getValue();
          } else if ("X-Px".equals(localHeader.getName())) {
            str6 = localHeader.getValue();
          } else if ("Fw-Via".equals(localHeader.getName())) {
            str6 = localHeader.getValue();
          }
        }
      }
      localObject3 = str6;
      localObject2 = str4;
      localObject1 = str5;
    }
    if (paramInt != 200) {
      if (paramArrayOfByte == null) {}
    }
    for (;;)
    {
      try
      {
        str2 = new String(paramArrayOfByte, "utf-8");
        String str3;
        localUnsupportedEncodingException1.printStackTrace();
      }
      catch (JSONException localJSONException1)
      {
        try
        {
          str3 = new JSONObject(str2).optString("error", str2);
          localObject4 = str3;
          if (paramInt != 0) {
            break;
          }
          i = -1;
          return new ResponseInfo(i, localObject1, localObject2, localObject3, paramString, null, paramDouble, (String)localObject4);
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException2)
        {
          String str2;
          break label288;
        }
        catch (JSONException localJSONException2)
        {
          String str1;
          continue;
          int i = paramInt;
          continue;
          Object localObject4 = null;
          continue;
          localObject4 = str1;
          continue;
        }
        localJSONException1 = localJSONException1;
        str2 = null;
        localJSONException1.printStackTrace();
        localObject4 = str2;
        continue;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException1)
      {
        str2 = null;
      }
      label288:
      localObject4 = str2;
      continue;
      if (paramThrowable == null) {
        break label355;
      }
      str1 = paramThrowable.getMessage();
      if (str1 != null) {
        break label361;
      }
      localObject4 = paramThrowable.toString();
      continue;
      if (localObject1 != null) {
        break label355;
      }
      localObject4 = "remote is not qiniu server!";
    }
  }
  
  public void onFailure(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfByte, Throwable paramThrowable)
  {
    double d = (System.currentTimeMillis() - this.reqStartTime) / 1000.0D;
    ResponseInfo localResponseInfo = buildResponseInfo(paramInt, paramArrayOfHeader, paramArrayOfByte, this.host, d, paramThrowable);
    Log.i("upload----failed", localResponseInfo.toString());
    this.completionHandler.complete(localResponseInfo, null);
  }
  
  public void onProgress(int paramInt1, int paramInt2)
  {
    if (this.progressHandler != null) {
      this.progressHandler.onProgress(paramInt1, paramInt2);
    }
  }
  
  public void onStart()
  {
    this.reqStartTime = System.currentTimeMillis();
    super.onStart();
  }
  
  public void onSuccess(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfByte)
  {
    double d = (System.currentTimeMillis() - this.reqStartTime) / 1000.0D;
    try
    {
      JSONObject localJSONObject2 = buildJsonResp(paramArrayOfByte);
      Throwable localThrowable = null;
      localJSONObject1 = localJSONObject2;
      ResponseInfo localResponseInfo = buildResponseInfo(paramInt, paramArrayOfHeader, null, this.host, d, localThrowable);
      Log.i("upload----success", localResponseInfo.toString());
      this.completionHandler.complete(localResponseInfo, localJSONObject1);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        JSONObject localJSONObject1 = null;
      }
    }
  }
  
  protected void sendMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      Object[] arrayOfObject = (Object[])paramMessage.obj;
      if ((arrayOfObject != null) && (arrayOfObject.length >= 4) && (!((Throwable)arrayOfObject[3] instanceof UnknownHostException))) {
        this.ip = Dns.getAddressesString(this.host);
      }
    }
    super.sendMessage(paramMessage);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.qiniu.android.http.ResponseHandler
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */