package ut.hacktx.churningtracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class InsertInformation extends Activity{
	
	private EditText cardNameItemText;
	private EditText monthSignedItemText;
	private EditText moneySpentItemText;
	private EditText requiredSpendedItemText;
	private EditText rewardAmountItemText;
	private EditText timeFrameItemText;
	private EditText ;
	
	@Override
	public void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		newItemText = (EditText) findViewById(R.id.newItemText); //newItemText should be the name of a "text field"
		
	}
	
	public void submitItem (View view) {
		String message = newItemText.getText().toString();
		
		Intent i = getIntent();
		i.putExtra("item", message);
		setResult(RESULT_OK, i);
		finish();
	}
	
}