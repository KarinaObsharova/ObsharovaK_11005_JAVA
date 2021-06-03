public class Main {
    public static void main(String[] args) {
        Crud<Animals> test = new Crud();
        test.create( new Animals("Bob", 25));
        test.create(new Animals("Oleg", 46));
        test.create(new Animals("Anasha", 67));
        System.out.println(test.read(0));
        System.out.println("----------------");
        test.update(new Animals("Oleg",54));
        test.delete(new Animals("Anasha", 67));
        for (Animals x:test.items) {
            x.print();
        }
    }
}
