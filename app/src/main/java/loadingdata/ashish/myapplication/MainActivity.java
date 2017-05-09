package loadingdata.ashish.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity implements View.OnClickListener {
    EditText nameeditText, Address;
    Button addButton, sendtoserver;
    ArrayList<String> Data;
    ListView listView;
    Spinner spinner;
    ArrayAdapter<CharSequence> spinneradapter;
    ArrayList<String> listItems;
    ArrayAdapter<String> adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WidgetInitialization();
        SpinnerSetup();
        ListSetUp();
        addButton.setOnClickListener(this);
        sendtoserver.setOnClickListener(this);
    }


    private void ListSetUp() {
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, listItems);
        listView.setAdapter(adapter);
    }

    private void SpinnerSetup() {
        spinneradapter = ArrayAdapter.createFromResource(
                this, R.array.City, android.R.layout.simple_spinner_item);
        spinneradapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinneradapter);
    }


    private void WidgetInitialization() {
        Data = new ArrayList<String>();
        listItems = new ArrayList<String>();
        addButton = (Button) findViewById(R.id.addItem);
        sendtoserver = (Button) findViewById(R.id.senserver);
        listView = (ListView) findViewById(R.id.listView);
        spinner = (Spinner) findViewById(R.id.spinner);
        nameeditText = (EditText) findViewById(R.id.name);
        Address = (EditText) findViewById(R.id.address);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.addItem:
                listItems.add(" Name :" + nameeditText.getText().toString() + "\n  Address: " + Address.getText().toString() + "\n  City :" + spinner.getSelectedItem().toString());
                adapter.notifyDataSetChanged();
                break;
            case R.id.senserver:
                Data = listItems;
                Log.d("List Items", Data + "");
                Toast.makeText(MainActivity.this, Data + "", Toast.LENGTH_SHORT).show();
                break;

        }
    }
}

