import trains.Train;
import trains.TrainManager;
import org.junit.Assert;
import org.junit.Test;

public class TrainTest {

    @Test
    public void TrainTest() {
        Train tr1 = new Train("Train1", "22:30", "Kushelevka");
        tr1.addStation("20:30", "A");
        tr1.addStation("19:30", "B");
        tr1.addStation("21:30", "C");
        tr1.addStation("16:30", "D");
        Train tr2 = new Train("Train2", "23:30", "Kushelevka");
        tr2.addStation("20:30", "C");
        tr2.addStation("19:30", "D");
        tr2.addStation("21:30", "E");
        tr2.addStation("16:30", "A");
        Train tr3 = new Train("Train3", "21:30", "Kushelevka");
        tr3.addStation("20:30", "F");
        tr3.addStation("19:30", "E");
        tr3.addStation("10:30", "A");
        tr3.addStation("16:30", "B");
        TrainManager tm = new TrainManager();
        tm.addTrain(tr1);
        tm.addTrain(tr2);
        tm.addTrain(tr3);
        Assert.assertEquals(tr1,            tm.searchForTrain("B", "18:30"));
        Assert.assertEquals(tr2,            tm.searchForTrain("C", "09:30"));
        Assert.assertEquals(tr1,            tm.searchForTrain("D", "16:30"));
        Assert.assertEquals(tr3,            tm.searchForTrain("F", "19:30"));
        Assert.assertEquals(tr2,            tm.searchForTrain("C", "13:30") );
        Assert.assertEquals(tr3,            tm.searchForTrain("E", "10:30"));

    }
}
