import { Figure } from './Figure'
import { Token } from './Token'

export class Snake implements Figure {
  private readonly head: number
  private readonly tail: number

  constructor(head: number, tail: number) {
    this.head = head
    this.tail = tail
  }

  public connects(head: number, tail: number): boolean {
    return this.head === head && this.tail === tail
  }

  public applyEffect(token: Token): void {
    if (this.hasHeadIn(token.getPosition())) {
      token.applySnakeEffect(this)
    }
  }

  public hasHeadIn(position: number): boolean {
    return this.head === position
  }

  public getTailPosition(): number {
    return this.tail
  }

  public equals(snake: Snake): boolean {
    return this.connects(snake.head, snake.tail)
  }
}
