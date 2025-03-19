import java.util.Random;

public class StoneHeap extends Case{

    private int stoneCount;

    public int getStoneCount() {
        return stoneCount;
    }

    public void setStoneCount(int stoneCount) {
        this.stoneCount = stoneCount;
    }

    /**
     * Nombre aléatoire de pierre entre 1 et le nombre max de pierre sur la case
     * @param maxStoneCount maximum de pierre possible au départ sur une case
     */
    public StoneHeap(int maxStoneCount) {
        super();
        Random random=new Random(); //objet de la classe random qui possède des méthodes permettant d'obtenir un nombre aléatoire
        this.stoneCount = random.nextInt(1,maxStoneCount);
    }

    @Override
    public boolean haveCollision() {
        return false;
    }

    /**
     * Ajout du nombre de pierre sur la case au stock de pierre du joueur
     * Passe la case de tas de pierre à une case normal
     * @param board
     * @param player
     * @param x
     * @param y
     */
    @Override
    public void apply(Board board, Player player, int x, int y) {
        player.setStones(player.getStones()+ stoneCount);
        board.setCase(y, x, new NormalCase());
    }

    @Override
    public String toString() {
        if(isRevealed() || Game.isCheat()){
            return "\uD83E\uDEA8 " ;
        }
        else{
            return charNoRevealed;
        }
    }
}
