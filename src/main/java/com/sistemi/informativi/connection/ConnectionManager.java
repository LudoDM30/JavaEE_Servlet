package com.sistemi.informativi.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionManager implements DbParameters{
	
	/*
	 * apertura di una connessione al database
	 * e restituzione della stessa
	 */
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		
		Class.forName(dbDriver);
		
		Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPass);
		
		return con;
	}
	
	/*
	 * inizializzazione di una variabile
	 * di tipo PreparedStatement
	 * e ritorno di un oggetto PreparedStatement
	 * che potrà essere usato per una 
	 * operazione di insert oppure
	 * di update oppure di delete a seconda di
	 * quale sarà lo script sql che arriverà in input
	 */
	public static PreparedStatement getPreparedStatement(String sql) throws ClassNotFoundException, SQLException {
		
		PreparedStatement ps = getConnection().prepareStatement(sql);
		
		return ps;
	}
	
	/*
	 * inizializzazione di una variabile 
	 * di tipo ResultSet tramite lo Statement
	 * e ritorno di una struttura dati che conterrà
	 * il risultato di una query (quella passata
	 * in input sotto forma di String)
	 * dal metodo invocante
	 */
	public static ResultSet getResultSet(String sql) throws ClassNotFoundException, SQLException {
		
		Statement st = getConnection().createStatement();
		
		ResultSet rs = st.executeQuery(sql);
		
		return rs;
	}
	
	/*
	 * chiusura della connessione
	 */
	public static void closeConnection() throws ClassNotFoundException, SQLException {
		getConnection().close();
	}

}
