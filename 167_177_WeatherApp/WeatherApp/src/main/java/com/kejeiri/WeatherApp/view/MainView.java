package com.kejeiri.WeatherApp.view;
import com.kejeiri.WeatherApp.controller.WeatherService;
import com.vaadin.data.HasValue;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.ClassResource;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;


@SpringUI(path = "")
public class MainView extends UI {
    private NativeSelect<String> unitSelect;
    private VerticalLayout mainLayout;
    private TextField cityTextField ;
    private Button showWeatherButton;
    private Label currentLocationTitle;
    private Label currentTemp;
    private Label weatherDescriptionLabel;
    private Label weatherMinLabel;
    private Label weatherMaxLabel;
    private Label pressureLabel;
    private Label humidityLabel;
    private Label windSpeedLabel;
    private Label sunriseLabel;
    private Label sunsetLabel;
    private Embedded image;



    @Autowired
    private WeatherService weatherService;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
       setUpLayout();

    }

    private void setUpLayout() {
        mainLayout = new VerticalLayout();
        mainLayout.setWidth("100%");
        mainLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        mainLayout.setSpacing(true);
        mainLayout.setMargin(true);
        setHeader();
        setLogo();
        setUpForm();
        dashBoardTitle();
        dashBoardDescription();

        setContent(mainLayout);
    }

    private void setUpForm() {
        HorizontalLayout formLayout = new HorizontalLayout();
        formLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        formLayout.setSpacing(true);
        formLayout.setMargin(true);

        //Create the selection component
        unitSelect = new NativeSelect();
        ArrayList<String> items = new ArrayList();
        items.add("C");
        items.add("F");
        unitSelect.setItems(items);
        unitSelect.setValue(items.get(0));

        unitSelect.addValueChangeListener(new HasValue.ValueChangeListener<String>() {
            @Override
            public void valueChange(HasValue.ValueChangeEvent<String> event) {

                switch (unitSelect.getValue()){
                    case "C" :
                                weatherService.setUnits("metric");
                                break;
                    case "F":
                                weatherService.setUnits("imperial");
                                break;
                    default:
                                weatherService.setUnits("metric");
                }
                if(!cityTextField.getValue().equals("")){
                    try {
                        updateUI();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });



        cityTextField = new TextField();
        cityTextField.setPlaceholder("Enter a city");
        cityTextField.setWidth("80%");

        showWeatherButton = new Button();
        showWeatherButton.setIcon(VaadinIcons.SEARCH);
        showWeatherButton.addClickListener((event)-> {
            if (!cityTextField.getValue().equals("")){
                try {
                    updateUI();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else{
                Notification.show("Please enter a city!");
            }
        });

        formLayout.addComponents(unitSelect,cityTextField,showWeatherButton);

        mainLayout.addComponent(formLayout);
    }
    private void setHeader() {
        HorizontalLayout headerLayout = new HorizontalLayout();
        headerLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        Label title = new Label("Weather!");
        title.addStyleName((ValoTheme.LABEL_H1));
        title.addStyleName((ValoTheme.LABEL_BOLD));
        title.addStyleName((ValoTheme.LABEL_COLORED));
        headerLayout.addComponent(title);
        mainLayout.addComponent(headerLayout);
    }
    private void setLogo() {
        HorizontalLayout logLayout = new HorizontalLayout();
        logLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

        Image icon = new Image(null, new ClassResource("/weatherIcon.jpg"));
        icon.setWidth("400px");
        icon.setHeight("400px");
        logLayout.addComponent(icon);
        mainLayout.addComponent(logLayout);
    }
    private void dashBoardTitle() {
        HorizontalLayout dashBoardMain = new HorizontalLayout();
        dashBoardMain.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        currentLocationTitle = new Label();
        currentLocationTitle.addStyleName(ValoTheme.LABEL_H2);
        currentLocationTitle.addStyleName(ValoTheme.LABEL_LIGHT);


        //Current Temp
        currentTemp = new Label();
        currentTemp.addStyleName(ValoTheme.LABEL_BOLD);
        currentTemp.addStyleName(ValoTheme.LABEL_H1);

        //Image icon
        image = new Embedded(null,null);

        dashBoardMain.addComponents(currentLocationTitle,image,currentTemp);
        mainLayout.addComponent(dashBoardMain);
    }
    private void dashBoardDescription() {
        HorizontalLayout mainDescriptionLayout = new HorizontalLayout();
        mainDescriptionLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

        //Description Vertical layout
        VerticalLayout descriptionLayout = new VerticalLayout();
        descriptionLayout.addStyleName(ValoTheme.FORMLAYOUT_LIGHT);
        descriptionLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

        weatherDescriptionLabel = new Label();
        weatherMinLabel = new Label();
        weatherMaxLabel = new Label();
        descriptionLayout.addComponents(weatherDescriptionLabel,weatherMinLabel,weatherMaxLabel);


        //Pressure, Humidity etc...
        VerticalLayout pressureLayout = new VerticalLayout();
        pressureLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        pressureLabel = new Label();
        humidityLabel = new Label();
        windSpeedLabel = new Label();
        sunriseLabel = new Label();
        sunsetLabel = new Label();

        pressureLayout.addComponents(pressureLabel,humidityLabel,windSpeedLabel,
                                     windSpeedLabel,sunriseLabel,sunsetLabel);
        mainDescriptionLayout.addComponents(descriptionLayout,pressureLayout);
        mainLayout.addComponent(mainDescriptionLayout);
    }

    private void updateUI() throws IOException {
        weatherService.setCity(cityTextField.getValue());
        String unit = "\u00b0"+unitSelect.getValue();
        currentLocationTitle.setValue("Currently in "+cityTextField.getValue());
        JSONObject json = (JSONObject)(weatherService.getWeather().getJSONArray("weather").get(0));
        currentTemp.setValue(String.valueOf(weatherService.getMainSection().getDouble("temp"))+unit);
        String icon =  json.getString("icon");

        String urlImg = weatherService.getImgUrl(icon);
                image.setSource(new ExternalResource(urlImg));

        weatherDescriptionLabel.setValue("Description: "+json.getString("description"));
        weatherDescriptionLabel.setStyleName(ValoTheme.LABEL_SUCCESS);
        weatherMinLabel.setValue("Min: "+String.valueOf(weatherService.getMainSection().getDouble("temp_min"))+unit);
        weatherMaxLabel.setValue("Min: "+String.valueOf(weatherService.getMainSection().getDouble("temp_max"))+unit);
        pressureLabel.setValue("pressure: "+String.valueOf(weatherService.getMainSection().getDouble("pressure"))+" hpa");
        humidityLabel.setValue("humidity: "+String.valueOf(weatherService.getMainSection().getDouble("humidity"))+" %");
        windSpeedLabel.setValue("speed: "+String.valueOf(weatherService.getWindSection().getDouble("speed")) + " m/s");


        Date sunriseDate = new Date(TimeUnit.SECONDS.toMillis(weatherService.getSysSection().getLong("sunrise")));
        Date sunsetDate = new Date(TimeUnit.SECONDS.toMillis(weatherService.getSysSection().getLong("sunset")));
        sunriseLabel.setValue("sunrise: "+getDateFormat(sunriseDate));
        sunsetLabel.setValue("sunset: "+getDateFormat(sunsetDate));
    }

    String getDateFormat(Date dt){
        SimpleDateFormat sdt = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        return  sdt.format(dt);
    }
}

