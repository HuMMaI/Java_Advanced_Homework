package homework1;

public class Accounting {
    private final int workingDayLength = 8;
    private final int numberOfHoursInMonth = 160;
    private int hourlyRate;
    private int hoursWorked;
    private int hospitalDayPayment;
    private int numberOfHospitalDays;
    private int extraHours;

    public Accounting(int hourlyRate, int hoursWorked, int hospitalDayPayment, int numberOfHospitalDays,
                      int extraHours) {
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
        this.extraHours = extraHours;
        this.hospitalDayPayment = hospitalDayPayment;
        this.numberOfHospitalDays = numberOfHospitalDays;
    }

    public int hospitalCalculation(){
        return hospitalDayPayment * numberOfHospitalDays;
    }

    public int salaryCalculation() throws HoursException {
        int salary;
        int hoursLimit = numberOfHoursInMonth - (numberOfHospitalDays * workingDayLength);

        if (hoursWorked < 0 || hoursWorked > hoursLimit){
            throw new HoursException("Wrong hours!");
        }

        salary = (hourlyRate * hoursWorked) + hospitalCalculation() + (extraHours * (2 * hourlyRate)) - getFine();

        return salary;
    }

    public int getFine(){
        int fine = 0;
        int numberOfPasses = numberOfHoursInMonth - ((numberOfHospitalDays * workingDayLength) + hoursWorked);

        if (numberOfPasses > 10){
            fine = (numberOfPasses - 10) * 15;
        }

        return fine;
    }

    public int getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(int hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public int getHospitalDayPayment() {
        return hospitalDayPayment;
    }

    public void setHospitalDayPayment(int hospitalDayPayment) {
        this.hospitalDayPayment = hospitalDayPayment;
    }

    public int getNumberOfHospitalDays() {
        return numberOfHospitalDays;
    }

    public void setNumberOfHospitalDays(int numberOfHospitalDays) {
        this.numberOfHospitalDays = numberOfHospitalDays;
    }
}
