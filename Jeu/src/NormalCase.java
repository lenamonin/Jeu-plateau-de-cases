public class NormalCase extends Case{

    private boolean victory;

    public boolean isVictory() {
        return victory;
    }

    public void setVictory(boolean victory) {
        this.victory = victory;
    }

    public NormalCase(){
        super();
        this.victory=false;
    }

    @Override
    public boolean haveCollision() {
        return false;
    }

    //Si le joueur arrive sur la case gagnante alors victory passe à true et le joueur gagne !
    @Override
    public void apply(Board board, Player player, int x, int y) {
        if(victory){
            player.setWin(true);
        }
    }

    @Override
    public String toString() {
        if(victory && (revealed || Game.isCheat()) ){
            return "\uD83C\uDF20";
        }
        else if(isRevealed() || Game.isCheat()){
            return "\u2b1c" ;
        }
        else{
            return charNoRevealed;
        }
    }

}
