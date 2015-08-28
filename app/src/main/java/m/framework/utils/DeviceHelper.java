package m.framework.utils;

import android.content.Context;
import android.os.Environment;
import java.io.File;

public class DeviceHelper
{
  private Context a;
  
  public DeviceHelper(Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
  }
  
  public String a()
  {
    return this.a.getPackageName();
  }
  
  public boolean b()
  {
    return "mounted".equals(Environment.getExternalStorageState());
  }
  
  public String c()
  {
    return Environment.getExternalStorageDirectory().getAbsolutePath();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     m.framework.utils.DeviceHelper
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */