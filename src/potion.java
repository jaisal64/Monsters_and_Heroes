import java.util.ArrayList;
// potion class inheriting items
public class potion extends items{


    public potion(int cost, int levelRequired, String name, int damageOrHeal, int manaCost, int type) {
        super(cost, levelRequired, name, damageOrHeal, manaCost, type);

    }


    public void use(hero h) {
        if (name == "Healing Potion") {
            h.health = h.health + damageOrHeal;
        } else if (name == "Strength Potion") {
            h.attack = h.attack + damageOrHeal;
        } else if (name == "Mana Potion") {
            h.mana = h.mana + damageOrHeal;
        } else if (name == "Agility Potion") {
            h.agility = h.agility + damageOrHeal;
        } else if (name == "Mermaid Tears Potion") {
            h.agility = h.agility + damageOrHeal;
            h.mana = h.mana + damageOrHeal;
            h.attack = h.attack + damageOrHeal;
            h.health = h.health + damageOrHeal;
        } else if (name == "Ambrosia All Stats") {
            h.agility = h.agility + damageOrHeal;
            h.mana = h.mana + damageOrHeal;
            h.attack = h.attack + damageOrHeal;
            h.health = h.health + damageOrHeal;
            h.dexterity = h.dexterity + damageOrHeal;
        }

    }

    public void useSpell(ArrayList<monsters> monsterList) {
        return;
    }


}
