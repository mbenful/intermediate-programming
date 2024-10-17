import java.util.Scanner;

class app {
    public static void main( String[] args) {

        System.out.println("What is your name?");
        Scanner myObj = new Scanner(System.in);
        
        String username = myObj.nextLine();
        nameInput(username);
        


        String flavor = myObj.nextLine();
        flavorInput(flavor);
        

    }
static String nameInput(String username){
    
    System.out.println("Hello, " + username + " What is your favorite ice cream flavor?");
    return username;
    
}
static String flavorInput(String flavor){
    if (flavor.equals("chocolate") ) {
        System.out.println("I hate chocolate ice cream!!!");
    } else {
        System.out.println("I love " + flavor + " too!!!");
    }
    return flavor;
}

}
