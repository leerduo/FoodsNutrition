package com.xiaomi.smack.util;

import com.xiaomi.smack.j;
import com.xiaomi.smack.packet.a;
import com.xiaomi.smack.packet.b.a;
import com.xiaomi.smack.packet.f;
import com.xiaomi.smack.packet.f.a;
import com.xiaomi.smack.packet.f.b;
import com.xiaomi.smack.packet.g;
import com.xiaomi.smack.packet.h;
import com.xiaomi.smack.packet.h.a;
import com.xiaomi.smack.s.b;
import com.xiaomi.smack.s.b.a;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class c
{
  private static XmlPullParser a = null;
  
  public static a a(String paramString1, String paramString2, XmlPullParser paramXmlPullParser)
  {
    Object localObject = com.xiaomi.smack.provider.c.a().a("all", "xm:chat");
    if ((localObject != null) && ((localObject instanceof com.xiaomi.push.service.c))) {
      return ((com.xiaomi.push.service.c)localObject).b(paramXmlPullParser);
    }
    return null;
  }
  
  public static com.xiaomi.smack.packet.b a(XmlPullParser paramXmlPullParser, j paramj)
  {
    String str1 = paramXmlPullParser.getAttributeValue("", "id");
    String str2 = paramXmlPullParser.getAttributeValue("", "to");
    String str3 = paramXmlPullParser.getAttributeValue("", "from");
    String str4 = paramXmlPullParser.getAttributeValue("", "chid");
    b.a locala = b.a.a(paramXmlPullParser.getAttributeValue("", "type"));
    int i = 0;
    Object localObject1 = null;
    Object localObject2 = null;
    int j;
    String str5;
    String str6;
    label121:
    Object localObject3;
    Object localObject4;
    int m;
    if (i == 0)
    {
      j = paramXmlPullParser.next();
      if (j == 2)
      {
        str5 = paramXmlPullParser.getName();
        str6 = paramXmlPullParser.getNamespace();
        if (str5.equals("error"))
        {
          localObject1 = e(paramXmlPullParser);
          int i1 = i;
          localObject3 = localObject2;
          localObject4 = localObject1;
          m = i1;
        }
      }
    }
    for (;;)
    {
      int n = m;
      localObject1 = localObject4;
      localObject2 = localObject3;
      i = n;
      break;
      localObject2 = new com.xiaomi.smack.packet.b();
      ((com.xiaomi.smack.packet.b)localObject2).a(a(str5, str6, paramXmlPullParser));
      break label121;
      if ((j == 3) && (paramXmlPullParser.getName().equals("iq")))
      {
        localObject3 = localObject2;
        localObject4 = localObject1;
        m = 1;
        continue;
        if (localObject2 == null)
        {
          if ((b.a.a == locala) || (b.a.b == locala))
          {
            d locald = new d();
            locald.k(str1);
            locald.m(str3);
            locald.n(str2);
            locald.a(b.a.d);
            locald.l(str4);
            locald.a(new h(h.a.e));
            paramj.a(locald);
            com.xiaomi.channel.commonutils.logger.b.c("iq usage error. send packet in packet parser.");
            return null;
          }
          localObject2 = new e();
        }
        ((com.xiaomi.smack.packet.b)localObject2).k(str1);
        ((com.xiaomi.smack.packet.b)localObject2).m(str2);
        ((com.xiaomi.smack.packet.b)localObject2).l(str4);
        ((com.xiaomi.smack.packet.b)localObject2).n(str3);
        ((com.xiaomi.smack.packet.b)localObject2).a(locala);
        ((com.xiaomi.smack.packet.b)localObject2).a((h)localObject1);
        return localObject2;
      }
      else
      {
        int k = i;
        localObject3 = localObject2;
        localObject4 = localObject1;
        m = k;
      }
    }
  }
  
  /* Error */
  public static com.xiaomi.smack.packet.d a(XmlPullParser paramXmlPullParser)
  {
    // Byte code:
    //   0: ldc 148
    //   2: aload_0
    //   3: ldc 32
    //   5: ldc 150
    //   7: invokeinterface 40 3 0
    //   12: invokevirtual 72	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15: ifeq +370 -> 385
    //   18: aload_0
    //   19: ldc 32
    //   21: ldc 46
    //   23: invokeinterface 40 3 0
    //   28: astore 24
    //   30: aload_0
    //   31: ldc 32
    //   33: ldc 34
    //   35: invokeinterface 40 3 0
    //   40: astore 25
    //   42: aload_0
    //   43: ldc 32
    //   45: ldc 44
    //   47: invokeinterface 40 3 0
    //   52: astore 26
    //   54: aload_0
    //   55: ldc 32
    //   57: ldc 42
    //   59: invokeinterface 40 3 0
    //   64: astore 27
    //   66: aload_0
    //   67: ldc 32
    //   69: ldc 48
    //   71: invokeinterface 40 3 0
    //   76: astore 28
    //   78: invokestatic 155	com/xiaomi/push/service/v:a	()Lcom/xiaomi/push/service/v;
    //   81: aload 24
    //   83: aload 27
    //   85: invokevirtual 158	com/xiaomi/push/service/v:b	(Ljava/lang/String;Ljava/lang/String;)Lcom/xiaomi/push/service/v$b;
    //   88: astore 29
    //   90: aload 29
    //   92: ifnonnull +849 -> 941
    //   95: invokestatic 155	com/xiaomi/push/service/v:a	()Lcom/xiaomi/push/service/v;
    //   98: aload 24
    //   100: aload 26
    //   102: invokevirtual 158	com/xiaomi/push/service/v:b	(Ljava/lang/String;Ljava/lang/String;)Lcom/xiaomi/push/service/v$b;
    //   105: astore 30
    //   107: aload 30
    //   109: ifnonnull +13 -> 122
    //   112: new 160	com/xiaomi/smack/w
    //   115: dup
    //   116: ldc 162
    //   118: invokespecial 164	com/xiaomi/smack/w:<init>	(Ljava/lang/String;)V
    //   121: athrow
    //   122: iconst_0
    //   123: istore 31
    //   125: aconst_null
    //   126: astore 32
    //   128: iload 31
    //   130: ifne +240 -> 370
    //   133: aload_0
    //   134: invokeinterface 57 1 0
    //   139: istore 33
    //   141: iload 33
    //   143: iconst_2
    //   144: if_icmpne +200 -> 344
    //   147: ldc 150
    //   149: aload_0
    //   150: invokeinterface 61 1 0
    //   155: invokevirtual 72	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   158: ifne +13 -> 171
    //   161: new 160	com/xiaomi/smack/w
    //   164: dup
    //   165: ldc 166
    //   167: invokespecial 164	com/xiaomi/smack/w:<init>	(Ljava/lang/String;)V
    //   170: athrow
    //   171: aload_0
    //   172: invokeinterface 57 1 0
    //   177: iconst_4
    //   178: if_icmpeq +13 -> 191
    //   181: new 160	com/xiaomi/smack/w
    //   184: dup
    //   185: ldc 166
    //   187: invokespecial 164	com/xiaomi/smack/w:<init>	(Ljava/lang/String;)V
    //   190: athrow
    //   191: aload_0
    //   192: invokeinterface 169 1 0
    //   197: astore 34
    //   199: ldc 171
    //   201: aload 24
    //   203: invokevirtual 72	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   206: ifne +13 -> 219
    //   209: ldc 173
    //   211: aload 24
    //   213: invokevirtual 72	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   216: ifeq +90 -> 306
    //   219: new 175	com/xiaomi/smack/packet/c
    //   222: dup
    //   223: invokespecial 176	com/xiaomi/smack/packet/c:<init>	()V
    //   226: astore 32
    //   228: aload 32
    //   230: aload 24
    //   232: invokevirtual 177	com/xiaomi/smack/packet/c:l	(Ljava/lang/String;)V
    //   235: aload 32
    //   237: iconst_1
    //   238: invokevirtual 180	com/xiaomi/smack/packet/c:b	(Z)V
    //   241: aload 32
    //   243: aload 26
    //   245: invokevirtual 181	com/xiaomi/smack/packet/c:n	(Ljava/lang/String;)V
    //   248: aload 32
    //   250: aload 27
    //   252: invokevirtual 182	com/xiaomi/smack/packet/c:m	(Ljava/lang/String;)V
    //   255: aload 32
    //   257: aload 25
    //   259: invokevirtual 183	com/xiaomi/smack/packet/c:k	(Ljava/lang/String;)V
    //   262: aload 32
    //   264: aload 28
    //   266: invokevirtual 186	com/xiaomi/smack/packet/c:f	(Ljava/lang/String;)V
    //   269: new 188	com/xiaomi/smack/packet/a
    //   272: dup
    //   273: ldc 150
    //   275: aconst_null
    //   276: aconst_null
    //   277: checkcast 190	[Ljava/lang/String;
    //   280: aconst_null
    //   281: checkcast 190	[Ljava/lang/String;
    //   284: invokespecial 193	com/xiaomi/smack/packet/a:<init>	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/String;)V
    //   287: astore 35
    //   289: aload 35
    //   291: aload 34
    //   293: invokevirtual 195	com/xiaomi/smack/packet/a:b	(Ljava/lang/String;)V
    //   296: aload 32
    //   298: aload 35
    //   300: invokevirtual 196	com/xiaomi/smack/packet/c:a	(Lcom/xiaomi/smack/packet/a;)V
    //   303: aload 32
    //   305: areturn
    //   306: aload 30
    //   308: getfield 202	com/xiaomi/push/service/v$b:i	Ljava/lang/String;
    //   311: aload 25
    //   313: invokestatic 207	com/xiaomi/push/service/z:a	(Ljava/lang/String;Ljava/lang/String;)[B
    //   316: aload 34
    //   318: invokestatic 210	com/xiaomi/push/service/z:b	([BLjava/lang/String;)[B
    //   321: invokestatic 213	com/xiaomi/smack/util/c:a	([B)V
    //   324: getstatic 10	com/xiaomi/smack/util/c:a	Lorg/xmlpull/v1/XmlPullParser;
    //   327: invokeinterface 57 1 0
    //   332: pop
    //   333: getstatic 10	com/xiaomi/smack/util/c:a	Lorg/xmlpull/v1/XmlPullParser;
    //   336: invokestatic 215	com/xiaomi/smack/util/c:a	(Lorg/xmlpull/v1/XmlPullParser;)Lcom/xiaomi/smack/packet/d;
    //   339: astore 32
    //   341: goto -213 -> 128
    //   344: iload 33
    //   346: iconst_3
    //   347: if_icmpne -219 -> 128
    //   350: aload_0
    //   351: invokeinterface 61 1 0
    //   356: ldc 217
    //   358: invokevirtual 72	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   361: ifeq -233 -> 128
    //   364: iconst_1
    //   365: istore 31
    //   367: goto -239 -> 128
    //   370: aload 32
    //   372: ifnonnull -69 -> 303
    //   375: new 160	com/xiaomi/smack/w
    //   378: dup
    //   379: ldc 166
    //   381: invokespecial 164	com/xiaomi/smack/w:<init>	(Ljava/lang/String;)V
    //   384: athrow
    //   385: new 175	com/xiaomi/smack/packet/c
    //   388: dup
    //   389: invokespecial 176	com/xiaomi/smack/packet/c:<init>	()V
    //   392: astore_1
    //   393: aload_0
    //   394: ldc 32
    //   396: ldc 34
    //   398: invokeinterface 40 3 0
    //   403: astore_2
    //   404: aload_2
    //   405: ifnonnull +6 -> 411
    //   408: ldc 219
    //   410: astore_2
    //   411: aload_1
    //   412: aload_2
    //   413: invokevirtual 183	com/xiaomi/smack/packet/c:k	(Ljava/lang/String;)V
    //   416: aload_1
    //   417: aload_0
    //   418: ldc 32
    //   420: ldc 42
    //   422: invokeinterface 40 3 0
    //   427: invokevirtual 182	com/xiaomi/smack/packet/c:m	(Ljava/lang/String;)V
    //   430: aload_1
    //   431: aload_0
    //   432: ldc 32
    //   434: ldc 44
    //   436: invokeinterface 40 3 0
    //   441: invokevirtual 181	com/xiaomi/smack/packet/c:n	(Ljava/lang/String;)V
    //   444: aload_1
    //   445: aload_0
    //   446: ldc 32
    //   448: ldc 46
    //   450: invokeinterface 40 3 0
    //   455: invokevirtual 177	com/xiaomi/smack/packet/c:l	(Ljava/lang/String;)V
    //   458: aload_1
    //   459: aload_0
    //   460: ldc 32
    //   462: ldc 221
    //   464: invokeinterface 40 3 0
    //   469: invokevirtual 223	com/xiaomi/smack/packet/c:a	(Ljava/lang/String;)V
    //   472: aload_0
    //   473: ldc 32
    //   475: ldc 225
    //   477: invokeinterface 40 3 0
    //   482: astore 23
    //   484: aload 23
    //   486: astore 4
    //   488: aload_0
    //   489: ldc 32
    //   491: ldc 227
    //   493: invokeinterface 40 3 0
    //   498: astore 22
    //   500: aload 22
    //   502: invokestatic 233	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   505: ifne +9 -> 514
    //   508: aload_1
    //   509: aload 22
    //   511: invokevirtual 234	com/xiaomi/smack/packet/c:b	(Ljava/lang/String;)V
    //   514: aload_0
    //   515: ldc 32
    //   517: ldc 236
    //   519: invokeinterface 40 3 0
    //   524: astore 21
    //   526: aload 21
    //   528: invokestatic 233	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   531: ifne +9 -> 540
    //   534: aload_1
    //   535: aload 21
    //   537: invokevirtual 237	com/xiaomi/smack/packet/c:c	(Ljava/lang/String;)V
    //   540: aload_0
    //   541: ldc 32
    //   543: ldc 239
    //   545: invokeinterface 40 3 0
    //   550: astore 20
    //   552: aload 20
    //   554: invokestatic 233	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   557: ifne +9 -> 566
    //   560: aload_1
    //   561: aload 20
    //   563: invokevirtual 241	com/xiaomi/smack/packet/c:d	(Ljava/lang/String;)V
    //   566: aload_0
    //   567: ldc 32
    //   569: ldc 243
    //   571: invokeinterface 40 3 0
    //   576: astore 19
    //   578: aload 19
    //   580: invokestatic 233	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   583: ifne +9 -> 592
    //   586: aload_1
    //   587: aload 19
    //   589: invokevirtual 245	com/xiaomi/smack/packet/c:e	(Ljava/lang/String;)V
    //   592: aload 4
    //   594: invokestatic 233	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   597: ifne +156 -> 753
    //   600: aload 4
    //   602: ldc 247
    //   604: invokevirtual 251	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   607: ifeq +146 -> 753
    //   610: iconst_1
    //   611: istore 9
    //   613: aload_1
    //   614: iload 9
    //   616: invokevirtual 253	com/xiaomi/smack/packet/c:a	(Z)V
    //   619: aload_1
    //   620: aload_0
    //   621: ldc 32
    //   623: ldc 48
    //   625: invokeinterface 40 3 0
    //   630: invokevirtual 186	com/xiaomi/smack/packet/c:f	(Ljava/lang/String;)V
    //   633: aload_0
    //   634: invokestatic 257	com/xiaomi/smack/util/c:g	(Lorg/xmlpull/v1/XmlPullParser;)Ljava/lang/String;
    //   637: astore 10
    //   639: aload 10
    //   641: ifnull +118 -> 759
    //   644: ldc 32
    //   646: aload 10
    //   648: invokevirtual 260	java/lang/String:trim	()Ljava/lang/String;
    //   651: invokevirtual 72	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   654: ifne +105 -> 759
    //   657: aload_1
    //   658: aload 10
    //   660: invokevirtual 263	com/xiaomi/smack/packet/c:j	(Ljava/lang/String;)V
    //   663: aconst_null
    //   664: astore 12
    //   666: iconst_0
    //   667: istore 13
    //   669: iload 13
    //   671: ifne +242 -> 913
    //   674: aload_0
    //   675: invokeinterface 57 1 0
    //   680: istore 14
    //   682: iload 14
    //   684: iconst_2
    //   685: if_icmpne +202 -> 887
    //   688: aload_0
    //   689: invokeinterface 61 1 0
    //   694: astore 15
    //   696: aload_0
    //   697: invokeinterface 64 1 0
    //   702: astore 16
    //   704: aload 16
    //   706: invokestatic 233	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   709: ifeq +8 -> 717
    //   712: ldc_w 265
    //   715: astore 16
    //   717: aload 15
    //   719: ldc_w 267
    //   722: invokevirtual 72	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   725: ifeq +41 -> 766
    //   728: aload_0
    //   729: invokestatic 257	com/xiaomi/smack/util/c:g	(Lorg/xmlpull/v1/XmlPullParser;)Ljava/lang/String;
    //   732: ifnonnull +3 -> 735
    //   735: aload_1
    //   736: aload_0
    //   737: invokestatic 269	com/xiaomi/smack/util/c:f	(Lorg/xmlpull/v1/XmlPullParser;)Ljava/lang/String;
    //   740: invokevirtual 271	com/xiaomi/smack/packet/c:g	(Ljava/lang/String;)V
    //   743: goto -74 -> 669
    //   746: astore_3
    //   747: aconst_null
    //   748: astore 4
    //   750: goto -262 -> 488
    //   753: iconst_0
    //   754: istore 9
    //   756: goto -143 -> 613
    //   759: invokestatic 276	com/xiaomi/smack/packet/d:u	()Ljava/lang/String;
    //   762: pop
    //   763: goto -100 -> 663
    //   766: aload 15
    //   768: ldc_w 278
    //   771: invokevirtual 72	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   774: ifeq +50 -> 824
    //   777: aload_0
    //   778: ldc 32
    //   780: ldc_w 280
    //   783: invokeinterface 40 3 0
    //   788: astore 17
    //   790: aload_0
    //   791: invokestatic 269	com/xiaomi/smack/util/c:f	(Lorg/xmlpull/v1/XmlPullParser;)Ljava/lang/String;
    //   794: astore 18
    //   796: aload 17
    //   798: invokestatic 233	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   801: ifne +14 -> 815
    //   804: aload_1
    //   805: aload 18
    //   807: aload 17
    //   809: invokevirtual 283	com/xiaomi/smack/packet/c:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   812: goto -143 -> 669
    //   815: aload_1
    //   816: aload 18
    //   818: invokevirtual 286	com/xiaomi/smack/packet/c:h	(Ljava/lang/String;)V
    //   821: goto -152 -> 669
    //   824: aload 15
    //   826: ldc_w 288
    //   829: invokevirtual 72	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   832: ifeq +19 -> 851
    //   835: aload 12
    //   837: ifnonnull -168 -> 669
    //   840: aload_0
    //   841: invokeinterface 291 1 0
    //   846: astore 12
    //   848: goto -179 -> 669
    //   851: aload 15
    //   853: ldc 66
    //   855: invokevirtual 72	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   858: ifeq +14 -> 872
    //   861: aload_1
    //   862: aload_0
    //   863: invokestatic 76	com/xiaomi/smack/util/c:e	(Lorg/xmlpull/v1/XmlPullParser;)Lcom/xiaomi/smack/packet/h;
    //   866: invokevirtual 292	com/xiaomi/smack/packet/c:a	(Lcom/xiaomi/smack/packet/h;)V
    //   869: goto -200 -> 669
    //   872: aload_1
    //   873: aload 15
    //   875: aload 16
    //   877: aload_0
    //   878: invokestatic 83	com/xiaomi/smack/util/c:a	(Ljava/lang/String;Ljava/lang/String;Lorg/xmlpull/v1/XmlPullParser;)Lcom/xiaomi/smack/packet/a;
    //   881: invokevirtual 196	com/xiaomi/smack/packet/c:a	(Lcom/xiaomi/smack/packet/a;)V
    //   884: goto -215 -> 669
    //   887: iload 14
    //   889: iconst_3
    //   890: if_icmpne -221 -> 669
    //   893: aload_0
    //   894: invokeinterface 61 1 0
    //   899: ldc 217
    //   901: invokevirtual 72	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   904: ifeq -235 -> 669
    //   907: iconst_1
    //   908: istore 13
    //   910: goto -241 -> 669
    //   913: aload_1
    //   914: aload 12
    //   916: invokevirtual 294	com/xiaomi/smack/packet/c:i	(Ljava/lang/String;)V
    //   919: aload_1
    //   920: areturn
    //   921: astore 8
    //   923: goto -331 -> 592
    //   926: astore 7
    //   928: goto -362 -> 566
    //   931: astore 6
    //   933: goto -393 -> 540
    //   936: astore 5
    //   938: goto -424 -> 514
    //   941: aload 29
    //   943: astore 30
    //   945: goto -838 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	948	0	paramXmlPullParser	XmlPullParser
    //   392	528	1	localc	com.xiaomi.smack.packet.c
    //   403	10	2	str1	String
    //   746	1	3	localException1	java.lang.Exception
    //   486	263	4	str2	String
    //   936	1	5	localException2	java.lang.Exception
    //   931	1	6	localException3	java.lang.Exception
    //   926	1	7	localException4	java.lang.Exception
    //   921	1	8	localException5	java.lang.Exception
    //   611	144	9	bool	boolean
    //   637	22	10	str3	String
    //   664	251	12	str4	String
    //   667	242	13	i	int
    //   680	211	14	j	int
    //   694	180	15	str5	String
    //   702	174	16	str6	String
    //   788	20	17	str7	String
    //   794	23	18	str8	String
    //   576	12	19	str9	String
    //   550	12	20	str10	String
    //   524	12	21	str11	String
    //   498	12	22	str12	String
    //   482	3	23	str13	String
    //   28	203	24	str14	String
    //   40	272	25	str15	String
    //   52	192	26	str16	String
    //   64	187	27	str17	String
    //   76	189	28	str18	String
    //   88	854	29	localb1	com.xiaomi.push.service.v.b
    //   105	839	30	localb2	com.xiaomi.push.service.v.b
    //   123	243	31	k	int
    //   126	245	32	localObject	Object
    //   139	209	33	m	int
    //   197	120	34	str19	String
    //   287	12	35	locala	a
    // Exception table:
    //   from	to	target	type
    //   472	484	746	java/lang/Exception
    //   566	592	921	java/lang/Exception
    //   540	566	926	java/lang/Exception
    //   514	540	931	java/lang/Exception
    //   488	514	936	java/lang/Exception
  }
  
  private static void a(byte[] paramArrayOfByte)
  {
    if (a == null) {}
    try
    {
      a = XmlPullParserFactory.newInstance().newPullParser();
      a.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
      a.setInput(new InputStreamReader(new ByteArrayInputStream(paramArrayOfByte)));
      return;
    }
    catch (XmlPullParserException localXmlPullParserException)
    {
      for (;;)
      {
        localXmlPullParserException.printStackTrace();
      }
    }
  }
  
  public static f b(XmlPullParser paramXmlPullParser)
  {
    Object localObject = f.b.a;
    String str1 = paramXmlPullParser.getAttributeValue("", "type");
    if ((str1 != null) && (!str1.equals(""))) {}
    try
    {
      f.b localb = f.b.valueOf(str1);
      localObject = localb;
      f localf = new f((f.b)localObject);
      localf.m(paramXmlPullParser.getAttributeValue("", "to"));
      localf.n(paramXmlPullParser.getAttributeValue("", "from"));
      localf.l(paramXmlPullParser.getAttributeValue("", "chid"));
      String str2 = paramXmlPullParser.getAttributeValue("", "id");
      if (str2 == null) {
        str2 = "ID_NOT_AVAILABLE";
      }
      localf.k(str2);
      int i = 0;
      int j;
      String str3;
      String str4;
      for (;;)
      {
        if (i != 0) {
          return localf;
        }
        j = paramXmlPullParser.next();
        if (j != 2) {
          break label348;
        }
        str3 = paramXmlPullParser.getName();
        str4 = paramXmlPullParser.getNamespace();
        if (!str3.equals("status")) {
          break;
        }
        localf.a(paramXmlPullParser.nextText());
      }
      String str5;
      label348:
      return localf;
    }
    catch (IllegalArgumentException localIllegalArgumentException3)
    {
      for (;;)
      {
        System.err.println("Found invalid presence type " + str1);
        continue;
        if (str3.equals("priority"))
        {
          try
          {
            localf.a(Integer.parseInt(paramXmlPullParser.nextText()));
          }
          catch (NumberFormatException localNumberFormatException) {}catch (IllegalArgumentException localIllegalArgumentException2)
          {
            localf.a(0);
          }
        }
        else if (str3.equals("show"))
        {
          str5 = paramXmlPullParser.nextText();
          try
          {
            localf.a(f.a.valueOf(str5));
          }
          catch (IllegalArgumentException localIllegalArgumentException1)
          {
            System.err.println("Found invalid presence mode " + str5);
          }
        }
        else if (str3.equals("error"))
        {
          localf.a(e(paramXmlPullParser));
        }
        else
        {
          localf.a(a(str3, str4, paramXmlPullParser));
          continue;
          if ((j == 3) && (paramXmlPullParser.getName().equals("presence"))) {
            i = 1;
          }
        }
      }
    }
  }
  
  public static s.b c(XmlPullParser paramXmlPullParser)
  {
    s.b localb = new s.b();
    String str1 = paramXmlPullParser.getAttributeValue("", "id");
    String str2 = paramXmlPullParser.getAttributeValue("", "to");
    String str3 = paramXmlPullParser.getAttributeValue("", "from");
    String str4 = paramXmlPullParser.getAttributeValue("", "chid");
    s.b.a locala = s.b.a.a(paramXmlPullParser.getAttributeValue("", "type"));
    localb.k(str1);
    localb.m(str2);
    localb.n(str3);
    localb.l(str4);
    localb.a(locala);
    int i = 0;
    h localh = null;
    while (i == 0)
    {
      int j = paramXmlPullParser.next();
      if (j == 2)
      {
        if (paramXmlPullParser.getName().equals("error")) {
          localh = e(paramXmlPullParser);
        } else if (paramXmlPullParser.getName().equals("p")) {
          try
          {
            localb.a(true, Integer.parseInt(paramXmlPullParser.getAttributeValue("", "period")));
          }
          catch (NumberFormatException localNumberFormatException)
          {
            com.xiaomi.channel.commonutils.logger.b.c("Bind result parse error: " + localNumberFormatException.toString());
          }
        }
      }
      else if ((j == 3) && (paramXmlPullParser.getName().equals("bind"))) {
        i = 1;
      }
    }
    localb.a(localh);
    return localb;
  }
  
  public static g d(XmlPullParser paramXmlPullParser)
  {
    g localg = null;
    int i = 0;
    while (i == 0)
    {
      int j = paramXmlPullParser.next();
      if (j == 2) {
        localg = new g(paramXmlPullParser.getName());
      } else if ((j == 3) && (paramXmlPullParser.getName().equals("error"))) {
        i = 1;
      }
    }
    return localg;
  }
  
  public static h e(XmlPullParser paramXmlPullParser)
  {
    ArrayList localArrayList = new ArrayList();
    String str1 = null;
    Object localObject1 = null;
    Object localObject2 = "-1";
    int i = 0;
    if (i < paramXmlPullParser.getAttributeCount()) {
      if (!paramXmlPullParser.getAttributeName(i).equals("code")) {
        break label322;
      }
    }
    label322:
    for (Object localObject5 = paramXmlPullParser.getAttributeValue("", "code");; localObject5 = localObject2)
    {
      if (paramXmlPullParser.getAttributeName(i).equals("type")) {}
      for (Object localObject6 = paramXmlPullParser.getAttributeValue("", "type");; localObject6 = localObject1)
      {
        if (paramXmlPullParser.getAttributeName(i).equals("reason")) {
          str1 = paramXmlPullParser.getAttributeValue("", "reason");
        }
        i++;
        localObject1 = localObject6;
        localObject2 = localObject5;
        break;
        int j = 0;
        Object localObject3 = null;
        String str2 = null;
        while (j == 0)
        {
          int k = paramXmlPullParser.next();
          if (k == 2)
          {
            if (paramXmlPullParser.getName().equals("text"))
            {
              str2 = paramXmlPullParser.nextText();
            }
            else
            {
              String str3 = paramXmlPullParser.getName();
              String str4 = paramXmlPullParser.getNamespace();
              if ("urn:ietf:params:xml:ns:xmpp-stanzas".equals(str4)) {
                localObject3 = str3;
              } else {
                localArrayList.add(a(str3, str4, paramXmlPullParser));
              }
            }
          }
          else if (k == 3)
          {
            if (paramXmlPullParser.getName().equals("error")) {
              j = 1;
            }
          }
          else if (k == 4) {
            str2 = paramXmlPullParser.getText();
          }
        }
        if (localObject1 == null) {}
        for (Object localObject4 = "cancel";; localObject4 = localObject1) {
          return new h(Integer.parseInt((String)localObject2), (String)localObject4, str1, localObject3, str2, localArrayList);
        }
      }
    }
  }
  
  private static String f(XmlPullParser paramXmlPullParser)
  {
    String str = "";
    int i = paramXmlPullParser.getDepth();
    while ((paramXmlPullParser.next() != 3) || (paramXmlPullParser.getDepth() != i)) {
      str = str + paramXmlPullParser.getText();
    }
    return str;
  }
  
  private static String g(XmlPullParser paramXmlPullParser)
  {
    for (int i = 0; i < paramXmlPullParser.getAttributeCount(); i++)
    {
      String str = paramXmlPullParser.getAttributeName(i);
      if (("xml:lang".equals(str)) || (("lang".equals(str)) && ("xml".equals(paramXmlPullParser.getAttributePrefix(i))))) {
        return paramXmlPullParser.getAttributeValue(i);
      }
    }
    return null;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.smack.util.c
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */