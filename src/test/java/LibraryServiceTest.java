import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LibraryServiceTest {

    private PaymentService paymentService;
    private LibraryService libraryService;
    private BookReviews bookReviews;

    @BeforeEach
    void setUp() {

        paymentService = mock(PaymentService.class);

        libraryService = new LibraryService(paymentService, bookReviews);


    }

    @BeforeAll
    public static void addBooks (){

        Bookshelf book1 = new Bookshelf(1,true,"frankenstein","mary shelley", "horror","1 januari 1818", 0);
        Bookshelf book2 = new Bookshelf(2, false, "moby dick","herman melville", "novel","18 October 1851",5);
        Bookshelf book3 = new Bookshelf(3, false, "hamlet","william shakespeare", "drama","1 januari 1603",0);

        Bookshelf.addBook(book1);
        Bookshelf.addBook(book2);
        Bookshelf.addBook(book3);

    }

    @Test
    void should_getBookName_when_getBookNameById2(){

        String expected = "moby dick";
        String actual = Bookshelf.getBookNameById(2);

        assertEquals(expected,actual);

    }

    @Test
    void should_findBook_When_searchByNameDick(){

        String actual = Bookshelf.searchByName("Dick");
        String expected = "moby dick";

        assertEquals(expected,actual);

    }

    @Test
    void should_findBook_When_searchByAuthorShakespeare(){

        String actual = Bookshelf.searchByAuthor("Shakespeare");
        String expected = "hamlet";

        assertEquals(expected,actual);

    }

    @Test
    void should_findBook_When_searchByGenreHorror(){

        String actual = Bookshelf.searchByGenre("horror");
        String expected = "frankenstein";

        assertEquals(expected,actual);

    }

    @Test
    void should_findBook_When_searchByReleaseDate1603(){

        String actual = Bookshelf.searchByReleaseDate("1603");
        String expected = "hamlet";

        assertEquals(expected,actual);

    }

    @Test
    void should_findBook_When_searchByRating5(){

        String actual = Bookshelf.searchByRating(5);
        String expected = "moby dick";

        assertEquals(expected,actual);


    }

    @Test
    void should_makeBookUnavailable_When_costumerPaysFee(){

        when(paymentService.getBookPrice()).thenReturn(100);

        int costumer = 300;

        costumer = costumer - paymentService.getBookPrice();

        assertEquals(200,costumer);



        Boolean available = Bookshelf.borrowBook("frankenstein");

        // If book is available after payment
        System.out.print(available);

        assertFalse(available);


    }

    @Test
    void should_beAbleToLeaveAComment_When_bookisPaid(){

        Bookshelf.reviewBook(1, "It was a great book");

        String response = BookReviews.userReviews.get(0);

        System.out.print(response);
        assertNotNull(response);


    }









}