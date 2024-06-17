import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class FileEntry {
    private String path;
    private String content;

    public FileEntry(String path, String content) {
        this.path = path;
        this.content = content;
    }

    public String getPath() {
        return path;
    }

    public String getContent() {
        return content;
    }

    public void create() throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
        }
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(content);
        }
    }

    public void delete() {
        File file = new File(path);
        if (file.exists()) {
            file.delete();
        }
    }

    public void rename(String newPath) {
        File oldFile = new File(path);
        File newFile = new File(newPath);
        if (oldFile.exists()) {
            oldFile.renameTo(newFile);
            this.path = newPath;
        }
    }

    public void copy(String destinationPath) throws IOException {
        File sourceFile = new File(path);
        File destinationFile = new File(destinationPath);
        Files.copy(sourceFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }
}
