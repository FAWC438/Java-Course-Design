package homework_2;

public class ScoreException extends Exception {
    public ScoreException() {
        super("Illegal score format");
    }
}
