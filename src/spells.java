import java.util.ArrayList;

public abstract class spells extends items{


    public spells(int cost, int levelRequired, String name, int damageOrHeal, int manaCost, int type) {
        super(cost, levelRequired, name, damageOrHeal, manaCost, type);
    }

    public abstract void useSpell(ArrayList<monsters> monsterList);
    public abstract void use(hero h);
}
