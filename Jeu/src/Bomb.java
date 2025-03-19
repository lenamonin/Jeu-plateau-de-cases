public class Bomb extends Case{
    public Bomb(){
        super();
    }

    @Override
    public boolean haveCollision() {
        return false;
    }

    //Le joueur perd quand il arrive sur cette case
    @Override
    public void apply(Board board, Player player, int x, int y) {
        player.setLost(true);
    }

    @Override
    public String toString() {
        if(isRevealed() || Game.isCheat()){
            return "\uD83D\uDD25" ;
        }
        else{
            return charNoRevealed;
        }
    }

}
