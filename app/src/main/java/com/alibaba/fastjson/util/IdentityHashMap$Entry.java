package com.alibaba.fastjson.util;

public final class IdentityHashMap$Entry<K, V>
{
  public final int hashCode;
  public final K key;
  public final Entry<K, V> next;
  public V value;
  
  public IdentityHashMap$Entry(K paramK, V paramV, int paramInt, Entry<K, V> paramEntry)
  {
    this.key = paramK;
    this.value = paramV;
    this.next = paramEntry;
    this.hashCode = paramInt;
  }
}


/* Location:           D:\15036015\反编译\shiwuku\classes_dex2jar.jar
 * Qualified Name:     com.alibaba.fastjson.util.IdentityHashMap.Entry
 * JD-Core Version:    0.7.0-SNAPSHOT-20130630
 */