import java.io.Serializable;
import java.util.Comparator;

public class BuyerByOrdersCountComparator implements Comparator<Buyer>, Serializable {
    @Override
    public int compare(Buyer o1, Buyer o2) {
        Integer size1 = 0;
        Integer size2 = 0;
        for (City i : o1.cities)
            size1 += i.orders.size();
        for (City i : o2.cities)
            size2 += i.orders.size();
        return size1.compareTo(size2);

    }
        
}
