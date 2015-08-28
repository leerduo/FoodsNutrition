package android.support.v4.content;

import android.net.Uri;
import java.io.File;

abstract interface FileProvider$PathStrategy
{
  public abstract File getFileForUri(Uri paramUri);
  
  public abstract Uri getUriForFile(File paramFile);
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.content.FileProvider.PathStrategy
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */