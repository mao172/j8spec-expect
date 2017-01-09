package j8spec.expect;

import static org.junit.Assert.*;

import org.hamcrest.Matcher;
import org.hamcrest.core.IsNot;

/**
 * @author mao
 *
 * @param <T>
 */
public class Expect<T> {

    private T actual;

    public static <T> Expect<T> expect(T operation) {
        return new Expect<T>(operation);
    }

    public static Expect<UnsafeCaller<?>> expect(UnsafeCaller<?> operation) {
        return new Expect<UnsafeCaller<?>>(operation);
    }

    public static <T> UnsafeCaller<T> of(UnsafeCaller<T> operation) {
        return operation;
    }

    public Expect(T actual) {
        this.actual = actual;
    }

    public void to(Matcher<T> matcher) {
        assertThat(actual, matcher);
    }

    public void not_to(Matcher<T> matcher) {
        assertThat(actual, not(matcher));
    }

    public void to_not(Matcher<T> matcher) {
        assertThat(actual, not(matcher));
    }

    private Matcher<T> not(Matcher<T> matcher) {
        return IsNot.not(matcher);
    }

}
