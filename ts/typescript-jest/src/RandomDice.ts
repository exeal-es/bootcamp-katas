import { CanRoll } from './CanRoll'

export class RandomDice implements CanRoll {
  private readonly min: number
  private readonly max: number

  constructor(min: number, max: number) {
    this.min = min
    this.max = max
  }

  public roll() {
    return Math.floor(Math.random() * this.max) + this.min
  }
}
