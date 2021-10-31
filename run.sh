#!/usr/bin/env bash
# Run the program

java --enable-preview -cp 'out:lib/*' -javaagent:agent.jar dgroomes/Runner
