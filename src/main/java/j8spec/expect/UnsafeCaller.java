package j8spec.expect;

/**
 * @author okamoto.masafumi
 *
 * @param <T> result type
 */
@FunctionalInterface
public interface UnsafeCaller<T> {

  T call() throws Throwable;
}
