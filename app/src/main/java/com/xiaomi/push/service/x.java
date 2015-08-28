package com.xiaomi.push.service;

public abstract class x
{
  public static String a = "com.xiaomi.push.OPEN_CHANNEL";
  public static String b = "com.xiaomi.push.SEND_MESSAGE";
  public static String c = "com.xiaomi.push.SEND_IQ";
  public static String d = "com.xiaomi.push.BATCH_SEND_MESSAGE";
  public static String e = "com.xiaomi.push.SEND_PRES";
  public static String f = "com.xiaomi.push.CLOSE_CHANNEL";
  public static String g = "com.xiaomi.push.FORCE_RECONN";
  public static String h = "com.xiaomi.push.RESET_CONN";
  public static String i = "com.xiaomi.push.UPDATE_CHANNEL_INFO";
  public static String j = "com.xiaomi.push.SEND_STATS";
  public static String k = "com.xiaomi.push.CHANGE_HOST";
  public static String l = "com.xiaomi.push.PING_TIMER";
  public static String m = "ext_user_id";
  public static String n = "ext_chid";
  public static String o = "ext_sid";
  public static String p = "ext_token";
  public static String q = "ext_auth_method";
  public static String r = "ext_security";
  public static String s = "ext_kick";
  public static String t = "ext_client_attr";
  public static String u = "ext_cloud_attr";
  public static String v = "ext_pkg_name";
  public static String w = "ext_notify_id";
  public static String x = "ext_notify_type";
  public static String y = "ext_session";
  public static String z = "sig";
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return String.valueOf(paramInt);
    case 0: 
      return "ERROR_OK";
    case 1: 
      return "ERROR_SERVICE_NOT_INSTALLED";
    case 2: 
      return "ERROR_NETWORK_NOT_AVAILABLE";
    case 3: 
      return "ERROR_NETWORK_FAILED";
    case 4: 
      return "ERROR_ACCESS_DENIED";
    case 5: 
      return "ERROR_AUTH_FAILED";
    case 6: 
      return "ERROR_MULTI_LOGIN";
    case 7: 
      return "ERROR_SERVER_ERROR";
    case 8: 
      return "ERROR_RECEIVE_TIMEOUT";
    case 9: 
      return "ERROR_READ_ERROR";
    case 10: 
      return "ERROR_SEND_ERROR";
    case 11: 
      return "ERROR_RESET";
    case 12: 
      return "ERROR_NO_CLIENT";
    case 13: 
      return "ERROR_SERVER_STREAM";
    case 14: 
      return "ERROR_THREAD_BLOCK";
    case 15: 
      return "ERROR_SERVICE_DESTROY";
    case 16: 
      return "ERROR_SESSION_CHANGED";
    case 17: 
      return "ERROR_READ_TIMEOUT";
    case 18: 
      return "ERROR_CONNECTIING_TIMEOUT";
    case 19: 
      return "ERROR_USER_BLOCKED";
    case 20: 
      return "ERROR_REDIRECT";
    case 21: 
      return "ERROR_BIND_TIMEOUT";
    }
    return "ERROR_PING_TIMEOUT";
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.push.service.x
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */