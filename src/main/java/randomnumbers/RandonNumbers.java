package randomnumbers;

import java.util.Random;

import static java.lang.System.out;

/**
 * Created by mayan on 3/7/18.
 */
public class RandonNumbers {
    private int getRandomNumber(int max,int min){
        Random random = new Random();
        return random.nextInt(max + 1-min) + min;

    }
    public static void main(String[] args){
        RandonNumbers randonNumbers = new RandonNumbers();
        for(int i = 0 ; i < 10;i ++){
            out.println(randonNumbers.getRandomNumber(100,50));
        }


    }
}
