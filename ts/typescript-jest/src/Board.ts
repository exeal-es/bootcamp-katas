import { Dice } from './Dice'
import { Snake } from './Snake'
import { Token } from './Token'

export class Board {
  private readonly token: Token
  private readonly dice: Dice
  private readonly snakes: Set<Snake> = new Set()

  constructor(token: Token, dice: Dice) {
    this.token = token
    this.dice = dice
  }

  public add(snakes: Snake): void {
    this.snakes.add(snakes)
  }

  public hasSnake(snake: Snake): boolean {
    return this.snakes.has(snake)
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
