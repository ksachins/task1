package org.cap.demo.controller;

import java.util.List;

import org.cap.demo.Bo.IBo;
import org.cap.demo.Bo.IBoImpl;
import org.cap.demo.healthcheck.HealthCheckEndPoint;
import org.cap.demo.model.Book;
import org.cap.demo.model.BookDTO;
import org.cap.demo.service.MapStruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
  @Autowired
    IBo ibo;
    @Autowired
    MapStruct mapstruct;
    
    Logger logger = LoggerFactory.getLogger(MyController.class);
	@PostMapping("/book")
	public ResponseEntity<Book> sayhello(@RequestBody Book book){
		BookDTO bookdto=mapstruct.bookToBookDTO(book);
		ibo.putBook(bookdto);
		
		
		logger.info("PostMapping:Data is retrieved from database");
		return new ResponseEntity<Book>(book,HttpStatus.OK);
		
	}
	@GetMapping("/book")
	public ResponseEntity<List<Book>> sayhello1(){
				List<BookDTO> book1=ibo.putBook1();
				List<Book> book=mapstruct.bookobj(book1);
			
		logger.info("GetMapping:Data is retrieved from database");
		return new ResponseEntity<List<Book>>(book,HttpStatus.OK);
	
	
	}
	@GetMapping("/healthcheck")
	public ResponseEntity<HealthCheckEndPoint> healthcheck(){
		HealthCheckEndPoint haeHealthCheckEndpoint= ibo.healthcheck();
		logger.info("Postmapping: data is saving in db");
		return new ResponseEntity<HealthCheckEndPoint> (haeHealthCheckEndpoint,HttpStatus.OK);
		//return ResponseEntity.status(HttpStatus.OK).body(haeHealthCheckEndpoint);
	}
		
}
