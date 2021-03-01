public class ApplicationsNumber {
    private Subscriber subscriber;
    private String number;

    ApplicationsNumber(Subscriber subscriber, String number){
        this.subscriber = subscriber;
        this.number = number;
    }

    @Override
    public String toString() {
        return subscriber + "\n" + "Запрос на номер:" + number;
    }
    public String getNumber(){
        return number;
    }
    public Subscriber subscriber(){
        return subscriber;
    }
}
