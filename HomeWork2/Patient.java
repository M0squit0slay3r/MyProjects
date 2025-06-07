public class Patient {
    public String name; 
    public int age;
    public int number; 
    public static int followingNumber = 1; 
    public Patient beforeMe; // bcs its referencing to another patient 

    // Constructor 2 argument
    public Patient(String name, int age) {
        this.name = name;
        this.age = age;
        this.number = followingNumber++; 
        this.beforeMe = null; 
    }

    // Constructor 3 argument
    public Patient(String name, int age, Patient beforeMe) {
        this.name = name;
        this.age = age;
        this.number = followingNumber++; 
        this.beforeMe = beforeMe; 
    }

    @Override  // recommended by vscode 
    public String toString() {
        String printText = name + " (" + number + ") ";
        if (beforeMe != null) {
            printText = printText + " comes after " + beforeMe.toString();
        }
        return printText;
    }
}
