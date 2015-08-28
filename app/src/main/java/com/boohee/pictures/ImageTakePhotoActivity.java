package com.boohee.pictures;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.boohee.pictures.model.AuthParams;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.io.File;
import java.io.IOException;

public class ImageTakePhotoActivity
  extends FragmentActivity
  implements View.OnClickListener
{
  private static String IMG_PATH;
  public static final String KEY_PHOTO_PATH = "key_phtoto_path";
  private static final int REQUEST_CODE_TAKEPHOTO = 1;
  private static int mReqCode = -1;
  private static AuthParams sAuthParams = PictureUpload.sAuthParams;
  private static IPictureUpload sUploadLitener;
  private ImageView imageView;
  private DisplayMetrics mMetrics;
  
  private void addListener()
  {
    findViewById(R.id.btn_cancel).setOnClickListener(new ImageTakePhotoActivity.1(this));
    findViewById(R.id.btn_ok).setOnClickListener(new ImageTakePhotoActivity.2(this));
  }
  
  private void init()
  {
    IMG_PATH = getExternalCacheDir() + "temp_pic_upload";
    this.imageView = ((ImageView)findViewById(R.id.iv_image));
    this.mMetrics = getResources().getDisplayMetrics();
    ActionBar localActionBar = getActionBar();
    localActionBar.setDisplayHomeAsUpEnabled(true);
    localActionBar.setDisplayShowHomeEnabled(true);
    addListener();
  }
  
  private void loadImage(Uri paramUri)
  {
    Picasso.a(this).a(paramUri).c().a(this.mMetrics.widthPixels / 3, this.mMetrics.heightPixels / 3).b().a(this.imageView);
  }
  
  public static void startMe(Context paramContext, IPictureUpload paramIPictureUpload)
  {
    if (sAuthParams == null) {
      throw new RuntimeException("Please invoke PictureUpload.init() First !");
    }
    if (paramIPictureUpload == null) {
      throw new RuntimeException("IPictureUpload must not be null !");
    }
    sUploadLitener = paramIPictureUpload;
    paramContext.startActivity(new Intent(paramContext, ImageTakePhotoActivity.class));
  }
  
  public static void startMeForResult(Activity paramActivity, int paramInt)
  {
    mReqCode = paramInt;
    paramActivity.startActivityForResult(new Intent(paramActivity, ImageTakePhotoActivity.class), paramInt);
  }
  
  private void startTakePhoto()
  {
    try
    {
      File localFile = new File(IMG_PATH);
      localFile.createNewFile();
      Uri localUri = Uri.fromFile(localFile);
      Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
      localIntent.addCategory("android.intent.category.DEFAULT");
      localIntent.putExtra("output", localUri);
      startActivityForResult(localIntent, 1);
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1) && (paramInt2 == -1))
    {
      Uri localUri = Uri.fromFile(new File(IMG_PATH));
      if (mReqCode > -1)
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("key_phtoto_path", IMG_PATH);
        setResult(-1, localIntent);
        finish();
        return;
      }
      loadImage(localUri);
      return;
    }
    finish();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.activity_take_photo);
    init();
  }
  
  protected void onPostCreate(Bundle paramBundle)
  {
    super.onPostCreate(paramBundle);
    startTakePhoto();
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.pictures.ImageTakePhotoActivity
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */