package dgroomes;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

public sealed interface ObjectInspection permits
        ObjectInspection.ClassInspection,
        ObjectInspection.EnumInspection,
        ObjectInspection.OtherObjectInspection,
        ObjectInspection.RecordInspection {

    /**
     * Inspect a Java object at runtime.
     * <p>
     * Find details like... is the object a class, a regular object, a record?
     *
     * @param obj the object to inspection
     * @return the object's "inspection"
     */
    static ObjectInspection inspect(Object obj) {
        return switch (obj) {
            case Class clazz -> ClassInspection.inspect(clazz);
            case Enum e -> new EnumInspection(e.getClass(), e);
            case Record record -> RecordInspection.inspect(record);
            default -> new OtherObjectInspection(obj.getClass());
        };
    }

    /**
     * An inspection report for some class. The "overloadedMethodNames" field describes how many names are overloaded
     * in method definitions on the class. For example if there are two methods named "compute(...)", then this counts
     * as one overloaded method name.
     */
    record ClassInspection(Class<?> clazz, short overloadedMethodNames) implements ObjectInspection {

        private static ClassInspection inspect(Class<?> clazz) {
            var overloadedMethods = Arrays.stream(clazz.getDeclaredMethods())
                    .collect(Collectors.groupingBy(Method::getName))
                    .entrySet()
                    .stream()
                    .filter(entry -> entry.getValue().size() > 1)
                    .count();

            return new ClassInspection(clazz, ((short) overloadedMethods));
        }
    }

    record EnumInspection(Class<? extends Enum> clazz, Object value) implements ObjectInspection {
    }

    record OtherObjectInspection(Class<?> clazz) implements ObjectInspection {
    }

    record RecordInspection(Class<? extends Record> clazz, String valueDescription) implements ObjectInspection {

        static RecordInspection inspect(Record record) {
            return new RecordInspection(record.getClass(), record.toString());
        }
    }
}
