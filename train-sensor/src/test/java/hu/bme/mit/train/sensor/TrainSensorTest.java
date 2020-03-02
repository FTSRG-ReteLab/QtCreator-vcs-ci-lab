package hu.bme.mit.train.sensor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import static org.mockito.Mockito.*;

public class TrainSensorTest {

    @Before
    public void before() {
    }

    @Test
    public void ThisIsAnExampleTestStub() {
        TrainSensorImpl sensor = new TrainSensorImpl(new TrainControllerImpl(), new TrainUserImpl(new TrainControllerImpl()));
        sensor.overrideSpeedLimit(500);
        assertEquals(500, sensor.getSpeedLimit());
    }
}
