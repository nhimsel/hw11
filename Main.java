public class Main
{
    public static void main(String[] args)
    {
        Player p1 = new Player("Milky");
        Player p2 = new Player("Lug");
        Player p3 = new Player("Sluggerwort");

        /* FightClub a1 = new FightClub(p1,p3);
        a1.Fight(); */

        Warrior p4 = new Warrior("Slugga");
        p4.display();
    }
}