package cn.sharesdk.framework.statistics;

import android.content.Context;
import android.text.TextUtils;
import cn.sharesdk.framework.utils.b;
import cn.sharesdk.framework.utils.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

class NewAppReceiver$b
  extends Thread
{
  private Context a;
  private NewAppReceiver.a b;
  
  private NewAppReceiver$b(Context paramContext)
  {
    this.a = paramContext;
    this.b = new NewAppReceiver.a(paramContext);
  }
  
  private ArrayList<HashMap<String, String>> a(HashMap<String, HashMap<String, String>> paramHashMap)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramHashMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((Map.Entry)localIterator.next()).getValue());
    }
    return localArrayList;
  }
  
  private HashMap<String, HashMap<String, String>> a(ArrayList<HashMap<String, String>> paramArrayList)
  {
    HashMap localHashMap1 = new HashMap();
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      HashMap localHashMap2 = (HashMap)localIterator.next();
      String str = (String)localHashMap2.get("pkg");
      if (!TextUtils.isEmpty(str)) {
        localHashMap1.put(str, localHashMap2);
      }
    }
    return localHashMap1;
  }
  
  public static void a(Context paramContext)
  {
    new b(paramContext).start();
  }
  
  public void run()
  {
    b localb = b.a(this.a);
    ArrayList localArrayList1 = localb.a(false);
    ArrayList localArrayList2 = this.b.a();
    this.b.a(localArrayList1);
    HashMap localHashMap1 = a(localArrayList1);
    HashMap localHashMap2 = a(localArrayList2);
    Iterator localIterator1 = localArrayList2.iterator();
    while (localIterator1.hasNext())
    {
      String str2 = (String)((HashMap)localIterator1.next()).get("pkg");
      if (!TextUtils.isEmpty(str2)) {
        localHashMap1.remove(str2);
      }
    }
    Iterator localIterator2 = localArrayList1.iterator();
    while (localIterator2.hasNext())
    {
      String str1 = (String)((HashMap)localIterator2.next()).get("pkg");
      if (!TextUtils.isEmpty(str1)) {
        localHashMap2.remove(str1);
      }
    }
    ArrayList localArrayList3 = a(localHashMap1);
    ArrayList localArrayList4 = a(localHashMap2);
    int i;
    if (System.currentTimeMillis() - this.b.b() >= 2592000000L)
    {
      i = 1;
      if ((i == 0) && (localArrayList2.size() > 0)) {
        break label296;
      }
      this.b.a(System.currentTimeMillis());
    }
    for (;;)
    {
      try
      {
        a.a(this.a).a("APPS_ALL", localArrayList1);
        if (localArrayList4.size() > 0) {
          e.a("================== upload new removes: " + localb.q(), new Object[0]);
        }
        try
        {
          a.a(this.a).a("UNINSTALL", localArrayList4);
          return;
        }
        catch (Throwable localThrowable2)
        {
          e.c(localThrowable2);
        }
        i = 0;
      }
      catch (Throwable localThrowable1)
      {
        e.c(localThrowable1);
        continue;
      }
      label296:
      if (localArrayList3.size() > 0)
      {
        e.a("================== upload new apps: " + localb.q(), new Object[0]);
        try
        {
          a.a(this.a).a("APPS_INCR", localArrayList3);
        }
        catch (Throwable localThrowable3)
        {
          e.c(localThrowable3);
        }
      }
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.framework.statistics.NewAppReceiver.b
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */