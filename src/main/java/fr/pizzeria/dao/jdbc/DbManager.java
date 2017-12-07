package fr.pizzeria.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import fr.pizzeria.exception.runtime.StopApplicationException;

public class DbManager {
	/* ATTRIBUTES */
	private Connection connection = null;
	private static DbManager singleton;
	private String url;
	private String user;
	private String password;
	
	private DbManager() {
		
	}
	
	public static synchronized DbManager getInstance() {
		if(singleton == null) {
			synchronized (DbManager.class) {
				singleton = new DbManager();
			}
		}
		return singleton;
	}
	
	/**
	 * Connexion à la base de données
	 * 
	 * @return
	 * @throws Exception
	 */
	public void openDbConnection() {
		/*
		 * Cette ligne exécute un bloc static dans la classe Driver qui effectue ceci:
		 * DriverManager.registerDriver(new org.mariadb.jdbc.Driver();
		 */
		ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
		try {
			Class.forName(bundle.getString("pizzeria.driver"));
		} catch (ClassNotFoundException e) {
			throw new StopApplicationException(e.getMessage());
		}
		
		this.url = bundle.getString("pizzeria.url");
		this.user = bundle.getString("pizzeria.user");
		this.password = bundle.getString("pizerria.password");
		
		// Tester si connection ouverte
		Connection conn;
		try {
			conn = DriverManager.getConnection(this.url, this.user, this.password);
			if (this.getConnection() == null || this.getConnection().isClosed()) {
				this.setConnection(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @return the connection
	 */
	public Connection getConnection() {
		return connection;
	}

	/**
	 * @param connection the connection to set
	 */
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	

}
