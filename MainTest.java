

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashMap;

/**
 * The test class MainTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class MainTest
{
    /**
     * Default constructor for test class MainTest
     */
    public MainTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }
    
    // 3 Normal Test Cases
    @Test
    public void testLowerCase(){
        String expected = "apples are sweet";
        String test = "Apples Are Sweet";
        
        String actual = Main.lowerCase(test);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testSplitParagraphToWords(){
        int expected = 3;
        String test = "apples are sweet";
        
        int actual = Main.splitParagraphToWords(test).length;
        assertEquals(expected, actual);
    }
    
    @Test
    public void testWordFrequencyCounter(){
        int expected = 3;
        String test = "the brown bear bit a brown bug and made the brown bug bleed";
        String testKey = "brown";
        
        String[] words = Main.splitParagraphToWords(test);
        HashMap<String, Integer> tester = Main.wordFrequencyCounter(words);
        int actual = tester.get(testKey).intValue();
        
        assertEquals(expected, actual);
    }
    
    // 3 Edge Case Tests
    @Test
    public void testWordFrequencyCounterNull(){
        int expected = 0;
        HashMap<String, Integer> tester = Main.wordFrequencyCounter(null);
        int actual = tester.size();
        
        assertEquals(expected, actual);        
    }
    
    @Test
    public void testLowerCaseNumbers(){
        String expected = "1234";
        String test = "1234";
        
        String actual = Main.lowerCase(test);
        assertEquals(expected, actual);        
    }
    
    @Test
    public void testSplitParagraphToWordsSymbols(){
        int expected = 1;
        String test = "apples_are_sweet";
        
        int actual = Main.splitParagraphToWords(test).length;
        assertEquals(expected, actual);        
    }
}
