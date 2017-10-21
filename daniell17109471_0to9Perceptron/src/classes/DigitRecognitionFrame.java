package classes;
 


import java.awt.HeadlessException;
import java.util.Arrays;

import javax.swing.JFrame;

/**
 * @author delgadomatac
 *
 */



public class DigitRecognitionFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8688901065711771599L;
	/**
	 * 
	 */

	private javax.swing.JButton m_addNoiseButton;
	private javax.swing.JButton m_classifyButton;
	private javax.swing.JButton m_clearButton;
	private javax.swing.JButton m_trainButton;
	private javax.swing.JButton m_generateButton;
	private DigitRecognitionPanel m_outputPanel;
	private javax.swing.JPanel m_digitsPanel;

	private javax.swing.JPanel m_mainPanel;
	private DigitRecognitionPanel m_inputPanel;
	private javax.swing.JPanel m_toolbarPanel;
	private DigitRecognitionPanel [] digitPanels;
	
	public static final int NUM_DIGITS =10;
	/**
	 * @throws HeadlessException
	 */
	
    static final double[] ONE   = { 0,1,1,0,0,
        0,0,1,0,0,
        0,0,1,0,0,
        0,0,1,0,0,
        0,0,1,0,0,
        0,0,1,0,0,
        1,1,1,1,1 };
    static final double[] TWO   = { 0,1,1,1,0,
        1,0,0,0,1,
        0,0,0,1,0,
        0,0,1,0,0,
        0,1,0,0,0,
        1,0,0,0,0,
        1,1,1,1,1 };
    static final double[] THREE = { 0,1,1,1,0,
        1,0,0,0,1,
        0,0,0,0,1,
        0,0,1,1,0,
        0,0,0,0,1,
        1,0,0,0,1,
        0,1,1,1,0 };
    static final double[] FOUR  = { 0,0,1,1,0,
        0,1,0,1,0,
        0,1,0,1,0,
        1,0,0,1,0,
        1,1,1,1,1,
        0,0,0,1,0,
        0,0,0,1,0 };
    static final double[] FIVE  = { 1,1,1,1,1,
        1,0,0,0,0,
        1,1,1,1,0,
        0,0,0,0,1,
        0,0,0,0,1,
        1,0,0,0,1,
        0,1,1,1,0 };
   static final double[] SIX   = { 0,0,1,1,1,
        0,1,0,0,0,
        1,1,1,1,0,
        1,0,0,0,1,
        1,0,0,0,1,
        1,0,0,0,1,
        0,1,1,1,0 };
   static final double[] SEVEN = { 1,1,1,1,1,
        0,0,0,0,1,
        0,0,0,1,0,
        0,0,1,0,0,
        0,0,1,0,0,
        0,1,0,0,0,
        0,1,0,0,0 };
   static final double[] EIGHT = { 0,1,1,1,0,
        1,0,0,0,1,
        1,0,0,0,1,
        0,1,1,1,0,
        1,0,0,0,1,
        1,0,0,0,1,
        0,1,1,1,0 };
   static final double[] NINE  = { 0,1,1,1,0,
        1,0,0,0,1,
        1,0,0,0,1,
        0,1,1,1,1,
        0,0,0,0,1,
        0,0,0,1,0,
        0,1,1,0,0 };
   static final double[] ZERO  = { 0,1,1,1,0,
        1,0,0,0,1,
        1,0,0,0,1,
        1,0,0,0,1,
        1,0,0,0,1,
        1,0,0,0,1,
        0,1,1,1,0 };
   static final double[] ERROR  = { 
	   0,1,1,1,1,
       1,0,0,0,0,
       1,0,0,0,0,
       0,1,1,1,0,
       1,0,0,0,0,
       1,0,0,0,0,
       0,1,1,1,1 };
   static final public double[] [] DIGITS = 
     { ZERO, ONE, TWO,   THREE, FOUR, 
       FIVE, SIX, SEVEN, EIGHT, NINE };


	public DigitRecognitionFrame() throws HeadlessException {
		// TODO Auto-generated constructor stub
	}


	/**
	 * @param arg0
	 * @throws HeadlessException
	 */
	
	

	public DigitRecognitionFrame(String arg0) throws HeadlessException {
		super(arg0);
		// TODO Auto-generated constructor stub
		initComponents();
	}

	
	public void initComponents () {

        m_classifyButton = new javax.swing.JButton();
        m_clearButton = new javax.swing.JButton();
        m_addNoiseButton = new javax.swing.JButton();
        m_trainButton = new javax.swing.JButton();
        m_generateButton = new javax.swing.JButton();
        m_outputPanel = new DigitRecognitionPanel(DigitRecognitionPanel.NORMAL_SIZE);
        m_digitsPanel = new javax.swing.JPanel();

        m_mainPanel = new javax.swing.JPanel();
        m_inputPanel = new DigitRecognitionPanel(DigitRecognitionPanel.NORMAL_SIZE);
        m_toolbarPanel = new javax.swing.JPanel();
        
        digitPanels = new DigitRecognitionPanel [NUM_DIGITS];
        for (int k= 0; k< digitPanels.length; k++) {
        	digitPanels [k] = new DigitRecognitionPanel (DigitRecognitionPanel.THUMBNAIL_SIZE);
        	digitPanels [k].setDigit(DIGITS[k]);
        }
        
        m_digitsPanel.setPreferredSize(new java.awt.Dimension(200, 60));
        getContentPane().add(m_digitsPanel, java.awt.BorderLayout.SOUTH);
        
        m_mainPanel.setLayout(new java.awt.BorderLayout());

        m_inputPanel.setLayout(null);

        m_inputPanel.setPreferredSize(new java.awt.Dimension((5+1)*25,(7+1)*25));
        m_mainPanel.add(m_inputPanel, java.awt.BorderLayout.WEST);

        m_toolbarPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 10));

        m_toolbarPanel.setMinimumSize(new java.awt.Dimension(100, 500));
        m_toolbarPanel.setPreferredSize(new java.awt.Dimension(100, 300));        


        m_generateButton.setText("Generate");
        m_generateButton.setMaximumSize(new java.awt.Dimension(85, 23));
        m_generateButton.setPreferredSize(new java.awt.Dimension(85, 23));
        m_generateButton.setMargin(new java.awt.Insets(2, 10, 2, 10));
        m_generateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateButtonActionPerformed(evt);
            }
        });        
        m_toolbarPanel.add(m_generateButton);
        m_trainButton.setText("Train");
        m_trainButton.setMaximumSize(new java.awt.Dimension(85, 23));
        m_trainButton.setPreferredSize(new java.awt.Dimension(85, 23));
        m_trainButton.setMargin(new java.awt.Insets(2, 10, 2, 10));
        m_trainButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trainButtonActionPerformed(evt);
            }
        });
        m_toolbarPanel.add(m_trainButton);
        
      
        m_classifyButton.setText("Classify");
        m_classifyButton.setMargin(new java.awt.Insets(2, 10, 2, 10));
        m_classifyButton.setPreferredSize(new java.awt.Dimension(85, 23));
        m_classifyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classifyButtonActionPerformed(evt);
            }
        });

        m_toolbarPanel.add(m_classifyButton);

        m_addNoiseButton.setText("Add Noise");
        m_addNoiseButton.setMargin(new java.awt.Insets(2, 10, 2, 10));
        m_addNoiseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNoiseButtonActionPerformed(evt);
            }
        });
        m_toolbarPanel.add(m_addNoiseButton);           
        
        m_clearButton.setText("Clear");
        m_clearButton.setMaximumSize(new java.awt.Dimension(85, 23));
        m_clearButton.setPreferredSize(new java.awt.Dimension(85, 23));
        m_clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        m_toolbarPanel.add(m_clearButton);

     

        
        // The digit Panels
        for (int k= 0; k< digitPanels.length; k++) {
            digitPanels[k].setLayout(null);

            digitPanels[k].setPreferredSize(new java.awt.Dimension(35,50));
            digitPanels[k].addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    digitsPanelMouseClicked(evt);
                }
            });

            m_digitsPanel.add(digitPanels[k]);
        }
        
        


        m_mainPanel.add(m_toolbarPanel, java.awt.BorderLayout.CENTER);        
        


        m_outputPanel.setLayout(new java.awt.BorderLayout());

        m_outputPanel.setPreferredSize(new java.awt.Dimension((5+1)*25,(7+1)*25));
        m_mainPanel.add(m_outputPanel, java.awt.BorderLayout.EAST);

        getContentPane().add(m_mainPanel, java.awt.BorderLayout.CENTER);

        pack();        
	}

    

    public static double[] learn(double[][] training){
		double learningrate = 0.2;
		double[] weightsa = new double[training[0].length+1];
		for(int k = 0; k<weightsa.length; k++){
			weightsa[k] = 0;
		}
		double threshinput = -1.0;
		int iterations = 0;
		while(test(training, weightsa)!=true){
			if(iterations>3000){
				break;
			}
			for(int k = 0; k<training.length; k++){
				while(1==1){
					int output;
					double product = weightsa[weightsa.length-1]*-1;
					for(int i = 0; i<weightsa.length-1; i++){//repeats for each point of training data
						product+= weightsa[i]*training[k][i];
					}
					if(product>0){
						output = 1;
					}
					else{
						output = 0;
					}
					if(output == training[k][training[0].length-1]){
						break;
					}
					for(int i = 0; i<training[0].length-2; i++){
						weightsa[i] = weightsa[i] + learningrate*(training[k][training[0].length-1]-output)*training[k][i];
					}
					
					double temp =  weightsa[training[0].length-1] + learningrate*(training[k][training[0].length-1]-output)*threshinput;
					weightsa[training[0].length-1] = temp;
					
				}
			}
			iterations++;
		}
		return weightsa;
		
	}
    private static boolean test(double[][] test, double[] weights)
	{
    	if(weights.length-1 != test[0].length){
			javax.swing.JOptionPane.showMessageDialog(null, "invalid test or weight array");
		}
    	for(int k = 0; k<test.length; k++){//repeats for each set of training data
			int temp = 0;
			double product = weights[weights.length-1]*-1;
			for(int i = 0; i<weights.length-1; i++){//repeats for each point of training data
				product+= weights[i]*test[k][i];
			}
			if(product>0){
				temp = 1;
			}
			if(temp!= test[k][test[0].length-1]){
				return false;
			}
		}
		return true;
	}
    
    double[][] training = new double[DIGITS.length*30][DIGITS[0].length+1];
    
    private void generateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classifyButtonActionPerformed
    	   weights = new double[DIGITS.length][DIGITS.length+1];
    	generated = true;
    	for(int k = 0; k<DIGITS.length; k++){
    		for(int i = 0; i<DIGITS[0].length; i++){
    			training[k*30][i]=DIGITS[k][i];
        		training[k*30][DIGITS[0].length] = 0;
    		}
    		double[] prev = training[k*30];
    		for(int i = 1; i<30; i++){
    			
    			m_inputPanel.setDigit(DIGITS[k]);
    			for(int r = (int)(Math.random()*3+1); r>0; r--){
        			m_inputPanel.addNoise(0.1);
    			}
    			prev = m_inputPanel.getDigit().clone();
    			training[k*30+i] = copy(prev, training[k*30+i]);
    			//training[k*30+i] = prev.clone();
        		training[k*30+i][training[0].length-1] = 0;
    		}
    	}
    	m_inputPanel.setDigit(d);
    	clearButtonActionPerformed(evt);
    	//print2DA(training);
    }
    
    double[] d = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    
    private static double[] copy(double[] from, double[] to){
    	double[] a = new double[to.length];
    	for(int k = 0; k<from.length; k++){
    		a[k] = from[k];
    	}
    	return a;
    }
    private void print2DA(double [][] d){
    	for(int k = 0; k<d.length; k++){
    		System.out.println(Arrays.toString(d[k]));
    	}
    }
    private void trainButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNoiseButtonActionPerformed
	 
		if(generated == false){
			javax.swing.JOptionPane.showMessageDialog(null, "No training data generated");
		}else{
	    	for(int k = 0; k<DIGITS.length; k++){
	        	double[][] temptraining = duplicate(training);
	        	for(int i = 0; i<30; i++){
		        	temptraining[k*30+i][training[0].length-1] = 1;
	        	}
	        	//print2DA(temptraining);
	        	weights[k] = learn(temptraining);
	        }
		}
	}


	private void classifyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classifyButtonActionPerformed

    	int perc = -1;
    	double[] testing = m_inputPanel.getDigit();
    	int suitable = 0;
        for(int k=0; k<weights.length; k++){
        	double product = weights[k][weights[0].length-1]*-1;
			for(int i = 0; i<weights[k].length-2; i++){//repeats for each point of training data
				product+= weights[k][i]*testing[i];
			}
			if(product>0){
				perc = k;
				suitable++;
			}
        }
        if(suitable>1){
        	m_outputPanel.setDigit(ERROR);
        }else{
	        switch(perc){
	        case -1:
	        	m_outputPanel.setDigit(ERROR);
	        	break;
	        case 0:
	        	m_outputPanel.setDigit(ZERO);
	        	break;
	        case 1:
	        	m_outputPanel.setDigit(ONE);
	        	break;
	        case 2:
	        	m_outputPanel.setDigit(TWO);
	        	break;
	        case 3:
	        	m_outputPanel.setDigit(THREE);
	        	break;
	        case 4:
	        	m_outputPanel.setDigit(FOUR);
	        	break;
	        case 5:
	        	m_outputPanel.setDigit(FIVE);
	        	break;
	        case 6:
	        	m_outputPanel.setDigit(SIX);
	        	break;
	        case 7:
	        	m_outputPanel.setDigit(SEVEN);
	        	break;
	        case 8:
	        	m_outputPanel.setDigit(EIGHT);
	        	break;
	        case 9:
	        	m_outputPanel.setDigit(NINE);
	        	break;
	        }
        }
    	
    	m_outputPanel.repaint();
    }

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        m_inputPanel.clear();
        m_inputPanel.repaint();
        m_outputPanel.clear();
        m_outputPanel.repaint();
    }

    private void addNoiseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNoiseButtonActionPerformed
	    m_inputPanel.addNoise(0.10);
	    m_inputPanel.repaint();
	}

	double[][] weights = new double[DIGITS.length][DIGITS.length+1];

    private boolean generated = false;
    public static double[][] duplicate(double[][] array){
    	double[][] duplicated = new double[array.length][array[0].length];
    	for(int k = 0; k<array.length; k++)
    		duplicated[k] = array[k].clone();
    	return duplicated;
    }
    
    private void digitsPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_templateMouseClicked
        DigitRecognitionPanel src = (DigitRecognitionPanel)evt.getSource();

	    m_inputPanel.setDigit(src.getDigit());
        m_inputPanel.repaint();
    }
}
