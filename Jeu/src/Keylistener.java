public class Keylistener {
    public char listenkeys(){ //recupere les entrees utilisateurs
        while(true){
            char key=Lire.c();
            switch(key){
                case 'z':{return 'z';} //aller en haut
                case 'q':{return 'q';} //aller a gauche
                case 'd':{return 'd';} //aller a droite
                case 's':{return 's';} //aller en bas
                case 'l':{return 'l';} //lancer une pierre
            }
        }
    }
}
