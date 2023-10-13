import { Board } from './Board'
import { CanRoll } from './CanRoll'

export class Game {
    private readonly board: Board

    constructor(board: Board) {
        this.board = board
    }

    public throwDice(canRoll: CanRoll): void {
        return this.board.throwDice(canRoll)
    }

    public getTokenPosition(): number {
        return this.board.getTokenPosition()
    }

    public hasEnded(): boolean {
        return this.board.hasWinner()
    }
}
