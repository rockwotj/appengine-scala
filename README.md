# Scala AppEngine using Bazel

This is an example of using Scala in [Google App Engine](https://cloud.google.com/appengine) while building with [Bazel](https://bazel.build).

To run it, first [install bazel](https://bazel.build/versions/master/docs/install.html) and run `bazel build :backend` then `./bazel-bin/backend --port=12345` to run the server.

## IDE Support

See the [IntelliJ with Bazel Plugin](https://ij.bazel.build/). It's suggested to pair with the [Scala plugin for IntelliJ](https://plugins.jetbrains.com/plugin/1347-scala).

## Adding dependencies

Dependencies are managed via [generate_workspace](https://docs.bazel.build/versions/master/generate-workspace.html) in order to pick up transative dependancies.
