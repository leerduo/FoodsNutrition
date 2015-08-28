package cn.sharesdk.framework.statistics;

import android.content.Context;
import cn.sharesdk.framework.utils.R;
import cn.sharesdk.framework.utils.b;
import cn.sharesdk.framework.utils.f;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

class NewAppReceiver$a
{
  private f a;
  
  public NewAppReceiver$a(Context paramContext)
  {
    b localb = b.a(paramContext);
    String str = R.getCachePath(paramContext, null);
    if (localb.w())
    {
      File localFile1 = new File(localb.x(), "ShareSDK");
      if (localFile1.exists())
      {
        this.a = new f();
        File localFile3 = new File(localFile1, ".ba");
        this.a.a(localFile3.getAbsolutePath());
        return;
      }
    }
    this.a = new f();
    File localFile2 = new File(str, ".ba");
    if (!localFile2.getParentFile().exists()) {
      localFile2.getParentFile().mkdirs();
    }
    this.a.a(localFile2.getAbsolutePath());
  }
  
  public ArrayList<HashMap<String, String>> a()
  {
    Object localObject = this.a.d("buffered_apps");
    if (localObject == null) {
      return new ArrayList();
    }
    return (ArrayList)localObject;
  }
  
  public void a(long paramLong)
  {
    this.a.a("buffered_apps_time", Long.valueOf(paramLong));
  }
  
  public void a(ArrayList<HashMap<String, String>> paramArrayList)
  {
    this.a.a("buffered_apps", paramArrayList);
  }
  
  public long b()
  {
    return this.a.c("buffered_apps_time");
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.framework.statistics.NewAppReceiver.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */