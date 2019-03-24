import java.util.ArrayList;

public class Train {

    private ArrayList<String> stationsList;
    private ArrayList<String> timeList;
    private String trainName;
    private String lastStation;
    private String arrTime;

    public Train(String trainName, String arrTime, String lastStation) {
        stationsList = new ArrayList<>();
        timeList = new ArrayList<>();
        this.arrTime = arrTime;
        this.lastStation = lastStation;
        this.trainName = trainName;
    }

    private Integer getMinFromTime(String time) {
        String[] s = time.split(":");
        return Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
    }

    public void addStation(String arrivalTime, String station) {
        timeList.add(arrivalTime);
        stationsList.add(station);
    }

    public void deleteStation(String arrivalTime, String station) {
        for (int i = 0; i < timeList.size(); i++) {
            if (timeList.get(i).equalsIgnoreCase(arrivalTime) &&
                    stationsList.get(i).equalsIgnoreCase(station)) {
                timeList.remove(i);
                stationsList.remove(i);

            }
        }
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
