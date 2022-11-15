import java.util.ArrayList;
import java.util.Scanner;

// class to conduct battle
public class battle {

    int turn=0;
    ArrayList <hero> heroList= new ArrayList<>();
    ArrayList <monsters> monsterList = new ArrayList<>();
    Scanner p = new Scanner(System.in);


    public ArrayList<hero> letFightTheMonsters(ArrayList<hero> heroList, ArrayList<monsters> monsterList ){
        ArrayList <hero> heroParty = new ArrayList<hero>();
        for(hero h : heroList){
            if(h.health>0){
                heroParty.add(h);
            }
        }
        while (!heroParty.isEmpty() && !monsterList.isEmpty()){
        for(hero h : heroParty){
            System.out.println("---------Battle Zone------");
            System.out.println("Hero " + h.name + "'s turn to attack.");
            System.out.println("Enter 1 : attack,  2: use item,  3: Display Hero info");
            int input = p.nextInt();
            if(input==1){
                int i=1;
                System.out.println("Enter index number of monster "+h.name  + " should attack");
                for(monsters m : monsterList){

                    System.out.println(i+" : " + m.name + " HP: " + m.health);

                    i++;
                }
                input = p.nextInt();
                System.out.println("Hero"+h.name + " has launched an attack on "+ monsterList.get(input-1).name);
                h.attack(monsterList.get(input-1));
                System.out.println(monsterList.get(input-1).name + " has remaining HP: " + monsterList.get(input-1).health);
                if(monsterList.get(input-1).health<1){
                    System.out.println(monsterList.get(input-1).name +" has fainted! ** Well done **");
                    monsterList.remove(input-1);
                }
            }
            else if(input==2){
                h.openInventory();
                System.out.println("Enter index number of item to use. " );
                input= p.nextInt();
                if (input == 0) {
                    continue;
                }
                else if (h.inventory.get(input-1).type==3){
                    h.inventory.get(input-1).use(h);
                }
                else if(h.inventory.get(input-1).type>3){
                    h.inventory.get(input-1).useSpell(monsterList);
                }
                else if(h.inventory.get(input-1).type<3){
                    System.out.println("Cannot change Weapons/Armor during Battle! Turn Lost!!" );
                }

            }
            else if (input==3){
                h.displayInfo();
            }


        }
        //monster turn to attack
            int heroCount= heroParty.size();
            int k=0;
            for (monsters m : monsterList){
                if (k==heroCount){
                    k=0;
                }

                m.attack(heroParty.get(k));
                System.out.println(m.name + " has attacked "+ heroParty.get(k).name + " HP remaining : "+ heroParty.get(k).health);
                k++;

            }
        }
// level up and gold for winning
        if(monsterList.isEmpty()){
            for (hero h : heroParty){
                h.levelUpAttributes();
                h.money += 250;
            }
            for (hero h : heroList){
                h.health= h.hp;
            }

        }
        else if(heroParty.isEmpty()){
            System.out.println("*********     Game Over     ******");
            System.exit(1);

        }



        return heroList;
    }




}

