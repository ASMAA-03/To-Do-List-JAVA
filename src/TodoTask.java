public class TodoTask {
    private String content;
    private boolean isDone;

    public TodoTask(String content, boolean isDone){
        this.content=content;
        this.isDone=isDone;
    }
public TodoTask(){
}

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public String toString()
    {
        return " Task: "+getContent()+"\n-is Complete? "+isDone()+"\n";
    }
}
