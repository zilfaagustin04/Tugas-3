package property;

public class Transaction {

    public Student student;
    public Book book;
    public int amount;

    public Transaction(Student student, Book book, int amount) {
        this.student = student;
        this.book = book;
        this.amount = amount;
    }

}

