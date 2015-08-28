package com.google.zxing.client.android.encode;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.android.Contents;
import com.google.zxing.client.android.R.string;
import com.google.zxing.client.result.AddressBookParsedResult;
import com.google.zxing.common.BitMatrix;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

final class QRCodeEncoder
{
  private static final String a = QRCodeEncoder.class.getSimpleName();
  private final Context b;
  private String c;
  private String d;
  private String e;
  private BarcodeFormat f;
  private final int g;
  private final boolean h;
  
  QRCodeEncoder(Context paramContext, Intent paramIntent, int paramInt, boolean paramBoolean)
  {
    this.b = paramContext;
    this.g = paramInt;
    this.h = paramBoolean;
    String str = paramIntent.getAction();
    if (str.equals("com.google.zxing.client.android.ENCODE")) {
      a(paramIntent);
    }
    while (!str.equals("android.intent.action.SEND")) {
      return;
    }
    b(paramIntent);
  }
  
  private static String a(CharSequence paramCharSequence)
  {
    for (int i = 0; i < paramCharSequence.length(); i++) {
      if (paramCharSequence.charAt(i) > 'ÿ') {
        return "UTF-8";
      }
    }
    return null;
  }
  
  private static List<String> a(Bundle paramBundle, String[] paramArrayOfString)
  {
    ArrayList localArrayList = new ArrayList(paramArrayOfString.length);
    int i = paramArrayOfString.length;
    int j = 0;
    if (j < i)
    {
      Object localObject1 = paramBundle.get(paramArrayOfString[j]);
      if (localObject1 == null) {}
      for (Object localObject2 = null;; localObject2 = localObject1.toString())
      {
        localArrayList.add(localObject2);
        j++;
        break;
      }
    }
    return localArrayList;
  }
  
  private static List<String> a(String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {
      return null;
    }
    return Arrays.asList(paramArrayOfString);
  }
  
  private void a(Intent paramIntent, String paramString)
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    default: 
      switch (i)
      {
      }
      break;
    }
    label513:
    label618:
    float f1;
    float f2;
    do
    {
      Bundle localBundle1;
      do
      {
        Bundle localBundle2;
        do
        {
          String str6;
          do
          {
            String str7;
            do
            {
              String str8;
              do
              {
                String str9;
                do
                {
                  return;
                  if (!paramString.equals("TEXT_TYPE")) {
                    break;
                  }
                  i = 0;
                  break;
                  if (!paramString.equals("EMAIL_TYPE")) {
                    break;
                  }
                  i = 1;
                  break;
                  if (!paramString.equals("PHONE_TYPE")) {
                    break;
                  }
                  i = 2;
                  break;
                  if (!paramString.equals("SMS_TYPE")) {
                    break;
                  }
                  i = 3;
                  break;
                  if (!paramString.equals("CONTACT_TYPE")) {
                    break;
                  }
                  i = 4;
                  break;
                  if (!paramString.equals("LOCATION_TYPE")) {
                    break;
                  }
                  i = 5;
                  break;
                  str9 = paramIntent.getStringExtra("ENCODE_DATA");
                } while ((str9 == null) || (str9.isEmpty()));
                this.c = str9;
                this.d = str9;
                this.e = this.b.getString(R.string.zxing_contents_text);
                return;
                str8 = ContactEncoder.a(paramIntent.getStringExtra("ENCODE_DATA"));
              } while (str8 == null);
              this.c = ("mailto:" + str8);
              this.d = str8;
              this.e = this.b.getString(R.string.zxing_contents_email);
              return;
              str7 = ContactEncoder.a(paramIntent.getStringExtra("ENCODE_DATA"));
            } while (str7 == null);
            this.c = ("tel:" + str7);
            this.d = PhoneNumberUtils.formatNumber(str7);
            this.e = this.b.getString(R.string.zxing_contents_phone);
            return;
            str6 = ContactEncoder.a(paramIntent.getStringExtra("ENCODE_DATA"));
          } while (str6 == null);
          this.c = ("sms:" + str6);
          this.d = PhoneNumberUtils.formatNumber(str6);
          this.e = this.b.getString(R.string.zxing_contents_sms);
          return;
          localBundle2 = paramIntent.getBundleExtra("ENCODE_DATA");
        } while (localBundle2 == null);
        String str1 = localBundle2.getString("name");
        String str2 = localBundle2.getString("company");
        String str3 = localBundle2.getString("postal");
        List localList1 = a(localBundle2, Contents.a);
        List localList2 = a(localBundle2, Contents.b);
        List localList3 = a(localBundle2, Contents.c);
        String str4 = localBundle2.getString("URL_KEY");
        List localList4;
        String str5;
        if (str4 == null)
        {
          localList4 = null;
          str5 = localBundle2.getString("NOTE_KEY");
          if (!this.h) {
            break label618;
          }
        }
        for (Object localObject = new VCardContactEncoder();; localObject = new MECARDContactEncoder())
        {
          String[] arrayOfString = ((ContactEncoder)localObject).a(Collections.singletonList(str1), str2, Collections.singletonList(str3), localList1, localList2, localList3, localList4, str5);
          if (arrayOfString[1].isEmpty()) {
            break;
          }
          this.c = arrayOfString[0];
          this.d = arrayOfString[1];
          this.e = this.b.getString(R.string.zxing_contents_contact);
          return;
          localList4 = Collections.singletonList(str4);
          break label513;
        }
        localBundle1 = paramIntent.getBundleExtra("ENCODE_DATA");
      } while (localBundle1 == null);
      f1 = localBundle1.getFloat("LAT", 3.4028235E+38F);
      f2 = localBundle1.getFloat("LONG", 3.4028235E+38F);
    } while ((f1 == 3.4028235E+38F) || (f2 == 3.4028235E+38F));
    this.c = ("geo:" + f1 + ',' + f2);
    this.d = (f1 + "," + f2);
    this.e = this.b.getString(R.string.zxing_contents_location);
  }
  
  private void a(AddressBookParsedResult paramAddressBookParsedResult)
  {
    if (this.h) {}
    for (Object localObject = new VCardContactEncoder();; localObject = new MECARDContactEncoder())
    {
      String[] arrayOfString = ((ContactEncoder)localObject).a(a(paramAddressBookParsedResult.a()), paramAddressBookParsedResult.e(), a(paramAddressBookParsedResult.d()), a(paramAddressBookParsedResult.b()), null, a(paramAddressBookParsedResult.c()), a(paramAddressBookParsedResult.f()), null);
      if (!arrayOfString[1].isEmpty())
      {
        this.c = arrayOfString[0];
        this.d = arrayOfString[1];
        this.e = this.b.getString(R.string.zxing_contents_contact);
      }
      return;
    }
  }
  
  /* Error */
  private boolean a(Intent paramIntent)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc_w 262
    //   4: invokevirtual 120	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   7: astore_2
    //   8: aload_0
    //   9: aconst_null
    //   10: putfield 264	com/google/zxing/client/android/encode/QRCodeEncoder:f	Lcom/google/zxing/BarcodeFormat;
    //   13: aload_2
    //   14: ifnull +11 -> 25
    //   17: aload_0
    //   18: aload_2
    //   19: invokestatic 270	com/google/zxing/BarcodeFormat:valueOf	(Ljava/lang/String;)Lcom/google/zxing/BarcodeFormat;
    //   22: putfield 264	com/google/zxing/client/android/encode/QRCodeEncoder:f	Lcom/google/zxing/BarcodeFormat;
    //   25: aload_0
    //   26: getfield 264	com/google/zxing/client/android/encode/QRCodeEncoder:f	Lcom/google/zxing/BarcodeFormat;
    //   29: ifnull +13 -> 42
    //   32: aload_0
    //   33: getfield 264	com/google/zxing/client/android/encode/QRCodeEncoder:f	Lcom/google/zxing/BarcodeFormat;
    //   36: getstatic 273	com/google/zxing/BarcodeFormat:l	Lcom/google/zxing/BarcodeFormat;
    //   39: if_acmpne +56 -> 95
    //   42: aload_1
    //   43: ldc_w 275
    //   46: invokevirtual 120	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   49: astore_3
    //   50: aload_3
    //   51: ifnull +10 -> 61
    //   54: aload_3
    //   55: invokevirtual 124	java/lang/String:isEmpty	()Z
    //   58: ifeq +5 -> 63
    //   61: iconst_0
    //   62: ireturn
    //   63: aload_0
    //   64: getstatic 273	com/google/zxing/BarcodeFormat:l	Lcom/google/zxing/BarcodeFormat;
    //   67: putfield 264	com/google/zxing/client/android/encode/QRCodeEncoder:f	Lcom/google/zxing/BarcodeFormat;
    //   70: aload_0
    //   71: aload_1
    //   72: aload_3
    //   73: invokespecial 277	com/google/zxing/client/android/encode/QRCodeEncoder:a	(Landroid/content/Intent;Ljava/lang/String;)V
    //   76: aload_0
    //   77: getfield 126	com/google/zxing/client/android/encode/QRCodeEncoder:c	Ljava/lang/String;
    //   80: ifnull -19 -> 61
    //   83: aload_0
    //   84: getfield 126	com/google/zxing/client/android/encode/QRCodeEncoder:c	Ljava/lang/String;
    //   87: invokevirtual 124	java/lang/String:isEmpty	()Z
    //   90: ifne -29 -> 61
    //   93: iconst_1
    //   94: ireturn
    //   95: aload_1
    //   96: ldc 116
    //   98: invokevirtual 120	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   101: astore 4
    //   103: aload 4
    //   105: ifnull -29 -> 76
    //   108: aload 4
    //   110: invokevirtual 124	java/lang/String:isEmpty	()Z
    //   113: ifne -37 -> 76
    //   116: aload_0
    //   117: aload 4
    //   119: putfield 126	com/google/zxing/client/android/encode/QRCodeEncoder:c	Ljava/lang/String;
    //   122: aload_0
    //   123: aload 4
    //   125: putfield 128	com/google/zxing/client/android/encode/QRCodeEncoder:d	Ljava/lang/String;
    //   128: aload_0
    //   129: aload_0
    //   130: getfield 33	com/google/zxing/client/android/encode/QRCodeEncoder:b	Landroid/content/Context;
    //   133: getstatic 133	com/google/zxing/client/android/R$string:zxing_contents_text	I
    //   136: invokevirtual 139	android/content/Context:getString	(I)Ljava/lang/String;
    //   139: putfield 141	com/google/zxing/client/android/encode/QRCodeEncoder:e	Ljava/lang/String;
    //   142: goto -66 -> 76
    //   145: astore 5
    //   147: goto -122 -> 25
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	150	0	this	QRCodeEncoder
    //   0	150	1	paramIntent	Intent
    //   7	12	2	str1	String
    //   49	24	3	str2	String
    //   101	23	4	str3	String
    //   145	1	5	localIllegalArgumentException	IllegalArgumentException
    // Exception table:
    //   from	to	target	type
    //   17	25	145	java/lang/IllegalArgumentException
  }
  
  private void b(Intent paramIntent)
  {
    if (paramIntent.hasExtra("android.intent.extra.STREAM"))
    {
      d(paramIntent);
      return;
    }
    c(paramIntent);
  }
  
  private void c(Intent paramIntent)
  {
    String str = ContactEncoder.a(paramIntent.getStringExtra("android.intent.extra.TEXT"));
    String[] arrayOfString;
    if (str == null)
    {
      str = ContactEncoder.a(paramIntent.getStringExtra("android.intent.extra.HTML_TEXT"));
      if (str == null)
      {
        str = ContactEncoder.a(paramIntent.getStringExtra("android.intent.extra.SUBJECT"));
        if (str == null)
        {
          arrayOfString = paramIntent.getStringArrayExtra("android.intent.extra.EMAIL");
          if (arrayOfString == null) {
            break label86;
          }
        }
      }
    }
    label86:
    for (str = ContactEncoder.a(arrayOfString[0]); (str == null) || (str.isEmpty()); str = "?") {
      throw new WriterException("Empty EXTRA_TEXT");
    }
    this.c = str;
    this.f = BarcodeFormat.l;
    if (paramIntent.hasExtra("android.intent.extra.SUBJECT")) {
      this.d = paramIntent.getStringExtra("android.intent.extra.SUBJECT");
    }
    for (;;)
    {
      this.e = this.b.getString(R.string.zxing_contents_text);
      return;
      if (paramIntent.hasExtra("android.intent.extra.TITLE")) {
        this.d = paramIntent.getStringExtra("android.intent.extra.TITLE");
      } else {
        this.d = this.c;
      }
    }
  }
  
  /* Error */
  private void d(Intent paramIntent)
  {
    // Byte code:
    //   0: aload_0
    //   1: getstatic 273	com/google/zxing/BarcodeFormat:l	Lcom/google/zxing/BarcodeFormat;
    //   4: putfield 264	com/google/zxing/client/android/encode/QRCodeEncoder:f	Lcom/google/zxing/BarcodeFormat;
    //   7: aload_1
    //   8: invokevirtual 316	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   11: astore_2
    //   12: aload_2
    //   13: ifnonnull +14 -> 27
    //   16: new 301	com/google/zxing/WriterException
    //   19: dup
    //   20: ldc_w 318
    //   23: invokespecial 306	com/google/zxing/WriterException:<init>	(Ljava/lang/String;)V
    //   26: athrow
    //   27: aload_2
    //   28: ldc_w 279
    //   31: invokevirtual 322	android/os/Bundle:getParcelable	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   34: checkcast 324	android/net/Uri
    //   37: astore_3
    //   38: aload_3
    //   39: ifnonnull +14 -> 53
    //   42: new 301	com/google/zxing/WriterException
    //   45: dup
    //   46: ldc_w 326
    //   49: invokespecial 306	com/google/zxing/WriterException:<init>	(Ljava/lang/String;)V
    //   52: athrow
    //   53: aload_0
    //   54: getfield 33	com/google/zxing/client/android/encode/QRCodeEncoder:b	Landroid/content/Context;
    //   57: invokevirtual 330	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   60: aload_3
    //   61: invokevirtual 336	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   64: astore 8
    //   66: aload 8
    //   68: astore 5
    //   70: new 338	java/io/ByteArrayOutputStream
    //   73: dup
    //   74: invokespecial 339	java/io/ByteArrayOutputStream:<init>	()V
    //   77: astore 9
    //   79: sipush 2048
    //   82: newarray byte
    //   84: astore 10
    //   86: aload 5
    //   88: aload 10
    //   90: invokevirtual 345	java/io/InputStream:read	([B)I
    //   93: istore 11
    //   95: iload 11
    //   97: ifle +43 -> 140
    //   100: aload 9
    //   102: aload 10
    //   104: iconst_0
    //   105: iload 11
    //   107: invokevirtual 349	java/io/ByteArrayOutputStream:write	([BII)V
    //   110: goto -24 -> 86
    //   113: astore 4
    //   115: new 301	com/google/zxing/WriterException
    //   118: dup
    //   119: aload 4
    //   121: invokespecial 352	com/google/zxing/WriterException:<init>	(Ljava/lang/Throwable;)V
    //   124: athrow
    //   125: astore 6
    //   127: aload 5
    //   129: ifnull +8 -> 137
    //   132: aload 5
    //   134: invokevirtual 355	java/io/InputStream:close	()V
    //   137: aload 6
    //   139: athrow
    //   140: aload 9
    //   142: invokevirtual 359	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   145: astore 12
    //   147: new 46	java/lang/String
    //   150: dup
    //   151: aload 12
    //   153: iconst_0
    //   154: aload 12
    //   156: arraylength
    //   157: ldc 71
    //   159: invokespecial 362	java/lang/String:<init>	([BIILjava/lang/String;)V
    //   162: astore 13
    //   164: aload 5
    //   166: ifnull +8 -> 174
    //   169: aload 5
    //   171: invokevirtual 355	java/io/InputStream:close	()V
    //   174: getstatic 27	com/google/zxing/client/android/encode/QRCodeEncoder:a	Ljava/lang/String;
    //   177: ldc_w 364
    //   180: invokestatic 369	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   183: pop
    //   184: getstatic 27	com/google/zxing/client/android/encode/QRCodeEncoder:a	Ljava/lang/String;
    //   187: aload 13
    //   189: invokestatic 369	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   192: pop
    //   193: new 371	com/google/zxing/Result
    //   196: dup
    //   197: aload 13
    //   199: aload 12
    //   201: aconst_null
    //   202: getstatic 273	com/google/zxing/BarcodeFormat:l	Lcom/google/zxing/BarcodeFormat;
    //   205: invokespecial 374	com/google/zxing/Result:<init>	(Ljava/lang/String;[B[Lcom/google/zxing/ResultPoint;Lcom/google/zxing/BarcodeFormat;)V
    //   208: invokestatic 379	com/google/zxing/client/result/ResultParser:d	(Lcom/google/zxing/Result;)Lcom/google/zxing/client/result/ParsedResult;
    //   211: astore 16
    //   213: aload 16
    //   215: instanceof 243
    //   218: ifne +14 -> 232
    //   221: new 301	com/google/zxing/WriterException
    //   224: dup
    //   225: ldc_w 381
    //   228: invokespecial 306	com/google/zxing/WriterException:<init>	(Ljava/lang/String;)V
    //   231: athrow
    //   232: aload_0
    //   233: aload 16
    //   235: checkcast 243	com/google/zxing/client/result/AddressBookParsedResult
    //   238: invokespecial 383	com/google/zxing/client/android/encode/QRCodeEncoder:a	(Lcom/google/zxing/client/result/AddressBookParsedResult;)V
    //   241: aload_0
    //   242: getfield 126	com/google/zxing/client/android/encode/QRCodeEncoder:c	Ljava/lang/String;
    //   245: ifnull +13 -> 258
    //   248: aload_0
    //   249: getfield 126	com/google/zxing/client/android/encode/QRCodeEncoder:c	Ljava/lang/String;
    //   252: invokevirtual 124	java/lang/String:isEmpty	()Z
    //   255: ifeq +24 -> 279
    //   258: new 301	com/google/zxing/WriterException
    //   261: dup
    //   262: ldc_w 385
    //   265: invokespecial 306	com/google/zxing/WriterException:<init>	(Ljava/lang/String;)V
    //   268: athrow
    //   269: astore 17
    //   271: goto -97 -> 174
    //   274: astore 7
    //   276: goto -139 -> 137
    //   279: return
    //   280: astore 6
    //   282: aconst_null
    //   283: astore 5
    //   285: goto -158 -> 127
    //   288: astore 4
    //   290: aconst_null
    //   291: astore 5
    //   293: goto -178 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	296	0	this	QRCodeEncoder
    //   0	296	1	paramIntent	Intent
    //   11	17	2	localBundle	Bundle
    //   37	24	3	localUri	android.net.Uri
    //   113	7	4	localIOException1	java.io.IOException
    //   288	1	4	localIOException2	java.io.IOException
    //   68	224	5	localInputStream1	java.io.InputStream
    //   125	13	6	localObject1	Object
    //   280	1	6	localObject2	Object
    //   274	1	7	localIOException3	java.io.IOException
    //   64	3	8	localInputStream2	java.io.InputStream
    //   77	64	9	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   84	19	10	arrayOfByte1	byte[]
    //   93	13	11	i	int
    //   145	55	12	arrayOfByte2	byte[]
    //   162	36	13	str	String
    //   211	23	16	localParsedResult	com.google.zxing.client.result.ParsedResult
    //   269	1	17	localIOException4	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   70	86	113	java/io/IOException
    //   86	95	113	java/io/IOException
    //   100	110	113	java/io/IOException
    //   140	164	113	java/io/IOException
    //   70	86	125	finally
    //   86	95	125	finally
    //   100	110	125	finally
    //   115	125	125	finally
    //   140	164	125	finally
    //   169	174	269	java/io/IOException
    //   132	137	274	java/io/IOException
    //   53	66	280	finally
    //   53	66	288	java/io/IOException
  }
  
  String a()
  {
    return this.c;
  }
  
  String b()
  {
    return this.d;
  }
  
  String c()
  {
    return this.e;
  }
  
  boolean d()
  {
    return this.h;
  }
  
  Bitmap e()
  {
    String str1 = this.c;
    if (str1 == null) {
      return null;
    }
    String str2 = a(str1);
    EnumMap localEnumMap;
    if (str2 != null)
    {
      localEnumMap = new EnumMap(EncodeHintType.class);
      localEnumMap.put(EncodeHintType.b, str2);
    }
    for (;;)
    {
      int i;
      int j;
      int[] arrayOfInt;
      int k;
      try
      {
        BitMatrix localBitMatrix = new MultiFormatWriter().a(str1, this.f, this.g, this.g, localEnumMap);
        i = localBitMatrix.f();
        j = localBitMatrix.g();
        arrayOfInt = new int[i * j];
        k = 0;
        if (k >= j) {
          break label171;
        }
        int m = k * i;
        int n = 0;
        if (n >= i) {
          break label165;
        }
        int i1 = m + n;
        if (localBitMatrix.a(n, k))
        {
          i2 = -16777216;
          arrayOfInt[i1] = i2;
          n++;
          continue;
        }
        int i2 = -1;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        return null;
      }
      continue;
      label165:
      k++;
      continue;
      label171:
      Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      localBitmap.setPixels(arrayOfInt, 0, i, 0, 0, i, j);
      return localBitmap;
      localEnumMap = null;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.android.encode.QRCodeEncoder
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */