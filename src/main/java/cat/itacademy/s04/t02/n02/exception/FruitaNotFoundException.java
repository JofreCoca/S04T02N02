package cat.itacademy.s04.t02.n02.exception;

public class FruitaNotFoundException extends RuntimeException {
    public FruitaNotFoundException(String message) {
        super(message);
    }
}
