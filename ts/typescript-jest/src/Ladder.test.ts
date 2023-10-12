import { Ladder } from './Ladder'

describe('Ladder', () => {
  it('should connect two squares', () => {
    const ladder = new Ladder(2, 12)
    expect(ladder.connects(2, 12)).toBe(true)
  })
})