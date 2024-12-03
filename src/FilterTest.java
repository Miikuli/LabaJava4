import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FilterTest {
    public static <T> List<T> test(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T value : list) {
            if (predicate.test(value)) result.add(value);
        }
        return result;
    }
}
