export class Snake {
  private readonly head: number
  private readonly tail: number

  constructor(head: number, tail: number) {
    this.head = head
    this.tail = tail
  }

  public connects(head: number, tail: number): boolean {
    return this.head === head && this.tail === tail
  }

  public equals(snake: Snake): boolean {
    return this.connects(snake.head, snake.tail)
  }
}