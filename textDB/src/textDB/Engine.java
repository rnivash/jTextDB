package textDB;

import java.util.*;
import java.io.*;

public class Engine {
	
	private static Engine Instance;
	
	private Engine() {
		LoadConfig();
	}
	
	public static Engine getInstance() {
		if(Instance == null) {
			Instance = new Engine();
		}
		return Instance;
	}
	
	public Settings Config;
	
	private void LoadConfig() {
		Config = new Settings();
		InputStream inputStream = null;
		try {
			Properties prop = new Properties();
			inputStream = getClass()
					.getClassLoader()
					.getResourceAsStream("config.properties");
			if(inputStream != null) {
				prop.load(inputStream);
				
				Config.FilePath = prop.getProperty("textdbpath",System.getProperty("user.dir"));
			}
			if(inputStream != null) {
				inputStream.close();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
