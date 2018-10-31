package it.cb.biblioteca.handlers;

import java.util.List;

public interface TaskExecutionHandler {

	void onTaskCompleteSuccess(String message, List<Integer> idRecordNoleggiTerminati);
	void onTaskCompleteFailure();

}
