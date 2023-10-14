import { Snake } from './Snake'
import { Token } from './Token'

describe('Snake', () => {
  it('should connect two squares', () => {
    const snake = new Snake(12, 2)
    expect(snake.connects(12, 2)).toBe(true)
  })

  it('should move token to tail when token lands on head', () => {
    const token = new Token(12)
    const snake = new Snake(12, 2)

    snake.applyEffect(token)

    expect(token.getPosition()).toBe(2)
  })
})
