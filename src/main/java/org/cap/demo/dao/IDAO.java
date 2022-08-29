package org.cap.demo.dao;

import java.util.List;

import org.cap.demo.healthcheck.HealthCheckEndPoint;
import org.cap.demo.model.Book;
import org.cap.demo.model.BookDTO;


public interface IDAO {

	//for post
	public void putBook(BookDTO bookdto);
	//for get
	public List<BookDTO> putBook1();
	public HealthCheckEndPoint healthcheck() throws TableNotAvailableException;
	
}
