package com.kodilla.rps.round;

import com.kodilla.rps.RpsMenu;
import com.kodilla.rps.move.RpsMove;
import com.kodilla.rps.move.RpsMovesComparator;
import java.util.Scanner;

public class RpsRound {

    private static final Scanner scanner = new Scanner(System.in);
    private int roundNumber;

    public RpsRound(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    public RpsRoundResult playRound() {
        RpsMenu.printRoundInstructions(roundNumber);
        RpsMove playerMove = getPlayerMove();
        RpsMove computerMove = RpsMove.getComputerMove();
        RpsRoundResult roundResult = RpsMovesComparator.compare(playerMove, computerMove);
        RpsMenu.printRoundResult(playerMove, computerMove, roundResult);
        return roundResult;
    }

    private static RpsMove getPlayerMove() {
        boolean rightMove = false;
        RpsMove playerMove = null;
        while (!rightMove) {
            playerMove = RpsMove.mapPlayerMove(scanner.next());
            if (!RpsMove.isRightMove(playerMove)) {
                RpsMenu.printWrongKeyInfo();
            } else {
                rightMove = true;
            }
        }
        return playerMove;
    }
}