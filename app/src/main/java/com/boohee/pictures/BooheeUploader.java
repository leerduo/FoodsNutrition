package com.boohee.pictures;

import android.text.TextUtils;
import com.boohee.pictures.model.AuthParams;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import java.io.File;
import java.io.FileNotFoundException;

public class BooheeUploader
{
  private static final String PRODUCTION = "http://status.boohee.com";
  private static final String QA = "http://status.ejianfei.com";
  private static final String UP_PIC_URL = "/api/v1/local_photos.json";
  private static AuthParams authParams = PictureUpload.sAuthParams;
  private static AsyncHttpClient sClient = new AsyncHttpClient();
  
  private static String getAbsoluteUrl(String paramString)
  {
    return "http://status.boohee.com" + paramString;
  }
  
  private static void post(String paramString, RequestParams paramRequestParams, AuthParams paramAuthParams, AsyncHttpResponseHandler paramAsyncHttpResponseHandler)
  {
    putBaseParams(paramRequestParams, paramAuthParams);
    sClient.post(getAbsoluteUrl(paramString), paramRequestParams, paramAsyncHttpResponseHandler);
  }
  
  private static void putBaseParams(RequestParams paramRequestParams, AuthParams paramAuthParams)
  {
    if (paramRequestParams != null)
    {
      paramRequestParams.put("app_version", paramAuthParams.versionName);
      paramRequestParams.put("app_device", "Android");
      paramRequestParams.put("os_version", paramAuthParams.osVersion);
      paramRequestParams.put("token", paramAuthParams.token);
      paramRequestParams.put("user_key", paramAuthParams.userKey);
    }
  }
  
  public static void uploadToBoohee(Picture paramPicture, AsyncHttpResponseHandler paramAsyncHttpResponseHandler)
  {
    if (paramPicture != null) {}
    try
    {
      if (!TextUtils.isEmpty(paramPicture.path))
      {
        RequestParams localRequestParams = new RequestParams();
        localRequestParams.put("file", new File(paramPicture.path));
        post("/api/v1/local_photos.json", localRequestParams, authParams, paramAsyncHttpResponseHandler);
      }
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      localFileNotFoundException.printStackTrace();
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.pictures.BooheeUploader
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */