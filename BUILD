load("@io_bazel_rules_appengine//appengine:appengine.bzl", "appengine_war")
load("@io_bazel_rules_scala//scala:scala.bzl", "scala_library", "scala_binary", "scala_test")

appengine_war(
  name = "backend",
  jars = [":app_deploy.jar"],
  data = ["//webapp"],
  data_path = "/webapp",
  visibility = ["//visibility:public"],
)

# We only need a java_library, but create a java_binary because we need a bundle
# of all of the dependencies (a deploy jar) to pass to the appengine_war. So we
# specify a non-existant class as the main_class (as the "binary" will never be
# run directly, only used as a library).
scala_binary(
  name = "app",
  srcs = glob(["src/main/scala/**/*.scala"]),
  main_class = "does.not.exist",
  scalacopts = [
    "-feature",  
  ],
  deps = [
    "//third_party:com_google_appengine_appengine_api_1_0_sdk",
    "@io_bazel_rules_appengine//appengine:javax.servlet.api",
  ],
)

scala_test(
    name = "app_tests",
    srcs = glob(["src/test/scala/**/*.scala"]),
    deps = [],
)
