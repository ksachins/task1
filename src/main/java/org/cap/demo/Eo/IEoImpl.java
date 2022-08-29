package org.cap.demo.Eo;

import java.util.List;

import org.cap.demo.dao.IDAO;
import org.cap.demo.dao.IDAOImpl;
import org.cap.demo.healthcheck.HealthCheckEndPoint;
import org.cap.demo.model.Book;
import org.cap.demo.model.BookDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class IEoImpl implements IEo{
   @Autowired
    IDAO idao;
   Logger logger = LoggerFactory.getLogger(IEoImpl.class);
	@Override
	public void putBook(BookDTO bookdto) {
		idao.putBook(bookdto);
		
		logger.info("EO Data is retrieved from database");
		
	}
	@Override
	public List<BookDTO> putBook1() {
		logger.info("IEo implementation");
		return idao.putBook1();
		
	}
	public  HealthCheckEndPoint healthcheck() {
		HealthCheckEndPoint healthcheckendpoint = new HealthCheckEndPoint();
		healthcheckendpoint= idao.healthcheck();
		return healthcheckendpoint;
		
	}

}
