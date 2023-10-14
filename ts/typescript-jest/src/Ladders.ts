export class Ladders{
    checkLadder(position: number): number {
    
        if(position==2){
         position+=10;
        }
        
        return position;
    }
  }