package application;
	
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import application.body.Body;
import application.clothes.Cloth;
import application.clothes.ClothListBuilder;
import application.images.ImageManager;




public class Main extends Application {
	final static int FRAME_WIDTH = 800;	
	final static int FRAME_HEIGHT = 600;
	final static int BTN_WIDTH = 300;
	final static int BTN_HEIGHT = 250;
	
	final static Image BACKGROUND_IMAGE = new Image(Main.class.getResource("ui/mainUI/main.png").toString());
	final static Image START_IMAGE = new Image(Main.class.getResource("ui/mainUI/start.png").toString());
	final static Image START_IMAGE1 = new Image(Main.class.getResource("ui/mainUI/start_hover.png").toString());

	final static Image LEVEL_IMAGE = new Image(Main.class.getResource("ui/mainUI/levelselect.png").toString());
	final static Image LEVEL_IMAGE1 = new Image(Main.class.getResource("ui/mainUI/levelselect_hover.png").toString());

	
	final static Image SCORES_IMAGE = new Image(Main.class.getResource("ui/mainUI/score.png").toString());
	final static Image SCORES_IMAGE1 = new Image(Main.class.getResource("ui/mainUI/score_hover.png").toString());
	
	
	final static Image EXIT_IMAGE = new Image(Main.class.getResource("ui/mainUI/exit.png").toString());
	final static Image EXIT_IMAGE1 = new Image(Main.class.getResource("ui/mainUI/exit_hover.png").toString());
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			final ImageView backgroundImage = new ImageView(BACKGROUND_IMAGE);
						
			final Group background = new Group(backgroundImage);
				
			// start btn
			final ImageView startImage = new ImageView(START_IMAGE);
			final Button btn = new Button();
			btn.setGraphic(startImage);
			btn.setBorder(null);
			btn.setBackground(null);
			btn.setOnMouseEntered(new EventHandler<MouseEvent>() {
	            @Override
	            public void handle(MouseEvent mouseEvent) {
	            	btn.setGraphic(new ImageView(START_IMAGE1));

	            }
	        });
			btn.setOnMouseExited(new EventHandler<MouseEvent>() {
	            @Override
	            public void handle(MouseEvent mouseEvent) {
	            	btn.setGraphic(startImage);

	            }
	        });

			btn.setOnAction(new EventHandler<ActionEvent>() {
		          @Override public void handle(ActionEvent e) {
		        	  startNewGame(primaryStage);
		          }
		      });
	
			// level select btn
			final ImageView levelImage = new ImageView(LEVEL_IMAGE);
			final Button btn1 = new Button();
			btn1.setGraphic(levelImage);
			btn1.setBorder(null);
			btn1.setBackground(null);
			btn1.setOnMouseEntered(new EventHandler<MouseEvent>() {
	            @Override
	            public void handle(MouseEvent mouseEvent) {
	            	btn1.setGraphic(new ImageView(LEVEL_IMAGE1));

	            }
	        });
			btn1.setOnMouseExited(new EventHandler<MouseEvent>() {
	            @Override
	            public void handle(MouseEvent mouseEvent) {
	            	btn1.setGraphic(levelImage);

	            }
	        });
			
			btn1.setOnAction(new EventHandler<ActionEvent>() {
		          @Override public void handle(ActionEvent e) {
		        	  
		          }
		      });
			
			// scores btn
			final ImageView scoresImage = new ImageView(SCORES_IMAGE);
			final Button btn2 = new Button();
			btn2.setBorder(null);
			btn2.setBackground(null);
			btn2.setGraphic(scoresImage);
			
			
			btn2.setOnMouseEntered(new EventHandler<MouseEvent>() {
	            @Override
	            public void handle(MouseEvent mouseEvent) {
	            	btn2.setGraphic(new ImageView(SCORES_IMAGE1));

	            }
	        });
			btn2.setOnMouseExited(new EventHandler<MouseEvent>() {
	            @Override
	            public void handle(MouseEvent mouseEvent) {
	            	btn2.setGraphic(scoresImage);

	            }
	        });
			
			btn2.setOnAction(new EventHandler<ActionEvent>() {
		          @Override public void handle(ActionEvent e) {
		        	  showScores(primaryStage, true);
		          }
		      });
			
			// exit btn
			final ImageView exitImage = new ImageView(EXIT_IMAGE);
			final Button btn3 = new Button();
			btn3.setGraphic(exitImage);
			btn3.setBorder(null);
			btn3.setBackground(null);
			btn3.setOnMouseEntered(new EventHandler<MouseEvent>() {
	            @Override
	            public void handle(MouseEvent mouseEvent) {
	            	btn3.setGraphic(new ImageView(EXIT_IMAGE1));

	            }
	        });
			btn3.setOnMouseExited(new EventHandler<MouseEvent>() {
	            @Override
	            public void handle(MouseEvent mouseEvent) {
	            	btn3.setGraphic(exitImage);

	            }
	        });			
			btn3.setOnAction(new EventHandler<ActionEvent>() {
				@Override public void handle(ActionEvent e) {
		        	  Alert alert = new Alert(AlertType.CONFIRMATION);
		        	  alert.setTitle("Confirmation Dialog");
		        	  alert.setHeaderText("Look, a Confirmation Dialog");
		        	  alert.setContentText("Are you ok with this?");

		        	  Optional<ButtonType> result = alert.showAndWait();
		        	  if (result.get() == ButtonType.OK){
		        	      // ... user chose OK
		        		  Platform.exit();
		        	  } else {
		        	      // ... user chose CANCEL or closed the dialog
		        	  }
		          }
		      });
			
