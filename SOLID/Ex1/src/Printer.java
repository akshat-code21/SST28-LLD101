import java.util.List;

public interface Printer {
    void printInput(String raw);
    void printErrors(List<String> errors);
    void printConfirmation(String id,int count,StudentRecord rec);
}
