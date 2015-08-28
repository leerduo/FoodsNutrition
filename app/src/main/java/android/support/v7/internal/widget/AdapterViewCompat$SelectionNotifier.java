package android.support.v7.internal.widget;

class AdapterViewCompat$SelectionNotifier
  implements Runnable
{
  private AdapterViewCompat$SelectionNotifier(AdapterViewCompat paramAdapterViewCompat) {}
  
  public void run()
  {
    if (this.a.u)
    {
      if (this.a.getAdapter() != null) {
        this.a.post(this);
      }
      return;
    }
    AdapterViewCompat.b(this.a);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.widget.AdapterViewCompat.SelectionNotifier
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */