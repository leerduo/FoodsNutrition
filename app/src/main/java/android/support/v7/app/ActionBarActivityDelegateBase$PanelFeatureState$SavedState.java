package android.support.v7.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

class ActionBarActivityDelegateBase$PanelFeatureState$SavedState
  implements Parcelable
{
  public static final Parcelable.Creator<SavedState> CREATOR = new ActionBarActivityDelegateBase.PanelFeatureState.SavedState.1();
  int a;
  boolean b;
  Bundle c;
  
  private static SavedState b(Parcel paramParcel)
  {
    int i = 1;
    SavedState localSavedState = new SavedState();
    localSavedState.a = paramParcel.readInt();
    if (paramParcel.readInt() == i) {}
    for (;;)
    {
      localSavedState.b = i;
      if (localSavedState.b) {
        localSavedState.c = paramParcel.readBundle();
      }
      return localSavedState;
      i = 0;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    if (this.b) {}
    for (int i = 1;; i = 0)
    {
      paramParcel.writeInt(i);
      if (this.b) {
        paramParcel.writeBundle(this.c);
      }
      return;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.app.ActionBarActivityDelegateBase.PanelFeatureState.SavedState
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */