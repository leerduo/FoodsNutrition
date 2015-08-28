package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class BackStackState$1
  implements Parcelable.Creator<BackStackState>
{
  public BackStackState createFromParcel(Parcel paramParcel)
  {
    return new BackStackState(paramParcel);
  }
  
  public BackStackState[] newArray(int paramInt)
  {
    return new BackStackState[paramInt];
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.app.BackStackState.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */