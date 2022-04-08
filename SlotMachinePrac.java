//package application;
//
//import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.stage.Stage;
//
//public class TipCalculator extends Application{
//    @Override
//    //start method to load fxml file.
//
//    public void start(Stage stage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("TipCalculator.fxml"));
//
//        Scene scene = new Scene(root);
//        stage.setTitle("TipCalculator");
//        stage.setScene(scene);
//        stage.show();
//    }
import java.util.Scanner;

public class SlotMachinePrac {
    // main method, executes program
    public static void main(String[] args) {
        String spinAgain = "yes";
        int currency = 100;
        while (spinAgain.equals("yes")) {
            System.out.print("Currency = " + currency);
            Scanner input = new Scanner(System.in);
            System.out.print(
                    "\nHow much do you want to bet? ");
            int bet = input.nextInt();
            currency = currency - bet;
            String[] symbols = {"Bar", "Orange", "Strawberry", "7", "Bell", "Cherry"};
            String random1 = symbols[(int) (6 * Math.random())];
            String random2 = symbols[(int) (6 * Math.random())];
            String random3 = symbols[(int) (6 * Math.random())];
            System.out.print(random1 + "  " + random2 + "  " + random3);
            if (random1.equals(random2) && random2.equals(random3)) {
                System.out.print("\nTriple!");
                currency = currency + (bet * 3);
            } else if (random1.equals(random2) || random1.equals(random3) || random2.equals(random3)) {
                System.out.print("\nDouble!");
                currency = currency + (bet * 2);
            } else {
                System.out.print("\nBetter Luck Next Time!");
            }
            input.nextLine();
            System.out.print(
                    "\nDo you want to play again? (yes/no) ");
            spinAgain = input.nextLine();
        }
        System.out.print(
                "\nEnded with: " + currency);
    }
}
