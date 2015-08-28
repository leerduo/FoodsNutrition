package u.aly;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class cl
  implements Serializable
{
  private static Map<Class<? extends bz>, Map<? extends cg, cl>> d = new HashMap();
  public final String a;
  public final byte b;
  public final cm c;
  
  public cl(String paramString, byte paramByte, cm paramcm)
  {
    this.a = paramString;
    this.b = paramByte;
    this.c = paramcm;
  }
  
  public static void a(Class<? extends bz> paramClass, Map<? extends cg, cl> paramMap)
  {
    d.put(paramClass, paramMap);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.cl
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */