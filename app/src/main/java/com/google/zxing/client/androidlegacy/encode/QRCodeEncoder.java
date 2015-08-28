package com.google.zxing.client.androidlegacy.encode;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.util.Log;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.androidlegacy.Contents;
import com.google.zxing.client.androidlegacy.R.string;
import com.google.zxing.client.result.AddressBookParsedResult;
import com.google.zxing.client.result.ParsedResult;
import com.google.zxing.client.result.ResultParser;
import com.google.zxing.common.BitMatrix;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

final class QRCodeEncoder
{
  private static final String a = QRCodeEncoder.class.getSimpleName();
  private final Activity b;
  private String c;
  private String d;
  private String e;
  private BarcodeFormat f;
  private final int g;
  private final boolean h;
  
  QRCodeEncoder(Activity paramActivity, Intent paramIntent, int paramInt, boolean paramBoolean)
  {
    this.b = paramActivity;
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
  
  private static Iterable<String> a(String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {
      return null;
    }
    return Arrays.asList(paramArrayOfString);
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
  
  private void a(Intent paramIntent, String paramString)
  {
    if (paramString.equals("TEXT_TYPE"))
    {
      String str9 = paramIntent.getStringExtra("ENCODE_DATA");
      if ((str9 != null) && (str9.length() > 0))
      {
        this.c = str9;
        this.d = str9;
        this.e = this.b.getString(R.string.zxinglegacy_contents_text);
      }
    }
    label439:
    float f1;
    label542:
    float f2;
    do
    {
      Bundle localBundle1;
      do
      {
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
                  return;
                  if (!paramString.equals("EMAIL_TYPE")) {
                    break;
                  }
                  str8 = ContactEncoder.a(paramIntent.getStringExtra("ENCODE_DATA"));
                } while (str8 == null);
                this.c = ("mailto:" + str8);
                this.d = str8;
                this.e = this.b.getString(R.string.zxinglegacy_contents_email);
                return;
                if (!paramString.equals("PHONE_TYPE")) {
                  break;
                }
                str7 = ContactEncoder.a(paramIntent.getStringExtra("ENCODE_DATA"));
              } while (str7 == null);
              this.c = ("tel:" + str7);
              this.d = PhoneNumberUtils.formatNumber(str7);
              this.e = this.b.getString(R.string.zxinglegacy_contents_phone);
              return;
              if (!paramString.equals("SMS_TYPE")) {
                break;
              }
              str6 = ContactEncoder.a(paramIntent.getStringExtra("ENCODE_DATA"));
            } while (str6 == null);
            this.c = ("sms:" + str6);
            this.d = PhoneNumberUtils.formatNumber(str6);
            this.e = this.b.getString(R.string.zxinglegacy_contents_sms);
            return;
            if (!paramString.equals("CONTACT_TYPE")) {
              break;
            }
            localBundle2 = paramIntent.getBundleExtra("ENCODE_DATA");
          } while (localBundle2 == null);
          String str1 = localBundle2.getString("name");
          String str2 = localBundle2.getString("company");
          String str3 = localBundle2.getString("postal");
          ArrayList localArrayList1 = new ArrayList(Contents.a.length);
          for (int i = 0; i < Contents.a.length; i++) {
            localArrayList1.add(localBundle2.getString(Contents.a[i]));
          }
          ArrayList localArrayList2 = new ArrayList(Contents.c.length);
          for (int j = 0; j < Contents.c.length; j++) {
            localArrayList2.add(localBundle2.getString(Contents.c[j]));
          }
          String str4 = localBundle2.getString("URL_KEY");
          Object localObject1;
          String str5;
          if (str4 == null)
          {
            localObject1 = null;
            str5 = localBundle2.getString("NOTE_KEY");
            if (!this.h) {
              break label542;
            }
          }
          for (Object localObject2 = new VCardContactEncoder();; localObject2 = new MECARDContactEncoder())
          {
            String[] arrayOfString = ((ContactEncoder)localObject2).a(Collections.singleton(str1), str2, Collections.singleton(str3), localArrayList1, localArrayList2, (Iterable)localObject1, str5);
            if (arrayOfString[1].length() <= 0) {
              break;
            }
            this.c = arrayOfString[0];
            this.d = arrayOfString[1];
            this.e = this.b.getString(R.string.zxinglegacy_contents_contact);
            return;
            localObject1 = Collections.singletonList(str4);
            break label439;
          }
        } while (!paramString.equals("LOCATION_TYPE"));
        localBundle1 = paramIntent.getBundleExtra("ENCODE_DATA");
      } while (localBundle1 == null);
      f1 = localBundle1.getFloat("LAT", 3.4028235E+38F);
      f2 = localBundle1.getFloat("LONG", 3.4028235E+38F);
    } while ((f1 == 3.4028235E+38F) || (f2 == 3.4028235E+38F));
    this.c = ("geo:" + f1 + ',' + f2);
    this.d = (f1 + "," + f2);
    this.e = this.b.getString(R.string.zxinglegacy_contents_location);
  }
  
  private void a(AddressBookParsedResult paramAddressBookParsedResult)
  {
    if (this.h) {}
    for (Object localObject = new VCardContactEncoder();; localObject = new MECARDContactEncoder())
    {
      String[] arrayOfString = ((ContactEncoder)localObject).a(a(paramAddressBookParsedResult.a()), paramAddressBookParsedResult.e(), a(paramAddressBookParsedResult.d()), a(paramAddressBookParsedResult.b()), a(paramAddressBookParsedResult.c()), a(paramAddressBookParsedResult.f()), null);
      if (arrayOfString[1].length() > 0)
      {
        this.c = arrayOfString[0];
        this.d = arrayOfString[1];
        this.e = this.b.getString(R.string.zxinglegacy_contents_contact);
      }
      return;
    }
  }
  
  /* Error */
  private boolean a(Intent paramIntent)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 250
    //   3: invokevirtual 87	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   6: astore_2
    //   7: aload_0
    //   8: aconst_null
    //   9: putfield 252	com/google/zxing/client/androidlegacy/encode/QRCodeEncoder:f	Lcom/google/zxing/BarcodeFormat;
    //   12: aload_2
    //   13: ifnull +11 -> 24
    //   16: aload_0
    //   17: aload_2
    //   18: invokestatic 258	com/google/zxing/BarcodeFormat:valueOf	(Ljava/lang/String;)Lcom/google/zxing/BarcodeFormat;
    //   21: putfield 252	com/google/zxing/client/androidlegacy/encode/QRCodeEncoder:f	Lcom/google/zxing/BarcodeFormat;
    //   24: aload_0
    //   25: getfield 252	com/google/zxing/client/androidlegacy/encode/QRCodeEncoder:f	Lcom/google/zxing/BarcodeFormat;
    //   28: ifnull +13 -> 41
    //   31: aload_0
    //   32: getfield 252	com/google/zxing/client/androidlegacy/encode/QRCodeEncoder:f	Lcom/google/zxing/BarcodeFormat;
    //   35: getstatic 261	com/google/zxing/BarcodeFormat:l	Lcom/google/zxing/BarcodeFormat;
    //   38: if_acmpne +56 -> 94
    //   41: aload_1
    //   42: ldc_w 263
    //   45: invokevirtual 87	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   48: astore_3
    //   49: aload_3
    //   50: ifnull +10 -> 60
    //   53: aload_3
    //   54: invokevirtual 88	java/lang/String:length	()I
    //   57: ifne +5 -> 62
    //   60: iconst_0
    //   61: ireturn
    //   62: aload_0
    //   63: getstatic 261	com/google/zxing/BarcodeFormat:l	Lcom/google/zxing/BarcodeFormat;
    //   66: putfield 252	com/google/zxing/client/androidlegacy/encode/QRCodeEncoder:f	Lcom/google/zxing/BarcodeFormat;
    //   69: aload_0
    //   70: aload_1
    //   71: aload_3
    //   72: invokespecial 265	com/google/zxing/client/androidlegacy/encode/QRCodeEncoder:a	(Landroid/content/Intent;Ljava/lang/String;)V
    //   75: aload_0
    //   76: getfield 90	com/google/zxing/client/androidlegacy/encode/QRCodeEncoder:c	Ljava/lang/String;
    //   79: ifnull -19 -> 60
    //   82: aload_0
    //   83: getfield 90	com/google/zxing/client/androidlegacy/encode/QRCodeEncoder:c	Ljava/lang/String;
    //   86: invokevirtual 88	java/lang/String:length	()I
    //   89: ifle -29 -> 60
    //   92: iconst_1
    //   93: ireturn
    //   94: aload_1
    //   95: ldc 83
    //   97: invokevirtual 87	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   100: astore 4
    //   102: aload 4
    //   104: ifnull -29 -> 75
    //   107: aload 4
    //   109: invokevirtual 88	java/lang/String:length	()I
    //   112: ifle -37 -> 75
    //   115: aload_0
    //   116: aload 4
    //   118: putfield 90	com/google/zxing/client/androidlegacy/encode/QRCodeEncoder:c	Ljava/lang/String;
    //   121: aload_0
    //   122: aload 4
    //   124: putfield 92	com/google/zxing/client/androidlegacy/encode/QRCodeEncoder:d	Ljava/lang/String;
    //   127: aload_0
    //   128: aload_0
    //   129: getfield 33	com/google/zxing/client/androidlegacy/encode/QRCodeEncoder:b	Landroid/app/Activity;
    //   132: getstatic 97	com/google/zxing/client/androidlegacy/R$string:zxinglegacy_contents_text	I
    //   135: invokevirtual 103	android/app/Activity:getString	(I)Ljava/lang/String;
    //   138: putfield 105	com/google/zxing/client/androidlegacy/encode/QRCodeEncoder:e	Ljava/lang/String;
    //   141: goto -66 -> 75
    //   144: astore 5
    //   146: goto -122 -> 24
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	149	0	this	QRCodeEncoder
    //   0	149	1	paramIntent	Intent
    //   6	12	2	str1	String
    //   48	24	3	str2	String
    //   100	23	4	str3	String
    //   144	1	5	localIllegalArgumentException	IllegalArgumentException
    // Exception table:
    //   from	to	target	type
    //   16	24	144	java/lang/IllegalArgumentException
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
    for (str = ContactEncoder.a(arrayOfString[0]); (str == null) || (str.length() == 0); str = "?") {
      throw new WriterException("Empty EXTRA_TEXT");
    }
    this.c = str;
    this.f = BarcodeFormat.l;
    if (paramIntent.hasExtra("android.intent.extra.SUBJECT")) {
      this.d = paramIntent.getStringExtra("android.intent.extra.SUBJECT");
    }
    for (;;)
    {
      this.e = this.b.getString(R.string.zxinglegacy_contents_text);
      return;
      if (paramIntent.hasExtra("android.intent.extra.TITLE")) {
        this.d = paramIntent.getStringExtra("android.intent.extra.TITLE");
      } else {
        this.d = this.c;
      }
    }
  }
  
  private void d(Intent paramIntent)
  {
    this.f = BarcodeFormat.l;
    Bundle localBundle = paramIntent.getExtras();
    if (localBundle == null) {
      throw new WriterException("No extras");
    }
    Uri localUri = (Uri)localBundle.getParcelable("android.intent.extra.STREAM");
    if (localUri == null) {
      throw new WriterException("No EXTRA_STREAM");
    }
    try
    {
      InputStream localInputStream = this.b.getContentResolver().openInputStream(localUri);
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      byte[] arrayOfByte1 = new byte[2048];
      for (;;)
      {
        int i = localInputStream.read(arrayOfByte1);
        if (i <= 0) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte1, 0, i);
      }
      arrayOfByte2 = localByteArrayOutputStream.toByteArray();
    }
    catch (IOException localIOException)
    {
      throw new WriterException(localIOException);
    }
    byte[] arrayOfByte2;
    String str = new String(arrayOfByte2, 0, arrayOfByte2.length, "UTF-8");
    Log.d(a, "Encoding share intent content:");
    Log.d(a, str);
    ParsedResult localParsedResult = ResultParser.d(new Result(str, arrayOfByte2, null, BarcodeFormat.l));
    if (!(localParsedResult instanceof AddressBookParsedResult)) {
      throw new WriterException("Result was not an address");
    }
    a((AddressBookParsedResult)localParsedResult);
    if ((this.c == null) || (this.c.length() == 0)) {
      throw new WriterException("No content to encode");
    }
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
 * Qualified Name:     com.google.zxing.client.androidlegacy.encode.QRCodeEncoder
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */