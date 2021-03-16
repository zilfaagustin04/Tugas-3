import property.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    static ArrayList<Student> students = new ArrayList<Student>();
    static ArrayList<Book> books = new ArrayList<Book>();
    static ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    static int inParam = 1;
    
    // Main action
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // seed
        students.add(new Student("1", "Zilfa"));
        students.add(new Student("2", "Agustina M"));
        books.add(new Book("1", "Cara 1"));
        books.add(new Book("2", "Cara 2"));
        transactions.add(new Transaction(students.get(0), books.get(0), 1));
        transactions.add(new Transaction(students.get(1), books.get(1), 2));

        //  action
        while(inParam <= 9 && inParam > 0) {
            System.out.println("----- Menu ---- \n1. Tampilkan Data Mahasiswa \n2. Tambah Data Mahasiswa \n3. Hapus Data Mahasiswa \n4. Tampilkan Data Buku \n5. Tambah Data Buku \n6. Hapus Data Buku \n7. Tampilkan Data Transaksi \n8. Tambah Data Transaksi \n9. Hapus Data Transaksi \n");
            System.out.print("Pilih menu : ");
            inParam = Integer.parseInt(scan.nextLine());
            switch(inParam) {
                case 1 :
                    showStudent();
                    break;
                case 2 :
                    addStudent(scan);
                    break;
                case 3 :
                    removeStudent(scan);
                    break;
                case 4 :
                    showBook();
                    break;
                case 5 :
                    addBook(scan);
                    break;
                case 6 :
                    removeBook(scan);
                    break; 
                case 7 :
                    showTransaction();
                    break;
                case 8 :
                    addTransaction(scan);
                    break;
                case 69 :
                    removeTransaction(scan);
                    break; 
                default :
                    inParam = 0;
            }
        }
        scan.close();
    }

    // primary action

    //student
    static void addStudent(Scanner scan) {
        String name;
        String nim;
        System.out.print("Masukan nama : ");
        name = scan.nextLine();
        System.out.print("Masukan nim  : ");
        nim = scan.nextLine();
        students.add(new Student(nim, name));
        System.out.println("Berhasil input data \n");
    }

    static void showStudent() {
        System.out.println("---- Data mahasiswa ----");
        for(int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            System.out.println("----------------------");
            System.out.println("Id   : " + i);
            System.out.println("Nim  : " + student.nim);
            System.out.println("Nama : " + student.name);
            System.out.println("----------------------");
        }
    }

    static void removeStudent(Scanner scan) {
        int id;
        System.out.print("Masukan id murid : ");
        id = Integer.parseInt(scan.nextLine());
        students.remove(id);
        System.out.println("berhasil menghapus");
    }

    // books
    static void addBook(Scanner scan) {
        String title;
        String code;
        System.out.print("Masukan judul : ");
        title = scan.nextLine();
        System.out.print("Masukan kode  : ");
        code = scan.nextLine();
        books.add(new Book(code, title));
        System.out.println("Berhasil input data \n");
    }

    static void showBook() {
        System.out.println("---- Data buku ----");
        for(int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            System.out.println("----------------------");
            System.out.println("Id    : " + i);
            System.out.println("Kode  : " + book.code);
            System.out.println("Judul : " + book.title);
            System.out.println("----------------------");
        }
    }

    static void removeBook(Scanner scan) {
        int id;
        System.out.print("Masukan id buku : ");
        id = Integer.parseInt(scan.nextLine());
        books.remove(id);
        System.out.println("berhasil menghapus");
    }

    // transactions
    static void showTransaction() {
        System.out.println("---- Data transaksi ----");
        for(int i = 0; i < transactions.size(); i++) {
            Transaction tra = transactions.get(i);
            System.out.println("----------------------");
            System.out.println("Id              : " + i);
            System.out.println("Nama mahasiswa  : " + tra.student.name);
            System.out.println("NIM mahasiswa   : " + tra.student.nim);
            System.out.println("Kode nuku       : " + tra.book.code);
            System.out.println("Judul Buku      : " + tra.book.title);
            System.out.println("Jumlah dipinjam : " + tra.amount);
            System.out.println("----------------------");
        }
    }

    static void addTransaction(Scanner scan) {
        int studentId;
        int bookId;
        int amount;
        System.out.println("Input data transaksi");
        System.out.print("Masukan id mahasiswa : ");
        studentId = Integer.parseInt(scan.nextLine());
        System.out.print("Masukan id buku      : ");
        bookId = Integer.parseInt(scan.nextLine());
        System.out.print("Masukan jumlah       : ");
        amount = Integer.parseInt(scan.nextLine());

        // attach
        Student currentStudent = students.get(studentId);
        Book currentBook = books.get(bookId);

        transactions.add(new Transaction(currentStudent, currentBook, amount));
        System.out.println("berhasil menambah transaksi");
        
    }

    static void removeTransaction(Scanner scan) {
        int id;
        System.out.print("Masukan id transaksi : ");
        id = Integer.parseInt(scan.nextLine());
        transactions.remove(id);
        System.out.println("berhasil menghapus transaksi");
    }
    
}