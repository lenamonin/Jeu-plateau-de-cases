public class Game {
    public static void main(String[] args) {
        View view = new View();
        view.clear();
        view.showMessage("Bonjour !! \n Vous voici arrivez sur notre nouveau jeu :) \n " +
                "Le but du jeu est simple, il vous suffit de parcourir les cases du plateau de jeu afin de trouver la sortie. " +
                "Malheureusement ce ne sera pas si simple. \n Vous avancerez à l'aveugle dans un terrain rempli de bombes et d'obstacles. " +
                "Mais vous aurez dans votre sac des pierres à lancer pour vous guider.\n " +
                "Selectionner : \n q pour aller à gauche \n d pour aller à droite \n s pour aller en bas \n z pour aller en haut \n " +
                "l pour lancer une pierre \n Et rappuyez sur l si vous avez changé de décision");
        view.showMessage("Choisir le nombre de ligne du plateau : ");
        int nbrligne=Math.max(Math.min(Lire.i(), 50), 5);
        view.showMessage("Choisir le nombre de colonne du plateau : ");
        int nbrColonne=Math.max(Math.min(Lire.i(), 50), 5);
        view.showMessage("Choisir le nombre de pierre");
        int nbrPierre=Math.max(Math.min(Lire.i(), 10), 0);
        view.clear();
        Player player=new Player(0,0, nbrPierre);
        Board board= new Board(nbrColonne,nbrligne,player);
        Keylistener keylistener=new Keylistener();
        Action action=new Action(board,view);
        while (!(player.isLost()|| player.isWin())){
            view.showBoard(board, player);
            view.showMessage("X : "+player.getX()+" Y : "+player.getY()+"\nNombre de pierres restante : "+player.getStones());
            action.Move(keylistener.listenkeys(), player);
            Verification.checkcase(board, player);
        }
        if(player.isWin()){
            view.showState("\n" +
                    "\n" +
                    "████████╗██╗   ██╗     █████╗ ███████╗     ██████╗  █████╗  ██████╗ ███╗   ██╗███████╗    ██╗██╗\n" +
                    "╚══██╔══╝██║   ██║    ██╔══██╗██╔════╝    ██╔════╝ ██╔══██╗██╔════╝ ████╗  ██║██╔════╝    ██║██║\n" +
                    "   ██║   ██║   ██║    ███████║███████╗    ██║  ███╗███████║██║  ███╗██╔██╗ ██║█████╗      ██║██║\n" +
                    "   ██║   ██║   ██║    ██╔══██║╚════██║    ██║   ██║██╔══██║██║   ██║██║╚██╗██║██╔══╝      ╚═╝╚═╝\n" +
                    "   ██║   ╚██████╔╝    ██║  ██║███████║    ╚██████╔╝██║  ██║╚██████╔╝██║ ╚████║███████╗    ██╗██╗\n" +
                    "   ╚═╝    ╚═════╝     ╚═╝  ╚═╝╚══════╝     ╚═════╝ ╚═╝  ╚═╝ ╚═════╝ ╚═╝  ╚═══╝╚══════╝    ╚═╝╚═╝\n" +
                    "                                                                                                \n" +
                    "\n");
        }
        else {
            view.showState("\n" +
                    "\n" +
                    "████████╗██╗   ██╗     █████╗ ███████╗    ██████╗ ███████╗██████╗ ██████╗ ██╗   ██╗    ██╗██╗\n" +
                    "╚══██╔══╝██║   ██║    ██╔══██╗██╔════╝    ██╔══██╗██╔════╝██╔══██╗██╔══██╗██║   ██║    ██║██║\n" +
                    "   ██║   ██║   ██║    ███████║███████╗    ██████╔╝█████╗  ██████╔╝██║  ██║██║   ██║    ██║██║\n" +
                    "   ██║   ██║   ██║    ██╔══██║╚════██║    ██╔═══╝ ██╔══╝  ██╔══██╗██║  ██║██║   ██║    ╚═╝╚═╝\n" +
                    "   ██║   ╚██████╔╝    ██║  ██║███████║    ██║     ███████╗██║  ██║██████╔╝╚██████╔╝    ██╗██╗\n" +
                    "   ╚═╝    ╚═════╝     ╚═╝  ╚═╝╚══════╝    ╚═╝     ╚══════╝╚═╝  ╚═╝╚═════╝  ╚═════╝     ╚═╝╚═╝\n" +
                    "                                                                                             \n" +
                    "\n");
        }
    }
    public static boolean isCheat(){
        return true;
    }
}