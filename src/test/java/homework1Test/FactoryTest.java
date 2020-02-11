package homework1Test;

import homework1.Accounting;
import homework1.Factory;
import homework1.HoursException;
import homework1.Worker;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashSet;
import java.util.Set;

public class FactoryTest {
    private Factory factory;
    private Accounting accounting;

    @Before
    public void setup(){
        factory = new Factory();
        accounting = new Accounting(20, 120, 120,
                5, 10);
    }

    @After
    public void afterTest(){
        factory = null;
        accounting = null;
    }

    @Test
    public void itAddSalaryToWorker(){
        factory.addSalaryToWorker(new Worker("Worker", "One", 22), accounting);
        factory.addSalaryToWorker(new Worker("Worker", "Two", 31), accounting);
    }

    @Test(expected = NullPointerException.class)
    public void itAddSalaryToWorkerWithException() throws HoursException {
        factory.addSalaryToWorker(null, accounting);
    }

    @Test
    public void itOutputAllWorkers(){
        factory.addSalaryToWorker(new Worker("Worker", "One", 22), accounting);
        factory.addSalaryToWorker(new Worker("Worker", "Two", 31), accounting);

        Set<Worker> expectedWorkers = new LinkedHashSet<>();
        expectedWorkers.add(new Worker("Worker", "One", 22));
        expectedWorkers.add(new Worker("Worker", "Two", 31));

        Assert.assertEquals(expectedWorkers, factory.getWorkers().keySet());
    }
}
