package u.aly;

import android.content.Context;
import android.content.SharedPreferences;

public class u
{
  public static SharedPreferences a(Context paramContext)
  {
    return paramContext.getSharedPreferences("umeng_general_config", 0);
  }
  
  public static SharedPreferences a(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences(paramString, 0);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.u
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */