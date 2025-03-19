public class Action {
    private Board map;
    private View view;
    private Verification verification;

    public Action(Board map, View view) {
        this.map = map;
        this.view = view;
        verification= new Verification(view);
    }

    public void Move (char key, Player player){
        switch(key){
            case 'l'->{
                if(player.getStones()>0){
                    player.setStones(player.getStones() - 1); //le joueur perd une pierre
                    Keylistener keylistener=new Keylistener(); // le joueur doit appuier sur une touche(z,q,s,d) pour lancer la pierre
                    verification.stoneLaunch(keylistener.listenkeys(),player, map);// on applique la methode stoneLaunch
                }
            }
            case 'z'->
            {
                int newY=player.getY()-1;
                if(CanMove(player.getX(),newY))
                    player.setY(newY);
            }
            case 'q'->
            {
                int newX=player.getX()-1;
                if(CanMove(newX,player.getY()))
                    player.setX(newX);
            }
            case 'd'->
            {
                int newX=player.getX()+1;
                if(CanMove(newX,player.getY()))
                    player.setX(newX);
            }
            case 's'->{
                int newY=player.getY()+1;
                if(CanMove(player.getX(),newY))
                    player.setY(newY);
            }
        }
    }

    /*
    return true si les coordonnées de x et y sont dans le plateau et s'il n'y a pas de collision
    return false sinon
     */
    public boolean CanMove(int newX, int newY){
        boolean rowSizeX=newX>=0 && newX < map.getSizeX();
        boolean colSizeY=newY>=0 && newY < map.getSizeY();
        if (rowSizeX&&colSizeY)
        {
            map.getCase(newY,newX).setRevealed(true);
            return !map.getCase(newY, newX).haveCollision();
        }
        return false;
    }
}

