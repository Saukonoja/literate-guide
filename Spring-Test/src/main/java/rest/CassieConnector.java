package rest;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.exceptions.NoHostAvailableException;

public class CassieConnector{
	Session session = null;
	String keyspace = "keyspacename"; // keyspace == database
	public CassieConnector(){
		this("localhost");
	}

	public CassieConnector(String addr){
		Cluster cluster = new Cluster.Builder().
				addContactPoint(addr).build();
		this.session = cluster.connect(keyspace);
	}

	public ResultSet selectCassie(String cql){
		ResultSet results = null;
	    try{
		results = session.execute(cql);
                return results;
	    }catch (NoHostAvailableException e){
		System.out.println(e.getErrors());
                return results;
	    }

	}

	public void insertCassie(String table, String username, String firstname, String lastname, int age){
		String cql = "INSERT INTO " + table + "(username, firstname, lastname, age) VALUES ('" + 
		                username + "', '" + firstname + "', '" + lastname + "', " +  age + " );";
		    try{
		        session.execute(cql);
		    }catch (NoHostAvailableException e){
		        System.out.println(e.getErrors());
		    }
		}
}
