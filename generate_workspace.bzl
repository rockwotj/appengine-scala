# The following dependencies were calculated from:
#
# generate_workspace --artifact com.google.appengine:appengine-api-1.0-sdk:1.9.54


def generated_maven_jars():
  native.maven_jar(
      name = "com_google_appengine_appengine_api_1_0_sdk",
      artifact = "com.google.appengine:appengine-api-1.0-sdk:1.9.54",
  )




def generated_java_libraries():
  native.java_library(
      name = "com_google_appengine_appengine_api_1_0_sdk",
      visibility = ["//visibility:public"],
      exports = ["@com_google_appengine_appengine_api_1_0_sdk//jar"],
  )


