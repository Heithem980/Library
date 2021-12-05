public class LibraryService {

    private PaymentService paymentService;
    private BookReviews bookReviews;


    public LibraryService(PaymentService paymentService, BookReviews bookReviews) {
        this.paymentService = paymentService;
        this.bookReviews = bookReviews;
    }

    public PaymentService getPaymentService() {
        return paymentService;
    }

    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public BookReviews getBookReviews() {
        return bookReviews;
    }

    public void setBookReviews(BookReviews bookReviews) {
        this.bookReviews = bookReviews;
    }





}
