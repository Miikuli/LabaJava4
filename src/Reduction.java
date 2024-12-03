import java.util.List;
import java.util.function.BinaryOperator;

public class Reduction {
    public static <T> T reduce(List<T> list, T begin, BinaryOperator<T> union) {
        if (list == null || list.isEmpty()) return begin;
        T result = begin;
        for (T value : list) result = union.apply(result, value);
        return result;
    }
}
