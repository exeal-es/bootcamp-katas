import { Dice } from './Dice'
import { Token } from './Token'

export class Board {
  public token: Token
  public dice: Dice

  constructor(token: Token, dice: Dice) {
    this.token = token
    this.dice = dice
  }

  public moveToken(): void {
    const tokenPosition = this.token.move(this.dice.roll())
    if (tokenPosition === 12) {
      this.token.applySnakeEffect(2)
    }
  }

  public getTokenPosition(): number {
    return this.token.getPosition()
  }

  public hasWinner(): boolean {
    return this.token.hasWon()
  }
}
