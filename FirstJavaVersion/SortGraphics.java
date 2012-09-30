import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

/*
 * Created on 18.04.2003
 *
 * To change this generated comment go to 
 * Window>Preferences>Java>Code Generation>Code Template
 */

/** Performs the graphics output of the sorting algorithm
 * 
 * @author rauch
 */
public class SortGraphics {
	
	public static SortCanvas canvas = new SortCanvas();
		
	SortGraphics(){
		
		JFrame frame = new JFrame("Sorting Algorithms");

		canvas.setForeground(Color.black);
		canvas.setBackground(Color.white);
		Sort.setPointNumber(300);  // calls init

		frame.getContentPane().add(canvas);
		frame.getContentPane().validate();
        
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
		frame.setSize(400,450);
        
		JMenuBar menubar = new JMenuBar();
        
		JMenu initMenu = new JMenu("Initialization");
        
		JMenuItem randomItem = new JMenuItem("Random");
		JMenuItem randomUniqueItem = new JMenuItem("Random, unique");
		JMenuItem backwardsItem = new JMenuItem("Sorted, decreasing");
		JMenuItem sortedItem = new JMenuItem("Sorted, increasing");
		JMenuItem reuseItem = new JMenuItem("Start over without init");
        
		initMenu.add(randomItem);
		initMenu.add(randomUniqueItem);
		initMenu.add(backwardsItem);
		initMenu.add(sortedItem);
		initMenu.add(new JSeparator());
		initMenu.add(reuseItem);
		
		randomItem.addActionListener(new ActionListener() {
		   public void actionPerformed(ActionEvent e) {
			Sort.initRandom(new Random().nextInt() );
			Dimension d = canvas.getSize();
			if( d == null ) return;
			canvas.repaint(0,0,d.width,d.height);
		   }
		});
		randomUniqueItem.addActionListener(new ActionListener() {
		   public void actionPerformed(ActionEvent e) {
			// TODO: initRandomUnique not implemented yet!!
			Sort.initRandom(new Random().nextInt() );
			Dimension d = canvas.getSize();
			if( d == null ) return;
			canvas.repaint(0,0,d.width,d.height);
		   }
		});
		backwardsItem.addActionListener(new ActionListener() {
		   public void actionPerformed(ActionEvent e) {
			Sort.initBackwards();
			Dimension d = canvas.getSize();
			if( d == null ) return;
			canvas.repaint(0,0,d.width,d.height);
		   }
		});
		sortedItem.addActionListener(new ActionListener() {
		   public void actionPerformed(ActionEvent e) {
			Sort.initSorted();
			Dimension d = canvas.getSize();
			if( d == null ) return;
			canvas.repaint(0,0,d.width,d.height);
		   }
		});
		reuseItem.addActionListener(new ActionListener() {
		   public void actionPerformed(ActionEvent e) {
			Sort.initOldNumbers();
			Dimension d = canvas.getSize();
			if( d == null ) return;
			canvas.repaint(0,0,d.width,d.height);
		   }
		});

		sortMenu = new JMenu("Sorting Algorithms");
		
		JMenuItem stopSort = new JMenuItem("Stop Sorting");
		sortMenu.add(stopSort);
		
		stopSort.addActionListener(new ActionListener() {
		   public void actionPerformed(ActionEvent e) {
			if( sortT == null ) return;
			sortT.stop();  // destroy the current thread
		   }
		});		

		sortMenu.add(new JSeparator());

		menubar.add(initMenu);
		menubar.add(sortMenu);
        
		frame.setJMenuBar(menubar);
        
		frame.pack();
		frame.setVisible(true);   

	}
		
	private JMenu sortMenu;
	
	protected SortThread sortT;
	
	public void addSort( String name, final SortingAlgorithm alg, 
						final SortArray work ){
		JMenuItem theSort = new JMenuItem(name);
		sortMenu.add(theSort);
		
		theSort.addActionListener(new ActionListener() {
		   public void actionPerformed(ActionEvent e) {
		   	sortT = new SortThread(alg, work, canvas);
		   	sortT.start();
		   }
		});		
	}
	
	public static void resetCanvas( SortArray s ){
		canvas.setPoints(s);

		canvas.reset();  // reset the compare and copy counters
	}
}

class SortThread extends Thread {
	SortingAlgorithm alg;
	SortArray work;
	SortCanvas canvas;
	
	SortThread( SortingAlgorithm a, SortArray w, SortCanvas c ){
		alg = a;
		work = w;
		canvas = c;
	}
	
	public void run(){
		alg.sort(work, canvas);
		canvas.paintNumbers();
	}
}		
