import { SquareConnectable } from './SquareConnectable'

export class Snake implements SquareConnectable {
  private readonly head: number
  private readonly tail: number

  constructor(head: number, tail: number) {
    this.head = head
    this.tail = tail
  }

  public hasHeadIn(position: number): boolean {
    return this.head === position
  }

  public connects(head: number, tail: number): boolean {
    return this.head === head && this.tail === tail
  }

  public getTailPosition(): number {
    return this.tail
  }

  public equals(snake: Snake): boolean {
    return this.connects(snake.head, snake.tail)
  }
}
