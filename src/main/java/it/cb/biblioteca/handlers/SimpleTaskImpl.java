package it.cb.biblioteca.handlers;

import java.util.ArrayList;
import java.util.List;

import it.cb.biblioteca.dao.NoleggioDao;

public class SimpleTaskImpl {

	private TaskExecutionHandler handler;
	public void execute() {		
		List<Integer> numeroNoleggiTerminati = new ArrayList<Integer>();
		String messageTask = null;
		try{
			System.out.println("sono in SimpleTaskImpl");
			NoleggioDao nld = new NoleggioDao();
			numeroNoleggiTerminati= nld.numeroNoleggiTerminati();
			if(numeroNoleggiTerminati.isEmpty()) {
				messageTask= "non ci sono record da cancellare!";
			}else {
				// TO DO: cancella record via DAO...
				messageTask = "abbiamo eliminato "+ numeroNoleggiTerminati.size()+" records";
			}
			handler.onTaskCompleteSuccess(messageTask,numeroNoleggiTerminati);
		}catch(Exception e)
		{	
			handler.onTaskCompleteFailure();
		}

	}

	
	public void registerHandler(TaskExecutionHandler handler) {
		this.handler=handler;		// TODO Auto-generated method stub
		
	}

}
