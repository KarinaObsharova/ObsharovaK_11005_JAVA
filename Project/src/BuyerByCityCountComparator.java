import java.io.Serializable;
import java.util.Comparator;

public class BuyerByCityCountComparator implements Comparator<Buyer>, Serializable {
    @Override
    public int compare(Buyer o1, Buyer o2) {
        Integer size1 = o1.cities.size();
        Integer size2 = o2.cities.size();
        return size1.compareTo(size2);
    }
}
