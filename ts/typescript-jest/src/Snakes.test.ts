import { Snakes } from './Snakes'

describe('Snakes', () => {
  it('should go down if is a snake', () => {
    const snake = new Snakes()
    expect(snake.checkSnakes(12)).toBe(2)
  })
  })
