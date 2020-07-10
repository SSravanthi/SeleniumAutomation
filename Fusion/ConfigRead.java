package Fusion;



import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class ConfigRead {


	PropertyResourceBundle prop = (PropertyResourceBundle) ResourceBundle.getBundle("Fusion.Config"); 

	/**
	 *  
	 * Get Config values from the instance of class
	 *  
	 */
	
	public String getProperty(String key) 
	{
		String value = prop.getString(key);
		System.out.println(value);
		if (value.length() > 0) 
		{
			return value;
		}
		return "";
	}	

	}
	