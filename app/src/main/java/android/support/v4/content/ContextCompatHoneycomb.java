package android.support.v4.content;

import android.content.Context;
import android.content.Intent;
import java.io.File;

class ContextCompatHoneycomb
{
  public static File getObbDir(Context paramContext)
  {
    return paramContext.getObbDir();
  }
  
  static void startActivities(Context paramContext, Intent[] paramArrayOfIntent)
  {
    paramContext.startActivities(paramArrayOfIntent);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.content.ContextCompatHoneycomb
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */