package Output;

import java.util.TreeSet;

public class TestTree {
    public static void main(String[] args) {
        new TestTree().go();
    }

    public void go() {
        Book b1 = new Book("Как устроены кошки");
        Book b2 = new Book("Постройте заново свое тело");
        Book b3 = new Book("В поисках немо");

        TreeSet<Book> treeSet = new TreeSet<Book>();
        treeSet.add(b1);
        treeSet.add(b2);
        treeSet.add(b3);

        System.out.println(treeSet);
    }
}

class Book implements Comparable{
    String title;
    public Book(String title) {
        this.title = title;
    }

    @Override
    public int compareTo(Object o) {
        Book book = (Book) o;
        return (title.compareTo(book.title));
    }
}
