package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class FragmentState$1
  implements Parcelable.Creator<FragmentState>
{
  public FragmentState createFromParcel(Parcel paramParcel)
  {
    return new FragmentState(paramParcel);
  }
  
  public FragmentState[] newArray(int paramInt)
  {
    return new FragmentState[paramInt];
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.app.FragmentState.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */