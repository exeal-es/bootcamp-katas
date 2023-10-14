import { Ladder } from './Ladder'
import { Token } from './Token'

describe('Ladder', () => {
  it('should connect two squares', () => {
    const ladder = new Ladder(2, 12)
    expect(ladder.connects(2, 12)).toBe(true)
  })

  it('should move token to top when token lands on bottom', () => {
    const token = new Token(2)
    const ladder = new Ladder(2, 12)

    ladder.applyEffect(token)

    expect(token.getPosition()).toBe(12)
  })
})
