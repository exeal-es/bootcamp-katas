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
}