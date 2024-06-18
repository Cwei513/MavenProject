package com.atguigu.demo;

public class Animal {
    public static void eat() {
        System.out.println("Animal eat");
    }
    public void run() {
        System.out.println("Animal Running");
    }
}

 class Dog extends Animal {
    public static void eat() {
        System.out.println("Dog eat");
    }
    public void run() {
        System.out.println("Dog Running");
    }
}

 class Test {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Animal dog = new Dog();
        animal.run();
        dog.run();
        animal.eat();
        dog.eat();
    }
}
