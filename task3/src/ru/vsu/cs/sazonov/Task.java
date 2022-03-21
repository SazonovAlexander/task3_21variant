package ru.vsu.cs.sazonov;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Task {
    public static void nextSimpleQueue(SimpleLinkedListQueue queue1, SimpleLinkedListQueue queue2) throws Exception {
        if ((Integer) queue1.element() > (Integer) queue2.element()) {
            queue1.add(queue1.element());
            queue1.add(queue2.element());
            queue1.remove();
            queue2.remove();
        } else if ((Integer) queue1.element() < (Integer) queue2.element()) {
            queue2.add(queue2.element());
            queue2.add(queue1.element());
            queue2.remove();
            queue1.remove();
        } else disputeSimpleQueue(queue1,queue2);

    }
    public static void disputeSimpleQueue(SimpleLinkedListQueue queue1, SimpleLinkedListQueue queue2) throws Exception {
        if (queue1.count() == 1) {
            queue1.add(queue2.element());
            queue2.remove();
            return;
        }
        if (queue2.count() == 1) {
            queue2.add(queue1.element());
            queue1.remove();
            return;
        }
        SimpleLinkedListQueue disputeSimpleQueue = new SimpleLinkedListQueue();
            while (true) {
                disputeSimpleQueue.add(queue1.element());
                disputeSimpleQueue.add(queue2.element());
                queue1.remove();
                queue2.remove();
                if(queue1.count()!=1 && queue2.count()!=1){
                disputeSimpleQueue.add(queue1.element());
                disputeSimpleQueue.add(queue2.element());
                queue1.remove();
                queue2.remove();
                }
                if(queue1.count()==0){
                    while (!disputeSimpleQueue.empty()) {
                        queue1.add(disputeSimpleQueue.element());
                        disputeSimpleQueue.remove();
                    }
                    return;
                }
                if(queue2.count()==0){
                    while (!disputeSimpleQueue.empty()) {
                        queue2.add(disputeSimpleQueue.element());
                        disputeSimpleQueue.remove();
                    }
                    return;
                }
                if ((Integer) queue1.element() < (Integer) queue2.element()) {
                    while (!disputeSimpleQueue.empty()) {
                        queue2.add(disputeSimpleQueue.element());
                        disputeSimpleQueue.remove();
                    }
                    nextSimpleQueue(queue1, queue2);
                    break;
                } else if ((Integer) queue1.element() > (Integer) queue2.element()) {
                    while (!disputeSimpleQueue.empty()) {
                        queue1.add(disputeSimpleQueue.element());
                        disputeSimpleQueue.remove();
                    }
                    nextSimpleQueue(queue1, queue2);
                    break;
                }
            }

    }
    public static void startSimpleQueue(SimpleLinkedListQueue queue1, SimpleLinkedListQueue queue2){
        List<Integer> list=new ArrayList<>();
        for(int i=6;i<16;i++){
            for (int j=0;j<4;j++){
                list.add(i);
            }
        }
        int index;
        for (int j=0;j<18;j++){
            index=0+(int) (Math.random()*list.size());
            queue1.add(list.get( index));
            list.remove(index);
        }
        for (int j=0;j<18;j++){
            index=0+(int) (Math.random()*list.size());
            queue2.add(list.get( index));
            list.remove(index);
        }
    }

    public static void startQueue(Queue queue1, Queue queue2){
        List<Integer> list=new ArrayList<>();
        for(int i=6;i<16;i++){
            for (int j=0;j<4;j++){
                list.add(i);
            }
        }
        int index;
        for (int j=0;j<18;j++){
            index=0+(int) (Math.random()*list.size());
            queue1.add(list.get( index));
            list.remove(index);
        }
        for (int j=0;j<18;j++){
            index=0+(int) (Math.random()*list.size());
            queue2.add(list.get( index));
            list.remove(index);
        }
    }
    public static void nextQueue(Queue queue1, Queue queue2) throws Exception {
        if ((Integer) queue1.element() > (Integer) queue2.element()) {
            queue1.add(queue1.element());
            queue1.add(queue2.element());
            queue1.remove();
            queue2.remove();
        } else if ((Integer) queue1.element() < (Integer) queue2.element()) {
            queue2.add(queue2.element());
            queue2.add(queue1.element());
            queue2.remove();
            queue1.remove();
        } else disputeQueue(queue1,queue2);

    }
    public static void disputeQueue(Queue queue1, Queue queue2) throws Exception {
        if (sizeQueue(queue1) == 1) {
            queue1.add(queue2.element());
            queue2.remove();
            return;
        }
        if (sizeQueue(queue2)== 1) {
            queue2.add(queue1.element());
            queue1.remove();
            return;
        }
        Queue disputeSimpleQueue = new LinkedList();
        while (true) {
            disputeSimpleQueue.add(queue1.element());
            disputeSimpleQueue.add(queue2.element());
            queue1.remove();
            queue2.remove();
            if(sizeQueue(queue1)!=1 && sizeQueue(queue2)!=1){
                disputeSimpleQueue.add(queue1.element());
                disputeSimpleQueue.add(queue2.element());
                queue1.remove();
                queue2.remove();
            }
            if(sizeQueue(queue1)==0){
                while (!disputeSimpleQueue.isEmpty()) {
                    queue1.add(disputeSimpleQueue.element());
                    disputeSimpleQueue.remove();
                }
                return;
            }
            if(sizeQueue(queue2)==0){
                while (!disputeSimpleQueue.isEmpty()) {
                    queue2.add(disputeSimpleQueue.element());
                    disputeSimpleQueue.remove();
                }
                return;
            }
            if ((Integer) queue1.element() < (Integer) queue2.element()) {
                while (!disputeSimpleQueue.isEmpty()) {
                    queue2.add(disputeSimpleQueue.element());
                    disputeSimpleQueue.remove();
                }
                nextQueue(queue1, queue2);
                break;
            } else if ((Integer) queue1.element() > (Integer) queue2.element()) {
                while (!disputeSimpleQueue.isEmpty()) {
                    queue1.add(disputeSimpleQueue.element());
                    disputeSimpleQueue.remove();
                }
                nextQueue(queue1, queue2);
                break;
            }
        }

    }
        public static int sizeQueue(Queue queue){
        int size=0;
            for (Object a: queue
                 ) {
                size++;
            }
            return size;
        }
}
