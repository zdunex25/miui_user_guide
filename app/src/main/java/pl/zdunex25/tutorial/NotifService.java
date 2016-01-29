package pl.zdunex25.tutorial;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

public class NotifService extends Service {
	private static final int NOTIF_ID = 1;
	
	@Override
	public IBinder onBind(Intent intent) {
	    return null;
	}
	
	@Override
	public void onCreate() {
		super.onCreate();
		Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent , 0);
		NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
		    .setSmallIcon(R.drawable.ic_launcher)
		    .setContentTitle(getResources().getString(R.string.app_name))
		    .setContentText("Koniecznie zapoznaj się z treścią")
		    .setDefaults(Notification.DEFAULT_ALL)
		    .setContentIntent(contentIntent)
		    .setAutoCancel(true);
		NotificationManager notificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);

		//checkbox state
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		boolean checked = prefs.getBoolean("checkeddd", false);

		if (checked){
			Log.d("TAG", "zaznaczony");
			notificationManager.notify(NOTIF_ID, builder.build());
		}
		else{
			Log.d("TAG", "odznaczony");
		}
	}
}