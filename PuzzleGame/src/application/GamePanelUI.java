package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import application.body.Body;
import application.clothes.Cloth;
import application.clothes.ClothListBuilder;
import application.images.ImageManager;
import javafx.animation.Animation.Status;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathElement;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GamePanelUI {
	Resourses res;
	Stage primaryStage;
	List<Path> pathList;
	Timeline timeline;
	int startTime = 50;
	private Label timerLabel;
	private IntegerProperty timeSeconds = new SimpleIntegerProperty(startTime);
	
	public GamePanelUI(Stage primaryStage, Resourses res) {
		this.res = res;
		this.primaryStage = primaryStage;


		setTimerLabel(new Label());
		
		timeSeconds.set(startTime);
        timeline = new Timeline();
        timeline.getKeyFrames().add(
                new KeyFrame(Duration.seconds(startTime+1),
                new KeyValue(timeSeconds, 0)));
		
	}
	
	public void show(){
		
		final Group background = new Group(res.gamePanelUI_background_Image);
		
		timerLabel.textProperty().bind(timeSeconds.asString());
		timerLabel.setTextFill(Color.RED);
		timerLabel.setStyle("-fx-font-size: 4em;");
		
		
		
		final Text label = new Text("Label");
		final Button btn = new Button("Return Main");
		btn.setOnAction(new EventHandler<ActionEvent>() {
	          @Override public void handle(ActionEvent e) {
	        	  pauseORresumeTimer();
	        	  Main.mainUI.show();
	          }
	      });
		
		final Button btn1 = new Button();
		btn1.setText("Start Timer");
		btn1.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                if (timeline != null) {
                    timeline.stop();
                }
                if( timeline.getStatus() == Status.PAUSED){
                	timeline.play();
                } else if (timeline.getStatus() == Status.RUNNING){
                	timeline.pause();
                }
                timeline.playFromStart();
            }
        });
		
		final Button btn2 = new Button();
		btn2.setText("Pause Timer");
		btn2.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {                
            	pauseORresumeTimer();
              
            }
        });
		
		
		
		final HBox topBTNs = new HBox(label, btn, btn1, btn2, timerLabel);

		
		
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
		
        Canvas canvas = new Canvas(300, 250);
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        
        initPathList();
        drawSomething(graphicsContext);
        canvas.setLayoutX(100);
        canvas.setLayoutY(100);
        
        
        
        
        
        
		final Group root = new Group(background, beforeRoot, topBTNs, canvas);
		
		Scene scene = new Scene(root,res.FRAME_WIDTH,res.FRAME_HEIGHT);
		primaryStage.setResizable(false);
		primaryStage.setTitle("Tangram Game");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	

	protected void pauseORresumeTimer() {
		if (timeline.getStatus() == Status.RUNNING){
        	timeline.pause();
        } else {
        	timeline.play();
        }
		
	}

	private void initPathList(){
    pathList = new ArrayList<>();
     
    Path p = new Path();
    p.getElements().add(new MoveTo(50, 50));
    p.getElements().add(new LineTo(50, 200));
    p.getElements().add(new LineTo(100, 200));
    p.getElements().add(new LineTo(100, 100));
    p.getElements().add(new LineTo(200, 100));
    pathList.add(p);
     
    p = new Path();
    p.getElements().add(new MoveTo(60, 60));
    p.getElements().add(new LineTo(60, 210));
    p.getElements().add(new LineTo(110, 210));
    p.getElements().add(new LineTo(110, 110));
    p.getElements().add(new LineTo(210, 110));
    pathList.add(p);  
     
    p = new Path();
    p.getElements().add(new MoveTo(70, 70));
    p.getElements().add(new LineTo(70, 220));
    p.getElements().add(new LineTo(120, 220));
    p.getElements().add(new LineTo(120, 120));
    p.getElements().add(new LineTo(220, 120));
    pathList.add(p); 
}
 
	private void drawSomething(GraphicsContext gc){
     
    gc.setFill(Color.RED);
    gc.setStroke(Color.BLUE);
    gc.setLineWidth(1);

    for(Path p : pathList){
         
        ObservableList<PathElement> l = p.getElements();
         
        gc.beginPath();
        for (PathElement pe : l){
            if(pe.getClass()==MoveTo.class){
                gc.moveTo(((MoveTo)pe).getX(), ((MoveTo)pe).getY());
            }else if(pe.getClass()==LineTo.class){
                gc.lineTo(((LineTo)pe).getX(), ((LineTo)pe).getY());
            }
        }
        gc.stroke();
        gc.closePath();
    }
    
    //gc.fillText("" + countdown,50,50);
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

	public Label getTimerLabel() {
		return timerLabel;
	}

	public void setTimerLabel(Label timerLabel) {
		this.timerLabel = timerLabel;
	}

}
