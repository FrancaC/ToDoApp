/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author clebe
 */
public class EditTask {
    private  String taskName, taskDescription;
    private  JTextField JTextFieldTaskName = new JTextField(5);
    private JTextField JTextFieldTaskDescription = new JTextField(5);

    public  void  editTask(){
      JPanel myPanel = new JPanel();
      myPanel.add(new JLabel("Insira o nome da tarefa:"));
      myPanel.add(JTextFieldTaskName);
      myPanel.add(new JLabel("insira a descrição da tarefa:"));
      myPanel.add(JTextFieldTaskDescription);

      int result = JOptionPane.showConfirmDialog(null, myPanel, 
               "Edite a tabela", JOptionPane.OK_CANCEL_OPTION);
      
      if (result == JOptionPane.OK_OPTION) {
          if(JTextFieldTaskName.getText()!=""){
        this.taskName=JTextFieldTaskName.getText();
        this.taskDescription = JTextFieldTaskDescription.getText();
          }
          else{
               JOptionPane.showConfirmDialog(null, myPanel, 
               "Edite a tabela", JOptionPane.OK_CANCEL_OPTION);
          }
      }
      }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }


      
}
