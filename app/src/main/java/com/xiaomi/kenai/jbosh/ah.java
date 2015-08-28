package com.xiaomi.kenai.jbosh;

final class ah
{
  private final o a;
  private final q b;
  private final p c;
  private final m d;
  private final j e;
  private final n f;
  private final i g;
  private final f h;
  private final k i;
  private final g j;
  private final h k;
  private final boolean l;
  
  private ah(o paramo, q paramq, p paramp, m paramm, j paramj, n paramn, i parami, f paramf, k paramk, g paramg, h paramh, boolean paramBoolean)
  {
    this.a = paramo;
    this.b = paramq;
    this.c = paramp;
    this.d = paramm;
    this.e = paramj;
    this.f = paramn;
    this.g = parami;
    this.h = paramf;
    this.i = paramk;
    this.j = paramg;
    this.k = paramh;
    this.l = paramBoolean;
  }
  
  static ah a(b paramb1, b paramb2)
  {
    g localg = g.a(paramb2.a(r.c));
    String str = paramb1.a(r.q);
    if ((localg != null) && (((String)localg.a()).equals(str))) {}
    for (boolean bool = true;; bool = false) {
      return new ah(o.a(a(paramb2, r.t)), q.a(a(paramb2, r.z)), p.a(paramb2.a(r.y)), m.a(paramb2.a(r.n)), j.a(paramb2.a(r.i)), n.a(paramb2.a(r.p)), i.a(paramb2.a(r.h)), f.a(paramb2.a(r.a)), k.a(paramb2.a(r.k)), localg, h.a(paramb2.a(r.d)), bool);
    }
  }
  
  private static String a(b paramb, ag paramag)
  {
    String str = paramb.a(paramag);
    if (str == null) {
      throw new aa("Connection Manager session creation response did not include required '" + paramag.b() + "' attribute");
    }
    return str;
  }
  
  o a()
  {
    return this.a;
  }
  
  q b()
  {
    return this.b;
  }
  
  p c()
  {
    return this.c;
  }
  
  m d()
  {
    return this.d;
  }
  
  k e()
  {
    return this.i;
  }
  
  boolean f()
  {
    return this.l;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.xiaomi.kenai.jbosh.ah
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */