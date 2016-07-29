import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    Card[] cards;
    int numOfPacks;
    int NumOfJokersInAPack;
    Deck(int numOfPacks, int numOfJokersInAPack){
        this.numOfPacks = numOfPacks;
        this.NumOfJokersInAPack = numOfJokersInAPack;
        ArrayList<Card> cardsList= new ArrayList<>();
        for(int i = 0; i < numOfPacks; i++){
            Pack p1 = new Pack(numOfJokersInAPack);
            for(int j = 0; j < p1.cards.length; j++) {
                cardsList.add(p1.cards[j]);
            }
        }
        cards = new Card[cardsList.size()];
        cards = cardsList.toArray(cards);
    }
    public void shuffle(int suitNum){
        List<Card> solution = new ArrayList<>();
        for (int i = suitNum * 13; i < (suitNum + 1) * 13; i++)
        {
            solution.add(cards[i]);
        }
        Collections.shuffle(solution);
        cards = solution.toArray(cards);
    }
    public String toString(){
        String cardsString = "";
        for(int i = 0; i < cards.length; i++)
            cardsString += cards[i] + "\n";
        return cardsString;
    }
    public static void main(String[] args) {
        Deck myDeck = new Deck(1,0);
        System.out.println(myDeck);
    }
}
