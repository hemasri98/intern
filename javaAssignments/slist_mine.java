//public class SList {
//    Node head = null;
//    SListIterator iterator() {
//        return new SListIterator(head);
//    }
//
//    public String toString() {
//        String listOfNodes = "";
//        if (head == null) {
//            return "It is an Empty list";
//        }
//        SListIterator iterator = this.iterator();
//        //System.out.println(this);
//        while (iterator.hasNext()) {
//            listOfNodes += iterator.next().data + ", ";
//        }
//        return listOfNodes;
//    }
//    public static void main(String[]args) {
//        SList s = new SList();
//        s.toString();
//    }
//}
//class Node {
//    String data;
//    Node next = null;
//    Node(String data) {
//        this.data = data;
//    }
//    public String toString() {
//        if (data==null)
//            return "null";
//        return data;
//    }
//}
//
//class SListIterator {
//    Node head;
//    SListIterator(Node head) {
//        this.head = head;
//    }
//
//    public String data() {
//    	return head.data;
//    }
//
//    public boolean hasNext() {
//        Node temp = head;
//        if(temp != null){
//            if(temp.next != null) {
//                return true;
//            }
//        }
//        return false;
//    }
//    public Node next() {
//        Node temp = head;
//        if(temp != null){
//            if(temp.next != null) {
//                temp = temp.next;
//                return temp;
//            }
//        }
//        return temp;
//    }
//
//    public Node insertLast(String data) {
//        if(head != null) {
//            Node temp = head;
//            while(temp.next != null) {
//                temp = temp.next;
//            }
//            temp.next = new Node(data);
//        }
//        else {
//            head = new Node(data);
//        }
//        return head;
//    }
//
//    public Node insertFirst(String data) {
//        if(head != null) {
//            Node temp = new Node(data);
//            temp.next = head;
//        }
//        else {
//            head = new Node(data);
//        }
//        return head;
//    }
//
//    public Node deleteFirst() {
//        if(head != null) {
//           head = head.next;
//        }
//        return head;
//    }
//
//    public Node deleteLast() {
//        if(head != null) {
//            Node prev = null;
//            Node curr = head;
//            while(curr.next != null) {
//                prev = curr;
//                curr = curr.next;
//            }
//           prev.next = null;
//        }
//        return head;
//    }
//
//    public Node deleteAfter(int position) {
//        int count = 0;
//        if(head != null) {
//            Node prev = null;
//            Node curr = head;
//            while(curr.next != null && count != position) {
//                prev = curr;
//                curr = curr.next;
//                count = count + 1;
//            }
//            if(count == position)
//                prev.next = curr.next;
//        }
//        return head;
//    }
//}
//
//class Assignment10 {
//    public static void main(String[] args) {
//        SList sList=new SList();
//        SListIterator sListIterator1=sList.iterator();
//        System.out.println(sList);
//        sListIterator1.insertLast("1");
//        sListIterator1.insertLast("2");
//       // System.out.println(sListIterator1);
//        System.out.println(sList);
////        SListIterator sListIterator2=sList.iterator();
////        sListIterator2.delete();
////        System.out.println(sList);
//    }
//}

