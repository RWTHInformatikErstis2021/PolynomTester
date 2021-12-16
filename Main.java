import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        while(true) {
            System.out.println("Please enter your polynom: ");
            Scanner scanner = new Scanner(System.in);
            String enter = scanner.nextLine();
            System.out.println("Please describe n in Z_n[X]: n = ");
            String r = scanner.nextLine();
            int raum = 0;
            try {
                raum = Integer.parseInt(r);
                Polynom pol = readEntry(enter, raum);
                System.out.println("\nThe entered Polynom: " + pol.toString() + " in Z_" + raum);
                System.out.println("Is Reduceable? : " + pol.isReduceable());
            }
            catch (NumberFormatException e){
                System.out.println("Could not format " + r);
            }
            String proceed = "";
            while(!proceed.equals("Again") && !proceed.equals("Exit")) {
                System.out.println("How do you wish to proceed? Again | Exit");
                proceed = scanner.nextLine();
            }
            if (proceed.equals("Exit")) {
                scanner.close();
                System.exit(0);
            }
        }
        

        
    }

    public static Polynom readEntry(String entered, int raum) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        String toParse = ""; 
        for (int i = 0; i < entered.length(); i++) {
            if (entered.charAt(i) != ' ') {
                toParse += entered.charAt(i);
            }
            else {
                try {
                    int num = Integer.parseInt(toParse);
                    list.add(num);
                    toParse = "";
                }
                catch(NumberFormatException e) {
                    System.out.println("Could not format " + toParse + "!");
                }
            }
        }
        try {
            int num = Integer.parseInt(toParse);
            list.add(num);
            toParse = "";
        }
        catch(NumberFormatException e) {
            System.out.println("Could not format " + toParse + "!");
        }
        
        int[] polynom = new int[list.size()];
        for (int i = 0; i < polynom.length; i++) {
            polynom[i] = list.get(polynom.length - i - 1);
        }
        return new Polynom(polynom, raum);
    }
}
