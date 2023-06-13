package assignment8;
import java.util.*;
public class MyPersonList {
    private final int INITIAL_LENGTH = 4;
    private Person[] people;
    private int size;

    public MyPersonList() {
        people = new Person[INITIAL_LENGTH];
        size = 0;
    }

    public void add(Person s) {
        if(s == null) return;
        if(size == people.length) resize();
        people[size++] = s;
    }
    public Person get(int i) {
        if (i < 0 || i >= size) {
            return null;
        }
        return people[i];
    }

    private void resize() {
        System.out.println("resizing");
        int len = people.length;
        int newLen = 2 * len;
        Person[] newArray = new Person[newLen];
        System.arraycopy(people, 0, newArray, 0, len);
        people = newArray;
    }

    public static void main(String[] args) {
        MyPersonList l = new MyPersonList();
        l.add(new Person("Billy", "Tommy",30));
        l.add(new Person("Jenny", "Lofs",45));
        l.add(new Person("White", "Jimmy",20));
        l.add(new Person("Tom", "Herrison",17));
        l.add(new Person("Billy", "Tommy",50));
        System.out.println("Number of elements: " + l.size);

        l.insert(new Person("Dash", "Hardy",50), 1);

        System.out.println("Length of the current arraySize: " + l.people.length);

        l.remove("White");
        l.remove("Billy");

        System.out.println("Number of elements resized: " + l.size);
    }

    public boolean find(Person s) {
        if (s == null) return false;
        for (Person test : people) {
            if (test.equals(s)) return true;
        }
        return false;
    }

    public void insert(Person person, int position) {
        if (position > size || position < 0) return;
        if (position == people.length || size + 1 > people.length) {
            resize();

        }
        Person[] temp = new Person[people.length + 1];
        System.arraycopy(people, 0, temp, 0, position);
        temp[position] = person;

        System.arraycopy(people, position, temp, position + 1, people.length - position);
        people = temp;
        ++size;

    }

    public boolean remove(String s) {
        if (size == 0) return false;
        if (s == null) return false;
        int index = -1;
        for (int i = 0; i < size; ++i) {
            if (people[i].equals(s)) {
                index = i;
                break;
            }
        }

        if (index == -1) return false; //s is not found in the list


        Person[] temp = new Person[people.length];
        System.arraycopy(people, 0, temp, 0, index);

        System.arraycopy(people, index + 1, temp, index, people.length - (index + 1));
        people = temp;
        --size;
        return true;

    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < size - 1; ++i) {
            sb.append(people[i] + ",");
        }
        sb.append(people[size - 1] + "]");

        return sb.toString();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public Object clone() {
        Person[] temp = Arrays.copyOf(people, size);
        return temp;

    }
}