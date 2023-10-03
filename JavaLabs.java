import assertions.AssertionsDemo;
import exceptions.ExceptionsDemo;
import interfaces.AutomaticTransmission;
import interfaces.Car;
import interfaces.DaewooMatiz;
import log.LoggingDemo;
import nestedClasses.A;

import java.io.IOException;

/**
 * Лабораторная #1
 * 1. Интерфейсы
 * 2. Внутренние классы
 * 3. Исключения
 * 4. Утверждения
 * 5. Протоколирование
 */
public class JavaLabs {

    public static void main(String[] args) throws IOException {

        //1
        Car deawoo = new DaewooMatiz();
        System.out.println(deawoo instanceof DaewooMatiz);
        System.out.println(deawoo instanceof Car);
        System.out.println(deawoo instanceof AutomaticTransmission);

        //2
        A a = new A();
        A.B b = a.new B();
        A.C c = new A.C();
        b.foo(13, 37);
        c.foo(42);

        //3
        ExceptionsDemo.bar();
        ExceptionsDemo.readerExample1("exceptions/test.txt");
        ExceptionsDemo.readerExample2("exceptions/test.txt");
        ExceptionsDemo.readerExample3("exceptions/test.txt");
        ExceptionsDemo.uncheckedExceptionExample();

        //4
        AssertionsDemo.doAssertions();

        //5
        LoggingDemo ld = new LoggingDemo(1, 0);
        ld.setX(2);
        ld.setY(1);
        ld.getX();
        ld.getX();
        ld.calculate();
        ld.setY(0);
        ld.calculate();
    }

}
