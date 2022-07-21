
package ProjectFinalCapgemini;

import controller.ProjectController;
import model.Project;

public class App {

    public static void main(String[] args) {
        Project project = new Project();
        ProjectController projectController = new ProjectController();
        project.setName("meu primeiro Projeto");
        project.setDescription("isso é quase um hello world");
        
        projectController.save(project);
    }
}
 
