package com.library.demo.bootstrap;

import com.library.demo.model.Author;
import com.library.demo.model.Books;
import com.library.demo.model.Publisher;
import com.library.demo.repositories.AuthorRepository;
import com.library.demo.repositories.BookRepository;
import com.library.demo.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;


    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        init();

    }


    public void init() {
        Publisher publisher = new Publisher();
        publisher.setName("Niru Duwal");
        publisherRepository.save(publisher);

        Author jack = new Author("Jack", "Daniels");
        Books ddd = new Books("1234", "Domain Driver Design", publisher);
        jack.getBooks().add(ddd);
        ddd.getAuthors().add(jack);
        authorRepository.save(jack);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);


        Author eric = new Author("eric", "Evans");
        Books noEJB = new Books("23444", "the girl next door", publisher);
        eric.getBooks().add(noEJB);
        ddd.getAuthors().add(jack);
        authorRepository.save(eric);
        bookRepository.save(noEJB);

    }
}
