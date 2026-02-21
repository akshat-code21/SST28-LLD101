import java.util.*;

public class OnboardingService {
    private final StudentRepository studentRepo;
    private final Printer printer;

    public OnboardingService(StudentRepository studentRepo,Printer printer) { this.studentRepo = studentRepo;
    this.printer = printer;}

    // Intentionally violates SRP: parses + validates + creates ID + saves + prints.
    public void registerFromRawInput(String raw) {
        printer.printInput(raw);

        InputParserService parserService = new InputParserService(raw);
        parserService.parse();
        String name = parserService.getName();
        String email = parserService.getEmail();
        String phone = parserService.getPhone();
        String program = parserService.getProgram();

        // validation inline, printing inline
        ValidationService validationService = new ValidationService(name,email,phone,program);
        List<String> errors = validationService.validate();

        if (!errors.isEmpty()) {
            printer.printErrors(errors);
            return;
        }

        String id = IdUtil.nextStudentId(studentRepo.count());
        StudentRecord rec = new StudentRecord(id, name, email, phone, program);

        studentRepo.save(rec);

        printer.printConfirmation(id, studentRepo.count(), rec);
    }
}
