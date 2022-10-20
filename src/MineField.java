public class MineField {
    private char[][][] field; 
    //      field[x][y][z]  ==  ({0,8}==#_of_adj_mines), (F==flagged), (o==dirt), (X==mine! KABOOM)
    //  ==  field[width][height][depth]  ==  field[xCord][yCord][ (0==top_layer(dirt)), (1==bellow_ground) ]
    private int width;
    private int height;
    private final int bombs = 15;
    private char dirt = '.';


    public MineField(){
        this.width = 10;
        this.height = 10;
        this.field = new char[10][10][2];
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
        for(int y = this.height-1; y>= 0; y--){
            System.out.print(y + "  |");
            for(int x = 0; x <= this.width-1; x++){
                if(field[x][y][0] != '0'){ // this if statement makes it so any squares with a zero show up as invisible
                    System.out.print(field[x][y][0]);
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

    public void dig(int xCord, int yCord){
        if(field[xCord][yCord][0] != 'F'){
            field[xCord][yCord][0] = field[xCord][yCord][1];
        }
        else{
            System.out.println("this spot is flagged and cannot be dug");
        }
    }
    
    public void flag(int xCord, int yCord){
        if (field[xCord][yCord][0] == 'F'){
            field[xCord][yCord][0] = dirt;
        }
        else{
            field[xCord][yCord][0] = 'F';
        }
    }

    public void notARealMethod(){ // make the problems go away
        System.out.println(bombs);
    }
}
