package View;

import Controllers.VacationController;
import Model.Vacation;
import com.sun.org.apache.regexp.internal.RE;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class SearchVacController extends AView {

    @FXML
    private AnchorPane extendableSearchPane;
    @FXML
    private TitledPane accord;
    private Rectangle clipRect;

    //Vacation information:
    @FXML
    private ComboBox<String> destination;
    private boolean isNumTouched = false; //if any num is touched.
    @FXML
    private TextField AdultNum;
    int i_AdultNum = 0;
    private final int maxAd = 10;
    private final int minAd = 0;
    @FXML
    private TextField ChildNum;
    int i_ChildNum = 0;
    private final int maxCh = 10;
    private final int minCh = 0;
    @FXML
    private TextField BabyNum;
    int i_BabyNum = 0;
    private final int maxBa = 10;
    private final int minBa = 0;
    @FXML
    private DatePicker DepartureDate;
    @FXML
    private ComboBox<String> includeReturn;
    @FXML
    private DatePicker ReturnDate;
    @FXML
    private ComboBox<String> includeHotel;
    @FXML
    private ComboBox<String> hotelStars;
    @FXML
    private ComboBox<String> hotelType;
    @FXML
    private ComboBox<String> flightComp;
    @FXML
    private ComboBox<String> vacationType;
    @FXML
    private ComboBox<String> includeBag;
    @FXML
    private TableView<Vacation> vacTable;


    @FXML
    void initialize() {
        double widthInitial = 200;
        double heightInitial = 200;
        clipRect = new Rectangle();
        clipRect.setWidth(widthInitial);
        clipRect.setHeight(0);
        clipRect.translateYProperty().set(heightInitial);
        extendableSearchPane.setClip(clipRect);
        extendableSearchPane.translateYProperty().set(-heightInitial);
        extendableSearchPane.prefHeightProperty().set(0);
        accord.setExpanded(false);
        clipRect.setWidth(extendableSearchPane.getWidth());
        toggleExtendableSearch();
        isNumTouched = false;
        i_AdultNum = 0;
        i_ChildNum = 0;
        i_BabyNum = 0;

    }


    @FXML
    public void toggleExtendableSearch() {

        clipRect.setWidth(extendableSearchPane.getWidth());

        if (clipRect.heightProperty().get() != 0) {

            // Animation for scroll up.
            Timeline timelineUp = new Timeline();

            // Animation of sliding the search pane up, implemented via
            // clipping.
            final KeyValue kvUp1 = new KeyValue(clipRect.heightProperty(), 0);
            final KeyValue kvUp2 = new KeyValue(clipRect.translateYProperty(), extendableSearchPane.getHeight());

            // The actual movement of the search pane. This makes the table
            // grow.
            final KeyValue kvUp4 = new KeyValue(extendableSearchPane.prefHeightProperty(), 0);
            final KeyValue kvUp3 = new KeyValue(extendableSearchPane.translateYProperty(), -extendableSearchPane.getHeight());

            final KeyFrame kfUp = new KeyFrame(Duration.millis(200), kvUp1, kvUp2, kvUp3, kvUp4);
            timelineUp.getKeyFrames().add(kfUp);
            timelineUp.play();
            accord.setExpanded(false);
        } else {

            // Animation for scroll down.
            Timeline timelineDown = new Timeline();

            // Animation for sliding the search pane down. No change in size,
            // just making the visible part of the pane
            // bigger.
            final KeyValue kvDwn1 = new KeyValue(clipRect.heightProperty(), extendableSearchPane.getHeight());
            final KeyValue kvDwn2 = new KeyValue(clipRect.translateYProperty(), 0);

            // Growth of the pane.
            final KeyValue kvDwn4 = new KeyValue(extendableSearchPane.prefHeightProperty(), extendableSearchPane.getHeight());
            final KeyValue kvDwn3 = new KeyValue(extendableSearchPane.translateYProperty(), 0);

            final KeyFrame kfDwn = new KeyFrame(Duration.millis(200), createBouncingEffect(extendableSearchPane.getHeight()), kvDwn1, kvDwn2,
                    kvDwn3, kvDwn4);
            timelineDown.getKeyFrames().add(kfDwn);

            timelineDown.play();
        }
    }

    public void withReturn(ActionEvent ae) {
        System.out.println(includeReturn.getValue());
        if (includeReturn.getValue().equals("yes")) {
            ReturnDate.setDisable(false);
        } else {
            ReturnDate.setDisable(true);
        }
    }

    public void withHotel(ActionEvent ae) {
        System.out.println(includeReturn.getValue());
        if (includeHotel.getValue().equals("yes")) {
            hotelStars.setDisable(false);
            hotelType.setDisable(false);
        } else {
            hotelStars.setDisable(true);
            hotelType.setDisable(true);
        }
    }


    public void addAdult(ActionEvent ae) {
        if (i_AdultNum < maxAd) {
            i_AdultNum++;
            AdultNum.setText("" + i_AdultNum);
            AdultNum.setEditable(false);

        }
    }

    public void minusAdult(ActionEvent ae) {
        if (minAd < i_AdultNum) {
            i_AdultNum--;
            AdultNum.setText("" + i_AdultNum);
            AdultNum.setEditable(false);
        }
    }

    public void addChild(ActionEvent ae) {
        if (i_ChildNum < maxCh) {
            i_ChildNum++;
            ChildNum.setText("" + i_ChildNum);
            ChildNum.setEditable(false);

        }
    }

    public void minusChild(ActionEvent ae) {
        if (minCh < i_ChildNum) {
            i_ChildNum--;
            ChildNum.setText("" + i_ChildNum);
            ChildNum.setEditable(false);

        }
    }

    public void addBaby(ActionEvent ae) {
        if (i_BabyNum < maxBa) {
            i_BabyNum++;
            BabyNum.setText("" + i_BabyNum);
            BabyNum.setEditable(false);
        }
    }

    public void minusBaby(ActionEvent ae) {
        if (minBa < i_BabyNum) {
            i_BabyNum--;
            BabyNum.setText("" + i_BabyNum);
            BabyNum.setEditable(false);
        }
    }


    @FXML
    private void search(ActionEvent ae) {
        String flightCompany = "", departureDate = "", backDate = "", baggageIncluded = "",
                Country = "", flightBackIncluded = "", vacationKind = "", hotelIncluded = "";
        int numOfTicketsAdult = -1, numOfTicketsChild = -1, numOfTicketsBaby = -1, rankOfHotel = -1;
        if (destination.getValue() != null) {
            Country = destination.getValue();
        }
        if (AdultNum.getText() != null && Integer.valueOf(AdultNum.getText()) != 0)
            numOfTicketsAdult = Integer.valueOf(AdultNum.getText());
        if (ChildNum.getText() != null && Integer.valueOf(ChildNum.getText()) != 0)
            numOfTicketsChild = Integer.valueOf(ChildNum.getText());
        if (BabyNum.getText() != null && Integer.valueOf(BabyNum.getText()) != 0)
            numOfTicketsBaby = Integer.valueOf(BabyNum.getText());

        if (DepartureDate.getValue() != null) {
            departureDate = DepartureDate.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        }
        if (includeReturn.getValue()!=null && !includeReturn.getValue().equals("not must")) {
            flightBackIncluded = includeReturn.getValue();
            if (ReturnDate.getValue() != null) { //todo - add check to returndate bigger then departure date
                backDate = ReturnDate.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            }
        }

        if (vacationType.getValue() != null && !vacationType.getValue().equals("Exotic or Urbanic")) {
            vacationKind = vacationType.getValue();
        } // else ""

            if (vacationType.getValue() != null && !vacationType.getValue().equals("Exotic or Urbanic")) {
            vacationKind = vacationType.getValue();
        } // else ""

        if (flightComp.getValue() != null && !flightComp.getValue().equals("All the companies")) {
            flightCompany = flightComp.getValue();
        }
        if (includeHotel.getValue()!=null && !includeHotel.getValue().equals("not must")) {
            hotelIncluded = includeHotel.getValue();
            if (hotelStars.getValue() != null && !hotelStars.getValue().equals("Any rank")) {
                switch ((String)hotelStars.getValue()){
                    case "★":
                        rankOfHotel=1; break;
                    case "★★":
                        rankOfHotel=2; break;
                    case "★★★":
                        rankOfHotel=3; break;
                    case "★★★★":
                        rankOfHotel=4; break;
                    case "★★★★★":
                        rankOfHotel=5; break;
                    default: rankOfHotel=-1;
                }
            }
            if (hotelType.getValue() != null && !hotelType.getValue().equals("Any type")){
                vacationKind=hotelType.getValue();
            }
        }//hotels

        if (includeBag.getValue()!=null && !includeBag.getValue().equals("not must")) {
            baggageIncluded = includeBag.getValue();
        }
        
        VacationController controller = (VacationController) this.controller;
        List<Vacation> vacList = controller.Search(flightCompany, departureDate, backDate, baggageIncluded,
                Country, flightBackIncluded, numOfTicketsAdult, numOfTicketsChild, numOfTicketsBaby, vacationKind, hotelIncluded, rankOfHotel);


        ObservableList<Vacation> vacObsList = FXCollections.observableArrayList();
        vacObsList.addAll(vacList);

        TableColumn<Vacation,String> flightCompanyColumn = new TableColumn<>("FlightCompany");
        flightCompanyColumn.setMinWidth(200);
        flightCompanyColumn.setCellValueFactory(new PropertyValueFactory<>("flightCompany"));

        vacTable.setItems(vacObsList);
        vacTable.getColumns().addAll(flightCompanyColumn);



    }

    private EventHandler<ActionEvent> createBouncingEffect(double height) {
        final Timeline timelineBounce = new Timeline();
        timelineBounce.setCycleCount(2);
        timelineBounce.setAutoReverse(true);
        final KeyValue kv1 = new KeyValue(clipRect.heightProperty(), (height - 15));
        final KeyValue kv2 = new KeyValue(clipRect.translateYProperty(), 15);
        final KeyValue kv3 = new KeyValue(extendableSearchPane.translateYProperty(), -15);
        final KeyFrame kf1 = new KeyFrame(Duration.millis(100), kv1, kv2, kv3);
        timelineBounce.getKeyFrames().add(kf1);

        // Event handler to call bouncing effect after the scroll down is
        // finished.
        EventHandler<ActionEvent> handler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                timelineBounce.play();
            }
        };
        return handler;
    }
}

