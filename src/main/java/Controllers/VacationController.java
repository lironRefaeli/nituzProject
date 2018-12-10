package Controllers;

import Model.Vacation;
import Model.VacationModel;
import View.AView;
import javafx.scene.control.Alert;

import java.util.List;

public class VacationController extends AController {

    boolean isConnected;
    String username;
    VacationModel vacationModel;
    AView searchView;

    public VacationController(String username, VacationModel vacationModel, AView searchView) {
        this.username = username;
        if(username!=null) {
            if (username.equals(""))
                isConnected = false;
            else {
                isConnected = true;
                this.username=username;
            }
        }
        this.vacationModel = vacationModel;
        this.searchView = searchView;
    }

    public void Connect(){

    }


    public void Create(String flightCompany,String departureDate,String backDate,String baggageIncluded,
                       String Country,String flightBackIncluded,int numOfTicketsAdult,int numOfTicketsChild,int numOfTicketsBaby,String vacationKind,String hotelIncluded,int rankOfHotel) {
        if(!isConnected){
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("You Are Not Connected!");
            errorAlert.setContentText("You are not connected.\n Please connect - you can do it by press \"Connect\" on the top of the page. ");
            searchView.setAlert(errorAlert);
        }
        else{//connected so can publish vacation
            Vacation vacation=new Vacation(flightCompany,departureDate,backDate,baggageIncluded,Country,flightBackIncluded,numOfTicketsAdult,numOfTicketsChild,numOfTicketsBaby,vacationKind,hotelIncluded,rankOfHotel,username);
            boolean flag=vacationModel.Create(vacation);
            if(flag){
                Alert success = new Alert(Alert.AlertType.CONFIRMATION);
                success.setHeaderText("Action Succeeded");
                success.setContentText("New vacation added successfully! ");
                searchView.setAlert(success);
            }
        }

    }

    public List<Vacation> Search(String flightCompany, String departureDate, String backDate, String baggageIncluded,
                       String Country, String flightBackIncluded, int numOfTicketsAdult, int numOfTicketsChild, int numOfTicketsBaby, String vacationKind, String hotelIncluded, int rankOfHotel){
        List<Vacation> vacations=vacationModel.findVacations(flightCompany,departureDate,backDate,baggageIncluded,
                 Country,flightBackIncluded,numOfTicketsAdult,numOfTicketsChild, numOfTicketsBaby,vacationKind,hotelIncluded, rankOfHotel);
        if(vacations.size()==0){//no vacation founded
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Error");
            errorAlert.setContentText("Can't find vaction with those details. Change the details and try again. ");
            searchView.setAlert(errorAlert);
            return  null;
        }
        return vacations;
    }
}
