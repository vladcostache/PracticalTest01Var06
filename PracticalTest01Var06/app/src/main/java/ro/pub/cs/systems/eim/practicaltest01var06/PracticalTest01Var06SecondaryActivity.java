package ro.pub.cs.systems.eim.practicaltest01var06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PracticalTest01Var06SecondaryActivity extends AppCompatActivity {
    private TextView gained;
    private Button ok;
    int RESULT_SCORE = 0;

    private PracticalTest01Var06SecondaryActivity.ButtonClickListener buttonClickListener = new PracticalTest01Var06SecondaryActivity.ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            if(v.getId() == R.id.ok_button) {
                setResult(RESULT_SCORE, null); // Aici ar trebui sa fie gained score
            }

            finish();

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var06_secondary);

        gained = (TextView)findViewById(R.id.gained_text);
        ok = (Button)findViewById(R.id.ok_button);

        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey("NUMBER1") && intent.getExtras().containsKey("NUMBER2") && intent.getExtras().containsKey("NUMBER3")) {
            int numberofchecked = intent.getIntExtra("NO_CHECK", 0);
            String no1 = intent.getStringExtra("NUMBER1");
            String no2 = intent.getStringExtra("NUMBER2");
            String no3 = intent.getStringExtra("NUMBER3");
            if(no1.equals("*")){
                int number2 = Integer.parseInt(no2);
                int number3 = Integer.parseInt(no3);
                if(number2 == number3){
                    String to_show = "Gained" + String.valueOf(numberofchecked);
                    gained.setText(to_show);
                }
            }else if(no2.equals("*")){
                int number1 = Integer.parseInt(no1);
                int number3 = Integer.parseInt(no3);
                if(number1 == number3){
                    String to_show = "Gained" + String.valueOf(numberofchecked);
                    gained.setText(to_show);
                }
            }else if(no3.equals("*")){
                int number1 = Integer.parseInt(no1);
                int number2 = Integer.parseInt(no2);
                if(number1 == number2){
                    String to_show = "Gained" + String.valueOf(numberofchecked);
                    gained.setText(to_show);
                }
            }


        }

        ok.setOnClickListener(buttonClickListener);
    }
}