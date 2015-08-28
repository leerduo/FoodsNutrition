package com.boohee.food.push;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Process;
import com.xiaomi.mipush.sdk.Logger;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.util.Iterator;
import java.util.List;

public class XMPush
{
  public static void a(Context paramContext)
  {
    Logger.a(paramContext, new XMPush.1());
    if (b(paramContext)) {
      MiPushClient.a(paramContext, "2882303761517288135", "5301728878135");
    }
  }
  
  private static boolean b(Context paramContext)
  {
    List localList = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    String str = paramContext.getPackageName();
    int i = Process.myPid();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
      if ((localRunningAppProcessInfo.pid == i) && (str.equals(localRunningAppProcessInfo.processName))) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.push.XMPush
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */