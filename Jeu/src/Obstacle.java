public class Obstacle extends Case{
    public Obstacle(){
        super();
    }

    @Override
    public boolean haveCollision() {
        return true;
    }

    @Override
    public void apply(Board board, Player player,  int x, int y) {}

    @Override
    public String toString() {
        if(isRevealed() || Game.isCheat()){
            return "\uD83D\uDFE9";
        }
        else{
            return charNoRevealed;
        }
    }
}
