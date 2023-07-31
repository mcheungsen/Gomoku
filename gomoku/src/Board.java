// Le plateau, qui représente un tableau de cases remplies ou non
public class Board{
    private final int row, col;
    public final Color[][] board;

    public Board(int r, int c){
        board = new Color[r][c];
        this.row = r;
        this.col = c;
        initializeBoard();
        showBoard();
    }

    public void showBoard() {
        // LETTRES
        System.out.print("    ");
        for(int c = 0; c < col; c++){
            System.out.print((char)(c+65)+ " ");
        }
        System.out.println();


        // LA BARRE HORIZONTALE
        showHorizontalBar();

        for(int l = 0; l < row; l++){
            System.out.print(l+1 + " |");
            for(int c = 0; c < col; c++){
                switch(board[l][c]){
                    case NONE :
                        System.out.print("  ");
                        break;
                    case BLACK :
                        System.out.print(" X");
                        break;
                    case WHITE :
                        System.out.print(" O");
                }
            }
            System.out.println("|");
        }

        showHorizontalBar();
    }

    private void showHorizontalBar() {
        System.out.print("  +");
        for(int c = 0; c < col; c++){
            System.out.print("--");
        }
        System.out.println("+");
    }

    void initializeBoard(){
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                board[i][j] = Color.NONE;
            }
        }
    }

    void set(Position p, Color c){
        board[p.row][p.col] = c;
    }

    Color get(Position p){
        return board[p.row][p.col];
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
