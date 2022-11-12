import java.util.Scanner;


public class Main {
    /**
     * Name: Myles Bennette
     * Course: COSC 2436
     * Section: 901
     * Professor Name: Dr. Basudeb Dash
     * Date:11/11/2022
     * Description:
     *   This class's job is to pass information to the link list class
     * */
    public static void main(String[] args)
    {
        LinkList linklist = new LinkList();
        Scanner scan = new Scanner(System.in);
        String name;
        int salary;

        int intValue =0;

        while(intValue != 6)
        {
            System.out.println("Hello and welcome to the program, please select an option!");
            System.out.println(" 1)Add person \n 2)Remove person \n 3)Sort list \n 4)Reverse list \n 5)Display list \n 6)Exit");
            System.out.print("Enter value: ");
            intValue = scan.nextInt();
            scan.nextLine();

            switch (intValue) {
                case 1:
                    System.out.println("please enter a person's name and salary");
                    System.out.println("Enter name: ");
                    name = scan.nextLine();
                    System.out.println("Enter salary: ");
                    salary = scan.nextInt();

                    scan.nextLine();

                    linklist.addNode(name, salary);
                    break;

                case 2:
                    System.out.println("please enter a person's name so they can be removed");
                    System.out.print("Enter name: ");
                    name = scan.nextLine();
                    if(linklist.removeNode(name))
                    {
                        System.out.println("User is removed");
                    }
                    else
                    {
                        System.out.println("User is not on the list");
                    }
                    break;

                case 3:
                    linklist.sortList();
                    break;

                case 4:
                    linklist.reverseList();
                    break;

                case 5:
                    System.out.println("--------------------");
                    linklist.displayList();
                    System.out.println("--------------------");
                    break;

                case 6:
                    System.exit(0);
                    break;
            }
        }
    }
}