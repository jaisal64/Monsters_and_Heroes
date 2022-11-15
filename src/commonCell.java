import java.util.ArrayList;



//commoncell class .has methods to checks if monsters are generated and another then another method to generates them
public class commonCell extends gamecell{


    public commonCell(int type, String symbol) {
        super(type, symbol);
    }

    public boolean monsterAttackCheck(int moveCount){
        if(moveCount%3==0){
            return true;
        }
        else{
            return false;
        }

    }

//method to make sure monster attributes are matched with hero attributes
    public ArrayList<monsters> monsterGenerator (ArrayList<hero> heroList, ArrayList<monsters> monsterList){
        ArrayList<monsters> monsterBattleParty = new ArrayList<monsters>();
        int attackSum=0;
        int defenceSum=0;
        int agilitySum=0;
        int healthSum=0;

        for (hero h : heroList){
            attackSum += h.attack;
            defenceSum += h.dexterity;
            agilitySum += h.agility;
            healthSum += h.health;
        }


        monsterList.get(0).strength= Math.max((int) ( attackSum*0.4), 250);
        monsterList.get(0).defence= Math.max((int) ( defenceSum*0.25),150);
        monsterList.get(0).dodge= Math.max((int) ( agilitySum*0.25),100);
        monsterList.get(0).health= Math.max((int) ( healthSum*0.25),150);

            monsterList.get(1).strength= Math.max((int) ( attackSum*0.25), 150);
        monsterList.get(1).defence= Math.max((int) ( defenceSum*0.4),200);
        monsterList.get(1).dodge= Math.max((int) ( agilitySum*0.25),100);
        monsterList.get(1).health= Math.max((int) ( healthSum*0.25),150);

        monsterList.get(2).strength= Math.max((int) ( attackSum*0.25), 150);
        monsterList.get(2).defence= Math.max((int) ( defenceSum*0.25),100);
        monsterList.get(2).dodge= Math.max((int) ( agilitySum*0.4),200);
        monsterList.get(2).health= Math.max((int) ( healthSum*0.25),150);


        monsterBattleParty.add(monsterList.get(0));
        monsterBattleParty.add(monsterList.get(1));
        monsterBattleParty.add(monsterList.get(2));





        return monsterBattleParty;
    }


}



