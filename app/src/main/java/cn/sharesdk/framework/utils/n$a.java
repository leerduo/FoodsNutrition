package cn.sharesdk.framework.utils;

import android.text.TextUtils;
import java.util.HashMap;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

class n$a
  extends DefaultHandler
{
  private HashMap<String, Object> a = new HashMap();
  private HashMap<String, Object> b;
  
  public HashMap<String, Object> a()
  {
    return this.a;
  }
  
  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    String str = String.valueOf(paramArrayOfChar, paramInt1, paramInt2).trim();
    if (TextUtils.isEmpty(str)) {}
    while (this.b == null) {
      return;
    }
    this.b.put("value", str);
  }
  
  public void endElement(String paramString1, String paramString2, String paramString3)
  {
    this.b = null;
  }
  
  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
  {
    if (this.b != null)
    {
      HashMap localHashMap = new HashMap();
      this.b.put(paramString2, localHashMap);
      this.b = localHashMap;
    }
    for (;;)
    {
      int i = paramAttributes.getLength();
      for (int j = 0; j < i; j++) {
        this.b.put(paramAttributes.getLocalName(j), paramAttributes.getValue(j));
      }
      this.b = new HashMap();
      this.a.put(paramString2, this.b);
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.framework.utils.n.a
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */