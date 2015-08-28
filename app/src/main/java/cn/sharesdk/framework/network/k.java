package cn.sharesdk.framework.network;

import android.text.TextUtils;
import cn.sharesdk.framework.ShareSDK;
import java.util.ArrayList;

public class k
  extends i
{
  private static k c = null;
  
  public static k a()
  {
    if (c == null) {
      c = new k();
    }
    return c;
  }
  
  private void a(String paramString, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramInt <= 0)) {
      return;
    }
    ShareSDK.logApiEvent(paramString, paramInt);
  }
  
  public String a(String paramString1, ArrayList<f<String>> paramArrayList, f<String> paramf, String paramString2, int paramInt)
  {
    return a(paramString1, paramArrayList, paramf, null, paramString2, paramInt);
  }
  
  public String a(String paramString1, ArrayList<f<String>> paramArrayList1, f<String> paramf, ArrayList<f<String>> paramArrayList2, String paramString2, int paramInt)
  {
    return a(paramString1, paramArrayList1, paramf, paramArrayList2, null, paramString2, paramInt);
  }
  
  public String a(String paramString1, ArrayList<f<String>> paramArrayList1, f<String> paramf, ArrayList<f<String>> paramArrayList2, ArrayList<f<?>> paramArrayList, String paramString2, int paramInt)
  {
    a(paramString2, paramInt);
    return super.a(paramString1, paramArrayList1, paramf, paramArrayList2, paramArrayList);
  }
  
  public String a(String paramString1, ArrayList<f<String>> paramArrayList, String paramString2, int paramInt)
  {
    return a(paramString1, paramArrayList, null, null, paramString2, paramInt);
  }
  
  public String a(String paramString1, ArrayList<f<String>> paramArrayList1, ArrayList<f<String>> paramArrayList2, ArrayList<f<?>> paramArrayList, String paramString2, int paramInt)
  {
    a(paramString2, paramInt);
    return super.a(paramString1, paramArrayList1, paramArrayList2, paramArrayList);
  }
  
  public void a(String paramString1, ArrayList<f<String>> paramArrayList, e parame, RawNetworkCallback paramRawNetworkCallback, String paramString2, int paramInt)
  {
    a(paramString2, paramInt);
    super.a(paramString1, paramArrayList, parame, paramRawNetworkCallback);
  }
  
  public String b(String paramString1, ArrayList<f<String>> paramArrayList1, f<String> paramf, ArrayList<f<String>> paramArrayList2, ArrayList<f<?>> paramArrayList, String paramString2, int paramInt)
  {
    a(paramString2, paramInt);
    return super.b(paramString1, paramArrayList1, paramf, paramArrayList2, paramArrayList);
  }
  
  public String b(String paramString1, ArrayList<f<String>> paramArrayList, String paramString2, int paramInt)
  {
    return a(paramString1, paramArrayList, null, paramString2, paramInt);
  }
  
  public String b(String paramString1, ArrayList<f<String>> paramArrayList1, ArrayList<f<String>> paramArrayList2, ArrayList<f<?>> paramArrayList, String paramString2, int paramInt)
  {
    a(paramString2, paramInt);
    return super.b(paramString1, paramArrayList1, paramArrayList2, paramArrayList);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.framework.network.k
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */