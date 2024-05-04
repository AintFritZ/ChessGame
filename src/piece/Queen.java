package piece;

import Main.GamePanel;
import Main.Main;

public class Queen extends Piece{
    public Queen(int color, int col, int row) {
        super(color, col, row);

        if(color == GamePanel.WHITE){
            image = getImage("/piece/w-queen");
        }
        else{
            image = getImage("/piece/b-queen");
        }
    }
    public boolean canMove(int targetCol, int targetRow){

        if(isWithinBoard(targetCol, targetRow) && isSameSquare(targetCol, targetRow) == false){

            //Vert & hori
            if(targetCol == preCol || targetRow == preRow){
                if(isValidSquare(targetCol, targetRow) && pieceIsOnStraightLine(targetCol, targetRow) == false){
                    return true;
                }
            }
            //dia
            if(Math.abs(targetCol-preCol) == Math.abs(targetRow - preRow)) {
                if(isValidSquare(targetCol, targetRow) && pieceIsOnDiagonalLine(targetCol, targetRow) == false){
                    return true;
                }
            }
        }
        return false;
    }
}
