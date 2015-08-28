package com.boohee.pictures;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore.Images.Media;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.GridView;
import com.boohee.pictures.util.ParseUtils;
import java.util.List;

public final class ImageGridViewActivity
  extends FragmentActivity
  implements LoaderManager.LoaderCallbacks<Cursor>
{
  public static final String KEY_RESULT_PICTURES = "KEY_RESULT_PICTURES";
  static ImageGridViewActivity instance;
  private static boolean needUploadPictures = true;
  private static IPictureUpload sUploadLitener;
  private ImageGridAdapter mAdapter;
  private Context mContext;
  private GridView mGridView;
  private Menu mMenu;
  
  private void check()
  {
    if ((needUploadPictures) && (sUploadLitener == null)) {
      throw new RuntimeException("Start ImageGridViewActivity must from startMe() method !");
    }
  }
  
  public static IPictureUpload getUploadListener()
  {
    return sUploadLitener;
  }
  
  private void init()
  {
    instance = this;
    this.mContext = this;
    this.mGridView = ((GridView)findViewById(R.id.grid_view));
    this.mAdapter = new ImageGridAdapter(this.mContext, null, 0);
    this.mGridView.setAdapter(this.mAdapter);
    this.mGridView.setOnItemClickListener(new ImageGridViewActivity.ItemClickListener(this, null));
    getSupportLoaderManager().initLoader(0, null, this);
    getActionBar().setDisplayHomeAsUpEnabled(true);
    getActionBar().setDisplayShowTitleEnabled(true);
  }
  
  private void previewImages()
  {
    if (this.mAdapter.getSelectList().size() > 0)
    {
      List localList = this.mAdapter.getSelectList();
      PreviewImageActivity.startMe(this.mContext, localList);
      return;
    }
    Cursor localCursor = this.mAdapter.getCursor();
    PreviewImageActivity.startMe(this.mContext, PictureHelper.getAllPictures(localCursor));
  }
  
  public static void startMe(Context paramContext, int paramInt, IPictureUpload paramIPictureUpload)
  {
    if (paramInt <= 0) {
      throw new RuntimeException("Please invoke PictureUpload.init() First !");
    }
    if (paramIPictureUpload == null) {
      throw new RuntimeException("IPictureUpload must not be null !");
    }
    PictureUpload.sMaxPicNumber = paramInt;
    sUploadLitener = paramIPictureUpload;
    needUploadPictures = true;
    paramContext.startActivity(new Intent(paramContext, ImageGridViewActivity.class));
  }
  
  public static void startMe(Context paramContext, IPictureUpload paramIPictureUpload)
  {
    if (paramIPictureUpload == null) {
      throw new RuntimeException("IPictureUpload must not be null !");
    }
    sUploadLitener = paramIPictureUpload;
    needUploadPictures = true;
    paramContext.startActivity(new Intent(paramContext, ImageGridViewActivity.class));
  }
  
  public static void startMeForResult(Activity paramActivity, int paramInt)
  {
    needUploadPictures = false;
    paramActivity.startActivityForResult(new Intent(paramActivity, ImageGridViewActivity.class), paramInt);
  }
  
  public static void startMeForResult(Activity paramActivity, int paramInt1, int paramInt2)
  {
    if (paramInt1 <= 0) {
      throw new RuntimeException("Max Pictures must big than 0 !");
    }
    PictureUpload.sMaxPicNumber = paramInt1;
    needUploadPictures = false;
    paramActivity.startActivityForResult(new Intent(paramActivity, ImageGridViewActivity.class), paramInt2);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.activity_image_gridview);
    check();
    init();
  }
  
  public Loader<Cursor> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    String[] arrayOfString = { "_data", "_id", "_size" };
    return new CursorLoader(this, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, arrayOfString, null, null, "date_modified DESC");
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(R.menu.menu_image_grid, paramMenu);
    this.mMenu = paramMenu;
    MenuItem localMenuItem = paramMenu.findItem(R.id.action_send);
    if (needUploadPictures) {}
    for (String str = "发送";; str = "选择")
    {
      localMenuItem.setTitle(str);
      return super.onCreateOptionsMenu(paramMenu);
    }
  }
  
  public void onLoadFinished(Loader<Cursor> paramLoader, Cursor paramCursor)
  {
    this.mAdapter.swapCursor(paramCursor);
  }
  
  public void onLoaderReset(Loader<Cursor> paramLoader)
  {
    this.mAdapter.swapCursor(null);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 16908332)
    {
      finish();
      return true;
    }
    if (paramMenuItem.getOrder() == 1)
    {
      previewImages();
      return true;
    }
    List localList = this.mAdapter.getSelectList();
    if (needUploadPictures)
    {
      QiniuUploader.upload(this, sUploadLitener, localList);
      return true;
    }
    setResult(-1, getIntent().putExtra("KEY_RESULT_PICTURES", ParseUtils.toJson(localList)));
    finish();
    return true;
  }
  
  public void updateMenuItem(int paramInt)
  {
    if (this.mMenu == null) {}
    while (PictureUpload.sMaxPicNumber <= 0) {
      return;
    }
    MenuItem localMenuItem1 = this.mMenu.findItem(R.id.action_send);
    MenuItem localMenuItem2 = this.mMenu.findItem(R.id.action_preview);
    if (paramInt > 0)
    {
      localMenuItem2.setTitle("预览(" + paramInt + "/" + PictureUpload.sMaxPicNumber + ")");
      if (needUploadPictures) {}
      for (String str2 = "发送(";; str2 = "选择(" + paramInt + "/" + PictureUpload.sMaxPicNumber + ")")
      {
        localMenuItem1.setTitle(str2);
        localMenuItem1.setEnabled(true);
        onPrepareOptionsMenu(this.mMenu);
        return;
      }
    }
    localMenuItem2.setTitle("预览");
    if (needUploadPictures) {}
    for (String str1 = "发送";; str1 = "选择")
    {
      localMenuItem1.setTitle(str1);
      localMenuItem1.setEnabled(false);
      break;
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.pictures.ImageGridViewActivity
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */