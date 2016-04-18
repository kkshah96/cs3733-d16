	package view;

	import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Palette;
import model.Piece;
import model.PieceFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

	public class PaletteView extends JPanel {
		static final int MAX_BOARD_SIZE = 12; // TODO: Should we define these elsewhere? 
		static final int SQUARE_SIZE = 10;
		static final int BUFFER_SIZE = 1;
		ArrayList<SquareView> squares = new ArrayList<SquareView>();
		
		Palette p = new Palette();
		
		/**
		 * Create the panel.
		 */
		public PaletteView() {
		//	setLayout();
			
			JLabel lblNewLabel = new JLabel("There should be a scrollbar here..");
			lblNewLabel.setBounds(10, 11, 436, 14);
			
			JLabel lblIfYouCan = new JLabel("If you can see this it works!");
			lblIfYouCan.setBounds(944, 11, 210, 14);
			
			JLabel lblBleh = new JLabel("Bleh");
			GroupLayout groupLayout = new GroupLayout(this);
			groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(30)
								.addComponent(lblNewLabel)
								.addGap(5)
								.addComponent(lblIfYouCan))
							.addComponent(lblBleh))
						.addContainerGap(111, Short.MAX_VALUE))
			);
			groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(5)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(lblNewLabel)
							.addComponent(lblIfYouCan))
						.addPreferredGap(ComponentPlacement.RELATED, 333, Short.MAX_VALUE)
						.addComponent(lblBleh)
						.addContainerGap())
			);
			setLayout(groupLayout);
			
			
			
		}
		
		public void paintComponent(Graphics g){
			PieceDrawer pDrawer = new PieceDrawer();
			
			for(int i = 0; i < 35; i++){
			//pDrawer.paint(g, piece, SQUARE_SIZE, HEIGHT_OFFSET, WIDTH_OFFSET);
				pDrawer.paint(g, p.getPiece(i), SQUARE_SIZE, 60, 10);
			}
		}
		
		private void initialize(){
			//JLabel lblBoard = new JLabel("Bullpen");
			//lblBoard.setFont(new Font("PT Sans Caption", Font.BOLD, 17));
			//lblBoard.setForeground(Color.BLACK);
		//	lblBoard.setBounds(201, 5, 100, 23);
			
		//	int count = 0;
			/*for(int i = 0; i < MAX_BOARD_SIZE * SQUARE_SIZE; i+= SQUARE_SIZE){
				for(int j = 0; j < MAX_BOARD_SIZE * SQUARE_SIZE; j+= SQUARE_SIZE){
					squares.add(new SquareView(SQUARE_SIZE));
					squares.get(count).setBounds(i + 10, j + 30, SQUARE_SIZE + BUFFER_SIZE, SQUARE_SIZE + BUFFER_SIZE);
					add(squares.get(count));
					count++;
				}
			}*/
			
			//setLayout(null);
			//add(lblBoard);
		}
	}



