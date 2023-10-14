import { Figure } from './Figure'
import { Token } from './Token'

export class Ladder implements Figure {
  private readonly bottom: number
  private readonly top: number

  constructor(bottom: number, top: number) {
    this.bottom = bottom
    this.top = top
  }

  public connects(bottom: number, top: number): boolean {
    return this.bottom === bottom && this.top === top
  }

  public affects(token: Token): boolean {
    return this.hasBottomIn(token.getPosition())
  }

  public applyEffect(token: Token): void {
    if (this.affects(token)) {
      token.move(this.top - this.bottom)
    }
  }

  public equals(ladder: Ladder): boolean {
    return this.connects(ladder.bottom, ladder.top)
  }

  private hasBottomIn(tokenPosition: number): boolean {
    return this.bottom === tokenPosition
  }
}
