package android.support.v4.net;

import java.net.Socket;

class TrafficStatsCompat$BaseTrafficStatsCompatImpl
  implements TrafficStatsCompat.TrafficStatsCompatImpl
{
  private ThreadLocal<TrafficStatsCompat.BaseTrafficStatsCompatImpl.SocketTags> mThreadSocketTags = new TrafficStatsCompat.BaseTrafficStatsCompatImpl.1(this);
  
  public void clearThreadStatsTag()
  {
    ((TrafficStatsCompat.BaseTrafficStatsCompatImpl.SocketTags)this.mThreadSocketTags.get()).statsTag = -1;
  }
  
  public int getThreadStatsTag()
  {
    return ((TrafficStatsCompat.BaseTrafficStatsCompatImpl.SocketTags)this.mThreadSocketTags.get()).statsTag;
  }
  
  public void incrementOperationCount(int paramInt) {}
  
  public void incrementOperationCount(int paramInt1, int paramInt2) {}
  
  public void setThreadStatsTag(int paramInt)
  {
    ((TrafficStatsCompat.BaseTrafficStatsCompatImpl.SocketTags)this.mThreadSocketTags.get()).statsTag = paramInt;
  }
  
  public void tagSocket(Socket paramSocket) {}
  
  public void untagSocket(Socket paramSocket) {}
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.net.TrafficStatsCompat.BaseTrafficStatsCompatImpl
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */