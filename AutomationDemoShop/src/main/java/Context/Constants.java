package Context;

import Utils.UniqueGenerator;

public class Constants {
	
	public static final String WORKINGDIRECTORY= System.getProperty("user.dir");
	public static final String PROPERTIESFILE =WORKINGDIRECTORY+"/src/main/resources/Configurations/Config.properties";
	public static final String EXCELFILE = WORKINGDIRECTORY+"/src/test/resources/testData/regsiteration.xlsx";
	public static final String reportPath =WORKINGDIRECTORY +"/Reports/index.html";
	public static String Screenshot=WORKINGDIRECTORY+"/Reports/screenshot"+UniqueGenerator.getCurrentDateTime()+".png";
	public static String extentConfigFile= WORKINGDIRECTORY+"/src/test/resources/extentConfig/extent-config.xml";
}
