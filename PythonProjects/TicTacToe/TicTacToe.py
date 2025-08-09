import random

def print_board(board):
    for i, row in enumerate(board):
        row_str = " "
        for j,value in enumerate(row):
            row_str += value 
            if j != len(row) - 1:
                row_str += " | "
        
        print(row_str)
        if i != len(board)-1:
            print("---------")

def get_move(turn,board):

    while True:
        row = int(input("Row: "))
        col = int(input("Col: "))

        if row < 1 or row > len(board):
            print("Invalid row, try again")
            continue
        elif col < 1 or col > len(board[row-1]):
            print("Invalid col, try again")
            continue
        elif board[row -1][col -1] != " ":
            print("Already taken,try again")
            continue
        else:
            break

    board[row-1][col-1] = turn

def check_win(board,turn):
    lines = [
        [(0,0),(0,1),(0,2)],
        [(1,0),(1,1),(1,2)],
        [(2,0),(2,1),(2,2)],
        [(0,0),(1,0),(2,0)],
        [(0,1),(1,1),(2,1)],
        [(0,2),(1,2),(2,2)],
        [(0,0),(1,1),(2,2)],
        [(0,0),(1,1),(2,0)],
    ]

    for line in lines:
        win = True
        for pos in line:
            row,col = pos#
            if board[row][col] != turn:
                win = False
                break
    
        if win:
            return True
    
    return False


def computer_move():

    empty_cells = []

    for i in range(len(board)):
        for j in range(len(board[i])):
            if board[i][j] == " ":
                empty_cells.append((i,j))
    
    if not empty_cells:
        return

    row,col = random.choice(empty_cells)
    
    board[row][col] = "O"
    print(f"\nComputer (O) played at row {row+1}, col {col+1}")


board = [
    [" "," "," "],
    [" "," "," "],
    [" "," "," "],
]

turn = "X"
turn_number = 0
print_board(board)

while turn_number < 9:
    print()
    print("It is the" , turn , "players turn. Please select your turn.")
    
    if turn == "O":
        computer_move()
    else:
        get_move(turn,board)

    print_board(board)

    winner = check_win(board,turn)
    if winner:
        break

    if turn == "X":
        turn = "O"
    else:
        turn = "X"

    turn_number += 1

if turn_number == 9:
    print("Tied game.")

print("The winner was" , turn)