/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.register;
import javax.swing.JOptionPane;
import java.util.*;

/**
 *
 * @author lab_services_student
 */
class Task {
    private int taskCount = 0;
    private List<String> developers = new ArrayList<>();
    private List<String> taskNames = new ArrayList<>();
    private List<String> taskIDs = new ArrayList<>();
    private List<Integer> taskDurations = new ArrayList<>();
    private List<String> taskStatuses = new ArrayList<>();

    public void addTasks(String lastName) {
        int numberOfTasks = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the number of tasks you wish to enter:"));
        for (int i = 0; i < numberOfTasks; i++) {
            String taskName = JOptionPane.showInputDialog(null, "Enter Task Name:");
            String taskDescription = JOptionPane.showInputDialog(null, "Enter Task Description (max 50 characters):");
            while (taskDescription.length() > 50) {
                taskDescription = JOptionPane.showInputDialog(null, "Description should not exceed 50 characters. Please re-enter Task Description:");
            }
            if (taskDescription.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No description was added. Task not captured.");
                continue;
            }
            String author = JOptionPane.showInputDialog(null, "Enter Author of the Task:");
            int duration = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Task Duration (in hours):"));
            String[] statuses = {"To Do", "Doing", "Done"};
            String selectedStatus = (String) JOptionPane.showInputDialog(null, "Select Task Status", "Task Status", JOptionPane.PLAIN_MESSAGE, null, statuses, statuses[0]);
            taskCount++;
            String taskID = generateTaskID(taskName, taskCount, lastName);

            developers.add(author);
            taskNames.add(taskName);
            taskIDs.add(taskID);
            taskDurations.add(duration);
            taskStatuses.add(selectedStatus);

            StringBuilder taskInfo = new StringBuilder("Task ID: " + taskID + "\n");
            taskInfo.append("Name: ").append(taskName).append("\n");
            taskInfo.append("Description: ").append(taskDescription).append("\n");
            taskInfo.append("Status: ").append(selectedStatus).append("\n");
            taskInfo.append("Author: ").append(author).append("\n");
            taskInfo.append("Duration: ").append(duration).append(" hours\n");
            JOptionPane.showMessageDialog(null, "Task successfully captured!\n\n" + taskInfo.toString());
        }
    }

    public void showTaskStatus() {
        String[] statuses = {"To Do", "Doing", "Done"};
        String selectedStatus = (String) JOptionPane.showInputDialog(null, "Select Task Status", "Task Status", JOptionPane.PLAIN_MESSAGE, null, statuses, statuses[0]);
        StringBuilder taskList = new StringBuilder("Tasks in " + selectedStatus + ":\n");
        for (int i = 0; i < taskNames.size(); i++) {
            if (taskStatuses.get(i).equals(selectedStatus)) {
                taskList.append("Task Name: ").append(taskNames.get(i)).append("\n");
                taskList.append("Developer: ").append(developers.get(i)).append("\n");
                taskList.append("Duration: ").append(taskDurations.get(i)).append(" hours\n\n");
            }
        }
        JOptionPane.showMessageDialog(null, taskList.toString());
    }

    private String generateTaskID(String taskName, int taskNumber, String lastName) {
        return taskName.substring(0, Math.min(taskName.length(), 3)).toUpperCase() + ":" + taskNumber + ":" + lastName.substring(Math.max(0, lastName.length() - 3)).toUpperCase();
    }
}