			final VBox btns = new VBox(btn, btn1, btn2, btn3);
			btns.alignmentProperty();
			btns.setAlignment(Pos.CENTER);
			btns.setLayoutX((FRAME_WIDTH - BTN_WIDTH)/2);
			btns.setLayoutY((FRAME_HEIGHT-BTN_HEIGHT)/2);
			

			final Group root = new Group(background,btns);
			
		    Scene scene = new Scene(root,FRAME_WIDTH,FRAME_HEIGHT);
			primaryStage.setResizable(false);
	        primaryStage.setTitle("Tangram Game");
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.centerOnScreen();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private void showScores(Stage previousStage,boolean whichStage ){
		final Stage tableStage = new Stage();
		final VBox scoresList = new VBox();
		final Button btn = new Button("Return Previous View");
		btn.setOnAction(new EventHandler<ActionEvent>() {
	          @Override public void handle(ActionEvent e) {
	        	  if(whichStage){
	        		  start(previousStage);
	        	  } else {
	        		  startNewGame(previousStage);
	        	  }
	        	  tableStage.close();
	          }
	          
	      });
		scoresList.getChildren().addAll(btn);
		final Group root = new Group(scoresList);
		Scene scene = new Scene(root,FRAME_WIDTH/4,FRAME_HEIGHT/1.1);
		tableStage.setResizable(false);
		tableStage.setTitle("Game Scores");
		tableStage.setScene(scene);
		tableStage.centerOnScreen();
		tableStage.setAlwaysOnTop(true);
		tableStage.show();
		
	}
	
	private void startNewGame(Stage gameStage){
		
		
		final Text label = new Text("Label");
		final Button btn = new Button("Return Main");
		btn.setOnAction(new EventHandler<ActionEvent>() {
	          @Override public void handle(ActionEvent e) {
	        	  start(gameStage);
	          }
	      });
		final VBox topBTNs = new VBox();
		topBTNs.getChildren().addAll(label, btn);
		//topBTNs.setLayoutX(FRAME_WIDTH/2);
		//topBTNs.setLayoutY(FRAME_HEIGHT/2);
		
		
		
		ImageView header = new ImageView(ImageManager.getImage("ui/flowers.jpg"));        
        VBox title = new VBox();
        title.getChildren().addAll(header);
        title.setPadding(new Insets(10.0));
        
        GridPane content = new GridPane();
        content.add(Body.getBody().getNode(), 1, 1);
        content.add(createItemPane(Body.getBody().getBodyPane()), 0, 1);
        ColumnConstraints c1 = new ColumnConstraints();
        c1.setHgrow(Priority.ALWAYS);
        ColumnConstraints c2 = new ColumnConstraints();
        c2.setHgrow(Priority.NEVER);
        c2.setPrefWidth(Body.getBody().getBodyPane().getMinWidth() + 20);
        content.getColumnConstraints().addAll(c1, c2);
        
        items = new HashMap<>();
        Body.getBody().setItemsInfo(itemPane, items);
        populateClothes();
        
        VBox beforeRoot = new VBox();
        beforeRoot.getChildren().addAll(title, content);
		
		
		final Group root = new Group(beforeRoot,topBTNs);
		
		Scene scene = new Scene(root,FRAME_WIDTH,FRAME_HEIGHT);
		gameStage.setResizable(false);
		gameStage.setTitle("Tangram Game");
		gameStage.setScene(scene);
		gameStage.show();
	}

private FlowPane itemPane = null;
    
    private HashMap<String, Cloth> items;
    
    /**
     * A container for unequipped items is created here.
     * @param bodyPane body container is needed so that the item is removed from
     * it when dropped here.
     * @return 
     */
    private FlowPane createItemPane(final Pane bodyPane) {
        if (!(itemPane == null))
            return itemPane;
        
        itemPane = new FlowPane();
        itemPane.setPadding(new Insets(10.0));
        
        itemPane.setOnDragDropped((DragEvent event) -> {
            Dragboard db = event.getDragboard();
            //Get an item ID here, which was stored when the drag started.
            boolean success = false;
            // If this is a meaningful drop...
            if (db.hasString()) {
                String nodeId = db.getString();
                // ...search for the item on body. If it is there...
                ImageView cloth = (ImageView) bodyPane.lookup("#" + nodeId);
                if (cloth != null) {
                    // ... it is removed from body
                    // and added to an unequipped container.
                    bodyPane.getChildren().remove(cloth);
                    itemPane.getChildren().add(cloth);
                    success = true;
                }
                // ...anyway, the item is not active or equipped anymore.
                items.get(nodeId).takeOff();
            }
            event.setDropCompleted(success);
            event.consume();
        });
        
        itemPane.setOnDragOver((DragEvent event) -> {
            if (event.getGestureSource() != itemPane &&
                    event.getDragboard().hasString()) {
                event.acceptTransferModes(TransferMode.MOVE);
            }
            event.consume();
        });        
        
        return itemPane;
    }
    
    /**
     * Here items are added to unequipped items container.
     */
    private void populateClothes() {
        ClothListBuilder clothBuilder = new ClothListBuilder();
        if (itemPane == null)
            throw new IllegalStateException("Should call getItems() before populating!");
        List<Cloth> clothes = clothBuilder.getClothList();
        clothes.stream().map((c) -> {
            itemPane.getChildren().add(c.getNode());
            return c;
        }).forEach((c) -> {
            items.put(c.getImageViewId(), c);
        });
    }
    
	public static void main(String[] args) {
		launch(args);
	}
}
