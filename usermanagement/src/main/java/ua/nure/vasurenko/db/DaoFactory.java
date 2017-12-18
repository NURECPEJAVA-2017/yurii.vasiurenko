package ua.nure.vasurenko.db;

import java.util.Properties;

public abstract class DaoFactory {

	private static DaoFactory instance;
	
	protected static Properties properties;
	
	protected DaoFactory(){}
	
	static {
			 properties = new Properties();
			 try{
				 properties.load(DaoFactory.class.getClassLoader().getResourceAsStream("settings.properties"));
			 } catch (IOException e){
				 throw new RuntimeException();
						 .
			 }

	
	}
	
	public static synchronized DaoFactory getInstance(){
		if (instance == null){
			Class factoryClass;
			try{
				factoryClass = Class.forName(properties.getProperty("dao.factory"));
				instance = (DaoFactory) factoryClass.newInstance();
			}catch (ClassNotFoundException e) {
				throw new RuntimeException();
			}catch (InstantiationException e){
				throw new RuntimeException ();
			}catch (IllegalAccessException e){
				throw new RuntimeException();
			}
		}
	
	return instance;
}
public ConnectionFactory getConnectionFactory(){
	return new ConnectionFactoryImpl(properties);
}

public abstract UserDAO getUserDao();
}
