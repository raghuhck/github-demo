package com.test.epam.java8;

//Product interface
interface FDPProduct {
 void operation();
}

//Concrete Products
class ConcreteProductA implements FDPProduct {
 @Override
 public void operation() {
     System.out.println("Operation performed by ConcreteProductA");
 }
}

class ConcreteProductB implements FDPProduct {
 @Override
 public void operation() {
     System.out.println("Operation performed by ConcreteProductB");
 }
}

//Factory interface
interface ProductFactory {
	FDPProduct createProduct();
}

//Concrete Factory for creating ConcreteProductA
class ConcreteProductAFactory implements ProductFactory {
 @Override
 public FDPProduct createProduct() {
     return new ConcreteProductA();
 }
}

//Concrete Factory for creating ConcreteProductB
class ConcreteProductBFactory implements ProductFactory {
 @Override
 public FDPProduct createProduct() {
     return new ConcreteProductB();
 }
}

//Client class
public class FactoryDesignPattern {
 public static void main(String[] args) {
     // Create a ConcreteProductA using ConcreteProductAFactory
     ProductFactory factoryA = new ConcreteProductAFactory();
     FDPProduct productA = factoryA.createProduct();
     productA.operation();
     
     // Create a ConcreteProductB using ConcreteProductBFactory
     ProductFactory factoryB = new ConcreteProductBFactory();
     FDPProduct productB = factoryB.createProduct();
     productB.operation();
 }
}

