package Objects;

import java.awt.Point;
import java.util.ArrayList;

import settings.settings;

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

//           ~!~ Special thanks to @Alexandru Besleaga  ~!~
//  ~!~ who legendarily wrote 800 lines of code in less than a day ~!~
public class helper {

	// returns a list of valid moves for a pawn in position pos

	public static ArrayList<move> getPawnMoves( String [] map , boolean [][] moved, Point pos ) {
		ArrayList<move> list = new ArrayList<move>();
		char piece = map[pos.x].charAt(pos.y);
                
        // white piece
        if(piece == 'P'){
        	
        	if ( pos.x == settings.BOARD_SIZE - 2 ) {
        		// TODO: pawn promotion
        	}
        	
	        // first move of a pawn
	        if ( pos.x == 1 && map[pos.x + 2].charAt(pos.y)== settings.FREE_CHELL )
			list.add(new move(new Point(pos.x, pos.y),
	    					new Point(pos.x + 2, pos.y)));

	        if(pos.x + 1 < settings.BOARD_SIZE && 
	        		map[pos.x+1].charAt(pos.y) == settings.FREE_CHELL )
	            list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+1,pos.y)));

	        if(pos.x+1<settings.BOARD_SIZE && pos.y + 1 < settings.BOARD_SIZE &&
	               Character.isLowerCase(map[pos.x+1].charAt(pos.y+1)))
	        	list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+1,pos.y+1)));

	        if(pos.x+1<settings.BOARD_SIZE && pos.y -1 >= 0 &&
	        		Character.isLowerCase(map[pos.x+1].charAt(pos.y-1)))
	        	list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+1,pos.y-1)));
        }
     
	    // black piece
	    if(piece == 'p'){

	    	if ( pos.x == 1 ) {
        		// TODO: pawn promotion
        	}

	    	if ( pos.x == settings.BOARD_SIZE - 1 && 
	    			map[pos.x - 2].charAt(pos.y) == settings.FREE_CHELL )
	    		list.add(new move( new Point(pos.x, pos.y),
	    							new Point(pos.x - 2, pos.y)));

	        if(pos.x-1>=0 && map[pos.x-1].charAt(pos.y) == settings.FREE_CHELL)
              	list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-1,pos.y)));

	        if(pos.x-1 >=0 && pos.y +1 < settings.BOARD_SIZE && 
	        		Character.isUpperCase(map[pos.x-1].charAt(pos.y+1)))
                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-1,pos.y+1)));

	        if(pos.x-1 >=0 && pos.y - 1 >= 0 &&
	        		Character.isUpperCase(map[pos.x-1].charAt(pos.y-1)))
                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-1,pos.y-1)));
	    }

	    return list;
	}

	// returns a list of valid moves for a rook in position pos

	public static ArrayList<move> getRookMoves( String [] map , boolean [][] moved, Point pos ) { 
        ArrayList<move> list = new ArrayList<move>();
        char piece = map[pos.x].charAt(pos.y);
        
        // white piece
        if(piece == 'R'){
        	
            int t = 0;
            int i = 1;
            
            // trying to move upwards
            while(t!=1 && pos.x+i < settings.BOARD_SIZE){
            	
	    		// it might need to check if map[pos.x+i][pos.y] == ' '
	            if(Character.isLowerCase(map[pos.x+i].charAt(pos.y))){
	                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+i,pos.y)));
	                t = 1;
	            }
	            else if ( map[pos.x+i].charAt(pos.y) == settings.FREE_CHELL ){
	                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+i,pos.y)));
	                i = i + 1;
	            }    
	            else 
	            	t = 1;
            }
            
            t=0;
            i=1;
            
            // trying to move downwards
            while(t!=1 && pos.x-i >= 0){
                
	            if(Character.isLowerCase(map[pos.x-i].charAt(pos.y))){
	                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-i,pos.y)));
	                t = 1;
	            }
	            else if ( map[pos.x-i].charAt(pos.y) == settings.FREE_CHELL ){
	                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-i,pos.y)));
	                i = i + 1;
	            }
	            else
	            	t = 1;
            }
            
            t=0;
            i=1;
            
            // trying to move leftwards
            while(t!=1 && pos.y-i >= 0){
                
                if(Character.isLowerCase(map[pos.x].charAt(pos.y-i))){
                    list.add(new move(new Point(pos.x, pos.y),new Point(pos.x,pos.y-i)));
                    t = 1;
                }
                else if ( map[pos.x].charAt(pos.y-i) == settings.FREE_CHELL ){
                    list.add(new move(new Point(pos.x, pos.y),new Point(pos.x,pos.y-i)));
                    i = i + 1;
                }
                else 
                	t = 1;
            }
            
            t=0;
            i=1;
            
            // trying to move rightwards
            while(t!=1 && pos.y+i < settings.BOARD_SIZE){
                
                if(Character.isLowerCase(map[pos.x].charAt(pos.y + i))){
                    list.add(new move(new Point(pos.x, pos.y),new Point(pos.x,pos.y + i)));
                    t = 1;
                }
                else if ( map[pos.x].charAt(pos.y + i) == settings.FREE_CHELL ){ 
                    list.add(new move(new Point(pos.x, pos.y),new Point(pos.x,pos.y + i)));
                    i = i + 1;
                }
                else 
                	t = 1;
            }
        }  
        
        // black piece
        if(piece == 'r'){
        	
            int t = 0;
            int i = 1;
            
            // trying to move downwards ( change of perspective )
            while(t!=1 && pos.x+i < settings.BOARD_SIZE){
            	
                if(Character.isUpperCase(map[pos.x+i].charAt(pos.y))) {
                    list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+i,pos.y)));
                    t = 1;
                }
                else if ( map[pos.x+i].charAt(pos.y) == settings.FREE_CHELL ){ 
                    list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+i,pos.y)));
                    i = i + 1;
                } else 
                	t = 1;
            }
            
            t=0;
            i=1;
            
            // trying to move upwards ( change of perspective )
            while(t!=1 && pos.x-i >= 0){
                
                if(Character.isUpperCase(map[pos.x-i].charAt(pos.y))){ 
                    list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-i,pos.y)));
                    t = 1;
                }
                else if ( map[pos.x-i].charAt(pos.y) == settings.FREE_CHELL ) {
                    list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-i,pos.y)));
                    i = i + 1;
                }
                else
                	t = 1;
            }
            
            t=0;
            i=1;
            
            // trying to move rightwards ( change of perspective )
            while(t!=1 && pos.y-i >= 0){
                
                if(Character.isUpperCase(map[pos.x].charAt(pos.y-i))){ 
                    list.add(new move(new Point(pos.x, pos.y),new Point(pos.x,pos.y-i)));
                    t = 1;
                }
                else if ( map[pos.x].charAt(pos.y-i) == settings.FREE_CHELL ){
                    list.add(new move(new Point(pos.x, pos.y),new Point(pos.x,pos.y-i)));
                    i = i + 1;
                }
                else
                	t = 1;
            }
            
            t=0;
            i=1;
            
            // trying to move leftwards ( change of perspective )
            while(t!=1 && pos.y + i < settings.BOARD_SIZE){
                
                if(Character.isUpperCase(map[pos.x].charAt(pos.y + i))){
                    list.add(new move(new Point(pos.x, pos.y),new Point(pos.x,pos.y + i)));
                    t = 1;
                }
                else if ( map[pos.x].charAt(pos.y + i) == settings.FREE_CHELL ){
                    list.add(new move(new Point(pos.x, pos.y),new Point(pos.x,pos.y + i)));
                    i = i + 1;
                }
                else
                	t = 1;
            }
        }  
        
        return list;
	}

	// returns a list of valid moves for a knight in position pos

	public static ArrayList<move> getKnightMoves( String [] map , boolean [][] moved, Point pos ) {
		// TODO
                ArrayList<move> list = new ArrayList<move>();
                char piece = map[pos.x].charAt(pos.y);
                //white pieces
                if(piece == 'N'){
                    //the knight tries to go down left ( as we look at the board)
                    if(pos.x+2 < settings.BOARD_SIZE && pos.y-1 >=0 && !(Character.isUpperCase(map[pos.x+2].charAt(pos.y-1)))){
                        list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+2,pos.y-1)));
                    }
                    //the knight tries to go down right ( as we look at the board)
                    if(pos.x+2 < settings.BOARD_SIZE && pos.y+1 <settings.BOARD_SIZE && !(Character.isUpperCase(map[pos.x+2].charAt(pos.y+1)))){
                        list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+2,pos.y+1)));
                    }
                    //the knight tries to go up left ( as we look at the board)
                    if(pos.x-2 >= 0 && pos.y-1 >=0 && !(Character.isUpperCase(map[pos.x-2].charAt(pos.y-1)))){
                        list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-2,pos.y-1)));
                    }
                    //the knight tries to go up right ( as we look at the board)
                    if(pos.x-2 >= 0 && pos.y+1 < settings.BOARD_SIZE && !(Character.isUpperCase(map[pos.x-2].charAt(pos.y+1)))){
                        list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-2,pos.y+1)));
                    }
                    //the knight tries to go up right ( as we look at the board)
                    if(pos.x-1 >= 0 && pos.y+2 < settings.BOARD_SIZE && !(Character.isUpperCase(map[pos.x-1].charAt(pos.y+2)))){
                        list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-1,pos.y+2)));
                    }
                    //the knight tries to go up left ( as we look at the board)
                    if(pos.x-1 >= 0 && pos.y-2 >=0 && !(Character.isUpperCase(map[pos.x-1].charAt(pos.y-2)))){
                        list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-1,pos.y-2)));
                    }
                    //the knight tries to go down right ( as we look at the board)
                    if(pos.x+1 < settings.BOARD_SIZE && pos.y+2 <settings.BOARD_SIZE && !(Character.isUpperCase(map[pos.x+1].charAt(pos.y+2)))){
                        list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+1,pos.y+2)));
                    }
                    //the knight tries to go down left ( as we look at the board)
                    if(pos.x+1 < settings.BOARD_SIZE && pos.y-2 >=0 && !(Character.isUpperCase(map[pos.x+1].charAt(pos.y-2)))){
                        list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+1,pos.y-2)));
                    }
                }
                // black pieces
                 if(piece == 'n'){
                    //the knight tries to go down left ( as we look at the board)
                    if(pos.x+2 < settings.BOARD_SIZE && pos.y-1 >=0 && !(Character.isLowerCase(map[pos.x+2].charAt(pos.y-1)))){
                        list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+2,pos.y-1)));
                    }
                    //the knight tries to go down right ( as we look at the board)
                    if(pos.x+2 < settings.BOARD_SIZE && pos.y+1 <settings.BOARD_SIZE && !(Character.isLowerCase(map[pos.x+2].charAt(pos.y+1)))){
                        list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+2,pos.y+1)));
                    }
                    //the knight tries to go up left ( as we look at the board)
                    if(pos.x-2 >= 0 && pos.y-1 >=0 && !(Character.isLowerCase(map[pos.x-2].charAt(pos.y-1)))){
                        list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-2,pos.y-1)));
                    }
                    //the knight tries to go up right ( as we look at the board)
                    if(pos.x-2 >= 0 && pos.y+1 < settings.BOARD_SIZE && !(Character.isLowerCase(map[pos.x-2].charAt(pos.y+1))) ){
                        list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-2,pos.y+1)));
                    }
                    //the knight tries to go up right ( as we look at the board)
                    if(pos.x-1 >= 0 && pos.y+2 < settings.BOARD_SIZE && !(Character.isLowerCase(map[pos.x-1].charAt(pos.y+2)))){
                        list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-1,pos.y+2)));
                    }
                    //the knight tries to go up left ( as we look at the board)
                    if(pos.x-1 >= 0 && pos.y-2 >=0 && !(Character.isLowerCase(map[pos.x-1].charAt(pos.y-2)))){
                        list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-1,pos.y-2)));
                    }
                    //the knight tries to go down right ( as we look at the board)
                    if(pos.x+1 < settings.BOARD_SIZE && pos.y+2 <settings.BOARD_SIZE && !(Character.isLowerCase(map[pos.x+1].charAt(pos.y+2)))){
                        list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+1,pos.y+2)));
                    }
                    //the knight tries to go down left ( as we look at the board)
                    if(pos.x+1 < settings.BOARD_SIZE && pos.y-2 >=0 && !(Character.isLowerCase(map[pos.x+1].charAt(pos.y-2)))){
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
                // white pieces
                if(piece == 'B'){
                    t = 0;
                    i = 1;
                    //there are 4 cases 
                    // the bishop wants to go down right (as we look at the board)
                    while(t!=1 && pos.x+i < settings.BOARD_SIZE && pos.y+i < settings.BOARD_SIZE){
                            if(map[pos.x+i].charAt(pos.y+i)==settings.FREE_CHELL){ 
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+i,pos.y+i)));
                                i=i+1;
                            }
                            else { 
                                if(Character.isLowerCase(map[pos.x+i].charAt(pos.y + i))){
                                    list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+i,pos.y+i)));
                                }
                                t=1;
                            }
                   }    
                   
                    
                    t = 0;
                    i = 1;
                    // the bishop wants to go down left (as we look at the board)
                    while(t!=1 && pos.x+i < settings.BOARD_SIZE && pos.y-i > 0){
                            if(map[pos.x+i].charAt(pos.y-i)==settings.FREE_CHELL){ 
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+i,pos.y-i)));
                                i=i+1;
                            }
                            else { 
                                if(Character.isLowerCase(map[pos.x+i].charAt(pos.y - i))){
                                    list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+i,pos.y-i)));
                                }
                                t=1;
                            }    
                    }
                    
                    t = 0;
                    i = 1;
                    // the bishop wants to go up left (as we look at the board)
                    while(t!=1 && pos.x-i > 0 && pos.y-i > 0){
                            if(map[pos.x-i].charAt(pos.y-i)==settings.FREE_CHELL){ 
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-i,pos.y-i)));
                                i=i+1;
                            }
                            else { 
                                if(Character.isLowerCase(map[pos.x-i].charAt(pos.y - i))){ 
                                    list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-i,pos.y-i)));
                                }
                                t=1;
                            }    
                    }
                    
                    t = 0;
                    i = 1;
                    // the bishop wants to go up right (as we look at the board)  
                    while(t!=1 && pos.x-i > 0 && pos.y+i < settings.BOARD_SIZE ){
                            if(map[pos.x-i].charAt(pos.y+i)==settings.FREE_CHELL){ 
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-i,pos.y+i)));
                                i=i+1;
                            }
                            else { 
                                if(Character.isLowerCase(map[pos.x-i].charAt(pos.y + i))){  
                                    list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-i,pos.y+i)));
                                }
                                t=1;
                            }    
                    }
                    
                }
                //black pieces
                if(piece == 'b'){
                    t = 0;
                    i = 1;
                    // there are four cases
                    // the bishop wants to go down right (as we look at the board)
                    while(t!=1 && pos.x+i < settings.BOARD_SIZE && pos.y+i < settings.BOARD_SIZE){
                            if(map[pos.x+i].charAt(pos.y+i)==settings.FREE_CHELL){ 
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+i,pos.y+i)));
                                i=i+1;
                            }
                            else { 
                                if(Character.isUpperCase(map[pos.x+i].charAt(pos.y + i))){  
                                    list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+i,pos.y+i)));
                                }
                                t=1;
                            }    
                    }
                    
                    t = 0;
                    i = 1;
                    // the bishop wants to go down left (as we look at the board) 
                    while(t!=1 && pos.x+i < settings.BOARD_SIZE && pos.y-i > 0){
                            if(map[pos.x+i].charAt(pos.y-i)==settings.FREE_CHELL){ 
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+i,pos.y-i)));
                                i=i+1;
                            }
                            else { 
                                if(Character.isUpperCase(map[pos.x+i].charAt(pos.y - i))){
                                    list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+i,pos.y-i)));
                                }
                                t=1;
                            }    
                    }
                    
                    t = 0;
                    i = 1;
                    // the bishop wants to go up left (as we look at the board) 
                    while(t!=1 && pos.x-i > 0 && pos.y-i > 0){
                            if(map[pos.x-i].charAt(pos.y-i)==settings.FREE_CHELL){ 
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-i,pos.y-i)));
                                i=i+1;
                            }
                            else { 
                                if(Character.isUpperCase(map[pos.x-i].charAt(pos.y - i))){
                                    list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-i,pos.y-i)));
                                }
                                t=1;
                            }    
                    }
                    
                    t = 0;
                    i = 1;
                    // the bishop wants to go up right (as we look at the board) 
                    while(t!=1 && pos.x-i > 0 && pos.y+i < settings.BOARD_SIZE ){
                            if(map[pos.x-i].charAt(pos.y+i)==settings.FREE_CHELL){ 
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-i,pos.y+i)));
                                i=i+1;
                            }
                            else {
                                if(Character.isUpperCase(map[pos.x-i].charAt(pos.y + i))){
                                    list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-i,pos.y+i)));
                                }
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
                    //there are 8 cases 
                    // the queen wants to go down right (as we look at the board)
                    while(t!=1 && pos.x+i < settings.BOARD_SIZE && pos.y+i < settings.BOARD_SIZE){
                            if(map[pos.x+i].charAt(pos.y+i)==settings.FREE_CHELL){ 
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+i,pos.y+i)));
                                i=i+1;
                            }
                            else { 
                                if(Character.isLowerCase(map[pos.x+i].charAt(pos.y + i))){
                                    list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+i,pos.y+i)));
                                }
                                t=1;
                            }
                   }    
                   
                    
                    t = 0;
                    i = 1;
                    // the queen wants to go down left (as we look at the board)
                    while(t!=1 && pos.x+i < settings.BOARD_SIZE && pos.y-i > 0){
                            if(map[pos.x+i].charAt(pos.y-i)==settings.FREE_CHELL){ 
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+i,pos.y-i)));
                                i=i+1;
                            }
                            else { 
                                if(Character.isLowerCase(map[pos.x+i].charAt(pos.y - i))){
                                    list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+i,pos.y-i)));
                                }
                                t=1;
                            }    
                    }
                    
                    t = 0;
                    i = 1;
                    // the queen wants to go up left (as we look at the board)
                    while(t!=1 && pos.x-i > 0 && pos.y-i > 0){
                            if(map[pos.x-i].charAt(pos.y-i)==settings.FREE_CHELL){ 
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-i,pos.y-i)));
                                i=i+1;
                            }
                            else { 
                                if(Character.isLowerCase(map[pos.x-i].charAt(pos.y - i))){ 
                                    list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-i,pos.y-i)));
                                }
                                t=1;
                            }    
                    }
                    
                    t = 0;
                    i = 1;
                    // the queen wants to go up right (as we look at the board)  
                    while(t!=1 && pos.x-i > 0 && pos.y+i < settings.BOARD_SIZE ){
                            if(map[pos.x-i].charAt(pos.y+i)==settings.FREE_CHELL){ 
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-i,pos.y+i)));
                                i=i+1;
                            }
                            else { 
                                if(Character.isLowerCase(map[pos.x-i].charAt(pos.y + i))){  
                                    list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-i,pos.y+i)));
                                }
                                t=1;
                            }    
                    }
                    
                    t = 0;
                    i = 1;
                    /*cazuri pe verticala/ orizontala */
                    t = 0;
                    i = 1;
            
                    // trying to move upwards
                    while(t!=1 && pos.x+i < settings.BOARD_SIZE){
            	
                    // it might need to check if map[pos.x+i][pos.y] == ' '
	            if(Character.isLowerCase(map[pos.x+i].charAt(pos.y))){
	                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+i,pos.y)));
	                t = 1;
	            }
	            else if ( map[pos.x+i].charAt(pos.y) == settings.FREE_CHELL ){
	                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+i,pos.y)));
	                i = i + 1;
	            }    
	            else 
	            	t = 1;
                    }
            
                    t=0;
                    i=1;
            
                     // trying to move downwards
                    while(t!=1 && pos.x-i >= 0){
                
                        if(Character.isLowerCase(map[pos.x-i].charAt(pos.y))){
                             list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-i,pos.y)));
                             t = 1;
                        }
                         else if ( map[pos.x-i].charAt(pos.y) == settings.FREE_CHELL ){
                             list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-i,pos.y)));
                             i = i + 1;
                        }
                        else
                            t = 1;
                    }
            
                t=0;
                i=1;
            
                // trying to move leftwards
                while(t!=1 && pos.y-i >= 0){
                
                     if(Character.isLowerCase(map[pos.x].charAt(pos.y-i))){
                         list.add(new move(new Point(pos.x, pos.y),new Point(pos.x,pos.y-i)));
                         t = 1;
                     }
                     else if ( map[pos.x].charAt(pos.y-i) == settings.FREE_CHELL ){
                        list.add(new move(new Point(pos.x, pos.y),new Point(pos.x,pos.y-i)));
                        i = i + 1;
                     }
                     else 
                            t = 1;
                     }   
            
                t=0;
                i=1;
            
                // trying to move rightwards
                while(t!=1 && pos.y+i < settings.BOARD_SIZE){
                
                    if(Character.isLowerCase(map[pos.x].charAt(pos.y + i))){
                         list.add(new move(new Point(pos.x, pos.y),new Point(pos.x,pos.y + i)));
                         t = 1;
                    }
                    else if ( map[pos.x].charAt(pos.y + i) == settings.FREE_CHELL ){ 
                          list.add(new move(new Point(pos.x, pos.y),new Point(pos.x,pos.y + i)));
                          i = i + 1;
                    }
                    else 
                            t = 1;
                }
                    
            }
                //black pieces
                if(piece == 'q'){
                    t = 0;
                    i = 1;
                    // there are eight cases
                    // the queen wants to go down right (as we look at the board)
                    while(t!=1 && pos.x+i < settings.BOARD_SIZE && pos.y+i < settings.BOARD_SIZE){
                            if(map[pos.x+i].charAt(pos.y+i)==settings.FREE_CHELL){ 
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+i,pos.y+i)));
                                i=i+1;
                            }
                            else { 
                                if(Character.isUpperCase(map[pos.x+i].charAt(pos.y + i))){  
                                    list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+i,pos.y+i)));
                                }
                                t=1;
                            }    
                    }
                    
                    t = 0;
                    i = 1;
                    // the queen wants to go down left (as we look at the board) 
                    while(t!=1 && pos.x+i < settings.BOARD_SIZE && pos.y-i > 0){
                            if(map[pos.x+i].charAt(pos.y-i)==settings.FREE_CHELL){ 
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+i,pos.y-i)));
                                i=i+1;
                            }
                            else { 
                                if(Character.isUpperCase(map[pos.x+i].charAt(pos.y - i))){
                                    list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+i,pos.y-i)));
                                }
                                t=1;
                            }    
                    }
                    
                    t = 0;
                    i = 1;
                    // the queen wants to go up left (as we look at the board) 
                    while(t!=1 && pos.x-i > 0 && pos.y-i > 0){
                            if(map[pos.x-i].charAt(pos.y-i)==settings.FREE_CHELL){ 
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-i,pos.y-i)));
                                i=i+1;
                            }
                            else { 
                                if(Character.isUpperCase(map[pos.x-i].charAt(pos.y - i))){
                                    list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-i,pos.y-i)));
                                }
                                t=1;
                            }    
                    }
                    
                    t = 0;
                    i = 1;
                    // the queen wants to go up right (as we look at the board) 
                    while(t!=1 && pos.x-i > 0 && pos.y+i < settings.BOARD_SIZE ){
                            if(map[pos.x-i].charAt(pos.y+i)==settings.FREE_CHELL){ 
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-i,pos.y+i)));
                                i=i+1;
                            }
                            else {
                                if(Character.isUpperCase(map[pos.x-i].charAt(pos.y + i))){
                                    list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-i,pos.y+i)));
                                }
                                t=1;
                            }    
                    }
                    
                    t = 0;
                    i = 1;
                    
                    /*cazuri pe verticala/ orizontala */
                   
                    // trying to move downwards ( change of perspective )
                    while(t!=1 && pos.x+i < settings.BOARD_SIZE){
            	
                        if(Character.isUpperCase(map[pos.x+i].charAt(pos.y))) {
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+i,pos.y)));
                                t = 1;
                        }
                        else if ( map[pos.x+i].charAt(pos.y) == settings.FREE_CHELL ){ 
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+i,pos.y)));
                                i = i + 1;
                        } else 
                                t = 1;
                    }
            
                    t=0;
                    i=1;
            
                    // trying to move upwards ( change of perspective )
                    while(t!=1 && pos.x-i >= 0){
                
                        if(Character.isUpperCase(map[pos.x-i].charAt(pos.y))){ 
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-i,pos.y)));
                                t = 1;
                        }
                        else if ( map[pos.x-i].charAt(pos.y) == settings.FREE_CHELL ) {
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-i,pos.y)));
                                i = i + 1;
                        }
                        else
                                t = 1;
                    }
            
                    t=0;
                    i=1;
            
                    // trying to move rightwards ( change of perspective )
                    while(t!=1 && pos.y-i >= 0){
                
                        if(Character.isUpperCase(map[pos.x].charAt(pos.y-i))){ 
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x,pos.y-i)));
                                t = 1;
                        }
                        else if ( map[pos.x].charAt(pos.y-i) == settings.FREE_CHELL ){
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x,pos.y-i)));
                                i = i + 1;
                        }
                        else
                                t = 1;
                    }
            
                    t=0;
                    i=1;
            
                    // trying to move leftwards ( change of perspective )
                    while(t!=1 && pos.y + i < settings.BOARD_SIZE){
                
                        if(Character.isUpperCase(map[pos.x].charAt(pos.y + i))){
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x,pos.y + i)));
                                t = 1;
                        }
                        else if ( map[pos.x].charAt(pos.y + i) == settings.FREE_CHELL ){
                                list.add(new move(new Point(pos.x, pos.y),new Point(pos.x,pos.y + i)));
                                i = i + 1;
                        }
                        else
                                t = 1;
                        }
                }  
                
		return list;
	}

	// returns a list of valid moves for a king in position pos

	public static ArrayList<move> getKingMoves( String [] map , boolean [][] moved, Point pos ) {
		// TODO
                ArrayList<move> list = new ArrayList<move>();
                char piece = map[pos.x].charAt(pos.y);
                //white pieces
                if(piece == 'K'){
                	
                    //wants to go down left( as we look at the board)
                    if(pos.x+1 < settings.BOARD_SIZE && pos.y-1 >=0 && !(Character.isUpperCase(map[pos.x+1].charAt(pos.y -1)))){
                        list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+1,pos.y-1)));
                    }
                    //wants to go down ( as we look at the board)
                    if(pos.x+1 < settings.BOARD_SIZE && !(Character.isUpperCase(map[pos.x+1].charAt(pos.y)))){
                        //adaug pozitia pos.x+1 pos.y la mutari
                        list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+1,pos.y)));
                    }
                    //wants to go down right( as we look at the board)
                    if(pos.x+1 < settings.BOARD_SIZE && pos.y+1 < settings.BOARD_SIZE && !(Character.isUpperCase(map[pos.x+1].charAt(pos.y +1)))){
                        //adaug pozitia pos.x+1 pos.y+1 la mutari
                        list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+1,pos.y+1)));
                    }
                    //wants to go right( as we look at the board)
                    if(pos.y+1 < settings.BOARD_SIZE && !(Character.isUpperCase(map[pos.x].charAt(pos.y +1)))){
                        //adaug pozitia pos.x pos.y+1 la mutari
                        list.add(new move(new Point(pos.x, pos.y),new Point(pos.x,pos.y+1)));
                    }
                    //wants to go up right( as we look at the board)
                    if(pos.x-1 >= 0 && pos.y+1 < settings.BOARD_SIZE && !(Character.isUpperCase(map[pos.x-1].charAt(pos.y+1)))){
                        //adaug pozitia pos.x-1 pos.y+1 la mutari
                        list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-1,pos.y+1)));
                    }
                    //wants to go up( as we look at the board)
                    if(pos.x-1 >= 0 && !(Character.isUpperCase(map[pos.x-1].charAt(pos.y)))){
                        //adaug pozitia pos.x-1 pos.y la mutari
                        list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-1,pos.y)));
                    }
                    //wants to go up left( as we look at the board)
                    if(pos.x-1 >= 0 && pos.y-1 >= 0 && !(Character.isUpperCase(map[pos.x-1].charAt(pos.y -1)))){
                        //adaug poz pos.x-1 pos.y-1 la mutari
                        list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-1,pos.y-1))); 
                    }
                    //wants to go left( as we look at the board)
                    if(pos.y-1 >=0 && !(Character.isUpperCase(map[pos.x].charAt(pos.y -1)))){
                        //adaug pozitia pos.x pos.y-1 la mutari
                        list.add(new move(new Point(pos.x, pos.y),new Point(pos.x,pos.y-1))); 
                    }
                }
                //black pieces
               if(piece == 'k'){
                    //wants to go down left( as we look at the board)
                    if(pos.x+1 < settings.BOARD_SIZE && pos.y-1 >=0 && !(Character.isUpperCase(map[pos.x+1].charAt(pos.y -1)))){
                        list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+1,pos.y-1)));
                    }
                     //wants to go down ( as we look at the board)
                    if(pos.x+1 < settings.BOARD_SIZE && !(Character.isUpperCase(map[pos.x+1].charAt(pos.y)))){
                        //adaug pozitia pos.x+1 pos.y la mutari
                        list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+1,pos.y)));
                    }
                    //wants to go down leftight( as we look at the board)
                    if(pos.x+1 < settings.BOARD_SIZE && pos.y+1 < settings.BOARD_SIZE && !(Character.isUpperCase(map[pos.x+1].charAt(pos.y+1)))){
                        //adaug pozitia pos.x+1 pos.y+1 la mutari
                        list.add(new move(new Point(pos.x, pos.y),new Point(pos.x+1,pos.y+1)));
                    }
                    //wants to go right( as we look at the board)
                    if(pos.y+1 < settings.BOARD_SIZE && !(Character.isUpperCase(map[pos.x].charAt(pos.y+1)))){
                        //adaug pozitia pos.x pos.y+1 la mutari
                        list.add(new move(new Point(pos.x, pos.y),new Point(pos.x,pos.y+1)));
                    }
                    //wants to go up right( as we look at the board)
                    if(pos.x-1 >= 0 && pos.y+1 < settings.BOARD_SIZE && !(Character.isUpperCase(map[pos.x-1].charAt(pos.y+1)))){
                        //adaug pozitia pos.x-1 pos.y+1 la mutari
                        list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-1,pos.y+1)));
                    }
                    //wants to go up( as we look at the board)
                    if(pos.x-1 >= 0 && !(Character.isUpperCase(map[pos.x-1].charAt(pos.y)))){
                        //adaug pozitia pos.x-1 pos.y la mutari
                        list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-1,pos.y)));
                    }
                    //wants to go up left( as we look at the board)
                    if(pos.x-1 >= 0 && pos.y-1 >= 0 && !(Character.isUpperCase(map[pos.x-1].charAt(pos.y -1)))){
                        //adaug poz pos.x-1 pos.y-1 la mutari
                        list.add(new move(new Point(pos.x, pos.y),new Point(pos.x-1,pos.y-1))); 
                    }
                    //wants to go left( as we look at the board)
                    if(pos.y-1 >=0 && !(Character.isUpperCase(map[pos.x].charAt(pos.y -1)))){
                        //adaug pozitia pos.x pos.y-1 la mutari
                        list.add(new move(new Point(pos.x, pos.y),new Point(pos.x,pos.y-1))); 
                    }
                }
		return list;
	}
}
