package com.readinglist.readinglist.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.readinglist.readinglist.Book.Book;

public interface ReadingListRepository extends JpaRepository<Book, Long> {
	List<Book> findByReader(String reader);
}
