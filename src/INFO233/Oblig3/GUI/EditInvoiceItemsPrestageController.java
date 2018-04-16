package INFO233.Oblig3.GUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class EditInvoiceItemsPrestageController {

    @FXML
    private TextField id;

    @FXML
    private Parent parent;

    public void onNext(){
        int collectedId = Integer.parseInt(id.getText());
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("EditInvoiceItemsFXML.fxml"));
            AnchorPane anchor = loader.load();
            EditInvoiceItemsController controller = loader.getController();
            controller.setId(collectedId);
            Scene scene = new Scene(anchor);
            Stage stage = (Stage) parent.getScene().getWindow();
            stage.setScene(scene);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void onBack(){
        try {
            AnchorPane anchor = FXMLLoader.load(getClass().getResource("MainSceneFXML.fxml"));
            Scene scene = new Scene(anchor);
            Stage stage = (Stage) parent.getScene().getWindow();
            stage.setScene(scene);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}