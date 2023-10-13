import { RandomDice } from './RandomDice'

describe('RandomDice', () => {
  it('should return a number between 1 and 6', () => {
    const dice = new RandomDice(1, 6)

    for (let i = 0; i < 1000; i++) {
      const result = dice.roll()
      expect(result).toBeGreaterThanOrEqual(1)
      expect(result).toBeLessThanOrEqual(6)
    }
  })
}
)
