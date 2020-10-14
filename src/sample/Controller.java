package sample;

import data_manage.FileManage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.Cat;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    private final NumberFormat integerFormat = new DecimalFormat("#,###");

    public Controller() throws IOException {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadGender();
        loadSpecies();
        viewAll();

    }

    @FXML
    private Button deleteButton;

    @FXML
    private Button addCustomer;

    @FXML
    private TextField inputCusName;

    @FXML
    private TextField inputCatAge;

    @FXML
    private TextField inputCusPhone;

    @FXML
    private TextField inputCatName;

    @FXML
    private CheckBox inputCastrated;

    @FXML
    private ChoiceBox inputSpecies;

    @FXML
    private TextField inputWeight;

    @FXML
    private ChoiceBox inputGender;

    @FXML
    private TextField inputHairColor;

    @FXML
    private TableView<Cat> table;

    @FXML
    private TableColumn<Cat, String> outputCusName;

    @FXML
    private TableColumn<Cat, String> outputCusPhone;

    @FXML
    private TableColumn<Cat, String> outputCatName;

    @FXML
    private TableColumn<Cat, String> outputCatSpecies;

    @FXML
    private TableColumn<Cat, Boolean> outputCatGender;

    @FXML
    private TableColumn<Cat, Integer> outputCatAge;

    @FXML
    private TableColumn<Cat, String> outputHairColor;

    @FXML
    private TableColumn<Cat, Boolean> outputCastrated;

    @FXML
    private TableColumn<Cat, Float> outputWeight;

    @FXML
    private TableColumn<Cat, String> outputTime;

    @FXML
    private TableColumn<Cat, Long> outputPrice;

    @FXML
    private Button update;

    private ObservableList<Cat> catList;


    ObservableList speciesList = FXCollections.observableArrayList();

    public void resetView(MouseEvent click) {
        if (click.getClickCount() == 2) {
            viewAll();
        }
    }

    public void viewAll() {
        catList = FXCollections.observableArrayList(fileManage.readFile("cat.dat"));
        outputCusName.setCellValueFactory(new PropertyValueFactory<Cat, String>("ownerName"));
        outputCusPhone.setCellValueFactory(new PropertyValueFactory<Cat, String>("ownerPhone"));
        outputCatName.setCellValueFactory(new PropertyValueFactory<Cat, String>("name"));
        outputCatAge.setCellValueFactory(new PropertyValueFactory<Cat, Integer>("age"));
        outputCastrated.setCellValueFactory(new PropertyValueFactory<Cat, Boolean>("castrated"));
        outputCatGender.setCellValueFactory(new PropertyValueFactory<Cat, Boolean>("gender"));
        outputCatSpecies.setCellValueFactory(new PropertyValueFactory<Cat, String>("species"));
        outputHairColor.setCellValueFactory(new PropertyValueFactory<Cat, String>("hairColor"));
        outputWeight.setCellValueFactory(new PropertyValueFactory<Cat, Float>("weight"));
        outputTime.setCellValueFactory(new PropertyValueFactory<Cat, String>("timeIn"));
        outputPrice.setCellValueFactory(new PropertyValueFactory<Cat, Long>("price"));
        outputPrice.setCellFactory(tc -> new TableCell<Cat, Long>() {
            @Override
            protected void updateItem(Long price, boolean empty) {
                super.updateItem(price, empty);
                if (empty) {
                    setText(null);
                } else {
                    setText(integerFormat.format(price));
                }
            }
        });
        outputCatGender.setCellFactory(tc -> new TableCell<Cat, Boolean>() {
            @Override
            protected void updateItem(Boolean gender, boolean empty) {
                super.updateItem(gender, empty);
                if (empty) {
                    setText(null);
                } else {
                    if(gender)
                    setText("Male");
                    else
                        setText("Female");
                }
            }
        });
        outputCastrated.setCellFactory(tc -> new TableCell<Cat, Boolean>() {
            @Override
            protected void updateItem(Boolean castrated, boolean empty) {
                super.updateItem(castrated, empty);
                if (empty||!castrated) {
                    setText(null);
                } else {
                    setText("X");
                }
            }
        });
        table.setItems(catList);
    }


    private void loadSpecies() {
        speciesList.removeAll();
        String a = "Siamese";
        String b = "British Longhair";
        String c = "British Shorthair";
        String d = "Persian Shorthair";
        String e = "Persian Longhair";
        String f = "Himalaya Persian";
        String g = "Chinchilla";
        String i = "Scottish Fold";
        String k = "Munchkin";
        String l = "Sphynx";
        String m = "VietNam";
        speciesList.addAll(a, b, c, d, e, f, g, i, k, l, m);
        inputSpecies.getItems().addAll(speciesList);
    }

    ObservableList genderList = FXCollections.observableArrayList();

    private void loadGender() {
        genderList.removeAll();
        String a = "Male";
        String b = "Female";
        genderList.addAll(a, b);
        inputGender.getItems().addAll(genderList);
    }

    public long checkPrice(String timeIn) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm dd/MM/yy");
        LocalDate now = LocalDate.from(LocalDateTime.now());

        LocalDate d1 = now;
        LocalDate d2 = LocalDate.parse(timeIn, dtf);
        long daysInBetween = ChronoUnit.DAYS.between(d2, d1);
        long price = 150000 * (daysInBetween + 1);
        return price;
    }

    public void add(javafx.event.ActionEvent actionEvent) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm dd/MM/yy");
        LocalDateTime now = LocalDateTime.now();
        try {
            String cusName = inputCusName.getText();
            String cusPhone = inputCusPhone.getText();
            String name = inputCatName.getText();
            int age = Integer.parseInt(inputCatAge.getText());
            boolean castrated = inputCastrated.isSelected();
            String species = String.valueOf(inputSpecies.getValue());
            float weight = Float.parseFloat(inputWeight.getText());
            String hairColor = inputHairColor.getText();
            boolean gender = inputGender.getValue().equals("Male");
            String timeIn = dtf.format(now);
            long price = checkPrice(timeIn);
            catList.add(new Cat(cusName, cusPhone, name, age, gender, species, weight, castrated, hairColor, timeIn, price));
            inputCusName.clear();
            inputCusPhone.clear();
            inputCatName.clear();
            inputCatAge.clear();
            inputHairColor.clear();
            inputWeight.clear();
        } catch (Exception exception) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Invalid Input!");
            alert.setHeaderText(null);
            alert.setContentText("Please try again");
            alert.showAndWait();
        }

        try {
            writeToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void help(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About \"Cat Hotel Management\"");
        alert.setHeaderText(null);
        alert.setContentText("Develop and publish by Nguyễn Thanh Tiến \n" +
                "Please contact if need to buy product or getting problem: \n" +
                "Phone: +84 367451097 \n" +
                "Email: nguyenthanhtien.vnuf@gmail.com");
        alert.showAndWait();
    }

    public void find(ActionEvent event) {
        ObservableList<Cat> searchList = FXCollections.observableArrayList();
        for (int i = 0; i < catList.size(); i++) {
            if (catList.get(i).getOwnerName().toLowerCase().contains(inputCusName.getText().toLowerCase())
                    && !inputCusName.getText().equals("")) {
                searchList.add(catList.get(i));
            }
            if (catList.get(i).getOwnerPhone().toLowerCase().contains(inputCusPhone.getText().toLowerCase())
                    && !inputCusPhone.getText().equals("")) {
                searchList.add(catList.get(i));
            }
            if (catList.get(i).getName().toLowerCase().contains(inputCatName.getText().toLowerCase())
                    && !inputCatName.getText().equals("")) {
                searchList.add(catList.get(i));
            }
        }
        table.setItems(searchList);
    }

    public void delete(ActionEvent event) {
        Cat selectedCat = table.getSelectionModel().getSelectedItem();
        if (selectedCat != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText(null);
            alert.setContentText("Do you want to check out?\n" +
                    "The total price is: " + integerFormat.format(checkPrice(selectedCat.getTimeIn())) + " VND");
            ButtonType buttonTypeYes = new ButtonType("Yes", ButtonBar.ButtonData.YES);
            ButtonType buttonTypeNo = new ButtonType("No", ButtonBar.ButtonData.NO);
            alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);
            Optional<ButtonType> choice = alert.showAndWait();
            if (choice.get().getButtonData() == ButtonBar.ButtonData.YES) {
                catList.remove(selectedCat);
                try {
                    writeToFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Notification");
            alert.setHeaderText(null);
            alert.setContentText("Please choose one!");
            alert.showAndWait();
        }
    }

    public void selected(MouseEvent click) {
        if (click.getClickCount() == 2) {

            Cat selectedCat = table.getSelectionModel().getSelectedItem();
            inputCusName.setText(selectedCat.getOwnerName());
            inputCusPhone.setText(selectedCat.getOwnerPhone());
            inputCatName.setText(selectedCat.getName());
            inputCatAge.setText(String.valueOf(selectedCat.getAge()));
            inputGender.setValue(selectedCat.isGender());
            inputSpecies.setValue(selectedCat.getSpecies());
            if (selectedCat.isGender()) {
                inputGender.setValue("Male");
            } else {
                inputGender.setValue("Female");
            }
            inputCastrated.setSelected(selectedCat.isCastrated());
            inputHairColor.setText(selectedCat.getHairColor());
            inputWeight.setText(String.valueOf(selectedCat.getWeight()));
        }
    }

    public void update(ActionEvent event) {
        Cat selectedCat = table.getSelectionModel().getSelectedItem();
        add(selectedCat);
        catList.remove(selectedCat);
        inputCusName.clear();
        inputCusPhone.clear();
        inputCatName.clear();
        inputCatAge.clear();
        inputHairColor.clear();
        inputWeight.clear();
        try {
            writeToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void add(Cat selectedCat) {
        String cusName = inputCusName.getText();
        String cusPhone = inputCusPhone.getText();
        String name = inputCatName.getText();
        int age = Integer.parseInt(inputCatAge.getText());
        boolean castrated = inputCastrated.isSelected();
        String species = String.valueOf(inputSpecies.getValue());
        float weight = Float.parseFloat(inputWeight.getText());
        String hairColor = inputHairColor.getText();
        boolean gender = inputGender.getValue().equals("Male");
        String timeIn = selectedCat.getTimeIn();
        Long price = selectedCat.getPrice();
        catList.add(new Cat(cusName, cusPhone, name, age, gender, species, weight, castrated, hairColor, timeIn, price));
    }

    FileManage fileManage = new FileManage();

    public void writeToFile() throws IOException {
        fileManage.writeToFile("cat.dat", catList);
    }

}
