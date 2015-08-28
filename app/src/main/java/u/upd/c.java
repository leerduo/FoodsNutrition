package u.upd;

import android.content.Context;
import android.content.res.Resources;

public class c
{
  private static final String a = c.class.getName();
  private static c b = null;
  private Resources c;
  private final String d;
  private final String e = "drawable";
  private final String f = "id";
  private final String g = "layout";
  private final String h = "anim";
  private final String i = "style";
  private final String j = "string";
  private final String k = "array";
  
  private c(Context paramContext)
  {
    this.c = paramContext.getResources();
    this.d = paramContext.getPackageName();
  }
  
  private int a(String paramString1, String paramString2)
  {
    int m = this.c.getIdentifier(paramString1, paramString2, this.d);
    if (m == 0)
    {
      b.b(a, "getRes(" + paramString2 + "/ " + paramString1 + ")");
      b.b(a, "Error getting resource. Make sure you have copied all resources (res/) from SDK to your project. ");
      m = 0;
    }
    return m;
  }
  
  public static c a(Context paramContext)
  {
    try
    {
      if (b == null) {
        b = new c(paramContext.getApplicationContext());
      }
      c localc = b;
      return localc;
    }
    finally {}
  }
  
  public int a(String paramString)
  {
    return a(paramString, "id");
  }
  
  public int b(String paramString)
  {
    return a(paramString, "drawable");
  }
  
  public int c(String paramString)
  {
    return a(paramString, "layout");
  }
  
  public int d(String paramString)
  {
    return a(paramString, "string");
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.upd.c
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */