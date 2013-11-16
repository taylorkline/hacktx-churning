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
	private EditText requiredSpentItemText;
	private EditText rewardAmountItemText;
	private EditText timeFrameItemText;
	private EditText feeItemText;
	
	@Override
	public void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		cardNameItemText = (EditText) findViewById(R.id.comp);
		monthSignedItemText = (EditText) findViewById(R.id.mon);
		moneySpentItemText = (EditText) findViewById(R.id.cash);
		requiredSpentItemText = (EditText) findViewById(R.id.lim);
		rewardAmountItemText = (EditText) findViewById(R.id.reward);
		timeFrameItemText = (EditText) findViewById(R.id.tim);
		feeItemText = (EditText) findViewById(R.id.fees);
		
	}
	
	public void submitItem (View view) {
		String cardName = cardNameItemText.getText().toString();
		String monthSigned = monthSignedItemText.getText().toString();
		String moneySpent = moneySpentItemText.getText().toString();
		String requiredSpent = requiredSpentItemText.getText().toString();
		String rewardAmount = rewardAmountItemText.getText().toString();
		String timeFrame = timeFrameItemText.getText().toString();
		String feeItem = feeItemText.getText().toString();
		
		Database myDatabase = new Database(InsertInformation.this);
		myDatabase.createEntry(cardName, monthSigned, moneySpent, requiredSpent, rewardAmount, timeFrame, feeItem);
		
		//Intent i = getIntent();
		//i.putExtra("item", message);
		//setResult(RESULT_OK, i);
		//finish();
	}
	
}