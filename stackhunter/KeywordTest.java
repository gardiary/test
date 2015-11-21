package stackhunter;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * User: gardiary
 * Date: 11/21/15, 11:29 AM
 */
public class KeywordTest extends TestCase {

    private static final String text = "The quick brown fox jumps over the lazy dog.";

    @Test
    public void test() throws Exception {
        assertTrue(new Keyword("jump").matches(text));
        assertTrue(new Keyword("brown fox").matches(text));
        assertTrue(new Keyword("brown dog").matches(text));
        assertTrue(new Keyword("THE lazy FOX").matches(text));

        assertFalse(new Keyword("the lazy cat").matches(text));

        assertFalse(new Keyword("").matches(text));
        assertFalse(new Keyword("").matches(""));
        assertFalse(new Keyword("").matches(null));

        assertFalse(new Keyword(null).matches(text));
        assertFalse(new Keyword(null).matches(""));
        assertFalse(new Keyword(null).matches(null));
    }

}
