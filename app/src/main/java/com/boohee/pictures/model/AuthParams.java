package com.boohee.pictures.model;

import android.content.Context;
import com.boohee.pictures.util.EnvHelper;

public class AuthParams
{
  public String osVersion = EnvHelper.getOSVersion();
  public String token;
  public String userKey;
  public String versionName;
  
  public AuthParams(Context paramContext, String paramString1, String paramString2)
  {
    this.versionName = EnvHelper.getVersionName(paramContext);
    this.token = paramString1;
    this.userKey = paramString2;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.boohee.pictures.model.AuthParams
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */