package dgroomes;

import dgroomes.ObjectInspection.ClassInspection;
import dgroomes.ObjectInspection.EnumInspection;
import dgroomes.ObjectInspection.OtherObjectInspection;
import dgroomes.ObjectInspection.RecordInspection;

import java.io.File;
import java.util.List;

public class Runner {

    enum PrimaryColor {RED, YELLOW, BLUE}

    record Point(int x, int y) {
    }

    public static void main(String[] args) {
        inspectObjects();
    }

    /**
     * Let's inspect some objects!
     */
    private static void inspectObjects() {
        var objects = List.of(
                "I am a string",
                File.class,
                123,
                PrimaryColor.BLUE,
                new Point(1, 2));

        for (var obj : objects) {
            var inspection = ObjectInspection.inspect(obj);
            var description = switch (inspection) {
                case ClassInspection insp -> "This is a Class object. Class: %s. Overloaded method names: %d".formatted(insp.clazz(), insp.overloadedMethodNames());
                case EnumInspection insp -> "This is an enum value. Enum type: %s. Enum value: %s".formatted(insp.clazz(), insp.value());
                case RecordInspection insp -> "This is an instance of Record. Record type: %s. Value: %s".formatted(insp.clazz(), insp.valueDescription());
                case OtherObjectInspection insp -> "This is an instance of %s".formatted(insp.clazz());
            };
            System.out.println(description);
        }
    }
}
