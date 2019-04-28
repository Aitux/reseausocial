package model;

import java.util.Comparator;

public class StatusComparator implements Comparator<Status> {
    @Override
    public int compare(Status status, Status t1) {
        return status.getDate().compareTo(t1.getDate());
    }
}
