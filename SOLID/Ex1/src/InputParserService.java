import java.util.LinkedHashMap;
import java.util.Map;

public class InputParserService {
    String raw;
    Map<String,String> kv;
    public InputParserService(String raw){
        this.raw = raw;
        kv = new LinkedHashMap<>();
    }
    void parse(){
        String[] parts = raw.split(";");
        for (String p : parts) {
            String[] t = p.split("=", 2);
            if (t.length == 2) kv.put(t[0].trim(), t[1].trim());
        }
    }
    public String getName(){
        return kv.getOrDefault("name", "");
    }
    public String getEmail(){
        return kv.getOrDefault("email", "");
    }
    public String getPhone(){
        return kv.getOrDefault("phone", "");
    }
    public String getProgram(){
        return kv.getOrDefault("program", "");
    }
}
