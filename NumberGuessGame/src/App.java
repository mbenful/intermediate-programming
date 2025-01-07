public class App {
    public static void main(String[] args) {
for(int i=1; i<4 ;i++){
    int highscore = Integer.MAX_VALUE;
    Game whatever = new Game(); 
        whatever.playGame();
        if (whatever.getScore() < highscore){
            highscore = whatever.getScore();
            System.out.println("new highscore is " +highscore);
        }
        whatever.getScore();
        System.out.println("final highscore is " + highscore);
}

    }   
}