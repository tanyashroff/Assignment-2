package edu.umd.enpm614.assignment2.services;

import edu.umd.enpm614.assignment2.interfaces.Authentication;
import edu.umd.enpm614.assignment2.interfaces.Connection;
import edu.umd.enpm614.assignment2.interfaces.FileSystem;
import edu.umd.enpm614.assignment2.interfaces.Persistance;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
public class PersistanceMySQL implements Persistance {

	private final FileSystem filesystem;
	private final Connection connection;

	@Inject
	public PersistanceMySQL(FileSystem filesystem, Connection connection) {
		this.filesystem = filesystem;
		this.connection = connection;
	}

	@Override
	public String getType() {
		return "MySQL Persistance";
	}
	
	@Override
	public boolean run() {
		System.out.println("running " + this.getType());
		
		// invoke services here if applicable
		filesystem.run();
		connection.run();

		return true;
	}
}
