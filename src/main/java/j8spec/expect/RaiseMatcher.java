package j8spec.expect;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

/**
 * @author okamoto.masafumi
 *
 */
public class RaiseMatcher extends TypeSafeMatcher<UnsafeCaller<?>> {

  private Matcher<?> matcher;

  /** constructor.
   * @param expectedType expected type
   */
  public RaiseMatcher(Class<? extends Throwable> expectedType) {

    matcher = new TypeSafeMatcher<Throwable>() {

      @Override
      public void describeTo(Description description) {
        description.appendText(expectedType.getName());
      }

      @Override
      protected boolean matchesSafely(Throwable item) {

        return (expectedType.equals(item.getClass()));
      }
    };
  }

  @Override
  public void describeTo(Description description) {
    description.appendText(String.format("throw : <%s>", matcher.toString()));
  }

  @Override
  protected boolean matchesSafely(UnsafeCaller<?> item) {
    try {
      item.call();

      return false;
    } catch (Throwable actual) {
      return matcher.matches(actual);
    }
  }

}
