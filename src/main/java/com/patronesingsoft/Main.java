package com.patronesingsoft;

/** Ejecuta las 25 demos y sus comprobaciones sin frameworks de pruebas. */
public class Main {
    public static void main(String[] args) {
        if (!Main.class.desiredAssertionStatus()) {
            throw new IllegalStateException("Activar las comprobaciones con java -ea");
        }
        System.out.println("\n=== Creacionales ===");
        com.patronesingsoft.creational.AbstractFactory.Demo.main(args);
        com.patronesingsoft.creational.Builder.Demo.main(args);
        com.patronesingsoft.creational.DependencyInjection.Demo.main(args);
        com.patronesingsoft.creational.FactoryMethod.Demo.main(args);
        com.patronesingsoft.creational.ObjectPool.Demo.main(args);
        com.patronesingsoft.creational.Prototype.Demo.main(args);
        com.patronesingsoft.creational.Singleton.Demo.main(args);
        System.out.println("\n=== Estructurales ===");
        com.patronesingsoft.structural.Adapter.Demo.main(args);
        com.patronesingsoft.structural.Bridge.Demo.main(args);
        com.patronesingsoft.structural.Composite.Demo.main(args);
        com.patronesingsoft.structural.Decorator.Demo.main(args);
        com.patronesingsoft.structural.Facade.Demo.main(args);
        com.patronesingsoft.structural.Flyweight.Demo.main(args);
        com.patronesingsoft.structural.Proxy.Demo.main(args);
        System.out.println("\n=== Conductuales ===");
        com.patronesingsoft.behavioral.ChainOfResponsibility.Demo.main(args);
        com.patronesingsoft.behavioral.Command.Demo.main(args);
        com.patronesingsoft.behavioral.Interpreter.Demo.main(args);
        com.patronesingsoft.behavioral.Iterator.Demo.main(args);
        com.patronesingsoft.behavioral.Mediator.Demo.main(args);
        com.patronesingsoft.behavioral.Memento.Demo.main(args);
        com.patronesingsoft.behavioral.Observer.Demo.main(args);
        com.patronesingsoft.behavioral.State.Demo.main(args);
        com.patronesingsoft.behavioral.Strategy.Demo.main(args);
        com.patronesingsoft.behavioral.TemplateMethod.Demo.main(args);
        com.patronesingsoft.behavioral.Visitor.Demo.main(args);
        System.out.println("\nOK: los 25 patrones funcionan correctamente.");
    }
}
