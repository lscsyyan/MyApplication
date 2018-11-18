package com.example.shinelon.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
    private TextView textView;
    private String str,num1,num2;
    private double result;
    private boolean addNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        addNum = true;
    }

    public void onClick(View v){
        str = (String) textView.getText();
        switch (v.getId()) {
            case R.id.btn_cle:
                textView.setText("");
                break;
            case R.id.btn_del:
                if(!str.equals("") && str != null){
                    textView.setText(str.substring(0, str.length()-1));
                }
                break;
            case R.id.btn_equ:
                if(str.contains("+")){
                    getResult(num1, num2, "+");
                }
                else if(str.contains("-")){
                    getResult(num1, num2, "-");
                }
                else if(str.contains("×")){
                    getResult(num1, num2, "×");
                }
                else if(str.contains("÷")){
                    getResult(num1, num2, "÷");
                }
                else {
                    return;
                }
                break;
            case R.id.btn_add:
            case R.id.btn_sub:
            case R.id.btn_mul:
            case R.id.btn_div:
                if (str.contains("+")||str.contains("-")||str.contains("×")||str.contains("÷"))
                    return;
                else
                    textView.setText(str+((Button)v).getText());
                if(!addNum)
                    addNum = true;
                break;
            default:
                if (addNum) {
                    textView.setText(str+((Button)v).getText());
                }else{
                    textView.setText(((Button)v).getText());
                    addNum = true;
                }
                break;
        }
    }
    private void getResult(String num1,String num2,String op) {
        num1 = str.substring(0,str.indexOf(op));
        num2 = str.substring(str.indexOf(op)+1);
        try {
            double n1 = Double.parseDouble(num1);
            double n2 = Double.parseDouble(num2);
            if (op.equals("+")) {
                result = n1+n2;
            }else if(op.equals("-")){
                result = n1-n2;
            }else if(op.equals("×")){
                result = n1*n2;
            }else if(op.equals("÷")){
                result = n1/n2;
            }else {
                return;
            }

            String r = result+"";
            if(r.contains(".")&&r.substring(r.length()-1).equals("0")){
                r = r.substring(0,r.indexOf("."));
            }
            textView.setText(r);
            addNum = false;
        } catch (Exception e) {
            return;
        }
    }
}
