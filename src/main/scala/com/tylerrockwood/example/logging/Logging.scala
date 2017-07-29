package com.tylerrockwood.example.logging

import java.util.logging.Logger

/**
  * A trait to mix in a logger.
  */
trait Logging {
  protected final val logger: Logger = Logger.getLogger(getClass.getName)
}
