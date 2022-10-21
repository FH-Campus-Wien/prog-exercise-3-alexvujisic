package at.ac.fhcampuswien;

import java.util.Random;
import java.util.Scanner;

public class App {
    public static void oneMonthCalendar(int days, int weekday) {
        int zaehler = 1;
        int abstand = weekday - 1;
        int tag = weekday;
        for (int i = 0; i < abstand; i++) {
            System.out.printf("   ");
        }
        for (int i = 0; zaehler != (days + 1); i++) {
            for (; zaehler < 8 && tag < 8; tag++) {
                System.out.printf("%2d ", zaehler);
                zaehler++;
            }
            //  System.out.print(" ");
            for (; tag < 7; tag++) {
                System.out.printf("%2d ", zaehler);
                zaehler++;
                if (zaehler == (days + 1)) {
                    break;
                }
            }
            System.out.print("\n");
            tag = 0;
        }
    }

    public static long[] lcg(long seed) {
        long[] randNumbArray = new long[10];
        final double m = Math.pow(2, 31);
        final long a = 1103515245;
        final long c = 12345;
        //seed = 12345;
        //randNumbArray[0] = seed;
        //System.out.println("Zahl 1:  " + randNumbArray[0]);
        for (int i = 0; i < 10; i++) {
            randNumbArray[i] = ((a * seed) + c) % (long) m;
            seed = randNumbArray[i];
            System.out.println("Zahl " + i + "= " + randNumbArray[i]);
        }
        return randNumbArray;
    }

    public static void guessingGame(int numberToGuess) {
        Scanner scan = new Scanner(System.in);
        int versuch = 0;
        boolean flag = false;
        for (int i = 0; i < 10; i++) {
            System.out.print("Guess number " + (i + 1) + ": ");
            versuch = scan.nextInt();
            if ((i < 9) && (versuch > numberToGuess)) {
                System.out.println("The number AI picked is lower than your guess.");
            } else if ((i < 9) && (versuch < numberToGuess)) {
                System.out.println("The number AI picked is higher than your guess.");
            } else if (versuch == numberToGuess) {
                System.out.println("You won wisenheimer!");
                flag = true;
                break;
            }
            //  System.out.print("\n");
        }
        if (flag == false) {
            System.out.println("You lost! Have you ever heard of divide & conquer?");
        }
    }

    public static int randomNumberBetweenOneAndHundred() {
        Random random = new Random();
        return random.nextInt(99) + 1;
    }

    public static boolean swapArrays(int arrayA[], int arrayB[]) {
        if (arrayA.length == arrayB.length) {
            int[] arrayTemp = new int[arrayA.length];
            for (int i = 0; i < arrayA.length; i++) {
                arrayTemp[i] = arrayA[i];
            }
            for (int i = 0; i < arrayA.length; i++) {
                arrayA[i] = arrayB[i];
            }
            for (int i = 0; i < arrayA.length; i++) {
                arrayB[i] = arrayTemp[i];
            }
            return true;
        }
        return false;
    }

    public static String camelCase(String eingabe) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] fertigesCharArray = eingabe.toCharArray();
        boolean erstesZeichenImWort = false;
        if(fertigesCharArray[0] >= 97 && fertigesCharArray[0] <= 122){
            fertigesCharArray[0] -= 32;

        }
        stringBuilder.append(fertigesCharArray[0]);
        for(int i = 1; i < fertigesCharArray.length; i++){
            if(fertigesCharArray[i] >= 65 && fertigesCharArray[i] <= 90){ // grossbuchstabe
                if(erstesZeichenImWort == false){ // nur kleinmachen wenn es nicht der erste buchstabe is
                    fertigesCharArray[i] += 32;
                }
                erstesZeichenImWort = false;
                stringBuilder.append(fertigesCharArray[i]);
            }
            else if(fertigesCharArray[i] >= 97 && fertigesCharArray[i] <= 122){ //kleinbichstabe
                if(erstesZeichenImWort == true){ //gross wenn erster buchstabe im wort
                    fertigesCharArray[i] -= 32;
                }
                stringBuilder.append(fertigesCharArray[i]);
                erstesZeichenImWort = false;
            }
            else if(fertigesCharArray[i] == 32){
                erstesZeichenImWort = true;
            }
            else if((fertigesCharArray[i] >= 33 && fertigesCharArray[i] <= 47) || (fertigesCharArray[i] >= 58 && fertigesCharArray[i] <= 64 )){
                fertigesCharArray[i] = 32;
                //stringBuilder.append(fertigesCharArray[i]);
            }
        }
        return stringBuilder.toString(); //stringBuilder als String uebergeben
    }
    public static int checkDigit(int[] code){
        int[] gewichtung  = new int[code.length];
        int[] product = new int[code.length];
        int sum = 0;
        for (int i = 0; i < code.length; i++) {
            gewichtung[i] = i + 2;
        }
        for (int i = 0; i < code.length; i++) {
            product[i] = gewichtung[i] * code[i];
            sum += product[i];
        }
        if (11 - (sum%11) == 10){
            return 0;
        }
        else if (11 - (sum%11) == 11){
            return 5;
        }
        return (11 - (sum%11));
    }

    // Implement all methods as public static

    public static void main(String[] args) {



     //   App.oneMonthCalendar(30, 2);
       // App.lcg(12345);
      //  App.guessingGame(App.randomNumberBetweenOneAndHundred());
           // App.swapArrays(array1, array2);


      //  System.out.println(App.camelCase("My Name Isn't Alice"));
        System.out.println(App.checkDigit(new int[]{1, 3, 2, 4}));

                // Beispiel        String[] names = new Strinq[3];
        // test your method implementations here
        // make method calls
        // print their results
        // etc.
    }
}
