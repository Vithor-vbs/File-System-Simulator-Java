import java.io.IOException;

public class FileSystemSimulator {
    private Journal journal;

    public FileSystemSimulator() {
        journal = new Journal();
    }

    public void createDirectory(String path) {
        DirectoryEntry dir = new DirectoryEntry(path);
        dir.create();
        journal.addEntry("Created directory: " + path);
    }

    public void deleteDirectory(String path) {
        DirectoryEntry dir = new DirectoryEntry(path);
        dir.delete();
        journal.addEntry("Deleted directory: " + path);
    }

    public void renameDirectory(String oldPath, String newPath) {
        DirectoryEntry dir = new DirectoryEntry(oldPath);
        dir.rename(newPath);
        journal.addEntry("Renamed directory from " + oldPath + " to " + newPath);
    }

    public void listFiles(String path) {
        DirectoryEntry dir = new DirectoryEntry(path);
        dir.listFiles();
    }

    public void createFile(String path, String content) {
        FileEntry file = new FileEntry(path, content);
        try {
            file.create();
            journal.addEntry("Created file: " + path);
        } catch (IOException e) {
            System.out.println("Error creating file: " + e.getMessage());
        }
    }

    public void deleteFile(String path) {
        FileEntry file = new FileEntry(path, null);
        file.delete();
        journal.addEntry("Deleted file: " + path);
    }

    public void renameFile(String oldPath, String newPath) {
        FileEntry file = new FileEntry(oldPath, null);
        file.rename(newPath);
        journal.addEntry("Renamed file from " + oldPath + " to " + newPath);
    }

    public void copyFile(String sourcePath, String destinationPath) {
        FileEntry file = new FileEntry(sourcePath, null);
        try {
            file.copy(destinationPath);
            journal.addEntry("Copied file from " + sourcePath + " to " + destinationPath);
        } catch (IOException e) {
            System.out.println("Error copying file: " + e.getMessage());
        }
    }

    public void showJournal() {
        journal.showLog();
    }

    public static void main(String[] args) {
        FileSystemSimulator fsSimulator = new FileSystemSimulator();

        fsSimulator.createDirectory("testDir");
        fsSimulator.createFile("testDir/sample.txt", "Sample Content");
        fsSimulator.listFiles("testDir");
        fsSimulator.renameFile("testDir/sample.txt", "testDir/sampleRenamed.txt");
        fsSimulator.copyFile("testDir/sampleRenamed.txt", "testDir/sampleCopy.txt");
        fsSimulator.deleteFile("testDir/sampleRenamed.txt");
        fsSimulator.listFiles("testDir");
        fsSimulator.deleteDirectory("testDir");

        fsSimulator.showJournal();
    }
}
