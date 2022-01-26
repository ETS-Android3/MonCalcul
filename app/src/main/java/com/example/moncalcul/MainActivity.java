package com.example.moncalcul;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
private EditText display;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.input);
        display.setShowSoftInputOnFocus(false);
        display.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v){
                if(getString(R.string.display).equals(display.getText().toString()))
            display.setText("");
            }
        });

    }
    private void updateText(String strToAdd){
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0,cursorPos);
        String rightStr = oldStr.substring(cursorPos);
        if(getString(R.string.display).equals(display.getText().toString()))
        {
            display.setText(strToAdd);
            display.setSelection(cursorPos+1);
        }
        else {
            display.setText(String.format("%s%s%s",leftStr,strToAdd,rightStr));
            display.setSelection(cursorPos+1);
        }


    }
    public void zeroBTN(View view){
updateText("0");
    }
    public void oneBTN(View view){
updateText("1");
    }
    public void towBTN(View view){
updateText("2");
    }
    public void threeBTN(View view){
updateText("3");
    }
    public void forBTN(View view){
updateText("4");
    }
    public void fiveBTN(View view){
updateText("5");
    }
    public void sevenBTN(View view){
updateText("7");
    }
    public void sixBTN(View view){
updateText("6");
    }
    public void eightBTN(View view){
updateText("8");
    }
    public void nineBTN(View view){
updateText("9");
    }
    public void plusBTN(View view){
updateText("+");
    }
    public void subBTN(View view){
updateText("-");
    }
    public void multipBTN(View view){
updateText("*");
    }
    public void clearBTN(View view){
display.setText("");
    }
    public void equalBTN(View view){
        String userExp =display.getText().toString();
        userExp = userExp.replaceAll("÷","/");
        userExp =  userExp.replaceAll("×", "*");

        Expression exp = new Expression(userExp);

        String result = String.valueOf(exp.calculate());
        display.setText(result);
        display.setSelection(result.length());
    }
    public void pointBTN(View view){
updateText(".");
    }
    public void plusminBTN(View view){
updateText("+/-");
    }
    public void deviseBTN(View view){
updateText("/");
    }
    public void parentheseBTN(View view){
    int cursorPos = display.getSelectionStart();
    int opnePar = 0;
    int closePar = 0;
    int textLen = display.getText().length();
    for (int i = 0; i< cursorPos; i++)
        {
            if(display.getText().toString().substring(i,i+1).equals("("))
            {
                opnePar += 1;

            }
            if(display.getText().toString().substring(i,i+1).equals(")"))
            {
                closePar += 1;

            }
        }
    if(opnePar == closePar || display.getText().toString().substring(textLen-1,textLen).equals("("))
    {
        updateText("(");
    }
    else if (closePar < opnePar && !display.getText().toString().substring(textLen-1,textLen).equals(")"))
    {
        updateText(")");
    }
    display.setSelection(cursorPos +1);
    }
    public void expoBTN(View view){
updateText("^");
    }
    public void backspaceBTN(View view){
int cursorPos = display.getSelectionStart();
int textLen = display.getText().length();
if(cursorPos != 0 && textLen != 0)
{
    SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
    selection.replace(cursorPos -1, cursorPos,"");
    display.setText(selection);
    display.setSelection(cursorPos -1);
}
    }
}