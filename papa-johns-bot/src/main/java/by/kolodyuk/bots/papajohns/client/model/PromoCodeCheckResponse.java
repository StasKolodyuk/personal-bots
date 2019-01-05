package by.kolodyuk.bots.papajohns.client.model;

public class PromoCodeCheckResponse {

    Stock stock;
    String success;

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }
}
