package cn.sharesdk.framework.network;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class d
  extends e
{
  private File a;
  
  protected InputStream a()
  {
    return new FileInputStream(this.a);
  }
  
  public void a(File paramFile)
  {
    this.a = paramFile;
  }
  
  public void a(String paramString)
  {
    this.a = new File(paramString);
  }
  
  protected long b()
  {
    return this.a.length();
  }
  
  public String toString()
  {
    return this.a.toString();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.framework.network.d
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */