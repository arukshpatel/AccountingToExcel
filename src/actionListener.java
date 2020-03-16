import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JCheckBox;

@SuppressWarnings("serial")
public class actionListener extends Graphics {
	Chooser fileHandler = new Chooser();

	btnChooseFolder.addActionListener(new ActionListener(){

	public void actionPerformed(ActionEvent e) {

		txtFolderPath.setText(fileHandler.FileExplorer());

		mntmUploadFolder.setText("Choose Another Folder");

		btnPath.setVisible(true);
		menuBar.setVisible(true);
		tabbedPane.setVisible(true);
		btnChooseFolder.setBounds(10, 11, 101, 46);

		checkboxArray = new ArrayList<>();

		int x_coordinate = 0;
		int y_coordinate = 0;
		int width = 97;
		int height = 23;

		try {
			for (int i = 0; i < fileHandler.getFilesInFolderString().length; i++) {
				if (!(fileHandler.getFilesInFolderString()[i]).contains("~")) {

					txtrFilesList.append("\n" + fileHandler.getFilesInFolderString()[i]);
					chckbx = new JCheckBox(fileHandler.getFilesInFolderString()[i]);

					if (i == 0) {
						chckbx.setBounds(x_coordinate, y_coordinate, width, height);
					} else if (i >= 1) {
						y_coordinate = y_coordinate + height;
						chckbx.setBounds(x_coordinate, y_coordinate, width, height);
					}
					CheckboxPanel.add(chckbx);
					checkboxArray.add(chckbx);
				}
			}
		} catch (Exception e1) {
			txtrPathFailure.setText("Please select a folder, NOT a file");
		}
		addActionListerer();
	}

	public void addActionListerer()
        {
            for (JCheckBox cb : checkboxArray)
            {
                cb.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        String exactFilePath = fileHandler.chooser.getSelectedFile().getPath() + "\\"
                                + cb.getText();

                        FileChecker fc = new FileChecker();

                        if (cb.isSelected())
                        {

                            fc.setFilePath(exactFilePath);

                            if (fc.PDFdoesExists())
                            {
                            	txtrPathFailure.setText("You selected a pdf file: " + cb.getText());
                            	txtrSelectedFiles.append(cb.getText() + "\n");

                                fc.check();

                            } else if (fc.PDFdoesExists() == false)
                            {
                            	txtrPathFailure.setText("Please select a pdf file");
                            }

                        }

                    }

                });
            }
        }
    });

    btnPath.addMouseListener(new MouseAdapter()
    {

	@Override
	public void mousePressed(MouseEvent e) {
		txtFolderPath.setVisible(true);
	}

	@Override
        public void mouseReleased(MouseEvent e)
        {
        	txtFolderPath.setVisible(false);
        }
    });

    mntmUploadFolder.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {

        	txtFolderPath.setText(fileHandler.FileExplorer());

        	mntmUploadFolder.setText("Choose Another Folder");
        }
    });

    mntmExit.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
            dispose();
            System.exit(ABORT);
        }
    });


}