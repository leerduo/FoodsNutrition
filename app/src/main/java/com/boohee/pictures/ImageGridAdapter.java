package com.boohee.pictures;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore.Images.Media;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.util.LinkedList;
import java.util.List;

public class ImageGridAdapter
  extends CursorAdapter
{
  private boolean[] mCheckStatus;
  private Context mContext;
  private final int mHeight;
  private LayoutInflater mLi;
  private LinkedList<String> mSelectList = new LinkedList();
  private final int mWidth;
  
  public ImageGridAdapter(Context paramContext, Cursor paramCursor, int paramInt)
  {
    super(paramContext, paramCursor, paramInt);
    this.mLi = LayoutInflater.from(paramContext);
    this.mContext = paramContext;
    DisplayMetrics localDisplayMetrics = this.mContext.getResources().getDisplayMetrics();
    this.mWidth = (localDisplayMetrics.widthPixels / 3);
    this.mHeight = (localDisplayMetrics.heightPixels / 3);
  }
  
  private Uri getNormalPicUri(Cursor paramCursor)
  {
    return getNormalPicUri("" + paramCursor.getInt(paramCursor.getColumnIndex("_id")));
  }
  
  private Uri getNormalPicUri(String paramString)
  {
    return Uri.withAppendedPath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, paramString);
  }
  
  private String getPicturePath(int paramInt)
  {
    Cursor localCursor = getCursor();
    localCursor.moveToPosition(paramInt);
    return localCursor.getString(localCursor.getColumnIndex("_data"));
  }
  
  private void initCheckBoxStatus()
  {
    if ((this.mCheckStatus == null) && (getCount() > 0)) {
      this.mCheckStatus = new boolean[getCount()];
    }
  }
  
  private void loadImage(long paramLong, ImageGridAdapter.ViewHolder paramViewHolder)
  {
    Uri localUri = getNormalPicUri(paramLong + "");
    if ((paramLong + "").equals(paramViewHolder.imageView.getTag())) {
      return;
    }
    paramViewHolder.imageView.getLayoutParams().width = this.mWidth;
    paramViewHolder.imageView.getLayoutParams().height = this.mWidth;
    Picasso.a(this.mContext).a(localUri).a((int)(this.mWidth / 2.2D), (int)(this.mHeight / 2.2D)).a(paramViewHolder.imageView, new ImageGridAdapter.1(this, paramViewHolder, paramLong));
  }
  
  public void bindView(View paramView, Context paramContext, Cursor paramCursor)
  {
    initCheckBoxStatus();
    ImageGridAdapter.ViewHolder localViewHolder = (ImageGridAdapter.ViewHolder)paramView.getTag();
    localViewHolder.checkBox.setOnClickListener(new ImageGridAdapter.CheckBoxClickListener(this, paramCursor.getPosition()));
    localViewHolder.checkBox.setChecked(this.mCheckStatus[paramCursor.getPosition()]);
    loadImage(getItemId(paramCursor.getPosition()), localViewHolder);
  }
  
  public List<String> getSelectList()
  {
    return this.mSelectList;
  }
  
  public View newView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    ImageGridAdapter.ViewHolder localViewHolder = new ImageGridAdapter.ViewHolder();
    View localView = this.mLi.inflate(R.layout.item_picture, null);
    localViewHolder.imageView = ((ImageView)localView.findViewById(R.id.iv_item));
    localViewHolder.checkBox = ((CheckBox)localView.findViewById(R.id.cb_select));
    localView.setTag(localViewHolder);
    return localView;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.pictures.ImageGridAdapter
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */