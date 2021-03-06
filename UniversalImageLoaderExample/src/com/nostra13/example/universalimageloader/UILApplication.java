package com.nostra13.example.universalimageloader;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * @author Sergey Tarasevich (nostra13[at]gmail[dot]com)
 */
public class UILApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();

		// This configuration tuning is custom. You can tune every option, you may tune some of them, 
		// or you can create default configuration by
		//  ImageLoaderConfiguration.createDefault(this);
		// method.
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext())
			.threadPoolSize(3)
			.threadPriority(Thread.NORM_PRIORITY - 2)
			.memoryCacheSize(1500000) // 1.5 Mb
			.discCacheSize(50000000) // 50 Mb
			.httpReadTimeout(10000) // 10 s
			.denyCacheImageMultipleSizesInMemory()
			.build();
		// Initialize ImageLoader with configuration.
		ImageLoader.getInstance().init(config);
		ImageLoader.getInstance().enableLogging(); // Not necessary in common
	}
}