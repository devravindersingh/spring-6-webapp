package com.project.ravinder.spring6webapp.bootstrap;

import com.project.ravinder.spring6webapp.domain.Author;
import com.project.ravinder.spring6webapp.domain.Book;
import com.project.ravinder.spring6webapp.domain.Publisher;
import com.project.ravinder.spring6webapp.repositories.AuthorRepository;
import com.project.ravinder.spring6webapp.repositories.BookRepository;
import com.project.ravinder.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Book ddd = new Book();
        ddd.setTittle("Domain Driven Design");
        ddd.setIsbn("123456");

        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);

        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        Book noEJB = new Book();
        noEJB.setTittle("J2EE Development without EJB");
        noEJB.setIsbn("54757585");

        Author rodSaved = authorRepository.save(rod);
        Book noEJBSaved = bookRepository.save(noEJB);

        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEJBSaved);

        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);

        System.out.println("-------------------------------------------------------------");
        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Books Count: "+ bookRepository.count());
        System.out.println("-------------------------------------------------------------");

        Publisher publisher = new Publisher();
        publisher.setPublisherName("My Publisher");
        publisher.setAddress("123 Main Street");
        publisher.setCity("California");
        publisher.setState("itsState");
        publisher.setZip("12345");

        publisherRepository.save(publisher);

        System.out.println("-------------------------------------------------------------");
        System.out.println("Publisher Count: " + publisherRepository.count());
        System.out.println("-------------------------------------------------------------");

    }
}
