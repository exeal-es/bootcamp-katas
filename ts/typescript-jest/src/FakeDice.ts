import { Dice } from './CanRoll'

export class FakeDice implements Dice {
  private readonly value: number

  constructor(value: number) {
    this.value = value
  }

  public roll(): number {
    return this.value
  }
}
