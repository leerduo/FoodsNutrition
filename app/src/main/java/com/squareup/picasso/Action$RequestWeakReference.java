package com.squareup.picasso;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

class Action$RequestWeakReference<M>
  extends WeakReference<M>
{
  final Action a;
  
  public Action$RequestWeakReference(Action paramAction, M paramM, ReferenceQueue<? super M> paramReferenceQueue)
  {
    super(paramM, paramReferenceQueue);
    this.a = paramAction;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.squareup.picasso.Action.RequestWeakReference
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */