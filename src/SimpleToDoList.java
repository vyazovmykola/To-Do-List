import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class Task {
    String description;
    boolean completed;
    
    public Task(String description) {
        this.description = description;
        this.completed = false;
    }
    
    public String toString() {
        return (completed ? "[tak] " : "[nie] ") + description;
    }
}

public class SimpleToDoList {
    private ArrayList<Task> tasks = new ArrayList<>();
    private JFrame frame;
    private JList<String> taskList;
    private DefaultListModel<String> listModel;
    private JTextField newTaskField;
    
    public SimpleToDoList() {
        createGUI();
        addSampleTasks();
    }
    
    private void createGUI() {
        frame = new JFrame("Prosta Lista Zadań");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        frame.setLayout(new BorderLayout());
        
        JLabel title = new JLabel("Moje Zadania", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(title, BorderLayout.NORTH);

        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);
        frame.add(new JScrollPane(taskList), BorderLayout.CENTER);
        
        JPanel bottomPanel = new JPanel(new BorderLayout());
        newTaskField = new JTextField();
        JButton addButton = new JButton("Dodaj");
        
        addButton.addActionListener(e -> addNewTask());
        
        bottomPanel.add(new JLabel("Nowe zadanie:"), BorderLayout.NORTH);
        bottomPanel.add(newTaskField, BorderLayout.CENTER);
        bottomPanel.add(addButton, BorderLayout.EAST);
        
        frame.add(bottomPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
    
    private void addSampleTasks() {
        addTask("Kupic mleko");
    }
    
    private void addNewTask() {
        String taskText = newTaskField.getText().trim();
        if (!taskText.isEmpty()) {
            addTask(taskText);
            newTaskField.setText("");
        }
    }
    
    private void addTask(String description) {
        Task task = new Task(description);
        tasks.add(task);
        listModel.addElement(task.toString());
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SimpleToDoList());
    }
}