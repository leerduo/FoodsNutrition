package cn.sharesdk.onekeyshare;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import cn.sharesdk.framework.FakeActivity;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.utils.R;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class EditPageFakeActivity
  extends FakeActivity
{
  protected View backgroundView;
  protected boolean dialogMode;
  protected List<Platform> platforms;
  private ArrayList<EditPageFakeActivity.ImageInfo> shareImageList;
  protected HashMap<String, Object> shareParamMap;
  protected ArrayList<String> toFriendList;
  
  protected String getAtUserButtonText(String paramString)
  {
    if ("FacebookMessenger".equals(paramString)) {
      return "To";
    }
    return "@";
  }
  
  protected String getJoinSelectedUser(HashMap<String, Object> paramHashMap)
  {
    if ((paramHashMap != null) && (paramHashMap.containsKey("selected")))
    {
      ArrayList localArrayList = (ArrayList)paramHashMap.get("selected");
      if ("FacebookMessenger".equals(((Platform)paramHashMap.get("platform")).getName()))
      {
        this.toFriendList = localArrayList;
        return null;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = localArrayList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localStringBuilder.append('@').append(str).append(' ');
      }
      return localStringBuilder.toString();
    }
    return null;
  }
  
  public String getLogoName(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    int i = R.getStringRes(getContext(), paramString);
    return getContext().getString(i);
  }
  
  protected boolean initImageList(EditPageFakeActivity.ImageListResultsCallback paramImageListResultsCallback)
  {
    String str1 = (String)this.shareParamMap.get("imageUrl");
    String str2 = (String)this.shareParamMap.get("imagePath");
    Bitmap localBitmap = (Bitmap)this.shareParamMap.get("viewToShare");
    String[] arrayOfString = (String[])this.shareParamMap.get("imageArray");
    this.shareImageList = new ArrayList();
    if ((!TextUtils.isEmpty(str2)) && (new File(str2).exists()))
    {
      EditPageFakeActivity.ImageInfo localImageInfo4 = new EditPageFakeActivity.ImageInfo();
      localImageInfo4.paramName = "imagePath";
      localImageInfo4.srcValue = str2;
      this.shareImageList.add(localImageInfo4);
      this.shareParamMap.remove("imagePath");
    }
    while (this.shareImageList.size() == 0)
    {
      return false;
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        EditPageFakeActivity.ImageInfo localImageInfo3 = new EditPageFakeActivity.ImageInfo();
        localImageInfo3.paramName = "viewToShare";
        localImageInfo3.bitmap = localBitmap;
        this.shareImageList.add(localImageInfo3);
        this.shareParamMap.remove("viewToShare");
      }
      else if (!TextUtils.isEmpty(str1))
      {
        EditPageFakeActivity.ImageInfo localImageInfo1 = new EditPageFakeActivity.ImageInfo();
        localImageInfo1.paramName = "imageUrl";
        localImageInfo1.srcValue = str1;
        this.shareImageList.add(localImageInfo1);
        this.shareParamMap.remove("imageUrl");
      }
      else if ((arrayOfString != null) && (arrayOfString.length > 0))
      {
        int i = arrayOfString.length;
        int j = 0;
        if (j < i)
        {
          String str3 = arrayOfString[j];
          if (TextUtils.isEmpty(str3)) {}
          for (;;)
          {
            j++;
            break;
            EditPageFakeActivity.ImageInfo localImageInfo2 = new EditPageFakeActivity.ImageInfo();
            localImageInfo2.paramName = "imageArray";
            localImageInfo2.srcValue = str3;
            this.shareImageList.add(localImageInfo2);
          }
        }
        this.shareParamMap.remove("imageArray");
      }
    }
    new EditPageFakeActivity.1(this).execute(new Object[] { paramImageListResultsCallback });
    return true;
  }
  
  protected boolean isShowAtUserLayout(String paramString)
  {
    return ("SinaWeibo".equals(paramString)) || ("TencentWeibo".equals(paramString)) || ("Facebook".equals(paramString)) || ("Twitter".equals(paramString)) || ("FacebookMessenger".equals(paramString));
  }
  
  public boolean onFinish()
  {
    this.shareImageList = null;
    return super.onFinish();
  }
  
  protected void removeImage(EditPageFakeActivity.ImageInfo paramImageInfo)
  {
    if ((this.shareImageList == null) || (paramImageInfo == null)) {
      return;
    }
    this.shareImageList.remove(paramImageInfo);
  }
  
  public void setBackgroundView(View paramView)
  {
    this.backgroundView = paramView;
  }
  
  public void setDialogMode()
  {
    this.dialogMode = true;
  }
  
  public void setPlatforms(List<Platform> paramList)
  {
    this.platforms = paramList;
  }
  
  protected void setResultAndFinish()
  {
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap1;
    Iterator localIterator1;
    if (this.shareImageList != null)
    {
      Iterator localIterator2 = this.shareImageList.iterator();
      while (localIterator2.hasNext())
      {
        EditPageFakeActivity.ImageInfo localImageInfo = (EditPageFakeActivity.ImageInfo)localIterator2.next();
        if (("imagePath".equals(localImageInfo.paramName)) || ("imageUrl".equals(localImageInfo.paramName))) {
          this.shareParamMap.put(localImageInfo.paramName, localImageInfo.srcValue);
        } else if ("viewToShare".equals(localImageInfo.paramName)) {
          this.shareParamMap.put(localImageInfo.paramName, localImageInfo.bitmap);
        } else if ("imageArray".equals(localImageInfo.paramName)) {
          localArrayList.add(localImageInfo.srcValue);
        }
      }
      this.shareImageList.clear();
      if (localArrayList.size() == 0) {
        this.shareParamMap.put("imageArray", null);
      }
    }
    else
    {
      localHashMap1 = new HashMap();
      localIterator1 = this.platforms.iterator();
    }
    for (;;)
    {
      if (!localIterator1.hasNext()) {
        break label418;
      }
      Platform localPlatform = (Platform)localIterator1.next();
      if ("FacebookMessenger".equals(localPlatform.getName()))
      {
        HashMap localHashMap3 = new HashMap(this.shareParamMap);
        if ((this.toFriendList != null) && (this.toFriendList.size() > 0)) {
          localHashMap3.put("address", this.toFriendList.get(-1 + this.toFriendList.size()));
        }
        if (localHashMap3.get("address") == null)
        {
          int i = R.getStringRes(this.activity, "select_a_friend");
          if (i > 0) {
            Toast.makeText(getContext(), this.activity.getString(i) + " - " + localPlatform.getName(), 0).show();
          }
          return;
          this.shareParamMap.put("imageArray", localArrayList.toArray(new String[localArrayList.size()]));
          break;
        }
        localHashMap1.put(localPlatform, localHashMap3);
        ShareSDK.logDemoEvent(3, localPlatform);
        continue;
      }
      ShareSDK.logDemoEvent(3, localPlatform);
      localHashMap1.put(localPlatform, this.shareParamMap);
    }
    label418:
    HashMap localHashMap2 = new HashMap();
    localHashMap2.put("editRes", localHashMap1);
    setResult(localHashMap2);
    finish();
  }
  
  public void setShareData(HashMap<String, Object> paramHashMap)
  {
    this.shareParamMap = paramHashMap;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     cn.sharesdk.onekeyshare.EditPageFakeActivity
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */