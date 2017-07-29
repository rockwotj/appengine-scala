package com.tylerrockwood.example

import com.tylerrockwood.example.logging.Logging
import com.tylerrockwood.example.memcache.MemcacheService
import com.tylerrockwood.example.servlet.{HttpRequest, HttpResponse, HttpServlet}

object MyAppServlet {
  private final val COUNTER_KEY = "counter"
}

class MyAppServlet extends HttpServlet with Logging {

  import MyAppServlet._

  override def handleGet(request: HttpRequest, response: HttpResponse): Unit = {
    val count = MemcacheService.increment(COUNTER_KEY)
    logger.info(s"Request number $count happened")
    response.setContentType("text/plain")
    response.write(s"You are number: $count\n")
  }
}

class FaviconServlet extends HttpServlet with Logging {

  override def handleGet(request: HttpRequest, response: HttpResponse): Unit = {
    response.setContentType("image/x-icon")
    val favicon = getClass.getClassLoader.getResourceAsStream("favicon.ico")
    response.write(favicon)
  }
}
