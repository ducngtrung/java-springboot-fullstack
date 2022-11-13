package Day09_Interface.LOL;

public interface CanSurf {
    void surf();

    default void checkDefault() {
        System.out.println("Day la default method CanSurf");
    }
}