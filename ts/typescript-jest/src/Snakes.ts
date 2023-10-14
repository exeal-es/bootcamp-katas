export class Snakes{
    checkSnakes(position: number): number {
    
        if(position==12){
         position-=10;
        }

        return position;
    }
  }