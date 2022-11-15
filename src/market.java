import java.nio.file.FileSystemNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
// market class to conduct market operations
public class market {

    ArrayList<items>  marketList= new ArrayList<items>();
    Scanner p = new Scanner(System.in);

    public void openSaleList(hero h){
        while(true) {
            System.out.println("Welcome " + h.name + ". The following items are on sale");
            int k = 1;
            for (items i : marketList) {
                System.out.println(k + ". Name: " + i.name + " | cost " + i.cost + " | Level Req: " + i.levelRequired +
                        " | Damage/Heal: " + i.damageOrHeal + " | Mana Cost: " + i.manaCost);
                k++;

            }
            System.out.println("Enter index number of Item you want to buy. Enter 0 to exit.");
            int input = p.nextInt();
            if (input == 0) {
                return;
            } else if (marketList.get(input - 1).levelRequired > h.getExperience()) {
                System.out.println("Level not high enough to buy item!");
            } else if (marketList.get(input-1).cost< h.money +1) {
                System.out.println(marketList.get(input - 1).name+ " has been added to " + h.name +"'s inventory");
                h.inventory.add(marketList.get(input - 1));
                h.money= h.money- marketList.get(input-1).cost;
            }else if (marketList.get(input-1).cost > h.money +1) {
                System.out.println("Not enough money to buy this item!");
            }



        }
    }



}
