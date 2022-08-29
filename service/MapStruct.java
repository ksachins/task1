package org.cap.demo.service;

import java.util.List;

import org.cap.demo.model.Book;
import org.cap.demo.model.BookDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MapStruct {

		
		   MapStruct INSTANCE=Mappers.getMapper(MapStruct.class);

		    BookDTO bookToBookDTO(Book book);
		    List<BookDTO> bookdtoobj(List<Book> book);
		    List<Book> bookobj(List<BookDTO> bookdto);
		
	}

	

