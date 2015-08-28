package android.support.v4.app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

class RemoteInput$ImplBase
  implements RemoteInput.Impl
{
  public void addResultsToIntent(RemoteInput[] paramArrayOfRemoteInput, Intent paramIntent, Bundle paramBundle)
  {
    Log.w("RemoteInput", "RemoteInput is only supported from API Level 16");
  }
  
  public Bundle getResultsFromIntent(Intent paramIntent)
  {
    Log.w("RemoteInput", "RemoteInput is only supported from API Level 16");
    return null;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.app.RemoteInput.ImplBase
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */