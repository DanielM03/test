import javax.lang.model.type.ArrayType;
import java.lang.reflect.Array;
import java.util.*;


public class Cards {
    public static void main(String[] args) {

        Random rand = new Random(); //Initialize the rand object (which is an instance of the Random class)
        int[] deck = new int[52]; //Declare a int array which has 52 values (0-51)
        String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"}; //Declare a string array which are the suits
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"}; //Declare a string array which are the ranks
        ArrayList<String> ranksFinal = new ArrayList<String>(Arrays.asList(ranks)); //Creating an array list which will convert the ranks string array to an array list. This is done so we can only pick a certain card once

        for (int i = 0; i < deck.length; i++) { //For loop initializes the deck int array so that each element has a value from 0 to 51
            deck[i] = i; //Gives the value of i to position i e.g. when i = 2 the position of the second element in the deck int array will equal 2
        }

       for (int i = 0; i < deck.length; i++) { //For loop which loops from 0 to the length of the deck int array
            int pos = rand.nextInt(51) + 1; //Creates a random number between 1-52
            int temp = deck[i]; // Creates a temp variable which stores the current index of deck
            deck[i] = deck[pos]; // Assigns the i position of the deck int array to a new random position
            deck[pos] = temp; // Assigns the pos position of the deck to the temp variablea
        }

        for (int i = 0; i < 4; i++) { //For loop which loops from 0-4 (this will produce a random selection of 4 cards)
            Collections.shuffle(ranksFinal); //Shuffles the deck to randomize further the cards that we can pick (this isn't actually needed but it's nice to have)
            String suit = suits[deck[i] / 13]; //This will assign the variable suit to the i position of deck divided by 13 (number 13 has been used as there are 13 ranks in a suit)
            String rank = ranksFinal.get(ranksFinal.size() - 1); //This will assign the variable rank to the position of the last element of the ranksFinal array list
            System.out.println("Card picked: " + rank + " of " + suit); //This will print the card picked
            ranksFinal.remove(ranksFinal.size() - 1); //This will remove the last element in the ranksFinal arraylist so that we avoid picking the same card twice
        }
    }
}