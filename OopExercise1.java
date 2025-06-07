public class OopExercise1
{
    public static void main(String[] args) 
    {
        int i;
        double j;
        {
            System.out.println("OOP exercise 1");
            for (i= 0; i< 10; i++) 
            {
                System.out.print(i + " ");    
            }
            // Line 2
            System.out.println();
            for (i= 13; i<= 29; i+= 4)
            {
                System.out.print(i + " ");
            }
            //Line 3
            System.out.println();
            for (j= 2.0; j>= -1.0; j-= 0.5)
            {
                System.out.print(j + " ");
            }
            //Line 4 
            System.out.println();
            for (i= 2000; i<=6000; i+= 1000)
            {
                System.out.print(i + " ");
            }
            //Line 5
            System.out.println();
            for (i= 5; i<= 13; i+= 2)
            {
                System.out.print("Z" + i + " ");    
            }
            //Line 6
            System.out.println();
            for (i= 1; i<= 3; i++)
            {
                System.out.print("a" + " " + "b" + i + " ");
            }
            //Line 7
            System.out.println();
            for (i= 0; i<= 2; i++)
            {
                System.out.print("c" + (i * 10 + 2) + " ");
                System.out.print("c" + (i * 10 + 3) + " ");
            }
            //Line 8
            System.out.println();
            for (i= 13; i<= 45;i+= 4)
            {
                System.out.print(i + " ");

                if (i == 21)
                {
                    i = 29;
                }

            }
            


        }
    }
}