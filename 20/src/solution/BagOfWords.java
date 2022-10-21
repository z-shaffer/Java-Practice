package solution;

import java.util.HashMap;


public class BagOfWords
{
    
    private HashMap<String, Integer> map;
    
    /**
     * Initialize an empty bag with an initial capacity of 10. 
     * @postcondition
     *   This bag is empty and has an initial capacity of 10.
     **/ 
    public BagOfWords()
    {
        map = new HashMap<String, Integer>(10);
    } 

    /**
     * Initialize an empty bag with a specified initial capacity.
     * @param initialCapacity
     *   the initial capacity of this bag
     * @precondition
     *   initialCapacity is non-negative.
     * @postcondition
     *   This bag is empty and has the given initial capacity.
     **/  
    public BagOfWords(int initialCapacity)
    {
            map = new HashMap<String, Integer>(initialCapacity);
    }

    /**
     * Add a new element to this bag.
     * @param word
     *   the new word that is being inserted
     * @postcondition
     *   A new copy of the word has been added to this bag.
     **/
    public void add(String word)
    {
        map.put(word, countOccurrences(word) + 1);
    } 

    /**
     * Accessor method to count the number of occurrences of a particular
     * element in this bag.
     * @param word
     *   the word that needs to be counted
     * @return
     *   the number of times that word occurs in this bag
     **/
    public int countOccurrences(String word)
    {
        int count = 0;
        for (HashMap.Entry<String, Integer> entry : map.entrySet()) 
        {
            if (entry.getKey().equals(word))
            {
                count += entry.getValue();
            }
        }
        return count;
    }

     /**
     * Remove one copy of a specified word from this bag.
     * @param word
     *   the word to remove from the bag
     * @postcondition
     *   If the word was found in the bag, then one copy of
     *   the word has been removed and the method returns true.
     *   Otherwise the bag remains unchanged and the method returns false.
     * @return true if the word was successfully removed.
     **/
    public boolean remove(String word)
    {
        for (HashMap.Entry<String, Integer> entry : map.entrySet()) 
        {
            if (entry.getKey().equals(word))
            {
                entry.setValue(entry.getValue() - 1);
                if (entry.getValue() == 0)
                {
                    map.remove(entry.getKey());
                }
                return true;
            }
        }
        return false;
    } 

    /**
     * Determine the number of words in this bag.
     * @return
     *   the number of words in this bag
     **/
    public int size()
    {
        int sum = 0;
        for (HashMap.Entry<String, Integer> entry : map.entrySet()) 
        {
            sum += entry.getValue();
        }
        return sum;
    } 

    /**
     * Produce one long string from the values in the BagOfWords.
     * If a string appears more than one time in the bag, it should
     * appear more than once in the output. Do not insert spaces.
     * @return the long string
     */
    public String oneLongString()
    {
        String str = "";
        for (HashMap.Entry<String, Integer> entry : map.entrySet()) 
        {
            for (int i = entry.getValue(); i > 0; i--)
            {
                str += entry.getKey();
            }
        }
        return str;
    }
}
