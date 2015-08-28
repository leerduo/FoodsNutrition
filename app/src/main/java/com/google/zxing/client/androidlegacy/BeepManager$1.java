package com.google.zxing.client.androidlegacy;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

final class BeepManager$1
  implements MediaPlayer.OnCompletionListener
{
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    paramMediaPlayer.seekTo(0);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.androidlegacy.BeepManager.1
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */