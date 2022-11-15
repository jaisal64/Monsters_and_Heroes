import java.util.ArrayList;

import static java.lang.Math.min;

public class fireSpell extends spells{


    public fireSpell(int cost, int levelRequired, String name, int damageOrHeal, int manaCost, int type) {
        super(cost, levelRequired, name, damageOrHeal, manaCost, type);
    }

    public void use(hero h) {
        return;
    }

    public void useSpell(ArrayList<monsters> monsterList) {
        for (monsters m: monsterList){
            m.defence= min((m.defence - this.damageOrHeal),10);
        }
    }

    public void use() {

    }
}
