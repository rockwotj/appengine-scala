package com.tylerrockwood.example.memcache

import com.google.appengine.api.memcache.MemcacheServiceFactory
import com.google.appengine.api.memcache.{MemcacheService => GoogleMemcache}

/**
  * The singleton instance of the memcache service.
  */
object MemcacheService extends MemcacheService(MemcacheServiceFactory.getMemcacheService)

/**
  * A scala wrapper for the app engine memcache service.
  */
class MemcacheService(_underlying: GoogleMemcache) {

  def get(key: AnyRef): Option[Any] = {
    Option(_underlying.get(key))
  }

  def put(key: AnyRef, value: AnyRef): Unit = {
    _underlying.put(key, value)
  }

  def delete(key: AnyRef): Boolean = {
    _underlying.delete(key)
  }

  def increment(key: AnyRef): Long = {
    _underlying.increment(key, 1L, 0L)
  }
}
