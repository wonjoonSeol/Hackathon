import java.util.Random;

public class Dice {

    public int rollDice(int nSides){ 
    	int roll = 0;
        Random  r = new Random(); 
        
        roll = r.nextInt(nSides)+1;
        System.out.println("Roll is:  "+roll);
      	return roll;
    } 
}
/*
Roll is:  4
Roll is:  1
Roll is:  2
Total is: 7
*/
