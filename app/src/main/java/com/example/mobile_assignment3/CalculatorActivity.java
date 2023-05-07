package com.example.mobile_assignment3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

import androidx.appcompat.app.AppCompatActivity;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView text_res, text_sol;
    private Button button_0,button_1,button_2,button_3,button_4,button_5,button_6,button_7,button_8,button_9,
                button_ac,button_div,button_multi,button_plus,button_minus,button_c,button_openbracket,button_closebracket,
                button_dot,button_equal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        text_res = findViewById(R.id.textview_res);
        text_sol = findViewById(R.id.textview_solution);

        assignButton(button_0,R.id.button_zero);
        assignButton(button_1,R.id.button_1);
        assignButton(button_2,R.id.button_2);
        assignButton(button_3,R.id.button_3);
        assignButton(button_4,R.id.button_4);
        assignButton(button_5,R.id.button_5);
        assignButton(button_6,R.id.button_6);
        assignButton(button_7,R.id.button_7);
        assignButton(button_8,R.id.button_8);
        assignButton(button_9,R.id.button_9);
        assignButton(button_ac,R.id.button_ac);
        assignButton(button_div,R.id.button_divide);
        assignButton(button_multi,R.id.button_multiply);
        assignButton(button_plus,R.id.button_plus);
        assignButton(button_minus,R.id.button_minus);
        assignButton(button_c,R.id.button_c);
        assignButton(button_openbracket,R.id.button_openbracket);
        assignButton(button_closebracket,R.id.button_closebracket);
        assignButton(button_dot,R.id.button_dot);
        assignButton(button_equal,R.id.button_equal);

    }
    // assign buttons
    void assignButton(Button button, int id){
        button = findViewById(id);
        button.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        Button button = (Button)view;
        String text = button.getText().toString();
        String text2 = text_sol.getText().toString();
        // when "AC" is pressed, clear all
        if(text.equals("ac")){
            text_sol.setText("");
            text_res.setText("0");
            return;
        }
        // when "C" is pressed, clear last digit
        if(text.equals("c")){
            text2 = text2.substring(0,text2.length()-1);
        }
        // if "=" is pressed
        if (text.equals("=")) {
            text_sol.setText(text_res.getText());
            return;
        }else{
            text2 = text2 + text;
        }
        text_sol.setText(text2);

        // If result is did not return error calculate the result
        String result = calculate(text2);
        if(!result.equals("Error Occured")){
            text_res.setText(result);
        }
    }

    String calculate(String value){
        try{
            Context context = Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable script = context.initSafeStandardObjects();
            String res = context.evaluateString(script,value,"JavaScript",1,null).toString();
            return res;
        } catch (Exception e){
            return "Error Occured";
        }
    }
}
