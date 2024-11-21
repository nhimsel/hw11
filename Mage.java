public class Mage extends Player
{
    private int mp;

    public Mage(String name)
    {
        super(name);
        this.str -=3;
        this.ac-=2;
        this.hp+=5;

        Dice mp_die = new Dice(26);
        this.mp = mp_die.roll()+24;
    }

    @Override
    public String toString()
    {
        String top = " _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _";
        String bottom = " ‾ ‾ ‾ ‾ ‾ ‾ ‾ ‾ ‾ ‾ ‾ ‾ ‾ ‾ ‾ ‾";
        if (this.name.length()<=5)
        {
            return top+"\n| "+this.name+"\t\t\t  HP="+this.hp+
                " |\n|\t\t\t\t|\n| STR="+this.str+
                "  \t\t\t|\n| AC="+this.ac+
                "   \t\t\t|\n| MP="+this.mp+
                "   \t\t\t|\n|\t\t\t\t|\n"+bottom;
        }
        else if (this.name.length()<=13)
        {
            return top+"\n| "+this.name+"\t\t  HP="+this.hp+
                " |\n|\t\t\t\t|\n| STR="+this.str+
                "  \t\t\t|\n| AC="+this.ac+
                "   \t\t\t|\n| MP="+this.mp+
                "   \t\t\t|\n|\t\t\t\t|\n"+bottom;
        }
        else if (this.name.length()<=21)
        {
            return top+"\n| "+this.name+"\t  HP="+this.hp+
                " |\n|\t\t\t\t|\n| STR="+this.str+
                "  \t\t\t|\n| AC="+this.ac+
                "   \t\t\t|\n| MP="+this.mp+
                "   \t\t\t|\n|\t\t\t\t|\n"+bottom;
        }
        else
        {
            top = ""; bottom = "";
            for (int i=0; i<this.name.length()/2+2; i++)
            {
                top += " _";
                bottom += " ‾";
            }
            return top+"\n| "+this.name+"\t   \n|\n| HP="+this.hp+
                " |\n|\t\t\t\t|\n| STR="+this.str+
                "  \t\t\t|\n| AC="+this.ac+
                "   \t\t\t|\n| MP="+this.mp+
                "   \t\t\t|\n|\t\t\t\t|\n"+bottom;
        }
    }
}