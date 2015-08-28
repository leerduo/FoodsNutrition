package com.google.zxing.client.android;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.util.Log;
import java.io.Closeable;
import java.io.IOException;

final class BeepManager
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, Closeable
{
  private static final String a = BeepManager.class.getSimpleName();
  private final Activity b;
  private MediaPlayer c;
  private boolean d;
  private boolean e;
  
  BeepManager(Activity paramActivity)
  {
    this.b = paramActivity;
    this.c = null;
    a();
  }
  
  private MediaPlayer a(Context paramContext)
  {
    MediaPlayer localMediaPlayer = new MediaPlayer();
    localMediaPlayer.setAudioStreamType(3);
    localMediaPlayer.setOnCompletionListener(this);
    localMediaPlayer.setOnErrorListener(this);
    try
    {
      AssetFileDescriptor localAssetFileDescriptor = paramContext.getResources().openRawResourceFd(R.raw.zxing_beep);
      try
      {
        localMediaPlayer.setDataSource(localAssetFileDescriptor.getFileDescriptor(), localAssetFileDescriptor.getStartOffset(), localAssetFileDescriptor.getLength());
        localAssetFileDescriptor.close();
        localMediaPlayer.setVolume(0.1F, 0.1F);
        return localMediaPlayer;
      }
      finally
      {
        localAssetFileDescriptor.close();
      }
      return null;
    }
    catch (IOException localIOException)
    {
      Log.w(a, localIOException);
      localMediaPlayer.release();
    }
  }
  
  private static boolean a(SharedPreferences paramSharedPreferences, Context paramContext)
  {
    boolean bool = paramSharedPreferences.getBoolean("zxing_preferences_play_beep", true);
    if ((bool) && (((AudioManager)paramContext.getSystemService("audio")).getRingerMode() != 2)) {
      return false;
    }
    return bool;
  }
  
  void a()
  {
    try
    {
      SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.b);
      this.d = a(localSharedPreferences, this.b);
      this.e = localSharedPreferences.getBoolean("zxing_preferences_vibrate", false);
      if ((this.d) && (this.c == null))
      {
        this.b.setVolumeControlStream(3);
        this.c = a(this.b);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  void b()
  {
    try
    {
      if ((this.d) && (this.c != null)) {
        this.c.start();
      }
      if (this.e) {
        ((Vibrator)this.b.getSystemService("vibrator")).vibrate(200L);
      }
      return;
    }
    finally {}
  }
  
  public void close()
  {
    try
    {
      if (this.c != null)
      {
        this.c.release();
        this.c = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    paramMediaPlayer.seekTo(0);
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 100) {}
    for (;;)
    {
      try
      {
        this.b.finish();
        return true;
      }
      finally {}
      paramMediaPlayer.release();
      this.c = null;
      a();
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.android.BeepManager
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */