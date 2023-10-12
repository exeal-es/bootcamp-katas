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

  public applyEffect(token: Token): void {
    if (this.hasBottomIn(token.getPosition())) {
      token.applyLadderEffect(this)
    }
  }

  public hasBottomIn(tokenPosition: number): boolean {
    return this.bottom === tokenPosition
  }

  public getTopPosition(): number {
    return this.top
  }

  public equals(ladder: Ladder): boolean {
    return this.connects(ladder.bottom, ladder.top)
  }
}
