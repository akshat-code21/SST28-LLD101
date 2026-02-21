import java.util.ArrayList;
import java.util.List;

public class ValidationService {
    String name;
    String email;
    String phone;
    String program;
    ValidationService(String name, String email,String phone,String program){
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.program = program;
    }
    public List<String> validate(){
        List<String> errors = new ArrayList<>();
        if (name.isBlank()) errors.add("name is required");
        if (email.isBlank() || !email.contains("@")) errors.add("email is invalid");
        if (phone.isBlank() || !phone.chars().allMatch(Character::isDigit)) errors.add("phone is invalid");
        if (!(program.equals("CSE") || program.equals("AI") || program.equals("SWE"))) errors.add("program is invalid");
        return errors;
    }
}
