import { CanRoll } from './CanRoll'
import { Figure } from './Figure'
import { Token } from './Token'

export class Board {
  private readonly token: Token
  private readonly figures: Set<Figure> = new Set()

  constructor(token: Token, figures: Set<Figure> = new Set()) {
    this.token = token
    this.figures = figures
  }

  public rollDice(canRoll: CanRoll): void {
    this.token.move(canRoll.roll())
    this.applyFigureEfect(this.token)
  }

  public getTokenPosition(): number {
    return this.token.getPosition()
  }

  public hasWinner(): boolean {
    return this.token.hasWon()
  }

  private applyFigureEfect(token: Token): void {
    Array.from(this.figures).filter((figure) => figure.affects(token))
      .forEach((figure) => figure.applyEffect(token))
  }
}
