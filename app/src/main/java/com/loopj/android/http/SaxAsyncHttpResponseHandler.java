package com.loopj.android.http;

import org.apache.http.Header;
import org.xml.sax.helpers.DefaultHandler;

public abstract class SaxAsyncHttpResponseHandler<T extends DefaultHandler>
  extends AsyncHttpResponseHandler
{
  private static final String LOG_TAG = "SaxAsyncHttpResponseHandler";
  private T handler = null;
  
  public SaxAsyncHttpResponseHandler(T paramT)
  {
    if (paramT == null) {
      throw new Error("null instance of <T extends DefaultHandler> passed to constructor");
    }
    this.handler = paramT;
  }
  
  /* Error */
  protected byte[] getResponseData(org.apache.http.HttpEntity paramHttpEntity)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +78 -> 79
    //   4: aload_1
    //   5: invokeinterface 40 1 0
    //   10: astore_2
    //   11: aload_2
    //   12: ifnull +67 -> 79
    //   15: invokestatic 46	javax/xml/parsers/SAXParserFactory:newInstance	()Ljavax/xml/parsers/SAXParserFactory;
    //   18: invokevirtual 50	javax/xml/parsers/SAXParserFactory:newSAXParser	()Ljavax/xml/parsers/SAXParser;
    //   21: invokevirtual 56	javax/xml/parsers/SAXParser:getXMLReader	()Lorg/xml/sax/XMLReader;
    //   24: astore 12
    //   26: aload 12
    //   28: aload_0
    //   29: getfield 19	com/loopj/android/http/SaxAsyncHttpResponseHandler:handler	Lorg/xml/sax/helpers/DefaultHandler;
    //   32: invokeinterface 62 2 0
    //   37: new 64	java/io/InputStreamReader
    //   40: dup
    //   41: aload_2
    //   42: ldc 66
    //   44: invokespecial 69	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   47: astore 4
    //   49: aload 12
    //   51: new 71	org/xml/sax/InputSource
    //   54: dup
    //   55: aload 4
    //   57: invokespecial 74	org/xml/sax/InputSource:<init>	(Ljava/io/Reader;)V
    //   60: invokeinterface 78 2 0
    //   65: aload_2
    //   66: invokestatic 84	com/loopj/android/http/AsyncHttpClient:silentCloseInputStream	(Ljava/io/InputStream;)V
    //   69: aload 4
    //   71: ifnull +8 -> 79
    //   74: aload 4
    //   76: invokevirtual 87	java/io/InputStreamReader:close	()V
    //   79: aconst_null
    //   80: areturn
    //   81: astore 9
    //   83: aconst_null
    //   84: astore 4
    //   86: ldc 9
    //   88: ldc 89
    //   90: aload 9
    //   92: invokestatic 95	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   95: pop
    //   96: aload_2
    //   97: invokestatic 84	com/loopj/android/http/AsyncHttpClient:silentCloseInputStream	(Ljava/io/InputStream;)V
    //   100: aload 4
    //   102: ifnull -23 -> 79
    //   105: aload 4
    //   107: invokevirtual 87	java/io/InputStreamReader:close	()V
    //   110: aconst_null
    //   111: areturn
    //   112: astore 11
    //   114: aconst_null
    //   115: areturn
    //   116: astore 6
    //   118: aconst_null
    //   119: astore 4
    //   121: ldc 9
    //   123: ldc 89
    //   125: aload 6
    //   127: invokestatic 95	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   130: pop
    //   131: aload_2
    //   132: invokestatic 84	com/loopj/android/http/AsyncHttpClient:silentCloseInputStream	(Ljava/io/InputStream;)V
    //   135: aload 4
    //   137: ifnull -58 -> 79
    //   140: aload 4
    //   142: invokevirtual 87	java/io/InputStreamReader:close	()V
    //   145: aconst_null
    //   146: areturn
    //   147: astore 8
    //   149: aconst_null
    //   150: areturn
    //   151: astore_3
    //   152: aconst_null
    //   153: astore 4
    //   155: aload_2
    //   156: invokestatic 84	com/loopj/android/http/AsyncHttpClient:silentCloseInputStream	(Ljava/io/InputStream;)V
    //   159: aload 4
    //   161: ifnull +8 -> 169
    //   164: aload 4
    //   166: invokevirtual 87	java/io/InputStreamReader:close	()V
    //   169: aload_3
    //   170: athrow
    //   171: astore 13
    //   173: aconst_null
    //   174: areturn
    //   175: astore 5
    //   177: goto -8 -> 169
    //   180: astore_3
    //   181: goto -26 -> 155
    //   184: astore 6
    //   186: goto -65 -> 121
    //   189: astore 9
    //   191: goto -105 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	194	0	this	SaxAsyncHttpResponseHandler
    //   0	194	1	paramHttpEntity	org.apache.http.HttpEntity
    //   10	146	2	localInputStream	java.io.InputStream
    //   151	19	3	localObject1	java.lang.Object
    //   180	1	3	localObject2	java.lang.Object
    //   47	118	4	localInputStreamReader	java.io.InputStreamReader
    //   175	1	5	localIOException1	java.io.IOException
    //   116	10	6	localParserConfigurationException1	javax.xml.parsers.ParserConfigurationException
    //   184	1	6	localParserConfigurationException2	javax.xml.parsers.ParserConfigurationException
    //   147	1	8	localIOException2	java.io.IOException
    //   81	10	9	localSAXException1	org.xml.sax.SAXException
    //   189	1	9	localSAXException2	org.xml.sax.SAXException
    //   112	1	11	localIOException3	java.io.IOException
    //   24	26	12	localXMLReader	org.xml.sax.XMLReader
    //   171	1	13	localIOException4	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   15	49	81	org/xml/sax/SAXException
    //   105	110	112	java/io/IOException
    //   15	49	116	javax/xml/parsers/ParserConfigurationException
    //   140	145	147	java/io/IOException
    //   15	49	151	finally
    //   74	79	171	java/io/IOException
    //   164	169	175	java/io/IOException
    //   49	65	180	finally
    //   86	96	180	finally
    //   121	131	180	finally
    //   49	65	184	javax/xml/parsers/ParserConfigurationException
    //   49	65	189	org/xml/sax/SAXException
  }
  
  public abstract void onFailure(int paramInt, Header[] paramArrayOfHeader, T paramT);
  
  public void onFailure(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfByte, Throwable paramThrowable)
  {
    onSuccess(paramInt, paramArrayOfHeader, this.handler);
  }
  
  public abstract void onSuccess(int paramInt, Header[] paramArrayOfHeader, T paramT);
  
  public void onSuccess(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfByte)
  {
    onSuccess(paramInt, paramArrayOfHeader, this.handler);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.loopj.android.http.SaxAsyncHttpResponseHandler
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */