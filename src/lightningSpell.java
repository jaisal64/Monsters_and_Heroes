import java.util.ArrayList;

public class lightningSpell extends spells{


    public lightningSpell(int cost, int levelRequired, String name, int damageOrHeal, int manaCost, int type) {
        super(cost, levelRequired, name, damageOrHeal, manaCost, type);
    }

    public void useSpell(ArrayList<monsters> monsterList) {
        for (monsters m: monsterList){
            m.dodge= m.dodge - this.damageOrHeal;
        }
    }

    public void use(hero h) {
        return;
    }
}
