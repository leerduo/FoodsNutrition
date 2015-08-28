package com.loopj.android.http;

import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;

class SimpleMultipartEntity
  implements HttpEntity
{
  private static final byte[] CR_LF = "\r\n".getBytes();
  private static final String LOG_TAG = "SimpleMultipartEntity";
  private static final char[] MULTIPART_CHARS = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
  private static final String STR_CR_LF = "\r\n";
  private static final byte[] TRANSFER_ENCODING_BINARY = "Content-Transfer-Encoding: binary\r\n".getBytes();
  private final String boundary;
  private final byte[] boundaryEnd;
  private final byte[] boundaryLine;
  private int bytesWritten;
  private final List<SimpleMultipartEntity.FilePart> fileParts = new ArrayList();
  private boolean isRepeatable;
  private final ByteArrayOutputStream out = new ByteArrayOutputStream();
  private final ResponseHandlerInterface progressHandler;
  private int totalSize;
  
  public SimpleMultipartEntity(ResponseHandlerInterface paramResponseHandlerInterface)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Random localRandom = new Random();
    for (int i = 0; i < 30; i++) {
      localStringBuilder.append(MULTIPART_CHARS[localRandom.nextInt(MULTIPART_CHARS.length)]);
    }
    this.boundary = localStringBuilder.toString();
    this.boundaryLine = ("--" + this.boundary + "\r\n").getBytes();
    this.boundaryEnd = ("--" + this.boundary + "--" + "\r\n").getBytes();
    this.progressHandler = paramResponseHandlerInterface;
  }
  
  private byte[] createContentDisposition(String paramString)
  {
    return ("Content-Disposition: form-data; name=\"" + paramString + "\"" + "\r\n").getBytes();
  }
  
  private byte[] createContentDisposition(String paramString1, String paramString2)
  {
    return ("Content-Disposition: form-data; name=\"" + paramString1 + "\"" + "; filename=\"" + paramString2 + "\"" + "\r\n").getBytes();
  }
  
  private byte[] createContentType(String paramString)
  {
    return ("Content-Type: " + normalizeContentType(paramString) + "\r\n").getBytes();
  }
  
  private String normalizeContentType(String paramString)
  {
    if (paramString == null) {
      paramString = "application/octet-stream";
    }
    return paramString;
  }
  
  private void updateProgress(int paramInt)
  {
    this.bytesWritten = (paramInt + this.bytesWritten);
    this.progressHandler.sendProgressMessage(this.bytesWritten, this.totalSize);
  }
  
  public void addPart(String paramString, File paramFile)
  {
    addPart(paramString, paramFile, null);
  }
  
  public void addPart(String paramString1, File paramFile, String paramString2)
  {
    this.fileParts.add(new SimpleMultipartEntity.FilePart(this, paramString1, paramFile, normalizeContentType(paramString2)));
  }
  
  public void addPart(String paramString1, File paramFile, String paramString2, String paramString3)
  {
    this.fileParts.add(new SimpleMultipartEntity.FilePart(this, paramString1, paramFile, normalizeContentType(paramString2), paramString3));
  }
  
  public void addPart(String paramString1, String paramString2)
  {
    addPartWithCharset(paramString1, paramString2, null);
  }
  
  public void addPart(String paramString1, String paramString2, InputStream paramInputStream, String paramString3)
  {
    this.out.write(this.boundaryLine);
    this.out.write(createContentDisposition(paramString1, paramString2));
    this.out.write(createContentType(paramString3));
    this.out.write(TRANSFER_ENCODING_BINARY);
    this.out.write(CR_LF);
    byte[] arrayOfByte = new byte[4096];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      this.out.write(arrayOfByte, 0, i);
    }
    this.out.write(CR_LF);
    this.out.flush();
    AsyncHttpClient.silentCloseOutputStream(this.out);
  }
  
  public void addPart(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      this.out.write(this.boundaryLine);
      this.out.write(createContentDisposition(paramString1));
      this.out.write(createContentType(paramString3));
      this.out.write(CR_LF);
      this.out.write(paramString2.getBytes());
      this.out.write(CR_LF);
      return;
    }
    catch (IOException localIOException)
    {
      Log.e("SimpleMultipartEntity", "addPart ByteArrayOutputStream exception", localIOException);
    }
  }
  
  public void addPartWithCharset(String paramString1, String paramString2, String paramString3)
  {
    if (paramString3 == null) {
      paramString3 = "UTF-8";
    }
    addPart(paramString1, paramString2, "text/plain; charset=" + paramString3);
  }
  
  public void consumeContent()
  {
    if (isStreaming()) {
      throw new UnsupportedOperationException("Streaming entity does not implement #consumeContent()");
    }
  }
  
  public InputStream getContent()
  {
    throw new UnsupportedOperationException("getContent() is not supported. Use writeTo() instead.");
  }
  
  public Header getContentEncoding()
  {
    return null;
  }
  
  public long getContentLength()
  {
    long l1 = this.out.size();
    Iterator localIterator = this.fileParts.iterator();
    long l3;
    for (long l2 = l1; localIterator.hasNext(); l2 = l3 + l2)
    {
      l3 = ((SimpleMultipartEntity.FilePart)localIterator.next()).getTotalLength();
      if (l3 < 0L) {
        return -1L;
      }
    }
    return l2 + this.boundaryEnd.length;
  }
  
  public Header getContentType()
  {
    return new BasicHeader("Content-Type", "multipart/form-data; boundary=" + this.boundary);
  }
  
  public boolean isChunked()
  {
    return false;
  }
  
  public boolean isRepeatable()
  {
    return this.isRepeatable;
  }
  
  public boolean isStreaming()
  {
    return false;
  }
  
  public void setIsRepeatable(boolean paramBoolean)
  {
    this.isRepeatable = paramBoolean;
  }
  
  public void writeTo(OutputStream paramOutputStream)
  {
    this.bytesWritten = 0;
    this.totalSize = ((int)getContentLength());
    this.out.writeTo(paramOutputStream);
    updateProgress(this.out.size());
    Iterator localIterator = this.fileParts.iterator();
    while (localIterator.hasNext()) {
      ((SimpleMultipartEntity.FilePart)localIterator.next()).writeTo(paramOutputStream);
    }
    paramOutputStream.write(this.boundaryEnd);
    updateProgress(this.boundaryEnd.length);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.loopj.android.http.SimpleMultipartEntity
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */