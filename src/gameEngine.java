import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class gameEngine {

    Scanner p = new Scanner(System.in);
    int heroCount = 1;
    ArrayList<hero> heroList = new ArrayList<hero>();
    ArrayList<monsters> monsterList = new ArrayList<monsters>();

    ArrayList<hero> heroParty = new ArrayList<hero>();
    ArrayList<monsters> monsterBattleParty = new ArrayList<monsters>();

    market market = new market();

    public int getMoveCount() {
        return moveCount;
    }

    public void setMoveCount(int moveCount) {
        this.moveCount = moveCount;
    }

    int moveCount = 0;

    public void gameStart() {

        System.out.println("Welcome to Heroes and Monsters!");
        System.out.println("Enter size of NxN map between 3 and 10");
        int boardSize = p.nextInt();

        while (boardSize < 3 || boardSize > 10) {
            System.out.println("Enter VALID size of NxN map between 3 and 10");
            boardSize = p.nextInt();
        }

        gameboard gameboard = new gameboard(boardSize);
        gameboard.partyLocation[0] = 0;
        gameboard.partyLocation[1] = 0;
        commonCell commonCell = new commonCell(1, "C");
        marketCell marketCell = new marketCell(2, "M");
        noAccessCell noAccessCell = new noAccessCell(0, "I");

        gameboard.generateMap(boardSize, commonCell, marketCell, noAccessCell);
        gameboard.partyLocation[0] = 0;
        gameboard.partyLocation[1] = 0;

        market market = new market();
        battle battle = new battle();


        System.out.println("Welcome to Heroes and Monsters! How many heroes would you" +
                " like to play with? Enter a number between 1 and 6");
        heroCount = p.nextInt();


        // initializing heroes
        warrior johnSnow = new warrior("John Snow the Warrior",
                300, 500, 100, 500, 100);
        heroList.add(johnSnow);


        paladin darkKnight = new paladin("Dark Knight the Paladin",
                150, 400, 200, 500, 100);
        heroList.add(darkKnight);


        sorcerer harryPotter = new sorcerer("Harry Potter the Sorcerer",
                170, 300, 100, 500, 200);
        heroList.add(harryPotter);


        warrior blackPanther = new warrior("Black Panther the Warrior",
                250, 350, 100, 500, 100);
        heroList.add(blackPanther);


        paladin mountain = new paladin("Mountain the Paladin",
                170, 300, 250, 500, 100);
        heroList.add(mountain);


        sorcerer gandalf = new sorcerer("Gandalf the Sorcerer",
                170, 300, 100, 500, 200);
        heroList.add(gandalf);


        //generating monsters

        dragon balerion = new dragon(300, 200, 100, 100, "Balerion the Dread Dragon");
        monsterList.add(balerion);

        exoskeleton skeletor = new exoskeleton(300, 50, 200, 90, "Skeletor the Exoskeleton");
        monsterList.add(skeletor);


        spirits maunjulika = new spirits(300, 60, 100, 190, "Maunjulika the Spirit");
        monsterList.add(maunjulika);


        dragon dracarys = new dragon(300, 175, 100, 100, "Dracarys the Dragon");
        monsterList.add(dracarys);


        exoskeleton noBlood = new exoskeleton(250, 50, 250, 90, "NoBlood the Exoskeleton");
        monsterList.add(noBlood);


        spirits voldemort = new spirits(300, 100, 120, 290, "Lord Voldemort the Spirit");
        monsterList.add(voldemort);


        // monsterList.add("Dragon");
        // monsterList.add("Spirit");
        // monsterList.add("Exoskeleton");

        //generating items such as armor, weapons , potions and spells


        weapons sword = new weapons(500, 1, "Sword", 200, 0,1);
        weapons bow = new weapons(300, 2, "Bow", 300, 0,1);
        weapons scythe = new weapons(800, 6, "Scythe", 900, 0,1);
        weapons axe = new weapons(550, 5, "Axe", 500, 0,1);
        weapons tSwords = new weapons(1400, 9, "TSword", 1100, 0,1);
        weapons dagger = new weapons(400, 2, "Dagger", 300, 0,1);

        market.marketList.add(sword);
        market.marketList.add(bow);
        market.marketList.add(scythe);
        market.marketList.add(axe);
        market.marketList.add(tSwords);
        market.marketList.add(dagger);

        armor platinumShield = new armor(200, 1, "Platinum Shield", 200, 0,2);
        armor breastPlate = new armor(300, 3, "Breast Plate", 500, 0,2);
        armor fullBodyArmor = new armor(1000, 8, "Full Body Armor", 1100, 0,2);
        armor wizardShield = new armor(1200, 10, "Wizard Shield", 1500, 0,2);
        armor guardianAngel = new armor(1000, 10, "Guardian Angel", 1000, 0,2);

        market.marketList.add(platinumShield);
        market.marketList.add(breastPlate);
        market.marketList.add(fullBodyArmor);
        market.marketList.add(wizardShield);
        market.marketList.add(guardianAngel);


        potion healingPotion = new potion(250, 1, "Healing Potion", 100, 0,3);
        potion strengthPotion = new potion(200, 1, "Strength Potion", 75, 0,3);
        potion manaPotion = new potion(350, 2, "Mana Potion", 100, 0,3);
        potion agilityPotion = new potion(500, 4, "Agility Potion", 75, 0,3);
        potion mermaidTears = new potion(850, 5, "Mermaid Tears Potion", 100, 0,3);
        potion ambrosia = new potion(1000, 8, "Ambrosia All Stats", 100, 0,3);

        market.marketList.add(healingPotion);
        market.marketList.add(strengthPotion);
        market.marketList.add(manaPotion);
        market.marketList.add(agilityPotion);
        market.marketList.add(mermaidTears);
        market.marketList.add(ambrosia);

        fireSpell flameTornado = new fireSpell(700, 4, "Flame Tornado", 600, 300,4);
        fireSpell breathOfFire = new fireSpell(350, 1, "Breath of Fire", 300, 100,4);
        fireSpell heatWave = new fireSpell(450, 2, "Heat Wave", 400, 200,4);
        fireSpell lavaComet = new fireSpell(850, 7, "Lava Comet", 800, 400,4);
        fireSpell hellStorm = new fireSpell(1000, 9, "Hell Storm", 1000, 500,4);

        market.marketList.add(flameTornado);
        market.marketList.add(breathOfFire);
        market.marketList.add(heatWave);
        market.marketList.add(lavaComet);
        market.marketList.add(hellStorm);

        iceSpell snowCannon = new iceSpell(500, 2, "Snow Cannon", 650, 250,5);
        iceSpell iceBlade = new iceSpell(250, 1, "Ice Blade", 450, 100,5);
        iceSpell frostBlizzard = new iceSpell(750, 5, "Frost Blizzard", 850, 350,5);
        iceSpell arcticStorm = new iceSpell(700, 4, "Arctic Storm", 800, 300,5);

        market.marketList.add(snowCannon);
        market.marketList.add(iceBlade);
        market.marketList.add(frostBlizzard);
        market.marketList.add(arcticStorm);

        lightningSpell lightningDagger = new lightningSpell(400, 1, "Lightning Dagger", 500, 300,6);
        lightningSpell thunderBlast = new lightningSpell(750, 4, "Thunder Blast", 950, 400,6);
        lightningSpell electricArrows = new lightningSpell(550, 5, "Electric Arrows", 650, 200,6);
        lightningSpell sparkNeedles = new lightningSpell(500, 2, "Spark Needles", 600, 200,6);

        market.marketList.add(lightningDagger);
        market.marketList.add(thunderBlast);
        market.marketList.add(electricArrows);
        market.marketList.add(sparkNeedles);

        // empty items object to give to heroes
        armor empty1 = new armor(0,1,"Empty",0,0,2);
        weapons empty2 = new weapons(0,1,"Empty",0,0,1);



// creating hero party
        int c = 0;

        for (hero x : heroList) {
            if (c == heroCount) {
                break;
            } else {
                heroParty.add(x);
                c++;
            }
        }

        for (hero x : heroParty) {
            x.equippedWeapon=empty2;
            x.equippedArmor= empty1;
        }

        gameboard.printBoard();

// take input to move on the map, check if legal move and if monsters are generated or open the marketplace IF ON M CELL

        String input = "s";
        int moveCount=0;
        boolean monster=false;

        while(!input.equals("q")) {
            input = p.next();

            if (Objects.equals(input, "w")) {
                if (gameboard.partyLocation[0] == 0) {
                    System.out.println("Not a valid move! Try Again");
                } else if (gameboard.cells.get((gameboard.partyLocation[0] - 1) * boardSize + gameboard.partyLocation[1]) == noAccessCell) {
                    System.out.println("Inaccessible cell! Try Again");
                }
                else if(gameboard.cells.get((gameboard.partyLocation[0] - 1) * boardSize + gameboard.partyLocation[1]) == marketCell){
                    gameboard.partyLocation[0]--;
                    for (hero x : heroParty){
                    market.openSaleList(x);
                    moveCount++;
                }}

                else if(gameboard.cells.get((gameboard.partyLocation[0] - 1) * boardSize + gameboard.partyLocation[1]) == commonCell) {
                    gameboard.partyLocation[0]--;
                    monster = commonCell.monsterAttackCheck(moveCount);
                    if (monster) {
                        monsterBattleParty = commonCell.monsterGenerator(heroParty, monsterList);
                        heroParty= battle.letFightTheMonsters(heroParty, monsterBattleParty);

                    }
                    moveCount++;
                }
                else {
                    gameboard.partyLocation[0]--;
                moveCount++;
                }

            } else if (Objects.equals(input, "s")) {
                if (gameboard.partyLocation[0] == (boardSize - 1)) {
                    System.out.println("Not a valid move! Try Again");
                } else if (gameboard.cells.get((gameboard.partyLocation[0] + 1) * boardSize + gameboard.partyLocation[1]) == noAccessCell) {
                    System.out.println("Inaccessible cell! Try Again");
                }
                else if(gameboard.cells.get((gameboard.partyLocation[0] + 1) * boardSize + gameboard.partyLocation[1]) == marketCell){
                    gameboard.partyLocation[0]++;
                    for (hero x : heroParty) {
                        market.openSaleList(x);
                        moveCount++;
                    }
                }

                else if(gameboard.cells.get((gameboard.partyLocation[0] + 1) * boardSize + gameboard.partyLocation[1]) == commonCell) {
                    gameboard.partyLocation[0]++;
                    monster = commonCell.monsterAttackCheck(moveCount);
                    if (monster) {
                        monsterBattleParty = commonCell.monsterGenerator(heroParty, monsterList);
                        heroParty= battle.letFightTheMonsters(heroParty, monsterBattleParty);

                    }
                    moveCount++;
                }
                else {
                    gameboard.partyLocation[0]++;
                    moveCount++;
                }
            } else if (Objects.equals(input, "a")) {
                if (gameboard.partyLocation[1] == 0) {
                    System.out.println("Not a valid move! Try Again");
                } else if (gameboard.cells.get((gameboard.partyLocation[0]) * boardSize + gameboard.partyLocation[1] - 1) == noAccessCell) {
                    System.out.println("Inaccessible cell! Try Again");
                }
                else if(gameboard.cells.get((gameboard.partyLocation[0]) * boardSize + gameboard.partyLocation[1] - 1) == marketCell){
                    gameboard.partyLocation[1]--;
                    for (hero x : heroParty) {
                        market.openSaleList(x);
                        moveCount++;
                    }}

                    else if(gameboard.cells.get((gameboard.partyLocation[0]) * boardSize + gameboard.partyLocation[1] - 1) == commonCell){
                        gameboard.partyLocation[1]--;
                    monster=commonCell.monsterAttackCheck(moveCount);
                    if (monster){
                        monsterBattleParty=commonCell.monsterGenerator(heroParty, monsterList);
                        heroParty= battle.letFightTheMonsters(heroParty, monsterBattleParty);

                    }
                            moveCount++;
                        }

                else {
                    gameboard.partyLocation[1]--;
                    moveCount++;
                }
            } else if (Objects.equals(input, "d")) {
                if (gameboard.partyLocation[1] == (boardSize - 1)) {
                    System.out.println("Not a valid move! Try Again");
                } else if (gameboard.cells.get((gameboard.partyLocation[0]) * boardSize + gameboard.partyLocation[1] + 1) == noAccessCell) {
                    System.out.println("Inaccessible cell! Try Again");
                }
                else if(gameboard.cells.get((gameboard.partyLocation[0]) * boardSize + gameboard.partyLocation[1] + 1) == marketCell){
                    gameboard.partyLocation[1]++;
                    for (hero x : heroParty) {
                        market.openSaleList(x);
                        moveCount++;
                    }
                }

                else if(gameboard.cells.get((gameboard.partyLocation[0]) * boardSize + gameboard.partyLocation[1] + 1) == commonCell){
                    gameboard.partyLocation[1]++;
                    monster= commonCell.monsterAttackCheck(moveCount);
                        moveCount++;

                    }
                else {
                    gameboard.partyLocation[1]++;
                    moveCount++;
                }

            } else if (Objects.equals(input, "i")) {
                System.out.println();
                for (hero x : heroParty){
                    x.displayInfo();

                }

            }

            else if (Objects.equals(input, "e")) {
                System.out.println();
                int n;

                   for (hero x : heroParty) {

                       x.openInventory();
                       System.out.println("Enter index number of Weapon/Armor to equip or potion to be used. Enter 0 to exit.");
                       n = p.nextInt();
                       if (n==0){
                           continue;
                       }
                       else if (x.inventory.get(n-1).type == 1) {
                           x.equippedWeapon = x.inventory.get(n-1);
                           System.out.println(x.inventory.get(n-1).name + " has been equipped for " + x.name);
                       }
                       else if (x.inventory.get(n-1).type == 2){
                           x.equippedArmor = x.inventory.get(n-1);
                           System.out.println(x.inventory.get(n-1).name + " has been equipped for " + x.name);
                           }
                       else if (x.inventory.get(n-1).type == 3) {
                           x.inventory.get(n - 1).use(x);
                           System.out.println(x.inventory.get(n - 1).name + " has been used on  " + x.name);
                           x.inventory.remove(n-1);
                       }
                       else if (x.inventory.get(n-1).type > 3) {
                           System.out.println("Cannot use spells outside of Battle!");
                       }
                   }
               }


                gameboard.printBoard();
        }



    }
}


