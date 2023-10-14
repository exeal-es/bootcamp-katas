import { Board } from './Board'
import { CanRoll } from './CanRoll'
import { Token } from './Token'

export class Game {
  private readonly token1: Token
  private readonly token2: Token

  constructor(token1: Token, token2: Token) {
    this.token1 = token1
    this.token2 = token2
  }

  public start(canRoll: CanRoll): Board | undefined {
    const token1RollResult = canRoll.roll()
    const token2RollResult = canRoll.roll()
    if (token1RollResult === token2RollResult) {
      return undefined
    }
    return new Board(new Set(token1RollResult > token2RollResult ? [this.token1, this.token2] : [this.token2, this.token1]))
  }
}