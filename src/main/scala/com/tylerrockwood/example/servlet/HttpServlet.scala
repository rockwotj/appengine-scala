package com.tylerrockwood.example.servlet

import java.io.InputStream
import javax.servlet.http.{HttpServlet => JavaHttpServlet, HttpServletRequest => JavaServletRequest, HttpServletResponse => JavaServletResponse}

import com.google.appengine.repackaged.com.google.api.client.util.IOUtils

import scala.collection.JavaConverters._
import scala.io.Source
import scala.language.implicitConversions

/**
  * A scala wrapper for a [[JavaServletRequest]]
  */
class HttpRequest(javaServletRequest: JavaServletRequest) {
  def headers: Map[String, String] = {
    javaServletRequest.getHeaderNames.asScala.map { case key: String =>
      key -> javaServletRequest.getHeader(key)
    }.toMap
  }
  def content: Source = {
    Source.fromInputStream(javaServletRequest.getInputStream, javaServletRequest.getCharacterEncoding)
  }
  def params: Map[String, String] = {
    javaServletRequest.getQueryString
      .stripPrefix("?")
      .split('&')
      .grouped(2)
      .map { case Array(key, value) => (key, value)}
      .toMap
  }
}

/**
  * A scala wrapper for a [[JavaServletResponse]]
  */
class HttpResponse(javaServletResponse: JavaServletResponse) {
  def setHeader(key: String, value: String): Unit = {
    javaServletResponse.setHeader(key, value)
  }
  def setContentType(content: String): Unit = {
    javaServletResponse.setContentType(content)
  }
  def setStatus(code: Int): Unit = {
    javaServletResponse.setStatus(code)
  }
  def write(body: String): Unit = {
    javaServletResponse.getWriter.write(body)
  }
  def write(body: InputStream): Unit = {
    IOUtils.copy(body, javaServletResponse.getOutputStream)
  }
}

/**
  * A scala wrapper around a [[JavaHttpServlet]]
  */
abstract class HttpServlet extends JavaHttpServlet {

  override final def doDelete(httpServletRequest: JavaServletRequest, httpServletResponse: JavaServletResponse): Unit = {
    handleDelete(httpServletRequest, httpServletResponse)
  }
  def handleDelete(httpRequest: HttpRequest, httpResponse: HttpResponse): Unit = {
    httpResponse.setStatus(405)
  }

  override final def doOptions(httpServletRequest: JavaServletRequest, httpServletResponse: JavaServletResponse): Unit = {
    handleOptions(httpServletRequest, httpServletResponse)
  }
  def handleOptions(httpRequest: HttpRequest, httpResponse: HttpResponse): Unit = {
    httpResponse.setStatus(405)
  }

  override final def doTrace(httpServletRequest: JavaServletRequest, httpServletResponse: JavaServletResponse): Unit = {
    handleTrace(httpServletRequest, httpServletResponse)
  }
  def handleTrace(httpRequest: HttpRequest, httpResponse: HttpResponse): Unit = {
    httpResponse.setStatus(405)
  }

  override final def doHead(httpServletRequest: JavaServletRequest, httpServletResponse: JavaServletResponse): Unit = {
    handleHead(httpServletRequest, httpServletResponse)
  }
  def handleHead(httpRequest: HttpRequest, httpResponse: HttpResponse): Unit = {
    httpResponse.setStatus(405)
  }

  override final def doPost(httpServletRequest: JavaServletRequest, httpServletResponse: JavaServletResponse): Unit = {
    handlePost(httpServletRequest, httpServletResponse)
  }
  def handlePost(httpRequest: HttpRequest, httpResponse: HttpResponse): Unit = {
    httpResponse.setStatus(405)
  }

  override final def doPut(httpServletRequest: JavaServletRequest, httpServletResponse: JavaServletResponse): Unit = {
    handlePut(httpServletRequest, httpServletResponse)
  }
  def handlePut(httpRequest: HttpRequest, httpResponse: HttpResponse): Unit = {
    httpResponse.setStatus(405)
  }

  override final def doGet(httpServletRequest: JavaServletRequest, httpServletResponse: JavaServletResponse): Unit = {
    handleGet(httpServletRequest, httpServletResponse)
  }
  def handleGet(httpRequest: HttpRequest, httpResponse: HttpResponse): Unit = {
      httpResponse.setStatus(405)
  }

  private[this] implicit def toScala(javaServletRequest: JavaServletRequest): HttpRequest = {
    new HttpRequest(javaServletRequest)
  }
  private[this] implicit def toScala(javaServletResponse: JavaServletResponse): HttpResponse = {
    new HttpResponse(javaServletResponse)
  }

}
