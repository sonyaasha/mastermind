package wit.comp1050.mastermindjavafx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {
    private int theNumber;
    private int numOfColorsChosen;

    private int theGuessAmount = 0;
    private int theCodeSize;
    int[] secretCode;
    int[] userGuessInt;
    private String[] feedbackSequence;
    //one color is correct, but wrong position
    private String whitePeg = "+";
    //one color is correct AND in correct position
    private String blackPeg = "-";
    private String neitherPeg = "*";

    private List<String> winningBlackPegs;

    public Game(int theColor){
        numOfColorsChosen = theColor;

        if (theColor == 5) {
            theCodeSize = 4;
            feedbackSequence = new String[4];
            theGuessAmount = 12;
        } else if (theColor == 6) {
            theCodeSize = 4;
            feedbackSequence = new String[4];
            theGuessAmount = 10;
        } else if (theColor == 7) {
            theCodeSize = 5;
            feedbackSequence = new String[5];
            theGuessAmount = 10;
        } else if (theColor == 8) {
            theCodeSize = 6;
            feedbackSequence = new String[6];
            theGuessAmount = 8;
        } else {
            throw new IllegalArgumentException("You can only play with 5, 6, 7,or 8 colors");
        }

        winningBlackPegs = new ArrayList<String>();

        for(int peg = 0; peg < theCodeSize; peg++){
            winningBlackPegs.add("-");
        }
    }

    public int getGameCodeSize(){
        return theCodeSize;
    }

    public int getTheGuessAmount(){
        return theGuessAmount;
    }

    //Depending on a level, the max # colors is different
    public int randomNumberBasedOnLevel(int colorNumber){
        theNumber = (int)(Math.random()*(colorNumber))+1;
        return theNumber;
    }

    //Adds random numbers to array, creating a secret sequence that user has to guess
    public int[] theSecretSequence(){
        secretCode = new int[theCodeSize];
        int[] listOfDuplicateNums = new int[theCodeSize];
        ArrayList<Integer> secretCodeAsList = new ArrayList<Integer>(theCodeSize);

        for (int i = 0; i < secretCode.length; i++) {
            while(secretCode[i] == 0) {
                int rand = randomNumberBasedOnLevel(numOfColorsChosen);
                if (secretCodeAsList.contains(rand)) {
                    listOfDuplicateNums[i] = rand;
                } else {
                    secretCode[i] = rand;
                    secretCodeAsList.add(rand);
                }
            }
        }
        return secretCode;
    }

    //converting user String guess into ints
    public void stringToIntConvert(String userGuess){
        String[] userGuessArray = userGuess.split("");
        userGuessInt = new int[userGuess.length()];
        for (int characterIndex = 0; characterIndex < userGuessArray.length; characterIndex++) {
            userGuessInt[characterIndex] = Integer.parseInt(userGuessArray[characterIndex]);
        }
    }

    public String[] feedbackOnUserGuess() {
        int onIndexAdded = 0;
        boolean containsPeg = false;

        while(onIndexAdded < 3){
            for (int element = 0; element < secretCode.length; element++) {
                for (int userElement = 0; userElement < userGuessInt.length; userElement++) {
                    if (userGuessInt[userElement] == secretCode[element]) {
                        containsPeg = true;
                        break;
                    }
                }
                if(containsPeg){
                    colorPeg(onIndexAdded);
                    containsPeg = false;
                } else{
                    feedbackSequence[onIndexAdded] = neitherPeg;
                }
                onIndexAdded++;
            }
        }

        //printing the feedbackSequence
        for (int i = 0; i < feedbackSequence.length; i++) {
            System.out.print(feedbackSequence[i]);
        }
        System.out.println();
        return feedbackSequence;
    }

    public void colorPeg (int elementIdx){
        if (secretCode[elementIdx] == userGuessInt[elementIdx]) {
            feedbackSequence[elementIdx] = blackPeg;
        } else {
            feedbackSequence[elementIdx] = whitePeg;
        }
    }

    public boolean gameResult(){
        boolean isWinner = false;
        List<String> theFeedbackSequence = new ArrayList<String>();

        for(String sec : feedbackSequence){
            theFeedbackSequence.add(sec);
        }

        System.out.println("winningBlackPegs: " + String.join(",", winningBlackPegs));
        System.out.println("theFeedbackSequence: " + String.join(",", theFeedbackSequence));

        if(theFeedbackSequence.equals(winningBlackPegs)){
            isWinner = true;
        }

        if(isWinner){
            System.out.println("Correct colors");
        } else{
            System.out.println("Not correct color combo");
        }

        return isWinner;
    }

    public boolean blackPegWinner(){
        for (String feedback: feedbackSequence) {
            if(feedback == blackPeg){
                return true;
            }
        }
        return false;
    }

    public List<String> getWinningBlackPegs(){
        return winningBlackPegs;
    }
}
