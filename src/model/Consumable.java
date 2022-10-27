package model;

public class Consumable {
    private int idNumber;
    private String name;
    private String type;
    private String startDate;
    private String endDate;
    private Double totalhours;
    private Double ratings;
    private int days;

    public Consumable() {
        startDate = "";
        endDate = "";
        totalhours = 0.0;
        ratings = 0.0;
        days = 0;
    }

    

    public Consumable(int idNumber,String name, String type, String startDate, String endDate, Double totalhours, Double ratings,
            int days) {
        this.idNumber = idNumber;
        this.name = name;
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalhours = totalhours;
        this.ratings = ratings;
        this.days = days;
    }


    public int getIdNumber() {
        return idNumber;
    }



    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Double getTotalhours() {
        return totalhours;
    }

    public void setTotalhours(Double totalhours) {
        this.totalhours = totalhours;
    }

    public Double getRatings() {
        return ratings;
    }

    public void setRatings(Double ratings) {
        this.ratings = ratings;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    

    
}
