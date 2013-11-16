package ut.hacktx.churningtracker;

import io.card.payment.CardIOActivity;
import io.card.payment.CreditCard;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

//cardIO app token: 10f00cdf035d444aaef4d8a7a8e3cc5c

public class MainActivity extends Activity {

	//private static  String = null;
	public int MY_SCAN_REQUEST_CODE;
	public String resultDisplayStr;
	private Button myCardsButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button myCardsButton = (Button) findViewById(R.id.myCardsButton);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
	
		return true;
	}
	
	public void onScanPress(View v) {
	    Intent scanIntent = new Intent(this, CardIOActivity.class);

	    // required for authentication with card.io
	    scanIntent.putExtra(CardIOActivity.EXTRA_APP_TOKEN, "10f00cdf035d444aaef4d8a7a8e3cc5c");

	    // customize these values to suit your needs.
	    scanIntent.putExtra(CardIOActivity.EXTRA_REQUIRE_EXPIRY, true); // default: true
	    scanIntent.putExtra(CardIOActivity.EXTRA_REQUIRE_CVV, false); // default: false
	    scanIntent.putExtra(CardIOActivity.EXTRA_REQUIRE_POSTAL_CODE, false); // default: false

	    // MY_SCAN_REQUEST_CODE is arbitrary and is only used within this activity.
	    startActivityForResult(scanIntent, MY_SCAN_REQUEST_CODE);
	}
	
	public void onMyCardsPress(View v) {
		Intent myCardsIntent = new Intent(this, InsertInformation.class);		
		startActivityForResult(myCardsIntent, 1);
		
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	    super.onActivityResult(requestCode, resultCode, data);

	    if (requestCode == MY_SCAN_REQUEST_CODE) {
	        
	        if (data != null && data.hasExtra(CardIOActivity.EXTRA_SCAN_RESULT)) {
	            CreditCard scanResult = data.getParcelableExtra(CardIOActivity.EXTRA_SCAN_RESULT);

	            // Never log a raw card number. Avoid displaying it, but if necessary use getFormattedCardNumber()
	            resultDisplayStr = "Card Number: " + scanResult.getRedactedCardNumber() + "\n";
	            
	            // Do something with the raw number, e.g.:
	            // myService.setCardNumber( scanResult.cardNumber );
	            
	            populateListView(resultDisplayStr);
	            registerClickerCallback();

	            if (scanResult.isExpiryValid()) {
	                resultDisplayStr += "Expiration Date: " + scanResult.expiryMonth + "/" + scanResult.expiryYear + "\n";
	            }

	            if (scanResult.cvv != null) {
	                // Never log or display a CVV
	                resultDisplayStr += "CVV has " + scanResult.cvv.length() + " digits.\n";
	            }

	            if (scanResult.postalCode != null) {
	                resultDisplayStr += "Postal Code: " + scanResult.postalCode + "\n";
	            }
	        }
	        else {
	            resultDisplayStr = "Scan was canceled.";
	        }
	        // do something with resultDisplayStr, maybe display it in a textView
	        // resultTextView.setText(resultStr);
	        populateListView(resultDisplayStr);
	        
	        
	    }
	    // else handle other activity results
	    
	}
	
	

	private void populateListView(String resultDisplayStr2) {
		// TODO Auto-generated method stub
		String[] myItems = {resultDisplayStr2}; 
    	
    	ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.da_item, myItems);
    			
    	ListView list = (ListView) findViewById(R.id.listViewMain);
    	list.setAdapter(adapter);
    	
		
	}
	
	private void registerClickerCallback() {
		// TODO Auto-generated method stub
		ListView list = (ListView) findViewById(R.id.listViewMain);
		list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			public void onItemClick(AdapterView<?> paret, View viewClicked, int position, long id)
			{
				TextView textView = (TextView) viewClicked;
				String message = "Credit Card: " +position + "Number: " + textView.getText().toString();
				Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
			}
		});
	}

	
	
	
	
}
