import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Collecting {
    public static <T, P extends Collection<T>> P collect(List<T> list, Supplier<P> collectionFactory, Predicate<T> filter) {
        P result = collectionFactory.get();
        for (T value : list) {
            if (filter.test(value)) {
                result.add(value);
            }
        }
        return result;
    }
}
