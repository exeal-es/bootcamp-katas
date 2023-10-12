export class Ladder {
  private readonly bottom: number
  private readonly top: number

  constructor(bottom: number, top: number) {
    this.bottom = bottom
    this.top = top
  }

  public connects(bottom: number, top: number): boolean {
    return this.bottom === bottom && this.top === top
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
