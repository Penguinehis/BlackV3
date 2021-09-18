package com.tg.net;

import android.app.Application;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Context;

import com.tg.ultrasshservice.TGNETVPNCore;
import com.tg.ultrasshservice.config.Settings;
import com.google.android.gms.ads.MobileAds;
import android.content.res.Configuration;

/**
* App
*/
public class TGNETVPNApp extends Application
{
	private static final String TAG = TGNETVPNApp.class.getSimpleName();
	public static final String PREFS_GERAL = "TGNETVPNGERAL";
	
	public static final String ADS_UNITID_INTERSTITIAL_MAIN = "noads";
	public static final String ADS_UNITID_BANNER_MAIN = "noads";
	public static final String ADS_UNITID_BANNER_SOBRE = "noads";
	public static final String ADS_UNITID_BANNER_TEST = "noads";
	public static final String APP_FLURRY_KEY = "RQQ8J9Q2N4RH827G32X9";
	
	private static TGNETVPNApp mApp;
	
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
		TGNETVPNCore.init(this);
		
		// protege o app
		//SkProtect.init(this);
		
		// Initialize the Mobile Ads SDK.
        MobileAds.initialize(this);
		
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
	
	public static TGNETVPNApp getApp() {
		return mApp;
	}
}
