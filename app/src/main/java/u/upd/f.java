package u.upd;

import org.json.JSONObject;

public class f
  extends i
{
  public f.a a;
  
  public f(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
    if (("ok".equalsIgnoreCase(paramJSONObject.optString("status"))) || ("ok".equalsIgnoreCase(paramJSONObject.optString("success"))))
    {
      this.a = f.a.a;
      return;
    }
    this.a = f.a.b;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.upd.f
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */