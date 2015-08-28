package android.support.v4.media;

import android.view.ViewTreeObserver.OnWindowFocusChangeListener;

class TransportMediatorJellybeanMR2$2
  implements ViewTreeObserver.OnWindowFocusChangeListener
{
  TransportMediatorJellybeanMR2$2(TransportMediatorJellybeanMR2 paramTransportMediatorJellybeanMR2) {}
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.this$0.gainFocus();
      return;
    }
    this.this$0.loseFocus();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.media.TransportMediatorJellybeanMR2.2
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */