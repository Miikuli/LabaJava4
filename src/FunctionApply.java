import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionApply {
    public static <T, P> List<P> apply(List<T> list, Function<T, P> function) {
        List<P> result = new ArrayList<>();
        for (T value : list) {
            result.add(function.apply(value));
        }
        return result;
    }
}
