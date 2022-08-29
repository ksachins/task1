package org.cap.demo.dao;
import java.util.List;

import org.cap.demo.controller.MyController;
import org.cap.demo.healthcheck.HealthCheckEndPoint;
import org.cap.demo.model.Book;
import org.cap.demo.model.BookDTO;
import org.cap.demo.service.MapStruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class IDAOImpl implements IDAO {
	  @Autowired
    JdbcTemplate jdbctemplate;
    @Autowired
    MapStruct mapstruct;
	
    Logger logger = LoggerFactory.getLogger(IDAOImpl.class);
    @Override
	public void putBook(BookDTO bookdto) {
		jdbctemplate.update("INSERT INTO Book(id,title) VALUES ('"+bookdto.getId()+"','"+bookdto.getTitle()+"')");
		
		logger.info("DAO is retrieved from database");
		
	}

	@Override
	public List<BookDTO> putBook1() {
		List<Book> book=jdbctemplate.query("SELECT * FROM Book", new BeanPropertyRowMapper<Book>(Book.class));
		List<BookDTO> bookdtoobj= mapstruct.bookdtoobj(book);
		
		logger.info("implementing dao");
		return bookdtoobj;
		
	}
	public HealthCheckEndPoint healthcheck() throws TableNotAvailableException {
		
		HealthCheckEndPoint healthcheckendpoint = new HealthCheckEndPoint();
		healthcheckendpoint.setSystemName("check table is available or not");
		try
		{
			if(putBook1()!=null)
			{
				healthcheckendpoint.setSystemCode("Success");
				healthcheckendpoint.setSystemDescription("table is available in db");
			}
		}
		catch(BadSqlGrammarException ex)
		{
			healthcheckendpoint.setSystemCode("failure");
		    healthcheckendpoint.setSystemDescription("table is not available in db");
		    logger.error("Exception in property loading healthcheck");
		}
		return healthcheckendpoint;
	}
	
	
}
