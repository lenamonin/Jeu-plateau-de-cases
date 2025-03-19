public class Player {
    private int x;
    private int y;
    private int stones;
    private boolean lost;
    private boolean win;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isLost() {
        return lost;
    }

    public void setLost(boolean lost) {
        this.lost = lost;
    }

    public int getStones() {
        return stones;
    }

    public void setStones(int stones) {
        this.stones = stones;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public Player(int x, int y, int stones) {
        this.x = x;
        this.y = y;
        this.lost = false;
        this.stones = stones;
        this.win=false;
    }

    @Override
    public String toString() {
        return "\uD83D\uDC7E";
    }
}
