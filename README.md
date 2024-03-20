# java-metaprogramming-playground

📚 Learning and exploring the metaprogramming features of Java.


## Overview

Metaprogramming is "programming the program". One of Java's key features is its dynamic-ness. There are things like the
Reflection API, Java agents, invokedynamic, Proxy, and annotation processing (often used for codegen). Together, these
tools enable metaprogramming for Java and other JVM languages. I would like to learn more about these tools so that I
can get even more leverage out of Java. In fact, the richness of these tools is a unique advantage of Java/JVM. Most
languages have fewer tools.

**NOTE**: This project was developed on macOS. It is for my own personal use.


## Instructions

Follow these instructions to compile and run the program.

1. Pre-requisite: Java 21
2. Compile the program:
    * ```shell
      ./build.sh
      ```
3. Run the program:
    * ```shell
      ./run.sh
      ```

Alternatively, configure your favorite IDE (like Intellij) to look at the `src/` for the source code and use the IDE to
compile and run the program.


## Wish List

General clean-ups, TODOs and things I wish to implement for this project:

* [ ] Do something with classpath scanning. Can I find all classes that extend Record, for example?
* [ ] Do something with MethodHandles. No idea how this works.
* [ ] Do something with dynamic Proxies
* [ ] Do something with JSR-223 or JShell to execute dynamic code at runtime and somehow side effect the program state. This
  is possible, right?
* [ ] HOLD (I started this a long time ago, but I completely forgot about this codebase) Do something with Java agents (premain or dynamic)
  * Can I replace a method definition using the agent?
  * Reconcile this project with my other project [java-agents-playground](https://github.com/dgroomes/java-agents-playground).
    Somehow when I did `java-agents-playground` I completely had forgotten about this project. I don't need the overlap
    on agents, but I still want to explore the other topics like reflection, invokedynamic, and Proxy. Those should
    best exist as standalone projects. This is a reminder.


## Reference

* [The Java Tutorials: "The Reflection API"](https://docs.oracle.com/javase/tutorial/reflect/index.html)
* [The Java Tutorials: "Using JAR Files: The Basics"](https://docs.oracle.com/javase/tutorial/deployment/jar/basicsindex.html)
* [Package java.lang.instrument](https://docs.oracle.com/javase/7/docs/api/java/lang/instrument/package-summary.html)
    * This describes Java agents.
* [Java Magazine: "Understanding Java method invocation with invokedynamic"](https://blogs.oracle.com/javamagazine/post/understanding-java-method-invocation-with-invokedynamic)
* [JavaDoc for Proxy](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/reflect/Proxy.html)
* [JavaDoc for "java.lang.instrument"](https://docs.oracle.com/en/java/javase/21/docs/api/java.instrument/java/lang/instrument/package-summary.html)
  * This is the only official Java document I can find on agents. I'm looking for more information and for examples. The
    OpenTelemetry project has a Java agent and the code is available at [open-telemetry/opentelemetry-java-instrumentation](https://github.com/open-telemetry/opentelemetry-java-instrumentation) 
    on GitHub. It is ostensibly a good example of a sophisticated Java agent but there is little in the way of documentation
    that explains the implementation. Also we can count on Baeldung to have a [Guide To Instrumentation](https://www.baeldung.com/java-instrumentation)
    which shows a simple agent example!
