package MyApp.Controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Popup;


public class TicTacToeController {

    boolean turn;
    private int count = 0;
    private int player1 = 0;
    private int player2 = 0;





    public boolean win;

    @FXML
    Button btn1;
    @FXML
    Button btn2;
    @FXML
    Button btn3;
    @FXML
    Button btn4;
    @FXML
    Button btn5;
    @FXML
    Button btn6;
    @FXML
    Button btn7;
    @FXML
    Button btn8;
    @FXML
    Button btn9;
    @FXML
    Button resetBtn;

    @FXML
    Label labelPlayer1;
    @FXML
    Label labelPlayer2;
    @FXML
    Label labelNoWin;


    public void initialize(){
        labelPlayer1.setText(" ");
        labelPlayer2.setText(" ");
        labelNoWin.setText(" ");
    }

    public void onClick(ActionEvent actionEvent){
        Button button = (Button) actionEvent.getSource();
        button.setFont(Font.font("verdana",40));
        if(turn){
            button.setText("X");
        }else{
            button.setText("O");
        }

        button.setDisable(true);
        turn = !turn;
        button.setStyle("-fx-opacity: 1");
        count++;

        checkWinner();



    }

    void setStyle(Button... buttons){
        for(Button b : buttons){
            b.setStyle("-fx-background-color: green");
        }
    }

    void checkWinner(){

        if(btn1.getText() == btn2.getText() && btn2.getText() == btn3.getText() && btn1.isDisabled()){
            setStyle(btn1,btn2,btn3);
            win = true;
        }else if(btn4.getText() == btn5.getText() && btn5.getText() == btn6.getText() && btn4.isDisabled()){
            setStyle(btn4,btn5,btn6);
            win = true;
        } else if (btn7.getText() == btn8.getText() && btn8.getText() == btn9.getText() && btn7.isDisabled()) {
            setStyle(btn7,btn8,btn9);
            win = true;
        }

        if(btn1.getText() == btn4.getText() && btn4.getText() == btn7.getText() && btn1.isDisabled()){
            setStyle(btn1,btn5,btn7);
            win = true;
        }else if(btn2.getText() == btn5.getText() && btn5.getText() == btn8.getText() && btn2.isDisabled()){
            setStyle(btn2,btn5,btn8);
            win = true;
        } else if (btn3.getText() == btn6.getText() && btn6.getText() == btn9.getText() && btn3.isDisabled()) {
            setStyle(btn3,btn6,btn9);
            win = true;
        }

        if(btn1.getText() == btn5.getText() && btn5.getText() == btn9.getText() && btn1.isDisabled()){
            setStyle(btn1,btn5,btn7);
            win = true;
        }else if(btn3.getText() == btn5.getText() && btn5.getText() == btn9.getText() && btn3.isDisabled()){
            setStyle(btn2,btn5,btn8);
            win = true;
        }

        if(win){
            String winner = "";

            if(turn){
                winner = "O";
            }else{
                winner = "X";
            }

            disableButtons();

            if(winner.equals("X")){
                player1++;
                labelPlayer1.setText("Winner is " + winner + ", Score is " + player1 + "" );

            }else{
                player2++;
                labelPlayer2.setText("Winner is " + winner + " , Score is " + player2 + "" );

            }



        }else{
            if (count == 9){
                Button[] buttons = {btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9};

                for(Button b : buttons){
                    b.setStyle("-fx-background-color: red");

                }

                labelNoWin.setText("No one is Winner");

            }
        }



    }

    public void disableButtons(){
        Button[] buttons = {btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9};

        for(Button b : buttons){
            b.setDisable(true);
        }
    }


    public void onButtonResetClick(){
        turn = true;
        win = false;
        count = 0;

        Button[] buttons = {btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9};

        for(Button b : buttons){
            b.setDisable(false);
            b.setText(" ");
            b.setStyle(null);
        }
    }


}
