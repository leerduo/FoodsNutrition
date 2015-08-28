package com.xiaomi.kenai.jbosh;

import java.util.HashMap;
import java.util.Map;

final class aq
{
  static final aq a = a("bad-request", "The format of an HTTP header or binding element received from the client is unacceptable (e.g., syntax error).", Integer.valueOf(400));
  static final aq b = a("host-gone", "The target domain specified in the 'to' attribute or the target host or port specified in the 'route' attribute is no longer serviced by the connection manager.");
  static final aq c = a("host-unknown", "The target domain specified in the 'to' attribute or the target host or port specified in the 'route' attribute is unknown to the connection manager.");
  static final aq d = a("improper-addressing", "The initialization element lacks a 'to' or 'route' attribute (or the attribute has no value) but the connection manager requires one.");
  static final aq e = a("internal-server-error", "The connection manager has experienced an internal error that prevents it from servicing the request.");
  static final aq f = a("item-not-found", "(1) 'sid' is not valid, (2) 'stream' is not valid, (3) 'rid' is larger than the upper limit of the expected window, (4) connection manager is unable to resend response, (5) 'key' sequence is invalid.", Integer.valueOf(404));
  static final aq g = a("other-request", "Another request being processed at the same time as this request caused the session to terminate.");
  static final aq h = a("policy-violation", "The client has broken the session rules (polling too frequently, requesting too frequently, sending too many simultaneous requests).", Integer.valueOf(403));
  static final aq i = a("remote-connection-failed", "The connection manager was unable to connect to, or unable to connect securely to, or has lost its connection to, the server.");
  static final aq j = a("remote-stream-error", "Encapsulated transport protocol error.");
  static final aq k = a("see-other-uri", "The connection manager does not operate at this URI (e.g., the connection manager accepts only SSL or TLS connections at some https: URI rather than the http: URI requested by the client).");
  static final aq l = a("system-shutdown", "The connection manager is being shut down. All active HTTP sessions are being terminated. No new sessions can be created.");
  static final aq m = a("undefined-condition", "Unknown or undefined error condition.");
  private static final Map<String, aq> n = new HashMap();
  private static final Map<Integer, aq> o = new HashMap();
  private final String p;
  private final String q;
  
  private aq(String paramString1, String paramString2)
  {
    this.p = paramString1;
    this.q = paramString2;
  }
  
  static aq a(int paramInt)
  {
    return (aq)o.get(Integer.valueOf(paramInt));
  }
  
  static aq a(String paramString)
  {
    return (aq)n.get(paramString);
  }
  
  private static aq a(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, null);
  }
  
  private static aq a(String paramString1, String paramString2, Integer paramInteger)
  {
    if (paramString1 == null) {
      throw new IllegalArgumentException("condition may not be null");
    }
    if (paramString2 == null) {
      throw new IllegalArgumentException("message may not be null");
    }
    if (n.get(paramString1) != null) {
      throw new IllegalStateException("Multiple definitions of condition: " + paramString1);
    }
    aq localaq = new aq(paramString1, paramString2);
    n.put(paramString1, localaq);
    if (paramInteger != null)
    {
      if (o.get(paramInteger) != null) {
        throw new IllegalStateException("Multiple definitions of code: " + paramInteger);
      }
      o.put(paramInteger, localaq);
    }
    return localaq;
  }
  
  String a()
  {
    return this.p;
  }
  
  String b()
  {
    return this.q;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.kenai.jbosh.aq
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */