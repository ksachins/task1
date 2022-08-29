package org.cap.demo.Bo;


import java.util.List;

import org.cap.demo.Eo.IEo;
import org.cap.demo.dao.IDAOImpl;
import org.cap.demo.healthcheck.HealthCheckEndPoint;
import org.cap.demo.model.Book;
import org.cap.demo.model.BookDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class IBoImpl implements IBo {
   @Autowired
    IEo ieo;
   Logger logger = LoggerFactory.getLogger(IBoImpl.class);
	@Override
	public void putBook(BookDTO bookdto) {
		ieo.putBook(bookdto);
		
		logger.info("IBO is retrieved from database");
		
	}
	@Override
	public List<BookDTO> putBook1() {
		logger.info("IBOImpl implementation");
		return ieo.putBook1();
	}
	
	public HealthCheckEndPoint healthcheck() {
		
		HealthCheckEndPoint healthcheckendpoint=  new HealthCheckEndPoint();
		healthcheckendpoint= ieo.healthcheck();
		return healthcheckendpoint;
	}

}
