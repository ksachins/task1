package org.cap.demo.dao;

public class TableNotAvailableException extends RuntimeException {
	public TableNotAvailableException(String message) {
	super("table not available ");
	}
}
