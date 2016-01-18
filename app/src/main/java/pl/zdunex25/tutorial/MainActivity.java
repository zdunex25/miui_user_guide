package pl.zdunex25.tutorial;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Scroller;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	final Context context = this;
	String[] countries;


	 
	// Array of integers points to images stored in /res/drawable-ldpi/
	int[] flags = new int[]{
	        R.drawable.ic_updater_settings,
	        R.drawable.com_miui_cloudservice,
	        R.drawable.com_miui_notes,
	        R.drawable.ic_date_time_settings,
	        R.drawable.ic_settings_home,
	        R.drawable.ic_account_autostar,
	        R.drawable.com_miui_fmradio,
	        R.drawable.com_miui_securitycenter,
	        R.drawable.ic_key_settings,
	};
	 
	// Array of strings to store currencies
	String[] currency = new String[]{
	        "Jakiś dodatkowy opis...",
	        "Jakiś dodatkowy opis...",
	        "Jakiś dodatkowy opis...",
	        "Jakiś dodatkowy opis...",
	        "Jakiś dodatkowy opis...",
	        "Jakiś dodatkowy opis...",
	        "Jakiś dodatkowy opis...",
	        "Jakiś dodatkowy opis...",
	        "Jakiś dodatkowy opis...",
	};
	    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		countries = getResources().getStringArray(R.array.list_items);
		
		// Each row in the list stores country name, currency and flag
        List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();
 
        for(int i=0;i<9;i++){
            HashMap<String, String> hm = new HashMap<String,String>();
            hm.put("txt", countries[i]);
            hm.put("cur", currency[i]);
            hm.put("flag", Integer.toString(flags[i]) );
            aList.add(hm);
        }
 
        // Keys used in Hashmap
        String[] from = { "flag","txt","cur" };
 
        // Ids of views in listview_layout
        int[] to = { R.id.flag,R.id.txt,R.id.cur};
 
        // Instantiating an adapter to store each items
        // R.layout.listview_layout defines the layout of each item
        SimpleAdapter adapter = new SimpleAdapter(getBaseContext(), aList, R.layout.listview_layout, from, to);
 
        // Getting a reference to listview of main.xml layout file
        ListView listView = ( ListView ) findViewById(R.id.listview);

        // Setting the adapter to the listView
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
					int i, long id) {
                // TODO Auto-generated method stub
                if(countries[i].equals("Aktualizacje")){
                	showDialog(getResources().getString(R.string.updates), getResources().getString(R.string.updates_summary));
                } else if(countries[i].equals("Aktywacja Wiadomości w chmurze lub dodanie lokalizacji w aplikacji Pogoda")){
                	showDialog(getResources().getString(R.string.cloudmsg), getResources().getString(R.string.cloudmsg_summary));
                } else if(countries[i].equals("Brak miniatur w ostatnich aplikacjach")){
                	showDialog(getResources().getString(R.string.recents), getResources().getString(R.string.recents_summary));
                } else if(countries[i].equals("Działanie aplikacji w tle")){
                	showDialog(getResources().getString(R.string.startup), getResources().getString(R.string.startup_summary));
                } else if(countries[i].equals("Edycja pulpitu")){
                	showDialog(getResources().getString(R.string.layout), getResources().getString(R.string.layout_summary));
                } else if(countries[i].equals("Niedziałające dymki i przejścia do aplikacji Messenger")){
                	showDialog(getResources().getString(R.string.popups), getResources().getString(R.string.popups_summary));
                } else if(countries[i].equals("Oczekiwanie na Wi-Fi w Sklepie Play i innych")){
                	showDialog(getResources().getString(R.string.downloads), getResources().getString(R.string.downloads_summary));
                } else if(countries[i].equals("Zarządzanie uprawnieniami aplikacji")){
                	showDialog(getResources().getString(R.string.permissions), getResources().getString(R.string.permissions_summary));
                } else if(countries[i].equals("Zmieniająca się klawiatura")){
                	showDialog(getResources().getString(R.string.missingkeys), getResources().getString(R.string.missingkeys_summary));
                }
            }
        });
	}

	private void showDialog(String title, String content) {
		final Dialog dialog = new Dialog(context,R.style.Theme_Holo_Light_Dialog);
    	//String chlog = getResources().getString(R.string.updates_summary);

        // Setting dialogview
        Window window = dialog.getWindow();
        window.setGravity(Gravity.BOTTOM);

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //dialog.setTitle(R.string.updates);
        dialog.setContentView(R.layout.dialog_updates);
		TextView header = (TextView) dialog.findViewById(R.id.titlee);
		header.setText(String.format(getResources().getString(R.string.lets_try2), title));
		TextView description = (TextView) dialog.findViewById(R.id.text3);
		description.setText(String.format(getResources().getString(R.string.lets_try), content));
		description.setMaxLines(10);
		description.setScroller(new Scroller(context));
		description.setVerticalScrollBarEnabled(true);
		description.setMovementMethod(new ScrollingMovementMethod());

        Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
		dialogButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				dialog.dismiss();
			}
		});

        dialog.show();
    }
}
