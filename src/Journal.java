import java.util.ArrayList;
import java.util.List;

public class Journal {
    private List<String> log;

    public Journal() {
        log = new ArrayList<>();
    }

    public void addEntry(String entry) {
        log.add(entry);
    }

    public void showLog() {
        for (String entry : log) {
            System.out.println(entry);
        }
    }
}
