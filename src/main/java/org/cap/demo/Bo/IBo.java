package org.cap.demo.Bo;
import org.cap.demo.healthcheck.HealthCheckEndPoint;
import java.util.List;

import org.cap.demo.model.Book;
import org.cap.demo.model.BookDTO;

public interface IBo {

	public void putBook(BookDTO bookdto);
	public List<BookDTO> putBook1();
	public HealthCheckEndPoint healthcheck();
}
