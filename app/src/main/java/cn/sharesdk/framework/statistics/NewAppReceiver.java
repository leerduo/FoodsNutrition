package cn.sharesdk.framework.statistics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import cn.sharesdk.framework.utils.b;
import cn.sharesdk.framework.utils.e;

public class NewAppReceiver
  extends BroadcastReceiver
  implements Handler.Callback
{
  private static final String[] a = { "android.intent.action.PACKAGE_ADDED", "android.intent.action.PACKAGE_CHANGED", "android.intent.action.PACKAGE_REMOVED", "android.intent.action.PACKAGE_REPLACED" };
  private static NewAppReceiver b;
  private Context c;
  private IntentFilter[] d;
  private Handler e;
  
  private NewAppReceiver(Context paramContext)
  {
    this.c = paramContext;
    IntentFilter[] arrayOfIntentFilter = new IntentFilter[2];
    arrayOfIntentFilter[0] = new IntentFilter();
    arrayOfIntentFilter[1] = new IntentFilter();
    this.d = arrayOfIntentFilter;
    this.d[0].addAction("cn.sharesdk.START_UP");
    String[] arrayOfString = a;
    int j = arrayOfString.length;
    while (i < j)
    {
      String str = arrayOfString[i];
      this.d[1].addAction(str);
      i++;
    }
    this.d[1].addDataScheme("package");
    this.e = new Handler(this);
    this.e.sendEmptyMessage(1);
  }
  
  /* Error */
  public static void a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 67	cn/sharesdk/framework/statistics/NewAppReceiver:b	Lcn/sharesdk/framework/statistics/NewAppReceiver;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +15 -> 23
    //   11: getstatic 67	cn/sharesdk/framework/statistics/NewAppReceiver:b	Lcn/sharesdk/framework/statistics/NewAppReceiver;
    //   14: getfield 36	cn/sharesdk/framework/statistics/NewAppReceiver:c	Landroid/content/Context;
    //   17: getstatic 67	cn/sharesdk/framework/statistics/NewAppReceiver:b	Lcn/sharesdk/framework/statistics/NewAppReceiver;
    //   20: invokevirtual 73	android/content/Context:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   23: ldc 2
    //   25: monitorexit
    //   26: return
    //   27: astore_2
    //   28: aload_2
    //   29: invokestatic 78	cn/sharesdk/framework/utils/e:b	(Ljava/lang/Throwable;)I
    //   32: pop
    //   33: goto -10 -> 23
    //   36: astore_0
    //   37: ldc 2
    //   39: monitorexit
    //   40: aload_0
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   36	5	0	localObject	Object
    //   6	2	1	localNewAppReceiver	NewAppReceiver
    //   27	2	2	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   11	23	27	java/lang/Throwable
    //   3	7	36	finally
    //   11	23	36	finally
    //   28	33	36	finally
  }
  
  /* Error */
  public static void a(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 67	cn/sharesdk/framework/statistics/NewAppReceiver:b	Lcn/sharesdk/framework/statistics/NewAppReceiver;
    //   6: ifnonnull +14 -> 20
    //   9: new 2	cn/sharesdk/framework/statistics/NewAppReceiver
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 80	cn/sharesdk/framework/statistics/NewAppReceiver:<init>	(Landroid/content/Context;)V
    //   17: putstatic 67	cn/sharesdk/framework/statistics/NewAppReceiver:b	Lcn/sharesdk/framework/statistics/NewAppReceiver;
    //   20: invokestatic 82	cn/sharesdk/framework/statistics/NewAppReceiver:a	()V
    //   23: getstatic 67	cn/sharesdk/framework/statistics/NewAppReceiver:b	Lcn/sharesdk/framework/statistics/NewAppReceiver;
    //   26: getfield 41	cn/sharesdk/framework/statistics/NewAppReceiver:d	[Landroid/content/IntentFilter;
    //   29: astore 4
    //   31: aload 4
    //   33: arraylength
    //   34: istore 5
    //   36: iconst_0
    //   37: istore 6
    //   39: iload 6
    //   41: iload 5
    //   43: if_icmpge +32 -> 75
    //   46: aload 4
    //   48: iload 6
    //   50: aaload
    //   51: astore 7
    //   53: aload_0
    //   54: getstatic 67	cn/sharesdk/framework/statistics/NewAppReceiver:b	Lcn/sharesdk/framework/statistics/NewAppReceiver;
    //   57: aload 7
    //   59: invokevirtual 86	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   62: pop
    //   63: iinc 6 1
    //   66: goto -27 -> 39
    //   69: astore_2
    //   70: aload_2
    //   71: invokestatic 78	cn/sharesdk/framework/utils/e:b	(Ljava/lang/Throwable;)I
    //   74: pop
    //   75: ldc 2
    //   77: monitorexit
    //   78: return
    //   79: astore_1
    //   80: ldc 2
    //   82: monitorexit
    //   83: aload_1
    //   84: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	paramContext	Context
    //   79	5	1	localObject	Object
    //   69	2	2	localThrowable	java.lang.Throwable
    //   29	18	4	arrayOfIntentFilter	IntentFilter[]
    //   34	10	5	i	int
    //   37	27	6	j	int
    //   51	7	7	localIntentFilter	IntentFilter
    // Exception table:
    //   from	to	target	type
    //   23	36	69	java/lang/Throwable
    //   46	63	69	java/lang/Throwable
    //   3	20	79	finally
    //   20	23	79	finally
    //   23	36	79	finally
    //   46	63	79	finally
    //   70	75	79	finally
  }
  
  private boolean a(String paramString)
  {
    String[] arrayOfString = a;
    int i = arrayOfString.length;
    for (int j = 0;; j++)
    {
      boolean bool = false;
      if (j < i)
      {
        if (arrayOfString[j].equals(paramString)) {
          bool = true;
        }
      }
      else {
        return bool;
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      NewAppReceiver.b.a(this.c);
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str1 = null;
    if (paramIntent != null) {
      str1 = paramIntent.getAction();
    }
    int i;
    if ("cn.sharesdk.START_UP".equals(str1))
    {
      String str2 = b.a(paramContext).q();
      String str3 = paramIntent.getStringExtra("packageName");
      if ((str3 == null) || (!str3.equals(str2))) {
        break label122;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        e.a("========= receive broadcast: " + str1, new Object[0]);
        this.e.removeMessages(1);
        this.e.sendEmptyMessageDelayed(1, 60000L);
      }
      return;
      if (a(str1)) {
        i = 1;
      } else {
        label122:
        i = 0;
      }
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.framework.statistics.NewAppReceiver
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */