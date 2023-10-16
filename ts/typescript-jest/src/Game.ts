import { Board } from './Board'
import { Dice } from './CanRoll'
import { Token } from './Token'

type Pair<T, K> = [T, K]
type Pairs<T, K> = Array<Pair<T, K>>

export class Game {
  private readonly startingRollResult: Map<number, Token>
  private readonly tokens: Token[]

  constructor(tokens: Token[]) {
    this.tokens = tokens
    this.startingRollResult = new Map()
  }

  public determinePlayOrder(dice: Dice): Board | undefined {
    const rollResults: Pairs<number, Token> = []
    const tokensWithoutRollResults =
      this.tokens.filter((token) => !Array.from(this.startingRollResult.values()).some((t) => t === token))
    tokensWithoutRollResults.forEach((token) => {
      const rollResult = dice.roll()
      rollResults.push([rollResult, token])
    })
    const differentRollResults: Pairs<number, Token> =
      rollResults.filter(([rollResult, token]) => !rollResults.some(([r, t]) => r === rollResult && t !== token))
    differentRollResults.forEach(([rollResult, token]) => this.startingRollResult.set(rollResult, token))
    if (this.startingRollResult.size !== this.tokens.length) {
      return undefined
    }
    const tokens = new Set(Array.from(this.startingRollResult.entries()).sort((a, b) => b[0] - a[0]).map((e) => e[1]))
    return new Board(tokens)
  }
}
