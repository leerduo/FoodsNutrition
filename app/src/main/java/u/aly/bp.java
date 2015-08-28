package u.aly;

import org.json.JSONObject;

public abstract class bp
{
  protected static String b = "POST";
  protected static String c = "GET";
  protected String d;
  
  public bp(String paramString)
  {
    this.d = paramString;
  }
  
  public abstract JSONObject a();
  
  public void a(String paramString)
  {
    this.d = paramString;
  }
  
  public abstract String b();
  
  protected String c()
  {
    return b;
  }
  
  public String d()
  {
    return this.d;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.bp
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */