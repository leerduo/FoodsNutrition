package com.boohee.pictures;

import android.content.Context;
import com.boohee.pictures.qiniu.QiniuConfig;
import com.qiniu.android.storage.UploadManager;
import com.qiniu.android.storage.UploadOptions;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QiniuUploader
{
  private static volatile boolean isCancelled;
  private static final BlockingQueue<Picture> mUpFailedQueue = new LinkedBlockingQueue();
  private static final Vector<JSONObject> mUpSuccessQueue = new Vector();
  private static IPictureUpload mUploadListener;
  private static UploadManager mUploadManager = new UploadManager();
  private static final BlockingQueue<Picture> mUploadingQueue = new LinkedBlockingQueue();
  
  public static void cancelAll()
  {
    isCancelled = true;
  }
  
  private static UploadOptions createUploadOptions()
  {
    return new UploadOptions(null, "image/png", false, new QiniuUploader.2(), new QiniuUploader.3());
  }
  
  public static void upload(Context paramContext, IPictureUpload paramIPictureUpload, List<String> paramList)
  {
    mUploadListener = paramIPictureUpload;
    if ((paramList == null) || (paramList.size() == 0))
    {
      mUploadListener.onFailed("图片路径不能为空！");
      return;
    }
    new QiniuUploader.1(new ArrayList(), paramContext, paramList).execute(new String[0]);
  }
  
  public static void upload(Context paramContext, IPictureUpload paramIPictureUpload, String... paramVarArgs)
  {
    mUploadListener = paramIPictureUpload;
    if ((paramVarArgs == null) || (paramVarArgs.length == 0))
    {
      mUploadListener.onFailed("图片路径不能为空！");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = paramVarArgs.length;
    for (int j = 0; j < i; j++) {
      localArrayList.add(paramVarArgs[j]);
    }
    upload(paramContext, paramIPictureUpload, localArrayList);
  }
  
  private static void uploadIfNeedCompress(Context paramContext, int paramInt, Picture paramPicture)
  {
    String str1 = QiniuConfig.getUploadFileName(PictureUpload.sUploadPath);
    String str2 = QiniuConfig.getToken();
    try
    {
      if (paramPicture.size > paramInt)
      {
        ByteArrayOutputStream localByteArrayOutputStream = BitmapUtils.compressBitmap(paramContext, paramPicture, 70);
        mUploadManager.put(localByteArrayOutputStream.toByteArray(), str1, str2, new QiniuUploader.UploadComplete(paramPicture), createUploadOptions());
        localByteArrayOutputStream.close();
        return;
      }
      mUploadManager.put(paramPicture.path, str1, str2, new QiniuUploader.UploadComplete(paramPicture), createUploadOptions());
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
  
  private static void uploadSuccess(JSONObject paramJSONObject, Picture paramPicture)
  {
    try
    {
      paramJSONObject.put("path", paramPicture.path);
      paramJSONObject.put("width", paramPicture.width);
      paramJSONObject.put("height", paramPicture.height);
      mUpSuccessQueue.add(paramJSONObject);
      if ((mUploadingQueue.size() == 0) && (mUpFailedQueue.size() == 0))
      {
        JSONArray localJSONArray = new JSONArray();
        for (int i = 0; i < mUpSuccessQueue.size(); i++) {
          localJSONArray.put(i, mUpSuccessQueue.get(i));
        }
        mUploadListener.onSuccess(localJSONArray.toString());
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.pictures.QiniuUploader
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */