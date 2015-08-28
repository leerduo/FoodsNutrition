package com.boohee.pictures;

import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.io.File;

public class PreviewImageFragment
  extends Fragment
{
  static final String KEY_PATH = "KEY_PATH";
  private ImageView mImageView;
  private String mPath;
  private ProgressBar mProgressBar;
  
  public static PreviewImageFragment newInstance(String paramString)
  {
    PreviewImageFragment localPreviewImageFragment = new PreviewImageFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("KEY_PATH", paramString);
    localPreviewImageFragment.setArguments(localBundle);
    return localPreviewImageFragment;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if (TextUtils.isEmpty(this.mPath))
    {
      Log.e("PicturePreview", "Picture Path is Empty !");
      return;
    }
    if (!new File(this.mPath).exists())
    {
      Toast.makeText(getActivity(), "图片的路径为空！", 0).show();
      return;
    }
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    Picasso.a(getActivity()).a(Uri.fromFile(new File(this.mPath))).a(localDisplayMetrics.widthPixels / 3, localDisplayMetrics.heightPixels / 3).b().a(this.mImageView, new PreviewImageFragment.1(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Bundle localBundle = getArguments();
    if (localBundle != null) {
      this.mPath = localBundle.getString("KEY_PATH");
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(R.layout.fragment_image_preview, paramViewGroup, false);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.mImageView = ((ImageView)paramView.findViewById(R.id.iv_image));
    this.mProgressBar = ((ProgressBar)paramView.findViewById(R.id.progress_bar));
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.pictures.PreviewImageFragment
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */