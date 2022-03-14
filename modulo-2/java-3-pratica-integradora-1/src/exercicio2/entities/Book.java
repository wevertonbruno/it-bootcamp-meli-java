package exercicio2.entities;

public class Book implements Printable{
    private String title;
    private String author;
    private String genre;
    private Integer pageCount;

    public Book(String title, String author, String genre, Integer pageCount) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.pageCount = pageCount;
    }

    @Override
    public String toString() {
        return "Book{" +
                "pageCount=" + pageCount +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }

    @Override
    public void print() {
        System.out.println(this);
    }
}
