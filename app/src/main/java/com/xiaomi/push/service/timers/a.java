package com.xiaomi.push.service.timers;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.xiaomi.channel.commonutils.logger.b;
import java.lang.reflect.Method;

public class a
{
  private PendingIntent a = null;
  private Context b = null;
  
  public a(Context paramContext)
  {
    this.b = paramContext;
  }
  
  private long a(long paramLong)
  {
    return paramLong * (1L + SystemClock.elapsedRealtime() / paramLong);
  }
  
  private void a(AlarmManager paramAlarmManager, long paramLong, PendingIntent paramPendingIntent)
  {
    try
    {
      Class[] arrayOfClass = new Class[3];
      arrayOfClass[0] = Integer.TYPE;
      arrayOfClass[1] = Long.TYPE;
      arrayOfClass[2] = PendingIntent.class;
      Method localMethod = AlarmManager.class.getMethod("setExact", arrayOfClass);
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = Integer.valueOf(2);
      arrayOfObject[1] = Long.valueOf(paramLong);
      arrayOfObject[2] = paramPendingIntent;
      localMethod.invoke(paramAlarmManager, arrayOfObject);
      return;
    }
    catch (Exception localException)
    {
      b.a(localException);
    }
  }
  
  public void a()
  {
    try
    {
      if (this.a != null)
      {
        ((AlarmManager)this.b.getSystemService("alarm")).cancel(this.a);
        this.a = null;
        b.b("unregister timer");
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(Intent paramIntent, long paramLong)
  {
    for (;;)
    {
      try
      {
        PendingIntent localPendingIntent = this.a;
        if (localPendingIntent != null) {
          return;
        }
        AlarmManager localAlarmManager = (AlarmManager)this.b.getSystemService("alarm");
        this.a = PendingIntent.getBroadcast(this.b, 0, paramIntent, 0);
        if (Build.VERSION.SDK_INT >= 19)
        {
          a(localAlarmManager, paramLong, this.a);
          b.b("register timer");
        }
        else
        {
          localAlarmManager.set(2, paramLong, this.a);
        }
      }
      finally {}
    }
  }
  
  /* Error */
  public void a(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 105	android/content/Intent
    //   5: dup
    //   6: getstatic 111	com/xiaomi/push/service/x:l	Ljava/lang/String;
    //   9: invokespecial 113	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   12: astore_2
    //   13: aload_2
    //   14: aload_0
    //   15: getfield 17	com/xiaomi/push/service/timers/a:b	Landroid/content/Context;
    //   18: invokevirtual 117	android/content/Context:getPackageName	()Ljava/lang/String;
    //   21: invokevirtual 121	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   24: pop
    //   25: iload_1
    //   26: ifeq +18 -> 44
    //   29: invokestatic 24	android/os/SystemClock:elapsedRealtime	()J
    //   32: lstore 5
    //   34: aload_0
    //   35: aload_2
    //   36: lload 5
    //   38: invokevirtual 123	com/xiaomi/push/service/timers/a:a	(Landroid/content/Intent;J)V
    //   41: aload_0
    //   42: monitorexit
    //   43: return
    //   44: aload_0
    //   45: invokestatic 129	com/xiaomi/smack/r:d	()I
    //   48: i2l
    //   49: invokespecial 131	com/xiaomi/push/service/timers/a:a	(J)J
    //   52: lstore 7
    //   54: lload 7
    //   56: lstore 5
    //   58: goto -24 -> 34
    //   61: astore_3
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_3
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	a
    //   0	66	1	paramBoolean	boolean
    //   12	24	2	localIntent	Intent
    //   61	4	3	localObject	Object
    //   32	25	5	l1	long
    //   52	3	7	l2	long
    // Exception table:
    //   from	to	target	type
    //   2	25	61	finally
    //   29	34	61	finally
    //   34	41	61	finally
    //   44	54	61	finally
  }
  
  /* Error */
  public boolean b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 15	com/xiaomi/push/service/timers/a:a	Landroid/app/PendingIntent;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnull +9 -> 17
    //   11: iconst_1
    //   12: istore_3
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_3
    //   16: ireturn
    //   17: iconst_0
    //   18: istore_3
    //   19: goto -6 -> 13
    //   22: astore_1
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_1
    //   26: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	27	0	this	a
    //   22	4	1	localObject	Object
    //   6	2	2	localPendingIntent	PendingIntent
    //   12	7	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	22	finally
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.service.timers.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */