package com.loopj.android.http;

import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.zip.GZIPInputStream;
import org.apache.http.HttpEntity;
import org.apache.http.entity.HttpEntityWrapper;

class AsyncHttpClient$InflatingEntity
  extends HttpEntityWrapper
{
  GZIPInputStream gzippedStream;
  PushbackInputStream pushbackStream;
  InputStream wrappedStream;
  
  public AsyncHttpClient$InflatingEntity(HttpEntity paramHttpEntity)
  {
    super(paramHttpEntity);
  }
  
  public void consumeContent()
  {
    AsyncHttpClient.silentCloseInputStream(this.wrappedStream);
    AsyncHttpClient.silentCloseInputStream(this.pushbackStream);
    AsyncHttpClient.silentCloseInputStream(this.gzippedStream);
    super.consumeContent();
  }
  
  public InputStream getContent()
  {
    this.wrappedStream = this.wrappedEntity.getContent();
    this.pushbackStream = new PushbackInputStream(this.wrappedStream, 2);
    if (AsyncHttpClient.isInputStreamGZIPCompressed(this.pushbackStream))
    {
      this.gzippedStream = new GZIPInputStream(this.pushbackStream);
      return this.gzippedStream;
    }
    return this.pushbackStream;
  }
  
  public long getContentLength()
  {
    if (this.wrappedEntity == null) {
      return 0L;
    }
    return this.wrappedEntity.getContentLength();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.loopj.android.http.AsyncHttpClient.InflatingEntity
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */