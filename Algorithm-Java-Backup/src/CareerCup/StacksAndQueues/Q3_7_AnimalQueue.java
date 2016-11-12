/**
 * Sanqiang Zhao Www.131X.Com Jan 4, 2013
 */
package CareerCup.StacksAndQueues;

import java.util.LinkedList;

public class Q3_7_AnimalQueue {

    public abstract class Animal {

        public String name;
        public int order;
    }

    public class Dog extends Animal {
    }

    public class Cat extends Animal {
    }

    public class AnimalQueue {

        LinkedList<Dog> dogs = new LinkedList<>();
        LinkedList<Cat> cats = new LinkedList<>();
        private int order = 0;

        public void enqueue(Animal animal) {
            animal.order = this.order++;
            if (animal instanceof Dog) {
                dogs.add((Dog) animal);
            } else if (animal instanceof Cat) {
                cats.add((Cat) animal);
            }
        }

        public Cat dequeueCat() {
            return cats.poll();
        }

        public Dog dequeueDog() {
            return dogs.poll();
        }

        public Animal dequeue() {
            if (dogs.isEmpty()) {
                return dequeueCat();
            } else if (cats.isEmpty()) {
                return dequeueDog();
            }
            if (dogs.peek().order < cats.peek().order) {
                return dequeueDog();
            } else {
                return dequeueCat();
            }
        }
    }

    public static void main(String[] args) {
        LinkedList<Character> ll = new LinkedList<>();
        ll.add('a');
        ll.add('b');
        ll.add('c');
        ll.add('d');
        ll.add('e');
        System.out.println(ll.pollLast());
    }
}
