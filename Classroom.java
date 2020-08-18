/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interval.scheduling;

/**
 *
 * @author mac
 */
public class Classroom {
    int busyUntil, prio;
    Interval[] intervals;
    DHArrayList<Interval> IntervalList = new DHArrayList<>();
    boolean Busy;
    
    public Classroom(int busyUntil, int prio, Interval interval){
        this.busyUntil = busyUntil;
        this.prio = prio;
        this.IntervalList.add(interval);
    }
    
    public Classroom(int busyUntil, int prio){
        this.busyUntil = busyUntil;
        this.prio = prio;
    }
    
    //public Classroom(){}
    
    public String toString() {
        return "Class [id=" + prio + ", intervals=[" + IntervalList.toString() + "]";
    }

    public int getPrio() {
        return prio;
    }
    
    public int getBusyUntil(){
        return busyUntil;
    }
    
    public void setBusy(int busy){
        this.busyUntil = busy;
    }
    
    public boolean getBusy(){
        return Busy;
    }
    
    public int getLength() {
        return IntervalList.getSize();
    }
}
