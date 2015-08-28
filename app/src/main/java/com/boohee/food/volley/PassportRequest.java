package com.boohee.food.volley;

import android.content.Context;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class PassportRequest
  extends BaseJsonRequest
{
  public PassportRequest(int paramInt, String paramString, JsonParams paramJsonParams, JsonCallback paramJsonCallback)
  {
    super(paramInt, paramString, paramJsonParams, paramJsonCallback, paramJsonCallback);
  }
  
  private static String A()
  {
    return "261f68f92cc5e34a7c818ee4d4ae4e76baf06653";
  }
  
  public static void a(String paramString, JsonParams paramJsonParams, JsonCallback paramJsonCallback, Context paramContext)
  {
    JsonParams localJsonParams = new JsonParams();
    localJsonParams.a("app_key", z());
    localJsonParams.a("context_params", d(paramJsonParams.toString()));
    localJsonParams.a("sign", e(paramJsonParams.toString()));
    RequestManager.a(new PassportRequest(1, y() + paramString, localJsonParams, paramJsonCallback), paramContext);
  }
  
  private static String d(String paramString)
  {
    try
    {
      byte[] arrayOfByte2 = paramString.getBytes("UTF-8");
      arrayOfByte1 = arrayOfByte2;
      return Base64.encodeToString(arrayOfByte1, 2);
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        localUnsupportedEncodingException.printStackTrace();
        byte[] arrayOfByte1 = null;
      }
    }
  }
  
  private static String e(String paramString)
  {
    try
    {
      SecretKeySpec localSecretKeySpec = new SecretKeySpec(A().getBytes(), "HmacSHA1");
      Mac localMac = Mac.getInstance("HmacSHA1");
      localMac.init(localSecretKeySpec);
      byte[] arrayOfByte2 = localMac.doFinal((z() + d(paramString)).getBytes("UTF-8"));
      arrayOfByte1 = arrayOfByte2;
      return Base64.encodeToString(arrayOfByte1, 2);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        byte[] arrayOfByte1 = null;
      }
    }
  }
  
  public static String y()
  {
    return "http://passport.boohee.com";
  }
  
  private static String z()
  {
    return "food";
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.volley.PassportRequest
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */