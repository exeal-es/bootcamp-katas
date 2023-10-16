import { Dice } from './CanRoll'
import { Figure } from './Figure'
import { Token } from './Token'

export class Board {
  private readonly tokens: Set<Token>
  private readonly figures: Set<Figure>
  private tokenWithTurn: Token

  constructor(tokens: Set<Token> = new Set<Token>([new Token(1)]), figures: Set<Figure> = new Set()) {
    this.figures = figures
    this.tokens = tokens
    this.tokenWithTurn = tokens.values().next().value
  }

  public rollDice(canRoll: Dice): void {
    this.tokenWithTurn.move(canRoll.roll())
    this.applyFigureEffect(this.tokenWithTurn)
    this.changeTurn()
  }

  public getTokenWithTurnPosition(): number {
    return this.tokenWithTurn.getPosition()
  }

  public hasWinner(): boolean {
    return Array.from(this.tokens).some((token) => token.hasWon())
  }

  private applyFigureEffect(token: Token): void {
    Array.from(this.figures).filter((figure) => figure.affects(token))
      .forEach((figure) => figure.applyEffect(token))
  }

  private changeTurn(): void {
    const tokens = Array.from(this.tokens)
    this.tokenWithTurn = tokens[(tokens.indexOf(this.tokenWithTurn) + 1) % tokens.length]
  }
}
