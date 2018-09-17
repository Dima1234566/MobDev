package labwork.lab1;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Activity extends AppCompatActivity {

    private EditText edit;
    private TextView TextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_);

        edit = findViewById(R.id.edittext);
        TextView = findViewById(R.id.text);
    }

    public void clickButton(View view) {
        String text = edit.getText().toString();
        TextView.setText("Hello" + " " + text + "!");
    }


    public void clearButton(View view) {
        edit.setText("");
    }
}
