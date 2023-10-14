import { Board } from './Board'
import { FakeDice } from './FakeDice'
import { Figure } from './Figure'
import { Ladder } from './Ladder'
import { Snake } from './Snake'
import { Token } from './Token'

describe('Board', () => {
  it('should return token to position 2 when token arrives at position 12' +
    ' and there is a snake connecting 12 and 2', () => {

      const token = new Token(10)
      const figures = new Set<Figure>([new Snake(12, 2)])
      const board = new Board(token, figures)

      board.rollDice(new FakeDice(2))

      expect(token.getPosition()).toBe(2)
    })

  it('should return token to position 3 when token arrives at position 15' +
    ' and there is a snake connecting 15 and 3', () => {

      const token = new Token(13)
      const figures = new Set<Figure>([new Snake(15, 3)])
      const board = new Board(token, figures)

      board.rollDice(new FakeDice(2))

      expect(token.getPosition()).toBe(3)
    })

  it('should not move token to position 12 when token arrives at position 2' +
    ' and there is a snake connecting 12 and 2', () => {

      const token = new Token(1)
      const figures = new Set<Figure>([new Snake(12, 2)])
      const board = new Board(token, figures)

      board.rollDice(new FakeDice(1))

      expect(token.getPosition()).toBe(2)
    })

  it('should moves token to position 12 when token arrives at position 2' +
    ' and there is a ladder connecting 2 and 12', () => {

      const token = new Token(1)
      const figures = new Set<Figure>([new Ladder(2, 12)])
      const board = new Board(token, figures)

      board.rollDice(new FakeDice(1))

      expect(token.getPosition()).toBe(12)
    })

  it('should not move token to position 12 when token arrives at position 12' +
    ' and there is a ladder connecting 2 and 12', () => {

      const token = new Token(11)
      const figures = new Set<Figure>([new Ladder(2, 12)])
      const board = new Board(token, figures)

      board.rollDice(new FakeDice(1))

      expect(token.getPosition()).toBe(12)
    })
})
