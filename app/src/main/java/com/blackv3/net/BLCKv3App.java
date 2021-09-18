package com.blackv3.net;

import android.app.Application;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Context;

import com.blackv3.ultrasshservice.BLCKv3Core;
import com.blackv3.ultrasshservice.config.Settings;
import android.content.res.Configuration;

/**
* App
*/
public class BLCKv3App extends Application
{
	private static final String TAG = BLCKv3App.class.getSimpleName();
	public static final String PREFS_GERAL = "BLCKv3GERAL";
	
	public static final String ADS_UNITID_INTERSTITIAL_MAIN = "noads";
	public static final String ADS_UNITID_BANNER_MAIN = "noads";
	public static final String ADS_UNITID_BANNER_SOBRE = "noads";
	public static final String ADS_UNITID_BANNER_TEST = "noads";
	public static final String APP_FLURRY_KEY = "RQQ8J9Q2N4RH827G32X9";
	
	private static BLCKv3App mApp;
	
	@Override
	public void onCreate()
	{
		super.onCreate();
		
		mApp = this;
		
		// captura dados para análise
		/*new FlurryAgent.Builder()
			.withCaptureUncaughtExceptions(true)
            .withIncludeBackgroundSessionsInMetrics(true)
            .withLogLevel(Log.VERBOSE)
            .withPerformanceMetrics(FlurryPerformance.ALL)
			.build(this, APP_FLURRY_KEY);*/
			
		// inicia
		BLCKv3Core.init(this);
		
		// protege o app
		//SkProtect.init(this);
		
		// Initialize the Mobile Ads SDK.
		
		// modo noturno
		setModoNoturno(this);
	}
	
	@Override
	protected void attachBaseContext(Context base) {
		super.attachBaseContext(base);
		//LocaleHelper.setLocale(this);
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		//LocaleHelper.setLocale(this);
	}
	
	private void setModoNoturno(Context context) {
		boolean is = new Settings(context)
			.getModoNoturno().equals("on");

		int night_mode = is ? AppCompatDelegate.MODE_NIGHT_YES : AppCompatDelegate.MODE_NIGHT_NO;
		AppCompatDelegate.setDefaultNightMode(night_mode);
	}
	
	public static BLCKv3App getApp() {
		return mApp;
	}
}
