import java.util.ArrayList;

public class TrainManager {

    private ArrayList<Train> trains;

    public TrainManager() {
        trains = new ArrayList<>();
    }

    public void addTrain(String trainName, String arrTime, String lastStation) {
        trains.add(new Train(trainName, arrTime, lastStation));
    }

    public void deleteTrain(String trainName) {
        trains.removeIf(train -> train.getTrainName().equalsIgnoreCase(trainName));
    }

    public void addStation(String trainName, String station, String arrivalTime) {
        for (Train train : trains) {
            if (train.getTrainName().equalsIgnoreCase(trainName)) {
                train.addStation(arrivalTime, station);
            }
        }
    }

    public void deleteStation(String trainName, String station, String arrivalTime) {
        for (Train train : trains) {
            if (train.getTrainName().equalsIgnoreCase(trainName)) {
                train.deleteStation(arrivalTime, station);
            }
        }
    }

    public void searchForTrain() {
        throw new UnsupportedOperationException();
    }

}
