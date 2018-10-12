package com.fiaschettodevin.guru.springframework.spring5webapp.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.fiaschettodevin.guru.springframework.spring5webapp.model.Author;
import com.fiaschettodevin.guru.springframework.spring5webapp.model.Book;
import com.fiaschettodevin.guru.springframework.spring5webapp.model.Publisher;
import com.fiaschettodevin.guru.springframework.spring5webapp.repository.AuthorRepository;
import com.fiaschettodevin.guru.springframework.spring5webapp.repository.BookRepository;
import com.fiaschettodevin.guru.springframework.spring5webapp.repository.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private PublisherRepository publisherRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		this.init();
	}

	private void init() {

		Publisher p1 = new Publisher("topolino", "via via");
		Author a1 = new Author("pippo", "pippo");
		Book b1 = new Book("aaa", "bbb");

		a1.getBooks().add(b1);
		b1.getAuthors().add(a1);
		b1.setPublisher(p1);

		this.authorRepository.save(a1);
		this.bookRepository.save(b1);

	}
}
