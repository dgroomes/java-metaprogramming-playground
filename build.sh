#!/usr/bin/env bash
# Compile the classes and create the jar.


# Compile the sources in the given directory to the given directory
#
# Usage: compile source-code-directory/
compile() {
  local source=$1
  local compiled=$2
  find "$source" -name "*.java" > sources.txt
  javac --enable-preview -source 17 @sources.txt --class-path "lib/*" -d "$compiled"
  rm sources.txt
}

compile src out
compile agent-src agent-out

# Build a jar file from the agent compiled code
jar --create --file agent.jar --manifest AGENT-MANIFEST.MF -C agent-out .
