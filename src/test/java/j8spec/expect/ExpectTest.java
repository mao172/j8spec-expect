package j8spec.expect;

import static j8spec.J8Spec.*;
import static j8spec.expect.Expect.*;
import static j8spec.expect.Matchers.*;

import org.junit.runner.RunWith;

import j8spec.junit.J8SpecRunner;

@RunWith(J8SpecRunner.class)
class ExpectText {
    {
        describe("", ()->{
            it("text expected integer value.", ()->{
                Integer val = 1;

                expect(val).to(be(1));
            });
        });
    }
}