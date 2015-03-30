package application;

import java.util.HashMap;
import java.util.List;

import application.body.Body;
import application.clothes.Cloth;
import application.clothes.ClothListBuilder;
import application.images.ImageManager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GamePanelUI {
	Resourses res;
	Stage gameStage;
	
	public GamePanelUI(Stage primaryStage, Resourses res) {
		this.res = res;
		//this.primaryStage = primaryStage;
	}
	
public void show(){
		
		
		final Text label = new Text("Label");
		final Button btn = new Button("Return Main");
		btn.setOnAction(new EventHandler<ActionEvent>() {
	          @Override public void handle(ActionEvent e) {
	        	  Main.mainUI.show();
	          }
	      });
		final VBox topBTNs = new VBox();
		topBTNs.getChildren().addAll(label, btn);
		
		/*
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
		
		*/
		final Group root = new Group(topBTNs);
		
		Scene scene = new Scene(root,res.FRAME_WIDTH,res.FRAME_HEIGHT);
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

}
