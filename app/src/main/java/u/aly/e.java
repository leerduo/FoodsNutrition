package u.aly;

import android.content.Context;
import android.telephony.TelephonyManager;

public class e
  extends a
{
  private Context a;
  
  public e(Context paramContext)
  {
    super("imei");
    this.a = paramContext;
  }
  
  public String f()
  {
    TelephonyManager localTelephonyManager = (TelephonyManager)this.a.getSystemService("phone");
    if (localTelephonyManager == null) {}
    try
    {
      if (bi.a(this.a, "android.permission.READ_PHONE_STATE"))
      {
        String str = localTelephonyManager.getDeviceId();
        return str;
      }
    }
    catch (Exception localException)
    {
      return null;
    }
    return null;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.e
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */