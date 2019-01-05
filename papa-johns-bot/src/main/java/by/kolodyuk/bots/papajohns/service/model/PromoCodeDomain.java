package by.kolodyuk.bots.papajohns.service.model;

public class PromoCodeDomain {

    private String code;
    private String name;
    private String prize;
    private int moneyRequired;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrize() {
        return prize;
    }

    public void setPrize(String prize) {
        this.prize = prize;
    }

    public int getMoneyRequired() {
        return moneyRequired;
    }

    public void setMoneyRequired(int moneyRequired) {
        this.moneyRequired = moneyRequired;
    }
}
