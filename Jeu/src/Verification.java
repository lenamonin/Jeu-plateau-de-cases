public class Verification {

    private View view;

    public Verification(View view) {
        this.view = view;
    }

    public static void checkcase(Board map, Player player){
        if(map.getCase(player.getY(), player.getX()) instanceof Bomb bomb){
            bomb.apply(map,player,player.getY(), player.getX());
        }
        if(map.getCase(player.getY(), player.getX()) instanceof StoneHeap stone){
            stone.apply(map,player,player.getY(), player.getX());
            map.setCase(player.getY(), player.getX(), new NormalCase());
            map.getCase(player.getY(), player.getX()).setRevealed(true);
        }
        if(map.getCase(player.getY(), player.getX()) instanceof TeleportCase teleportation){
            teleportation.apply(map,player,player.getY(), player.getX());
        }
        if(map.getCase(player.getY(), player.getX()) instanceof NormalCase normalcase){
            normalcase.apply(map,player,player.getY(), player.getX());
        }
    }


    public void stoneLaunch(char key, Player player, Board map){
        int newX=player.getX();
        int newY=player.getY();
        boolean travelStone = true; // = true si la pierre passe sur une case vide ou un passage pour qu'elle continue a avancer
        while(travelStone){
            travelStone=false; // on ne sait pas encore quel est le type de case donc travelStone = false
            switch(key){
                case'z'->{
                    newY = newY-1;
                }
                case 'q'->{
                    newX=newX-1;
                }
                case 'd'->{
                    newX=newX+1;
                }
                case 's'->{
                    newY=newY+1;
                }
                case 'l'->{
                    player.setStones(player.getStones() + 1); //si le joueur appui sur l par inadvertance on lui rend sa pierre
                    return;
                }
            }
            if (newY<0||newX<0||newX>=map.getSizeX()||newY>=map.getSizeY()) {
                view.stockMessage("La pierre a atteint le bord");
                return; //si la pierre touche le bord elle est perdue
            }
            else if (map.getCase(newY, newX) instanceof StoneHeap stone) {
                stone.setStoneCount(stone.getStoneCount() + 1);
                view.stockMessage("La pierre a atteri vers ses amis les cailloux");
            }
            else if(map.getCase(newY,newX) instanceof TeleportCase teleportation){
                travelStone=true;
                newX=teleportation.getTargetCaseX();
                newY=teleportation.getTargetCaseY();
                //la pierre est teleporte
            }
            else if(map.getCase(newY,newX)instanceof Bomb){
                map.setCase(newY,player.getX(), new NormalCase());
                map.getCase(newY,player.getX()).setRevealed(true);
            }
            else if(map.getCase(newY, newX)instanceof Obstacle){
                view.stockMessage("La pierre a rencontré un obstacle");
            }
            else if(map.getCase(newY, newX)instanceof NormalCase){
                travelStone=true;
            }
        }
    }
}
/** si le joueur appuis sur l verifie si il a des pierre, si il en a il décide où lancer la pierre
 * si ça attéri sur une case vide la pierre continue ok
 * si c'est une case bombe, la bombe explose, et la pierre est perdu, la case est révélée et devient normalcase ok
 * si c'est une case téléportation, la pierre se téléporte ok
 * si c'est une case obstacle, la pierre est perdu, le joueur sait qu'il y a un obstacle mais pas où il se situe
 * si c'est une case qui stock des pierres, la pierre lancer s'ajoute au stock, le joueur sait
 * si c'est un bord, la pierre est perdu et le joueur sait
 */
