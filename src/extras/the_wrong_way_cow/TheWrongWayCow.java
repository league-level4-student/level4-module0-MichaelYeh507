//https://www.codewars.com/kata/the-wrong-way-cow
//
//Task
//Given a field of cows find which one is the Wrong-Way Cow and return her position.
//
//Notes:
//
//There are always at least 3 cows in a herd
//There is only 1 Wrong-Way Cow!
//Fields are rectangular
//The cow position is zero-based [x,y] of her head (i.e. the letter c)
//Examples
//Ex1
//
//cow.cow.cow.cow.cow
//cow.cow.cow.cow.cow
//cow.woc.cow.cow.cow
//cow.cow.cow.cow.cow
//Answer: [6,2]
//
//Ex2
//
//c..........
//o...c......
//w...o.c....
//....w.o....
//......w.cow
//Answer: [8,4]
//
//Notes
//The test cases will NOT test any situations where there are "imaginary" cows, so your solution does not need to worry about such things!
//
//To explain - Yes, I recognize that there are certain configurations where an "imaginary" cow may appear that in fact is just made of three other "real" cows.
//In the following field you can see there are 4 real cows (3 are facing south and 1 is facing north). There are also 2 imaginary cows (facing east and west).
//
//...w...
//..cow..
//.woco..
//.ow.c..
//.c.....

package extras.the_wrong_way_cow;

import java.util.HashMap;

public class TheWrongWayCow {

    public static int[] findWrongWayCow(final char[][] field) {
        // Fill in the code to return the x,y coordinate position of the
        // head (letter 'c') of the wrong way cow!
    	int north = 0;
    	int south = 0;
    	int west = 0;
    	int east = 0;
    	HashMap<String, int[]> cows = new HashMap<String, int[]>();
        
    	
    	for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field.length; j++) {
				if (i+1 < field.length && field[i+1][j]=='o') {
					if(field[i+2][j]=='w') {
						north ++;
						System.out.println("Confirmed north cow " + north);
						int[] northCow = {j, i};
						cows.put("north cow", northCow);
						if(south>1 || west > 1 || east > 1 && north == 1) {
							return northCow;
						} else if(north > 1 && west == 1) {
							return cows.get("west cow");
						}
					}
				}
			}
		}
    	
        return null;
    }
}
