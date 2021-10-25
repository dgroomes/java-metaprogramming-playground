#!/usr/bin/env bash
# Compile

find . -name "*.java" > sources.txt
javac --enable-preview -source 17 @sources.txt --class-path "lib/*" -d out
