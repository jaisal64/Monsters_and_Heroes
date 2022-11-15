import java.util.ArrayList;
import static java.lang.Math.min;
public class iceSpell extends spells{


    public iceSpell(int cost, int levelRequired, String name, int damageOrHeal, int manaCost, int type) {
        super(cost, levelRequired, name, damageOrHeal, manaCost, type);
    }

    public void useSpell(ArrayList<monsters> monsterList) {
        for (monsters m: monsterList){
            m.strength= min((m.strength - this.damageOrHeal),15);
        }
    }




    public void use(hero h) {
        return;
    }
}

