package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Cat Hotel Management");
        primaryStage.setScene(new Scene(root, 1100, 700));
        primaryStage.show();
//        FileChooser fileChooser = new FileChooser();
//        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF File", "*.pdf"));
//        fileChooser.setTitle("Save To PDF");
//        fileChooser.setInitialFileName("untitle.pdf");
//        File file = fileChooser.showSaveDialog(primaryStage);
//        if (file != null) {
//            String str = file.getAbsolutePath();
//            FileOutputStream fos = new FileOutputStream(str);
//            PD pdf =
//        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
