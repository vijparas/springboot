package in.paras.springwebapp.bootstrap;

import in.paras.springwebapp.model.Author;
import in.paras.springwebapp.model.Book;
import in.paras.springwebapp.model.Publisher;
import in.paras.springwebapp.repositories.AuthorRepository;
import in.paras.springwebapp.repositories.BookRepository;
import in.paras.springwebapp.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {


    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;
    public DevBootStrap(AuthorRepository authorRepository,BookRepository bookRepository,PublisherRepository publisherRepository){
        this.authorRepository=authorRepository;
        this.bookRepository=bookRepository;
        this.publisherRepository=publisherRepository;
    }
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
            initData();
    }

    public void initData(){
        Publisher publisher=new Publisher("MBD","Delhi");
        publisherRepository.save(publisher);
        Author author=new Author("Paras","Vij");
        Book ddd=new Book("Hello",publisher,"1234567");
        author.getBooks().add(ddd);
        ddd.getAuthors().add(author);
        authorRepository.save(author);
        bookRepository.save(ddd);
    }
}
