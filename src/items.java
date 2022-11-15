import java.util.ArrayList;

public abstract class items {
    int cost;
    int levelRequired;
    String name;
    int damageOrHeal;

    int manaCost;
    int type;


    public items(int cost, int levelRequired, String name, int damageOrHeal, int manaCost, int type) {
        this.cost = cost;
        this.levelRequired = levelRequired;
        this.name = name;
        this.damageOrHeal = damageOrHeal;
        this.manaCost = manaCost;
        this.type = type;
    }

    public abstract void use(hero h);
    public abstract void useSpell(ArrayList<monsters> monsterList);
}
