package android.support.v4.media;

import android.view.KeyEvent;

abstract interface TransportMediatorCallback
{
  public abstract long getPlaybackPosition();
  
  public abstract void handleAudioFocusChange(int paramInt);
  
  public abstract void handleKey(KeyEvent paramKeyEvent);
  
  public abstract void playbackPositionUpdate(long paramLong);
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.media.TransportMediatorCallback
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */