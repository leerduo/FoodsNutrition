package u.aly;

import org.json.JSONArray;

public class ae
  extends ay
{
  public ae() {}
  
  public ae(String paramString)
  {
    a(new JSONArray(paramString));
  }
  
  private void a(JSONArray paramJSONArray)
  {
    a(paramJSONArray.getString(0));
    a(paramJSONArray.getInt(1));
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     u.aly.ae
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */