class Student {

    private String name;
    private int number;

    private static int counter = 0;

    public static int getCounter(){

        return counter;

    }
   
    //constructor with no arguments just counting 

    public Student(){

        counter++;
    }
    //constructor with 2 argumments: name and number
    public Student(String name,int number){

        this();
        this.name = name;
        this.number = number;
    }


    public String getName(){

        return name;

    }

    public int getNumber(){

        return number;
    }

    public void setName(String name){

        this.name = name;
    }

    public void setNumber(int number){

        this.number = number;
    }
}

public class Administration{

    public static void main (String[] args){
        Student studi = new Student();
        studi.setName("Jane Doe");
        studi.setNumber(292326);
        System.out.println(studi.getName() + " " + studi.getNumber());
        System.out.println("Number of Students: " + Student.getCounter());

        Student studi2 = new Student("John Doe" , 292327);

        
        System.out.println(studi2.getName() + " " + studi2.getNumber());
        System.out.println("Number of Students: " + Student.getCounter());
    }
}
