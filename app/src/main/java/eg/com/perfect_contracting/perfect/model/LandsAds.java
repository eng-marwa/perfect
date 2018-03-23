package eg.com.perfect_contracting.perfect.model;

/**
 * Created by java on 01/12/2017.
 */

public class LandsAds {
    private String adTitle;
    private String adDesc;
    private String image;
    private String location;
    private String address;
    private String area;
    private String price;
    private String priceDetails;
    private int defaultImg;
    public LandsAds() {
    }

    public LandsAds(String adTitle, int defaultImg) {
        this.adTitle = adTitle;
        this.defaultImg = defaultImg;
    }

    public int getDefaultImg() {
        return defaultImg;
    }

    public void setDefaultImg(int defaultImg) {
        this.defaultImg = defaultImg;
    }

    public String getAdTitle() {
        return adTitle;
    }

    public void setAdTitle(String adTitle) {
        this.adTitle = adTitle;
    }

    public String getAdDesc() {
        return adDesc;
    }

    public void setAdDesc(String adDesc) {
        this.adDesc = adDesc;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPriceDetails() {
        return priceDetails;
    }

    public void setPriceDetails(String priceDetails) {
        this.priceDetails = priceDetails;
    }

    public LandsAds(String adTitle, String adDesc, String image, String location, String address, String area, String price, String priceDetails) {
        this.adTitle = adTitle;
        this.adDesc = adDesc;
        this.image = image;
        this.location = location;
        this.address = address;
        this.area = area;
        this.price = price;
        this.priceDetails = priceDetails;
    }
}
