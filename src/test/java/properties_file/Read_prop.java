package properties_file;



public class Read_prop {
	public static final String Filepath = System.getProperty("user.dir")+"/src/test/resources/confige/Test.properties";
	public static String  GetBrowserName() {
		return prop_file.Extract_PropertyFile(Filepath, "browser_name");
	}
	
	public static  String GetUrl() {
		return prop_file.Extract_PropertyFile(Filepath, "App_url");
	}
	
	public static  String getusername() {
		return prop_file.Extract_PropertyFile(Filepath,"username");
	}
	
	public static  String getPassword() {
		return prop_file.Extract_PropertyFile(Filepath,"password" );
	}

}
