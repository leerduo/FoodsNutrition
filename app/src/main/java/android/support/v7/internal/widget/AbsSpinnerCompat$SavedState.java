package android.support.v7.internal.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;

class AbsSpinnerCompat$SavedState
  extends View.BaseSavedState
{
  public static final Parcelable.Creator<SavedState> CREATOR = new AbsSpinnerCompat.SavedState.1();
  long a;
  int b;
  
  AbsSpinnerCompat$SavedState(Parcel paramParcel)
  {
    super(paramParcel);
    this.a = paramParcel.readLong();
    this.b = paramParcel.readInt();
  }
  
  AbsSpinnerCompat$SavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public String toString()
  {
    return "AbsSpinner.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " selectedId=" + this.a + " position=" + this.b + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeLong(this.a);
    paramParcel.writeInt(this.b);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.AbsSpinnerCompat.SavedState
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */