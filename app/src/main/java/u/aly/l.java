package u.aly;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class l
{
  private final String a = "umeng_event_snapshot";
  private boolean b = false;
  private SharedPreferences c;
  private Map<String, ArrayList<aa>> d = new HashMap();
  
  public l(Context paramContext)
  {
    this.c = u.a(paramContext, "umeng_event_snapshot");
  }
  
  private void b(String paramString)
  {
    boolean bool = this.d.containsKey(paramString);
    String str = null;
    if (bool)
    {
      ArrayList localArrayList = (ArrayList)this.d.get(paramString);
      while (localArrayList.size() > 4) {
        localArrayList.remove(0);
      }
      str = s.a(localArrayList);
    }
    this.c.edit().putString(paramString, str).commit();
  }
  
  private boolean c(String paramString)
  {
    if (this.d.containsKey(paramString)) {
      return true;
    }
    String str = this.c.getString(paramString, null);
    if (str != null)
    {
      ArrayList localArrayList = (ArrayList)s.a(str);
      if (localArrayList != null)
      {
        this.d.put(paramString, localArrayList);
        return true;
      }
    }
    return false;
  }
  
  public aa a(String paramString)
  {
    if (this.b) {
      c(paramString);
    }
    ArrayList localArrayList;
    if (this.d.containsKey(paramString))
    {
      localArrayList = (ArrayList)this.d.get(paramString);
      if (localArrayList.size() <= 0) {}
    }
    for (aa localaa = (aa)localArrayList.remove(-1 + localArrayList.size());; localaa = null)
    {
      if (this.b) {
        b(paramString);
      }
      return localaa;
    }
  }
  
  public void a(String paramString, aa paramaa)
  {
    if (this.b) {
      c(paramString);
    }
    if (this.d.containsKey(paramString)) {
      ((ArrayList)this.d.get(paramString)).add(paramaa);
    }
    for (;;)
    {
      if (this.b) {
        b(paramString);
      }
      return;
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramaa);
      this.d.put(paramString, localArrayList);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.l
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */