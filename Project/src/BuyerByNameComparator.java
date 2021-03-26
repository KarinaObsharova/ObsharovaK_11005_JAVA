import java.io.Serializable;
import java.util.Comparator;

public class BuyerByNameComparator implements Comparator<Buyer>, Serializable {

    @Override
    public int compare(Buyer o1, Buyer o2) {
        return o1.name.compareTo(o2.name);
    }
}
