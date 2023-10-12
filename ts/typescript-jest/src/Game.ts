import { Board } from './Board'

export class Game {
    private readonly board: Board

    constructor(board: Board) {
        this.board = board
    }

    public play(): void {
        return this.board.moveToken()
    }

    public getTokenPosition(): number {
        return this.board.getTokenPosition()
    }

    public hasEnded(): boolean {
        return this.board.hasWinner()
    }
}
