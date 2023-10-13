import { Token } from './Token'

export interface Figure {
  connects(start: number, end: number): boolean
  affects(token: Token): boolean
  applyEffect(token: Token): void
}
