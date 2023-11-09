package MyApp.Controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;


public class TicTacToeController {

    boolean turn, win;
    private int count = 0 , player1 = 0 , player2 = 0;

    @FXML
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,resetBtn;

    @FXML
    Label labelPlayer1,labelPlayer2,labelNoWin;


    public void initialize(){
        labelPlayer1.setText(" ");
        labelPlayer2.setText(" ");
        labelNoWin.setText(" ");
    }

    public void onClick(ActionEvent actionEvent){
        Button button = (Button) actionEvent.getSource();
        button.setFont(Font.font("verdana",40));
        if(turn){
            button.setText("O");
        }else{
            button.setText("X");
        }

        button.setDisable(true);
        turn = !turn;
        button.setStyle("-fx-opacity: 1");
        count++;

        button.requestFocus();
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
            setStyle(btn1,btn4,btn7);
            win = true;
        }else if(btn2.getText() == btn5.getText() && btn5.getText() == btn8.getText() && btn2.isDisabled()){
            setStyle(btn2,btn5,btn8);
            win = true;

        } else if (btn3.getText() == btn6.getText() && btn6.getText() == btn9.getText() && btn3.isDisabled()) {
            setStyle(btn3,btn6,btn9);
            win = true;
        }

        if(btn1.getText() == btn5.getText() && btn5.getText() == btn9.getText() && btn1.isDisabled()){
            setStyle(btn1,btn5,btn9);
            win = true;
        }else if(btn3.getText() == btn5.getText() && btn5.getText() == btn7.getText() && btn3.isDisabled()){
            setStyle(btn3,btn5,btn7);
            win = true;
        }

        if(win){
            String winner = "";

            if(turn){
                winner = "X";
            }else{
                winner = "O";
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

                labelNoWin.setText("No Winner");
                labelNoWin.setStyle("fx-color: red");

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
        turn = false;
        win = false;
        count = 0;

        Button[] buttons = {btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9};

        for(Button b : buttons){
            b.setDisable(false);
            b.setText(" ");
            b.setStyle(null);
        }

        labelNoWin.setText(" ");
    }


}
