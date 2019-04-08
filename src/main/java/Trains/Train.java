package Trains;

import java.util.ArrayList;

public class Train {

    private ArrayList<String> stationsList;
    private ArrayList<String> timeList;
    private String trainName;
    private String lastStation;
    private String arrTime;

    public Train(String trainName, String arrTime, String lastStation) {
        timeTest(arrTime);
        if(trainName == null) {
            trainName = "";
            arrTime = "";
            lastStation = "";
        }
        stationsList = new ArrayList<>();
        timeList = new ArrayList<>();
        this.arrTime = arrTime;
        this.lastStation = lastStation;
        this.trainName = trainName;
    }

    protected static void timeTest(String arrTime) {
        String regex = "\\d{1,2}:\\d{2}";
        if(!arrTime.matches(regex) || getMinFromTime(arrTime) >= 1440) {
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
            if (timeList.get(i).equalsIgnoreCase(arrivalTime) &&
                    stationsList.get(i).equalsIgnoreCase(station)) {
                timeList.remove(i);
                stationsList.remove(i);

            }
        }
    }

    //first num is station num, second - difference between two times

    public int findNearestStation(String destStation, String currentTime) {
        timeTest(currentTime);
        int time = getMinFromTime(currentTime);
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < stationsList.size(); i++) {
            int difference = getMinFromTime(timeList.get(i)) - time;
            if(difference >= 0 && result > difference &&
                    stationsList.get(i).equalsIgnoreCase(destStation)) {
                result = difference;
            }
        }
        return result;
    }

    public ArrayList<String> getStationsList() {
        return stationsList;
    }

    public ArrayList<String> getTimeList() {
        return timeList;
    }

    public String getTrainName() {
            return trainName;
    }

    public String getLastStation() {
        return lastStation;
    }

    public String getArrTime() {
        return arrTime;
    }
}
