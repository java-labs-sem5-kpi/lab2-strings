import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.sergosoft.sentencessorter.SentenceSorter;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class SentenceSorterTests {

    private final SentenceSorter sentenceSorter = new SentenceSorter();
    private final StringBuilder textToSort;
    private final StringBuilder expectedSortedText;

    public SentenceSorterTests(StringBuilder textToSort, StringBuilder expectedSortedText) {
        this.textToSort = textToSort;
        this.expectedSortedText = expectedSortedText;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                // Different-sized sentences
                {new StringBuilder("Hello, Bill! How're you doing today? Hello?"), new StringBuilder("Hello? Hello, Bill! How're you doing today?")},

                // Equal-sizes sentences
                {new StringBuilder("I love coffee. You like tea. She enjoys juice."), new StringBuilder("I love coffee. You like tea. She enjoys juice.")},

                // Empty input text
                {new StringBuilder(), new StringBuilder()},

                // Single sentence
                {new StringBuilder("One short sentence."), new StringBuilder("One short sentence.")},

                // Short and long sentences
                {new StringBuilder("This is a short sentence. This sentence is considerably longer and contains many more words."),
                        new StringBuilder("This is a short sentence. This sentence is considerably longer and contains many more words.")},

                // Mixed questions and usual sentences
                {new StringBuilder("What's your name? My name is John. Who are you?"),
                        new StringBuilder("What's your name? Who are you? My name is John.")},

                // Sentences separated with a couple of spaces
                {new StringBuilder("What's your name?        My name is John.         Who are you?       "),
                        new StringBuilder("What's your name? Who are you? My name is John.")},
        });
    }

    @Test
    public void testSortByWordCountSentences() {
        assertEquals(expectedSortedText.toString(), sentenceSorter.sortByWordCount(textToSort).toString());
    }
}
