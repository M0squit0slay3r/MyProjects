public class Student{
    // instance variables things object knows
    private String name;
    private int number;
    private String degreeProgram; 
    private int yearOfBirth;
    private String gender;

    private static int counter = 0; //static kullaninca butun nesneler icin gecerliligi olusuyor 
                                    // sinif seviyesinde sabit haline gelir nesne olusturulmadan da kullanilabilir her nesne icin ayri ayri olusturulmaz 
// final
    public static final String FEMALE  = "Female"; //public so its accessible by main class Test
    public static final String MALE = "Male";  // sabitler static oldugu icin sinifin parcasidir,
                                               // sinif adiyla erisilmesi gerekir 
                                                // class level constants
//no argument-parameter constructor
    public Student(){
        counter++;
    }
    
// with arguments constructor 
    public Student(String name,
    int number,
    String degreeProgram,
    int yearOfBirth)
    { 

// methods
        this();   // parametresiz constructorı cagirir             
        this.name = name;
        this.number = number;
        this.degreeProgram = degreeProgram;
        this.yearOfBirth = yearOfBirth;
    }
    public static int getCounter() {
        return counter;
    }
    public Student(
        String name, 
        int number, 
        String degreeProgram, 
        int yearOfBirth, 
        String gender)
        {
        this(name, number, degreeProgram, yearOfBirth); // Calls the previous constructor
        this.gender = gender;  // Set gender
    }
        // getter = allows reading the value of a private variable, does not allow external modification 
        // setter = deger atamasi yapilir, konrol mekanizmasi sinrilandirmalar eklenebilir.
    public String getName(){          //get name

        return name;   // getter sadece veriyi korur 

    }
    public void setName(String name){      //set name void 

        this.name = name;  // setterda sinirlama,kontrol ekleyebilirsin 
    }

    public int getNumber(){           // get number

        return number;

    }
    public void setNumber(int number){         // set number

        this.number = number;
    }
 
    public String getDegreeProgram(){                //get degree

        return degreeProgram;
    }
    public void setDegreeProgram(String degreeProgram){        //set degree

        this.degreeProgram = degreeProgram;
    }
    public int getYearOfBirth(){                //get year

        return yearOfBirth;
    }
    public void setYearOfBirth(int yearOfBirth){       //set year

        this.yearOfBirth = yearOfBirth;
    }

    public String getGender(){             //get gender

        return gender;
    }

    public void setGender(String gender){           //set gender

        this.gender = gender;
    }
        
}

