// package application.view;
//
// import java.util.List;
// import application.Launcher;
// import application.model.AdjacentCellsListBuilder;
// import application.view.dashboard.Dashboard;
// import application.view.minefield.CellLabel;
// import javafx.animation.Animation;
// import javafx.event.EventHandler;
// import javafx.scene.input.MouseButton;
// import javafx.scene.input.MouseEvent;
// import javafx.scene.layout.Border;
// import javafx.scene.layout.BorderStroke;
// import javafx.scene.layout.BorderStrokeStyle;
// import javafx.scene.layout.BorderWidths;
// import javafx.scene.paint.Color;
// import javafx.scene.shape.StrokeLineJoin;
// import javafx.scene.shape.StrokeType;
//
// public class MinefieldCellClickHandler implements EventHandler<MouseEvent> {
//
// @Override
// public void handle(MouseEvent event) {
//
// if (Launcher.gameIsOn()) {
//
// MinefieldUICell clickedCell = (MinefieldUICell) event.getSource();
//
// if (event.getButton() == MouseButton.PRIMARY) {
// startGameClock();
//
// // if (!clickedCell.isRevealed() && !clickedCell.isflagged()) {
// // Dashboard.getResetButton().setButtonLabel("scared");
// // }
// // revealThis(clickedCell);
// //
// } else if (event.getButton() == MouseButton.SECONDARY) {
//
// if (!clickedCell.isRevealed()) {
//
// if (clickedCell.getChildren().isEmpty()) {
// setFlagOnThis(clickedCell);
// } else {
// removeFlagFromThis(clickedCell);
// }
// }
// }
// }
// }
//
// private static void startGameClock() {
// if (Dashboard.getGameClock().getTimeline().getStatus() == Animation.Status.STOPPED)
// Dashboard.getGameClock().getTimeline().play();
// }
//
// private void revealThis(MinefieldUICell cell) {
// if (!cell.isRevealed() && !cell.isflagged()) {
// cell.setRevealed(true);
// if (cell.getValue() == -1) {
// displayMineOnThis(cell);
// stopGame();
// revealAllUnexplodedMines();
// } else if (cell.getValue() == 0) {
// displayThisEmpty(cell);
// revealCellsAdjacentToThis(cell);
// } else {
// displayAdjacencyValueOfThis(cell);
// }
// }
// }
//
// private static void setFlagOnThis(MinefieldUICell clickedCell) {
// clickedCell.getChildren().add(new CellLabel("flag"));
// clickedCell.setFlagged(true);
// MinefieldUI.decrementNumberOfRemainingMines();
// MinefieldUI.getRemainingMinesStringProperty()
// .setValue(MinefieldUI.getNumberOfRemainingMinesAsString());
// }
//
// private static void removeFlagFromThis(MinefieldUICell clickedCell) {
// clickedCell.getChildren().clear();
// clickedCell.setFlagged(false);
// MinefieldUI.incrementNumberOfRemainingMines();
// MinefieldUI.getRemainingMinesStringProperty()
// .setValue(MinefieldUI.getNumberOfRemainingMinesAsString());
// }
//
// private static void displayMineOnThis(MinefieldUICell cell) {
// cell.setBorder(new Border(new BorderStroke(
// Color.GRAY,
// new BorderStrokeStyle(StrokeType.INSIDE, StrokeLineJoin.BEVEL, null, 10, 0, null),
// null, new BorderWidths(1))));
// cell.getChildren().add(new CellLabel("mine"));
// }
//
// private static void stopGame() {
// Launcher.setGameOn(false);
// Dashboard.getGameClock().stop();
// Dashboard.getResetButton().setButtonLabel("done");
// }
//
// private static void revealAllUnexplodedMines() {
// for (int row = 0; row < MinefieldUI.ROWS; row++) {
// for (int col = 0; col < MinefieldUI.COLUMNS; col++) {
// MinefieldUICell cell = MinefieldUI.getCell(row, col);
// if (!cell.isRevealed() && !cell.isflagged() && cell.getValue() == -1) {
// displayUnexplodedMineOnThis(cell);
// }
// }
// }
// }
//
// private static void displayThisEmpty(MinefieldUICell cell) {
// cell.setBorder(new Border(new BorderStroke(
// Color.GRAY,
// new BorderStrokeStyle(StrokeType.INSIDE, StrokeLineJoin.BEVEL, null, 10, 0, null),
// null, new BorderWidths(1))));
// }
//
// private void revealCellsAdjacentToThis(MinefieldUICell cell) {
// List<MinefieldUICell> adjacentCellsList = AdjacentCellsListBuilder
// .build(MinefieldUI.getCellsMatrix(), cell.getRow(), cell.getCol());
// for (MinefieldUICell adjacentCell : adjacentCellsList) {
// revealThis(adjacentCell);
// }
// }
//
// private static void displayAdjacencyValueOfThis(MinefieldUICell cell) {
// cell.setBorder(new Border(new BorderStroke(
// Color.GRAY,
// new BorderStrokeStyle(StrokeType.INSIDE, StrokeLineJoin.BEVEL, null, 10, 0, null),
// null, new BorderWidths(1))));
// cell.getChildren().add(new CellLabel(cell.getValue()));
// }
//
// private static void displayUnexplodedMineOnThis(MinefieldUICell cell) {
// cell.setRevealed(true);
// cell.setBorder(new Border(new BorderStroke(
// Color.GRAY,
// new BorderStrokeStyle(StrokeType.INSIDE, StrokeLineJoin.BEVEL, null, 10, 0, null),
// null, new BorderWidths(1))));
// cell.getChildren().add(new CellLabel("unexplodedMine"));
// }
// }
