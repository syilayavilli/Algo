package Challenge.Pattern;
//https://www.youtube.com/watch?v=lsOOs5J8ycw
//37:30
public class PrintPatterns {

    public static void main(String[] args) {
        //printPattern1(5);
        //printPattern2(4);
        //printPattern3(5);
        //printPattern4(5);
        //printPattern5(5);
        printPattern6(5);
    }


    /*
      pattern2
      1 * * * * *
      2 * * * * *
      3 * * * * *
      4 * * * * *

      number of rows = 5 outer for loop
      All rows has 5 columns with stars
      so number of cols is tied to the row
     */
    public static void printPattern1(int totalRows){
        //If rows start with 1 and not zero
        for (int row=1; row<=totalRows; row++) {

            //print
            for( int col=1; col<=totalRows; col++) {
                //print star
                System.out.print(" * ");
            }

            //After each row print a newline
            System.out.println();

        }

    }

    /*
      pattern2
      1 *
      2 **
      3 ***
      4 ****

      number of rows = 4 outer for loop
      first row 1 col, row2 has 2 cols row 3 three cols and row 4 has 4 cols
      so number of cols is tied to the row
     */
    public static void printPattern2(int totalRows){

        //If rows start with 1 and not zero
        for (int row=1; row<=totalRows; row++) {

            //print the col which is by row number amount
            for( int col=1; col<=row; col++) {
                //print star
                System.out.print(" * ");
            }

            //After each row print a newline
            System.out.println();

        }
    }

    /*
          pattern3
          1 * * * * *
          2 * * * *
          3 * * *
          4 * *
          5 *

          number of rows = 5 outer for loop
          first row 5 col, row2 has 4 cols row 3 three cols and row 4 has 2 cols and 5row 5 has one col
          so number of cols is tied to the row in reverse
         */
    public static void printPattern3(int totalRows){

        //If rows start with 1 and not zero
        for (int row=1; row<=totalRows; row++) {

            //print the col which is by row number amount
            // or we can start from 1 to N-r+1 i.e totalRows - current row + 1 since we start from 1
//            for( int col=totalRows; col>=row; col--) {
//                //print star
//                System.out.print(" * ");
//            }
            for( int col=1; col<= (totalRows - row +1); col++) {
                //print star
                System.out.print(" * ");
            }

            //After each row print a newline
            System.out.println();

        }
    }

    /*
          pattern4
          1 1
          2 1 2
          3 1 2 3
          4 1 2 3 4
          5 1 2 3 4 5

          number of rows = 5 outer for loop
          first row 1 col, row2 has 2 cols row 3 three cols and row 4 has 4 cols and row 5 has 5 col
          Instead of star we could use column number
         */
    public static void printPattern4(int totalRows){

        //If rows start with 1 and not zero
        for (int row=1; row<=totalRows; row++) {

            //print the col which is by row number amount
            for( int col=1; col<=row; col++) {
                //print star
                System.out.print(" " + col + " ");
            }

            //After each row print a newline
            System.out.println();

        }
    }

    /*
         pattern5
         1 *
         2 * *
         3 * * *
         4 * * * *
         5 * * * * *
         6 * * * *
         7 * * *
         8 * *
         9 *

         number of rows = 9 outer for loop

        */
    public static void printPattern5(int totalRows){

        //If rows start with 1 and not zero
        for (int row=1; row<=((2 * totalRows) -1); row++) {

            int maxCol;
//            if (row <= 5) {
//                maxCol = row;
//            } else {
//                maxCol = ((2*totalRows) - row );
//            }
            maxCol = (row <= 5) ? row : ((2*totalRows) - row );

            //print the col which is by row number amount
            for( int col=1; col<=maxCol; col++) {
                //print star
                System.out.print(" * ");
            }

            //After each row print a newline
            System.out.println();

        }
    }

    /*
         pattern6
         1     *
         2    * *
         3   * * *
         4  * * * *
         5 * * * * *
         6  * * * *
         7   * * *
         8    * *
         9     *

         number of rows = 9 outer for loop

        */
    public static void printPattern6(int totalRows){

        //If rows start with 1 and not zero
        for (int row=1; row<=((2 * totalRows) -1); row++) {

            int maxCol;
//            if (row <= 5) {
//                maxCol = row;
//            } else {
//                maxCol = ((2*totalRows) - row );
//            }
            maxCol = (row <= 5) ? row : ((2*totalRows) - row );

            int numOfSpaces = totalRows - maxCol ;

            for( int s=1; s<=numOfSpaces; s++) {
                //print space
                System.out.print("-");
            }
            //print the col which is by row number amount
            for( int col=1; col<=maxCol; col++) {
                //print star
                System.out.print(" * ");
            }

            //After each row print a newline
            System.out.println();

        }
    }




}
