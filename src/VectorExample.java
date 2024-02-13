import java.util.Vector;

public class VectorExample {
    public static void main(String[] args) {
        // Vector oluşturma
        Vector<String> vector = new Vector<>();

        // Eleman ekleme
        vector.add("Java");
        vector.add("Python");
        vector.add("C++");

        // Elemanları yazdırma
        System.out.println("Vector içeriği:");
        for (String str : vector) {
            System.out.println(str);
        }

        // Eleman sayısını alma
        System.out.println("Vector'deki eleman sayısı: " + vector.size());

        // Belirli bir indeksteki elemanı alma
        String eleman = vector.get(1);
        System.out.println("İndeks 1'deki eleman: " + eleman);

        // Belirli bir elemanın indeksini alma
        int indeks = vector.indexOf("Python");
        System.out.println("Python elemanının indeksi: " + indeks);

        // Belirli bir indeksteki elemanı silme
        vector.removeFirst();
        System.out.println("İndeks 0'daki eleman silindi.");

        // Elemanları tekrar yazdırma
        System.out.println("Güncellenmiş Vector içeriği:");
        for (String str : vector) {
            System.out.println(str);
        }
        System.out.println("Güncellenmiş Vector'deki eleman sayısı: " + vector.size());
    }
}
