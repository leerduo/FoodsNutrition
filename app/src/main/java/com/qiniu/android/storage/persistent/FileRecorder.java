package com.qiniu.android.storage.persistent;

import com.qiniu.android.storage.Recorder;
import com.qiniu.android.utils.UrlSafeBase64;
import java.io.File;
import java.io.IOException;

public final class FileRecorder
  implements Recorder
{
  public String directory;
  
  public FileRecorder(String paramString)
  {
    this.directory = paramString;
    File localFile = new File(paramString);
    if (!localFile.exists())
    {
      if (!localFile.mkdirs()) {
        throw new IOException("mkdir failed");
      }
    }
    else if (!localFile.isDirectory()) {
      throw new IOException("does not mkdir");
    }
  }
  
  public void del(String paramString)
  {
    new File(this.directory, UrlSafeBase64.encodeToString(paramString)).delete();
  }
  
  /* Error */
  public byte[] get(String paramString)
  {
    // Byte code:
    //   0: new 17	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: getfield 15	com/qiniu/android/storage/persistent/FileRecorder:directory	Ljava/lang/String;
    //   8: aload_1
    //   9: invokestatic 43	com/qiniu/android/utils/UrlSafeBase64:encodeToString	(Ljava/lang/String;)Ljava/lang/String;
    //   12: invokespecial 46	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   15: astore_2
    //   16: aload_2
    //   17: invokevirtual 55	java/io/File:length	()J
    //   20: l2i
    //   21: newarray byte
    //   23: astore_3
    //   24: new 57	java/io/FileInputStream
    //   27: dup
    //   28: aload_2
    //   29: invokespecial 60	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   32: astore 4
    //   34: aload 4
    //   36: aload_3
    //   37: invokevirtual 64	java/io/FileInputStream:read	([B)I
    //   40: istore 8
    //   42: iload 8
    //   44: istore 6
    //   46: aload 4
    //   48: ifnull +8 -> 56
    //   51: aload 4
    //   53: invokevirtual 67	java/io/FileInputStream:close	()V
    //   56: iload 6
    //   58: ifne +31 -> 89
    //   61: aconst_null
    //   62: areturn
    //   63: astore 5
    //   65: aconst_null
    //   66: astore 4
    //   68: aload 5
    //   70: invokevirtual 70	java/io/IOException:printStackTrace	()V
    //   73: iconst_0
    //   74: istore 6
    //   76: goto -30 -> 46
    //   79: astore 7
    //   81: aload 7
    //   83: invokevirtual 70	java/io/IOException:printStackTrace	()V
    //   86: goto -30 -> 56
    //   89: aload_3
    //   90: areturn
    //   91: astore 5
    //   93: goto -25 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	FileRecorder
    //   0	96	1	paramString	String
    //   15	14	2	localFile	File
    //   23	67	3	arrayOfByte	byte[]
    //   32	35	4	localFileInputStream	java.io.FileInputStream
    //   63	6	5	localIOException1	IOException
    //   91	1	5	localIOException2	IOException
    //   44	31	6	i	int
    //   79	3	7	localIOException3	IOException
    //   40	3	8	j	int
    // Exception table:
    //   from	to	target	type
    //   24	34	63	java/io/IOException
    //   51	56	79	java/io/IOException
    //   34	42	91	java/io/IOException
  }
  
  /* Error */
  public void set(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 17	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: getfield 15	com/qiniu/android/storage/persistent/FileRecorder:directory	Ljava/lang/String;
    //   8: aload_1
    //   9: invokestatic 43	com/qiniu/android/utils/UrlSafeBase64:encodeToString	(Ljava/lang/String;)Ljava/lang/String;
    //   12: invokespecial 46	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   15: astore_3
    //   16: new 74	java/io/FileOutputStream
    //   19: dup
    //   20: aload_3
    //   21: invokespecial 75	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   24: astore 4
    //   26: aload 4
    //   28: aload_2
    //   29: invokevirtual 79	java/io/FileOutputStream:write	([B)V
    //   32: aload 4
    //   34: ifnull +8 -> 42
    //   37: aload 4
    //   39: invokevirtual 80	java/io/FileOutputStream:close	()V
    //   42: return
    //   43: astore 5
    //   45: aconst_null
    //   46: astore 4
    //   48: aload 5
    //   50: invokevirtual 70	java/io/IOException:printStackTrace	()V
    //   53: goto -21 -> 32
    //   56: astore 6
    //   58: aload 6
    //   60: invokevirtual 70	java/io/IOException:printStackTrace	()V
    //   63: return
    //   64: astore 5
    //   66: goto -18 -> 48
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	this	FileRecorder
    //   0	69	1	paramString	String
    //   0	69	2	paramArrayOfByte	byte[]
    //   15	6	3	localFile	File
    //   24	23	4	localFileOutputStream	java.io.FileOutputStream
    //   43	6	5	localIOException1	IOException
    //   64	1	5	localIOException2	IOException
    //   56	3	6	localIOException3	IOException
    // Exception table:
    //   from	to	target	type
    //   16	26	43	java/io/IOException
    //   37	42	56	java/io/IOException
    //   26	32	64	java/io/IOException
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.qiniu.android.storage.persistent.FileRecorder
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */