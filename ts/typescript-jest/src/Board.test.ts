import { Board } from './Board'
import { FakeDice } from './FakeDice'
import { Figure } from './Figure'
import { Ladder } from './Ladder'
import { Snake } from './Snake'
import { Token } from './Token'

describe('Board', () => {
  it('should move token to snake tail when token lands at snake head', () => {
    const token = new Token(10)
    const figures = new Set<Figure>([new Snake(12, 2)])
    const board = new Board(token, figures)

    board.rollDice(new FakeDice(2))

    expect(token.getPosition()).toBe(2)
  })

  it('should not move token to snake tail when token lands at snake tail', () => {
    const token = new Token(1)
    const figures = new Set<Figure>([new Snake(12, 2)])
    const board = new Board(token, figures)

    board.rollDice(new FakeDice(1))

    expect(token.getPosition()).toBe(2)
  })

  it('should move token to ladder top when token lands at ladder bottom', () => {
    const token = new Token(1)
    const figures = new Set<Figure>([new Ladder(2, 12)])
    const board = new Board(token, figures)

    board.rollDice(new FakeDice(1))

    expect(token.getPosition()).toBe(12)
  })

  it('should not move token to ladder top when token lands at ladder top', () => {
    const token = new Token(11)
    const figures = new Set<Figure>([new Ladder(2, 12)])
    const board = new Board(token, figures)

    board.rollDice(new FakeDice(1))

    expect(token.getPosition()).toBe(12)
  })
})
