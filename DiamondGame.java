import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DiamondGame {
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
            playerCards[i] = myDeck.cards[i + cardsInOneSuit * 2];
        }
        myDeck.shuffle(1);
        for (int i = 0; i < cardsInOneSuit; i++) {
            diamonds[i] = myDeck.cards[i];
        }
    }

    public static void main(String[] args) {
        DiamondGame myDiamondGame = new DiamondGame();
        //System.out.println(myDiamondGame);
        myDiamondGame.play();
    }

   public void play() {
        for(int i = 0; i < diamonds.length; i++){
            System.out.println("Current diamond is:\n" + diamonds[i]);
            System.out.println("What's your bid?:\n");
            Scanner sc = new Scanner(System.in);
            int userBid = sc.nextInt();
            int computerBid = getComputerBid();

            if(userBid > computerBid){
                computerMoney += Float.parseFloat(diamonds[i].getPip());
            }
            else if(userBid == computerBid){
                computerMoney += Float.parseFloat(diamonds[i].getPip()) / 2;
                userMoney += Float.parseFloat(diamonds[i].getPip()) / 2;
            }
            else{
                System.out.println("Congrats you won this bid");
                userMoney += Float.parseFloat(diamonds[i].getPip());
            }
        }
       System.out.println(computerMoney > userMoney ? "You lost" : "Congratulations you won the game");
       System.out.println("Computer has " + computerMoney + " money, and you have" + userMoney);
    }

    public int getComputerBid(){
        return 15;
    }

    public String toString() {
        String myCards = "Diamonds are: ";
        for (int i = 0; i < cardsInOneSuit; i++) {
            myCards += diamonds[i] + "\n";
        }
        return myCards;
    }
}