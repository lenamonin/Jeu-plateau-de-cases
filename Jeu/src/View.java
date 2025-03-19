import java.util.ArrayList;

public class View {
    private ArrayList<String> memoryMessage;

    public View() {
        this.memoryMessage = new ArrayList<>();
    }

    public void showBoard(Board board, Player player){
        clear();
        for(int rowY=0; rowY<board.getSizeY(); rowY++){
            for(int colX=0; colX< board.getSizeX(); colX++){
                if(rowY== player.getY() && colX== player.getX()){
                    System.out.print(player.toString()); //affichage du joueur
                }
                else {
                    System.out.print(board.getCase(rowY, colX)); //affichage de la case
                }
            }
            System.out.println();
        }
        lateMessage();
    }

    public void clear(){
        System.out.print("\033\143"); // permet d'effacer tout le contenu de la console
    }

    public void showMessage(String message){
        System.out.println();
        System.out.println(message);
    }

    public void showState(String message){
        clear();
        System.out.println(message);
    }

    private void lateMessage(){
        for(int i=0; i< memoryMessage.size();i++){
            System.out.println(memoryMessage.get(i));
        }
    }

    public void stockMessage(String message){
        memoryMessage.add(message);
    }
}
