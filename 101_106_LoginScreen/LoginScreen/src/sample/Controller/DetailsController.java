package sample.Controller;

        import java.awt.*;
        import java.io.IOException;
        import java.net.URI;
        import java.net.URISyntaxException;
        import java.net.URL;
        import java.util.ResourceBundle;
        import java.util.StringTokenizer;

        import javafx.application.Application;
        import javafx.event.ActionEvent;
        import javafx.event.EventHandler;
        import javafx.fxml.FXML;
        import javafx.fxml.Initializable;
        import javafx.scene.control.Hyperlink;
        import javafx.scene.control.Label;

public class DetailsController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label detailWelcomeLabel;

    @FXML
    private Label detailNameId;

    @FXML
    private Label detailAgeId;

    @FXML
    private Label detailProfessionId;

    @FXML
    private Hyperlink detailWeb;

    @FXML
    private Hyperlink detailTwitter;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        detailWeb.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (Desktop.isDesktopSupported()){
                    try {
                        //Desktop.getDesktop().browse(new URI(detailWeb.getAccessibleText().trim()));
                        Desktop.getDesktop().browse(new URI("https://www.google.be/"));
                    }catch (IOException ex) {ex.printStackTrace();}
                    catch (URISyntaxException ex) {ex.printStackTrace();}
                }
            }
        });

        detailTwitter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (Desktop.isDesktopSupported()){
                    try {
                        //Desktop.getDesktop().browse(new URI(detailTwitter.getAccessibleText().trim()));
                        Desktop.getDesktop().browse(new URI("https://www.google.be/"));
                    }catch (IOException ex) {ex.printStackTrace();}
                    catch (URISyntaxException ex) {ex.printStackTrace();}

                }
            }
        });

    }

    public void setProfile(String name, int age, String profession){
        detailNameId.setText("Name: " + name);
        detailAgeId.setText("Age: " + String.valueOf(age));
        detailWelcomeLabel.setText("Welcome "+name);
        detailProfessionId.setText("Profession: " + profession);
    }
}
