package android.support.v7.internal.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.support.v4.view.ActionProvider;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import org.xmlpull.v1.XmlPullParser;

public class SupportMenuInflater
  extends MenuInflater
{
  private static final Class<?>[] a = { Context.class };
  private static final Class<?>[] b = a;
  private final Object[] c;
  private final Object[] d;
  private Context e;
  private Object f;
  
  public SupportMenuInflater(Context paramContext)
  {
    super(paramContext);
    this.e = paramContext;
    this.c = new Object[] { paramContext };
    this.d = this.c;
  }
  
  private Object a(Object paramObject)
  {
    if ((paramObject instanceof Activity)) {}
    while (!(paramObject instanceof ContextWrapper)) {
      return paramObject;
    }
    return a(((ContextWrapper)paramObject).getBaseContext());
  }
  
  private void a(XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Menu paramMenu)
  {
    SupportMenuInflater.MenuState localMenuState = new SupportMenuInflater.MenuState(this, paramMenu);
    int i = paramXmlPullParser.getEventType();
    String str3;
    label51:
    Object localObject;
    int j;
    int k;
    int m;
    if (i == 2)
    {
      str3 = paramXmlPullParser.getName();
      if (str3.equals("menu"))
      {
        i = paramXmlPullParser.next();
        localObject = null;
        j = 0;
        k = i;
        m = 0;
        label64:
        if (m != 0) {
          return;
        }
      }
    }
    label96:
    int n;
    switch (k)
    {
    default: 
      n = j;
    case 2: 
    case 3: 
      for (;;)
      {
        int i1 = paramXmlPullParser.next();
        int i2 = n;
        k = i1;
        j = i2;
        break label64;
        throw new RuntimeException("Expecting menu, got " + str3);
        i = paramXmlPullParser.next();
        if (i != 1) {
          break;
        }
        break label51;
        if (j != 0)
        {
          n = j;
        }
        else
        {
          String str2 = paramXmlPullParser.getName();
          if (str2.equals("group"))
          {
            localMenuState.a(paramAttributeSet);
            n = j;
          }
          else if (str2.equals("item"))
          {
            localMenuState.b(paramAttributeSet);
            n = j;
          }
          else if (str2.equals("menu"))
          {
            a(paramXmlPullParser, paramAttributeSet, localMenuState.c());
            n = j;
          }
          else
          {
            localObject = str2;
            n = 1;
            continue;
            String str1 = paramXmlPullParser.getName();
            if ((j != 0) && (str1.equals(localObject)))
            {
              localObject = null;
              n = 0;
            }
            else if (str1.equals("group"))
            {
              localMenuState.a();
              n = j;
            }
            else
            {
              if (str1.equals("item"))
              {
                if (localMenuState.d()) {
                  break label96;
                }
                if ((SupportMenuInflater.MenuState.a(localMenuState) != null) && (SupportMenuInflater.MenuState.a(localMenuState).hasSubMenu()))
                {
                  localMenuState.c();
                  n = j;
                  continue;
                }
                localMenuState.b();
                n = j;
                continue;
              }
              if (!str1.equals("menu")) {
                break label96;
              }
              m = 1;
              n = j;
            }
          }
        }
      }
    }
    throw new RuntimeException("Unexpected end of document");
  }
  
  private Object c()
  {
    if (this.f == null) {
      this.f = a(this.e);
    }
    return this.f;
  }
  
  /* Error */
  public void inflate(int paramInt, Menu paramMenu)
  {
    // Byte code:
    //   0: aload_2
    //   1: instanceof 141
    //   4: ifne +10 -> 14
    //   7: aload_0
    //   8: iload_1
    //   9: aload_2
    //   10: invokespecial 143	android/view/MenuInflater:inflate	(ILandroid/view/Menu;)V
    //   13: return
    //   14: aconst_null
    //   15: astore_3
    //   16: aload_0
    //   17: getfield 31	android/support/v7/internal/view/SupportMenuInflater:e	Landroid/content/Context;
    //   20: invokevirtual 147	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   23: iload_1
    //   24: invokevirtual 153	android/content/res/Resources:getLayout	(I)Landroid/content/res/XmlResourceParser;
    //   27: astore_3
    //   28: aload_0
    //   29: aload_3
    //   30: aload_3
    //   31: invokestatic 159	android/util/Xml:asAttributeSet	(Lorg/xmlpull/v1/XmlPullParser;)Landroid/util/AttributeSet;
    //   34: aload_2
    //   35: invokespecial 108	android/support/v7/internal/view/SupportMenuInflater:a	(Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/view/Menu;)V
    //   38: aload_3
    //   39: ifnull -26 -> 13
    //   42: aload_3
    //   43: invokeinterface 164 1 0
    //   48: return
    //   49: astore 6
    //   51: new 166	android/view/InflateException
    //   54: dup
    //   55: ldc 168
    //   57: aload 6
    //   59: invokespecial 171	android/view/InflateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   62: athrow
    //   63: astore 5
    //   65: aload_3
    //   66: ifnull +9 -> 75
    //   69: aload_3
    //   70: invokeinterface 164 1 0
    //   75: aload 5
    //   77: athrow
    //   78: astore 4
    //   80: new 166	android/view/InflateException
    //   83: dup
    //   84: ldc 168
    //   86: aload 4
    //   88: invokespecial 171	android/view/InflateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   91: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	this	SupportMenuInflater
    //   0	92	1	paramInt	int
    //   0	92	2	paramMenu	Menu
    //   15	55	3	localXmlResourceParser	android.content.res.XmlResourceParser
    //   78	9	4	localIOException	java.io.IOException
    //   63	13	5	localObject	Object
    //   49	9	6	localXmlPullParserException	org.xmlpull.v1.XmlPullParserException
    // Exception table:
    //   from	to	target	type
    //   16	38	49	org/xmlpull/v1/XmlPullParserException
    //   16	38	63	finally
    //   51	63	63	finally
    //   80	92	63	finally
    //   16	38	78	java/io/IOException
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     android.support.v7.internal.view.SupportMenuInflater
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */