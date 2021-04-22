public class Task1 {
    public static void main(String[] args) {
        FourTuple<Integer, Integer, String, Long> four = makeFourValue();
        System.out.println(four.first + ", " + four.second + ", " + four.third + ", " + four.fourth);
    }
    public static FourTuple<Integer, Integer, String, Long> makeFourValue(){
        return new FourTuple<>(4, 5, "Third value", 345l);
    }
}
