package dgroomes;

import java.lang.instrument.Instrumentation;

/**
 * NOT YET IMPLEMENTED
 * <p>
 * This is a Java agent.
 */
public class Agent {

    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.printf("Hello from the 'premain' method in '%s'! This is a Java agent.%n", Agent.class.getName());
    }
}
