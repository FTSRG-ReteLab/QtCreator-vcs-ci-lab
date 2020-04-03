package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TrainSensorTest {

    TrainController mockTrainCon;
    TrainUser mockTrainUser;
    TrainSensorImpl trainSensor;

    @Before
    public void before() {
        mockTrainCon = mock(TrainController.class);
        mockTrainUser = mock(TrainUser.class);
        trainSensor = new TrainSensorImpl(mockTrainCon, mockTrainUser);
    }

    @Test
    public void ChechSpeedLimit(){
        trainSensor.overrideSpeedLimit(10);
        Assert.assertEquals(trainSensor.getSpeedLimit(), 10);
    }

    @Test
    public void AbsuMinMargin(){
        trainSensor.overrideSpeedLimit(-1);
        verify(mockTrainUser).setAlarmState(true);
    }

    @Test
    public void AbsuMaxMargin(){
        trainSensor.overrideSpeedLimit(501);
        verify(mockTrainUser, times(1)).getAlarmState();
    }

    @Test
    public void RelMargin(){
        trainSensor.overrideSpeedLimit(4);
        verify(mockTrainUser, times(1)).setAlarmState(true);
    }

    @Test
    public void BetweenMargin(){
        trainSensor.overrideSpeedLimit(300);
        verify(mockTrainUser, times(0)).setAlarmState(false);
    }
}
