package com.android.volley.toolbox;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonObjectRequest
  extends JsonRequest<JSONObject>
{
  public JsonObjectRequest(int paramInt, String paramString, JSONObject paramJSONObject, Response.Listener<JSONObject> paramListener, Response.ErrorListener paramErrorListener) {}
  
  protected Response<JSONObject> a(NetworkResponse paramNetworkResponse)
  {
    try
    {
      Response localResponse = Response.a(new JSONObject(new String(paramNetworkResponse.b, HttpHeaderParser.a(paramNetworkResponse.c))), HttpHeaderParser.a(paramNetworkResponse));
      return localResponse;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      return Response.a(new ParseError(localUnsupportedEncodingException));
    }
    catch (JSONException localJSONException)
    {
      return Response.a(new ParseError(localJSONException));
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.android.volley.toolbox.JsonObjectRequest
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */