package com.tg.ultrasshservice.tunnel;

import android.content.Intent;
import android.os.Build;
import android.content.Context;
import com.tg.ultrasshservice.TGNETVPNService;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class TunnelManagerHelper
{
	public static void startTGNETVPN(Context context) {
        Intent startVPN = new Intent(context, TGNETVPNService.class);
		
		if (startVPN != null) {
			TunnelUtils.restartRotateAndRandom();
			
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
			//noinspection NewApi
                context.startForegroundService(startVPN);
            else
                context.startService(startVPN);
        }
    }
	
	public static void stopTGNETVPN(Context context) {
		Intent stopTunnel = new Intent(TGNETVPNService.TUNNEL_SSH_STOP_SERVICE);
		LocalBroadcastManager.getInstance(context)
			.sendBroadcast(stopTunnel);
	}
}
