package Objects;


import java.awt.Point;
import java.util.ArrayList;

// a set of functions that help determine the next moves on a specific
// board
//
// PAY ATTENTION TO THE FOLLOWING: 
//		- a piece can't move if, after it has moved, the king is under attack
//		- a pawn can move to the left or to the right if it attacks
//		- try to use direction vectors for the knight and king
//		- check if king can castle ( it hasn't moved, it isn't under attack and
//				no peace controls any square on it's path )
//		- you must implement the moves for the black and the white pieces
//		- in DEBUGGING STATE, use the move.isValid( move ) function
// 		- please validate that there is actually that piece at the position pos

public class helper {
	
	// returns a list of valid moves for a pawn in position pos
	
	public static ArrayList<move> getPawnMoves( String [] map , boolean [][] moved, Point pos ) {
		// TODO
                ArrayList<move> list = new ArrayList<move>();
                char piece = map[pos.x].charAt(pos.y);
                //pt alb
                if(piece == 'P'){
                    if(pos.x+1<8){
                        if(map[pos.x+1].charAt(pos.y) == ' '){
                            //adaug la array list pozitia pos.x+1 pos.y
                            list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+1,pos.y)));
                        }
                    }
                    if(pos.x+1<8 && pos.y + 1 < 8){
                            if(map[pos.x+1].charAt(pos.y+1) != ' '){
                                //adaug la array
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+1,pos.y+1)));
                            }
                    }
                    if(pos.x+1<8 && pos.y -1 >= 0){        
                            if(map[pos.x+1].charAt(pos.y-1) != ' ' /*suficient? cum vad ca nu e nimic acolo?*/){
                                    //adaug la array
                                    list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+1,pos.y-1)));
                            }
                    }
                }
                //pt negru
                if(piece == 'p'){
                    if(pos.x-1>=0){
                        if(map[pos.x-1].charAt(pos.y) == ' '){
                                //adaug la array list pozitia pos.x+1 pos.y
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-1,pos.y)));
                        }
                    }
                    if(pos.x-1 >=0 && pos.y +1 < 8){
                            if(map[pos.x-1].charAt(pos.y+1) != ' ' /*suficient?*/){
                                    //adaug la array
                                    list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-1,pos.y+1)));
                            }
                    }
                    if(pos.x-1 >=0 && pos.y - 1 >= 0){        
                            if(map[pos.x-1].charAt(pos.y-1) != ' ' /*suficient? cum vad ca nu e nimic acolo?*/){
                                    //adaug la array
                                    list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-1,pos.y-1)));
                            }
                    }
                }
               
                return list;
	}
	
	// returns a list of valid moves for a rook in position pos
	
	public static ArrayList<move> getRookMoves( String [] map , boolean [][] moved, Point pos ) {
		// TODO 
                ArrayList<move> list = new ArrayList<move>();
                char piece = map[pos.x].charAt(pos.y);
                //pt alb
                if(piece == 'R'){
                    int t = 0;
                    int i = 1;
                    /*sunt 4 cazuri la tura -> <- jos sus */
                    while(t!=1 && pos.x+i < 8){
                            if(map[pos.x+i].charAt(pos.y)!=' '){ 
                                //adaug la miscari posibile
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+i,pos.y)));
                                i=i+1;
                            }
                            else { 
                                // adaug la miscare posibila
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+i,pos.y)));
                                t=1;
                            }    
                    }
                    t=0;
                    i=1;
                    
                    while(t!=1 && pos.x-i >= 0){
                        
                            if(map[pos.x-i].charAt(pos.y)!=' '){ 
                                //adaug la miscari posibile
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-i,pos.y)));
                                i=i+1;
                            }
                            else { 
                                // adaug la miscare posibila
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-i,pos.y)));
                                t=1;
                            }
                    }
                    t=0;
                    i=1;
                    
                    while(t!=1 && pos.y-i >= 0){
                        
                            if(map[pos.x].charAt(pos.y-i)!=' '){ 
                                //adaug la miscari posibile
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x,pos.y-i)));
                                i=i+1;
                            }
                            else { 
                                // adaug la miscare posibila
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x,pos.y-i)));
                                t=1;
                            }
                    }
                    t=0;
                    i=1;
                    
                    while(t!=1 && pos.x+i < 8){
                        
                            if(map[pos.x+i].charAt(pos.y)!=' '){ 
                                //adaug la miscari posibile
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+i,pos.y)));
                                i=i+1;
                            }
                            else { 
                                // adaug la miscare posibila
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+i,pos.y)));
                                t=1;
                            }
                    }
                }  
                //pt negru
                if(piece == 'r'){
                    int t = 0;
                    int i = 1;
                    /*sunt 4 cazuri la tura -> <- jos sus */
                    while(t!=1 && pos.x+i < 8){
                            if(map[pos.x+i].charAt(pos.y)!=' '){ 
                                //adaug la miscari posibile
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+i,pos.y)));
                                i=i+1;
                            }
                            else { 
                                // adaug la miscare posibila
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+i,pos.y)));
                                t=1;
                            }    
                    }
                    t=0;
                    i=1;
                    
                    while(t!=1 && pos.x-i >= 0){
                        
                            if(map[pos.x-i].charAt(pos.y)!=' '){ 
                                //adaug la miscari posibile
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-i,pos.y)));
                                i=i+1;
                            }
                            else { 
                                // adaug la miscare posibila
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-i,pos.y)));
                                t=1;
                            }
                    }
                    t=0;
                    i=1;
                    
                    while(t!=1 && pos.y-i >= 0){
                        
                            if(map[pos.x].charAt(pos.y-i)!=' '){ 
                                //adaug la miscari posibile
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x,pos.y-i)));
                                i=i+1;
                            }
                            else { 
                                // adaug la miscare posibila
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x,pos.y-i)));
                                t=1;
                            }
                    }
                    t=0;
                    i=1;
                    
                    while(t!=1 && pos.x+i < 8){
                        
                            if(map[pos.x+i].charAt(pos.y)!=' '){ 
                                //adaug la miscari posibile
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+i,pos.y)));
                                i=i+1;
                            }
                            else { 
                                // adaug la miscare posibila
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+i,pos.y)));
                                t=1;
                            }
                    }
                }  
		return list;
	}
	
	// returns a list of valid moves for a knight in position pos
	
	public static ArrayList<move> getKnightMoves( String [] map , boolean [][] moved, Point pos ) {
		// TODO
                ArrayList<move> list = new ArrayList<move>();
                char piece = map[pos.x].charAt(pos.y);
                //pt alb
                if(piece == 'N'){
                    if(pos.x+2 < 8 && pos.y-1 >=0){
                        //adaug pozitia pos.x+2 pos.y-1 la mutari
                        list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+2,pos.y-1)));
                    }
                
                    if(pos.x+2 < 8 && pos.y+1 <8){
                        //adaug pozitia pos.x+2 pos.y+1 la mutari
                        list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+2,pos.y+1)));
                    }
                
                    if(pos.x-2 >= 0 && pos.y-1 >=0){
                        //adaug pozitia pos.x-2 pos.y-1 la mutari
                        list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-2,pos.y-1)));
                    }
                
                    if(pos.x-2 >= 0 && pos.y+1 < 8){
                        //adaug pozitia pos.x-2 pos.y+1 la mutari
                        list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-2,pos.y+1)));
                    }
                
                    if(pos.x-1 >= 0 && pos.y+2 < 8){
                        //adaug pozitia pos.x-1 pos.y+2 la mutari
                        list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-1,pos.y+2)));
                    }
                
                    if(pos.x-1 >= 0 && pos.y-2 >=0){
                        //adaug pozitia pos.x-1 pos.y-2 la mutari
                        list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-1,pos.y-2)));
                    }
                
                    if(pos.x+1 < 8 && pos.y+2 <8){
                        //adaug pozitia pos.x+1 pos.y+2 la mutari
                        list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+1,pos.y+2)));
                    }
                
                    if(pos.x+1 < 8 && pos.y-2 >=0){
                        //adaug pozitia pos.x+1 pos.y-2 la mutari
                        list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+1,pos.y-2)));
                    }
                }
                // pt negru
                 if(piece == 'n'){
                    if(pos.x+2 < 8 && pos.y-1 >=0){
                        //adaug pozitia pos.x+2 pos.y-1 la mutari
                        list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+2,pos.y-1)));
                    }
                
                    if(pos.x+2 < 8 && pos.y+1 <8){
                        //adaug pozitia pos.x+2 pos.y+1 la mutari
                        list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+2,pos.y+1)));
                    }
                
                    if(pos.x-2 >= 0 && pos.y-1 >=0){
                        //adaug pozitia pos.x-2 pos.y-1 la mutari
                        list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-2,pos.y-1)));
                    }
                
                    if(pos.x-2 >= 0 && pos.y+1 < 8){
                        //adaug pozitia pos.x-2 pos.y+1 la mutari
                        list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-2,pos.y+1)));
                    }
                
                    if(pos.x-1 >= 0 && pos.y+2 < 8){
                        //adaug pozitia pos.x-1 pos.y+2 la mutari
                        list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-1,pos.y+2)));
                    }
                
                    if(pos.x-1 >= 0 && pos.y-2 >=0){
                        //adaug pozitia pos.x-1 pos.y-2 la mutari
                        list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-1,pos.y-2)));
                    }
                
                    if(pos.x+1 < 8 && pos.y+2 <8){
                        //adaug pozitia pos.x+1 pos.y+2 la mutari
                        list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+1,pos.y+2)));
                    }
                
                    if(pos.x+1 < 8 && pos.y-2 >=0){
                        //adaug pozitia pos.x+1 pos.y-2 la mutari
                        list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+1,pos.y-2)));
                    }
                }
                
                
		return list;
	}
	
	// returns a list of valid moves for a bishop in position pos
	
	public static ArrayList<move> getBishopMoves( String [] map , boolean [][] moved, Point pos ) {
		// TODO
                ArrayList<move> list = new ArrayList<move>();
                char piece = map[pos.x].charAt(pos.y);
                int i;
                int t;
                if(piece == 'B'){
                    t = 0;
                    i = 1;
                    /*sunt 4 cazuri la nebun 4 diagonale */
                    while(t!=1 && pos.x+i < 8 && pos.y+i < 8){
                            if(map[pos.x+i].charAt(pos.y+i)!=' '){ 
                                //adaug la miscari posibile
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+i,pos.y+i)));
                                i=i+1;
                            }
                            else { 
                                // adaug la miscare posibila chiar daca am gasit o piesa in drum
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+i,pos.y+i)));
                                t=1;
                            }    
                    }
                    
                    t = 0;
                    i = 1;
                    
                    while(t!=1 && pos.x+i < 8 && pos.y-i > 0){
                            if(map[pos.x+i].charAt(pos.y-i)!=' '){ 
                                //adaug la miscari posibile
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+i,pos.y-i)));
                                i=i+1;
                            }
                            else { 
                                // adaug la miscare posibila chiar daca am gasit o piesa in drum
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+i,pos.y-i)));
                                t=1;
                            }    
                    }
                    
                    t = 0;
                    i = 1;
                    
                    while(t!=1 && pos.x-i > 0 && pos.y-i > 0){
                            if(map[pos.x-i].charAt(pos.y-i)!=' '){ 
                                //adaug la miscari posibile
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-i,pos.y-i)));
                                i=i+1;
                            }
                            else { 
                                // adaug la miscare posibila chiar daca am gasit o piesa in drum
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-i,pos.y-i)));
                                t=1;
                            }    
                    }
                    
                    t = 0;
                    i = 1;
                    
                    while(t!=1 && pos.x-i > 0 && pos.y+i < 8 ){
                            if(map[pos.x-i].charAt(pos.y+i)!=' '){ 
                                //adaug la miscari posibile
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-i,pos.y+i)));
                                i=i+1;
                            }
                            else { 
                                // adaug la miscare posibila chiar daca am gasit o piesa in drum
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-i,pos.y+i)));
                                t=1;
                            }    
                    }
                    
                }
                //pentru negru
                if(piece == 'b'){
                    t = 0;
                    i = 1;
                    /*sunt 4 cazuri la nebun 4 diagonale */
                    while(t!=1 && pos.x+i < 8 && pos.y+i < 8){
                            if(map[pos.x+i].charAt(pos.y+i)!=' '){ 
                                //adaug la miscari posibile
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+i,pos.y+i)));
                                i=i+1;
                            }
                            else { 
                                // adaug la miscare posibila chiar daca am gasit o piesa in drum
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+i,pos.y+i)));
                                t=1;
                            }    
                    }
                    
                    t = 0;
                    i = 1;
                    
                    while(t!=1 && pos.x+i < 8 && pos.y-i > 0){
                            if(map[pos.x+i].charAt(pos.y-i)!=' '){ 
                                //adaug la miscari posibile
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+i,pos.y-i)));
                                i=i+1;
                            }
                            else { 
                                // adaug la miscare posibila chiar daca am gasit o piesa in drum
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+i,pos.y-i)));
                                t=1;
                            }    
                    }
                    
                    t = 0;
                    i = 1;
                    
                    while(t!=1 && pos.x-i > 0 && pos.y-i > 0){
                            if(map[pos.x-i].charAt(pos.y-i)!=' '){ 
                                //adaug la miscari posibile
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-i,pos.y-i)));
                                i=i+1;
                            }
                            else { 
                                // adaug la miscare posibila chiar daca am gasit o piesa in drum
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-i,pos.y-i)));
                                t=1;
                            }    
                    }
                    
                    t = 0;
                    i = 1;
                    
                    while(t!=1 && pos.x-i > 0 && pos.y+i < 8 ){
                            if(map[pos.x-i].charAt(pos.y+i)!=' '){ 
                                //adaug la miscari posibile
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-i,pos.y+i)));
                                i=i+1;
                            }
                            else { 
                                // adaug la miscare posibila chiar daca am gasit o piesa in drum
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-i,pos.y+i)));
                                t=1;
                            }    
                    }
                    
                }
            
		return list;
	}
	
	// returns a list of valid moves for a queen in position pos
	
	public static ArrayList<move> getQueenMoves( String [] map , boolean [][] moved, Point pos ) {
		// TODO
                ArrayList<move> list = new ArrayList<move>();
                char piece = map[pos.x].charAt(pos.y);
                int i;
                int t;
                //pentru alb
                if(piece == 'Q'){
                    t = 0;
                    i = 1;
                    /*sunt 4 cazuri la nebun 4 diagonale */
                    while(t!=1 && pos.x+i < 8 && pos.y+i < 8){
                            if(map[pos.x+i].charAt(pos.y+i)!=' '){ 
                                //adaug la miscari posibile
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+i,pos.y+i)));
                                i=i+1;
                            }
                            else { 
                                // adaug la miscare posibila chiar daca am gasit o piesa in drum
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+i,pos.y+i)));
                                t=1;
                            }    
                    }
                    
                    t = 0;
                    i = 1;
                    
                    while(t!=1 && pos.x+i < 8 && pos.y-i > 0){
                            if(map[pos.x+i].charAt(pos.y-i)!=' '){ 
                                //adaug la miscari posibile
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+i,pos.y-i)));
                                i=i+1;
                            }
                            else { 
                                // adaug la miscare posibila chiar daca am gasit o piesa in drum
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+i,pos.y-i)));
                                t=1;
                            }    
                    }
                    
                    t = 0;
                    i = 1;
                    
                    while(t!=1 && pos.x-i > 0 && pos.y-i > 0){
                            if(map[pos.x-i].charAt(pos.y-i)!=' '){ 
                                //adaug la miscari posibile
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-i,pos.y-i)));
                                i=i+1;
                            }
                            else { 
                                // adaug la miscare posibila chiar daca am gasit o piesa in drum
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-i,pos.y-i)));
                                t=1;
                            }    
                    }
                    
                    t = 0;
                    i = 1;
                    
                    while(t!=1 && pos.x-i > 0 && pos.y+i < 8 ){
                            if(map[pos.x-i].charAt(pos.y+i)!=' '){ 
                                //adaug la miscari posibile
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-i,pos.y+i)));
                                i=i+1;
                            }
                            else { 
                                // adaug la miscare posibila chiar daca am gasit o piesa in drum
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-i,pos.y+i)));
                                t=1;
                            }    
                    }
                    
                    t = 0;
                    i = 1;
                    /*cazuri pe verticala/ orizontala */
                    while(t!=1 && pos.x+i < 8){
                            if(map[pos.x+i].charAt(pos.y)!=' '){ 
                                //adaug la miscari posibile
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+i,pos.y)));
                                i=i+1;
                            }
                            else { 
                                // adaug la miscare posibila
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+i,pos.y)));
                                t=1;
                            }    
                    }
                    t=0;
                    i=1;
                    
                    while(t!=1 && pos.x-i >= 0){
                        
                            if(map[pos.x-i].charAt(pos.y)!=' '){ 
                                //adaug la miscari posibile
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-i,pos.y)));
                                i=i+1;
                            }
                            else { 
                                // adaug la miscare posibila
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-i,pos.y)));
                                t=1;
                            }
                    }
                    t=0;
                    i=1;
                    
                    while(t!=1 && pos.y-i >= 0){
                        
                            if(map[pos.x].charAt(pos.y-i)!=' '){ 
                                //adaug la miscari posibile
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x,pos.y-i)));
                                i=i+1;
                            }
                            else { 
                                // adaug la miscare posibila
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x,pos.y-i)));
                                t=1;
                            }
                    }
                    t=0;
                    i=1;
                    
                    while(t!=1 && pos.x+i < 8){
                        
                            if(map[pos.x+i].charAt(pos.y)!=' '){ 
                                //adaug la miscari posibile
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+i,pos.y)));
                                i=i+1;
                            }
                            else { 
                                // adaug la miscare posibila
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+i,pos.y)));
                                t=1;
                            }
                    }
                    
                }
                //pentru negru
                if(piece == 'q'){
                    t = 0;
                    i = 1;
                    /*sunt 4 cazuri la nebun 4 diagonale */
                    while(t!=1 && pos.x+i < 8 && pos.y+i < 8){
                            if(map[pos.x+i].charAt(pos.y+i)!=' '){ 
                                //adaug la miscari posibile
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+i,pos.y+i)));
                                i=i+1;
                            }
                            else { 
                                // adaug la miscare posibila chiar daca am gasit o piesa in drum
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+i,pos.y+i)));
                                t=1;
                            }    
                    }
                    
                    t = 0;
                    i = 1;
                    
                    while(t!=1 && pos.x+i < 8 && pos.y-i > 0){
                            if(map[pos.x+i].charAt(pos.y-i)!=' '){ 
                                //adaug la miscari posibile
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+i,pos.y-i)));
                                i=i+1;
                            }
                            else { 
                                // adaug la miscare posibila chiar daca am gasit o piesa in drum
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+i,pos.y-i)));
                                t=1;
                            }    
                    }
                    
                    t = 0;
                    i = 1;
                    
                    while(t!=1 && pos.x-i > 0 && pos.y-i > 0){
                            if(map[pos.x-i].charAt(pos.y-i)!=' '){ 
                                //adaug la miscari posibile
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-i,pos.y-i)));
                                i=i+1;
                            }
                            else { 
                                // adaug la miscare posibila chiar daca am gasit o piesa in drum
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-i,pos.y-i)));
                                t=1;
                            }    
                    }
                    
                    t = 0;
                    i = 1;
                    
                    while(t!=1 && pos.x-i > 0 && pos.y+i < 8 ){
                            if(map[pos.x-i].charAt(pos.y+i)!=' '){ 
                                //adaug la miscari posibile
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-i,pos.y+i)));
                                i=i+1;
                            }
                            else { 
                                // adaug la miscare posibila chiar daca am gasit o piesa in drum
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-i,pos.y+i)));
                                t=1;
                            }    
                    }
                    
                    t = 0;
                    i = 1;
                    
                    /*cazuri pe verticala/ orizontala */
                    while(t!=1 && pos.x+i < 8){
                            if(map[pos.x+i].charAt(pos.y)!=' '){ 
                                //adaug la miscari posibile
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+i,pos.y)));
                                i=i+1;
                            }
                            else { 
                                // adaug la miscare posibila
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+i,pos.y)));
                                t=1;
                            }    
                    }
                    t=0;
                    i=1;
                    
                    while(t!=1 && pos.x-i >= 0){
                        
                            if(map[pos.x-i].charAt(pos.y)!=' '){ 
                                //adaug la miscari posibile
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-i,pos.y)));
                                i=i+1;
                            }
                            else { 
                                // adaug la miscare posibila
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-i,pos.y)));
                                t=1;
                            }
                    }
                    t=0;
                    i=1;
                    
                    while(t!=1 && pos.y-i >= 0){
                        
                            if(map[pos.x].charAt(pos.y-i)!=' '){ 
                                //adaug la miscari posibile
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x,pos.y-i)));
                                i=i+1;
                            }
                            else { 
                                // adaug la miscare posibila
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x,pos.y-i)));
                                t=1;
                            }
                    }
                    t=0;
                    i=1;
                    
                    while(t!=1 && pos.x+i < 8){
                        
                            if(map[pos.x+i].charAt(pos.y)!=' '){ 
                                //adaug la miscari posibile
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+i,pos.y)));
                                i=i+1;
                            }
                            else { 
                                // adaug la miscare posibila
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+i,pos.y)));
                                t=1;
                            }
                    }
                    
                }
                
		return list;
	}
	
	// returns a list of valid moves for a king in position pos
	
	public static ArrayList<move> getKingMoves( String [] map , boolean [][] moved, Point pos ) {
		// TODO
                ArrayList<move> list = new ArrayList<move>();
                char piece = map[pos.x].charAt(pos.y);
                //pt alb
                if(piece == 'K'){
                    if(pos.x+1 < 8 && pos.y-1 >=0){
                        //adaug pozitia pos.x+1 pos.y-1 la mutari
                        list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+1,pos.y-1)));
                    }
                
                    if(pos.x+1 < 8){
                        //adaug pozitia pos.x+1 pos.y la mutari
                        list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+1,pos.y)));
                    }
                
                    if(pos.x+1 < 8 && pos.y+1 < 8){
                        //adaug pozitia pos.x+1 pos.y+1 la mutari
                        list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+1,pos.y+1)));
                    }
                
                    if(pos.y+1 < 8){
                        //adaug pozitia pos.x pos.y+1 la mutari
                        list.add(new move(new Point(pos.x, pos.y),new Point(pos.x,pos.y+1)));
                    }
                
                    if(pos.x-1 >= 0 && pos.y+1 < 8){
                        //adaug pozitia pos.x-1 pos.y+1 la mutari
                        list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-1,pos.y+1)));
                    }
                
                    if(pos.x-1 >= 0){
                        //adaug pozitia pos.x-1 pos.y la mutari
                        list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-1,pos.y)));
                    }
                
                    if(pos.x-1 >= 0 && pos.y-1 >= 0){
                        //adaug poz pos.x-1 pos.y-1 la mutari
                        list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-1,pos.y-1))); 
                    }
                
                    if(pos.y-1 >=0){
                        //adaug pozitia pos.x pos.y-1 la mutari
                        list.add(new move(new Point(pos.x, pos.y),new Point(pos.x,pos.y-1))); 
                    }
                }
                // pt negru
               if(piece == 'k'){
                    if(pos.x+1 < 8 && pos.y-1 >=0){
                        //adaug pozitia pos.x+1 pos.y-1 la mutari
                        list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+1,pos.y-1)));
                    }
                
                    if(pos.x+1 < 8){
                        //adaug pozitia pos.x+1 pos.y la mutari
                        list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+1,pos.y)));
                    }
                
                    if(pos.x+1 < 8 && pos.y+1 < 8){
                        //adaug pozitia pos.x+1 pos.y+1 la mutari
                        list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+1,pos.y+1)));
                    }
                
                    if(pos.y+1 < 8){
                        //adaug pozitia pos.x pos.y+1 la mutari
                        list.add(new move(new Point(pos.x, pos.y),new Point(pos.x,pos.y+1)));
                    }
                
                    if(pos.x-1 >= 0 && pos.y+1 < 8){
                        //adaug pozitia pos.x-1 pos.y+1 la mutari
                        list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-1,pos.y+1)));
                    }
                
                    if(pos.x-1 >= 0){
                        //adaug pozitia pos.x-1 pos.y la mutari
                        list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-1,pos.y)));
                    }
                
                    if(pos.x-1 >= 0 && pos.y-1 >= 0){
                        //adaug poz pos.x-1 pos.y-1 la mutari
                        list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-1,pos.y-1))); 
                    }
                
                    if(pos.y-1 >=0){
                        //adaug pozitia pos.x pos.y-1 la mutari
                        list.add(new move(new Point(pos.x, pos.y),new Point(pos.x,pos.y-1))); 
                    }
                }
		return list;
	}
}