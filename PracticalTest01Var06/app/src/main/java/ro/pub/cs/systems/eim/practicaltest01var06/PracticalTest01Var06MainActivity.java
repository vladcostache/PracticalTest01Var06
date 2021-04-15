package ro.pub.cs.systems.eim.practicaltest01var06;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PracticalTest01Var06MainActivity extends AppCompatActivity {

    private EditText leftEditText, rightEditText, centerEditText;
    private CheckBox leftCheckbox, rightCheckbox, centerCheckbox;
    private Button playButton;

    private ButtonClickListener saveClickListener = new ButtonClickListener();

    private class ButtonClickListener implements View.OnClickListener{
        Random rand = new Random();
        List<String> elements = Arrays.asList("1", "2", "3", "*");

        String randomElement1, randomElement2, randomElement3;
//        randomElement1 = elements.get(rand.nextInt(elements.size()));
//        randomElement2 = elements.get(rand.nextInt(elements.size()));
//        randomElement3 = elements.get(rand.nextInt(elements.size()));

        int no_checkbox = 0;
        @Override
        public void onClick(View v) {
            if(v.getId() == R.id.play_button){
                if(!leftCheckbox.isChecked()){
                    randomElement1 = elements.get(rand.nextInt(elements.size()));
                    leftEditText.setText(randomElement1);
                } else if(leftCheckbox.isChecked()){
                    no_checkbox++;
                }
                if(!centerCheckbox.isChecked()){
                    randomElement2 = elements.get(rand.nextInt(elements.size()));
                    centerEditText.setText(randomElement2);
                }else if(centerCheckbox.isChecked()){
                    no_checkbox++;
                }
                if(!rightCheckbox.isChecked()){
                    randomElement3 = elements.get(rand.nextInt(elements.size()));
                    rightEditText.setText(randomElement3);
                }else if(rightCheckbox.isChecked()){
                    no_checkbox++;
                }
                Context context = getApplicationContext();
                String text = randomElement1 + " " + randomElement2 + " " + randomElement3;
                Toast.makeText(context, text, Toast.LENGTH_LONG).show();

                Intent intent = new Intent(getApplicationContext(), PracticalTest01Var06SecondaryActivity.class);
                intent.putExtra("NUMBER1", randomElement1);
                intent.putExtra("NUMBER2", randomElement2);
                intent.putExtra("NUMBER3", randomElement3);
                intent.putExtra("NO_CHECK", no_checkbox);
                startActivityForResult(intent, 100);
            }
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var06_main);

        leftEditText = (EditText)findViewById(R.id.left_edit_text);
        rightEditText = (EditText)findViewById(R.id.right_edit_text);
        centerEditText = (EditText)findViewById(R.id.center_edit_text);

        leftCheckbox = (CheckBox)findViewById(R.id.checkbox_left);
        rightCheckbox = (CheckBox)findViewById(R.id.checkbox_right);
        centerCheckbox = (CheckBox)findViewById(R.id.checkbox_center);

        playButton = (Button)findViewById(R.id.play_button);

        playButton.setOnClickListener(saveClickListener);
    }
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            Toast.makeText(this, "Gain score" + resultCode, Toast.LENGTH_LONG).show();
        }
    }

    protected void onSaveInstanceState(@NonNull Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("SCOR", "2");
    }

    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.containsKey("SCOR")) {
            Context context = getApplicationContext();
            String text = savedInstanceState.getString("SCOR");
            Toast.makeText(context, text, Toast.LENGTH_LONG).show();
        }
    }
}