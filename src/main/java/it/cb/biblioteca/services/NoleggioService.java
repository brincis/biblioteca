package it.cb.biblioteca.services;

import java.time.LocalDate;
import java.util.List;

import it.cb.biblioteca.dao.NoleggioDao;
import it.cb.biblioteca.exceptions.DataException;
import it.cb.biblioteca.handlers.SimpleTaskImpl;
import it.cb.biblioteca.handlers.TaskExecutionHandler;
import it.cb.biblioteca.model.UtenteVo;

public class NoleggioService {

	public int noleggiaLibroById(int idlibro, UtenteVo currentUser) throws DataException {
		LocalDate datainizio = LocalDate.now();
		NoleggioDao nd = new NoleggioDao();
		return nd.noleggiaLibroById(idlibro,datainizio,currentUser.getId());		 
	}
	
	public void numeroNoleggiTerminati() {
		SimpleTaskImpl currentTask = new SimpleTaskImpl();
		currentTask.registerHandler(handler);
		currentTask.execute();
	} 
	
	
	private TaskExecutionHandler handler = new TaskExecutionHandler() {

		@Override
		public void onTaskCompleteSuccess(String message, List<Integer> idRecordNoleggiTerminati) {
			// TODO rilascia messaggio di numero record eliminati all'handler
			System.out.println(message + " idNoleggio: "+idRecordNoleggiTerminati.toString());
		}
			
		

		@Override
		public void onTaskCompleteFailure() {
			// TODO rilascia messaggio di numero record eliminati all'handler
			
		}
	};
		

}
