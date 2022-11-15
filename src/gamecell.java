public abstract class gamecell {

    int type;
    int[] location = new int[2];
    String symbol;

    public gamecell(int type, String symbol ) {

        this.type = type;
        this.symbol= symbol;
    }
}
