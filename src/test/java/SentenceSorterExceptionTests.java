import com.sergosoft.sentencessorter.SentenceSorter;
import org.junit.Test;

import static org.junit.Assert.assertThrows;

public class SentenceSorterExceptionTests {

    private final SentenceSorter sentenceSorter = new SentenceSorter();

    @Test
    public void testInputTextIsNull() {
        assertThrows(IllegalArgumentException.class, () -> sentenceSorter.sortByWordCount(null));
    }
}
