package android.support.v7.internal.widget;

import android.util.SparseArray;
import android.view.View;

class AbsSpinnerCompat$RecycleBin
{
  private final SparseArray<View> b = new SparseArray();
  
  AbsSpinnerCompat$RecycleBin(AbsSpinnerCompat paramAbsSpinnerCompat) {}
  
  View a(int paramInt)
  {
    View localView = (View)this.b.get(paramInt);
    if (localView != null) {
      this.b.delete(paramInt);
    }
    return localView;
  }
  
  void a()
  {
    SparseArray localSparseArray = this.b;
    int i = localSparseArray.size();
    for (int j = 0; j < i; j++)
    {
      View localView = (View)localSparseArray.valueAt(j);
      if (localView != null) {
        AbsSpinnerCompat.a(this.a, localView, true);
      }
    }
    localSparseArray.clear();
  }
  
  public void a(int paramInt, View paramView)
  {
    this.b.put(paramInt, paramView);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.AbsSpinnerCompat.RecycleBin
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */