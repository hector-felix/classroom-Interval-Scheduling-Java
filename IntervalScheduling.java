/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interval.scheduling;

import java.util.Scanner;

/**
 *
 * @author mac
 */
public class IntervalScheduling {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Interval[] intervalsHeap = createHeap();
        HeapSort(intervalsHeap);
        DHArrayList<Classroom> ClassroomList = new DHArrayList<>();
        Classroom Classroom1 = new Classroom(0, 1);
        ClassroomList.add(Classroom1);
        ClassroomList.get(0).IntervalList.add(intervalsHeap[0]);
        ClassroomList.get(0).setBusy(intervalsHeap[0].getEnd());
        for (int i = 1; i < intervalsHeap.length; i++) {
            int total = ClassroomList.getSize();
            boolean added = false;
            for (int j = 0; j < total; j++) {
                if (intervalsHeap[i].getStart() >= ClassroomList.get(j).getBusyUntil()) {
                    ClassroomList.get(j).IntervalList.add(intervalsHeap[i]);
                    ClassroomList.get(j).setBusy(intervalsHeap[i].getEnd());
                    added = true;
                    break;
                }
            }
            if (!added) {
                Classroom temp = new Classroom(intervalsHeap[i].getEnd(), ClassroomList.getSize() + 1, intervalsHeap[i]);
                ClassroomList.add(temp);
            }
        }
        System.out.println("\n-~-~-~-~-~-~-~-~Interval-~Scheduling-~-~-~-~-~-~-~-~");
        System.out.println(longest(ClassroomList).toString());      //I believe the assignment was asking for the most jobs assigned to a classroom here
        System.out.println("\n~-~-~-~-~-~-~-~Interval-~Partitioning-~-~-~-~-~-~-~-~");
        for (int i = 0; i < ClassroomList.getSize(); i++) {
            System.out.println(ClassroomList.get(i).toString());
        }
    }

    public static Classroom longest(DHArrayList<Classroom> a) {
        Classroom temp = a.get(0);
        for (int i = 1; i < a.getSize(); i++) {
            if (temp.getLength() < a.get(i).getLength()) {
                temp = a.get(i);
            }
        }
        return temp;
    }

    public static void HeapSort(Interval[] interval) {
        int a = interval.length;
        for (int i = a / 2 - 1; i >= 0; i--) {
            MaxHeapify(interval, a, i);
        }
        for (int i = a - 1; i >= 0; i--) {
            Interval temp = interval[0];
            interval[0] = interval[i];
            interval[i] = temp;
            MaxHeapify(interval, i, 0);
        }
    }

    public static void MaxHeapify(Interval[] Intervals, int n, int i) {
        int Max = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && Intervals[l].getStart() > Intervals[Max].getStart()) {
            Max = l;
        }
        if (r < n && Intervals[r].getStart() > Intervals[Max].getStart()) {
            Max = r;
        }
        if (Max != i) {
            Interval temp = Intervals[i];
            Intervals[i] = Intervals[Max];
            Intervals[Max] = temp;
            MaxHeapify(Intervals, n, Max);
        }
    }

    public static Interval[] createHeap() {
        int entries, start, end;
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the number of intervals:");
        entries = input.nextInt();
        Interval[] intervalsHeap = new Interval[entries];
        System.out.println("Please enter the start time of intervals:");
        start = input.nextInt();
        System.out.println("Please enter end time of intervals:");
        end = input.nextInt();
        for (int i = 0; i < entries; i++) {
            intervalsHeap[i] = new Interval();
        }
        for (int i = 0; i < entries; i++) {

            intervalsHeap[i].setStart((int) ((Math.random() * (end - start)) + start));
            intervalsHeap[i].setEnd((int) ((Math.random() * (end - intervalsHeap[i].getStart())) + intervalsHeap[i].getStart() + 1));
            intervalsHeap[i].setNumberInterval(i);
        }
        System.out.println("\n-~-~-~-~-~-~-~-~Initial-~Intervals-~-~-~-~-~-~-~-~");
        for (Interval intervalsHeap1 : intervalsHeap) {
            System.out.println(intervalsHeap1);
        }
        /*for (int i = 0; i < intervalsHeap.length; i++) {
            System.out.println(intervalsHeap[i]);
        }*/  
        return intervalsHeap;
    }
}
