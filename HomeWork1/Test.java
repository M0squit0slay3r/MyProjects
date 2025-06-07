public class Test {
    public static void main(String[] args) {
        
        Student studi = new Student("Jane Doe", 292326, "Computer Science", 2000, Student.FEMALE);
        System.out.println(studi.getName() + " " + studi.getNumber() + " " + studi.getDegreeProgram() + " "
                           + studi.getYearOfBirth() + " " + studi.getGender());
        System.out.println("Number of Students: " + Student.getCounter());

       
        Student studi2 = new Student("John Doe", 292327, "Business", 1999, Student.MALE);
        System.out.println(studi2.getName() + " " + studi2.getNumber() + " " + studi2.getDegreeProgram() + " "
                           + studi2.getYearOfBirth() + " " + studi2.getGender());
        System.out.println("Number of Students: " + Student.getCounter());
    }
}
