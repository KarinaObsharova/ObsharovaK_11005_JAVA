public class Request {
    private Buyer buyer;
    private Product product;

    public Request(Buyer buyer, Product product){
        this.buyer = buyer;
        this.product = product;
    }

    @Override
    public String toString() {
        return "New order  \n" + buyer +"\n" + product;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public Product getProduct() {
        return product;
    }
}
