package com.xiaomi.mipush.sdk;

import android.app.IntentService;
import android.content.Intent;
import com.xiaomi.channel.commonutils.logger.b;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MessageHandleService
  extends IntentService
{
  private static ConcurrentLinkedQueue<MessageHandleService.a> a = new ConcurrentLinkedQueue();
  
  public MessageHandleService()
  {
    super("MessageHandleThread");
  }
  
  public static void a(MessageHandleService.a parama)
  {
    if (parama != null) {
      a.add(parama);
    }
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    MessageHandleService.a locala;
    if (paramIntent != null)
    {
      locala = (MessageHandleService.a)a.poll();
      if (locala != null) {
        break label19;
      }
    }
    label19:
    PushMessageReceiver localPushMessageReceiver;
    PushMessageHandler.a locala1;
    label144:
    do
    {
      Intent localIntent;
      for (;;)
      {
        return;
        try
        {
          localPushMessageReceiver = locala.a();
          localIntent = locala.b();
          switch (localIntent.getIntExtra("message_type", 1))
          {
          case 4: 
          case 1: 
            locala1 = d.a(this).a(localIntent);
            if (locala1 != null)
            {
              if (!(locala1 instanceof MiPushMessage)) {
                break label144;
              }
              localPushMessageReceiver.onReceiveMessage(this, (MiPushMessage)locala1);
              return;
            }
            break;
          }
        }
        catch (RuntimeException localRuntimeException)
        {
          b.a(localRuntimeException);
          return;
        }
      }
      localPushMessageReceiver.onReceiveMessage(this, (MiPushMessage)localIntent.getSerializableExtra("key_message"));
      return;
      localPushMessageReceiver.onCommandResult(this, (MiPushCommandMessage)localIntent.getSerializableExtra("key_command"));
      return;
    } while (!(locala1 instanceof MiPushCommandMessage));
    localPushMessageReceiver.onCommandResult(this, (MiPushCommandMessage)locala1);
    return;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.mipush.sdk.MessageHandleService
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */