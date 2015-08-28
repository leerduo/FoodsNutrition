package com.boohee.food.volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonParams
{
  protected final JSONObject a = new JSONObject();
  
  public JSONObject a()
  {
    return this.a;
  }
  
  public void a(String paramString, int paramInt)
  {
    if (paramString != null) {}
    try
    {
      this.a.put(paramString, paramInt);
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public void a(String paramString, JsonParams paramJsonParams)
  {
    if ((paramString != null) && (paramJsonParams != null)) {}
    try
    {
      this.a.put(paramString, paramJsonParams.a());
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null)) {}
    try
    {
      this.a.put(paramString1, paramString2);
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public void a(String paramString, JSONArray paramJSONArray)
  {
    if ((paramString != null) && (paramJSONArray != null)) {}
    try
    {
      this.a.put(paramString, paramJSONArray);
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public String toString()
  {
    return this.a.toString();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.volley.JsonParams
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */