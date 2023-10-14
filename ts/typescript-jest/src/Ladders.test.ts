import { Ladders } from './Ladders'

describe('Ladders', () => {
  it('should go up if is a ladder', () => {
    const ladder = new Ladders()
    expect(ladder.checkLadder(2)).toBe(12)
  })
  })

  describe('Ladders', () => {
    it('should is on same position if is not a ladder', () => {
      const ladder = new Ladders()
      expect(ladder.checkLadder(12)).toBe(12)
    })
    })  