import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class ToDoListTasks extends TodoTask {
    private final HashMap<Integer, TodoTask> listOfTasks=new HashMap<>();
    private int ID=0;
    Scanner scan=new Scanner(System.in);
    private String priority;
    private  boolean flag=true;

    public ToDoListTasks(){
    }
    public ToDoListTasks(String priority,int ID){//still think about it
        this.ID=ID;
        this.priority=priority;
    }
    public void start(){
        menue();
    }
public void menue(){
    System.out.println("\t*** To-Do List ***");
    System.out.println("-what do you want to do :");
    System.out.println("1-Add Task");
    System.out.println("2-Delete Task");
    System.out.println("3-Search for Task");
    System.out.println("4-Exit");
    System.out.println("5-Show Un-Completed Tasks");/////////////
    System.out.println("6-Show the list of Tasks");
    System.out.println("7-mark As Complete");
    System.out.println("8-Show Completed Tasks");////////////
    System.out.println("-Choose a number :");
    ChooseFrom();
}
    public void ChooseFrom(){
        while(flag) {
        try {
                int userInput = scan.nextInt();
                display(userInput);
                if(flag) {
                    menue();
                }
        }catch (InputMismatchException e){
            System.out.println("Invalid Input");
            System.out.println("Enter number from 1-8 based on the list please:");
           scan.nextLine();
           if(flag) {
               menue();
           }
        }
    }
    }
    public void display(int userInput){
        switch (userInput){
            case 1 -> {
                System.out.println("**what do you want to add: ");
                scan.nextLine();
                add();
            }
            case 2->{
                System.out.println("**what is the ID for item you want to delete :");
            delete();
            }
            case 3 ->{
                System.out.println("**What is the ID for the Task You Want to See:");
                searchForTask();
            }
            case 5->{
                System.out.println("\t**The Un-Completed List:**");
                showUnCompletedList();
            }
            case 8->{
                System.out.println("\t**The Completed List:**");
                showCompletedList();
            }
            case 6->{
                System.out.println("\t**The List:**");
                TheList();
            }
            case 7 ->{
                System.out.println("**Enter The ID For The Task U Complete");
                markAsComplete();
            }
            case 4->{
                System.out.println("**Good bye**");
                flag=false;
            }
        }
    }
    public void add(){
        String userTask=scan.nextLine();
        setID(++ID);
        TodoTask task=new TodoTask(userTask,false);
        listOfTasks.put(getID(),task);
        System.out.println("Task: "+userTask+",ID= "+getID());
    }
    public void delete(){
    int deleteID=scan.nextInt();
    if (listOfTasks.containsKey(deleteID)) {
        listOfTasks.remove(deleteID);
        System.out.println("The ID successfully deleted");
    }else {
        System.out.println("Invalid ID");
    }
    }
public void TheList(){
        for(Map.Entry<Integer,TodoTask> task: listOfTasks.entrySet()){
TodoTask content=task.getValue();
            System.out.println(content.getContent());
        }
}
    public void markAsComplete(){
        try {
            int idComplete = scan.nextInt();
            TodoTask complete = listOfTasks.get(idComplete);
            if(!complete.isDone()){
                complete.setDone(true);
                System.out.println("Successfully Completed");
            }else{
                System.out.println("already Done");
            }
        }catch (NullPointerException e){
            System.out.println("Invalid ID");
        }
    }


public void searchForTask(){
        try {
            int userSearchID = scan.nextInt();
            TodoTask searchTask = listOfTasks.get(userSearchID);
            System.out.println(searchTask.getContent());
        }catch (NullPointerException e){
            System.out.println("Invalid ID");
        }
        }
    public void showUnCompletedList(){
        boolean found=false;
        for(TodoTask task: listOfTasks.values()){
            if(!task.isDone()){
                System.out.println(task);
                found=true;
            }
        }if(!found){
            System.out.println("No UNCompleted Tasks");

        }}
    public void showCompletedList(){

        boolean found=false;
        for(TodoTask task: listOfTasks.values()){
            if(task.isDone()){
                System.out.println(task);
                found=true;
            }
        }if(!found){
            System.out.println("No Completed Tasks");


    }}

    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
}
