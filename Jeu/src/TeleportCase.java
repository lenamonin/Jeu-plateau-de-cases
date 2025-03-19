public class TeleportCase extends Case{

    private int targetCaseX;
    private int targetCaseY;

    public int getTargetCaseX() {
        return targetCaseX;
    }

    public void setTargetCaseX(int targetCaseX) {
        this.targetCaseX = targetCaseX;
    }

    public int getTargetCaseY() {
        return targetCaseY;
    }

    public void setTargetCaseY(int targetCaseY) {
        this.targetCaseY = targetCaseY;
    }

    public TeleportCase(int targetCaseX, int targetCaseY) {
        super();
        this.targetCaseX = targetCaseX;
        this.targetCaseY = targetCaseY;
    }

    @Override
    public boolean haveCollision() {
        return false;
    }

    //Le joueur est téléporter quand il arrive sur cette case
    @Override
    public void apply(Board board, Player player, int x, int y) {
        player.setY(targetCaseY);
        player.setX(targetCaseX);
    }

    @Override
    public String toString() {
        if(isRevealed() || Game.isCheat()){
            return "\uD83D\uDE80";
        }
        else{
            return charNoRevealed;
        }
    }
}
