package app.config;

/**
 * AppConfigを保持するクラス
 */
public class AppConfigService {
	private static AppConfigService theInstance;
	private AppConfig appConfig;

	private AppConfigService(AppConfig appConfig) {
		this.appConfig = appConfig;
	}
	public synchronized static AppConfigService getInstance() {
		if(theInstance == null) {
			throw new RuntimeException("AppConfigService is not initialized.");
		}
		return theInstance;
	}
	public synchronized static AppConfigService getInstance(AppConfig appConfig) {
		if(theInstance == null) {
			theInstance = new AppConfigService(appConfig);
		}
		return theInstance;
	}
	
	public AppConfig getAppConfig() {
		return this.appConfig;
	}
}
