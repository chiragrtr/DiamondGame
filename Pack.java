import java.util.ArrayList;

public class Pack {
    Card[] cards;
    //ArrayList<Card> jokers = new ArrayList<>();
    private final int NUMOFSUITS = 4;
    private final int NUMOFCARDSINASUIT = 13;

    Pack(int numOfJokers){
        ArrayList<Card> cardsList = new ArrayList<>();
        String suit = "";
        for(int suitIter = 1; suitIter <= NUMOFSUITS; suitIter++){
            if(suitIter == 1) suit = "Club";
            if(suitIter == 2) suit = "Diamond";
            if(suitIter == 3) suit = "Heart";
            if(suitIter == 4) suit = "Spade";
            for(int pip = 1; pip <= NUMOFCARDSINASUIT; pip++){
                cardsList.add(new Card(suit, pip));
            }
        }
        for(int jokerIter = 1; jokerIter <= numOfJokers; jokerIter++){
            cardsList.add(new Joker("JOKER", 0));
        }
        cards = new Card[cardsList.size()];
        cards = (cardsList.toArray(cards));
    }
    @Override
    public String toString(){
        String cardsInfo = "";
        for(int i = 0; i < NUMOFCARDSINASUIT * NUMOFSUITS; i++){
            cardsInfo += cards[i].toString() + "\n";
        }
        return cardsInfo;
    }
/*
    public static void main(String[] args) {
        Pack p1 = new Pack(0);
        System.out.println(p1);
    }
    */
}