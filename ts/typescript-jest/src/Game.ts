import { Dice } from './Dice'
import { Token } from './Token'
import { UserInputReader } from './UserInputReader'

export class Game {
    public token: Token
    public dice: Dice

    constructor(token: Token, dice: Dice) {
        this.token = token
        this.dice = dice
    }

    public play() {
        this.token.move(this.dice.roll())
    }

    public getTokenPosition(): number {
        return this.token.getPosition()
    }

    public hasEnded(): boolean {
        return this.token.hasWon()
    }
}
