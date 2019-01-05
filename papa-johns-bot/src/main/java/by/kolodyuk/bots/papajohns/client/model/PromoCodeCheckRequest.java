package by.kolodyuk.bots.papajohns.client.model;

public class PromoCodeCheckRequest {

    private String cityId;
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public static PromoCodeCheckRequest of(String code) {
        PromoCodeCheckRequest promoCodeCheckRequest = new PromoCodeCheckRequest();
        promoCodeCheckRequest.setCode(code);
        promoCodeCheckRequest.setCityId("1"); // Minsk

        return promoCodeCheckRequest;
    }
}
