import java.util.ArrayList;

public class armor extends items{


    public armor(int cost, int levelRequired, String name, int damageOrHeal, int manaCost, int type) {
        super(cost, levelRequired, name, damageOrHeal, manaCost, type);
    }

    public void use(hero h) {
        return;
    }

    public void useSpell(ArrayList<monsters> monsterList) {
        return;
    }


}
