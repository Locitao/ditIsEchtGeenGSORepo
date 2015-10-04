/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

/**
 *
 * @author rick
 */
public class TimeSpan2 implements ITimeSpan{
    
    /* class invariant: 
     * A TimeSpan with a begin time and end time.
     * End time must be later than begin time, duration is always positive.
     * 
     */
    private ITime bt, et;
    private long duration;
    
    /**
     * 
     * @param bt must be earlier than et
     * @param duration
     */
    public TimeSpan2(ITime bt, long duration) {
        //ITime et = bt.plus(Integer.valueOf(String.valueOf(duration)));
        
        if (bt.compareTo(et) <= 0) {
            throw new IllegalArgumentException("begin time "
                    + bt + " must be earlier than end time " + et);
        }

        this.bt = bt;
        this.et = et;
        this.duration = duration;
    }

    @Override
    public ITime getBeginTime() {
        return bt;
    }

    @Override
    public ITime getEndTime() {
        return et;
    }

    @Override
    public int length() {
        return et.difference(bt);
    }

    @Override
    public void setBeginTime(ITime beginTime) {
        if (beginTime.compareTo(et) <= 0) {
            throw new IllegalArgumentException("begin time "
                    + bt + " must be earlier than end time " + et);
        }

        bt = beginTime;
    }

    @Override
    public void setEndTime(ITime endTime) {
        if (endTime.compareTo(bt) >= 0) {
            throw new IllegalArgumentException("end time "
                    + et + " must be later then begin time " + bt);
        }

        bt = endTime;
    }

    @Override
    public void move(int minutes) {
        bt = bt.plus(minutes);
        et = bt.plus(minutes);
    }

    @Override
    public void changeLengthWith(int minutes) {
        if (minutes <= 0) {
            throw new IllegalArgumentException("length of period must be positive");
        }
        
        et = et.plus(minutes);
    }

    @Override
    public boolean isPartOf(ITimeSpan timeSpan) {
        return (getBeginTime().compareTo(timeSpan.getBeginTime()) >= 0
                && getEndTime().compareTo(timeSpan.getEndTime()) <= 0);
    }

    @Override
    public ITimeSpan unionWith(ITimeSpan timeSpan) {
        //if begin time > end time
        int i = bt.compareTo(timeSpan.getEndTime());
        if (bt.compareTo(timeSpan.getEndTime()) < 0 || et.compareTo(timeSpan.getBeginTime()) > 0) {
            return null;
        }
        
        //If the old bt is smaller than the new one, it becomes the new bt
        ITime begintime, endtime;
        if (bt.compareTo(timeSpan.getBeginTime()) < 0) {
            begintime = bt;
        } else {
            begintime = timeSpan.getBeginTime();
        }

        if (et.compareTo(timeSpan.getEndTime()) > 0) {
            endtime = et;
        } else {
            endtime = timeSpan.getEndTime();
        }

        return new TimeSpan2(begintime, endtime.difference(begintime));

    }

    @Override
    public ITimeSpan intersectionWith(ITimeSpan timeSpan) {

        ITime begintime, endtime;
        int i = bt.compareTo(timeSpan.getBeginTime());
        if (bt.compareTo(timeSpan.getBeginTime()) > 0) {
            begintime = bt;
        } else {
            begintime = timeSpan.getBeginTime();
        }

        if (et.compareTo(timeSpan.getEndTime()) < 0) {
            endtime = et;
        } else {
            endtime = timeSpan.getEndTime();
        }
       
        if (begintime.compareTo(endtime) <= 0) {
            return null;
        }

        return new TimeSpan2(begintime, endtime.difference(begintime));
    }
    
}
