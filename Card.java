
/**
 * Write a description of class Card here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Card
{
    private int face;
    private int suit;
    private String[] faces = {"Ace","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King"};
    private String[] suits = {"Spades","Hearts","Clubs","Diamonds"};
    public Card(int f, int s)
    {
        if(f<0 || f>12){
            face = 1;
        } else {
            face = f;
        }
        if(s<0 || s>3){
            suit = 1;
        } else {
            suit = s;
        }
    }
    public int getFace() {
        return face;
    }
    public int getSuit() {
        return suit;
    }
    public String toString() {
        return "The "+faces[face]+" of "+suits[suit];
    }
}
