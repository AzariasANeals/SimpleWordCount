import java.util.Scanner;
import java.util.HashMap;
import java.util.Collection;
import java.util.TreeMap;
import java.util.Map;

/**
 * Azarias A'Neals
 * AD300 
 * Simple Word Frequency Counter
 */

public class Main
{
    // Example text: "The quick brown fox jumps over the lazy dog"
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        
        //  Create a HashMap for the word frequency counter
        HashMap<String, Integer> wordCounter = null;
        
        // Create a TreeMap for sorting the word frequency counter
        TreeMap<String, Integer> sorted = new TreeMap<String, Integer>();
        System.out.println("Enter in a block of text: ");
        
        // Sets all user input to lower case
        String paragraph = lowerCase(s.nextLine());
        
        // Seperate user input into seperate word Strings, using " " as the delimiter.
        String[] words = splitParagraphToWords(paragraph);
        
        // Here we fill wordCounter with word frequency data.
        wordCounter = wordFrequencyCounter(words);
        
        System.out.println(words.length);
        System.out.println("Your paragraph is: " + paragraph);
        
        // For each loop for sorting wordCounter HashMap into alphabetical order using
        // a TreeMap (sorted).
        for(HashMap.Entry<String, Integer> e : wordCounter.entrySet()){
            sorted.put(e.getKey(), e.getValue());
        }
        
        // Output word frequency in alphabetical order.
        for(Map.Entry<String, Integer> srt : sorted.entrySet()){
            System.out.println(srt.getKey() + ": " + srt.getValue());
        }
    }
    
    public static String lowerCase(String paragraph){
        return paragraph.toLowerCase();
    }
    
    public static String[] splitParagraphToWords(String paragraph){
        return paragraph.split(" ");
    }
    
    // wordFrequencyCounter will always pass back a HashMap<String, Integer> object.
    // If the input is not valid or null, then an empty HashMap object will be returned.
    public static HashMap<String, Integer> wordFrequencyCounter(String[] words){
        HashMap<String, Integer> buffer = new HashMap<String, Integer>();
        
        if(words == null){
            return buffer;
        }
        // For each loop cycling through words array.
        for(String w : words){
            
            // If the word has occurred before, increment counter in HashMap.
            // If this is the first occurrence of word, set counter to 1 in HashMap.
            if(buffer.containsKey(w)){
                int counter = buffer.get(w).intValue();
                counter++;
                buffer.put(w, counter);
            }
            else{
                buffer.put(w, 1);
            }
        }
        return buffer;
    }
}
