package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.InputStream;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{






        // Lables

        Label lblname = new Label("name");
        Label lblquantity = new Label("quantity");
        Label lbldescription = new Label("description");
        Label lbloldprice = new Label("oldprice");
        Label lblnewprice = new Label("newprice");



        // Textfields

        TextField tname = new TextField();
        TextField tquantity = new TextField();
        TextField tdescription = new TextField();
        TextField toldprice = new TextField();
        TextField tnewprice = new TextField();


        //Observable list

        ObservableList<Product> items = FXCollections.observableArrayList(
                new Product("Pfeffer","1 Stück\n","Schwarzer Pfeffer verleiht Ihren Speisen eine pikante Schärfe, besonders wenn er länger mitgekocht wird. \n",3.49,2.79,"/resources/pfeffer__600x600.jpg"),
                new Product("Schafmilchkäse","200 Gramm Packung","Hier gibt es keine Beschreibung, weil unsere Handelskette kennst sich nur bedingt damit aus, wie man eine Werbebeschreibung schreibt.\n",2.59,1.99,"/resources/cheese_salakis__600x600.jpg"),
                new Product("Vöslauer","1.5 Liter Flasche\n","Spritziges Vöslauer Mineralwasser.\n",0.75,0.49,"/resources/voslauer__600x600.jpg"),
                new Product("Zucker","500 Gramm Paket\n","Natürliches Gelieren wird durch Apfelpektin unterstützt, welches im richtigen Verhältnis mit Zitronensäure und Kristallzucker abgemischt wurde.\n",1.39,0.89,"/resources/zucker__600x600.jpg")
        );


        // List View
        ListView <Product>list = new ListView();
        list.getItems().addAll(items);

        // Images
        ImageView imageView = new ImageView();
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);
        HBox imgBox = new HBox(imageView);
        imgBox.setPadding(new Insets(10,10,10,10));

        // Box





        // Buttons
        Button btnAddNew = new Button("Add");
        Button btnUpdate = new Button("Update");
        Button btnDelete = new Button("Delete");



        // Controls
        HBox hBoxname = new HBox(lblname, tname);
        HBox hBoxquantity = new HBox(lblquantity, tquantity);
        HBox hBoxoldprice = new HBox(lbloldprice,toldprice);
        HBox hBoxnewprice = new HBox(lblnewprice,tnewprice);
        HBox btnControls = new HBox(btnAddNew, btnUpdate,btnDelete);
        HBox hBoximgBox = new HBox(imageView);

        // Productcontrols
        VBox productControls = new VBox(hBoxname, hBoxquantity,hBoxoldprice,hBoxnewprice, btnControls);

        HBox main = new HBox(productControls,list);
        main.setSpacing(330);

        list.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            tname.setText(newValue.getName());
            tquantity.setText(newValue.getQuantity());
            tdescription.setText(newValue.getDescription());
            toldprice.setText(String.valueOf(newValue.getOldPrice()));
            tnewprice.setText(String.valueOf(newValue.getNewPrice()));
            imageView.setImage(new Image(this.getClass().getResourceAsStream(newValue.getImgPath())));



        });







        Scene scene = new Scene(main, 800, 600);
        primaryStage.setTitle("Set action prices");
        primaryStage.setScene(scene);
        primaryStage.show();

       // uodate action

        btnUpdate.setOnAction(actionEvent ->  {
            System.out.println("User clicked on update button!");
            int selIdx = list.getSelectionModel().getSelectedIndex();
            Double newP = Double.valueOf(tnewprice.getText());
            Double oldP = Double.valueOf(toldprice.getText());
            if (selIdx != -1) {
                String prodTitleFieldText = tname.getText();
                String prodQuantFieldText = tquantity.getText();
                String prodDescFieldText = tdescription.getText();
                String oldPrText = toldprice.getText();
                String newPrText = tnewprice.getText();
                list.getItems().get(selIdx).setOldPrice(oldP);
                list.getItems().get(selIdx).setNewPrice(newP);
                list.refresh();
            }});


    }


    public static void main(String[] args) {
        launch(args);
    }
}
