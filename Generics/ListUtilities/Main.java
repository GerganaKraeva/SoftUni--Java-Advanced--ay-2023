package ListUtilities;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,5,99,80);
        System.out.println(ListUtils.getMax(numbers));
        System.out.println(ListUtils.getMin(numbers));
    }
}
