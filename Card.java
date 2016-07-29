class Card implements Comparable{
    protected String suit;
    protected int pip;

    public Card(String suit, int pip){
        this.suit = suit;
        this.pip = pip;
    }
    public String getColor() {
        if(suit == "spade" || suit == "club") return "black";
        return "red";
    }
    public String getSuit() {
        return suit;
    }
    public String getPip() {
        if(pip == 1) return "A";
        if(pip == 10) return "T";
        if(pip == 11) return "J";
        if(pip == 12) return "Q";
        if(pip == 13) return "K";
        return "" + pip;
    }
    @Override
    public int compareTo(Object anotherCard){
        return (this.pip - ((Card) anotherCard).pip);
    }
    @Override
    public String toString(){
        return suit + " " + pip;
    }
    public int comparePip(Card anotherCard){
        if(this.pip > anotherCard.pip) return 1;
        if(this.pip < anotherCard.pip) return -1;
        return 0;
    }
    public boolean isSuitSame(Card anotherCard){
        if(anotherCard.suit == this.suit) return true;
        return false;
    }
    public boolean isColorSame(Card anotherCard){
        if(anotherCard.getColor() == this.getColor()) return true;
        return false;
    }
}