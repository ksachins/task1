package org.cap.demo.Eo;

import java.util.List;

import org.cap.demo.healthcheck.HealthCheckEndPoint;
import org.cap.demo.model.Book;
import org.cap.demo.model.BookDTO;

public interface IEo {

		public void putBook(BookDTO bookdto);
		public List<BookDTO> putBook1();
		public HealthCheckEndPoint healthcheck();

}
