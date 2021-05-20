package az.company.turbo.dto;


import java.math.BigDecimal;





public class SearchDto {

    private String brandName;
    private String modelName;
    private String cityName;
    private boolean creditStatus;
    private boolean barterStatus;
    private Short maxReleaseDate;
    private Short minReleaseDate;
    private BigDecimal maxPrice;
    private BigDecimal minPrice;

    public SearchDto(String brandName, String modelName, String cityName, boolean creditStatus, boolean barterStatus, Short maxReleaseDate, Short minReleaseDate, BigDecimal maxPrice, BigDecimal minPrice) {
        if (!brandName.equals("")) this.brandName = brandName;
        else this.brandName = " ";
        if (!modelName.equals("")) this.modelName = modelName;
        else this.modelName = " ";
        if (!cityName.equals("")) this.cityName = cityName;
        else this.cityName = " ";
        if (creditStatus) this.creditStatus = creditStatus;
        else this.creditStatus = false;
        if (barterStatus) this.barterStatus = barterStatus;
        else this.barterStatus = false;
        if (maxReleaseDate!=0) this.maxReleaseDate = maxReleaseDate;
        else this.maxReleaseDate = Short.MAX_VALUE;

        this.minReleaseDate = minReleaseDate;


        if (maxPrice.doubleValue()!=0.0) this.maxPrice = maxPrice;
        else this.maxPrice = BigDecimal.valueOf(Double.MAX_VALUE);

        this.minPrice = minPrice;


    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        if (!brandName.equals("")) this.brandName = brandName;
        else this.brandName = " ";
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        if (!modelName.equals("")) this.modelName = modelName;
        else this.brandName = " ";
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        if (!cityName.equals("")) this.cityName = cityName;
        else this.cityName = " ";
    }

    public boolean isCreditStatus() {
        return creditStatus;
    }

    public void setCreditStatus(boolean creditStatus) {
        if (creditStatus) this.creditStatus = creditStatus;
        else this.creditStatus = false;
    }

    public boolean isBarterStatus() {
        return barterStatus;
    }

    public void setBarterStatus(boolean barterStatus) {
        if (barterStatus) this.barterStatus = barterStatus;
        else this.barterStatus = false;
    }

    public Short getMaxReleaseDate() {
        return maxReleaseDate;
    }

    public void setMaxReleaseDate(Short maxReleaseDate) {
        if (maxReleaseDate!=0) this.maxReleaseDate = maxReleaseDate;
        else this.maxReleaseDate = Short.MAX_VALUE;
    }

    public Short getMinReleaseDate() {
        return minReleaseDate;
    }

    public void setMinReleaseDate(Short minReleaseDate) {
        if (minReleaseDate!=0) this.minReleaseDate = minReleaseDate;
        else this.minReleaseDate = 0;
    }

    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(BigDecimal maxPrice) {
        if (maxPrice.doubleValue()!=0.0) this.maxPrice = maxPrice;
        else this.maxPrice = BigDecimal.valueOf(Double.MAX_VALUE);
    }

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(BigDecimal minPrice) {
        if (minPrice.doubleValue()!=0.0) this.minPrice = minPrice;
        else this.minPrice = BigDecimal.valueOf(Double.MIN_VALUE);
    }

    @Override
    public String toString() {
        return "SearchDto{" +
                "brandName='" + brandName + '\'' +
                ", modelName='" + modelName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", creditStatus=" + creditStatus +
                ", barterStatus=" + barterStatus +
                ", maxReleaseDate=" + maxReleaseDate +
                ", minReleaseDate=" + minReleaseDate +
                ", maxPrice=" + maxPrice +
                ", minPrice=" + minPrice +
                '}';
    }
}
