package android.support.v4.content;

import android.content.Intent;
import java.util.ArrayList;

class LocalBroadcastManager$BroadcastRecord
{
  final Intent intent;
  final ArrayList<LocalBroadcastManager.ReceiverRecord> receivers;
  
  LocalBroadcastManager$BroadcastRecord(Intent paramIntent, ArrayList<LocalBroadcastManager.ReceiverRecord> paramArrayList)
  {
    this.intent = paramIntent;
    this.receivers = paramArrayList;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.content.LocalBroadcastManager.BroadcastRecord
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */