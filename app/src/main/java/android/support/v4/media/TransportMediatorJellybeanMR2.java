package android.support.v4.media;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.RemoteControlClient;
import android.media.RemoteControlClient.OnGetPlaybackPositionListener;
import android.media.RemoteControlClient.OnPlaybackPositionUpdateListener;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnWindowAttachListener;
import android.view.ViewTreeObserver.OnWindowFocusChangeListener;

class TransportMediatorJellybeanMR2
  implements RemoteControlClient.OnGetPlaybackPositionListener, RemoteControlClient.OnPlaybackPositionUpdateListener
{
  AudioManager.OnAudioFocusChangeListener mAudioFocusChangeListener = new TransportMediatorJellybeanMR2.4(this);
  boolean mAudioFocused;
  final AudioManager mAudioManager;
  final Context mContext;
  boolean mFocused;
  final Intent mIntent;
  final BroadcastReceiver mMediaButtonReceiver = new TransportMediatorJellybeanMR2.3(this);
  PendingIntent mPendingIntent;
  int mPlayState = 0;
  final String mReceiverAction;
  final IntentFilter mReceiverFilter;
  RemoteControlClient mRemoteControl;
  final View mTargetView;
  final TransportMediatorCallback mTransportCallback;
  final ViewTreeObserver.OnWindowAttachListener mWindowAttachListener = new TransportMediatorJellybeanMR2.1(this);
  final ViewTreeObserver.OnWindowFocusChangeListener mWindowFocusListener = new TransportMediatorJellybeanMR2.2(this);
  
  public TransportMediatorJellybeanMR2(Context paramContext, AudioManager paramAudioManager, View paramView, TransportMediatorCallback paramTransportMediatorCallback)
  {
    this.mContext = paramContext;
    this.mAudioManager = paramAudioManager;
    this.mTargetView = paramView;
    this.mTransportCallback = paramTransportMediatorCallback;
    this.mReceiverAction = (paramContext.getPackageName() + ":transport:" + System.identityHashCode(this));
    this.mIntent = new Intent(this.mReceiverAction);
    this.mIntent.setPackage(paramContext.getPackageName());
    this.mReceiverFilter = new IntentFilter();
    this.mReceiverFilter.addAction(this.mReceiverAction);
    this.mTargetView.getViewTreeObserver().addOnWindowAttachListener(this.mWindowAttachListener);
    this.mTargetView.getViewTreeObserver().addOnWindowFocusChangeListener(this.mWindowFocusListener);
  }
  
  public void destroy()
  {
    windowDetached();
    this.mTargetView.getViewTreeObserver().removeOnWindowAttachListener(this.mWindowAttachListener);
    this.mTargetView.getViewTreeObserver().removeOnWindowFocusChangeListener(this.mWindowFocusListener);
  }
  
  void dropAudioFocus()
  {
    if (this.mAudioFocused)
    {
      this.mAudioFocused = false;
      this.mAudioManager.abandonAudioFocus(this.mAudioFocusChangeListener);
    }
  }
  
  void gainFocus()
  {
    if (!this.mFocused)
    {
      this.mFocused = true;
      this.mAudioManager.registerMediaButtonEventReceiver(this.mPendingIntent);
      this.mAudioManager.registerRemoteControlClient(this.mRemoteControl);
      if (this.mPlayState == 3) {
        takeAudioFocus();
      }
    }
  }
  
  public Object getRemoteControlClient()
  {
    return this.mRemoteControl;
  }
  
  void loseFocus()
  {
    dropAudioFocus();
    if (this.mFocused)
    {
      this.mFocused = false;
      this.mAudioManager.unregisterRemoteControlClient(this.mRemoteControl);
      this.mAudioManager.unregisterMediaButtonEventReceiver(this.mPendingIntent);
    }
  }
  
  public long onGetPlaybackPosition()
  {
    return this.mTransportCallback.getPlaybackPosition();
  }
  
  public void onPlaybackPositionUpdate(long paramLong)
  {
    this.mTransportCallback.playbackPositionUpdate(paramLong);
  }
  
  public void pausePlaying()
  {
    if (this.mPlayState == 3)
    {
      this.mPlayState = 2;
      this.mRemoteControl.setPlaybackState(2);
    }
    dropAudioFocus();
  }
  
  public void refreshState(boolean paramBoolean, long paramLong, int paramInt)
  {
    RemoteControlClient localRemoteControlClient;
    int i;
    if (this.mRemoteControl != null)
    {
      localRemoteControlClient = this.mRemoteControl;
      if (!paramBoolean) {
        break label47;
      }
      i = 3;
      if (!paramBoolean) {
        break label53;
      }
    }
    label47:
    label53:
    for (float f = 1.0F;; f = 0.0F)
    {
      localRemoteControlClient.setPlaybackState(i, paramLong, f);
      this.mRemoteControl.setTransportControlFlags(paramInt);
      return;
      i = 1;
      break;
    }
  }
  
  public void startPlaying()
  {
    if (this.mPlayState != 3)
    {
      this.mPlayState = 3;
      this.mRemoteControl.setPlaybackState(3);
    }
    if (this.mFocused) {
      takeAudioFocus();
    }
  }
  
  public void stopPlaying()
  {
    if (this.mPlayState != 1)
    {
      this.mPlayState = 1;
      this.mRemoteControl.setPlaybackState(1);
    }
    dropAudioFocus();
  }
  
  void takeAudioFocus()
  {
    if (!this.mAudioFocused)
    {
      this.mAudioFocused = true;
      this.mAudioManager.requestAudioFocus(this.mAudioFocusChangeListener, 3, 1);
    }
  }
  
  void windowAttached()
  {
    this.mContext.registerReceiver(this.mMediaButtonReceiver, this.mReceiverFilter);
    this.mPendingIntent = PendingIntent.getBroadcast(this.mContext, 0, this.mIntent, 268435456);
    this.mRemoteControl = new RemoteControlClient(this.mPendingIntent);
    this.mRemoteControl.setOnGetPlaybackPositionListener(this);
    this.mRemoteControl.setPlaybackPositionUpdateListener(this);
  }
  
  void windowDetached()
  {
    loseFocus();
    if (this.mPendingIntent != null)
    {
      this.mContext.unregisterReceiver(this.mMediaButtonReceiver);
      this.mPendingIntent.cancel();
      this.mPendingIntent = null;
      this.mRemoteControl = null;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.media.TransportMediatorJellybeanMR2
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */