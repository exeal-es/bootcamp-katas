import { CanRoll } from './CanRoll'

export class FakeDice implements CanRoll {
  private readonly value: number

  constructor(value: number) {
    this.value = value
  }

  public roll(): number {
    return this.value
  }
}
