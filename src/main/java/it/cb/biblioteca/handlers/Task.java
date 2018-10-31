package it.cb.biblioteca.handlers;

public interface Task {
	void execute();
	
	void registerHandler(TaskExecutionHandler handler);
}
