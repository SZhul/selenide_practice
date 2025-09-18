package tests.simple;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("simple")
public class SkippedTests {

    @Test
    @Disabled("Some reason")
    public void negativeTest() {
        assertTrue(false);
    }

    @Test
    @Disabled("Some reason")
    public void negativeTest2() {
        assertTrue(false);
    }

    @Test
    @Disabled("Some reason")
    public void negativeTest3() {
        assertTrue(false);
    }

    @Test
    @Disabled("Some reason")
    public void negativeTest4() {
        assertTrue(false);
    }
}
