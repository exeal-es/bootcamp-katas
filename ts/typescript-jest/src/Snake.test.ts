import { Snake } from './Snake';

describe('Snake', () => {
  it("should connect two squares", () => {
    const snake = new Snake(12, 2);
    expect(snake.connects(12, 2)).toBe(true);
  });
})