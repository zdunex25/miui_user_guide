package pl.zdunex25.tutorial;

import android.content.Context;
import android.content.BroadcastReceiver;
import android.content.Intent;

public class BootComplete extends BroadcastReceiver {

	@Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getAction().equalsIgnoreCase(Intent.ACTION_BOOT_COMPLETED)) {
            Intent serviceIntent = new Intent(context, NotifService.class);
            context.startService(serviceIntent);
        }
    }
}