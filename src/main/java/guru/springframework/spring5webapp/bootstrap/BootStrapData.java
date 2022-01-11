package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author rebreanu = new Author("Liviu", "Rebreanu");
        Book ion = new Book("Ion", "11111132123");
        rebreanu.getBooks().add(ion);
        ion.getAuthors().add(rebreanu);

        authorRepository.save(rebreanu);
        bookRepository.save(ion);

        Author king = new Author("Stephen", "King");
        Book it = new Book("IT", "3534534646");
        king.getBooks().add(it);
        it.getAuthors().add(king);

        authorRepository.save(king);
        bookRepository.save(it);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
    }
}