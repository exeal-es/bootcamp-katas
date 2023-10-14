import { Ladders } from './Ladders'

describe('Ladders', () => {
  it('should go up if is a ladder', () => {
    const ladder = new Ladders()
    expect(ladder.checkLadder(2)).toBe(12)
  })
  })