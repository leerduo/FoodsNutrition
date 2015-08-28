package com.boohee.food;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore.Images.Media;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import butterknife.ButterKnife;
import com.boohee.food.util.SDcard;
import com.boohee.food.util.ToastUtils;
import java.io.File;

public class SelectPictureActivity
  extends FragmentActivity
{
  private Uri a;
  
  private void a()
  {
    startActivityForResult(new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI), 1122);
  }
  
  public static void a(Activity paramActivity, int paramInt)
  {
    paramActivity.startActivityForResult(new Intent(paramActivity, SelectPictureActivity.class), paramInt);
  }
  
  private void b()
  {
    if (!SDcard.e())
    {
      ToastUtils.b("暂无SDCard");
      return;
    }
    File localFile = SDcard.c();
    if ((localFile == null) || (!localFile.exists()))
    {
      ToastUtils.b("初始化SDCard文件失败");
      setResult(0);
      finish();
      return;
    }
    Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
    this.a = Uri.fromFile(localFile);
    localIntent.putExtra("output", this.a);
    startActivityForResult(localIntent, 2233);
  }
  
  /* Error */
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: iload_2
    //   3: aload_3
    //   4: invokespecial 89	android/support/v4/app/FragmentActivity:onActivityResult	(IILandroid/content/Intent;)V
    //   7: iload_2
    //   8: iconst_m1
    //   9: if_icmpne +350 -> 359
    //   12: iload_1
    //   13: lookupswitch	default:+27->40, 1122:+113->126, 2233:+90->103
    //   41: nop
    //   42: fconst_1
    //   43: dup
    //   44: invokespecial 90	android/content/Intent:<init>	()V
    //   47: astore 4
    //   49: new 92	com/alibaba/fastjson/JSONArray
    //   52: dup
    //   53: invokespecial 93	com/alibaba/fastjson/JSONArray:<init>	()V
    //   56: astore 5
    //   58: aload_0
    //   59: getfield 77	com/boohee/food/SelectPictureActivity:a	Landroid/net/Uri;
    //   62: ifnull +305 -> 367
    //   65: aload 5
    //   67: aload_0
    //   68: getfield 77	com/boohee/food/SelectPictureActivity:a	Landroid/net/Uri;
    //   71: invokevirtual 97	android/net/Uri:getPath	()Ljava/lang/String;
    //   74: invokevirtual 101	com/alibaba/fastjson/JSONArray:add	(Ljava/lang/Object;)Z
    //   77: pop
    //   78: aload 4
    //   80: ldc 103
    //   82: aload 5
    //   84: invokevirtual 106	com/alibaba/fastjson/JSONArray:toString	()Ljava/lang/String;
    //   87: invokevirtual 109	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   90: pop
    //   91: aload_0
    //   92: iconst_m1
    //   93: aload 4
    //   95: invokevirtual 112	com/boohee/food/SelectPictureActivity:setResult	(ILandroid/content/Intent;)V
    //   98: aload_0
    //   99: invokevirtual 65	com/boohee/food/SelectPictureActivity:finish	()V
    //   102: return
    //   103: aload_0
    //   104: getfield 77	com/boohee/food/SelectPictureActivity:a	Landroid/net/Uri;
    //   107: invokevirtual 97	android/net/Uri:getPath	()Ljava/lang/String;
    //   110: invokestatic 115	com/boohee/food/util/SDcard:a	(Ljava/lang/String;)J
    //   113: lconst_0
    //   114: lcmp
    //   115: ifgt -75 -> 40
    //   118: aload_0
    //   119: aconst_null
    //   120: putfield 77	com/boohee/food/SelectPictureActivity:a	Landroid/net/Uri;
    //   123: goto -83 -> 40
    //   126: aload_3
    //   127: ifnull -87 -> 40
    //   130: aload_0
    //   131: aload_3
    //   132: invokevirtual 119	android/content/Intent:getData	()Landroid/net/Uri;
    //   135: putfield 77	com/boohee/food/SelectPictureActivity:a	Landroid/net/Uri;
    //   138: aload_0
    //   139: getfield 77	com/boohee/food/SelectPictureActivity:a	Landroid/net/Uri;
    //   142: ifnonnull +89 -> 231
    //   145: aload_3
    //   146: invokevirtual 123	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   149: astore 17
    //   151: aload 17
    //   153: ifnull -113 -> 40
    //   156: aload 17
    //   158: ldc 125
    //   160: invokevirtual 131	android/os/Bundle:getParcelable	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   163: checkcast 133	android/graphics/Bitmap
    //   166: astore 18
    //   168: aload 18
    //   170: ifnull -130 -> 40
    //   173: new 135	java/io/ByteArrayOutputStream
    //   176: dup
    //   177: invokespecial 136	java/io/ByteArrayOutputStream:<init>	()V
    //   180: astore 19
    //   182: aload 18
    //   184: getstatic 142	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   187: bipush 70
    //   189: aload 19
    //   191: invokevirtual 146	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   194: pop
    //   195: aload_0
    //   196: aload_0
    //   197: invokevirtual 150	com/boohee/food/SelectPictureActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   200: aload 18
    //   202: invokestatic 156	java/lang/System:currentTimeMillis	()J
    //   205: invokestatic 162	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   208: aconst_null
    //   209: invokestatic 166	android/provider/MediaStore$Images$Media:insertImage	(Landroid/content/ContentResolver;Landroid/graphics/Bitmap;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   212: invokestatic 170	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   215: putfield 77	com/boohee/food/SelectPictureActivity:a	Landroid/net/Uri;
    //   218: goto -178 -> 40
    //   221: astore 9
    //   223: aload 9
    //   225: invokevirtual 173	java/lang/Exception:printStackTrace	()V
    //   228: goto -188 -> 40
    //   231: iconst_1
    //   232: anewarray 158	java/lang/String
    //   235: dup
    //   236: iconst_0
    //   237: ldc 175
    //   239: aastore
    //   240: astore 10
    //   242: aload_0
    //   243: invokevirtual 150	com/boohee/food/SelectPictureActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   246: aload_0
    //   247: getfield 77	com/boohee/food/SelectPictureActivity:a	Landroid/net/Uri;
    //   250: aload 10
    //   252: aconst_null
    //   253: aconst_null
    //   254: aconst_null
    //   255: invokevirtual 181	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   258: astore 14
    //   260: aload 14
    //   262: astore 12
    //   264: aload 12
    //   266: ldc 175
    //   268: invokeinterface 187 2 0
    //   273: istore 15
    //   275: aload 12
    //   277: invokeinterface 190 1 0
    //   282: pop
    //   283: aload_0
    //   284: aload 12
    //   286: iload 15
    //   288: invokeinterface 194 2 0
    //   293: invokestatic 170	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   296: putfield 77	com/boohee/food/SelectPictureActivity:a	Landroid/net/Uri;
    //   299: aload 12
    //   301: ifnull -261 -> 40
    //   304: aload 12
    //   306: invokeinterface 197 1 0
    //   311: goto -271 -> 40
    //   314: astore 13
    //   316: aconst_null
    //   317: astore 12
    //   319: aload 13
    //   321: invokevirtual 173	java/lang/Exception:printStackTrace	()V
    //   324: aload_0
    //   325: aconst_null
    //   326: putfield 77	com/boohee/food/SelectPictureActivity:a	Landroid/net/Uri;
    //   329: aload 12
    //   331: ifnull -291 -> 40
    //   334: aload 12
    //   336: invokeinterface 197 1 0
    //   341: goto -301 -> 40
    //   344: aload 12
    //   346: ifnull +10 -> 356
    //   349: aload 12
    //   351: invokeinterface 197 1 0
    //   356: aload 11
    //   358: athrow
    //   359: aload_0
    //   360: aconst_null
    //   361: putfield 77	com/boohee/food/SelectPictureActivity:a	Landroid/net/Uri;
    //   364: goto -324 -> 40
    //   367: aload 5
    //   369: ldc 199
    //   371: invokevirtual 101	com/alibaba/fastjson/JSONArray:add	(Ljava/lang/Object;)Z
    //   374: pop
    //   375: goto -297 -> 78
    //   378: astore 11
    //   380: goto -36 -> 344
    //   383: astore 13
    //   385: goto -66 -> 319
    //   388: astore 11
    //   390: aconst_null
    //   391: astore 12
    //   393: goto -49 -> 344
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	396	0	this	SelectPictureActivity
    //   0	396	1	paramInt1	int
    //   0	396	2	paramInt2	int
    //   0	396	3	paramIntent	Intent
    //   47	47	4	localIntent	Intent
    //   56	312	5	localJSONArray	com.alibaba.fastjson.JSONArray
    //   221	3	9	localException1	java.lang.Exception
    //   240	11	10	arrayOfString	java.lang.String[]
    //   356	1	11	localObject1	java.lang.Object
    //   378	1	11	localObject2	java.lang.Object
    //   388	1	11	localObject3	java.lang.Object
    //   262	130	12	localCursor1	android.database.Cursor
    //   314	6	13	localException2	java.lang.Exception
    //   383	1	13	localException3	java.lang.Exception
    //   258	3	14	localCursor2	android.database.Cursor
    //   273	14	15	i	int
    //   149	8	17	localBundle	Bundle
    //   166	35	18	localBitmap	android.graphics.Bitmap
    //   180	10	19	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   130	151	221	java/lang/Exception
    //   156	168	221	java/lang/Exception
    //   173	218	221	java/lang/Exception
    //   304	311	221	java/lang/Exception
    //   334	341	221	java/lang/Exception
    //   349	356	221	java/lang/Exception
    //   356	359	221	java/lang/Exception
    //   231	260	314	java/lang/Exception
    //   264	299	378	finally
    //   319	329	378	finally
    //   264	299	383	java/lang/Exception
    //   231	260	388	finally
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131427503: 
      a();
      return;
    }
    b();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903084);
    ButterKnife.a(this);
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.food.SelectPictureActivity
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */