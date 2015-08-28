package com.google.zxing.client.android.encode;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.zxing.WriterException;
import com.google.zxing.client.android.FinishListener;
import com.google.zxing.client.android.R.id;
import com.google.zxing.client.android.R.layout;
import com.google.zxing.client.android.R.menu;
import com.google.zxing.client.android.R.string;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class EncodeActivity
  extends Activity
{
  private static final String a = EncodeActivity.class.getSimpleName();
  private static final Pattern b = Pattern.compile("[^A-Za-z0-9]");
  private QRCodeEncoder c;
  
  private static CharSequence a(CharSequence paramCharSequence)
  {
    String str = b.matcher(paramCharSequence).replaceAll("_");
    if (str.length() > 24) {
      str = str.substring(0, 24);
    }
    return str;
  }
  
  /* Error */
  private void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 64	com/google/zxing/client/android/encode/EncodeActivity:c	Lcom/google/zxing/client/android/encode/QRCodeEncoder;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnonnull +13 -> 19
    //   9: getstatic 20	com/google/zxing/client/android/encode/EncodeActivity:a	Ljava/lang/String;
    //   12: ldc 66
    //   14: invokestatic 72	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   17: pop
    //   18: return
    //   19: aload_1
    //   20: invokevirtual 76	com/google/zxing/client/android/encode/QRCodeEncoder:a	()Ljava/lang/String;
    //   23: astore_2
    //   24: aload_2
    //   25: ifnonnull +13 -> 38
    //   28: getstatic 20	com/google/zxing/client/android/encode/EncodeActivity:a	Ljava/lang/String;
    //   31: ldc 66
    //   33: invokestatic 72	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   36: pop
    //   37: return
    //   38: aload_1
    //   39: invokevirtual 80	com/google/zxing/client/android/encode/QRCodeEncoder:e	()Landroid/graphics/Bitmap;
    //   42: astore 5
    //   44: aload 5
    //   46: ifnull -28 -> 18
    //   49: new 82	java/io/File
    //   52: dup
    //   53: new 82	java/io/File
    //   56: dup
    //   57: invokestatic 88	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   60: ldc 90
    //   62: invokespecial 93	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   65: ldc 95
    //   67: invokespecial 93	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   70: astore 6
    //   72: aload 6
    //   74: invokevirtual 99	java/io/File:exists	()Z
    //   77: ifne +56 -> 133
    //   80: aload 6
    //   82: invokevirtual 102	java/io/File:mkdirs	()Z
    //   85: ifne +48 -> 133
    //   88: getstatic 20	com/google/zxing/client/android/encode/EncodeActivity:a	Ljava/lang/String;
    //   91: new 104	java/lang/StringBuilder
    //   94: dup
    //   95: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   98: ldc 107
    //   100: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: aload 6
    //   105: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   108: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokestatic 72	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   114: pop
    //   115: aload_0
    //   116: getstatic 123	com/google/zxing/client/android/R$string:zxing_msg_unmount_usb	I
    //   119: invokespecial 126	com/google/zxing/client/android/encode/EncodeActivity:a	(I)V
    //   122: return
    //   123: astore_3
    //   124: getstatic 20	com/google/zxing/client/android/encode/EncodeActivity:a	Ljava/lang/String;
    //   127: aload_3
    //   128: invokestatic 129	android/util/Log:w	(Ljava/lang/String;Ljava/lang/Throwable;)I
    //   131: pop
    //   132: return
    //   133: new 82	java/io/File
    //   136: dup
    //   137: aload 6
    //   139: new 104	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   146: aload_2
    //   147: invokestatic 131	com/google/zxing/client/android/encode/EncodeActivity:a	(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    //   150: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   153: ldc 133
    //   155: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokespecial 93	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   164: astore 7
    //   166: aload 7
    //   168: invokevirtual 136	java/io/File:delete	()Z
    //   171: ifne +30 -> 201
    //   174: getstatic 20	com/google/zxing/client/android/encode/EncodeActivity:a	Ljava/lang/String;
    //   177: new 104	java/lang/StringBuilder
    //   180: dup
    //   181: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   184: ldc 138
    //   186: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: aload 7
    //   191: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   194: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   197: invokestatic 72	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   200: pop
    //   201: new 140	java/io/FileOutputStream
    //   204: dup
    //   205: aload 7
    //   207: invokespecial 143	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   210: astore 8
    //   212: aload 5
    //   214: getstatic 149	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   217: iconst_0
    //   218: aload 8
    //   220: invokevirtual 155	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   223: pop
    //   224: aload 8
    //   226: ifnull +8 -> 234
    //   229: aload 8
    //   231: invokevirtual 158	java/io/FileOutputStream:close	()V
    //   234: new 160	android/content/Intent
    //   237: dup
    //   238: ldc 162
    //   240: ldc 164
    //   242: invokestatic 170	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   245: invokespecial 173	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   248: astore 15
    //   250: aload 15
    //   252: ldc 175
    //   254: new 104	java/lang/StringBuilder
    //   257: dup
    //   258: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   261: aload_0
    //   262: getstatic 178	com/google/zxing/client/android/R$string:zxing_app_name	I
    //   265: invokevirtual 182	com/google/zxing/client/android/encode/EncodeActivity:getString	(I)Ljava/lang/String;
    //   268: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: ldc 184
    //   273: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: aload_1
    //   277: invokevirtual 186	com/google/zxing/client/android/encode/QRCodeEncoder:c	()Ljava/lang/String;
    //   280: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   286: invokevirtual 190	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   289: pop
    //   290: aload 15
    //   292: ldc 192
    //   294: aload_2
    //   295: invokevirtual 190	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   298: pop
    //   299: aload 15
    //   301: ldc 194
    //   303: new 104	java/lang/StringBuilder
    //   306: dup
    //   307: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   310: ldc 196
    //   312: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: aload 7
    //   317: invokevirtual 199	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   320: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   326: invokestatic 170	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   329: invokevirtual 202	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   332: pop
    //   333: aload 15
    //   335: ldc 204
    //   337: invokevirtual 208	android/content/Intent:setType	(Ljava/lang/String;)Landroid/content/Intent;
    //   340: pop
    //   341: aload 15
    //   343: ldc 209
    //   345: invokevirtual 213	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   348: pop
    //   349: aload_0
    //   350: aload 15
    //   352: aconst_null
    //   353: invokestatic 217	android/content/Intent:createChooser	(Landroid/content/Intent;Ljava/lang/CharSequence;)Landroid/content/Intent;
    //   356: invokevirtual 221	com/google/zxing/client/android/encode/EncodeActivity:startActivity	(Landroid/content/Intent;)V
    //   359: return
    //   360: astore 9
    //   362: aconst_null
    //   363: astore 8
    //   365: getstatic 20	com/google/zxing/client/android/encode/EncodeActivity:a	Ljava/lang/String;
    //   368: new 104	java/lang/StringBuilder
    //   371: dup
    //   372: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   375: ldc 223
    //   377: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: aload 7
    //   382: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   385: ldc 225
    //   387: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: aload 9
    //   392: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   395: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   398: invokestatic 72	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   401: pop
    //   402: aload_0
    //   403: getstatic 123	com/google/zxing/client/android/R$string:zxing_msg_unmount_usb	I
    //   406: invokespecial 126	com/google/zxing/client/android/encode/EncodeActivity:a	(I)V
    //   409: aload 8
    //   411: ifnull -393 -> 18
    //   414: aload 8
    //   416: invokevirtual 158	java/io/FileOutputStream:close	()V
    //   419: return
    //   420: astore 13
    //   422: return
    //   423: astore 10
    //   425: aconst_null
    //   426: astore 8
    //   428: aload 8
    //   430: ifnull +8 -> 438
    //   433: aload 8
    //   435: invokevirtual 158	java/io/FileOutputStream:close	()V
    //   438: aload 10
    //   440: athrow
    //   441: astore 21
    //   443: goto -209 -> 234
    //   446: astore 11
    //   448: goto -10 -> 438
    //   451: astore 10
    //   453: goto -25 -> 428
    //   456: astore 9
    //   458: goto -93 -> 365
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	461	0	this	EncodeActivity
    //   4	273	1	localQRCodeEncoder	QRCodeEncoder
    //   23	272	2	str	String
    //   123	5	3	localWriterException	WriterException
    //   42	171	5	localBitmap	Bitmap
    //   70	68	6	localFile1	java.io.File
    //   164	217	7	localFile2	java.io.File
    //   210	224	8	localFileOutputStream	java.io.FileOutputStream
    //   360	31	9	localFileNotFoundException1	java.io.FileNotFoundException
    //   456	1	9	localFileNotFoundException2	java.io.FileNotFoundException
    //   423	16	10	localObject1	java.lang.Object
    //   451	1	10	localObject2	java.lang.Object
    //   446	1	11	localIOException1	java.io.IOException
    //   420	1	13	localIOException2	java.io.IOException
    //   248	103	15	localIntent	Intent
    //   441	1	21	localIOException3	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   38	44	123	com/google/zxing/WriterException
    //   201	212	360	java/io/FileNotFoundException
    //   414	419	420	java/io/IOException
    //   201	212	423	finally
    //   229	234	441	java/io/IOException
    //   433	438	446	java/io/IOException
    //   212	224	451	finally
    //   365	409	451	finally
    //   212	224	456	java/io/FileNotFoundException
  }
  
  private void a(int paramInt)
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
    localBuilder.setMessage(paramInt);
    localBuilder.setPositiveButton(R.string.zxing_button_ok, new FinishListener(this));
    localBuilder.setOnCancelListener(new FinishListener(this));
    localBuilder.show();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Intent localIntent = getIntent();
    if (localIntent == null)
    {
      finish();
      return;
    }
    String str = localIntent.getAction();
    if (("com.google.zxing.client.android.ENCODE".equals(str)) || ("android.intent.action.SEND".equals(str)))
    {
      setContentView(R.layout.zxing_encode);
      return;
    }
    finish();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(R.menu.zxing_encode, paramMenu);
    int i;
    if ((this.c != null) && (this.c.d()))
    {
      i = 1;
      if (i == 0) {
        break label102;
      }
    }
    label102:
    for (int j = R.string.zxing_menu_encode_mecard;; j = R.string.zxing_menu_encode_vcard)
    {
      MenuItem localMenuItem = paramMenu.findItem(R.id.zxing_menu_encode);
      localMenuItem.setTitle(j);
      Intent localIntent = getIntent();
      if (localIntent != null) {
        localMenuItem.setVisible("CONTACT_TYPE".equals(localIntent.getStringExtra("ENCODE_TYPE")));
      }
      return super.onCreateOptionsMenu(paramMenu);
      i = 0;
      break;
    }
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    int i = paramMenuItem.getItemId();
    if (i == R.id.zxing_menu_share)
    {
      a();
      return true;
    }
    if (i == R.id.zxing_menu_encode)
    {
      Intent localIntent = getIntent();
      if (localIntent == null) {
        return false;
      }
      boolean bool1 = this.c.d();
      boolean bool2 = false;
      if (!bool1) {
        bool2 = true;
      }
      localIntent.putExtra("USE_VCARD", bool2);
      localIntent.addFlags(67108864);
      startActivity(localIntent);
      finish();
      return true;
    }
    return false;
  }
  
  protected void onResume()
  {
    super.onResume();
    Display localDisplay = ((WindowManager)getSystemService("window")).getDefaultDisplay();
    Point localPoint = new Point();
    localDisplay.getSize(localPoint);
    int i = localPoint.x;
    int j = localPoint.y;
    if (i < j) {}
    int k;
    Intent localIntent;
    for (;;)
    {
      k = i * 7 / 8;
      localIntent = getIntent();
      if (localIntent != null) {
        break;
      }
      return;
      i = j;
    }
    Bitmap localBitmap;
    try
    {
      this.c = new QRCodeEncoder(this, localIntent, k, localIntent.getBooleanExtra("USE_VCARD", false));
      localBitmap = this.c.e();
      if (localBitmap == null)
      {
        Log.w(a, "Could not encode barcode");
        a(R.string.zxing_msg_encode_contents_failed);
        this.c = null;
        return;
      }
    }
    catch (WriterException localWriterException)
    {
      Log.w(a, "Could not encode barcode", localWriterException);
      a(R.string.zxing_msg_encode_contents_failed);
      this.c = null;
      return;
    }
    ((ImageView)findViewById(R.id.zxing_image_view)).setImageBitmap(localBitmap);
    TextView localTextView = (TextView)findViewById(R.id.zxing_contents_text_view);
    if (localIntent.getBooleanExtra("ENCODE_SHOW_CONTENTS", true))
    {
      localTextView.setText(this.c.b());
      setTitle(this.c.c());
      return;
    }
    localTextView.setText("");
    setTitle("");
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.google.zxing.client.android.encode.EncodeActivity
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */