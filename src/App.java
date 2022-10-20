import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        String playerInput;
        MineField minefield = new MineField();
        Controller controller = new Controller();
        boolean playing = true;

        System.out.println("Hello and welcome to MineSweeper!");
        System.out.println("Simply type in a x and y cordinates seperated by a space, \r\nand that square will be dug up. ex: 4 2");
        System.out.println("To flag a square, type f then x and y cordinates ex: f 6 9");
        System.out.println("help, start, settings, credits");
        playerInput = input.nextLine();
        if (playerInput.equals("start")){
            minefield.noBombsMethod();
            minefield.coverWithDirt();
            minefield.displayMineField();
            while(playing) {
                try{   
                    while(true){
                        minefield.displayMineField();
                        playerInput = input.nextLine();
                        controller.compute(playerInput, minefield);
                    }
                }
                catch(Exception e){
                    System.out.println("Something went wrong");
                }
            }
        }
        else{
            System.out.println("looks like i havent encorperated this part yet O.O");
        }


        input.close();
    }
}
