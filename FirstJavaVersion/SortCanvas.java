
import java.awt.*;


public class SortCanvas extends Canvas {

    SortArray points = null;
    int xoffset = 10, yoffset = 50, textyoffset = 20;
    
    int copy, compare;
    
    public void IncCopy(){ 
    	copy++; 
    	//if( copy % 10 == 0 ) paintNumbers(); 
    }
	public void IncCompare(){ 
		compare++; 
		//if( compare % 10 == 0 ) paintNumbers(); 
	}
    
    public void reset(){
    	copy = 0;
    	compare = 0;
    }
    
    SortCanvas(){
    	reset();
    }

    // this performs the painting action of the canvas
    public void paint( Graphics g ) {

        Rectangle r = g.getClipBounds();
        if( r == null ){
            g.drawString( "Clipping rectangle is empty!", 
                          20 + xoffset, 20 + yoffset );
            return;
        }

        g.clearRect( r.x, r.y, r.width, r.height );

        g.setColor(Color.black);

        if( points == null ) {
            g.drawString( "Please call setPoints first!", xoffset, yoffset );
            return;
        }
        
        // redraw string       
		g.drawString(compare + " key comparisons        "
					 + copy + " copy operations", xoffset, textyoffset);

        // redraw points
        int x, y;
        for( int i = 1; i < points.length(); i++ ){
        	x = i + xoffset;
        	y = points.getValueOnly(i) + yoffset;
//            g.drawLine( x, y, x + 0, y + 0 );
			g.fillOval(x,y,1,1);
        }

    }
    
    public void clearWindow() {
		Graphics g = getGraphics();
		if( g == null ) return;  // canvas currently not displayable

    	Dimension d = getSize();
    	if( d == null ) return;

		g.setColor( Color.white );
    	g.fillRect( 0, 0, d.width, d.height );
    }
    
	// was: DisplayNumbers
    public void paintNumbers(){
		Graphics g = getGraphics();
		if( g == null ) return;  // canvas currently not displayable

		g.clearRect( 0, 0, 400, textyoffset + 5 );

		g.drawString(compare + " key comparisons        "
					 + copy + " copy operations", xoffset, textyoffset);
    }
    
    public void paintOne( int px, int py, Color c ){
    	Graphics g = getGraphics();
    	if( g == null ) return;  // canvas currently not displayable
    	g.setColor(c);
    	g.drawLine(px + xoffset, py + yoffset,
    			   px + 1 + xoffset, py + 1 + yoffset);
    }

    public void setPoints( SortArray p ){
        points = p;
    }
    
    	
    	

}
