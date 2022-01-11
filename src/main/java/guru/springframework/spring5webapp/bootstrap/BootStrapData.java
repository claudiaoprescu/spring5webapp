package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.BookRepository;
import guru.springframework.spring5webapp.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher cluj = new Publisher("Strada Sperantei nr 5", "Cluj", "Romania", "353445");

        publisherRepository.save(cluj);
        
        Author rebreanu = new Author("Liviu", "Rebreanu");
        Book ion = new Book("Ion", "11111132123");
        rebreanu.getBooks().add(ion);
        ion.getAuthors().add(rebreanu);
        ion.setPublisher(cluj);

        authorRepository.save(rebreanu);
        bookRepository.save(ion);

        Author king = new Author("Stephen", "King");
        Book it = new Book("IT", "3534534646");
        king.getBooks().add(it);
        it.getAuthors().add(king);
        it.setPublisher(cluj);

        authorRepository.save(king);
        bookRepository.save(it);

        cluj.getBooks().add(ion);
        cluj.getBooks().add(it);

        publisherRepository.save(cluj);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Publishers: " + publisherRepository.count());
        System.out.println("Number of Books for Publisher Cluj: " + cluj.getBooks().size());
    }
}
