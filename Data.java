public class Data {
    private String name;
    private int frek;
    private Linkedlist judul = new Linkedlist();

    public Data(String name) {
        this.name = name;
        this.frek = 1;
    }

    public String getName() {
        return this.name;
    }    

    public int getFreq() {
        return this.frek;
    }

    public void addFreq() {
        this.frek++;
    }

    public void addJudul(String artikel){
        judul.add(artikel);
    }

    public void getJudul() {
        Node current = judul.getHead();
        int i = 1;
        while(current != null){
            System.out.println(i+". "+current.getData().getName());
            if(current.getNext() == null){
                break;
            }
            current = current.getNext();
            i++;
        }
    }
}