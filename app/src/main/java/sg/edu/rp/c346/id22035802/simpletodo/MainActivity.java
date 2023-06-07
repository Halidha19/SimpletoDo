package sg.edu.rp.c346.id22035802.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etNewTodo;
    Button btnAdd;
    Button btnClearAll;
    ListView lvTodo;

    ArrayList<String> alTodo = new ArrayList<>();
    ArrayAdapter<String> aaTodo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNewTodo = findViewById(R.id.editNewToDo);
        btnAdd = findViewById(R.id.buttonAddItem);
        btnClearAll = findViewById(R.id.buttonClearItem);
        lvTodo = findViewById(R.id.listViewTodo);

        alTodo = new ArrayList<>();

        aaTodo = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, alTodo);

        lvTodo.setAdapter(aaTodo);

        btnAdd.setOnClickListener((v )-> {
            String newTodo = etNewTodo.getText().toString();
            alTodo.add(newTodo);
            aaTodo.notifyDataSetChanged();
            etNewTodo.setText(null);
        });

        btnClearAll.setOnClickListener((v) -> {
            alTodo.clear();
            aaTodo.notifyDataSetChanged();

        });
    }
}