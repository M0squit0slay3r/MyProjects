public class PatientTest {
    public static void main(String[] args) {
        // Hasta oluşturma
        Patient smith = new Patient("R. Smith", 69);
        Patient jones = new Patient("G. Jones", 45, smith);
        Patient williams = new Patient("J. Williams", 29, jones);

        // Hastaların bilgilerini yazdırma
        System.out.println(smith);
        System.out.println(jones);
        System.out.println(williams);

    }
}

