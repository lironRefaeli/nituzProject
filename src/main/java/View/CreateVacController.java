package View;

import Controllers.VacationController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.shape.Rectangle;

import java.time.format.DateTimeFormatter;


public class CreateVacController extends AView{

    @FXML
    private ComboBox<String> destination;
    @FXML
    private TextField AdultNum;
    private boolean isNumTouched = false; //if any num is touched.
    @FXML
    private TextField ChildNum;
    @FXML
    private TextField BabyNum;
    @FXML
    private DatePicker DepartureDate;
    @FXML
    private DatePicker ReturnDate;
    @FXML
    private ComboBox includeHotel;
    @FXML
    private ComboBox<Integer> hotelRank;
    @FXML
    private ComboBox<String> flightComp;
    @FXML
    private ComboBox<String> vacationType;
    @FXML
    private ComboBox IncludeBagage;
    @FXML
    private CheckBox includeReturn;


    @FXML
    void initialize() {
        double widthInitial = 200;
        double heightInitial = 200;

    }


    public void create(ActionEvent actionEvent) {
        String flightCompany = "", departureDate = "", backDate = "", baggageIncluded = "",
                Country = "", flightBackIncluded = "", vacationKind = "", hotelIncluded = "";
        int numOfTicketsAdult = -1, numOfTicketsChild = -1, numOfTicketsBaby = -1, rankOfHotel = -1;
        if (destination.getValue() != null) {
            Country = destination.getValue();
        }
        if (isNumTouched) {
            numOfTicketsAdult = Integer.valueOf(AdultNum.getText());
            numOfTicketsChild = Integer.valueOf(ChildNum.getText());
            numOfTicketsBaby = Integer.valueOf(BabyNum.getText());
        }
        if (DepartureDate.getValue() != null) {
            departureDate = DepartureDate.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        }
        if (includeReturn.isSelected()) {
            flightBackIncluded = "true";
            if (ReturnDate.getValue() != null) {
                backDate = ReturnDate.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            }
        }
        else{
            flightBackIncluded="false";
        }
        if (vacationType.getValue() != null) {
            vacationKind = vacationType.getValue();
        }
        if (vacationType.getValue() != null) {
            flightCompany = flightComp.getValue();
        }
        /**
        if (includeHotel.isSelected())
            hotelIncluded = "true";
        if (hotelStars.getValue() != null) {
            rankOfHotel = hotelStars.getValue();
        }
        if (includeBag.isSelected()) {
            baggageIncluded = "true";
        }
**/
        VacationController controller = (VacationController) this.controller;
        controller.Create(flightCompany,departureDate,backDate,baggageIncluded,Country,flightBackIncluded,numOfTicketsAdult,numOfTicketsAdult,numOfTicketsBaby,
                vacationKind,hotelIncluded,rankOfHotel);
        this.ShowAlert();
    }
}
