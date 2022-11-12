import java.util.Scanner;


public class Main {
    public static void main(String[] args)
    {
        LinkList linklist = new LinkList();


        linklist.addNode("Myles",100);
        linklist.addNode("Robin", 200);
        linklist.addNode("Nathan",300);
        linklist.addNode("Isaiah", 400);

        linklist.displayList();
        System.out.println("---------------------");
        linklist.sortList();
        linklist.displayList();

        System.exit(0);
        Scanner scan = new Scanner(System.in);
        String Name;
        int Salary;

        int intValue;

        System.out.println("Hello and welcome to the program, please select an option!");
        System.out.println("1)Add person \n 2)Remove person \n 3)Display list \n 4)Exit");
        intValue = scan.nextInt();

        switch(intValue)
        {
            case 1:
                System.out.println("please enter a person's name and salary");
                Name = scan.nextLine();
                Salary = scan.nextInt();
                linklist.addNode(Name,Salary);
                break;

            case 2:
                //call to remove node
                System.out.println("please enter a person's name so they can be removed");
                Name = scan.nextLine();

                //Salary = scan.nextInt();

                linklist.removeNode(Name);
                break;

            case 3:
                linklist.displayList();
                break;

            case 4:
                break;
        }
    }
}