/**
 *
 */

package j8spec.expect;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;

/**
 * @author okamoto.masafumi
 *
 */
public class Matchers {

    public static Matcher<Boolean> be_truthy() {
        return CoreMatchers.is(true);
    }

    public static Matcher<Boolean> be_falsey() {
        return CoreMatchers.not(true);
    }

    public static Matcher<Object> be_null() {
        return CoreMatchers.nullValue();
    }

    public static <T> Matcher<T> be(T value) {
        return CoreMatchers.is(value);
    }

    public static <T> Matcher<T> eq(T value) {
        return CoreMatchers.is(value);
    }

    public static RaiseMatcher raise(Class<? extends Throwable> expectedType) {

        return new RaiseMatcher(expectedType);
    }

    public static RaiseMatcher raise_error(Class<? extends Throwable> expectedType) {
        return raise(expectedType);
    }

    public static RaiseMatcher raise_exception() {
        return raise(Exception.class);
    }

}
