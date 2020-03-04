package com.xzq.node;


public class NoteMain {


    public static ListNode removeElements(ListNode node, int a) {
        if (node == null) {
            return node;
        }
//        ListNode list = removeElements(node.next, a);
//
//         if (node.val==a){
//             return list;
//         }else {
//             node.next=list;
//             return node;
//         }
        node.next = removeElements(node.next, a);
        return (node.val==a)?node.next:node;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);
        System.out.println(removeElements(head, 6));

//        System.out.println(linkedList.getFirst());
//        System.out.println(linkedList.getLast());
//        System.out.println(linkedList.contains("A1"));
//        linkedList.set(3,"789");
//        System.out.println(linkedList.toString());
//        linkedList.set(1,"789");
//        System.out.println(linkedList.toString());

//        linkedList.remove("789");
//        System.out.println(linkedList.toString());


//        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
//        for (int i = 0; i < 10; i++) {
//            queue.enqueue(i);
//            System.out.println(queue);
//
//            if (i % 3 == 2) {
//                queue.dequeue();
//                System.out.println(queue);
//            }
//        }
    }
}
