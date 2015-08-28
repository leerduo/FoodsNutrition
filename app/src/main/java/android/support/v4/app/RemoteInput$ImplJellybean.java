package android.support.v4.app;

import android.content.Intent;
import android.os.Bundle;

class RemoteInput$ImplJellybean
  implements RemoteInput.Impl
{
  public void addResultsToIntent(RemoteInput[] paramArrayOfRemoteInput, Intent paramIntent, Bundle paramBundle)
  {
    RemoteInputCompatJellybean.addResultsToIntent(paramArrayOfRemoteInput, paramIntent, paramBundle);
  }
  
  public Bundle getResultsFromIntent(Intent paramIntent)
  {
    return RemoteInputCompatJellybean.getResultsFromIntent(paramIntent);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.app.RemoteInput.ImplJellybean
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */