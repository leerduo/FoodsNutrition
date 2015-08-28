package cn.sharesdk.framework.network;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class n
  extends e
{
  private StringBuilder a = new StringBuilder();
  
  public n a(String paramString)
  {
    this.a.append(paramString);
    return this;
  }
  
  protected InputStream a()
  {
    return new ByteArrayInputStream(this.a.toString().getBytes("utf-8"));
  }
  
  protected long b()
  {
    return this.a.toString().getBytes("utf-8").length;
  }
  
  public String toString()
  {
    return this.a.toString();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.framework.network.n
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */