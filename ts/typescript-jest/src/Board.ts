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

  public place(snake: Snake): void {
    this.snakes.add(snake)
  }

  public hasSnake(snake: Snake): boolean {
    return this.snakes.has(snake)
  }

  public moveToken(): void {
    const tokenPosition = this.token.move(this.dice.roll())
    const snake = this.findSnake(tokenPosition)
    if (snake) {
      this.token.applySnakeEffect(snake)
    }
  }

  public getTokenPosition(): number {
    return this.token.getPosition()
  }

  public hasWinner(): boolean {
    return this.token.hasWon()
  }

  private findSnake(tokenPosition: number): Snake | undefined {
    return Array.from(this.snakes).find((snake) => snake.hasHeadIn(tokenPosition))
  }
}
