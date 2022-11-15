import java.util.ArrayList;

// gameboard class that generates a map with diferent cells and prints map
public class gameboard {
    int size;
    ArrayList <gamecell> cells = new ArrayList<gamecell>();
    public gameboard(int size){
        this.size=size;

    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public ArrayList<gamecell> getCells() {
        return cells;
    }

    public void setCells(ArrayList<gamecell> cells) {
        this.cells = cells;
    }

    public int[] getPartyLocation() {
        return partyLocation;
    }

    public void setPartyLocation(int[] partyLocation) {
        this.partyLocation = partyLocation;
    }

    int [] partyLocation = new int[2];




    public void generateMap(int size, commonCell c, marketCell m, noAccessCell x) {
        for (int i = 0; i < (size * size); i++) {
            if(i%2==0){
                cells.add(c);
            } else if (i%5==0) {
                cells.add(x);
            }
            else {
                cells.add(m);
            }
        }
    }

    public void printBoard(){
        int count =0;
        for(int i=0; i<size; i++){
            System.out.println();
            for(int j=0; j<size; j++){
                if(j==0) {
                    for (int k = 0; k < size; k++) {
                        System.out.print("+---+");
                    }
                    System.out.println();
                }

                if(count==(partyLocation[0]*size + partyLocation[1])) {
                    System.out.print("| " + "P" + " |");
                    count++;
                    continue;

                }

                System.out.print("| " + cells.get(count).symbol + " |");
                count++;
                }

        }
        System.out.println();
        System.out.println();
        System.out.println("Controls: w/s/a/d for up/down/left/right. i: hero info, e: Apply Weapon/Armor/Potion , q: quit");

    }


}
