import java.util.Random;

public class Coin
{
    String side;
    final public static String HEADS = "Heads";
    final public static String TAILS = "Tails";


    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String flip()
    {
        if(new Random().nextBoolean())
        {
            setSide(TAILS);
        }
        else
        {
            setSide(HEADS);
        }

        return getSide();
    }
}
