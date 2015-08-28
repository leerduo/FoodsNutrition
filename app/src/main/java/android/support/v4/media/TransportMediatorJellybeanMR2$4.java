package android.support.v4.media;

import android.media.AudioManager.OnAudioFocusChangeListener;

class TransportMediatorJellybeanMR2$4
  implements AudioManager.OnAudioFocusChangeListener
{
  TransportMediatorJellybeanMR2$4(TransportMediatorJellybeanMR2 paramTransportMediatorJellybeanMR2) {}
  
  public void onAudioFocusChange(int paramInt)
  {
    this.this$0.mTransportCallback.handleAudioFocusChange(paramInt);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.media.TransportMediatorJellybeanMR2.4
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */