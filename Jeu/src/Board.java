import java.util.Random;

public class Board {

    private int sizeX;
    private int sizeY;
    private Case[][] map;

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public Case[][] getMap() {
        return map;
    }

    /**
     *
     * @param y (colonne)
     * @param x (ligne)
     * @return les coordonnées d'une case du plateau
     */
    public Case getCase(int y, int x){
        return map[y][x];
    }

    public void setCase(int y, int x, Case cellule) {
        map[y][x]=cellule;
    }
    public Board(int sizeX, int sizeY, Player player ) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.map =new Case[sizeY][sizeX];
        mapGenerateur(player);
    }

    /**
     * Cette fonction permet de générer aléatoirement un plateau de jeu.
     * Génère un nombre entre 0 et 101 (exclus).
     * Utilisation d'un système de pourcentage pour savoir à quoi correspond les cases du plateau:
     * 60% Normalcase; 10% Obstacle; 10% Bomb; 15% StoneHeap; 5% TeleportCase.
     * @param player
     */
    public void mapGenerateur(Player player){
        Random random=new Random();
        for(int rowIndex=0; rowIndex< sizeY; rowIndex++){
            for(int colIndex=0; colIndex< sizeX; colIndex++){
                int randomNumber= random.nextInt(0, 101);
                if(player.getX()==colIndex && player.getY()==rowIndex){
                    map[rowIndex][colIndex]=new NormalCase();
                    map[rowIndex][colIndex].setRevealed(true);
                }
                else if(randomNumber<=60){
                    map[rowIndex][colIndex]=new NormalCase();
                }
                else if(randomNumber>60 && randomNumber<=70){
                    map[rowIndex][colIndex]=new Obstacle();
                }
                else if(randomNumber>70 && randomNumber<=80){
                    map[rowIndex][colIndex]=new Bomb();
                }
                else if(randomNumber>80 && randomNumber<=95){
                    map[rowIndex][colIndex]=new StoneHeap(5);
                }
                else if(randomNumber>95 && randomNumber<=100){
                    int[] coordinate = findNormalCase();
                    map[rowIndex][colIndex]=new TeleportCase(coordinate[0], coordinate[1]);
                }
            }
        }
        createVictoryCase();
    }

    /**
     * Fonction qui permet d'attribuer la sortie à une case dans le plateau
     * (cette case est forcémenent située sur la dernière colonne)
     */
    private void createVictoryCase() {
        int[] coordinate=findNormalCase(sizeX-1);
        NormalCase celluleGagnante = (NormalCase) map[coordinate[0]][coordinate[1]];
        celluleGagnante.setVictory(true);

    }

    /**
     *
     * @param X colonne où l'on chercher une case normal
     * @return
     */
    public int[] findNormalCase(int X){
        Random random = new Random();
        while (true) {
            int randomY = random.nextInt(0, sizeY);
            if (map[randomY][X] instanceof NormalCase) {
                NormalCase cellule = (NormalCase) map[randomY][X];
                return new int[]{randomY, X};
            }
        }
    }

    /**
     * Fonction permettant de trouver une case normal dans le plateau
     * @return
     */
    public int[] findNormalCase(){
        Random random = new Random();
        while (true) {
            int randomY = random.nextInt(0, sizeY);
            int randomX = random.nextInt(0, sizeX);
            if (map[randomY][randomX] instanceof NormalCase) {
                NormalCase cellule = (NormalCase) map[randomY][randomX];
                return new int[]{randomY, randomX};
            }
        }
    }




}
