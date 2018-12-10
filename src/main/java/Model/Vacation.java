package Model;

public class Vacation {

    private String flightCompany;
    private String departureDate;
    private String backDate;
    private String baggageIncluded; //boolean
    private String Country;
    private String flightBackIncluded; //boolean
    private int numOfTicketsAdult;
    private int numOfTicketsKid;
    private int numOfTicketsBaby;
    private String vacationKind;
    private String hotelIncluded; //boolean
    private int rankOfHotel;
    private int id;
    private String userName;

    static int numOfVactions=0;//id

    //string ="" --> empty
    //int =-1 -->empty


    public Vacation(String flightCompany, String departureDate, String backDate, String baggageIncluded, String country, String flightBackIncluded, int numOfTicketsAdult,int numOfTicketsChild,int numOfTicketsBaby, String vacationKind, String hotelIncluded, int rankOfHotel,String userName) {
        this.flightCompany = flightCompany;
        this.departureDate = departureDate;
        this.backDate = backDate;
        this.baggageIncluded = baggageIncluded;
        Country = country;
        this.flightBackIncluded = flightBackIncluded;
        this.numOfTicketsAdult = numOfTicketsAdult;
        this.numOfTicketsKid=numOfTicketsChild;
        this.numOfTicketsBaby=numOfTicketsBaby;
        this.vacationKind = vacationKind;
        this.hotelIncluded = hotelIncluded;
        this.rankOfHotel = rankOfHotel;
        this.userName=userName;
        id=numOfVactions;

        numOfVactions+=1;
    }

    public String getFlightCompany() {
        return flightCompany;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public String getBackDate() {
        return backDate;
    }

    public String getBaggageIncluded() {
        return baggageIncluded;
    }

    public String getCountry() {
        return Country;
    }

    public String getFlightBackIncluded() {
        return flightBackIncluded;
    }

    public int getNumOfTicketsAdult() {
        return numOfTicketsAdult;
    }

    public int getNumOfTicketsKid() {
        return numOfTicketsKid;
    }

    public int getNumOfTicketsBaby() {
        return numOfTicketsBaby;
    }

    public String getVacationKind() {
        return vacationKind;
    }

    public String getHotelIncluded() {
        return hotelIncluded;
    }

    public int getRankOfHotel() {
        return rankOfHotel;
    }

    public String getUserName() {
        return userName;
    }

    public int getId() {
        return id;
    }
}
