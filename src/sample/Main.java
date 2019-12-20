package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        //Observable list

        ObservableList<Product> items = FXCollections.observableArrayList(
                new Product("Pfeffer","1 Stück\n","Schwarzer Pfeffer verleiht Ihren Speisen eine pikante Schärfe, besonders wenn er länger mitgekocht wird. \n",3.49,2.79, "pfeffer__600x600.jpg"),
                new Product("Schafmilchkäse","200 Gramm Packung","Hier gibt es keine Beschreibung, weil unsere Handelskette kennst sich nur bedingt damit aus, wie man eine Werbebeschreibung schreibt.\n",2.59,1.99, "cheese_salakis__600x600.jpg"),
                new Product("Vöslauer","1.5 Liter Flasche\n","Spritziges Vöslauer Mineralwasser.\n",0.75,0.49, "voslauer__600x600.jpg"),
                new Product("Zucker","500 Gramm Paket\n","Natürliches Gelieren wird durch Apfelpektin unterstützt, welches im richtigen Verhältnis mit Zitronensäure und Kristallzucker abgemischt wurde.\n",1.39,0.89, "zucker__600x600.jpg")
        );
        // List View
                    ListView <Product>list = new ListView();
                    list.getItems().addAll(items);

        // Lables

        Label lblname = new Label("name    ");
        Label lblquantity = new Label("quantity     ");
        Label lbldescription = new Label("description       ");
        Label lbloldprice = new Label("oldprice     ");
        Label lblnewprice = new Label("newprice     ");


        // Textfields

        TextField tname = new TextField();
        TextField tquantity = new TextField();
        TextField tdescription = new TextField();
        TextField toldprice = new TextField();
        TextField tnewprice = new TextField();


        // Images

        ImageView image = new ImageView();
        image.setFitHeight(200);
        image.setFitWidth(200);
        list.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            tname.setText(newValue.getName());
            tquantity.setText(newValue.getQuantity());
            tdescription.setText(newValue.getDescription());
            toldprice.setText(String.valueOf(newValue.getOldPrice()));
            tnewprice.setText(String.valueOf(newValue.getNewPrice()));

            Image im = null;

                im = new Image(newValue.getImage());
                image.setImage(im);



        });




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

        // Productcontrols
        VBox productControls = new VBox(hBoxname, hBoxquantity,hBoxoldprice,hBoxnewprice, btnControls,image);

        HBox main = new HBox(productControls,list);

        main.setSpacing(330);


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
                String tnameText = tname.getText();
                String tquantityText = tquantity.getText();
                String tdescriptionText = tdescription.getText();
                String toldpriceText = toldprice.getText();
                String tnewpriceText = tnewprice.getText();
                list.getItems().get(selIdx).setOldPrice(oldP);
                list.getItems().get(selIdx).setNewPrice(newP);
                list.refresh();
            }});


    }


    public static void main(String[] args) {
        launch(args);
    }
}
