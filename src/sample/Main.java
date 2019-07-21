package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    private Controller controller;

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("game.fxml"));
		GridPane rootGridPane = loader.load();

        controller = loader.getController();
        controller.createPlayground();

        Scene scene = new Scene(rootGridPane);

        MenuBar menuBar = createMenu();
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());

        Pane menuPane = (Pane) rootGridPane.getChildren().get(0);
		menuPane.getChildren().add(menuBar);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Connect 4");
        primaryStage.setResizable(false);
        primaryStage.show();

    }


    public MenuBar createMenu(){

	    Menu fileMenu = new Menu("File");
	    MenuItem newGame = new MenuItem("New");

	    newGame.setOnAction(event -> controller.resetGame());

	    MenuItem resetGame = new MenuItem("Reset");

	    resetGame.setOnAction(event -> controller.resetGame());

	    SeparatorMenuItem sepratorMenuItem = new SeparatorMenuItem();
	    MenuItem quitGame = new MenuItem("Quit");

	    quitGame.setOnAction(event -> exitgame());

	    fileMenu.getItems().addAll(newGame, resetGame, sepratorMenuItem, quitGame);

	    Menu helpMenu = new Menu("Help");
	    MenuItem aboutGame = new MenuItem("About Connect 4");

	    aboutGame.setOnAction(event -> aboutConnect4());

	    SeparatorMenuItem seprator = new SeparatorMenuItem();
	    MenuItem aboutme = new MenuItem("About Me");

	    aboutme.setOnAction(event -> aboutme());

	    helpMenu.getItems().addAll(aboutGame, seprator, aboutme);

	    MenuBar menuBar = new MenuBar();
	    menuBar.getMenus().addAll(fileMenu, helpMenu);
	    return menuBar;


    }

	private void aboutme() {

		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("About Developer");
		alert.setHeaderText("Deepanshu Gupta");
		alert.setContentText("I love to play around with code and create game.z");
		alert.show();

	}

	private void aboutConnect4() {

		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("About Connect 4");
		alert.setHeaderText("How To Play");
		alert.setContentText("Connect Four is a two-player connection game in which " +
				"the players first choose a color and then take turns dropping colored discs " +
				"from the top into a seven-column, six-row vertically suspended grid." +
				" The pieces fall straight down, occupying the next available space within the column." +
				" The objective of the game is to be the first to form a horizontal, vertical," +
				"or diagonal line of four of one's own discs. Connect Four is a solved game." +
				"The first player can always win by playing the right moves.");
		alert.show();

	}

	private void exitgame() {

		Platform.exit();
		System.exit(0);

	}

	private void resetGame() {
	}

	public static void main(String[] args) {
        launch(args);
    }
}
