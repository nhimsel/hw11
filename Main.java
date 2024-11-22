public class Main
{
    public static void main(String[] args)
    {
        Mage merlin = new Mage("Merlin");
        Warrior parzival = new Warrior("Parzival");
        Arena R1 = new Arena(merlin, parzival);
        R1.Fight();
    }
}