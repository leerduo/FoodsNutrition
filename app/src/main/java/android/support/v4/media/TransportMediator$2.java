package android.support.v4.media;

import android.view.KeyEvent;
import android.view.KeyEvent.Callback;

class TransportMediator$2
  implements KeyEvent.Callback
{
  TransportMediator$2(TransportMediator paramTransportMediator) {}
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (TransportMediator.isMediaKey(paramInt)) {
      return this.this$0.mCallbacks.onMediaButtonDown(paramInt, paramKeyEvent);
    }
    return false;
  }
  
  public boolean onKeyLongPress(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public boolean onKeyMultiple(int paramInt1, int paramInt2, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (TransportMediator.isMediaKey(paramInt)) {
      return this.this$0.mCallbacks.onMediaButtonUp(paramInt, paramKeyEvent);
    }
    return false;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.media.TransportMediator.2
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */