package StopWatch;

public class StopWatch {
    //Attributes
    private long startTime;
    private long endTime;

    //Constructor
    public StopWatch(){ this.startTime = 0; this.endTime = 0;}

    //Methods
    public long getStartTime() {
        return startTime;
    }
    public long getEndTime() {
        return endTime;
    }

    public void start(){
        this.startTime = System.currentTimeMillis();
    }

    public void stop(){
        this.endTime = System.currentTimeMillis();
    }

    public long getElapsedTime(){
        return this.getEndTime() - this.getStartTime();
    }
}
