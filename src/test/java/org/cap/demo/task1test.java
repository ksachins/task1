package org.cap.demo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.cap.demo.Bo.IBo;
import org.cap.demo.model.BookDTO;
import org.h2.command.dml.MergeUsing.When;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
@AutoConfigureMockMvc
@SpringBootTest
public class task1test {
@Autowired
MockMvc mvc;
@Autowired
ObjectMapper obj;
	@MockBean
	IBo bookDbService;
	
	@Test
	public void createtask1test() throws Exception
	{
		BookDTO book=new BookDTO();
		book.setId(1);
		book.setTitle("kamakshi");
		String jsonRequest = obj.writeValueAsString(book);
		
		bookDbService.putBook(any());
		mvc.perform(post("/book").content(jsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE)
				.accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void getBookTest() throws Exception
	{
		BookDTO book=new BookDTO();
		book.setId(1);
		book.setTitle("Kamakshi");
		List<BookDTO> book1=Arrays.asList(book);
		when(bookDbService.putBook1()).thenReturn(book1);
		mvc.perform(get("/book")).andExpect(status().isOk());
		assertEquals("Kamakshi",book.getTitle());
	}
}

