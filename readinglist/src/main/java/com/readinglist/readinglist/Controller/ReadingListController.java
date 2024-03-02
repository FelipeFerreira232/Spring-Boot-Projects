package com.readinglist.readinglist.Controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.readinglist.readinglist.Book.Book;
import com.readinglist.readinglist.Repository.ReadingListRepository;

@Controller
@RequestMapping("/")
public class ReadingListController {
	
	private ReadingListRepository readingListRepository;
	
	public ReadingListController(ReadingListRepository readingListRepository) {
		super();
		this.readingListRepository = readingListRepository;
	}


	@RequestMapping(value="reader", method=RequestMethod.GET)
	public String readerBooks(@PathVariable("reader") String reader, Model model) {
		List<Book> readingList = readingListRepository.findByReader(reader);
		
		if(readingListRepository != null) {
			model.addAttribute("books", readingList);
		}
		return "readingList";
	}
	
	@RequestMapping(value="reader", method=RequestMethod.POST)
	public String addToReadingList(@PathVariable("reader") String reader, Book book) {
		book.setReader(reader);
		readingListRepository.save(book);
		return "redirect:reader";
	}
}
