package com.umeng.analytics.social;

import android.os.AsyncTask;
import android.text.TextUtils;
import org.json.JSONObject;

class UMSocialService$a
  extends AsyncTask<Void, Void, d>
{
  String a = paramArrayOfString[0];
  String b = paramArrayOfString[1];
  UMSocialService.b c;
  UMPlatformData[] d;
  
  public UMSocialService$a(String[] paramArrayOfString, UMSocialService.b paramb, UMPlatformData[] paramArrayOfUMPlatformData)
  {
    this.c = paramb;
    this.d = paramArrayOfUMPlatformData;
  }
  
  protected d a(Void... paramVarArgs)
  {
    String str1;
    if (TextUtils.isEmpty(this.b)) {
      str1 = c.a(this.a);
    }
    for (;;)
    {
      int i;
      try
      {
        JSONObject localJSONObject = new JSONObject(str1);
        i = localJSONObject.optInt("st");
        if (i != 0) {
          break label134;
        }
        j = -404;
        d locald = new d(j);
        String str2 = localJSONObject.optString("msg");
        if (!TextUtils.isEmpty(str2)) {
          locald.a(str2);
        }
        String str3 = localJSONObject.optString("data");
        if (!TextUtils.isEmpty(str3)) {
          locald.b(str3);
        }
        return locald;
      }
      catch (Exception localException)
      {
        return new d(-99, localException);
      }
      str1 = c.a(this.a, this.b);
      continue;
      label134:
      int j = i;
    }
  }
  
  protected void a(d paramd)
  {
    if (this.c != null) {
      this.c.a(paramd, this.d);
    }
  }
  
  protected void onPreExecute()
  {
    if (this.c != null) {
      this.c.a();
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.umeng.analytics.social.UMSocialService.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */