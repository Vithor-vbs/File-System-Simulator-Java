import java.io.File;

public class DirectoryEntry {
    private String path;

    public DirectoryEntry(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void create() {
        File directory = new File(path);
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }

    public void delete() {
        File directory = new File(path);
        if (directory.exists()) {
            directory.delete();
        }
    }

    public void rename(String newPath) {
        File oldDirectory = new File(path);
        File newDirectory = new File(newPath);
        if (oldDirectory.exists()) {
            oldDirectory.renameTo(newDirectory);
            this.path = newPath;
        }
    }

    public void listFiles() {
        File directory = new File(path);
        if (directory.exists() && directory.isDirectory()) {
            String[] files = directory.list();
            if (files != null) {
                for (String file : files) {
                    System.out.println(file);
                }
            } else {
                System.out.println("O diretório está vazio: " + path);
            }
        } else {
            System.out.println("O diretório não existe ou não é um diretório: " + path);
        }
    }
}
