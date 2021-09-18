package com.blackv3.ultrasshservice.tunnel;

import android.content.Intent;
import android.os.Build;
import android.content.Context;
import com.blackv3.ultrasshservice.BLCKv3Service;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class TunnelManagerHelper
{
	public static void startBLCKv3(Context context) {
        Intent startVPN = new Intent(context, BLCKv3Service.class);
		
		if (startVPN != null) {
			TunnelUtils.restartRotateAndRandom();
			
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
			//noinspection NewApi
                context.startForegroundService(startVPN);
            else
                context.startService(startVPN);
        }
    }
	
	public static void stopBLCKv3(Context context) {
		Intent stopTunnel = new Intent(BLCKv3Service.TUNNEL_SSH_STOP_SERVICE);
		LocalBroadcastManager.getInstance(context)
			.sendBroadcast(stopTunnel);
	}
}
