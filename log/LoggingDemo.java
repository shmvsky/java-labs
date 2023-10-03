package log;

import java.util.logging.Level;
import java.util.logging.Logger;

/*
 *SEVERE (ошибка)
 *WARNING (предупреждение)
 *INFO (информационное сообщение)
 *CONFIG
 *FINE
 *FINER
 *FINEST
**/
public class LoggingDemo {

    private int x;
    private int y;

    public static Logger logger = Logger.getLogger(LoggingDemo.class.getName());

    public LoggingDemo(int x, int y) {
        if (y == 0) {
            logger.log(Level.WARNING, "change y value from 0 to something else");
        }
        this.x = x;
        this.y = y;
        logger.log(Level.INFO, LoggingDemo.class.getName() + " created!");
    }

    public int calculate() {
        try {
            return x/y;
        }
        catch (ArithmeticException e) {
            logger.log(Level.SEVERE, "Divided by zero operation cannot possible");
        }
        return 0;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        logger.log(Level.INFO, "'x' set to " + x);
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        logger.log(Level.INFO, "'y' set to " + y);
        this.y = y;
    }

}
