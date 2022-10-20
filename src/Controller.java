public class Controller {
    public Controller(){}

    public void compute(String arg, MineField minefield) throws Exception{
        String[] strArgArray = arg.split(" ");
        switch(strArgArray.length){
            case 0:
                throw new Exception();
            case 1:
                throw new Exception();
            case 2:
            if((int)(strArgArray[0]).charAt(0) <= 57 && (int)(strArgArray[0]).charAt(0) >= 48 && (int)(strArgArray[1]).charAt(0) <= 57 && (int)(strArgArray[1]).charAt(0) >= 48){ // 0 - 9
                System.out.println("uhhh" + strArgArray[0].length());
                System.out.println("seems to be a number");
                minefield.dig(Integer.valueOf(strArgArray[0]), Integer.valueOf(strArgArray[1]));
            }
            else{
                throw new Exception();
            }
            case 3:
                if(strArgArray[0].charAt(0) == 'f' || strArgArray[0].charAt(0) == 'F'){
                    System.out.println("seems you wish to flag something");
                    if((int)(strArgArray[1]).charAt(0) <= 57 && (int)(strArgArray[1]).charAt(0) >= 48 && (int)(strArgArray[2]).charAt(0) <= 57 && (int)(strArgArray[2]).charAt(0) >= 48){ // 0 - 9
                        minefield.flag(Integer.valueOf(strArgArray[1]), Integer.valueOf(strArgArray[2]));
                    }
                }
                
        }      
    }

}
