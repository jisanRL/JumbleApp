package ca.jisan.jumbleapp;

import android.database.sqlite.SQLiteBindOrColumnIndexOutOfRangeException;
import android.provider.UserDictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static ca.jisan.jumbleapp.R.id.input;


/**
 * Created by jisanreza on 7/25/17.
 */


public class Dictionary {

    private ArrayList<String> dictionary = new ArrayList<String>();   //making new arraylist of dictionary which holds the array
    private String word;


    /**
     * Initializes this dictionary from the given stream.  Each line of the file contains a
     * single word.
     *
     * @param stream stream from which a file containing the words of this dictionary can be read.
     */

    public Dictionary(InputStream stream)
    {
            Scanner input = new Scanner(stream);

            while (input.hasNextLine())
            {
                this.word = input.nextLine();    //  takes the iostream input from the controller and scans the doc dictionary.txt line by line
                dictionary.add(this.word);
            }
            input.close();
    }


    /**
     * Returns the list of words that are unscramblings of the given word.
     *
     * @param word word to be unscrambled.
     * @return list of words that are unscramblings of the given word.
     */

    public List<String> getUnscramblings(String word) {

        ArrayList<String> iList = new ArrayList<String>();      //making a new arraylist

        for (String wordindict: this.dictionary) {
            char[] first = word.toCharArray();               // converts input string (Word) to new character array
            char[] second = wordindict.toCharArray();       //  resembles the word
            Arrays.sort(first);                            //   sorts the array
            Arrays.sort(second);

            if (Arrays.equals(first,second) ){      // checks if the characters of word first and second matches
                iList.add(wordindict);                    //  if the characters match prints the word
            }
        }

        return iList;         // a create a new array list nd contains strings within it


    }

}
