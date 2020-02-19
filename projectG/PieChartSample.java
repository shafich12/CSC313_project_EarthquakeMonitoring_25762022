import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.chart.*;
import javafx.scene.Group;

import java.sql.SQLException;

public class PieChartSample extends Application {

   @Override public void start(Stage stage) throws SQLException {
      Scene scene = new Scene(new Group());
      stage.setTitle("Color Value Statistics");
      stage.setWidth(500);
      stage.setHeight(500);

      ObservableList<PieChart.Data> pieChartData =
              FXCollections.observableArrayList(
                      new PieChart.Data("Brown - " + MonitoringIO.db.countRecords(3), MonitoringIO.db.countRecords(3)),
                      new PieChart.Data("Yellow - " + MonitoringIO.db.countRecords(2), MonitoringIO.db.countRecords(2)),
                      new PieChart.Data("Green - " + MonitoringIO.db.countRecords(1), MonitoringIO.db.countRecords(1)));

      final PieChart chart = new PieChart(pieChartData);
      chart.setTitle("Color Value Statistics");

      final Label caption = new Label("");
      caption.setTextFill(Color.DARKORANGE);
      caption.setStyle("-fx-font: 24 arial;");

      for (final PieChart.Data data : chart.getData()) {
         data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED,
                 new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                       caption.setTranslateX(e.getSceneX());
                       caption.setTranslateY(e.getSceneY());
                       caption.setText(String.valueOf(data.getPieValue()) + "%");
                    }
                 });
      }

      ((Group) scene.getRoot()).getChildren().add(chart);
      stage.setScene(scene);
      stage.show();

   }

   public static void main(String[] args) {
      launch(args);
   }

}