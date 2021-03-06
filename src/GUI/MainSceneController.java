package GUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainSceneController {

    @FXML
    private Parent parent;

    /**
     * Spesifiserer hva som skjer når man trykker på knappen for ny customer.
     * Alle metodene under gjør så å si det samme, ved å vise til neste FXML-dokument.
     * Skriver derfor ikke mer javadoc på disse.
     */

    @FXML
    public void onNewCustomer() {
        try {
            AnchorPane anchor = FXMLLoader.load(getClass().getResource("NewCustomerFXML.fxml"));
            Scene scene = new Scene(anchor);
            Stage stage = (Stage) parent.getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onNewAddress(){
        try {
            AnchorPane anchor = FXMLLoader.load(getClass().getResource("NewAddressFXML.fxml"));
            Scene scene = new Scene(anchor);
            Stage stage = (Stage) parent.getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onShowInvoice() {
        try {
            AnchorPane anchor = FXMLLoader.load(getClass().getResource("InvoiceFXML.fxml"));
            Scene scene = new Scene(anchor);
            Stage stage = (Stage) parent.getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onNewInvoice() {
        try {
            AnchorPane anchor = FXMLLoader.load(getClass().getResource("NewInvoiceFXML.fxml"));
            Scene scene = new Scene(anchor);
            Stage stage = (Stage) parent.getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onNewCategory() {
        try {
            AnchorPane anchor = FXMLLoader.load(getClass().getResource("NewCategoryFXML.fxml"));
            Scene scene = new Scene(anchor);
            Stage stage = (Stage) parent.getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onNewInvoiceItem() {
        try {
            AnchorPane anchor = FXMLLoader.load(getClass().getResource("NewInvoiceItemFXML.fxml"));
            Scene scene = new Scene(anchor);
            Stage stage = (Stage) parent.getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onNewProduct() {
        try {
            AnchorPane anchor = FXMLLoader.load(getClass().getResource("NewProductFXML.fxml"));
            Scene scene = new Scene(anchor);
            Stage stage = (Stage) parent.getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onEditCustomer() {
        try {
            AnchorPane anchor = FXMLLoader.load(getClass().getResource("EditCustomerPrestageFXML.fxml"));
            Scene scene = new Scene(anchor);
            Stage stage = (Stage) parent.getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onEditAddress() {
        try {
            AnchorPane anchor = FXMLLoader.load(getClass().getResource("EditAddressPrestageFXML.fxml"));
            Scene scene = new Scene(anchor);
            Stage stage = (Stage) parent.getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void onEditCategory() {
        try {
            AnchorPane anchor = FXMLLoader.load(getClass().getResource("EditCategoryPrestageFXML.fxml"));
            Scene scene = new Scene(anchor);
            Stage stage = (Stage) parent.getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onEditInvoice() {
        try {
            AnchorPane anchor = FXMLLoader.load(getClass().getResource("EditInvoicePrestageFXML.fxml"));
            Scene scene = new Scene(anchor);
            Stage stage = (Stage) parent.getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onEditProduct() {
        try {
            AnchorPane anchor = FXMLLoader.load(getClass().getResource("EditProductPrestageFXML.fxml"));
            Scene scene = new Scene(anchor);
            Stage stage = (Stage) parent.getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onEditInvoiceItem() {
        try {
            AnchorPane anchor = FXMLLoader.load(getClass().getResource("EditInvoiceItemsPrestageFXML.fxml"));
            Scene scene = new Scene(anchor);
            Stage stage = (Stage) parent.getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
