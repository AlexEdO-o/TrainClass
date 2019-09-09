package trains;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Train {

    private static final Integer TWENTY_FOUR_HOURS_IN_MINUTES = 1440;
    private ArrayList<String> stationsList;
    private ArrayList<String> timeList;
    private String trainName;
    private String lastStation;
    private String arrTime;

    public Train(String trainName, String arrTime, String lastStation) {
        timeTest(arrTime);
        stationsList = new ArrayList<>();
        timeList = new ArrayList<>();
        this.arrTime = arrTime;
        this.lastStation = lastStation;
        this.trainName = trainName;
    }

    static void timeTest(String arrTime) {
        String regex = "\\d{1,2}:\\d{2}";
        if(!arrTime.matches(regex) || getMinFromTime(arrTime) >= TWENTY_FOUR_HOURS_IN_MINUTES) {
            throw new IllegalArgumentException("Time is not right");
        }
    }

    private static Integer getMinFromTime(String time) {
        String[] s = time.split(":");
        return Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
    }

    public void addStation(String arrivalTime, String station) {
        timeTest(arrivalTime);
        timeList.add(arrivalTime);
        stationsList.add(station);
    }

    public void deleteStation(String arrivalTime, String station) {
        timeTest(arrivalTime);
        for (int i = 0; i < timeList.size(); i++) {
            if (timeList.get(i).equals(arrivalTime) &&
                    stationsList.get(i).equals(station)) {
                timeList.remove(i);
                stationsList.remove(i);

            }
        }
    }

    public int findNearestStation(String destStation, String currentTime) {
        timeTest(currentTime);
        int time = getMinFromTime(currentTime);
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < stationsList.size(); i++) {
            int difference = getMinFromTime(timeList.get(i)) - time;
            if(difference >= 0 && result > difference &&
                    stationsList.get(i).equals(destStation)) {
                result = difference;
            }
        }
        return result;
    }

    public List<String> getStationsList() {
        return Collections.unmodifiableList(stationsList);
    }
    public List<String> getTimeList() {
        return Collections.unmodifiableList(timeList);
    }
    public String getTrainName() {
        return trainName; }

    public String getLastStation() {
        return lastStation;
    }

    public String getArrTime() {
        return arrTime;
    }
}
