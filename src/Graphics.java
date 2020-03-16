
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class Graphics extends JFrame
{

    public JMenuBar menuBar;
    public JMenu mnFile;
    public JMenuItem mntmUploadFolder;
    public JMenuItem mntmExit;
    public JTabbedPane tabbedPane;
    public JPanel tab1;
    public JTextField txtPleaseSelectFiles;
    public JTextArea txtrFilesList;
    public JScrollPane filesListScroll;
    public JPanel CheckboxPanel;
    public JScrollPane checkboxScroll;
    public JTextField txtFilesList;
    public JTextArea txtrSelectedFiles;
    public JScrollPane scrollPane;
    public JTextField txtSelectedFiles;
    public JTextArea txtrPathFailure;
    public JTextField txtExcelFiles;
    public JTextArea txtrExcelFiles;
    public JScrollPane excelFilesScroll;
    public JPanel tab2;
    public JToggleButton btnPath;
    public JButton btnChooseFolder;
    public JTextField txtFolderPath;

    public Graphics()
    {
    	System.out.print("Opening main frame");
        /**
         * Main Frame
         */
        getContentPane().setBackground(new Color(255, 255, 255));
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 600);
        setUndecorated(false);

        /**
         * Menu Bar
         */
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(new Color(192, 192, 192));
        setJMenuBar(menuBar);
        menuBar.setVisible(false);

        /**
         * File button on Menu Bar
         */
        JMenu mnFile = new JMenu("File");
        mnFile.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        menuBar.add(mnFile);

        /**
         * Upload button in File Button on Menu Bar
         */
        JMenuItem mntmUploadFolder = new JMenuItem("Upload Folder");
        mntmUploadFolder.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mnFile.add(mntmUploadFolder);

        /**
         * Exit button in File Button on Menu Bar
         */
        JMenuItem mntmExit = new JMenuItem("Exit");
        mntmExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mnFile.add(mntmExit);


        /**
         * Panel with tabs that consists everything
         */
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(0, 67, 884, 473);
        getContentPane().add(tabbedPane);
        tabbedPane.setVisible(false);

        /**
         * First tab
         */
        JPanel tab1 = new JPanel();
        tabbedPane.addTab("Files", null, tab1, null);
        tab1.setLayout(null);

        /**
         * Text Field stating to select files
         */
        JTextField txtPleaseSelectFiles = new JTextField();
        txtPleaseSelectFiles.setBounds(253, 1, 308, 20);
        tab1.add(txtPleaseSelectFiles);
        txtPleaseSelectFiles.setFont(new Font("Tahoma", Font.BOLD, 12));
        txtPleaseSelectFiles.setBorder(null);
        txtPleaseSelectFiles.setEditable(false);
        txtPleaseSelectFiles.setText("Select files the .PDF files you want to compute:");
        txtPleaseSelectFiles.setColumns(10);

        /**
         * Text area with the list of all the files in the directory
         */
        JTextArea txtrFilesList = new JTextArea();
        txtrFilesList.setFont(new Font("Tahoma", Font.PLAIN, 12));
        txtrFilesList.setLineWrap(true);
        txtrFilesList.setWrapStyleWord(true);
        txtrFilesList.setEditable(false);
        txtrFilesList.setBackground(txtPleaseSelectFiles.getBackground());

        /**
         * Scroll bar for the txtrFilesList
         */
        JScrollPane filesListScroll = new JScrollPane(txtrFilesList);
        filesListScroll.setBounds(10, 32, 233, 375);
        tab1.add(filesListScroll);

        /**
         * Panel that contains all the checkbox's
         */
        JPanel CheckboxPanel = new JPanel();
        CheckboxPanel.setBorder(null);

        /**
         * Scroll bar for the CheckboxPanel
         */
        JScrollPane checkboxScroll = new JScrollPane(CheckboxPanel);
        CheckboxPanel.setLayout(new GridLayout(0, 1, 0, 0));
        checkboxScroll.setBounds(253, 32, 308, 375);
        tab1.add(checkboxScroll);

        /**
         * Area where files will be listed
         */
        JTextField txtFilesList = new JTextField();
        txtFilesList.setBorder(null);
        txtFilesList.setFont(new Font("Tahoma", Font.BOLD, 12));
        txtFilesList.setEditable(false);
        txtFilesList.setText("Files List:");
        txtFilesList.setBounds(10, 1, 233, 20);
        tab1.add(txtFilesList);
        txtFilesList.setColumns(10);

        /**
         * Area where selected files are listed
         */
        JTextArea txtrSelectedFiles = new JTextArea();
        txtrSelectedFiles.setFont(new Font("Tahoma", Font.PLAIN, 12));
        txtrSelectedFiles.setLineWrap(true);
        txtrSelectedFiles.setWrapStyleWord(true);
        txtrSelectedFiles.setEditable(false);
        txtrSelectedFiles.setBackground(txtPleaseSelectFiles.getBackground());

        /**
         * Scroll panel were for selected files
         */
        JScrollPane scrollPane = new JScrollPane(txtrSelectedFiles);
        scrollPane.setBounds(571, 32, 298, 167);
        tab1.add(scrollPane);

        /**
         * Selected Files Text area
         */
        JTextField txtSelectedFiles = new JTextField();
        txtSelectedFiles.setText("Theser are the files you've selected:");
        txtSelectedFiles.setFont(new Font("Tahoma", Font.BOLD, 12));
        txtSelectedFiles.setEditable(false);
        txtSelectedFiles.setColumns(10);
        txtSelectedFiles.setBorder(null);
        txtSelectedFiles.setBounds(571, 1, 298, 20);
        tab1.add(txtSelectedFiles);

        /**
         * Checks if path is available and if not, it notifies
         */
        JTextArea txtrPathFailure = new JTextArea();
        txtrPathFailure.setText("");
        txtrPathFailure.setWrapStyleWord(true);
        txtrPathFailure.setLineWrap(true);
        txtrPathFailure.setForeground(Color.RED);
        txtrPathFailure.setBackground(txtPleaseSelectFiles.getBackground());
        txtrPathFailure.setFont(new Font("Tahoma", Font.PLAIN, 12));
        txtrPathFailure.setBounds(10, 412, 859, 22);
        txtrPathFailure.setEditable(false);
//        txtrPathFailure.setVisible(false);
        tab1.add(txtrPathFailure);

        /**
         * Excel File Title
         */
        JTextField txtExcelFiles = new JTextField();
        txtExcelFiles.setText("These are the Excel files that were created:");
        txtExcelFiles.setBounds(571, 210, 298, 20);
        txtExcelFiles.setBackground(txtPleaseSelectFiles.getBackground());
        txtExcelFiles.setFont(new Font("Tahoma", Font.BOLD, 12));
        txtExcelFiles.setEditable(false);
        txtExcelFiles.setVisible(false);
        tab1.add(txtExcelFiles);
        txtExcelFiles.setColumns(10);

        JTextArea txtrExcelFiles = new JTextArea();
        txtrExcelFiles.setFont(new Font("Tahoma", Font.PLAIN, 12));
        txtrExcelFiles.setLineWrap(true);
        txtrExcelFiles.setWrapStyleWord(true);
        txtrExcelFiles.setEditable(false);
        txtrExcelFiles.setBackground(txtPleaseSelectFiles.getBackground());

        /**
         * Scroll bar that includes the excel files
         */
        JScrollPane excelFilesScroll = new JScrollPane(txtrExcelFiles);
        excelFilesScroll.setBounds(571, 241, 298, 167);
        tab1.add(excelFilesScroll);

        /**
         * Second Tab
         */
        JPanel tab2 = new JPanel();
        tabbedPane.addTab("New tab", null, tab2, null);
        tab2.setLayout(null);

        /**
         * Folder Path text box
         */
        JTextField txtFolderPath = new JTextField();
        txtFolderPath.setBorder(null);
        txtFolderPath.setBackground(Color.WHITE);
        txtFolderPath.setBounds(232, 24, 620, 20);
        txtFolderPath.setHorizontalAlignment(SwingConstants.CENTER);
        txtFolderPath.setSelectionColor(Color.WHITE);
        txtFolderPath.setEditable(false);
        txtFolderPath.setColumns(10);
        txtFolderPath.setVisible(false);
        getContentPane().add(txtFolderPath);

        /**
         * Button to show folder path
         */
        JToggleButton btnPath = new JToggleButton("Show Path");
        btnPath.setBounds(121, 11, 101, 46);
        btnPath.setVisible(false);
        getContentPane().add(btnPath);

        /**
         * Choose Folder button
         */
        JButton btnChooseFolder = new JButton("Choose Folder");
        btnChooseFolder.setBounds(297, 202, 289, 136);
        getContentPane().add(btnChooseFolder);
    }

}
