package com.boohee.pictures;

import com.boohee.pictures.util.ParseUtils;
import com.loopj.android.http.JsonHttpResponseHandler;
import java.util.concurrent.BlockingQueue;
import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

class QiniuUploader$BooheeUploadHandler
  extends JsonHttpResponseHandler
{
  private final Picture mFailedPicture;
  
  public QiniuUploader$BooheeUploadHandler(Picture paramPicture)
  {
    this.mFailedPicture = paramPicture;
  }
  
  private void failed()
  {
    if (QiniuUploader.access$200().size() == 0) {
      QiniuUploader.access$000().onFailed(ParseUtils.toJson(QiniuUploader.access$400()));
    }
  }
  
  public void onFailure(int paramInt, Header[] paramArrayOfHeader, Throwable paramThrowable, JSONObject paramJSONObject)
  {
    super.onFailure(paramInt, paramArrayOfHeader, paramThrowable, paramJSONObject);
    failed();
  }
  
  public void onSuccess(int paramInt, Header[] paramArrayOfHeader, JSONObject paramJSONObject)
  {
    super.onSuccess(paramInt, paramArrayOfHeader, paramJSONObject);
    if (paramJSONObject != null) {}
    try
    {
      if ("succeed".equalsIgnoreCase(paramJSONObject.getString("status")))
      {
        QiniuUploader.access$400().remove(this.mFailedPicture);
        JSONObject localJSONObject = new JSONObject();
        this.mFailedPicture.width = paramJSONObject.optInt("origin_width");
        this.mFailedPicture.height = paramJSONObject.optInt("origin_height");
        localJSONObject.put("key", paramJSONObject.optString("qiniu_key"));
        QiniuUploader.access$300(localJSONObject, this.mFailedPicture);
        return;
      }
      failed();
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.pictures.QiniuUploader.BooheeUploadHandler
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */