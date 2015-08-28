package com.boohee.food.model;

import org.json.JSONArray;
import org.json.JSONObject;

public class ApiError
{
  public int code;
  public String message;
  
  public static String getErrorMessage(JSONObject paramJSONObject)
  {
    String str = "";
    JSONArray localJSONArray = paramJSONObject.optJSONArray("errors");
    int i = 0;
    if (localJSONArray != null)
    {
      int j = localJSONArray.length();
      i = 0;
      if (j > 0)
      {
        JSONObject localJSONObject = localJSONArray.optJSONObject(0);
        i = 0;
        if (localJSONObject != null)
        {
          str = localJSONObject.optString("message");
          i = localJSONObject.optInt("code");
        }
      }
    }
    return str + " 错误代码: " + i;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.model.ApiError
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */