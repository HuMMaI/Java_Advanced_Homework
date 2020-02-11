package homework1;

import java.util.LinkedHashMap;
import java.util.Map;

public class Factory {
    private Map<Worker, Integer> workers = new LinkedHashMap<>();

    public void addSalaryToWorker(Worker worker, Accounting accounting) throws HoursException {
        int salary = accounting.salaryCalculation();
        workers.put(worker, salary);
    }

    public Map<Worker, Integer> getWorkers() {
        return workers;
    }
}
