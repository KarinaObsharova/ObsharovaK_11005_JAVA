public class Applications {
    private Subscriber subscriber;
    private Tariff tariff;


    Applications(Subscriber subscriber, Tariff tariff){
        this.subscriber = subscriber;
        this.tariff = tariff;
    }

    Applications(Subscriber subscriber){
        this.subscriber = subscriber;
    }

    @Override
    public String toString() {
        return subscriber + "\n" + "Запрос на тариф: " + tariff + "\n ------------";
    }

    public Tariff getTariff(){
        return tariff;
    }

    public Subscriber getSubscriber(){
        return subscriber;
    }
}
