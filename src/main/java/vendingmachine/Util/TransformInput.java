package vendingmachine.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TransformInput {
    public static List<String> transformFormat(String input) {
        String transform = input.substring(1, input.length() - 1);
        String[] transformInput = transform.split(",");
        return Arrays.asList(transformInput);
    }
}
