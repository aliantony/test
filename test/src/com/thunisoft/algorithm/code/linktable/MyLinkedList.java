package com.thunisoft.algorithm.code.linktable;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> {
    
    // ～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～
    private final DNode<T> header;
    
    private int listSize;
    
    // ～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～
    public MyLinkedList() {
        header = new DNode<T>();
        listSize = 0;
    }
    
    // ～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～
    private static class DNode<T> {
        
        T nodeValue;
        
        DNode<T> prev;
        
        DNode<T> next;
        
        public DNode() { // for header
            nodeValue = null;
            prev = this; // left
            next = this; // right
        }
        
        public DNode(T item) {
            nodeValue = item;
            prev = this;
            next = this;
        }
    }
    
    // ～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～
    public boolean isEmpty() {
        return (header.prev == header || header.next == header);
    }
    
    public int size() {
        return listSize;
    }
    
    // ～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～
    private DNode<T> addBefore(DNode<T> curr, T item) {
        DNode<T> newNode, prevNode;
        newNode = new DNode<T>(item);
        
        prevNode = curr.prev; // 当前元素的前一个
        
        newNode.prev = prevNode;// 新节点指向当前元素的前一个
        newNode.next = curr;// 新节点的下一个指向当前元素
        
        prevNode.next = newNode;// 当前元素前一个的下一个指向新节点
        curr.prev = newNode; // prev<<-curr<<-next
        // prev->>newnode->>curr->>next
        return newNode;
    }
    
    public boolean add(T item) {
        addBefore(header, item);
        listSize++;
        return true;
    }
    
    public void addFirst(T item) {
        addBefore(header.next, item);
        listSize++;
    }
    
    public void addLast(T item) {
        addBefore(header, item);
        listSize++;
    }
    
    // ～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～
    private void remove(DNode<T> curr) {
        if (curr.next == curr) {
            return;
        }
        
        DNode<T> prevNode = curr.prev, nextNode = curr.next;
        
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
    
    public boolean remove(Object o) {
        for (DNode<T> p = header.next; p != header; p = p.next) {
            if (o.equals(p.nodeValue)) {
                remove(p);
                listSize--;
                return true;
            }
        }
        return false;
    }
    
    // ～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～
    public void printList() {
        for (DNode<T> p = header.next; p != header; p = p.next) {
            System.out.println(p.nodeValue);
        }
    }
    
    // ～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～
    private class MyIterator implements Iterator<T> {
        
        public DNode<T> nextNode = header.next;
        
        public DNode<T> lastReturned = header;// 从链头开始取，取走一个，链头下一个作为新的链头
        
        @Override
        public boolean hasNext() {
            return nextNode != header;
        }
        
        @Override
        public T next() {
            if (nextNode == header) {
                throw new NoSuchElementException("");
            }
            
            lastReturned = nextNode;
            nextNode = nextNode.next;
            return lastReturned.nodeValue;
        }
        
        @Override
        public void remove() {
            if (lastReturned == header) {
                throw new IllegalStateException("");
            }
            
            MyLinkedList.this.remove(lastReturned);
            lastReturned = header;
            listSize--;
        }
    }
    
    // ～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～
    private class MyListIterator extends MyIterator implements ListIterator<T> {
        
        private int nextIndex;
        
        MyListIterator(int index) {
            if (index < 0 || index > listSize) {
                throw new IndexOutOfBoundsException("");
            }
            
            // 如果index小于listSize/2，就从表头开始查找定位，否则就从表尾开始查找定位
            if (index < (listSize >> 1)) {
                nextNode = header.next;
                for (nextIndex = 0; nextIndex < index; nextIndex++) {
                    nextNode = nextNode.next;
                }
            }
            else {
                nextNode = header;
                for (nextIndex = listSize; nextIndex > index; nextIndex--) {
                    nextNode = nextNode.prev;
                }
            }
        }
        
        @Override
        public boolean hasPrevious() {
            return nextIndex != 0;
            // return nextNode.prev != header;
        }
        
        @Override
        public T previous() {
            if (nextIndex == 0) {
                throw new NoSuchElementException("no");
            }
            
            lastReturned = nextNode = nextNode.prev;
            nextIndex--;
            return lastReturned.nodeValue;
        }
        
        @Override
        public void remove() {
            if (lastReturned == header) {
                throw new IllegalStateException("");
            }
            
            MyLinkedList.this.remove(lastReturned);
            nextIndex--;
            listSize--;
            
            if (lastReturned == nextNode) {
                nextNode = nextNode.next;
            }
            lastReturned = header;
        }
        
        @Override
        public void add(T item) {
            MyLinkedList.this.addBefore(nextNode, item);
            nextIndex++;
            listSize++;
            lastReturned = header;
        }
        
        @Override
        public void set(T item) {
            if (lastReturned == header) {
                throw new IllegalStateException();
            }
            
            lastReturned.nodeValue = item;
        }
        
        @Override
        public int nextIndex() {
            return nextIndex;
        }
        
        @Override
        public int previousIndex() {
            return nextIndex - 1;
        }
    }
    
    // ～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～
    public Iterator<T> iterator() {
        return new MyIterator();
    }
    
    // ～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～
    public ListIterator<T> listIterator(int index) {
        return new MyListIterator(index);
    }
    
    // ～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～～
    public static void main(String[] args) {
        MyLinkedList<String> t = new MyLinkedList<String>();
        t.add("A");
        t.add("B");
        t.add("C");
        t.add("D");
        // t.remove("B");
        // t.addFirst("AA");
        // t.addLast("BB");
        // t.printList();
        
        ListIterator<String> it = t.listIterator(t.size());
        
        while (it.hasPrevious()) {
            System.out.println(it.previous()); // D C B A
        }
    }
}// MyLinkedList end～

