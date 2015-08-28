package com.google.zxing.client.androidlegacy;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.util.Log;
import java.io.IOException;

final class BeepManager
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
  
  private static MediaPlayer a(Context paramContext)
  {
    MediaPlayer localMediaPlayer = new MediaPlayer();
    localMediaPlayer.setAudioStreamType(3);
    localMediaPlayer.setOnCompletionListener(new BeepManager.1());
    AssetFileDescriptor localAssetFileDescriptor = paramContext.getResources().openRawResourceFd(R.raw.zxinglegacy_beep);
    try
    {
      localMediaPlayer.setDataSource(localAssetFileDescriptor.getFileDescriptor(), localAssetFileDescriptor.getStartOffset(), localAssetFileDescriptor.getLength());
      localAssetFileDescriptor.close();
      localMediaPlayer.setVolume(0.1F, 0.1F);
      localMediaPlayer.prepare();
      return localMediaPlayer;
    }
    catch (IOException localIOException)
    {
      Log.w(a, localIOException);
    }
    return null;
  }
  
  private static boolean a(SharedPreferences paramSharedPreferences, Context paramContext)
  {
    boolean bool = paramSharedPreferences.getBoolean("preferences_play_beep", true);
    if ((bool) && (((AudioManager)paramContext.getSystemService("audio")).getRingerMode() != 2)) {
      return false;
    }
    return bool;
  }
  
  void a()
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.b);
    this.d = a(localSharedPreferences, this.b);
    this.e = localSharedPreferences.getBoolean("preferences_vibrate", false);
    if ((this.d) && (this.c == null))
    {
      this.b.setVolumeControlStream(3);
      this.c = a(this.b);
    }
  }
  
  void b()
  {
    if ((this.d) && (this.c != null)) {
      this.c.start();
    }
    if (this.e) {
      ((Vibrator)this.b.getSystemService("vibrator")).vibrate(200L);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.androidlegacy.BeepManager
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */