import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DiamondGame {
    public static final int STRATEGY = 2;
    public static final String ERRORSTRING = "ERROR: You don't have this card available\nWhat's your bid";
    public static final int ACE = 14;
    public static final int DIAMONDSUITNUM = 1;
    public static final int HEARTSSUITNUM = 2;
    final int cardsInOneSuit = 13;

    Card[] computerCards;
    Card[] playerCards;
    Card[] diamonds;
    float computerMoney = 0;
    float userMoney = 0;

    public DiamondGame() {
        Deck myDeck = new Deck(1, 0);
        computerCards = new Card[cardsInOneSuit];
        playerCards = new Card[cardsInOneSuit];
        diamonds = new Card[cardsInOneSuit];
        for (int i = 0; i < cardsInOneSuit; i++) {
            computerCards[i] = myDeck.cards[i];
            playerCards[i] = myDeck.cards[i + cardsInOneSuit * HEARTSSUITNUM];
        }
        myDeck.shuffle(DIAMONDSUITNUM);
        for (int i = 0; i < cardsInOneSuit; i++) {
            diamonds[i] = myDeck.cards[i];
            if (diamonds[i].pip == 1) diamonds[i].pip = ACE;         //for ACE
        }
    }

    public static void main(String[] args) {
        DiamondGame myDiamondGame = new DiamondGame();
        myDiamondGame.play();
    }

   public void play() {
        for(int i = 0; i < diamonds.length; i++){
            System.out.println("Current diamond is:\n" + diamonds[i]);
            System.out.println("What's your bid?:\n");

            int computerBid = getComputerBid(diamonds[i].pip);
            int userBid = getUserBid();

            if(userBid < computerBid){
                System.out.println("Sorry, Computer won this bid");
                computerMoney += (float)diamonds[i].pip;
            } else if(userBid == computerBid){
                System.out.println("It's a tie; You get half the money");
                computerMoney += (float)diamonds[i].pip / 2;
                userMoney += (float)diamonds[i].pip / 2;
            } else{
                System.out.println("Congrats you won this bid");
                userMoney += (float)diamonds[i].pip;
            }
        }
       System.out.println(computerMoney > userMoney ? "You lost" : "Congratulations you won the game");
       System.out.println("Computer has " + computerMoney + " money, and you have " + userMoney);
    }

    public boolean isInvalid(int userBid){
        if(userBid == 1){                           // for ACE
            System.out.println("ERROR: Use 14 for A\nWhat's your bid");
            return true;
        }
        if(userBid == ACE){                          // ACE is at first place in Card class
            if(playerCards[0].pip != 0){
                playerCards[0].pip = 0;
                return false;
            }
            System.out.println(ERRORSTRING);
            return true;
        }
        else if(playerCards[userBid-1].pip != 0){
            playerCards[userBid-1].pip = 0;
            return  false;
        }
        System.out.println(ERRORSTRING);
        return true;
    }
    public int getUserBid(){
        Scanner sc = new Scanner(System.in);
        int userBid = sc.nextInt();
        while(isInvalid(userBid)){
            userBid = sc.nextInt();
        }
        return userBid;
    }
    public int getComputerBid(int i){
        if(STRATEGY == 1)
            return i;
        else
            return getRandomComputerBid();
    }

    public int getRandomComputerBid(){
        int bid = randomWithRange(1, cardsInOneSuit);
        while(computerCards[bid-1].pip == 0){
            bid = randomWithRange(1, cardsInOneSuit);
        }
        computerCards[bid-1].pip = 0;
        if(bid == 1) bid = ACE;
        return bid;
    }
    int randomWithRange(int min, int max)
    {
        int range = (max - min) + 1;
        return (int)(Math.random() * range) + min;
    }
    public String toString() {
        String myCards = "Diamonds are: ";
        for (int i = 0; i < cardsInOneSuit; i++) {
            myCards += diamonds[i] + "\n";
        }
        return myCards;
    }
}