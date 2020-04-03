
public class Linkedlist {

    private Node head;
    private int size;

    public Linkedlist() {
        this.head = null;
        this.size = 0;
    }

    public void setHead(Node head) {
        this.head = head;
        this.incSize();
    }

    public void incSize() {
        this.size++;
    }

    public void decSize() {
        this.size--;
    }

    public int Size() {
        return this.size;
    }

    public Node getHead() {
        return this.head;
    }

    public void add(String editor) {
        Node isFound = this.searchData(editor);

        if (isFound == null) {
            this.setHead(new Node(new Data(editor), this.getHead()));
        } else {
            isFound.getData().addFreq();
        }

    }

    public void display() {
        Node current = this.getHead();

        while (current != null) {
            System.out.println(current.getData().getName() + ", " + current.getData().getFreq() + " artikel");
            if (current.getNext() == null)
                break;
            current = current.getNext();
        }
    }

    public Node searchData(String editor) {
        Node current = this.getHead();

        while (current != null) {
            if (current.getData().getName().equals(editor))
                return current;
            if (current.getNext() == null)
                break;
            current = current.getNext();
        }

        return null;
    }

    public String fetchData(String editor) {
        Node isFound = this.searchData(editor);

        if (isFound != null) {
            return isFound.getData().getName() + " ditemukan dengan total artikel yang diedit adalah "
                    + isFound.getData().getFreq() + ".";
        } else {
            return "Nama dari " + editor + " tidak ditemukan.";
        }
    }

    public void sort() {
        Node current = this.getHead();
        Data tempData;
        while (current.getNext() != null) {
            while (current.getData().getName().compareTo(current.getNext().getData().getName()) > 0) {
                tempData = current.getNext().getData();
                current.getNext().setData(current.getData());
                current.setData(tempData);
                current = this.getHead();
            }
            current = current.getNext();
        }
    }

    public void menubaru(String editor) {
        Node isFound = this.searchData(editor);

        if (isFound != null) {
            System.out.println(isFound.getData().getName() + " mengedit " + isFound.getData().getFreq() + " artikel.");
            isFound.getData().getJudul();

        } else {
            System.out.println("Data " + editor + " tidak ditemukan.");
        }
    }

    public void searchContainsEditor(String editor) {
        Node current = this.getHead();

        while (current != null) {
            if (current.getData().getName().toLowerCase().contains(editor.toLowerCase())) {
                System.out.println(
                        current.getData().getName() + " ditemukan dengan " + current.getData().getFreq() + " artikel.");
            }
            if (current.getNext() == null) {
                break;
            }
            current = current.getNext();
        }
    }
}
