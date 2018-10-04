package e.dimas.labs;


import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        SharedPreferences sp  = getSharedPreferences("app_settings", Context.MODE_PRIVATE);
        String entryListString = sp.getString("entry_list", "");

        String[] entryList = entryListString.split("&");
        for (int i = 0; i < entryList.length; i++)
        {
            String[] data = entryList[i].split("\\|");
            entryList[i] = data[0] + ", " + data[1] + ", " + data[2];
        }

        ListView lv = findViewById(R.id.onViewList);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, entryList);
        lv.setAdapter(adapter);
    }
}
