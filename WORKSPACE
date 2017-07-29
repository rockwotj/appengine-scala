git_repository(
  name = "io_bazel_rules_appengine",
  remote = "https://github.com/bazelbuild/rules_appengine.git",
  tag = "0.0.4",
)
git_repository(
  name = "io_bazel_rules_scala",
  remote = "https://github.com/bazelbuild/rules_scala.git",
  commit = "aaa6c7d4db4f231a541f20a60760420f4bdd11e8",
)

load("@io_bazel_rules_scala//scala:scala.bzl", "scala_repositories")
load("@io_bazel_rules_appengine//appengine:appengine.bzl", "appengine_repositories")
load("//:generate_workspace.bzl", "generated_maven_jars")

scala_repositories()
appengine_repositories()
generated_maven_jars()

