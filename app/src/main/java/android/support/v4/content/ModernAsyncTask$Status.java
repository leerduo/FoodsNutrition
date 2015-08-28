package android.support.v4.content;

public enum ModernAsyncTask$Status
{
  static
  {
    FINISHED = new Status("FINISHED", 2);
    Status[] arrayOfStatus = new Status[3];
    arrayOfStatus[0] = PENDING;
    arrayOfStatus[1] = RUNNING;
    arrayOfStatus[2] = FINISHED;
  }
  
  private ModernAsyncTask$Status() {}
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.content.ModernAsyncTask.Status
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */