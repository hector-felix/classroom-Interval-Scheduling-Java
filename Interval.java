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
public class Interval {
    int start, end, numberInterval;

    public Interval(int start, int end, int numberInterval) {
        this.start = start;
        this.end = end;
        this.numberInterval = numberInterval;
    }

    public Interval(){}
    
    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public int getNumberInterval() {
        return numberInterval;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public void setNumberInterval(int numberInterval) {
        this.numberInterval = numberInterval;
    }
    
    public String toString() {
        return "[" + numberInterval + ", [" + start + ", " + end + "]]";
    }
}
