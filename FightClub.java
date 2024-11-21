public class FightClub
{
    protected Player p1;
    protected Player p2;
    final Dice d20 = new Dice(20);
    final Dice d4 = new Dice(4);
    final Dice d2 = new Dice(2);

    public FightClub(Player p1, Player p2)
    {
        this.p1 = p1;
        this.p2 = p2;
    }

    public void Fight()
    {
        Player curAttacker;
        Player curDefender;
        if (this.d20.roll()>10)
        {
            curAttacker = this.p1; 
            curDefender = this.p2;
        }
        else
        {
            curAttacker = this.p2; 
            curDefender = this.p1;
        }

        //print stats of characters
        System.out.println(curAttacker + "\n" + curDefender);
        
        while (true) 
        //loop runs until a player dies
        {
            System.out.println(curAttacker.getName() + "   HP: " + curAttacker.getHP());
            System.out.println(curDefender.getName() + "   HP: "+curDefender.getHP());
            System.out.println(curAttacker.getName() + " is on the offensive.");
            int atkRoll = this.d20.roll();
            if (atkRoll >= curDefender.getAC())
            {
                //defender has been hit
                int tempHP = curDefender.getHP();
                int damage = this.d4.roll();
                curDefender.takeDamage(damage, curAttacker.getSTR());
                System.out.println(curAttacker.getName() + " deals " 
                + (tempHP-curDefender.getHP()) + " points of damage to " 
                + curDefender.getName());
                if (curDefender.isDead())
                {
                    //defender is dead, attacker wins
                    System.out.println(curDefender.getName() + " was killed. " 
                    + curAttacker.getName() + " wins.");
                    return;
                }
            }
            else
            {
                //attack defended
                if (atkRoll<=3)
                {
                    //attack missed, defender counterattacks
                    int damage = this.d2.roll();
                    curAttacker.takeDamage(damage);
                    System.out.println(curAttacker.getName() + 
                    " missed their attack! " + curDefender.getName() + 
                    " counterattacks and deals " + damage + " points of damage.");
                    if (curAttacker.isDead())
                    {
                        //attacker was killed, defender wins
                        System.out.println(curAttacker.getName() + " was killed. " 
                        + curDefender.getName() + " wins.");
                        return;
                    }
                }
                else
                {
                    System.out.println(curDefender.getName() + " defended the attack.");
                }
            }
            //swap players
            Player tmp = curAttacker;
            curAttacker = curDefender;
            curDefender = tmp;

            //add a blank line to make clear the end of a turn
            System.out.println("");
        }
    }
}