package trains;

import java.util.ArrayList;

public class TrainManager {

    private ArrayList<Train> trains;

    public TrainManager() {
        trains = new ArrayList<>();
    }

    public void addTrain(Train train) {
        trains.add(train);
    }

    public void deleteTrain(String trainName) {
        trains.removeIf(train -> train.getTrainName().equals(trainName));
    }

    private Train getTrain(String trainName) {
        for (Train train : trains) {
            if (train.getTrainName().equals(trainName))
                return train;
        }
        throw new IllegalArgumentException("train with name:" + trainName + "not found");
    }

    public void addStation(String trainName, String station, String arrivalTime) {
        Train.timeTest(arrivalTime);
        getTrain(trainName).addStation(arrivalTime, station);
    }

    public void deleteStation(String trainName, String station, String arrivalTime) {
        Train.timeTest(arrivalTime);
        getTrain(trainName).deleteStation(arrivalTime, station);
    }

    private int min(ArrayList<Integer> list) {
        int min = Integer.MAX_VALUE;
        int numOfTrain = -1;
        for (int i = 0; i < list.size(); i++) {
            Integer time = list.get(i);
            if (time != null) {
                if (min > time) {
                    min = time;
                    numOfTrain = i;
                }
            }
        }
        return numOfTrain;
    }

    public Train searchForTrain(String destStation, String currentTime) {
        Train.timeTest(currentTime);
        ArrayList<Integer> arr = new ArrayList<>();
        for (Train train : trains) {
            int time = train.findNearestStation(destStation, currentTime);
            if (time >= 0) {
                arr.add(time);
            }
        }
        int res = min(arr);
        if (res >= 0) {
            return trains.get(res);
        } else {
            return new Train("No such train!", "00:00", null);
        }
    }
}

