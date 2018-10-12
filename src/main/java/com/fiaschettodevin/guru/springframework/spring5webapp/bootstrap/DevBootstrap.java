package com.fiaschettodevin.guru.springframework.spring5webapp.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.fiaschettodevin.guru.springframework.spring5webapp.model.Author;
import com.fiaschettodevin.guru.springframework.spring5webapp.model.Book;
import com.fiaschettodevin.guru.springframework.spring5webapp.repository.AuthorRepository;
import com.fiaschettodevin.guru.springframework.spring5webapp.repository.BookRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private BookRepository bookRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		this.init();
	}

	private void init() {

		Author a1 = new Author("pippo", "pippo");
		Book b1 = new Book("aaa", "bbb", "cccc");
		a1.getBooks().add(b1);
		b1.getAuthors().add(a1);

		this.authorRepository.save(a1);
		this.bookRepository.save(b1);

	}
}
