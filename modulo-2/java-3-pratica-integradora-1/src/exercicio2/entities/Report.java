package exercicio2.entities;

public class Report implements Printable{
    private String text;
    private String author;
    private String reviewer;
    private Integer pageCount;

    public Report(String text, String author, String reviewer, Integer pageCount) {
        this.text = text;
        this.author = author;
        this.reviewer = reviewer;
        this.pageCount = pageCount;
    }

    @Override
    public String toString() {
        return "Report{" +
                "text='" + text + '\'' +
                ", author='" + author + '\'' +
                ", reviewer='" + reviewer + '\'' +
                ", pageCount='" + pageCount + '\'' +
                '}';
    }

    @Override
    public void print() {
        System.out.println(this);
    }
}
