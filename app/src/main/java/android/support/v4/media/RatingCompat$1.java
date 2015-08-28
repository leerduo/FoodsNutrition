package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class RatingCompat$1
  implements Parcelable.Creator<RatingCompat>
{
  public RatingCompat createFromParcel(Parcel paramParcel)
  {
    return new RatingCompat(paramParcel.readInt(), paramParcel.readFloat(), null);
  }
  
  public RatingCompat[] newArray(int paramInt)
  {
    return new RatingCompat[paramInt];
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.media.RatingCompat.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */