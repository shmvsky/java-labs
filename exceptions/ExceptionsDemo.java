package exceptions;

import java.io.*;

public class ExceptionsDemo {


    private static void foo() throws Exception {
        throw new Exception("WTF...");
    }

    public static void bar() {
        try {
            foo();
        } catch (Exception ex) {
            System.out.println("Исключение обработано. Теперь всё хорошо!");
        } finally {
            buz();
        }
    }

    private static void buz() {
        System.out.println("Освобождаем ресурсы или что-нибудь еще...");
    }

    //try-with-resources
    public static void readerExample1(String fn) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fn))) {
            String line;
            while((line = reader.readLine()) != null){
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not exists: " + fn);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Specify Requirement
    //https://docs.oracle.com/javase/tutorial/essential/exceptions/catchOrDeclare.html
    public static void readerExample2(String fn) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fn));
        String line;
        while((line = reader.readLine()) != null){
            System.out.println(line);
        }
        reader.close();
    }

    //try-catch-finally
    public static void readerExample3(String fn) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fn));
            String line;
            while((line = reader.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("File not exists: " + fn);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void uncheckedExceptionExample() {
//        int waitForAnException = 1/0;
    }


}
