package classes.mulitpleInheritance;

/**
 * Can be attached to a derived class with
 public class SomeClass implements SomeInterface{…}
 * OR
 public class SomeClass extend SuperClass implements SomeInterface{…}
 * OR
 public class SomeClass implements SomeInterface, SomeOtherInterface{…}
 */
public interface CreateNum {
    //"public static final" implied
    double MORE = 1.5;

    //"public abstract" implied and MUST be overridden
    double newNumber(int num);
}
