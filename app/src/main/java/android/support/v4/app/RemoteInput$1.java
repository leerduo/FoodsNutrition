package android.support.v4.app;

import android.os.Bundle;

final class RemoteInput$1
  implements RemoteInputCompatBase.RemoteInput.Factory
{
  public RemoteInput build(String paramString, CharSequence paramCharSequence, CharSequence[] paramArrayOfCharSequence, boolean paramBoolean, Bundle paramBundle)
  {
    return new RemoteInput(paramString, paramCharSequence, paramArrayOfCharSequence, paramBoolean, paramBundle);
  }
  
  public RemoteInput[] newArray(int paramInt)
  {
    return new RemoteInput[paramInt];
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.app.RemoteInput.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */