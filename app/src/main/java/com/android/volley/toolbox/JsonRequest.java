package com.android.volley.toolbox;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyLog;
import java.io.UnsupportedEncodingException;

public abstract class JsonRequest<T>
  extends Request<T>
{
  private static final String a = String.format("application/json; charset=%s", new Object[] { "utf-8" });
  private final Response.Listener<T> b;
  private final String c;
  
  public JsonRequest(int paramInt, String paramString1, String paramString2, Response.Listener<T> paramListener, Response.ErrorListener paramErrorListener)
  {
    super(paramInt, paramString1, paramErrorListener);
    this.b = paramListener;
    this.c = paramString2;
  }
  
  protected abstract Response<T> a(NetworkResponse paramNetworkResponse);
  
  protected void b(T paramT)
  {
    this.b.a(paramT);
  }
  
  public String m()
  {
    return q();
  }
  
  public byte[] n()
  {
    return r();
  }
  
  public String q()
  {
    return a;
  }
  
  public byte[] r()
  {
    try
    {
      if (this.c == null) {
        return null;
      }
      byte[] arrayOfByte = this.c.getBytes("utf-8");
      return arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = this.c;
      arrayOfObject[1] = "utf-8";
      VolleyLog.d("Unsupported Encoding while trying to get the bytes of %s using %s", arrayOfObject);
    }
    return null;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.android.volley.toolbox.JsonRequest
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */