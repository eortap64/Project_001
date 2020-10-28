package Lesson_008.app;

public class Player extends AGamer {
    MainGameField gameField;
    int isShotReady = 1;

    public Player(String sign) {
        this.sign = sign;
    }

    public boolean shot(int x, int y) {
        gameField = MainGameField.getInstance();
        if (!gameField.isCellBusy(x, y)) {
            gameField.cell[x][y] = sign;
            return true;
        }
        return false;
    }

    public boolean win() {
        gameField = MainGameField.getInstance();
        return gameField.checkWin(this.sign);
    }
}
