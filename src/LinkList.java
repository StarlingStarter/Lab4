/**
 * Name: Myles Bennette
 * Course: COSC 2436
 * Section: 901
 * Professor Name: Dr. Basudeb Dash
 * Date:11/11/2022
 * Description:
 *   This class's job is to take the information given by the user from main.
 *   Then based off the user's response add a new person to the list, remove a person from the list, sort the list in alphabetical order, sort the list in reverse order.
 *   Finally, display the list of the users that have been added.
 * */
public class LinkList
{
    Node head;
    Node tail;
    LinkList()
    {
        head = null;
        tail = null;
    }


    public boolean isEmpty()
    {
        return head == null;
    }

    public int sizeList()
    {
        int count = 0;
        Node refVar = head;

        if(isEmpty())
        {
            return 0;
        }
        else
        {
            while(refVar != null)
            {
                refVar = refVar.next;
                count++;
            }
            return count;
        }
    }

    public void addNode(String strVal, int intVal)
    {
        if(isEmpty())
        {
            head = new Node(strVal, intVal);
            tail = head;
        }
        else
        {
            Node storageVar = new Node(strVal, intVal, tail.next, tail);
            tail.next = storageVar;
            tail = storageVar;
        }
    }

    public boolean removeNode(String removeVar)
    {
        if(isEmpty())
        {
            return false;
        }

        Node refVar = head;

        while(refVar != null && !refVar.name.equals(removeVar))
        {
           refVar= refVar.next;
        }

        if(refVar == null)
        {
            return false;
        }

        if(refVar.prev == null && refVar.next == null)
        {
            head = null;
            tail = null;
        }
        else if(refVar.prev == null)
        {
            head = refVar.next;
            head.prev = null;
        }else if(refVar.next == null)
        {
            tail = refVar.prev;
            tail.next = null;
        }
        else
        {
              refVar.prev.next = refVar.next;
              refVar.next.prev = refVar.prev;
        }

        return true;
    }

    public void sortList()
    {
        for(Node a = tail; a.prev != null; a = a.prev)
        {
            for(Node i = head; i != a; i = i.next )
            {
                if(i.name.compareTo(i.next.name) > 0)
                {
                    String tempName = i.name;
                    int tempSalary = i.payment;

                    i.name = i.next.name;
                    i.payment = i.next.payment;

                    i.next.name = tempName;
                    i.next.payment = tempSalary;
                }
            }
        }
    }

    public void reverseList()
    {
        head = tail;
        Node refVar = tail;
        Node tempVar;

        while (refVar != null) {
            tempVar = refVar.prev;
            refVar.prev = refVar.next;
            refVar.next = tempVar;

            if (refVar.next == null)
            {
                tail = refVar;
            }

            refVar = tempVar;
        }
    }

    public void displayList()
    {
        Node refVar = head;

        while(refVar != null)
        {
            System.out.println("Employee: "+refVar.name + " $" + refVar.payment);
            refVar = refVar.next;
        }
    }
}

class Node
{
    String name;
    int payment;
    Node next;
    Node prev;

    Node(String strVal, int intVal, Node n, Node p)
    {
        name = strVal;
        payment = intVal;
        next = n;
        prev = p;
    }
    Node(String strVal, int intVal)
    {
        name = strVal;
        payment = intVal;
        next = null;
        prev = null;
    }
}