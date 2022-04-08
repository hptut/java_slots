package application;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Objects;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;

public class SlotMachineController {
    private static final NumberFormat currency = NumberFormat.getCurrencyInstance();

    private BigDecimal betText = new BigDecimal(50);

    @FXML
    private Label betLabel;

    @FXML
    private TextField currencyTextField;

    @FXML
    private ImageView firstSlotImageView;

    @FXML
    private TextField resultTextField;

    @FXML
    private Slider betSlider;

    @FXML
    private ImageView secondSlotImageView;

    @FXML
    private ImageView thirdSlotImageView;

    @FXML
    public void spinButtonPressed(ActionEvent event) {
        try {
            BigDecimal amount = new BigDecimal(currencyTextField.getText());
        String[] symbols = {"Bar", "Orange", "Strawberry", "7", "Bell", "Cherry"};
        String random1 = symbols[(int) (6 * Math.random())];
        String random2 = symbols[(int) (6 * Math.random())];
        String random3 = symbols[(int) (6 * Math.random())];
        BigDecimal bet = new BigDecimal(String.valueOf(betText));
        amount = amount.subtract(bet);
        currencyTextField.setText(String.valueOf(amount));

            if (random1.equals(random2) && random2.equals(random3)) {
                resultTextField.setText("Triple");
                bet = bet.multiply(BigDecimal.valueOf(4));
                amount = amount.add(bet);
                currencyTextField.setText(String.valueOf(amount));
            } else if (random1.equals(random2) || random1.equals(random3) || random2.equals(random3)) {
                resultTextField.setText("Double");
                bet = bet.multiply(BigDecimal.valueOf(3));
                amount = amount.add(bet);
                currencyTextField.setText(String.valueOf(amount));
            } else {
                resultTextField.setText("Better Luck Next Time!");

            }
        }
        catch(NumberFormatException ex){
            System.out.print("NumberFormatException");
        }

//        String[] imageArray = {"Cherries.jpg","7.jpg","Bells.jpg"};

//        Image myRandImage1 = new Image(Objects.requireNonNull(getClass().getResourceAsStream(imageArray[(int) (3 * Math.random())])));
//        Image myRandImage2 = new Image(Objects.requireNonNull(getClass().getResourceAsStream(imageArray[(int) (3 * Math.random())])));
//        Image myRandImage3 = new Image(Objects.requireNonNull(getClass().getResourceAsStream(imageArray[(int) (3 * Math.random())])));
//
//        firstSlotImageView.setImage(myRandImage1);
//        secondSlotImageView.setImage(myRandImage2);
//        thirdSlotImageView.setImage(myRandImage3);




    }
    public void initialize() {
        currency.setRoundingMode(RoundingMode.HALF_UP);

        betSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number oldValue, Number newValue) {
                betText = BigDecimal.valueOf(newValue.intValue());
                betLabel.setText(String.valueOf(betText));
            }
        }
        );
    }

}
