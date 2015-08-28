package com.boohee.food.push;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.boohee.food.FoodApplication;
import com.boohee.food.TopicActivity;
import com.boohee.food.util.LogUtils;
import com.boohee.food.util.SystemUtils;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.mipush.sdk.PushMessageReceiver;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class XMPushReceiver
  extends PushMessageReceiver
{
  private void delTags()
  {
    List localList = MiPushClient.b(FoodApplication.a());
    String str1 = SystemUtils.a(FoodApplication.a());
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      if ((!TextUtils.isEmpty(str2)) && (!"ALL".equals(str2)) && (!str1.equals(str2))) {
        MiPushClient.c(FoodApplication.a(), str2, null);
      }
    }
  }
  
  private void handleMessage(Context paramContext, String paramString)
  {
    String str = new JSONObject(paramString).optString("topicId");
    if (!TextUtils.isEmpty(str))
    {
      Intent localIntent = new Intent(paramContext, TopicActivity.class);
      localIntent.setFlags(268435456);
      localIntent.putExtra("key_topic_id", str);
      paramContext.startActivity(localIntent);
    }
  }
  
  private void setDefaultTags()
  {
    MiPushClient.b(FoodApplication.a(), "ALL", null);
    MiPushClient.b(FoodApplication.a(), SystemUtils.a(FoodApplication.a()), null);
  }
  
  public void onCommandResult(Context paramContext, MiPushCommandMessage paramMiPushCommandMessage)
  {
    String str1 = paramMiPushCommandMessage.a();
    List localList = paramMiPushCommandMessage.b();
    if (localList != null)
    {
      if ((!"register".equals(str1)) || (localList.size() != 1)) {
        break label90;
      }
      str2 = (String)localList.get(0);
      LogUtils.a("regId =  " + str2);
      if (paramMiPushCommandMessage.c() == 0L)
      {
        setDefaultTags();
        delTags();
      }
    }
    label90:
    while (((!MiPushClient.a.equals(str1)) && (!MiPushClient.b.equals(str1))) || (localList.size() != 1) || (paramMiPushCommandMessage.c() != 0L))
    {
      String str2;
      return;
    }
    LogUtils.b("TED", (String)localList.get(0));
  }
  
  public void onReceiveMessage(Context paramContext, MiPushMessage paramMiPushMessage)
  {
    if ((paramMiPushMessage == null) || (TextUtils.isEmpty(paramMiPushMessage.b()))) {
      return;
    }
    try
    {
      handleMessage(paramContext, paramMiPushMessage.b().trim());
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.push.XMPushReceiver
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */