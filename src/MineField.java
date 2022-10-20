import java.lang.Math;

public class MineField {
    private char[][][] field; 
    //      field[x][y][z]  ==  ({0,8}==#_of_adj_mines), (F==flagged), (o==dirt), (X==mine! KABOOM)
    //  ==  field[width][height][depth]  ==  field[xCord][yCord][ (0==top_layer(dirt)), (1==bellow_ground) ]
    private int width;
    private int height;
    int min = 0;//hard coded, bad
    int max = 9;//
    private final int bombs = 6;
    private char dirt = '.';
    private boolean[][] checked;
    



    public MineField(){
        this.width = 10;
        this.height = 10;
        this.field = new char[10][10][2];
        checked = new boolean[10][10]; // hard coded, bad.
        for(int i=0; i<10;i++){
            for(int j=0; j<10; j++){
                checked[i][j] = false;
            }
        }
    }

    public MineField(int w, int h){
        this.width = w;
        this.height = h;
        this.field = new char[w][h][2];
        
    }

    public int getWidth(){
        return this.width;
    }

    public int getHeight(){
        return this.height;
    }

    public void coverWithDirt(){
        /* the top layer, aka z=0, aaka ground level
         * will be covered in dirt. which is represented as '.'
         */

        for(int x = 0; x < this.width; x++){
            for(int y = 0; y < this.height; y++){
                field[x][y][0] = dirt;
            }
        }
    }

    public void noBombsMethod(){
        /* the bottom layer, aka z=1, aaka where the bombs and numbers rest
         * will be filled with nothing, no bombs. 
         * each spot will be fill with a '0',
         * indicating that there are zero bombs adjacent to this cell
         */

        for(int x = 0; x < this.width; x++){
            for(int y = 0; y < this.height; y++){
                field[x][y][1] = '0';
            }
        }
    }

    public void displayMineField(){
        displayMineField(0);
    }

    public void displayMineField(int z){ //default 0
        for(int y = this.height-1; y>= 0; y--){
            System.out.print(y + "  |");
            for(int x = 0; x <= this.width-1; x++){
                if(field[x][y][z] != '0'){ // this if statement makes it so any squares with a zero show up as invisible
                    System.out.print(field[x][y][z]);
                }
                else{
                    System.out.print(" ");
                }
                System.out.print(" ");
            }
            System.out.println();

        }
        System.out.print("    -");
        for(int x=0; x < this.width; x++){
            System.out.print("--");
        }
        System.out.println();

        System.out.print("    ");
        for(int x=0; x < this.width; x++){
            System.out.print("^ ");
        }
        System.out.println();

        System.out.print("    ");
        for(int x=0; x < this.width; x++){
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.println();
    }

    public void dig(int x, int y){
        checked[x][y] = true;


        
        if(field[x][y][0] != 'x'){
            field[x][y][0] = field[x][y][1];
            if (field[x][y][1] == '0'){
                for(int yTan = -1; yTan <= 1; yTan++){
                    for(int xTan = -1; xTan <= 1; xTan++){
                        if(x+xTan >=0 && x+xTan <= 9 && y+yTan >= 0 && y+yTan <= 9){
                            if(field[x+xTan][y+yTan][1] == '0' && !checked[x+xTan][y+yTan]){
                                displayMineField();
                                dig(x+xTan, y+yTan);
                            }
                            else{
                                field[x+xTan][y+yTan][0] = field[x+xTan][y+yTan][1];
                            }
                        }
                    }
                }
            }
        }
        else{
            System.out.println("this spot is flagged and cannot be dug");
        }
    }
    
    public void flag(int xCord, int yCord){
        if (field[xCord][yCord][0] == 'x'){
            field[xCord][yCord][0] = dirt;
        }
        else{
            field[xCord][yCord][0] = 'x';
        }
    }

    public void notARealMethod(){ // make the problems go away
        System.out.println(bombs);
    }

    public void placeRandomMines(){
        for(int b = bombs; b > 0; b--){
            int x;
            int y;
            while (true) {
                x = rand();
                y = rand();
                if (field[x][y][1] != 'X'){
                    field[x][y][1] = 'X';
                    break;
                }
            }
        }

        
    }

    public void countMines(){
        for(int y = this.height-1; y >= 0; y--){
            for(int x = 0; x < this.width; x++){
                //goes through all squares on the field

                    if(field[x][y][1] != 'X'){
                        int numOfAdjBombs = 48; //char index is 0
                        for(int yTan = -1; yTan <= 1; yTan++){
                            for(int xTan = -1; xTan <= 1; xTan++){
                                if(x+xTan >=0 && x+xTan <= 9 && y+yTan >= 0 && y+yTan <= 9){
                                    if(field[x+xTan][y+yTan][1] == 'X'){
                                        numOfAdjBombs++;
                                    }
                                }
                            }
                        }

                        field[x][y][1] = (char)numOfAdjBombs;
                        System.out.println("5");
                    }

            }
        }
    }

    public int rand(){
        return (int)(Math.random()*(max+1));
    }













}
