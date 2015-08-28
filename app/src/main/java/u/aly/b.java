package u.aly;

import android.content.Context;
import android.provider.Settings.Secure;

public class b
  extends a
{
  private Context a;
  
  public b(Context paramContext)
  {
    super("android_id");
    this.a = paramContext;
  }
  
  public String f()
  {
    try
    {
      String str = Settings.Secure.getString(this.a.getContentResolver(), "android_id");
      return str;
    }
    catch (Exception localException) {}
    return null;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.b
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */