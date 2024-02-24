/*
 * Program Name: Main.java
 * Author: Julian Fuentes
 * Date Last Updated: 24 February 2024
 * Purpose: This program will select a color for a text.
 */

package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;


public class Main extends Application 
{
	protected Slider redSlider = new Slider();
	protected Slider greenSlider = new Slider();
	protected Slider blueSlider = new Slider();
	protected Slider opacitySlider = new Slider();
	protected Text text = new Text("Show Colors");
	//This should create the sliders and the text shown in the image.
	
	private void setColor() 
	{
		text.setFill(new Color(redSlider.getValue(), greenSlider.getValue(),
				blueSlider.getValue(), opacitySlider.getValue()));
	}
	//This should set the text color.
	
	@Override
	public void start(Stage primaryStage)  
	{
		StackPane textStack = new StackPane(text);
		textStack.setPadding(new Insets(20, 10, 5, 10));
		GridPane sliderGrid = new GridPane();
		//This should create both panes, one of the text, the other
		//for the sliders.
		
		redSlider.setMin(0);
		redSlider.setMax(1);
		greenSlider.setMin(0);
		greenSlider.setMax(1);
		blueSlider.setMin(0);
		blueSlider.setMax(1);
		opacitySlider.setMin(0);
		opacitySlider.setMax(1);
		//These should set the limits of the sliders.
		
		redSlider.valueProperty().addListener(ov-> setColor());
		greenSlider.valueProperty().addListener(ov-> setColor());
		blueSlider.valueProperty().addListener(ov-> setColor());
		opacitySlider.valueProperty().addListener(ov-> setColor());
		opacitySlider.setValue(1);
		//This should create the listeners.
		
		sliderGrid.setAlignment(Pos.CENTER);
		sliderGrid.setVgap(5);
		sliderGrid.setHgap(5);
		sliderGrid.add(new Label("Red"), 0, 0);
		sliderGrid.add(redSlider, 1, 0);
		sliderGrid.add(new Label("Green"), 0, 1);
		sliderGrid.add(greenSlider, 1, 1);
		sliderGrid.add(new Label("Blue"), 0, 2);
		sliderGrid.add(blueSlider, 1, 2);
		sliderGrid.add(new Label("Opacity"), 0, 3);
		sliderGrid.add(opacitySlider, 1, 3);
		//This should create the full pane for the sliders.
		
		BorderPane border = new BorderPane();
		border.setTop(textStack);
		border.setCenter(sliderGrid);
		//This should place the nodes inside the border pane.
		
		Scene scene = new Scene(border, 250, 150);
		primaryStage.setTitle("Use Scrollbar And Slider");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}
	
}
