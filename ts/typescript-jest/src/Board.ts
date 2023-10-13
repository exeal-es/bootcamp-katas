import { Dice } from './Dice'
import { Figure } from './Figure'
import { Token } from './Token'

export class Board {
  private readonly token: Token
  private readonly dice: Dice
  private readonly figures: Set<Figure> = new Set()

  constructor(token: Token, dice: Dice) {
    this.token = token
    this.dice = dice
  }

  public place(figure: Figure): void {
    this.figures.add(figure)
  }

  public has(figure: Figure): boolean {
    return this.figures.has(figure)
  }

  public moveToken(): void {
    this.token.move(this.dice.roll())
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
