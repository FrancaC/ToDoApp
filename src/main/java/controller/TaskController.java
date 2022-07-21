/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Task;
import util.ConnectionFactory;


public class TaskController {
    
    public void save(Task task) {
        String sql = "INSERT INTO tasks (idProject,"
                + "nome,"
                + "description,"
                + "completed,"
                + "notes,"
                + "deadline,"
                + "createdAt,"
                + "updatedAt) VALUES (?,?,?,?,?,?,?,?)";
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3,task.getDescription());
            statement.setBoolean(4, task.isIsCompleted());
            statement.setString(5, task.getNotes());
            statement.setDate(6,new Date(task.getDeadline().getTime()));
            statement.setDate(7, new Date(task.getCreatedAt().getTime()));
            statement.setDate(8,new Date(task.getUpdatedAt().getTime()));
            statement.execute();
        }catch(Exception e){
           throw new RuntimeException("Erro ao inserir dados: "+ e.getMessage(),e);
        }
        finally{
            ConnectionFactory.closeConnection(connection, statement);
            
        }
    
    }
    public void update(Task task){
        String sql = "UPDATE tasks SET idProject =?,"
                + "nome =?,"
                + "description = ?,"
                + "completed = ?,"
                + "notes = ?,"
                + "deadline = ?,"
                + "createdAt = ?,"
                + "updatedAt = ?"
                + "WHERE id = ?";
        Connection connection =null;
        PreparedStatement statement = null;
        try{
            //estabelece a conexão com o banco
            connection = ConnectionFactory.getConnection();
            // prepara a query
            statement = connection.prepareStatement(sql);
            //seta os valores do statement
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3,task.getDescription());
            statement.setBoolean(4, task.isIsCompleted());
            statement.setString(5, task.getNotes());
            statement.setDate(6,new Date(task.getDeadline().getTime()));
            statement.setDate(7, new Date(task.getCreatedAt().getTime()));
            statement.setDate(8,new Date(task.getUpdatedAt().getTime()));
            statement.setInt(9, task.getId());
            statement.execute();
        }catch(Exception e){
            throw new RuntimeException("Erro ao atualizar uma tarefa"+ e.getMessage(),e);
        }         finally{
            ConnectionFactory.closeConnection(connection,statement);
            
        }
        
    }
    public void editTask(Task task,String nome, String descricao){
        String sql = "UPDATE tasks SET idProject =?,"
                + "nome =?,"
                + "description = ?,"
                + "completed = ?,"
                + "notes = ?,"
                + "deadline = ?,"
                + "createdAt = ?,"
                + "updatedAt = ?"
                + "WHERE id = ?";
        Connection connection =null;
        PreparedStatement statement = null;
        try{
            //estabelece a conexão com o banco
            connection = ConnectionFactory.getConnection();
            // prepara a query
            statement = connection.prepareStatement(sql);
            //seta os valores do statement
            statement.setInt(1, task.getIdProject());
            statement.setString(2, nome);
            statement.setString(3,descricao);
            statement.setBoolean(4, task.isIsCompleted());
            statement.setString(5, task.getNotes());
            statement.setDate(6,new Date(task.getDeadline().getTime()));
            statement.setDate(7, new Date(task.getCreatedAt().getTime()));
            statement.setDate(8,new Date(task.getUpdatedAt().getTime()));
            statement.setInt(9, task.getId());
            statement.execute();
        }catch(Exception e){
            throw new RuntimeException("Erro ao atualizar uma tarefa"+ e.getMessage(),e);
        }         finally{
            ConnectionFactory.closeConnection(connection,statement);
            
        }
        
    }
    
    public void removeById(int taskId) {
        String sql ="DELETE FROM tasks WHERE id = ?";
        Connection connection = null;
        PreparedStatement statement = null;
        
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, taskId);
            statement.execute();
        }catch(Exception e){
            throw new RuntimeException("Erro ao deletar uma tarefa"+ e.getMessage(),e);
        }finally{
            ConnectionFactory.closeConnection(connection, statement);
        }
    }
    
    public List<Task> getAll(int idProject){
        String sql = "SELECT * FROM tasks WHERE idProject = ?";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Task> tasks = new ArrayList<Task>();
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1,idProject);
            resultSet = statement.executeQuery();
            while(resultSet.next()){
                Task task = new Task();
                task.setId(resultSet.getInt("id"));
                task.setIdProject(resultSet.getInt("idProject"));
                task.setName(resultSet.getString("nome"));
                task.setDescription(resultSet.getString("description"));
                task.setNotes(resultSet.getString("notes"));
                task.setIsCompleted(resultSet.getBoolean("completed"));
                task.setDeadline(resultSet.getDate("deadline"));
                task.setCreatedAt(resultSet.getDate("createdAt"));
                task.setUpdatedAt(resultSet.getDate("updatedAt"));
                tasks.add(task);
                
            }
            
        }catch(Exception e){
            throw new RuntimeException("Erro ao listar uma tarefa"+ e.getMessage(),e);
        } finally{
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }
        
        return tasks;
    }
    
    
}
