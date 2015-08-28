package com.google.zxing.client.androidlegacy.encode;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.graphics.Bitmap;
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
import com.google.zxing.client.androidlegacy.FinishListener;
import com.google.zxing.client.androidlegacy.R.id;
import com.google.zxing.client.androidlegacy.R.layout;
import com.google.zxing.client.androidlegacy.R.menu;
import com.google.zxing.client.androidlegacy.R.string;
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
    //   1: getfield 64	com/google/zxing/client/androidlegacy/encode/EncodeActivity:c	Lcom/google/zxing/client/androidlegacy/encode/QRCodeEncoder;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnonnull +13 -> 19
    //   9: getstatic 20	com/google/zxing/client/androidlegacy/encode/EncodeActivity:a	Ljava/lang/String;
    //   12: ldc 66
    //   14: invokestatic 72	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   17: pop
    //   18: return
    //   19: aload_1
    //   20: invokevirtual 76	com/google/zxing/client/androidlegacy/encode/QRCodeEncoder:a	()Ljava/lang/String;
    //   23: astore_2
    //   24: aload_2
    //   25: ifnonnull +13 -> 38
    //   28: getstatic 20	com/google/zxing/client/androidlegacy/encode/EncodeActivity:a	Ljava/lang/String;
    //   31: ldc 66
    //   33: invokestatic 72	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   36: pop
    //   37: return
    //   38: aload_1
    //   39: invokevirtual 80	com/google/zxing/client/androidlegacy/encode/QRCodeEncoder:e	()Landroid/graphics/Bitmap;
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
    //   88: getstatic 20	com/google/zxing/client/androidlegacy/encode/EncodeActivity:a	Ljava/lang/String;
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
    //   116: getstatic 123	com/google/zxing/client/androidlegacy/R$string:zxinglegacy_msg_unmount_usb	I
    //   119: invokespecial 126	com/google/zxing/client/androidlegacy/encode/EncodeActivity:a	(I)V
    //   122: return
    //   123: astore_3
    //   124: getstatic 20	com/google/zxing/client/androidlegacy/encode/EncodeActivity:a	Ljava/lang/String;
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
    //   147: invokestatic 131	com/google/zxing/client/androidlegacy/encode/EncodeActivity:a	(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    //   150: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   153: ldc 133
    //   155: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokespecial 93	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   164: astore 7
    //   166: aload 7
    //   168: invokevirtual 136	java/io/File:delete	()Z
    //   171: pop
    //   172: new 138	java/io/FileOutputStream
    //   175: dup
    //   176: aload 7
    //   178: invokespecial 141	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   181: astore 9
    //   183: aload 5
    //   185: getstatic 147	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   188: iconst_0
    //   189: aload 9
    //   191: invokevirtual 153	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   194: pop
    //   195: aload 9
    //   197: ifnull +8 -> 205
    //   200: aload 9
    //   202: invokevirtual 156	java/io/FileOutputStream:close	()V
    //   205: new 158	android/content/Intent
    //   208: dup
    //   209: ldc 160
    //   211: ldc 162
    //   213: invokestatic 168	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   216: invokespecial 171	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   219: astore 16
    //   221: aload 16
    //   223: ldc 173
    //   225: new 104	java/lang/StringBuilder
    //   228: dup
    //   229: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   232: aload_0
    //   233: getstatic 176	com/google/zxing/client/androidlegacy/R$string:zxinglegacy_app_name	I
    //   236: invokevirtual 180	com/google/zxing/client/androidlegacy/encode/EncodeActivity:getString	(I)Ljava/lang/String;
    //   239: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: ldc 182
    //   244: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: aload_1
    //   248: invokevirtual 184	com/google/zxing/client/androidlegacy/encode/QRCodeEncoder:c	()Ljava/lang/String;
    //   251: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   257: invokevirtual 188	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   260: pop
    //   261: aload 16
    //   263: ldc 190
    //   265: aload_2
    //   266: invokevirtual 188	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   269: pop
    //   270: aload 16
    //   272: ldc 192
    //   274: new 104	java/lang/StringBuilder
    //   277: dup
    //   278: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   281: ldc 194
    //   283: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: aload 7
    //   288: invokevirtual 197	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   291: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   297: invokestatic 168	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   300: invokevirtual 200	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   303: pop
    //   304: aload 16
    //   306: ldc 202
    //   308: invokevirtual 206	android/content/Intent:setType	(Ljava/lang/String;)Landroid/content/Intent;
    //   311: pop
    //   312: aload 16
    //   314: ldc 207
    //   316: invokevirtual 211	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   319: pop
    //   320: aload_0
    //   321: aload 16
    //   323: aconst_null
    //   324: invokestatic 215	android/content/Intent:createChooser	(Landroid/content/Intent;Ljava/lang/CharSequence;)Landroid/content/Intent;
    //   327: invokevirtual 219	com/google/zxing/client/androidlegacy/encode/EncodeActivity:startActivity	(Landroid/content/Intent;)V
    //   330: return
    //   331: astore 10
    //   333: aconst_null
    //   334: astore 9
    //   336: getstatic 20	com/google/zxing/client/androidlegacy/encode/EncodeActivity:a	Ljava/lang/String;
    //   339: new 104	java/lang/StringBuilder
    //   342: dup
    //   343: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   346: ldc 221
    //   348: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: aload 7
    //   353: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   356: ldc 223
    //   358: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: aload 10
    //   363: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   366: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   369: invokestatic 72	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   372: pop
    //   373: aload_0
    //   374: getstatic 123	com/google/zxing/client/androidlegacy/R$string:zxinglegacy_msg_unmount_usb	I
    //   377: invokespecial 126	com/google/zxing/client/androidlegacy/encode/EncodeActivity:a	(I)V
    //   380: aload 9
    //   382: ifnull -364 -> 18
    //   385: aload 9
    //   387: invokevirtual 156	java/io/FileOutputStream:close	()V
    //   390: return
    //   391: astore 14
    //   393: return
    //   394: astore 11
    //   396: aconst_null
    //   397: astore 9
    //   399: aload 9
    //   401: ifnull +8 -> 409
    //   404: aload 9
    //   406: invokevirtual 156	java/io/FileOutputStream:close	()V
    //   409: aload 11
    //   411: athrow
    //   412: astore 22
    //   414: goto -209 -> 205
    //   417: astore 12
    //   419: goto -10 -> 409
    //   422: astore 11
    //   424: goto -25 -> 399
    //   427: astore 10
    //   429: goto -93 -> 336
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	432	0	this	EncodeActivity
    //   4	244	1	localQRCodeEncoder	QRCodeEncoder
    //   23	243	2	str	String
    //   123	5	3	localWriterException	WriterException
    //   42	142	5	localBitmap	Bitmap
    //   70	68	6	localFile1	java.io.File
    //   164	188	7	localFile2	java.io.File
    //   181	224	9	localFileOutputStream	java.io.FileOutputStream
    //   331	31	10	localFileNotFoundException1	java.io.FileNotFoundException
    //   427	1	10	localFileNotFoundException2	java.io.FileNotFoundException
    //   394	16	11	localObject1	java.lang.Object
    //   422	1	11	localObject2	java.lang.Object
    //   417	1	12	localIOException1	java.io.IOException
    //   391	1	14	localIOException2	java.io.IOException
    //   219	103	16	localIntent	Intent
    //   412	1	22	localIOException3	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   38	44	123	com/google/zxing/WriterException
    //   172	183	331	java/io/FileNotFoundException
    //   385	390	391	java/io/IOException
    //   172	183	394	finally
    //   200	205	412	java/io/IOException
    //   404	409	417	java/io/IOException
    //   183	195	422	finally
    //   336	380	422	finally
    //   183	195	427	java/io/FileNotFoundException
  }
  
  private void a(int paramInt)
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
    localBuilder.setMessage(paramInt);
    localBuilder.setPositiveButton(R.string.zxinglegacy_button_ok, new FinishListener(this));
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
      setContentView(R.layout.zxinglegacy_encode);
      return;
    }
    finish();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(R.menu.zxinglegacy_encode, paramMenu);
    int i;
    if ((this.c != null) && (this.c.d()))
    {
      i = 1;
      if (i == 0) {
        break label102;
      }
    }
    label102:
    for (int j = R.string.zxinglegacy_menu_encode_mecard;; j = R.string.zxinglegacy_menu_encode_vcard)
    {
      MenuItem localMenuItem = paramMenu.findItem(R.id.menu_encode);
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
    if (i == R.id.menu_share)
    {
      a();
      return true;
    }
    if (i == R.id.menu_encode)
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
    int i = localDisplay.getWidth();
    int j = localDisplay.getHeight();
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
        a(R.string.zxinglegacy_msg_encode_contents_failed);
        this.c = null;
        return;
      }
    }
    catch (WriterException localWriterException)
    {
      Log.w(a, "Could not encode barcode", localWriterException);
      a(R.string.zxinglegacy_msg_encode_contents_failed);
      this.c = null;
      return;
    }
    ((ImageView)findViewById(R.id.zxinglegacy_image_view)).setImageBitmap(localBitmap);
    TextView localTextView = (TextView)findViewById(R.id.zxinglegacy_contents_text_view);
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
 * Qualified Name:     com.google.zxing.client.androidlegacy.encode.EncodeActivity
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */