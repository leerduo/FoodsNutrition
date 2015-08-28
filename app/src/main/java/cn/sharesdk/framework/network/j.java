package cn.sharesdk.framework.network;

import cn.sharesdk.framework.utils.d;
import java.util.HashMap;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.util.EntityUtils;

class j
  implements HttpResponseCallback
{
  j(i parami, HashMap paramHashMap) {}
  
  public void onResponse(HttpResponse paramHttpResponse)
  {
    int i = paramHttpResponse.getStatusLine().getStatusCode();
    if ((i == 200) || (i == 201))
    {
      this.a.put("resp", EntityUtils.toString(paramHttpResponse.getEntity(), "utf-8"));
      return;
    }
    String str = EntityUtils.toString(paramHttpResponse.getEntity(), "utf-8");
    HashMap localHashMap = new HashMap();
    localHashMap.put("error", str);
    localHashMap.put("status", Integer.valueOf(i));
    throw new Throwable(new d().a(localHashMap));
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.framework.network.j
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */