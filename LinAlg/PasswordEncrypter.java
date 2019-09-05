
import java.util.Scanner;

/**
 * Password Encrypter
 *
 * @author (Johnathon, Joe, Chandler) 
 * @version (12/10/18)
 */
public class PasswordEncrypter
{
    public static int[][] matrix = new int[3][6];

    public static void main(String[] args) 
    {
        boolean flag = true;
        String str = new String();

        do{
            Scanner kb = new Scanner(System.in);
            System.out.println("Enter the password (18 characters max)" 
                + " you wish to encrypt"
                + " or type \"quit\" to quit.");
            str = kb.nextLine();

            if (str.equalsIgnoreCase("quit"))
            {
                flag = false; 
            }
            else
            {
                int[] array = new int[18];
                if (str.length() > 18)
                {
                    System.out.println("The password you have entered" 
                        + " is too long, please try again.");
                    continue;
                }
                for (int i = 0; i < str.length(); i++)
                {           
                    char y = str.charAt(i);
                    int x = (int) y;
                    array[i] = y;
                }
                for (int j = 0; j < array.length; j++)
                {
                    if (array[j] == 0)
                    {
                        array[j] = 0;
                    }
                }
                matrix[0][0] = array[0];
                matrix[0][1] = array[1];
                matrix[0][2] = array[2];
                matrix[0][3] = array[3];
                matrix[0][4] = array[4];
                matrix[0][5] = array[5];
                matrix[1][0] = array[6];
                matrix[1][1] = array[7];
                matrix[1][2] = array[8];
                matrix[1][3] = array[9];
                matrix[1][4] = array[10];
                matrix[1][5] = array[11];
                matrix[2][0] = array[12];
                matrix[2][1] = array[13];
                matrix[2][2] = array[14];
                matrix[2][3] = array[15];
                matrix[2][4] = array[16];
                matrix[2][5] = array[17];                    

                System.out.println("\nThis is your password in" 
                + " matrix formation: ");
                displayProduct(matrix); 

                int r = 3;
                int c = 6;
                int[][] firstMatrix = {{2, 1, 1}, {3, 2, 1}, {2, 1, 2}};
                int[][] secondMatrix = getMatrix();
                int[][] thirdMatrix = {{3, -1, -1}, {-4, 2, 1}, {-1, 0, 1}};  

                int[][] product = multiplyMatrices(firstMatrix, 
                    secondMatrix, r, c);
                int[][] product2 = multiplyMatrices(thirdMatrix, 
                    product, r, c);

                System.out.println("\nThis is your password " 
                    + "in encrypted matrix form: ");
                displayProduct(product);
                System.out.println("\nThis is your password in" 
                    + " its encrypted String form: ");
                displayString(product);

                System.out.println("\nThis is your password in"
                    + " its original matrix form: ");
                displayProduct(product2);
                System.out.println("\nThis is your password in" 
                    + " its original String form: ");
                displayString(product2);
            }
            System.out.println("\n");
        }
        while (flag);
    }

    public static int[][] getMatrix()
    {
        return matrix;
    }

    public static void displayProduct(int[][] product) 
    {
        int yourInt;
        char ch;
        String st;
        for(int[] row : product) 
        {
            for (int column : row) 
            {
                System.out.print(column + "    ");
            }
            System.out.println();
        }
    }

    public static void displayString(int[][] product)
    {
        int yourInt;
        char ch;
        String st = "";
        for(int i = 0; i < product.length; i++) 
        {
            for (int j = 0; j < product[i].length; j++) 
            {                
                yourInt = product[i][j];
                ch = (char) yourInt;
                st += ch;         
            }
        }
        System.out.println(st);
    }

    public static int[][] multiplyMatrices(int[][] firstMatrix, int[][] secondMatrix, int r, int c) 
    {
        int[][] product = new int[r][c];
        for(int i = 0; i < r; i++) 
        {
            for (int j = 0; j < c; j++) 
            {
                for (int k = 0; k < r; k++) 
                {
                    product[i][j] += firstMatrix[i][k] * secondMatrix[k][j];
                }
            }
        }
        return product;
    }
}
