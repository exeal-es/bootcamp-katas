import { Dice } from './Dice'
import { Ladder } from './Ladder'
import { Snake } from './Snake'
import { Token } from './Token'

export class Board {
  private readonly token: Token
  private readonly dice: Dice
  private readonly snakes: Set<Snake> = new Set()
  private readonly ladders: Set<Ladder> = new Set()

  constructor(token: Token, dice: Dice) {
    this.token = token
    this.dice = dice
  }

  public placeSnake(snake: Snake): void {
    this.snakes.add(snake)
  }

  public placeLadder(ladder: Ladder): void {
    this.ladders.add(ladder)
  }

  public hasSnake(snake: Snake): boolean {
    return this.snakes.has(snake)
  }

  public moveToken(): void {
    const tokenPosition = this.token.move(this.dice.roll())
    const snake = this.findSnake(tokenPosition)
    const ladder = this.findLadder(tokenPosition)
    if (snake) {
      this.token.applySnakeEffect(snake)
    }
    if (ladder) {
      this.token.applyLadderEffect(ladder)
    }
  }

  public getTokenPosition(): number {
    return this.token.getPosition()
  }

  public hasWinner(): boolean {
    return this.token.hasWon()
  }

  private findLadder(tokenPosition: number): Ladder | undefined {
    return Array.from(this.ladders).find((ladder) => ladder.hasBottomIn(tokenPosition))
  }

  private findSnake(tokenPosition: number): Snake | undefined {
    return Array.from(this.snakes).find((snake) => snake.hasHeadIn(tokenPosition))
  }
}
