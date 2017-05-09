package loadingdata.ashish.myapplication;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

public class AddNewPerson extends Activity implements OnClickListener {

	private AtomPayListAdapter adapter;
	private EditText etname,etaddress;
	Button sendtoserver;
	ArrayAdapter<CharSequence> spinneradapter;
	private Spinner spinner;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_view);
		etname=(EditText)findViewById(R.id.name);
		etaddress=(EditText)findViewById(R.id.address);
		sendtoserver=(Button)findViewById(R.id.senserver);
		spinner=(Spinner)findViewById(R.id.spinner);
		setupListViewAdapter();
		SpinnerSetup();
		setupAddPaymentButton();
		sendtoserver.setOnClickListener(this);
	}

	private void SpinnerSetup() {
		spinneradapter = ArrayAdapter.createFromResource(
				this, R.array.City, android.R.layout.simple_spinner_item);
		spinneradapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(spinneradapter);
	}

	public void removeAtomPayOnClickHandler(View v) {
		AtomPayment itemToRemove = (AtomPayment)v.getTag();
		adapter.remove(itemToRemove);
	}

	private void setupListViewAdapter() {
		adapter = new AtomPayListAdapter(AddNewPerson.this, R.layout.atom_pay_list_item, new ArrayList<AtomPayment>());
		ListView atomPaysListView = (ListView)findViewById(R.id.EnterPays_atomPaysList);
		atomPaysListView.setAdapter(adapter);
	}
	
	private void setupAddPaymentButton() {
		findViewById(R.id.EnterPays_addAtomPayment).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				adapter.insert(new AtomPayment(etname.getText().toString(),etaddress.getText().toString(),spinner.getSelectedItem().toString()), 0);
			}
		});
	}


	@Override
	public void onClick(View view) {
		switch (view.getId())
		{
			case R.id.senserver:
				DataSendtoServer();
		}

	}

	private void DataSendtoServer() {


	}
}
