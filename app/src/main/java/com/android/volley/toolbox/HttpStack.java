package com.android.volley.toolbox;

import com.android.volley.Request;
import java.util.Map;
import org.apache.http.HttpResponse;

public abstract interface HttpStack
{
  public abstract HttpResponse a(Request<?> paramRequest, Map<String, String> paramMap);
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.android.volley.toolbox.HttpStack
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */