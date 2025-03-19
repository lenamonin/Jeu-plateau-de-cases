public abstract class Case {
    protected String charNoRevealed="⬛";
    protected boolean revealed; //protected pour que seul les enfants puisse l'utiliser

    public boolean isRevealed() {
        return revealed;
    }

    public void setRevealed(boolean revealed) {
        this.revealed = revealed;
    }

    public Case() {
        this.revealed = false;
    }

    public abstract boolean haveCollision(); //fonction qui permet de savoir si le joueur rentre en collision avec qql chose

    public abstract void apply(Board board, Player player, int x, int y); // Permet de savoir le rôle de chaque case
}